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
import com.tencent.connect.C3202a;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.p207a.C3203a;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3263e;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3291i;
import com.tencent.open.utils.C3292j;
import com.tencent.open.utils.C3293k;
import com.tencent.open.utils.C3294l;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.security.JniInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class AuthAgent extends BaseApi {
    public static final String KEY_FORCE_QR_LOGIN = "KEY_FORCE_QR_LOGIN";
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final int SECURE_LIB_VERSION = 5;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";

    /* renamed from: a */
    private IUiListener f10865a;

    /* renamed from: d */
    private String f10866d;

    /* renamed from: e */
    private WeakReference<Activity> f10867e;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.AuthAgent$a */
    private class C3206a extends DefaultUiListener {

        /* renamed from: a */
        IUiListener f10873a;

        public C3206a(IUiListener iUiListener) {
            this.f10873a = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f10873a;
            if (iUiListener != null) {
                iUiListener.onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            if (obj == null) {
                SLog.m10500e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i2 = jSONObject.getInt("ret");
                String string = i2 == 0 ? "success" : jSONObject.getString("msg");
                if (this.f10873a != null) {
                    this.f10873a.onComplete(new JSONObject().put("ret", i2).put("msg", string));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                SLog.m10500e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            IUiListener iUiListener = this.f10873a;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.AuthAgent$c */
    private class C3208c extends DefaultUiListener {

        /* renamed from: b */
        private final IUiListener f10892b;

        /* renamed from: c */
        private final boolean f10893c;

        /* renamed from: d */
        private final Context f10894d;

        public C3208c(Context context, IUiListener iUiListener, boolean z, boolean z2) {
            this.f10894d = context;
            this.f10892b = iUiListener;
            this.f10893c = z;
            SLog.m10498d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            SLog.m10498d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.f10892b.onCancel();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            SLog.m10498d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (string != null && ((BaseApi) AuthAgent.this).f11013c != null && string3 != null) {
                    ((BaseApi) AuthAgent.this).f11013c.setAccessToken(string, string2);
                    ((BaseApi) AuthAgent.this).f11013c.setOpenId(string3);
                    C3203a.m10158d(this.f10894d, ((BaseApi) AuthAgent.this).f11013c);
                }
                String string4 = jSONObject.getString("pf");
                if (string4 != null) {
                    try {
                        this.f10894d.getSharedPreferences(Constants.PREFERENCE_PF, 0).edit().putString("pf", string4).commit();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        SLog.m10501e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
                    }
                }
                if (this.f10893c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
                SLog.m10501e("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e3);
            }
            this.f10892b.onComplete(jSONObject);
            AuthAgent.this.releaseResource();
            SLog.release();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            SLog.m10498d("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.f10892b.onError(uiError);
            SLog.release();
        }
    }

    static {
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            SLog.m10502i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
            return;
        }
        if (str.equalsIgnoreCase("arm64-v8a")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            SLog.m10502i("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
            return;
        }
        if (str.equalsIgnoreCase("x86")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            SLog.m10502i("openSDK_LOG.AuthAgent", "is x86 architecture");
            return;
        }
        if (str.equalsIgnoreCase("x86_64")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
            SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
            SLog.m10502i("openSDK_LOG.AuthAgent", "is x86_64 architecture");
            return;
        }
        SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
        SECURE_LIB_NAME = SECURE_LIB_FILE_NAME + ".so";
        SLog.m10502i("openSDK_LOG.AuthAgent", "is arm(default) architecture");
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment, boolean z2, Map<String, Object> map) {
        if (C3202a.m10152a("openSDK_LOG.AuthAgent", iUiListener)) {
            return -1;
        }
        this.f10866d = str;
        this.f10867e = new WeakReference<>(activity);
        this.f10865a = iUiListener;
        Object[] objArr = new Object[2];
        boolean booleanExtra = activity.getIntent().getBooleanExtra(KEY_FORCE_QR_LOGIN, false);
        boolean m10625b = C3291i.m10615a(activity, this.f11013c.getAppId()).m10625b("C_LoginWeb");
        SLog.m10502i("openSDK_LOG.AuthAgent", "doLogin needForceQrLogin=" + booleanExtra + ", toWebLogin=" + m10625b);
        if (!booleanExtra && !m10625b && m10167a(activity, fragment, map, z, objArr)) {
            SLog.m10502i("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
            C3263e.m10457a().m10460a(this.f11013c.getOpenId(), this.f11013c.getAppId(), "2", "1", "5", (String) objArr[0], "0", "0");
            return ((Integer) objArr[1]).intValue();
        }
        C3263e.m10457a().m10460a(this.f11013c.getOpenId(), this.f11013c.getAppId(), "2", "1", "5", "1", "0", "0");
        SLog.m10508w("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
        this.f10865a = new C3207b(this.f10865a);
        return m10162a(z, this.f10865a, z2, map);
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
        this.f10865a = null;
    }

    /* renamed from: b */
    private String m10170b(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        Object obj = map.get(Constants.KEY_ADD_LOGIN_ACCOUNT);
        return obj instanceof String ? ((String) obj).trim() : "";
    }

    /* renamed from: a */
    int m10180a(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment, boolean z2) {
        return doLogin(activity, str, iUiListener, z, fragment, z2, null);
    }

    /* renamed from: a */
    private int m10162a(boolean z, IUiListener iUiListener, boolean z2, Map<String, Object> map) {
        CookieSyncManager.createInstance(C3289g.m10603a());
        Bundle m10308a = m10308a();
        if (z) {
            m10308a.putString("isadd", "1");
        }
        m10308a.putString(Constants.PARAM_SCOPE, this.f10866d);
        m10308a.putString(Constants.PARAM_CLIENT_ID, this.f11013c.getAppId());
        if (BaseApi.isOEM) {
            m10308a.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + DispatchConstants.ANDROID + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + BaseApi.registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + BaseApi.businessId);
        } else {
            m10308a.putString("pf", Constants.DEFAULT_PF);
        }
        String str = (System.currentTimeMillis() / 1000) + "";
        m10308a.putString("sign", C3293k.m10641b(C3289g.m10603a(), str));
        m10308a.putString("time", str);
        m10308a.putString("display", "mobile");
        m10308a.putString("response_type", "token");
        m10308a.putString("redirect_uri", "auth://tauth.qq.com/");
        m10308a.putString("cancel_display", "1");
        m10308a.putString("switch", "1");
        m10308a.putString("compat_v", "1");
        if (z2) {
            m10308a.putString("style", "qr");
        }
        String m10170b = m10170b(map);
        SLog.m10502i("openSDK_LOG.AuthAgent", "OpenUI, showDialog addLoginAccount: " + m10170b);
        if (m10170b != null && !m10170b.isEmpty()) {
            m10308a.putString("uin", m10170b);
        }
        boolean m10168a = m10168a(map);
        m10308a.putString("show_download_ui", Boolean.toString(m10168a));
        SLog.m10502i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start, isShowDownloadUi=" + m10168a);
        final String str2 = C3292j.m10626a().m10627a(C3289g.m10603a(), "https://openmobile.qq.com/oauth2.0/m_authorize?") + HttpUtils.encodeUrl(m10308a);
        final C3208c c3208c = new C3208c(C3289g.m10603a(), iUiListener, true, false);
        SLog.m10498d("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        C3294l.m10656b(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1
            @Override // java.lang.Runnable
            public void run() {
                final Activity activity;
                C3293k.m10639a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                JniInterface.loadSo();
                if (AuthAgent.this.f10867e == null || (activity = (Activity) AuthAgent.this.f10867e.get()) == null) {
                    return;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.connect.auth.AuthAgent.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (JniInterface.isJniOk) {
                            Activity activity2 = activity;
                            RunnableC32051 runnableC32051 = RunnableC32051.this;
                            DialogC3209a dialogC3209a = new DialogC3209a(activity2, "action_login", str2, c3208c, ((BaseApi) AuthAgent.this).f11013c);
                            if (activity.isFinishing()) {
                                return;
                            }
                            dialogC3209a.show();
                            return;
                        }
                        SLog.m10508w("openSDK_LOG.AuthAgent", "OpenUi, secure so load failed, goto download QQ.");
                        Activity activity3 = activity;
                        String m10309a = AuthAgent.this.m10309a("");
                        RunnableC32051 runnableC320512 = RunnableC32051.this;
                        TDialog tDialog = new TDialog(activity3, "", m10309a, c3208c, ((BaseApi) AuthAgent.this).f11013c);
                        if (activity.isFinishing()) {
                            return;
                        }
                        tDialog.show();
                    }
                });
            }
        });
        SLog.m10502i("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return 2;
    }

    /* renamed from: b */
    protected void m10182b(IUiListener iUiListener) {
        Bundle m10308a = m10308a();
        m10308a.putString("reqType", "checkLogin");
        HttpUtils.requestAsync(this.f11013c, C3289g.m10603a(), "https://openmobile.qq.com/v3/user/get_info", m10308a, "GET", new BaseApi.TempRequestListener(new C3206a(iUiListener)));
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.AuthAgent$b */
    private class C3207b extends DefaultUiListener {

        /* renamed from: a */
        WeakReference<IUiListener> f10875a;

        /* renamed from: c */
        private final String f10877c = "sendinstall";

        /* renamed from: d */
        private final String f10878d = "installwording";

        /* renamed from: e */
        private final String f10879e = "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* compiled from: ProGuard */
        /* renamed from: com.tencent.connect.auth.AuthAgent$b$a */
        private abstract class a implements View.OnClickListener {

            /* renamed from: d */
            Dialog f10889d;

            a(Dialog dialog) {
                this.f10889d = dialog;
            }
        }

        public C3207b(IUiListener iUiListener) {
            this.f10875a = new WeakReference<>(iUiListener);
        }

        /* renamed from: a */
        private void m10185a(String str, final IUiListener iUiListener, final Object obj) {
            PackageInfo packageInfo;
            if (AuthAgent.this.f10867e == null) {
                SLog.m10502i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity null and return");
                return;
            }
            Activity activity = (Activity) AuthAgent.this.f10867e.get();
            if (activity == null) {
                SLog.m10502i("openSDK_LOG.AuthAgent", "showFeedConfrimDialog mActivity.get() null and return");
                return;
            }
            Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(1);
            PackageManager packageManager = activity.getPackageManager();
            try {
                packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                SLog.m10500e("openSDK_LOG.AuthAgent", "showFeedConfrimDialog exception:" + e2.getStackTrace().toString());
                packageInfo = null;
            }
            Drawable loadIcon = packageInfo != null ? packageInfo.applicationInfo.loadIcon(packageManager) : null;
            View.OnClickListener onClickListener = new a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C3207b.this.m10186a();
                    Dialog dialog2 = this.f10889d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f10889d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            View.OnClickListener onClickListener2 = new a(dialog) { // from class: com.tencent.connect.auth.AuthAgent.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Dialog dialog2 = this.f10889d;
                    if (dialog2 != null && dialog2.isShowing()) {
                        this.f10889d.dismiss();
                    }
                    IUiListener iUiListener2 = iUiListener;
                    if (iUiListener2 != null) {
                        iUiListener2.onComplete(obj);
                    }
                }
            };
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setAlpha(0);
            dialog.getWindow().setBackgroundDrawable(colorDrawable);
            dialog.setContentView(m10184a(activity, loadIcon, str, onClickListener, onClickListener2));
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.connect.auth.AuthAgent.b.3
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
            dialog.show();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            if (this.f10875a.get() != null) {
                this.f10875a.get().onCancel();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onComplete(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.String r0 = "openSDK_LOG.AuthAgent"
                if (r8 == 0) goto La5
                r1 = r8
                org.json.JSONObject r1 = (org.json.JSONObject) r1
                if (r1 == 0) goto La5
                r2 = 0
                java.lang.String r3 = "sendinstall"
                int r3 = r1.getInt(r3)     // Catch: org.json.JSONException -> L1c
                r4 = 1
                if (r3 != r4) goto L14
                goto L15
            L14:
                r4 = 0
            L15:
                java.lang.String r3 = "installwording"
                java.lang.String r3 = r1.getString(r3)     // Catch: org.json.JSONException -> L1d
                goto L24
            L1c:
                r4 = 0
            L1d:
                java.lang.String r3 = "FeedConfirmListener onComplete There is no value for sendinstall."
                com.tencent.open.log.SLog.m10508w(r0, r3)
                java.lang.String r3 = ""
            L24:
                java.lang.String r3 = java.net.URLDecoder.decode(r3)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = " WORDING = "
                r5.append(r6)
                r5.append(r3)
                java.lang.String r6 = "xx,showConfirmDialog="
                r5.append(r6)
                r5.append(r4)
                java.lang.String r5 = r5.toString()
                com.tencent.open.log.SLog.m10502i(r0, r5)
                if (r4 == 0) goto L5d
                boolean r4 = android.text.TextUtils.isEmpty(r3)
                if (r4 != 0) goto L5d
                java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> r1 = r7.f10875a
                java.lang.Object r1 = r1.get()
                com.tencent.tauth.IUiListener r1 = (com.tencent.tauth.IUiListener) r1
                r7.m10185a(r3, r1, r8)
                java.lang.String r8 = " WORDING is not empty and return"
                com.tencent.open.log.SLog.m10502i(r0, r8)
                return
            L5d:
                java.lang.ref.WeakReference<com.tencent.tauth.IUiListener> r3 = r7.f10875a
                java.lang.Object r3 = r3.get()
                com.tencent.tauth.IUiListener r3 = (com.tencent.tauth.IUiListener) r3
                if (r3 == 0) goto La0
                com.tencent.connect.auth.AuthAgent r4 = com.tencent.connect.auth.AuthAgent.this
                com.tencent.connect.auth.QQToken r4 = com.tencent.connect.auth.AuthAgent.m10176h(r4)
                if (r4 == 0) goto L8d
                com.tencent.connect.auth.AuthAgent r2 = com.tencent.connect.auth.AuthAgent.this
                com.tencent.connect.auth.QQToken r2 = com.tencent.connect.auth.AuthAgent.m10177i(r2)
                boolean r2 = r2.saveSession(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r4 = " saveSession saveSuccess="
                r1.append(r4)
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.tencent.open.log.SLog.m10502i(r0, r1)
            L8d:
                if (r2 == 0) goto L93
                r3.onComplete(r8)
                goto La5
            L93:
                com.tencent.tauth.UiError r8 = new com.tencent.tauth.UiError
                r0 = -6
                r1 = 0
                java.lang.String r2 = "持久化失败!"
                r8.<init>(r0, r2, r1)
                r3.onError(r8)
                goto La5
            La0:
                java.lang.String r8 = " userListener is null"
                com.tencent.open.log.SLog.m10502i(r0, r8)
            La5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.auth.AuthAgent.C3207b.onComplete(java.lang.Object):void");
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            if (this.f10875a.get() != null) {
                this.f10875a.get().onError(uiError);
            }
        }

        /* renamed from: a */
        private Drawable m10183a(String str, Context context) {
            Bitmap bitmap;
            try {
                InputStream open = context.getApplicationContext().getAssets().open(str);
                if (open == null) {
                    return null;
                }
                if (str.endsWith(".9.png")) {
                    try {
                        bitmap = BitmapFactory.decodeStream(open);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                        bitmap = null;
                    }
                    if (bitmap == null) {
                        return null;
                    }
                    byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                    NinePatch.isNinePatchChunk(ninePatchChunk);
                    return new NinePatchDrawable(bitmap, ninePatchChunk, new Rect(), null);
                }
                Drawable createFromStream = Drawable.createFromStream(open, str);
                open.close();
                return createFromStream;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* renamed from: a */
        private View m10184a(Context context, Drawable drawable, String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
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
            button.setText("跳过");
            button.setBackgroundDrawable(m10183a("buttonNegt.png", context));
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
            button2.setText("确定");
            button2.setTextSize(20.0f);
            button2.setTextColor(Color.rgb(255, 255, 255));
            button2.setBackgroundDrawable(m10183a("buttonPost.png", context));
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

        /* renamed from: a */
        protected void m10186a() {
            Activity activity;
            Bundle m10318b = AuthAgent.this.m10318b();
            if (AuthAgent.this.f10867e == null || (activity = (Activity) AuthAgent.this.f10867e.get()) == null) {
                return;
            }
            HttpUtils.requestAsync(((BaseApi) AuthAgent.this).f11013c, activity, "https://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", m10318b, "POST", null);
        }
    }

    /* renamed from: a */
    private boolean m10168a(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Object obj = map.get(Constants.KEY_ENABLE_SHOW_DOWNLOAD_URL);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m10167a(Activity activity, Fragment fragment, Map<String, Object> map, boolean z, Object[] objArr) {
        SLog.m10502i("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent m10319c = m10319c();
        if (m10319c != null) {
            Bundle m10308a = m10308a();
            if (z) {
                m10308a.putString("isadd", "1");
            }
            m10308a.putString(Constants.PARAM_SCOPE, this.f10866d);
            m10308a.putString(Constants.PARAM_CLIENT_ID, this.f11013c.getAppId());
            if (BaseApi.isOEM) {
                m10308a.putString("pf", "desktop_m_qq-" + BaseApi.installChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + DispatchConstants.ANDROID + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + BaseApi.registerChannel + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + BaseApi.businessId);
            } else {
                m10308a.putString("pf", Constants.DEFAULT_PF);
            }
            m10308a.putString("need_pay", "1");
            m10166a(m10308a, map);
            m10308a.putString(Constants.KEY_APP_NAME, C3293k.m10633a(C3289g.m10603a()));
            m10319c.putExtra(Constants.KEY_ACTION, "action_login");
            m10319c.putExtra(Constants.KEY_PARAMS, m10308a);
            m10319c.putExtra("appid", this.f11013c.getAppId());
            m10308a.putString(Constants.KEY_PPSTS, C3293k.m10632a(activity, m10164a(m10308a)));
            try {
                this.f10865a = new C3207b(this.f10865a);
                UIListenerManager.getInstance().setListenerWithRequestcode(11101, this.f10865a);
                if (fragment != null) {
                    SLog.m10498d("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    m10314a(fragment, m10319c, 11101, map);
                } else {
                    SLog.m10498d("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    m10312a(activity, m10319c, 11101, map);
                }
                SLog.m10502i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                C3263e.m10457a().m10458a(0, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f11013c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                objArr[0] = "0";
                objArr[1] = 1;
                return true;
            } catch (Exception e2) {
                SLog.m10501e("openSDK_LOG.AuthAgent", "startActionActivity() exception", e2);
            }
        }
        C3263e.m10457a().m10458a(1, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.f11013c.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        SLog.m10502i("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return false;
    }

    /* renamed from: a */
    private void m10166a(Bundle bundle, Map<String, Object> map) {
        String m10170b = m10170b(map);
        if (m10170b == null || m10170b.isEmpty()) {
            return;
        }
        bundle.putString(Constants.KEY_ADD_LOGIN_ACCOUNT, m10170b);
    }

    /* renamed from: a */
    private String m10164a(Bundle bundle) {
        String string = bundle.getString("status_os");
        String string2 = bundle.getString("status_machine");
        String string3 = bundle.getString("status_version");
        String string4 = bundle.getString(SocializeProtocolConstants.PROTOCOL_KEY_VERSION);
        String string5 = bundle.getString(Constants.PARAM_CLIENT_ID);
        String string6 = bundle.getString("need_pay");
        String string7 = bundle.getString("pf");
        SLog.m10498d("openSDK_LOG.AuthAgent", "os=" + string + ", machine=" + string2 + ", version=" + string3 + ", sdkv=" + string4 + ", appId=" + string5 + ", needPay=" + string6 + ", pf=" + string7);
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

    /* renamed from: a */
    protected void m10181a(IUiListener iUiListener) {
        String str;
        SLog.m10502i("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        String accessToken = this.f11013c.getAccessToken();
        String openId = this.f11013c.getOpenId();
        String appId = this.f11013c.getAppId();
        if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId)) {
            str = "";
        } else {
            str = C3295m.m10704g("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
        }
        if (TextUtils.isEmpty(str)) {
            SLog.m10500e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        Bundle m10308a = m10308a();
        m10308a.putString("encrytoken", str);
        HttpUtils.requestAsync(this.f11013c, C3289g.m10603a(), "https://openmobile.qq.com/user/user_login_statis", m10308a, "POST", null);
        SLog.m10502i("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }
}
