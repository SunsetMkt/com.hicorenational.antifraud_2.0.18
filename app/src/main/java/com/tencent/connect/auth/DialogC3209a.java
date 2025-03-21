package com.tencent.connect.auth;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.hms.api.ConnectionResult;
import com.tencent.connect.auth.C3210b;
import com.tencent.connect.avatar.C3219a;
import com.tencent.connect.common.Constants;
import com.tencent.open.C3249a;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3266h;
import com.tencent.open.p213c.C3270c;
import com.tencent.open.p213c.C3271d;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.web.C3298a;
import com.tencent.open.web.security.C3300b;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import util.C7316r1;

/* compiled from: ProGuard */
/* renamed from: com.tencent.connect.auth.a */
/* loaded from: classes2.dex */
public class DialogC3209a extends Dialog {

    /* renamed from: a */
    private String f10902a;

    /* renamed from: b */
    private b f10903b;

    /* renamed from: c */
    private IUiListener f10904c;

    /* renamed from: d */
    private Handler f10905d;

    /* renamed from: e */
    private FrameLayout f10906e;

    /* renamed from: f */
    private LinearLayout f10907f;

    /* renamed from: g */
    private FrameLayout f10908g;

    /* renamed from: h */
    private ProgressBar f10909h;

    /* renamed from: i */
    private String f10910i;

    /* renamed from: j */
    private C3271d f10911j;

    /* renamed from: k */
    private Context f10912k;

    /* renamed from: l */
    private C3300b f10913l;

    /* renamed from: m */
    private boolean f10914m;

    /* renamed from: n */
    private int f10915n;

    /* renamed from: o */
    private String f10916o;

    /* renamed from: p */
    private String f10917p;

    /* renamed from: q */
    private long f10918q;

    /* renamed from: r */
    private long f10919r;

