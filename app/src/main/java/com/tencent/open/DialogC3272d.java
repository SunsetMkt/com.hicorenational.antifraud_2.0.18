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
import com.tencent.open.C3258b;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3266h;
import com.tencent.open.p213c.C3268a;
import com.tencent.open.p213c.C3269b;
import com.tencent.open.utils.C3292j;
import com.tencent.open.utils.C3295m;
import com.tencent.open.web.C3298a;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.d */
/* loaded from: classes2.dex */
public class DialogC3272d extends AbstractDialogC3267c implements C3268a.a {

    /* renamed from: c */
    static Toast f11210c;

    /* renamed from: d */
    private String f11211d;

    /* renamed from: e */
    private IUiListener f11212e;

    /* renamed from: f */
    private c f11213f;

    /* renamed from: g */
    private Handler f11214g;

    /* renamed from: h */
    private C3268a f11215h;

    /* renamed from: i */
    private C3269b f11216i;

    /* renamed from: j */
    private WeakReference<Context> f11217j;

    /* renamed from: k */
    private int f11218k;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$a */
    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            DialogC3272d.this.f11216i.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.m10506v("openSDK_LOG.PKDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            DialogC3272d.this.f11213f.onError(new UiError(i2, str, str2));
            if (DialogC3272d.this.f11217j != null && DialogC3272d.this.f11217j.get() != null) {
                Toast.makeText((Context) DialogC3272d.this.f11217j.get(), "网络连接异常或系统错误", 0).show();
            }
            DialogC3272d.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.m10506v("openSDK_LOG.PKDialog", "Redirect URL: " + str);
            if (str.startsWith(C3292j.m10626a().m10627a((Context) DialogC3272d.this.f11217j.get(), "auth://tauth.qq.com/"))) {
                DialogC3272d.this.f11213f.onComplete(C3295m.m10692c(str));
                DialogC3272d.this.dismiss();
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                DialogC3272d.this.f11213f.onCancel();
                DialogC3272d.this.dismiss();
                return true;
            }
            if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            }
            DialogC3272d.this.dismiss();
            return true;
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$b */
    private class b extends C3258b.b {
        private b() {
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$c */
    private static class c extends DefaultUiListener {

        /* renamed from: a */
        String f11221a;

        /* renamed from: b */
        String f11222b;

        /* renamed from: c */
        private WeakReference<Context> f11223c;

        /* renamed from: d */
        private String f11224d;

        /* renamed from: e */
        private IUiListener f11225e;

        public c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f11223c = new WeakReference<>(context);
            this.f11224d = str;
            this.f11221a = str2;
            this.f11222b = str3;
            this.f11225e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f11225e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f11225e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C3266h.m10468a().m10472a(this.f11224d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f11221a, false);
            IUiListener iUiListener = this.f11225e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f11225e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f11221a;
            } else {
                str = this.f11221a;
            }
            C3266h m10468a = C3266h.m10468a();
            m10468a.m10472a(this.f11224d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f11225e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f11225e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m10494a(String str) {
            try {
                onComplete(C3295m.m10696d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.d$d */
    private class d extends Handler {

        /* renamed from: b */
        private c f11227b;

        public d(c cVar, Looper looper) {
            super(looper);
            this.f11227b = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.m10498d("openSDK_LOG.PKDialog", "msg = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f11227b.m10494a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.f11227b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (DialogC3272d.this.f11217j == null || DialogC3272d.this.f11217j.get() == null) {
                    return;
                }
                DialogC3272d.m10491c((Context) DialogC3272d.this.f11217j.get(), (String) message.obj);
                return;
            }
            if (i2 == 4 || i2 != 5 || DialogC3272d.this.f11217j == null || DialogC3272d.this.f11217j.get() == null) {
                return;
            }
            DialogC3272d.m10492d((Context) DialogC3272d.this.f11217j.get(), (String) message.obj);
        }
    }

    public DialogC3272d(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f11217j = new WeakReference<>(context);
        this.f11211d = str2;
        this.f11213f = new c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f11214g = new d(this.f11213f, context.getMainLooper());
        this.f11212e = iUiListener;
        this.f11218k = Math.round(context.getResources().getDisplayMetrics().density * 185.0f);
        SLog.m10500e("openSDK_LOG.PKDialog", "density=" + context.getResources().getDisplayMetrics().density + "; webviewHeight=" + this.f11218k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m10492d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject m10696d = C3295m.m10696d(str);
            m10696d.getInt("action");
            m10696d.getString("msg");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.tencent.open.AbstractDialogC3267c, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        m10487b();
        m10490c();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: c */
    private void m10490c() {
        this.f11216i.setVerticalScrollBarEnabled(false);
        this.f11216i.setHorizontalScrollBarEnabled(false);
        this.f11216i.setWebViewClient(new a());
        this.f11216i.setWebChromeClient(this.f11201b);
        this.f11216i.clearFormData();
        WebSettings settings = this.f11216i.getSettings();
        if (settings == null) {
            return;
        }
        C3298a.m10720a(this.f11216i);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f11217j;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f11217j.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f11200a.m10429a(new b(), "sdk_js_if");
        this.f11216i.clearView();
        this.f11216i.loadUrl(this.f11211d);
    }

    /* renamed from: b */
    private void m10487b() {
        this.f11215h = new C3268a(this.f11217j.get());
        this.f11215h.setBackgroundColor(1711276032);
        this.f11215h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f11216i = new C3269b(this.f11217j.get());
        this.f11216i.setBackgroundColor(0);
        this.f11216i.setBackgroundDrawable(null);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(this.f11216i, 1, new Paint());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f11218k);
        layoutParams.addRule(13, -1);
        this.f11216i.setLayoutParams(layoutParams);
        this.f11215h.addView(this.f11216i);
        this.f11215h.m10479a(this);
        setContentView(this.f11215h);
    }

    @Override // com.tencent.open.p213c.C3268a.a
    /* renamed from: a */
    public void mo10481a(int i2) {
        WeakReference<Context> weakReference = this.f11217j;
        if (weakReference != null && weakReference.get() != null) {
            if (i2 < this.f11218k && 2 == this.f11217j.get().getResources().getConfiguration().orientation) {
                this.f11216i.getLayoutParams().height = i2;
            } else {
                this.f11216i.getLayoutParams().height = this.f11218k;
            }
        }
        SLog.m10500e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    @Override // com.tencent.open.p213c.C3268a.a
    /* renamed from: a */
    public void mo10480a() {
        this.f11216i.getLayoutParams().height = this.f11218k;
        SLog.m10500e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    @Override // com.tencent.open.AbstractDialogC3267c
    /* renamed from: a */
    protected void mo10395a(String str) {
        SLog.m10498d("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.f11200a.mo10431a(this.f11216i, str);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m10491c(Context context, String str) {
        try {
            JSONObject m10696d = C3295m.m10696d(str);
            int i2 = m10696d.getInt("type");
            String string = m10696d.getString("msg");
            if (i2 == 0) {
                if (f11210c == null) {
                    f11210c = Toast.makeText(context, string, 0);
                } else {
                    f11210c.setView(f11210c.getView());
                    f11210c.setText(string);
                    f11210c.setDuration(0);
                }
                f11210c.show();
                return;
            }
            if (i2 == 1) {
                if (f11210c == null) {
                    f11210c = Toast.makeText(context, string, 1);
                } else {
                    f11210c.setView(f11210c.getView());
                    f11210c.setText(string);
                    f11210c.setDuration(1);
                }
                f11210c.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
