package com.umeng.socialize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.handler.UMSSOHandler;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.utils.CommonUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UMShareAPI {

    /* renamed from: a */
    private static UMShareAPI f13448a = null;

    /* renamed from: b */
    private static boolean f13449b = true;
    public boolean isZyb = true;

    /* renamed from: a */
    private static Class<?> m12485a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static UMShareAPI get(Context context) {
        if (!m12487a(context) || CommonUtil.isSilentMode(context)) {
            f13448a = new C3628b(context);
            return f13448a;
        }
        if (f13448a == null) {
            f13448a = new C3614a(context);
            SLog.welcome();
        }
        return f13448a;
    }

    public static String getSdkVersion() {
        return "7.3.2";
    }

    public static boolean getSmartEnableFlag() {
        return f13449b;
    }

    public static void init(Context context, String str) {
        if (m12487a(context)) {
            SocializeConstants.APPKEY = str;
            get(context);
            UMWorkDispatch.sendEvent(context, SocializeConstants.REGIST_TO_WORK_QUEUE, CommonNetImpl.get(context), null);
        }
    }

    public static void setSmartEnable(boolean z) {
        f13449b = z;
    }

    public void deleteOauth(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f13448a.deleteOauth(activity, share_media, uMAuthListener);
    }

    @Deprecated
    public void doOauthVerify(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f13448a.doOauthVerify(activity, share_media, uMAuthListener);
    }

    public void doShare(Activity activity, ShareAction shareAction, UMShareListener uMShareListener) {
        f13448a.doShare(activity, shareAction, uMShareListener);
    }

    public void fetchAuthResultWithBundle(Activity activity, Bundle bundle, UMAuthListener uMAuthListener) {
        f13448a.fetchAuthResultWithBundle(activity, bundle, uMAuthListener);
    }

    public UMSSOHandler getHandler(SHARE_MEDIA share_media) {
        return f13448a.getHandler(share_media);
    }

    public void getPlatformInfo(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        f13448a.getPlatformInfo(activity, share_media, uMAuthListener);
    }

    public String getversion(Activity activity, SHARE_MEDIA share_media) {
        return f13448a.getversion(activity, share_media);
    }

    public boolean isAuthorize(Activity activity, SHARE_MEDIA share_media) {
        return f13448a.isAuthorize(activity, share_media);
    }

    public boolean isInstall(Activity activity, SHARE_MEDIA share_media) {
        return f13448a.isInstall(activity, share_media);
    }

    public boolean isSupport(Activity activity, SHARE_MEDIA share_media) {
        return f13448a.isSupport(activity, share_media);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        f13448a.onActivityResult(i2, i3, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        f13448a.onSaveInstanceState(bundle);
    }

    public void release() {
        f13448a.release();
    }

    public void setShareConfig(UMShareConfig uMShareConfig) {
        f13448a.setShareConfig(uMShareConfig);
    }

    /* renamed from: a */
    private static boolean m12486a() {
        try {
            Class<?> m12485a = m12485a("com.umeng.commonsdk.framework.UMEnvelopeBuild");
            if (m12485a != null) {
                return m12485a.getDeclaredMethod("buildEnvelopeWithExtHeader", Context.class, JSONObject.class, JSONObject.class, String.class, String.class, String.class) != null;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m12487a(final Context context) {
        if (m12486a()) {
            return true;
        }
        new Thread() { // from class: com.umeng.socialize.UMShareAPI.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Looper.prepare();
                    Toast.makeText(context.getApplicationContext(), UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH, 1).show();
                    Looper.loop();
                } catch (Throwable unused) {
                }
            }
        }.start();
        SLog.m12716E(UmengText.CHECK.DEPENDENT_COMMON_NOT_MATCH);
        return false;
    }
}
