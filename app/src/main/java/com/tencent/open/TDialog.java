package com.tencent.open;

import android.R;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.C3258b;
import com.tencent.open.log.SLog;
import com.tencent.open.p212b.C3266h;
import com.tencent.open.p213c.C3269b;
import com.tencent.open.p213c.C3270c;
import com.tencent.open.utils.C3292j;
import com.tencent.open.utils.C3295m;
import com.tencent.open.web.C3298a;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p014u.C0052a;
import util.C7316r1;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class TDialog extends AbstractDialogC3267c {

    /* renamed from: c */
    static final FrameLayout.LayoutParams f11115c = new FrameLayout.LayoutParams(-1, -1);

    /* renamed from: d */
    static Toast f11116d = null;

    /* renamed from: f */
    private static WeakReference<ProgressDialog> f11117f;

    /* renamed from: e */
    private WeakReference<Context> f11118e;

    /* renamed from: g */
    private String f11119g;

    /* renamed from: h */
    private OnTimeListener f11120h;

    /* renamed from: i */
    private IUiListener f11121i;

    /* renamed from: j */
    private FrameLayout f11122j;

    /* renamed from: k */
    private C3269b f11123k;

    /* renamed from: l */
    private Handler f11124l;

    /* renamed from: m */
    private boolean f11125m;

    /* renamed from: n */
    private QQToken f11126n;

    /* compiled from: ProGuard */
    private class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f11123k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.m10506v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TDialog.this.f11120h.onError(new UiError(i2, str, str2));
            if (TDialog.this.f11118e != null && TDialog.this.f11118e.get() != null) {
                Toast.makeText((Context) TDialog.this.f11118e.get(), "网络连接异常或系统错误", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.m10506v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(C3292j.m10626a().m10627a((Context) TDialog.this.f11118e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f11120h.onComplete(C3295m.m10692c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f11120h.onCancel();
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CLOSE_URI)) {
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(C7316r1.f25586d)) {
                return str.startsWith("auth://progress");
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                intent.addFlags(CommonNetImpl.FLAG_AUTH);
                if (TDialog.this.f11118e != null && TDialog.this.f11118e.get() != null) {
                    ((Context) TDialog.this.f11118e.get()).startActivity(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }
    }

    /* compiled from: ProGuard */
    private class JsListener extends C3258b.b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.m10498d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.m10500e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f11124l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.m10500e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(CommonNetImpl.CANCEL);
        }

        public void onCancelInvite() {
            SLog.m10500e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f11124l.obtainMessage(1, str).sendToTarget();
            SLog.m10500e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f11124l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f11124l.obtainMessage(3, str).sendToTarget();
        }
    }

    /* compiled from: ProGuard */
    private static class OnTimeListener extends DefaultUiListener {

        /* renamed from: a */
        String f11130a;

        /* renamed from: b */
        String f11131b;

        /* renamed from: c */
        private WeakReference<Context> f11132c;

        /* renamed from: d */
        private String f11133d;

        /* renamed from: e */
        private IUiListener f11134e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f11132c = new WeakReference<>(context);
            this.f11133d = str;
            this.f11130a = str2;
            this.f11131b = str3;
            this.f11134e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f11134e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f11134e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            C3266h.m10468a().m10472a(this.f11133d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.f11130a, false);
            IUiListener iUiListener = this.f11134e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f11134e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            if (uiError.errorMessage != null) {
                str = uiError.errorMessage + this.f11130a;
            } else {
                str = this.f11130a;
            }
            C3266h m10468a = C3266h.m10468a();
            m10468a.m10472a(this.f11133d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f11134e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f11134e = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m10397a(String str) {
            try {
                onComplete(C3295m.m10696d(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }
    }

    /* compiled from: ProGuard */
    private class THandler extends Handler {

        /* renamed from: b */
        private OnTimeListener f11136b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f11136b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.m10498d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f11136b.m10397a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.f11136b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (TDialog.this.f11118e == null || TDialog.this.f11118e.get() == null) {
                    return;
                }
                TDialog.m10392c((Context) TDialog.this.f11118e.get(), (String) message.obj);
                return;
            }
            if (i2 == 4 || i2 != 5 || TDialog.this.f11118e == null || TDialog.this.f11118e.get() == null) {
                return;
            }
            TDialog.m10394d((Context) TDialog.this.f11118e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f11125m = false;
        this.f11126n = null;
        this.f11118e = new WeakReference<>(context);
        this.f11119g = str2;
        this.f11120h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f11124l = new THandler(this.f11120h, context.getMainLooper());
        this.f11121i = iUiListener;
        this.f11126n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f11120h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.AbstractDialogC3267c, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        C3249a.m10399a(getWindow());
        m10386a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            @Override // java.lang.Runnable
            public void run() {
                View decorView;
                View childAt;
                Window window = TDialog.this.getWindow();
                if (window == null || (decorView = window.getDecorView()) == null || (childAt = ((ViewGroup) decorView).getChildAt(0)) == null) {
                    return;
                }
                childAt.setPadding(0, 0, 0, 0);
            }
        });
        m10389b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m10392c(Context context, String str) {
        try {
            JSONObject m10696d = C3295m.m10696d(str);
            int i2 = m10696d.getInt("type");
            String string = m10696d.getString("msg");
            if (i2 == 0) {
                if (f11116d == null) {
                    f11116d = Toast.makeText(context, string, 0);
                } else {
                    f11116d.setView(f11116d.getView());
                    f11116d.setText(string);
                    f11116d.setDuration(0);
                }
                f11116d.show();
                return;
            }
            if (i2 == 1) {
                if (f11116d == null) {
                    f11116d = Toast.makeText(context, string, 1);
                } else {
                    f11116d.setView(f11116d.getView());
                    f11116d.setText(string);
                    f11116d.setDuration(1);
                }
                f11116d.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m10394d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject m10696d = C3295m.m10696d(str);
            int i2 = m10696d.getInt("action");
            String string = m10696d.getString("msg");
            if (i2 == 1) {
                if (f11117f != null && f11117f.get() != null) {
                    f11117f.get().setMessage(string);
                    if (!f11117f.get().isShowing()) {
                        f11117f.get().show();
                    }
                }
                ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setMessage(string);
                f11117f = new WeakReference<>(progressDialog);
                progressDialog.show();
            } else if (i2 == 0) {
                if (f11117f == null) {
                    return;
                }
                if (f11117f.get() != null && f11117f.get().isShowing()) {
                    f11117f.get().dismiss();
                    f11117f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m10386a() {
        try {
            new TextView(this.f11118e.get()).setText(C0052a.f162n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f11123k = new C3269b(this.f11118e.get());
            this.f11123k.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            this.f11122j = new C3270c(this.f11118e.get());
            this.f11122j.setLayoutParams(layoutParams);
            this.f11122j.setBackgroundColor(-1);
            this.f11122j.addView(this.f11123k);
            setContentView(this.f11122j);
        } catch (Throwable th) {
            SLog.m10501e("openSDK_LOG.TDialog", "onCreateView exception", th);
            C3249a.m10398a(this, this.f11124l);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: b */
    private void m10389b() {
        this.f11123k.setVerticalScrollBarEnabled(false);
        this.f11123k.setHorizontalScrollBarEnabled(false);
        this.f11123k.setWebViewClient(new FbWebViewClient());
        this.f11123k.setWebChromeClient(this.f11201b);
        this.f11123k.clearFormData();
        WebSettings settings = this.f11123k.getSettings();
        if (settings == null) {
            return;
        }
        C3298a.m10720a(this.f11123k);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f11118e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f11118e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.f11200a.m10429a(new JsListener(), "sdk_js_if");
        this.f11123k.loadUrl(this.f11119g);
        this.f11123k.setLayoutParams(f11115c);
        this.f11123k.setVisibility(4);
    }

    @Override // com.tencent.open.AbstractDialogC3267c
    /* renamed from: a */
    protected void mo10395a(String str) {
        SLog.m10498d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.f11200a.mo10431a(this.f11123k, str);
        } catch (Exception unused) {
        }
    }
}
