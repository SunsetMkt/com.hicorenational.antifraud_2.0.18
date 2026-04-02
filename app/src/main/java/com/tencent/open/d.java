package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.c.a;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class d extends com.tencent.open.c implements a.InterfaceC0119a {

    /* JADX INFO: renamed from: c */
    static Toast f6845c;

    /* JADX INFO: renamed from: d */
    private String f6846d;

    /* JADX INFO: renamed from: e */
    private IUiListener f6847e;

    /* JADX INFO: renamed from: f */
    private c f6848f;

    /* JADX INFO: renamed from: g */
    private Handler f6849g;

    /* JADX INFO: renamed from: h */
    private com.tencent.open.c.a f6850h;

    /* JADX INFO: renamed from: i */
    private com.tencent.open.c.b f6851i;

    /* JADX INFO: renamed from: j */
    private WeakReference<Context> f6852j;

    /* JADX INFO: renamed from: k */
    private int f6853k;

    /* JADX INFO: compiled from: ProGuard */
    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            d.this.f6851i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            d.this.f6848f.onError(new UiError(i2, str, str2));
            if (d.this.f6852j != null && d.this.f6852j.get() != null) {
                Toast.makeText((Context) d.this.f6852j.get(), "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38\u6216\u7cfb\u7edf\u9519\u8bef", 0).show();
            }
            d.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) d.this.f6852j.get(), "auth://tauth.qq.com/"))) {
                d.this.f6848f.onComplete(m.c(str));
                d.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                d.this.f6848f.onCancel();
                d.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            d.this.dismiss();
            return true;
        }

        /* synthetic */ a(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private class b extends b.C0118b {
        private b() {
        }

        /* synthetic */ b(d dVar, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class c extends DefaultUiListener {
        String a;

        /* JADX INFO: renamed from: b */
        String f6854b;

        /* JADX INFO: renamed from: c */
        private WeakReference<Context> f6855c;

        /* JADX INFO: renamed from: d */
        private String f6856d;

        /* JADX INFO: renamed from: e */
        private IUiListener f6857e;

        public c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f6855c = new WeakReference<>(context);
            this.f6856d = str;
            this.a = str2;
            this.f6854b = str3;
            this.f6857e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f6857e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f6857e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f6856d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.a, false);
            IUiListener iUiListener = this.f6857e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f6857e = null;
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
            h hVarA = h.a();
            hVarA.a(this.f6856d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f6857e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f6857e = null;
            }
        }

        public void a(String str) {
            try {
                onComplete(m.d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.d$d */
    /* JADX INFO: compiled from: ProGuard */
    private class HandlerC0120d extends Handler {

        /* JADX INFO: renamed from: b */
        private c f6858b;

        public HandlerC0120d(c cVar, Looper looper) {
            super(looper);
            this.f6858b = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f6858b.a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.f6858b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (d.this.f6852j == null || d.this.f6852j.get() == null) {
                    return;
                }
                d.c((Context) d.this.f6852j.get(), (String) message.obj);
                return;
            }
            if (i2 == 4 || i2 != 5 || d.this.f6852j == null || d.this.f6852j.get() == null) {
                return;
            }
            d.d((Context) d.this.f6852j.get(), (String) message.obj);
        }
    }

    public d(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f6852j = new WeakReference<>(context);
        this.f6846d = str2;
        this.f6848f = new c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f6849g = new HandlerC0120d(this.f6848f, context.getMainLooper());
        this.f6847e = iUiListener;
        this.f6853k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f6853k);
    }

    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObjectD = m.d(str);
            jSONObjectD.getInt("action");
            jSONObjectD.getString("msg");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.c, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.f6851i.setVerticalScrollBarEnabled(false);
        this.f6851i.setHorizontalScrollBarEnabled(false);
        this.f6851i.setWebViewClient(new a());
        this.f6851i.setWebChromeClient(this.f6839b);
        this.f6851i.clearFormData();
        WebSettings settings = this.f6851i.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f6851i);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f6852j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f6852j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.a.a(new b(), "sdk_js_if");
        this.f6851i.clearView();
        this.f6851i.loadUrl(this.f6846d);
    }

    private void b() {
        this.f6850h = new com.tencent.open.c.a(this.f6852j.get());
        this.f6850h.setBackgroundColor(1711276032);
        this.f6850h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f6851i = new com.tencent.open.c.b(this.f6852j.get());
        this.f6851i.setBackgroundColor(0);
        this.f6851i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f6851i, 1, new Paint());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f6853k);
        layoutParams.addRule(13, -1);
        this.f6851i.setLayoutParams(layoutParams);
        this.f6850h.addView(this.f6851i);
        this.f6850h.a(this);
        setContentView(this.f6850h);
    }

    @Override // com.tencent.open.c.a.InterfaceC0119a
    public void a(int i2) {
        WeakReference<Context> weakReference = this.f6852j;
        if (weakReference != null && weakReference.get() != null) {
            if (i2 < this.f6853k && 2 == this.f6852j.get().getResources().getConfiguration().orientation) {
                this.f6851i.getLayoutParams().height = i2;
            } else {
                this.f6851i.getLayoutParams().height = this.f6853k;
            }
        }
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.c.a.InterfaceC0119a
    public void a() {
        this.f6851i.getLayoutParams().height = this.f6853k;
        SLog.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.c
    protected void a(String str) {
        SLog.d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.f6851i, str);
        } catch (Exception unused) {
        }
    }

    public static void c(Context context, String str) {
        try {
            JSONObject jSONObjectD = m.d(str);
            int i2 = jSONObjectD.getInt("type");
            String string = jSONObjectD.getString("msg");
            if (i2 == 0) {
                if (f6845c == null) {
                    f6845c = Toast.makeText(context, string, 0);
                } else {
                    f6845c.setView(f6845c.getView());
                    f6845c.setText(string);
                    f6845c.setDuration(0);
                }
                f6845c.show();
                return;
            }
            if (i2 == 1) {
                if (f6845c == null) {
                    f6845c = Toast.makeText(context, string, 1);
                } else {
                    f6845c.setView(f6845c.getView());
                    f6845c.setText(string);
                    f6845c.setDuration(1);
                }
                f6845c.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
