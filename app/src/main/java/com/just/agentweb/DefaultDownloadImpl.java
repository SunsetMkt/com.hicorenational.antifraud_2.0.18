package com.just.agentweb;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.download.library.DownloadImpl;
import com.download.library.DownloadListenerAdapter;
import com.download.library.Extra;
import com.download.library.ResourceRequest;
import com.just.agentweb.ActionActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class DefaultDownloadImpl implements DownloadListener {
    private static final String TAG = DefaultDownloadImpl.class.getSimpleName();
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean isInstallDownloader;
    protected WeakReference<Activity> mActivityWeakReference;
    protected WeakReference<AbsAgentWebUIController> mAgentWebUIController;
    protected Context mContext;
    protected ConcurrentHashMap<String, ResourceRequest> mDownloadTasks = new ConcurrentHashMap<>();
    protected PermissionInterceptor mPermissionListener;

    protected DefaultDownloadImpl(Activity activity, WebView webView, PermissionInterceptor permissionInterceptor) {
        this.mActivityWeakReference = null;
        this.mPermissionListener = null;
        this.mContext = activity.getApplicationContext();
        this.mActivityWeakReference = new WeakReference<>(activity);
        this.mPermissionListener = permissionInterceptor;
        this.mAgentWebUIController = new WeakReference<>(AgentWebUtils.getAgentWebUIControllerByWebView(webView));
        try {
            DownloadImpl.getInstance().with(this.mContext);
            this.isInstallDownloader = true;
        } catch (Throwable th) {
            LogUtils.m8081e(TAG, "implementation 'com.download.library:Downloader:x.x.x'");
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
            this.isInstallDownloader = false;
        }
    }

    public static DefaultDownloadImpl create(@NonNull Activity activity, @NonNull WebView webView, @Nullable PermissionInterceptor permissionInterceptor) {
        return new DefaultDownloadImpl(activity, webView, permissionInterceptor);
    }

    protected List<String> checkNeedPermission() {
        ArrayList arrayList = new ArrayList();
        if (!AgentWebUtils.hasPermission(this.mActivityWeakReference.get(), AgentWebPermissions.STORAGE)) {
            arrayList.addAll(Arrays.asList(AgentWebPermissions.STORAGE));
        }
        return arrayList;
    }

    protected Handler.Callback createCallback(final String str) {
        return new Handler.Callback() { // from class: com.just.agentweb.DefaultDownloadImpl.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                DefaultDownloadImpl.this.forceDownload(str);
                return true;
            }
        };
    }

    protected ResourceRequest createResourceRequest(String str) {
        return DownloadImpl.getInstance().with(str).setEnableIndicator(true).autoOpenIgnoreMD5();
    }

    protected void forceDownload(String str) {
        this.mDownloadTasks.get(str).setForceDownload(true);
        performDownload(str);
    }

    protected ActionActivity.PermissionListener getPermissionListener(final String str) {
        return new ActionActivity.PermissionListener() { // from class: com.just.agentweb.DefaultDownloadImpl.2
            @Override // com.just.agentweb.ActionActivity.PermissionListener
            public void onRequestPermissionsResult(@NonNull String[] strArr, @NonNull int[] iArr, Bundle bundle) {
                if (DefaultDownloadImpl.this.checkNeedPermission().isEmpty()) {
                    DefaultDownloadImpl.this.preDownload(str);
                    return;
                }
                if (DefaultDownloadImpl.this.mAgentWebUIController.get() != null) {
                    DefaultDownloadImpl.this.mAgentWebUIController.get().onPermissionsDeny((String[]) DefaultDownloadImpl.this.checkNeedPermission().toArray(new String[0]), AgentWebPermissions.ACTION_STORAGE, "Download");
                }
                LogUtils.m8081e(DefaultDownloadImpl.TAG, "储存权限获取失败~");
            }
        };
    }

    protected boolean isForceRequest(String str) {
        ResourceRequest resourceRequest = this.mDownloadTasks.get(str);
        if (resourceRequest != null) {
            return resourceRequest.getDownloadTask().isForceDownload();
        }
        return false;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(final String str, final String str2, final String str3, final String str4, final long j2) {
        if (this.isInstallDownloader) {
            mHandler.post(new Runnable() { // from class: com.just.agentweb.DefaultDownloadImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    DefaultDownloadImpl.this.onDownloadStartInternal(str, str2, str3, str4, j2);
                }
            });
            return;
        }
        LogUtils.m8081e(TAG, "unable start download " + str + "; implementation 'com.download.library:Downloader:x.x.x'");
    }

    protected void onDownloadStartInternal(String str, String str2, String str3, String str4, long j2) {
        if (this.mActivityWeakReference.get() == null || this.mActivityWeakReference.get().isFinishing()) {
            return;
        }
        PermissionInterceptor permissionInterceptor = this.mPermissionListener;
        if (permissionInterceptor == null || !permissionInterceptor.intercept(str, AgentWebPermissions.STORAGE, "download")) {
            this.mDownloadTasks.put(str, createResourceRequest(str));
            if (Build.VERSION.SDK_INT < 23) {
                preDownload(str);
                return;
            }
            List<String> checkNeedPermission = checkNeedPermission();
            if (checkNeedPermission.isEmpty()) {
                preDownload(str);
                return;
            }
            Action createPermissionsAction = Action.createPermissionsAction((String[]) checkNeedPermission.toArray(new String[0]));
            ActionActivity.setPermissionListener(getPermissionListener(str));
            ActionActivity.start(this.mActivityWeakReference.get(), createPermissionsAction);
        }
    }

    protected void performDownload(String str) {
        try {
            LogUtils.m8081e(TAG, "performDownload:" + str + " exist:" + DownloadImpl.getInstance().exist(str));
            if (DownloadImpl.getInstance().exist(str)) {
                if (this.mAgentWebUIController.get() != null) {
                    this.mAgentWebUIController.get().onShowMessage(this.mActivityWeakReference.get().getString(C2605R.string.agentweb_download_task_has_been_exist), "preDownload");
                }
            } else {
                ResourceRequest resourceRequest = this.mDownloadTasks.get(str);
                resourceRequest.addHeader("Cookie", AgentWebConfig.getCookiesByUrl(str));
                taskEnqueue(resourceRequest);
            }
        } catch (Throwable th) {
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    protected void preDownload(String str) {
        if (isForceRequest(str) || AgentWebUtils.checkNetworkType(this.mContext) <= 1) {
            performDownload(str);
        } else {
            showDialog(str);
        }
    }

    protected void showDialog(String str) {
        AbsAgentWebUIController absAgentWebUIController;
        Activity activity = this.mActivityWeakReference.get();
        if (activity == null || activity.isFinishing() || (absAgentWebUIController = this.mAgentWebUIController.get()) == null) {
            return;
        }
        absAgentWebUIController.onForceDownloadAlert(str, createCallback(str));
    }

    protected void taskEnqueue(ResourceRequest resourceRequest) {
        resourceRequest.enqueue(new DownloadListenerAdapter() { // from class: com.just.agentweb.DefaultDownloadImpl.4
            public boolean onResult(Throwable th, Uri uri, String str, Extra extra) {
                DefaultDownloadImpl.this.mDownloadTasks.remove(str);
                return super.onResult(th, uri, str, extra);
            }
        });
    }
}
