package com.sina.weibo.sdk.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.p194b.C2927e;
import com.sina.weibo.sdk.web.p195a.AbstractC2953b;
import com.sina.weibo.sdk.web.p195a.C2952a;
import com.sina.weibo.sdk.web.p195a.C2954c;
import com.sina.weibo.sdk.web.p195a.C2955d;
import com.sina.weibo.sdk.web.p196b.AbstractC2957b;
import com.sina.weibo.sdk.web.p196b.C2956a;
import com.sina.weibo.sdk.web.p196b.C2958c;
import com.sina.weibo.sdk.web.p196b.C2959d;

/* loaded from: classes.dex */
public class WebActivity extends Activity implements InterfaceC2951a {

    /* renamed from: am */
    private LinearLayout f9339am;

    /* renamed from: an */
    private TextView f9340an;

    /* renamed from: ao */
    private TextView f9341ao;

    /* renamed from: ap */
    private WebView f9342ap;

    /* renamed from: aq */
    private ProgressBar f9343aq;

    /* renamed from: ar */
    private AbstractC2957b f9344ar;

    /* renamed from: as */
    private AbstractC2953b f9345as;

    /* renamed from: at */
    private String f9346at;

    /* renamed from: d */
    static /* synthetic */ void m8885d(WebActivity webActivity) {
        webActivity.f9339am.setVisibility(8);
        webActivity.f9342ap.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static boolean m8887j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://service.weibo.com/share/mobilesdk.php") || str.startsWith("https://open.weibo.cn/oauth2/authorize?");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        this.f9340an = new TextView(this);
        this.f9340an.setText("关闭");
        this.f9340an.setTextSize(17.0f);
        this.f9340an.setTextColor(-32256);
        this.f9340an.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.web.WebActivity.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebActivity.this.f9345as.mo8894q();
            }
        });
        this.f9341ao = new TextView(this);
        this.f9341ao.setTextSize(18.0f);
        this.f9341ao.setTextColor(-11382190);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.f9340an.setPadding(C2927e.m8841a(10, this), 0, C2927e.m8841a(10, this), 0);
        layoutParams2.addRule(13);
        relativeLayout2.addView(this.f9340an, layoutParams);
        relativeLayout2.addView(this.f9341ao, layoutParams2);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, C2927e.m8841a(55, this)));
        this.f9342ap = new WebView(getApplicationContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = C2927e.m8841a(55, this);
        relativeLayout.addView(this.f9342ap, layoutParams3);
        this.f9343aq = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, C2927e.m8841a(3, this));
        layoutParams4.topMargin = C2927e.m8841a(55, this);
        relativeLayout.addView(this.f9343aq, layoutParams4);
        View view = new View(this);
        view.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", "drawable", getPackageName()));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, C2927e.m8841a(3, this));
        layoutParams5.topMargin = C2927e.m8841a(55, this);
        relativeLayout.addView(view, layoutParams5);
        this.f9339am = new LinearLayout(this);
        this.f9339am.setOrientation(1);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", "drawable", getPackageName()));
        this.f9339am.addView(imageView);
        TextView textView = new TextView(this);
        textView.setTextSize(14.0f);
        textView.setTextColor(-4342339);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = C2927e.m8841a(18, this);
        layoutParams6.bottomMargin = C2927e.m8841a(20, this);
        this.f9339am.addView(textView, layoutParams6);
        textView.setText("网络出错啦，请点击按钮重新加载");
        Button button = new Button(this);
        button.setTextSize(16.0f);
        button.setTextColor(-8882056);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(C2927e.m8841a(142, this), C2927e.m8841a(46, this));
        layoutParams7.gravity = 17;
        this.f9339am.addView(button, layoutParams7);
        button.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", "drawable", getPackageName()));
        button.setText("重新加载");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.web.WebActivity.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WebActivity.m8885d(WebActivity.this);
                WebActivity.this.f9342ap.reload();
            }
        });
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        relativeLayout.addView(this.f9339am, layoutParams8);
        this.f9339am.setVisibility(8);
        this.f9342ap.setWebChromeClient(new WebChromeClient() { // from class: com.sina.weibo.sdk.web.WebActivity.4
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView, int i2) {
                super.onProgressChanged(webView, i2);
                WebActivity.this.f9343aq.setProgress(i2);
                if (i2 == 100) {
                    WebActivity.this.f9343aq.setVisibility(4);
                } else {
                    WebActivity.this.f9343aq.setVisibility(0);
                }
            }

            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
            }
        });
        setContentView(relativeLayout);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("web_type", -1);
        if (intExtra == -1) {
            finish();
            return;
        }
        if (intExtra == 1) {
            this.f9346at = "微博分享";
            this.f9344ar = new C2959d(this);
            this.f9345as = new C2955d(this, this, this.f9344ar);
        } else if (intExtra == 2) {
            this.f9346at = "微博登录";
            this.f9344ar = new C2956a();
            this.f9345as = new C2952a(this, this, this.f9344ar);
        } else if (intExtra == 3) {
            this.f9344ar = new C2958c();
            this.f9345as = new C2954c(this, this.f9344ar);
        }
        this.f9342ap.setWebViewClient(this.f9345as);
        this.f9344ar.readFromBundle(extras);
        WebSettings settings = this.f9342ap.getSettings();
        settings.setSavePassword(false);
        settings.setAllowContentAccess(false);
        settings.setUserAgentString(C2927e.m8847o());
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        this.f9342ap.requestFocus();
        this.f9342ap.setScrollBarStyle(0);
        m8882a(this.f9342ap, "searchBoxJavaBridge_");
        m8882a(this.f9342ap, "accessibility");
        m8882a(this.f9342ap, "accessibilityTraversal");
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        if (this.f9344ar.mo8904t()) {
            this.f9344ar.mo8903a(new AbstractC2957b.a() { // from class: com.sina.weibo.sdk.web.WebActivity.1
                @Override // com.sina.weibo.sdk.web.p196b.AbstractC2957b.a
                public final void onComplete() {
                    String url = WebActivity.this.f9344ar.getUrl();
                    if (TextUtils.isEmpty(url) || !WebActivity.m8887j(url)) {
                        return;
                    }
                    WebActivity.this.f9342ap.loadUrl(url);
                }

                @Override // com.sina.weibo.sdk.web.p196b.AbstractC2957b.a
                public final void onError(String str) {
                    WebActivity.this.f9345as.mo8900p(str);
                }
            });
        } else {
            String url = this.f9344ar.getUrl();
            if (!TextUtils.isEmpty(url) && m8887j(url)) {
                this.f9342ap.loadUrl(url);
            }
        }
        TextView textView2 = this.f9341ao;
        if (textView2 != null) {
            textView2.setText(this.f9346at);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.f9345as.mo8895s()) {
                return true;
            }
            if (this.f9342ap.canGoBack()) {
                this.f9342ap.goBack();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.sina.weibo.sdk.web.InterfaceC2951a
    /* renamed from: p */
    public final void mo8889p() {
        this.f9339am.setVisibility(0);
        this.f9342ap.setVisibility(8);
    }

    @Override // com.sina.weibo.sdk.web.InterfaceC2951a
    /* renamed from: q */
    public final void mo8890q() {
        finish();
    }

    /* renamed from: a */
    private static void m8882a(WebView webView, String str) {
        try {
            WebView.class.getDeclaredMethod("removeJavascriptInterface", String.class).invoke(webView, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
