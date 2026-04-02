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
import com.tencent.connect.auth.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.m;
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
import util.x1;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class a extends Dialog {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f6649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IUiListener f6650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f6651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f6652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinearLayout f6653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FrameLayout f6654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ProgressBar f6655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f6656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.tencent.open.c.d f6657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f6658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.tencent.open.web.security.b f6659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f6661n;
    private String o;
    private String p;
    private long q;
    private long r;
    private HashMap<String, Runnable> s;

    /* JADX INFO: renamed from: com.tencent.connect.auth.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ProGuard */
    private class C0113a extends WebViewClient {
        private C0113a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + str);
            a.this.f6654g.setVisibility(8);
            if (a.this.f6657j != null) {
                a.this.f6657j.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a.this.f6651d.removeCallbacks((Runnable) a.this.s.remove(str));
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + str);
            super.onPageStarted(webView, str, bitmap);
            a.this.f6654g.setVisibility(0);
            a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.o)) {
                a.this.f6651d.removeCallbacks((Runnable) a.this.s.remove(a.this.o));
            }
            a.this.o = str;
            a aVar = a.this;
            d dVar = aVar.new d(aVar.o);
            a.this.s.put(str, dVar);
            a.this.f6651d.postDelayed(dVar, 120000L);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + i2 + " | description: " + str);
            if (!m.b(a.this.f6658k)) {
                a.this.f6649b.onError(new UiError(ConnectionResult.RESOLUTION_REQUIRED, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", str2));
                a.this.dismiss();
                return;
            }
            if (a.this.o.startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?")) {
                a.this.f6649b.onError(new UiError(i2, str, str2));
                a.this.dismiss();
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.q;
            if (a.this.f6661n >= 1 || jElapsedRealtime >= a.this.r) {
                a.this.f6657j.loadUrl(a.this.a());
            } else {
                a.m(a.this);
                a.this.f6651d.postDelayed(new Runnable() { // from class: com.tencent.connect.auth.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f6657j.loadUrl(a.this.o);
                    }
                }, 500L);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + sslError.getPrimaryError() + "\u8bf7\u6c42\u4e0d\u5408\u6cd5\uff0c\u8bf7\u68c0\u67e5\u624b\u673a\u5b89\u5168\u8bbe\u7f6e\uff0c\u5982\u7cfb\u7edf\u65f6\u95f4\u3001\u4ee3\u7406\u7b49");
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + str);
            if (str.startsWith("auth://browser")) {
                JSONObject jSONObjectC = m.c(str);
                a aVar = a.this;
                aVar.f6660m = aVar.e();
                if (!a.this.f6660m) {
                    if (jSONObjectC.optString("fail_cb", null) != null) {
                        a.this.a(jSONObjectC.optString("fail_cb"), "");
                    } else if (jSONObjectC.optInt("fall_to_wv") == 1) {
                        a aVar2 = a.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append(a.this.a);
                        sb.append(a.this.a.indexOf("?") > -1 ? "&" : "?");
                        aVar2.a = sb.toString();
                        a.this.a = a.this.a + "browser_error=1";
                        a.this.f6657j.loadUrl(a.this.a);
                    } else {
                        String strOptString = jSONObjectC.optString("redir", null);
                        if (strOptString != null) {
                            a.this.f6657j.loadUrl(strOptString);
                        }
                    }
                }
                return true;
            }
            if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.f6649b.onComplete(m.c(str));
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.f6649b.onCancel();
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.DOWNLOAD_URI) || str.endsWith(x1.f15111d)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    a.this.f6658k.startActivity(intent);
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e2);
                }
                return true;
            }
            if (!str.startsWith("auth://progress")) {
                if (str.startsWith("auth://onLoginSubmit")) {
                    try {
                        List<String> pathSegments = Uri.parse(str).getPathSegments();
                        if (!pathSegments.isEmpty()) {
                            a.this.p = pathSegments.get(0);
                        }
                    } catch (Exception unused) {
                    }
                    return true;
                }
                if (a.this.f6659l.a(a.this.f6657j, str)) {
                    return true;
                }
                SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
            try {
                List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                if (pathSegments2.isEmpty()) {
                    return true;
                }
                int iIntValue = Integer.valueOf(pathSegments2.get(0)).intValue();
                if (iIntValue == 0) {
                    a.this.f6654g.setVisibility(8);
                    a.this.f6657j.setVisibility(0);
                } else if (iIntValue == 1) {
                    a.this.f6654g.setVisibility(0);
                }
            } catch (Exception unused2) {
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private class b extends DefaultUiListener {
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f6662b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f6664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IUiListener f6665e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
            this.f6664d = str;
            this.a = str2;
            this.f6662b = str3;
            this.f6665e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f6665e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f6665e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f6664d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.a, false);
            IUiListener iUiListener = this.f6665e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f6665e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.a;
            } else {
                str = this.a;
            }
            h.a().a(this.f6664d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            a.this.a(str);
            IUiListener iUiListener = this.f6665e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f6665e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            try {
                onComplete(m.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private class c extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f6666b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.f6666b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                this.f6666b.a((String) message.obj);
            } else if (i2 == 2) {
                this.f6666b.onCancel();
            } else {
                if (i2 != 3) {
                    return;
                }
                a.b(a.this.f6658k, (String) message.obj);
            }
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    class d implements Runnable {
        String a;

        public d(String str) {
            this.a = "";
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.a + " | mRetryUrl: " + a.this.o);
            if (this.a.equals(a.this.o)) {
                a.this.f6649b.onError(new UiError(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, "\u8bf7\u6c42\u9875\u9762\u8d85\u65f6\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff01", a.this.o));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f6660m = false;
        this.q = 0L;
        this.r = 30000L;
        this.f6658k = context;
        this.a = str2;
        this.f6649b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.f6651d = new c(this.f6649b, context.getMainLooper());
        this.f6650c = iUiListener;
        this.f6656i = str;
        this.f6659l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    static /* synthetic */ int m(a aVar) {
        int i2 = aVar.f6661n;
        aVar.f6661n = i2 + 1;
        return i2;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.s.clear();
        this.f6651d.removeCallbacksAndMessages(null);
        try {
            if ((this.f6658k instanceof Activity) && !((Activity) this.f6658k).isFinishing() && isShowing()) {
                super.dismiss();
                SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");
            }
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e2);
        }
        com.tencent.open.c.d dVar = this.f6657j;
        if (dVar != null) {
            dVar.destroy();
            this.f6657j = null;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (!this.f6660m) {
            this.f6649b.onCancel();
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.tencent.open.a.a(getWindow());
        b();
        d();
        this.s = new HashMap<>();
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        com.tencent.connect.auth.b bVarA = com.tencent.connect.auth.b.a();
        String strC = bVarA.c();
        b.a aVar = new b.a();
        aVar.a = this.f6650c;
        aVar.f6672b = this;
        aVar.f6673c = strC;
        String strA = bVarA.a(aVar);
        String str = this.a;
        String strSubstring = str.substring(0, str.indexOf("?"));
        Bundle bundleB = m.b(this.a);
        bundleB.putString("token_key", strC);
        bundleB.putString("serial", strA);
        bundleB.putString("browser", "1");
        this.a = strSubstring + "?" + HttpUtils.encodeUrl(bundleB);
        return m.a(this.f6658k, this.a);
    }

    private void b() {
        try {
            c();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f6657j = new com.tencent.open.c.d(this.f6658k);
            if (Build.VERSION.SDK_INT >= 11) {
                this.f6657j.setLayerType(1, null);
            }
            this.f6657j.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            com.tencent.open.c.c cVar = new com.tencent.open.c.c(this.f6658k);
            cVar.setLayoutParams(layoutParams);
            cVar.addView(this.f6657j);
            this.f6652e = new FrameLayout(this.f6658k);
            this.f6652e.addView(cVar);
            this.f6652e.setBackgroundColor(-1);
            this.f6652e.addView(this.f6654g);
            String string = m.b(this.a).getString("style");
            if (string != null && "qr".equals(string)) {
                a(this.f6652e);
            }
            setContentView(this.f6652e);
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.AuthDialog", "onCreateView exception", e2);
            com.tencent.open.a.a(this, this.f6651d);
        }
    }

    private void c() {
        TextView textView;
        this.f6655h = new ProgressBar(this.f6658k);
        this.f6655h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f6653f = new LinearLayout(this.f6658k);
        if (this.f6656i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.f6658k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("\u767b\u5f55\u4e2d...");
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
        this.f6653f.setLayoutParams(layoutParams2);
        this.f6653f.addView(this.f6655h);
        if (textView != null) {
            this.f6653f.addView(textView);
        }
        this.f6654g = new FrameLayout(this.f6658k);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        this.f6654g.setLayoutParams(layoutParams3);
        this.f6654g.setBackgroundColor(Color.parseColor("#B3000000"));
        this.f6654g.addView(this.f6653f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.f6657j.setVerticalScrollBarEnabled(false);
        this.f6657j.setHorizontalScrollBarEnabled(false);
        this.f6657j.setWebViewClient(new C0113a());
        this.f6657j.setWebChromeClient(new WebChromeClient());
        this.f6657j.clearFormData();
        this.f6657j.clearSslPreferences();
        this.f6657j.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.connect.auth.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.f6657j.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.connect.auth.a.3
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
        WebSettings settings = this.f6657j.getSettings();
        com.tencent.open.web.a.a(this.f6657j);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f6658k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.a);
        String str = this.a;
        this.o = str;
        this.f6657j.loadUrl(str);
        this.f6657j.setVisibility(4);
        this.f6659l.a(new SecureJsInterface(), "SecureJsInterface");
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
    public String a(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            String str2 = this.p;
            String strSubstring = str2.substring(str2.length() - 4);
            sb.append("_u_");
            sb.append(strSubstring);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        String str = this.a;
        String str2 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + str.substring(str.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return str2;
    }

    private void a(ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.f6658k);
        int iA = com.tencent.connect.avatar.a.a(this.f6658k, 15.6f);
        int iA2 = com.tencent.connect.avatar.a.a(this.f6658k, 25.2f);
        int iA3 = com.tencent.connect.avatar.a.a(this.f6658k, 10.0f);
        int i2 = iA3 * 2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA + i2, iA2 + i2);
        layoutParams.leftMargin = iA3;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(iA3, iA3, iA3, iA3);
        imageView.setImageDrawable(m.a("h5_qr_back.png", this.f6658k));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.connect.auth.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.dismiss();
                if (a.this.f6660m || a.this.f6649b == null) {
                    return;
                }
                a.this.f6649b.onCancel();
            }
        });
        viewGroup.addView(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str) {
        try {
            JSONObject jSONObjectD = m.d(str);
            int i2 = jSONObjectD.getInt("type");
            Toast.makeText(context.getApplicationContext(), jSONObjectD.getString("msg"), i2).show();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        this.f6657j.loadUrl("javascript:" + str + "(" + str2 + ");void(" + System.currentTimeMillis() + ");");
    }
}
