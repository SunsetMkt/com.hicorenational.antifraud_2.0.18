package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.TDialog;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class AuthAgent extends BaseApi {
    public static final String KEY_FORCE_QR_LOGIN = "KEY_FORCE_QR_LOGIN";
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final int SECURE_LIB_VERSION = 5;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
    private IUiListener a;

    /* JADX INFO: renamed from: d */
    private String f6622d;

    /* JADX INFO: renamed from: e */
    private WeakReference<Activity> f6623e;

    /* JADX INFO: renamed from: com.tencent.connect.auth.AuthAgent$1 */
    /* JADX INFO: compiled from: ProGuard */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ IUiListener f6624b;

        /* JADX INFO: renamed from: com.tencent.connect.auth.AuthAgent$1$1 */
        /* JADX INFO: compiled from: ProGuard */
        class RunnableC01121 implements Runnable {
            final /* synthetic */ Activity a;

            RunnableC01121(Activity activity) {
                activity = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (JniInterface.isJniOk) {
                    Activity activity = activity;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity, "action_login", str, iUiListener, ((BaseApi) AuthAgent.this).f6711c);
                    if (activity.isFinishing()) {
                        return;
                    }
                    aVar.show();
                    return;
                }
                SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                Activity activity2 = activity;
                String strA = AuthAgent.this.a("");
                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                TDialog tDialog = new TDialog(activity2, "", strA, iUiListener, ((BaseApi) AuthAgent.this).f6711c);
                if (activity.isFinishing()) {
                    return;
                }
                tDialog.show();
            }
        }

        AnonymousClass1(String str, IUiListener iUiListener) {
            str = str;
            iUiListener = iUiListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
            JniInterface.loadSo();
            if (AuthAgent.this.f6623e == null || (activity = (Activity) AuthAgent.this.f6623e.get()) == null) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1
                final /* synthetic */ Activity a;

                RunnableC01121(Activity activity2) {
                    activity = activity2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (JniInterface.isJniOk) {
                        Activity activity2 = activity;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity2, "action_login", str, iUiListener, ((BaseApi) AuthAgent.this).f6711c);
                        if (activity.isFinishing()) {
                            return;
                        }
                        aVar.show();
                        return;
                    }
                    SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                    Activity activity22 = activity;
                    String strA = AuthAgent.this.a("");
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    TDialog tDialog = new TDialog(activity22, "", strA, iUiListener, ((BaseApi) AuthAgent.this).f6711c);
                    if (activity.isFinishing()) {
                        return;
                    }
                    tDialog.show();
                }
            });
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private class a extends DefaultUiListener {
        IUiListener a;

        public a(IUiListener iUiListener) {
            this.a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj == null) {
                SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i2 = jSONObject.getInt("ret");
                String string = i2 == 0 ? "success" : jSONObject.getString("msg");
                if (this.a != null) {
                    this.a.onComplete(new JSONObject().put("ret", i2).put("msg", string));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                SLog.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private class c extends DefaultUiListener {

        /* JADX INFO: renamed from: b */
        private final IUiListener f6640b;

        /* JADX INFO: renamed from: c */
        private final boolean f6641c;

        /* JADX INFO: renamed from: d */
        private final Context f6642d;

        public c(Context context, IUiListener iUiListener, boolean z, boolean z2) {
            this.f6642d = context;
            this.f6640b = iUiListener;
            this.f6641c = z;
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.f6640b.onCancel();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (string != null && ((BaseApi) AuthAgent.this).f6711c != null && string3 != null) {
                    ((BaseApi) AuthAgent.this).f6711c.setAccessToken(string, string2);
                    ((BaseApi) AuthAgent.this).f6711c.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.f6642d, ((BaseApi) AuthAgent.this).f6711c);
                }
                String string4 = jSONObject.getString("pf");
                if (string4 != null) {
                    try {
                        this.f6642d.getSharedPreferences(Constants.PREFERENCE_PF, 0).edit().putString("pf", string4).commit();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
                    }
                }
                if (this.f6641c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
                SLog.e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e3);
            }
            this.f6640b.onComplete(jSONObject);
            AuthAgent.this.releaseResource();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.f6640b.onError(uiError);
            SLog.release();
        }
    }

    static {
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
            return;
        }
        if (str.equalsIgnoreCase("arm64-v8a")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            SLog.i("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
            return;
        }
        if (str.equalsIgnoreCase("x86")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            SLog.i("openSDK_LOG.AuthAgent", "is x86 architecture");
            return;
        }
        if (str.equalsIgnoreCase("x86_64")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            SLog.i("openSDK_LOG.AuthAgent", "is x86_64 architecture");
            return;
        }
        SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        SLog.i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment, boolean z2, Map<String, Object> map) {
        if (com.tencent.connect.a.a("openSDK_LOG.AuthAgent", iUiListener)) {
            return -1;
        }
        this.f6622d = str;
        this.f6623e = new WeakReference<>(activity);
        this.a = iUiListener;
        Object[] objArr = new Object[2];
        boolean booleanExtra = activity.getIntent().getBooleanExtra(KEY_FORCE_QR_LOGIN, false);
        boolean zB = i.a(activity, this.f6711c.getAppId()).b("C_LoginWeb");
        SLog.i("openSDK_LOG.AuthAgent", "doLogin needForceQrLogin=" + booleanExtra + ", toWebLogin=" + zB);
        if (!booleanExtra && !zB && a(activity, fragment, map, z, objArr)) {
            SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            e.a().a(this.f6711c.getOpenId(), this.f6711c.getAppId(), "2", "1", "5", (String) objArr[0], "0", "0");
            return ((Integer) objArr[1]).intValue();
        }
        e.a().a(this.f6711c.getOpenId(), this.f6711c.getAppId(), "2", "1", "5", "1", "0", "0");
        SLog.w("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        this.a = new b(this.a);
        return a(z, this.a, z2, map);
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.a = null;
    }

    private String b(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        Object obj = map.get(Constants.KEY_ADD_LOGIN_ACCOUNT);
        return obj instanceof String ? ((String) obj).trim() : "";
    }

    int a(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment, boolean z2) {
        return doLogin(activity, str, iUiListener, z, fragment, z2, null);
    }

    private int a(boolean z, IUiListener iUiListener, boolean z2, Map<String, Object> map) {
        CookieSyncManager.createInstance(g.a());
        Bundle bundleA = a();
        if (z) {
            bundleA.putString("isadd", "1");
        }
        bundleA.putString(Constants.PARAM_SCOPE, this.f6622d);
        bundleA.putString(Constants.PARAM_CLIENT_ID, this.f6711c.getAppId());
        if (BaseApi.isOEM) {
            bundleA.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + DispatchConstants.ANDROID + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + BaseApi.registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + BaseApi.businessId);
        } else {
            bundleA.putString("pf", Constants.DEFAULT_PF);
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        bundleA.putString("sign", k.b(g.a(), str));
        bundleA.putString("time", str);
        bundleA.putString("display", "mobile");
        bundleA.putString("response_type", "token");
        bundleA.putString("redirect_uri", "auth://tauth.qq.com/");
        bundleA.putString("cancel_display", "1");
        bundleA.putString("switch", "1");
        bundleA.putString("compat_v", "1");
        if (z2) {
            bundleA.putString("style", "qr");
        }
        String strB = b(map);
        SLog.i("openSDK_LOG.AuthAgent", "OpenUI, showDialog addLoginAccount: " + strB);
        if (strB != null && !strB.isEmpty()) {
            bundleA.putString("uin", strB);
        }
        boolean zA = a(map);
        bundleA.putString("show_download_ui", Boolean.toString(zA));
        SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start, isShowDownloadUi=" + zA);
        String str2 = j.a().a(g.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(bundleA);
        c cVar = new c(g.a(), iUiListener, true, false);
        SLog.d("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        l.b(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1
            final /* synthetic */ String a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ IUiListener f6624b;

            /* JADX INFO: renamed from: com.tencent.connect.auth.AuthAgent$1$1 */
            /* JADX INFO: compiled from: ProGuard */
            class RunnableC01121 implements Runnable {
                final /* synthetic */ Activity a;

                RunnableC01121(Activity activity2) {
                    activity = activity2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (JniInterface.isJniOk) {
                        Activity activity2 = activity;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity2, "action_login", str, iUiListener, ((BaseApi) AuthAgent.this).f6711c);
                        if (activity.isFinishing()) {
                            return;
                        }
                        aVar.show();
                        return;
                    }
                    SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                    Activity activity22 = activity;
                    String strA = AuthAgent.this.a("");
                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                    TDialog tDialog = new TDialog(activity22, "", strA, iUiListener, ((BaseApi) AuthAgent.this).f6711c);
                    if (activity.isFinishing()) {
                        return;
                    }
                    tDialog.show();
                }
            }

            AnonymousClass1(String str22, IUiListener cVar2) {
                str = str22;
                iUiListener = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity2;
                k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                JniInterface.loadSo();
                if (AuthAgent.this.f6623e == null || (activity2 = (Activity) AuthAgent.this.f6623e.get()) == null) {
                    return;
                }
                activity2.runOnUiThread(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1
                    final /* synthetic */ Activity a;

                    RunnableC01121(Activity activity22) {
                        activity = activity22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (JniInterface.isJniOk) {
                            Activity activity22 = activity;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            com.tencent.connect.auth.a aVar = new com.tencent.connect.auth.a(activity22, "action_login", str, iUiListener, ((BaseApi) AuthAgent.this).f6711c);
                            if (activity.isFinishing()) {
                                return;
                            }
                            aVar.show();
                            return;
                        }
                        SLog.w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                        Activity activity222 = activity;
                        String strA = AuthAgent.this.a("");
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        TDialog tDialog = new TDialog(activity222, "", strA, iUiListener, ((BaseApi) AuthAgent.this).f6711c);
                        if (activity.isFinishing()) {
                            return;
                        }
                        tDialog.show();
                    }
                });
            }
        });
        SLog.i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    protected void b(IUiListener iUiListener) {
        Bundle bundleA = a();
        bundleA.putString("reqType", "checkLogin");
        HttpUtils.requestAsync(this.f6711c, g.a(), "https://openmobile.qq.com/v3/user/get_info", bundleA, "GET", new BaseApi.TempRequestListener(new a(iUiListener)));
    }

    /* JADX INFO: compiled from: ProGuard */
    private class b extends DefaultUiListener {
        WeakReference<IUiListener> a;

        /* JADX INFO: renamed from: c */
        private final String f6629c = "sendinstall";

        /* JADX INFO: renamed from: d */
        private final String f6630d = "installwording";

        /* JADX INFO: renamed from: e */
        private final String f6631e = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* JADX INFO: renamed from: com.tencent.connect.auth.AuthAgent$b$1 */
        /* JADX INFO: compiled from: ProGuard */
        class AnonymousClass1 extends a {
            final /* synthetic */ IUiListener a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Object f6632b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Dialog dialog, IUiListener iUiListener, Object obj) {
                super(dialog);
                iUiListener = iUiListener;
                obj = obj;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.a();
                Dialog dialog = this.f6638d;
                if (dialog != null && dialog.isShowing()) {
                    this.f6638d.dismiss();
                }
                IUiListener iUiListener = iUiListener;
                if (iUiListener != null) {
                    iUiListener.onComplete(obj);
                }
            }
        }

        /* JADX INFO: renamed from: com.tencent.connect.auth.AuthAgent$b$2 */
        /* JADX INFO: compiled from: ProGuard */
        class AnonymousClass2 extends a {
            final /* synthetic */ IUiListener a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Object f6634b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Dialog dialog, IUiListener iUiListener, Object obj) {
                super(dialog);
                iUiListener = iUiListener;
                obj = obj;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Dialog dialog = this.f6638d;
                if (dialog != null && dialog.isShowing()) {
                    this.f6638d.dismiss();
                }
                IUiListener iUiListener = iUiListener;
                if (iUiListener != null) {
                    iUiListener.onComplete(obj);
                }
            }
        }

        /* JADX INFO: renamed from: com.tencent.connect.auth.AuthAgent$b$3 */
        /* JADX INFO: compiled from: ProGuard */
        class AnonymousClass3 implements DialogInterface.OnCancelListener {
            final /* synthetic */ IUiListener a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Object f6636b;

            AnonymousClass3(IUiListener iUiListener, Object obj) {
                iUiListener = iUiListener;
                obj = obj;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                IUiListener iUiListener = iUiListener;
                if (iUiListener != null) {
                    iUiListener.onComplete(obj);
                }
            }
        }

        /* JADX INFO: compiled from: ProGuard */
        private abstract class a implements View.OnClickListener {

            /* JADX INFO: renamed from: d */
            Dialog f6638d;

            a(Dialog dialog) {
                this.f6638d = dialog;
            }
        }

        public b(IUiListener iUiListener) {
            this.a = new WeakReference<>(iUiListener);
        }

        private void a(String str, IUiListener iUiListener, Object obj) {
            PackageInfo packageInfo;
            if (AuthAgent.this.f6623e == null) {
                SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
                return;
            }
            Activity activity = (Activity) AuthAgent.this.f6623e.get();
            if (activity == null) {
                SLog.i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                return;
            }
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            PackageManager packageManager = activity.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                SLog.e("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e2.getStackTrace().toString());
                packageInfo = null;
            }
            Drawable drawableLoadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
            View.OnClickListener anonymousClass1 = new a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.1
                final /* synthetic */ IUiListener a;

                /* JADX INFO: renamed from: b */
                final /* synthetic */ Object f6632b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Dialog dialog2, IUiListener iUiListener2, Object obj2) {
                    super(dialog2);
                    iUiListener = iUiListener2;
                    obj = obj2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.a();
                    Dialog dialog2 = this.f6638d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f6638d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            View.OnClickListener anonymousClass2 = new a(dialog2) { // from class: com.tencent.connect.auth.AuthAgent.b.2
                final /* synthetic */ IUiListener a;

                /* JADX INFO: renamed from: b */
                final /* synthetic */ Object f6634b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(Dialog dialog2, IUiListener iUiListener2, Object obj2) {
                    super(dialog2);
                    iUiListener = iUiListener2;
                    obj = obj2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Dialog dialog2 = this.f6638d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f6638d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setAlpha(0);
            dialog2.getWindow().setBackgroundDrawable(colorDrawable);
            dialog2.setContentView(a(activity, drawableLoadIcon, str, anonymousClass1, anonymousClass2));
            dialog2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.connect.auth.AuthAgent.b.3
                final /* synthetic */ IUiListener a;

                /* JADX INFO: renamed from: b */
                final /* synthetic */ Object f6636b;

                AnonymousClass3(IUiListener iUiListener2, Object obj2) {
                    iUiListener = iUiListener2;
                    obj = obj2;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            });
            if (activity == null || activity.isFinishing()) {
                return;
            }
            dialog2.show();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.a.get() != null) {
                this.a.get().onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject;
            boolean z;
            String string;
            if (obj == null || (jSONObject = (JSONObject) obj) == null) {
                return;
            }
            boolean zSaveSession = false;
            try {
                z = jSONObject.getInt("sendinstall") == 1;
                try {
                    string = jSONObject.getString("installwording");
                } catch (JSONException unused) {
                    SLog.w("openSDK_LOG.AuthAgent", "FeedConfirmListener onComplete There is no value for sendinstall.");
                    string = "";
                }
            } catch (JSONException unused2) {
                z = false;
            }
            String strDecode = URLDecoder.decode(string);
            SLog.i("openSDK_LOG.AuthAgent", " WORDING = " + strDecode + "xx,showConfirmDialog=" + z);
            if (z && !TextUtils.isEmpty(strDecode)) {
                a(strDecode, this.a.get(), obj);
                SLog.i("openSDK_LOG.AuthAgent", " WORDING is not empty and return");
                return;
            }
            IUiListener iUiListener = this.a.get();
            if (iUiListener == null) {
                SLog.i("openSDK_LOG.AuthAgent", " userListener is null");
                return;
            }
            if (((BaseApi) AuthAgent.this).f6711c != null) {
                zSaveSession = ((BaseApi) AuthAgent.this).f6711c.saveSession(jSONObject);
                SLog.i("openSDK_LOG.AuthAgent", " saveSession saveSuccess=" + zSaveSession);
            }
            if (zSaveSession) {
                iUiListener.onComplete(obj);
            } else {
                iUiListener.onError(new UiError(-6, Constants.MSG_PERSISTENCE_FAIL, null));
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.a.get() != null) {
                this.a.get().onError(uiError);
            }
        }

        private Drawable a(String str, Context context) {
            Bitmap bitmapDecodeStream;
            try {
                InputStream inputStreamOpen = context.getApplicationContext().getAssets().open(str);
                if (inputStreamOpen == null) {
                    return null;
                }
                if (str.endsWith(".9.png")) {
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                        bitmapDecodeStream = null;
                    }
                    if (bitmapDecodeStream == null) {
                        return null;
                    }
                    byte[] ninePatchChunk = bitmapDecodeStream.getNinePatchChunk();
                    NinePatch.isNinePatchChunk(ninePatchChunk);
                    return new NinePatchDrawable(bitmapDecodeStream, ninePatchChunk, new Rect(), null);
                }
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpen, str);
                inputStreamOpen.close();
                return drawableCreateFromStream;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        private View a(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            RelativeLayout relativeLayout = new RelativeLayout(context);
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setId(1);
            int i2 = (int) (60.0f * f2);
            int i3 = (int) (f2 * 14.0f);
            int i4 = (int) (18.0f * f2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i4, (int) (6.0f * f2), i4);
            relativeLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextSize(14.0f);
            textView.setGravity(3);
            textView.setIncludeFontPadding(false);
            textView.setPadding(0, 0, 0, 0);
            textView.setLines(2);
            textView.setId(5);
            textView.setMinWidth((int) (185.0f * f2));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, 1);
            layoutParams2.addRule(6, 1);
            float f3 = 5.0f * f2;
            layoutParams2.setMargins(0, 0, (int) f3, 0);
            relativeLayout.addView(textView, layoutParams2);
            View view = new View(context);
            view.setBackgroundColor(Color.rgb(214, 214, 214));
            view.setId(3);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, 2);
            layoutParams3.addRule(3, 1);
            layoutParams3.addRule(5, 1);
            layoutParams3.addRule(7, 5);
            int i5 = (int) (12.0f * f2);
            layoutParams3.setMargins(0, 0, 0, i5);
            relativeLayout.addView(view, layoutParams3);
            LinearLayout linearLayout = new LinearLayout(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(5, 1);
            layoutParams4.addRule(7, 5);
            layoutParams4.addRule(3, 3);
            Button button = new Button(context);
            button.setText("\u8df3\u8fc7");
            button.setBackgroundDrawable(a("buttonNegt.png", context));
            button.setTextColor(Color.rgb(36, 97, 131));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            int i6 = (int) (45.0f * f2);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i6);
            layoutParams5.rightMargin = i3;
            int i7 = (int) (4.0f * f2);
            layoutParams5.leftMargin = i7;
            layoutParams5.weight = 1.0f;
            linearLayout.addView(button, layoutParams5);
            Button button2 = new Button(context);
            button2.setText("\u786e\u5b9a");
            button2.setTextSize(20.0f);
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(a("buttonPost.png", context));
            button2.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i6);
            layoutParams6.weight = 1.0f;
            layoutParams6.rightMargin = i7;
            linearLayout.addView(button2, layoutParams6);
            relativeLayout.addView(linearLayout, layoutParams4);
            ViewGroup.LayoutParams layoutParams7 = new FrameLayout.LayoutParams((int) (279.0f * f2), (int) (f2 * 163.0f));
            relativeLayout.setPadding(i3, 0, i5, i5);
            relativeLayout.setLayoutParams(layoutParams7);
            relativeLayout.setBackgroundColor(Color.rgb(247, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 247));
            PaintDrawable paintDrawable = new PaintDrawable(Color.rgb(247, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 247));
            paintDrawable.setCornerRadius(f3);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        protected void a() {
            Activity activity;
            Bundle bundleB = AuthAgent.this.b();
            if (AuthAgent.this.f6623e == null || (activity = (Activity) AuthAgent.this.f6623e.get()) == null) {
                return;
            }
            HttpUtils.requestAsync(((BaseApi) AuthAgent.this).f6711c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", bundleB, "POST", null);
        }
    }

    private boolean a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Object obj = map.get(Constants.KEY_ENABLE_SHOW_DOWNLOAD_URL);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return true;
    }

    private boolean a(Activity activity, Fragment fragment, Map<String, Object> map, boolean z, Object[] objArr) {
        SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent intentC = c();
        if (intentC != null) {
            Bundle bundleA = a();
            if (z) {
                bundleA.putString("isadd", "1");
            }
            bundleA.putString(Constants.PARAM_SCOPE, this.f6622d);
            bundleA.putString(Constants.PARAM_CLIENT_ID, this.f6711c.getAppId());
            if (BaseApi.isOEM) {
                bundleA.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + DispatchConstants.ANDROID + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + BaseApi.registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + BaseApi.businessId);
            } else {
                bundleA.putString("pf", Constants.DEFAULT_PF);
            }
            bundleA.putString("need_pay", "1");
            a(bundleA, map);
            bundleA.putString(Constants.KEY_APP_NAME, k.a(g.a()));
            intentC.putExtra(Constants.KEY_ACTION, "action_login");
            intentC.putExtra(Constants.KEY_PARAMS, bundleA);
            intentC.putExtra("appid", this.f6711c.getAppId());
            bundleA.putString(Constants.KEY_PPSTS, k.a(activity, a(bundleA)));
            try {
                this.a = new b(this.a);
                UIListenerManager.getInstance().setListenerWithRequestcode(11101, this.a);
                if (fragment != null) {
                    SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, intentC, 11101, map);
                } else {
                    SLog.d("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, intentC, 11101, map);
                }
                SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                e.a().a(0, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f6711c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                objArr[0] = "0";
                objArr[1] = 1;
                return true;
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.AuthAgent", "startActionActivity() exception", e2);
            }
        }
        e.a().a(1, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f6711c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        SLog.i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    private void a(Bundle bundle, Map<String, Object> map) {
        String strB = b(map);
        if (strB == null || strB.isEmpty()) {
            return;
        }
        bundle.putString(Constants.KEY_ADD_LOGIN_ACCOUNT, strB);
    }

    private String a(Bundle bundle) {
        String string = bundle.getString("status_os");
        String string2 = bundle.getString("status_machine");
        String string3 = bundle.getString("status_version");
        String string4 = bundle.getString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION);
        String string5 = bundle.getString(Constants.PARAM_CLIENT_ID);
        String string6 = bundle.getString("need_pay");
        String string7 = bundle.getString("pf");
        SLog.d("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
        StringBuilder sb = new StringBuilder();
        if (string == null) {
            string = "";
        }
        sb.append(string);
        if (string2 == null) {
            string2 = "";
        }
        sb.append(string2);
        if (string3 == null) {
            string3 = "";
        }
        sb.append(string3);
        if (string4 == null) {
            string4 = "";
        }
        sb.append(string4);
        if (string5 == null) {
            string5 = "";
        }
        sb.append(string5);
        if (string6 == null) {
            string6 = "";
        }
        sb.append(string6);
        if (string7 == null) {
            string7 = "";
        }
        sb.append(string7);
        return sb.toString();
    }

    protected void a(IUiListener iUiListener) {
        String strG;
        SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String accessToken = this.f6711c.getAccessToken();
        String openId = this.f6711c.getOpenId();
        String appId = this.f6711c.getAppId();
        if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId)) {
            strG = "";
        } else {
            strG = m.g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        if (TextUtils.isEmpty(strG)) {
            SLog.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle bundleA = a();
        bundleA.putString("encrytoken", strG);
        HttpUtils.requestAsync(this.f6711c, g.a(), "https://openmobile.qq.com/user/user_login_statis", bundleA, "POST", null);
        SLog.i("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }
}