    /* renamed from: s */
    private HashMap<String, Runnable> f10920s;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$a */
    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.m10506v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            DialogC3209a.this.f10908g.setVisibility(8);
            if (DialogC3209a.this.f10911j != null) {
                DialogC3209a.this.f10911j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            DialogC3209a.this.f10905d.removeCallbacks((Runnable) DialogC3209a.this.f10920s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.m10506v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            DialogC3209a.this.f10908g.setVisibility(0);
            DialogC3209a.this.f10918q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(DialogC3209a.this.f10916o)) {
                DialogC3209a.this.f10905d.removeCallbacks((Runnable) DialogC3209a.this.f10920s.remove(DialogC3209a.this.f10916o));
            }
            DialogC3209a.this.f10916o = str;
            DialogC3209a dialogC3209a = DialogC3209a.this;
            d dVar = dialogC3209a.new d(dialogC3209a.f10916o);
            DialogC3209a.this.f10920s.put(str, dVar);
            DialogC3209a.this.f10905d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            SLog.m10502i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i2 + " | description: " + str);
            if (!C3295m.m10688b(DialogC3209a.this.f10912k)) {
                DialogC3209a.this.f10903b.onError(new UiError(ConnectionResult.RESOLUTION_REQUIRED, "当前网络不可用，请稍后重试！", str2));
                DialogC3209a.this.dismiss();
                return;
            }
            if (DialogC3209a.this.f10916o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                DialogC3209a.this.f10903b.onError(new UiError(i2, str, str2));
                DialogC3209a.this.dismiss();
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - DialogC3209a.this.f10918q;
            if (DialogC3209a.this.f10915n >= 1 || elapsedRealtime >= DialogC3209a.this.f10919r) {
                DialogC3209a.this.f10911j.loadUrl(DialogC3209a.this.m10195a());
            } else {
                DialogC3209a.m10220m(DialogC3209a.this);
                DialogC3209a.this.f10905d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DialogC3209a.this.f10911j.loadUrl(DialogC3209a.this.f10916o);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.m10500e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> pathSegments;
            SLog.m10506v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject m10692c = C3295m.m10692c(str);
                DialogC3209a dialogC3209a = DialogC3209a.this;
                dialogC3209a.f10914m = dialogC3209a.m10212e();
                if (!DialogC3209a.this.f10914m) {
                    if (m10692c.optString("fail_cb", null) != null) {
                        DialogC3209a.this.m10224a(m10692c.optString("fail_cb"), "");
                    } else if (m10692c.optInt("fall_to_wv") == 1) {
                        DialogC3209a dialogC3209a2 = DialogC3209a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(DialogC3209a.this.f10902a);
                        sb.append(DialogC3209a.this.f10902a.indexOf("?") > -1 ? "&" : "?");
                        dialogC3209a2.f10902a = sb.toString();
                        DialogC3209a.this.f10902a = DialogC3209a.this.f10902a + "browser_error=1";
                        DialogC3209a.this.f10911j.loadUrl(DialogC3209a.this.f10902a);
                    } else {
                        String optString = m10692c.optString("redir", null);
                        if (optString != null) {
                            DialogC3209a.this.f10911j.loadUrl(optString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                DialogC3209a.this.f10903b.onComplete(C3295m.m10692c(str));
                DialogC3209a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                DialogC3209a.this.f10903b.onCancel();
                DialogC3209a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                DialogC3209a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.DOWNLOAD_URI) || str.endsWith(C7316r1.f25586d)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    DialogC3209a.this.f10912k.startActivity(intent);
                } catch (Exception e2) {
                    SLog.m10501e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
                }
                return true;
            }
            if (!str.startsWith("auth://progress")) {
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                        if (!pathSegments2.isEmpty()) {
                            DialogC3209a.this.f10917p = pathSegments2.get(0);
                        }
                    } catch (Exception unused) {
                    }
                    return true;
                }
                if (DialogC3209a.this.f10913l.mo10431a(DialogC3209a.this.f10911j, str)) {
                    return true;
                }
                SLog.m10502i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
            try {
                pathSegments = Uri.parse(str).getPathSegments();
            } catch (Exception unused2) {
            }
            if (pathSegments.isEmpty()) {
                return true;
            }
            int intValue = Integer.valueOf(pathSegments.get(0)).intValue();
            if (intValue == 0) {
                DialogC3209a.this.f10908g.setVisibility(8);
                DialogC3209a.this.f10911j.setVisibility(0);
            } else if (intValue == 1) {
                DialogC3209a.this.f10908g.setVisibility(0);
            }
            return true;
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$b */
    private class b extends DefaultUiListener {

        /* renamed from: a */
        String f10927a;

        /* renamed from: b */
        String f10928b;

        /* renamed from: d */
        private String f10930d;

        /* renamed from: e */
        private IUiListener f10931e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f10930d = str;
            this.f10927a = str2;
            this.f10928b = str3;
            this.f10931e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f10931e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f10931e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C3266h.m10468a().m10472a(this.f10930d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f10927a, false);
            IUiListener iUiListener = this.f10931e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f10931e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f10927a;
            } else {
                str = this.f10927a;
            }
            C3266h.m10468a().m10472a(this.f10930d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            DialogC3209a.this.m10197a(str);
            IUiListener iUiListener = this.f10931e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f10931e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m10226a(String str) {
            try {
                onComplete(C3295m.m10696d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$c */
    private class c extends Handler {

        /* renamed from: b */
        private b f10933b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f10933b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                this.f10933b.m10226a((String) message.obj);
            } else if (i2 == 2) {
                this.f10933b.onCancel();
            } else {
                if (i2 != 3) {
                    return;
                }
                DialogC3209a.m10203b(DialogC3209a.this.f10912k, (String) message.obj);
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.connect.auth.a$d */
    class d implements Runnable {

        /* renamed from: a */
        String f10934a;

        public d(String str) {
            this.f10934a = "";
            this.f10934a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.m10506v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f10934a + " | mRetryUrl: " + DialogC3209a.this.f10916o);
            if (this.f10934a.equals(DialogC3209a.this.f10916o)) {
                DialogC3209a.this.f10903b.onError(new UiError(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, "请求页面超时，请稍后重试！", DialogC3209a.this.f10916o));
                DialogC3209a.this.dismiss();
            }
        }
    }

    public DialogC3209a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f10914m = false;
        this.f10918q = 0L;
        this.f10919r = 30000L;
        this.f10912k = context;
        this.f10902a = str2;
        this.f10903b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f10905d = new c(this.f10903b, context.getMainLooper());
        this.f10904c = iUiListener;
        this.f10910i = str;
        this.f10913l = new C3300b();
        getWindow().setSoftInputMode(32);
    }

    /* renamed from: m */
    static /* synthetic */ int m10220m(DialogC3209a dialogC3209a) {
        int i2 = dialogC3209a.f10915n;
        dialogC3209a.f10915n = i2 + 1;
        return i2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f10920s.clear();
        this.f10905d.removeCallbacksAndMessages(null);
        try {
            if ((this.f10912k instanceof Activity) && !((Activity) this.f10912k).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.m10502i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e2);
        }
        C3271d c3271d = this.f10911j;
        if (c3271d != null) {
            c3271d.destroy();
            this.f10911j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f10914m) {
            this.f10903b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        C3249a.m10399a(getWindow());
        m10202b();
        m10210d();
        this.f10920s = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m10212e() {
        C3210b m10227a = C3210b.m10227a();
        String m10230c = m10227a.m10230c();
        C3210b.a aVar = new C3210b.a();
        aVar.f10941a = this.f10904c;
        aVar.f10942b = this;
        aVar.f10943c = m10230c;
        String m10229a = m10227a.m10229a(aVar);
        String str = this.f10902a;
        String substring = str.substring(0, str.indexOf("?"));
        Bundle m10684b = C3295m.m10684b(this.f10902a);
        m10684b.putString("token_key", m10230c);
        m10684b.putString("serial", m10229a);
        m10684b.putString("browser", "1");
        this.f10902a = substring + "?" + HttpUtils.encodeUrl(m10684b);
        return C3295m.m10678a(this.f10912k, this.f10902a);
    }

    /* renamed from: b */
    private void m10202b() {
        try {
            m10206c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f10911j = new C3271d(this.f10912k);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f10911j.setLayerType(1, null);
            }
            this.f10911j.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            C3270c c3270c = new C3270c(this.f10912k);
            c3270c.setLayoutParams(layoutParams);
            c3270c.addView(this.f10911j);
            this.f10906e = new FrameLayout(this.f10912k);
            this.f10906e.addView(c3270c);
            this.f10906e.setBackgroundColor(-1);
            this.f10906e.addView(this.f10908g);
            String string = C3295m.m10684b(this.f10902a).getString("style");
            if (string != null && "qr".equals(string)) {
                m10199a(this.f10906e);
            }
            setContentView(this.f10906e);
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.AuthDialog", "onCreateView exception", e2);
            C3249a.m10398a(this, this.f10905d);
        }
    }

    /* renamed from: c */
    private void m10206c() {
        TextView textView;
        this.f10909h = new ProgressBar(this.f10912k);
        this.f10909h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f10907f = new LinearLayout(this.f10912k);
        if (this.f10910i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f10912k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f10907f.setLayoutParams(layoutParams2);
        this.f10907f.addView(this.f10909h);
        if (textView != null) {
            this.f10907f.addView(textView);
        }
        this.f10908g = new FrameLayout(this.f10912k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f10908g.setLayoutParams(layoutParams3);
        this.f10908g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f10908g.addView(this.f10907f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: d */
    private void m10210d() {
        this.f10911j.setVerticalScrollBarEnabled(false);
        this.f10911j.setHorizontalScrollBarEnabled(false);
        this.f10911j.setWebViewClient(new a());
        this.f10911j.setWebChromeClient(new WebChromeClient());
        this.f10911j.clearFormData();
        this.f10911j.clearSslPreferences();
        this.f10911j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f10911j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if ((action != 0 && action != 1) || view.hasFocus()) {
                    return false;
                }
                view.requestFocus();
                return false;
            }
        });
        WebSettings settings = this.f10911j.getSettings();
        C3298a.m10720a(this.f10911j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f10912k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.m10506v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f10902a);
        String str = this.f10902a;
        this.f10916o = str;
        this.f10911j.loadUrl(str);
        this.f10911j.setVisibility(4);
        this.f10913l.m10429a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.connect.auth.a.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    if (JniInterface.isJniOk) {
                        JniInterface.clearAllPWD();
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m10197a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.f10917p) && this.f10917p.length() >= 4) {
            String str2 = this.f10917p;
            String substring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(substring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m10195a() {
        String str = this.f10902a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.m10502i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    /* renamed from: a */
    private void m10199a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f10912k);
        int m10293a = C3219a.m10293a(this.f10912k, 15.6f);
        int m10293a2 = C3219a.m10293a(this.f10912k, 25.2f);
        int m10293a3 = C3219a.m10293a(this.f10912k, 10.0f);
        int i2 = m10293a3 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m10293a + i2, m10293a2 + i2);
        layoutParams.leftMargin = m10293a3;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(m10293a3, m10293a3, m10293a3, m10293a3);
        imageView.setImageDrawable(C3295m.m10661a("h5_qr_back.png", this.f10912k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC3209a.this.dismiss();
                if (DialogC3209a.this.f10914m || DialogC3209a.this.f10903b == null) {
                    return;
                }
                DialogC3209a.this.f10903b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m10203b(Context context, String str) {
        try {
            JSONObject m10696d = C3295m.m10696d(str);
            int i2 = m10696d.getInt("type");
            Toast.makeText(context.getApplicationContext(), m10696d.getString("msg"), i2).show();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m10224a(String str, String str2) {
        this.f10911j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
