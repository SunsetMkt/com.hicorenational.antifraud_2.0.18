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
import com.tencent.open.b;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import util.x1;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class TDialog extends c {

    /* JADX INFO: renamed from: c */
    static final FrameLayout.LayoutParams f6781c = new FrameLayout.LayoutParams(-1, -1);

    /* JADX INFO: renamed from: d */
    static Toast f6782d = null;

    /* JADX INFO: renamed from: f */
    private static WeakReference<ProgressDialog> f6783f;

    /* JADX INFO: renamed from: e */
    private WeakReference<Context> f6784e;

    /* JADX INFO: renamed from: g */
    private String f6785g;

    /* JADX INFO: renamed from: h */
    private OnTimeListener f6786h;

    /* JADX INFO: renamed from: i */
    private IUiListener f6787i;

    /* JADX INFO: renamed from: j */
    private FrameLayout f6788j;

    /* JADX INFO: renamed from: k */
    private com.tencent.open.c.b f6789k;

    /* JADX INFO: renamed from: l */
    private Handler f6790l;

    /* JADX INFO: renamed from: m */
    private boolean f6791m;

    /* JADX INFO: renamed from: n */
    private QQToken f6792n;

    /* JADX INFO: renamed from: com.tencent.open.TDialog$1 */
    /* JADX INFO: compiled from: ProGuard */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

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
    }

    /* JADX INFO: compiled from: ProGuard */
    private class FbWebViewClient extends WebViewClient {
        private FbWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TDialog.this.f6789k.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            SLog.v("openSDK_LOG.TDialog", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TDialog.this.f6786h.onError(new UiError(i2, str, str2));
            if (TDialog.this.f6784e != null && TDialog.this.f6784e.get() != null) {
                Toast.makeText((Context) TDialog.this.f6784e.get(), "\u7f51\u7edc\u8fde\u63a5\u5f02\u5e38\u6216\u7cfb\u7edf\u9519\u8bef", 0).show();
            }
            TDialog.this.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            SLog.v("openSDK_LOG.TDialog", "Redirect URL: " + str);
            if (str.startsWith(j.a().a((Context) TDialog.this.f6784e.get(), "auth://tauth.qq.com/"))) {
                TDialog.this.f6786h.onComplete(m.c(str));
                if (TDialog.this.isShowing()) {
                    TDialog.this.dismiss();
                }
                return true;
            }
            if (str.startsWith(Constants.CANCEL_URI)) {
                TDialog.this.f6786h.onCancel();
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
            if (!str.startsWith(Constants.DOWNLOAD_URI) && !str.endsWith(x1.f15111d)) {
                return str.startsWith("auth://progress");
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(11))) : Uri.parse(Uri.decode(str)));
                intent.addFlags(CommonNetImpl.FLAG_AUTH);
                if (TDialog.this.f6784e != null && TDialog.this.f6784e.get() != null) {
                    ((Context) TDialog.this.f6784e.get()).startActivity(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        }

        /* synthetic */ FbWebViewClient(TDialog tDialog, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private class JsListener extends b.C0118b {
        private JsListener() {
        }

        public void onAddShare(String str) {
            SLog.d("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onCancel(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancel --msg = " + str);
            TDialog.this.f6790l.obtainMessage(2, str).sendToTarget();
            TDialog.this.dismiss();
        }

        public void onCancelAddShare(String str) {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelAddShare" + str);
            onCancel(CommonNetImpl.CANCEL);
        }

        public void onCancelInvite() {
            SLog.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onComplete(String str) {
            TDialog.this.f6790l.obtainMessage(1, str).sendToTarget();
            SLog.e("openSDK_LOG.TDialog", "JsListener onComplete" + str);
            TDialog.this.dismiss();
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onLoad(String str) {
            TDialog.this.f6790l.obtainMessage(4, str).sendToTarget();
        }

        public void showMsg(String str) {
            TDialog.this.f6790l.obtainMessage(3, str).sendToTarget();
        }

        /* synthetic */ JsListener(TDialog tDialog, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: ProGuard */
    private static class OnTimeListener extends DefaultUiListener {
        String a;

        /* JADX INFO: renamed from: b */
        String f6793b;

        /* JADX INFO: renamed from: c */
        private WeakReference<Context> f6794c;

        /* JADX INFO: renamed from: d */
        private String f6795d;

        /* JADX INFO: renamed from: e */
        private IUiListener f6796e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.f6794c = new WeakReference<>(context);
            this.f6795d = str;
            this.a = str2;
            this.f6793b = str3;
            this.f6796e = iUiListener;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener iUiListener = this.f6796e;
            if (iUiListener != null) {
                iUiListener.onCancel();
                this.f6796e = null;
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            h.a().a(this.f6795d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, jSONObject.optInt("ret", -6), this.a, false);
            IUiListener iUiListener = this.f6796e;
            if (iUiListener != null) {
                iUiListener.onComplete(jSONObject);
                this.f6796e = null;
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
            hVarA.a(this.f6795d + "_H5", SystemClock.elapsedRealtime(), 0L, 0L, uiError.errorCode, str, false);
            IUiListener iUiListener = this.f6796e;
            if (iUiListener != null) {
                iUiListener.onError(uiError);
                this.f6796e = null;
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

    /* JADX INFO: compiled from: ProGuard */
    private class THandler extends Handler {

        /* JADX INFO: renamed from: b */
        private OnTimeListener f6797b;

        public THandler(OnTimeListener onTimeListener, Looper looper) {
            super(looper);
            this.f6797b = onTimeListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SLog.d("openSDK_LOG.TDialog", "--handleMessage--msg.WHAT = " + message.what);
            int i2 = message.what;
            if (i2 == 1) {
                this.f6797b.a((String) message.obj);
                return;
            }
            if (i2 == 2) {
                this.f6797b.onCancel();
                return;
            }
            if (i2 == 3) {
                if (TDialog.this.f6784e == null || TDialog.this.f6784e.get() == null) {
                    return;
                }
                TDialog.c((Context) TDialog.this.f6784e.get(), (String) message.obj);
                return;
            }
            if (i2 == 4 || i2 != 5 || TDialog.this.f6784e == null || TDialog.this.f6784e.get() == null) {
                return;
            }
            TDialog.d((Context) TDialog.this.f6784e.get(), (String) message.obj);
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        this.f6791m = false;
        this.f6792n = null;
        this.f6784e = new WeakReference<>(context);
        this.f6785g = str2;
        this.f6786h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.f6790l = new THandler(this.f6786h, context.getMainLooper());
        this.f6787i = iUiListener;
        this.f6792n = qQToken;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        OnTimeListener onTimeListener = this.f6786h;
        if (onTimeListener != null) {
            onTimeListener.onCancel();
        }
        super.onBackPressed();
    }

    @Override // com.tencent.open.c, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a.a(getWindow());
        a();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.open.TDialog.1
            AnonymousClass1() {
            }

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
        b();
    }

    public static void c(Context context, String str) {
        try {
            JSONObject jSONObjectD = m.d(str);
            int i2 = jSONObjectD.getInt("type");
            String string = jSONObjectD.getString("msg");
            if (i2 == 0) {
                if (f6782d == null) {
                    f6782d = Toast.makeText(context, string, 0);
                } else {
                    f6782d.setView(f6782d.getView());
                    f6782d.setText(string);
                    f6782d.setDuration(0);
                }
                f6782d.show();
                return;
            }
            if (i2 == 1) {
                if (f6782d == null) {
                    f6782d = Toast.makeText(context, string, 1);
                } else {
                    f6782d.setView(f6782d.getView());
                    f6782d.setText(string);
                    f6782d.setDuration(1);
                }
                f6782d.show();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void d(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            JSONObject jSONObjectD = m.d(str);
            int i2 = jSONObjectD.getInt("action");
            String string = jSONObjectD.getString("msg");
            if (i2 == 1) {
                if (f6783f == null || f6783f.get() == null) {
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(string);
                    f6783f = new WeakReference<>(progressDialog);
                    progressDialog.show();
                } else {
                    f6783f.get().setMessage(string);
                    if (!f6783f.get().isShowing()) {
                        f6783f.get().show();
                    }
                }
            } else if (i2 == 0) {
                if (f6783f == null) {
                    return;
                }
                if (f6783f.get() != null && f6783f.get().isShowing()) {
                    f6783f.get().dismiss();
                    f6783f = null;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        try {
            new TextView(this.f6784e.get()).setText(b.a.u.a.f1912n);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f6789k = new com.tencent.open.c.b(this.f6784e.get());
            this.f6789k.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            this.f6788j = new com.tencent.open.c.c(this.f6784e.get());
            this.f6788j.setLayoutParams(layoutParams);
            this.f6788j.setBackgroundColor(-1);
            this.f6788j.addView(this.f6789k);
            setContentView(this.f6788j);
        } catch (Throwable th) {
            SLog.e("openSDK_LOG.TDialog", "onCreateView exception", th);
            a.a(this, this.f6790l);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.f6789k.setVerticalScrollBarEnabled(false);
        this.f6789k.setHorizontalScrollBarEnabled(false);
        this.f6789k.setWebViewClient(new FbWebViewClient());
        this.f6789k.setWebChromeClient(this.f6839b);
        this.f6789k.clearFormData();
        WebSettings settings = this.f6789k.getSettings();
        if (settings == null) {
            return;
        }
        com.tencent.open.web.a.a(this.f6789k);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        WeakReference<Context> weakReference = this.f6784e;
        if (weakReference != null && weakReference.get() != null) {
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(this.f6784e.get().getApplicationContext().getDir("databases", 0).getPath());
        }
        settings.setDomStorageEnabled(true);
        this.a.a(new JsListener(), "sdk_js_if");
        this.f6789k.loadUrl(this.f6785g);
        this.f6789k.setLayoutParams(f6781c);
        this.f6789k.setVisibility(4);
    }

    @Override // com.tencent.open.c
    protected void a(String str) {
        SLog.d("openSDK_LOG.TDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.f6789k, str);
        } catch (Exception unused) {
        }
    }
}
