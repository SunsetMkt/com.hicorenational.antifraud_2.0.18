package com.sina.weibo.sdk.web.p195a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.p194b.C2927e;
import com.sina.weibo.sdk.web.InterfaceC2951a;
import com.sina.weibo.sdk.web.p196b.AbstractC2957b;

/* renamed from: com.sina.weibo.sdk.web.a.a */
/* loaded from: classes.dex */
public final class C2952a extends AbstractC2953b {
    public C2952a(Activity activity, InterfaceC2951a interfaceC2951a, AbstractC2957b abstractC2957b) {
        super(activity, interfaceC2951a, abstractC2957b);
    }

    /* renamed from: l */
    private boolean m8893l(String str) {
        Bundle m8844g;
        AuthInfo m8891a = this.f9354aA.m8905u().m8891a();
        return (m8891a == null || !str.startsWith(m8891a.getRedirectUrl()) || (m8844g = C2927e.m8844g(str)) == null || TextUtils.isEmpty(m8844g.getString("access_token"))) ? false : true;
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        AuthInfo m8891a = this.f9354aA.m8905u().m8891a();
        if (m8891a == null || !str.startsWith(m8891a.getRedirectUrl())) {
            return;
        }
        String m8892r = this.f9354aA.m8905u().m8892r();
        if (!TextUtils.isEmpty(m8892r)) {
            this.f9355aB = this.f9356ax.m8818a(m8892r);
            if (this.f9355aB != null) {
                Bundle m8844g = C2927e.m8844g(str);
                if (m8844g != null) {
                    String string = m8844g.getString("error");
                    String string2 = m8844g.getString("error_code");
                    String string3 = m8844g.getString("error_description");
                    if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(m8844g);
                        AccessTokenHelper.writeAccessToken(this.f9357ay, parseAccessToken);
                        this.f9355aB.onComplete(parseAccessToken);
                    } else {
                        this.f9355aB.onError(new UiError(-1, string2, string3));
                    }
                } else {
                    this.f9355aB.onError(new UiError(-1, "bundle is null", "parse url error"));
                }
                this.f9356ax.m8820b(m8892r);
            }
        }
        InterfaceC2951a interfaceC2951a = this.f9358az;
        if (interfaceC2951a != null) {
            interfaceC2951a.mo8890q();
        }
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b
    /* renamed from: q */
    public final void mo8894q() {
        super.mo8894q();
        String m8892r = this.f9354aA.m8905u().m8892r();
        if (!TextUtils.isEmpty(m8892r)) {
            this.f9355aB = this.f9356ax.m8818a(m8892r);
            WbAuthListener wbAuthListener = this.f9355aB;
            if (wbAuthListener != null) {
                wbAuthListener.onCancel();
            }
            this.f9356ax.m8820b(m8892r);
        }
        InterfaceC2951a interfaceC2951a = this.f9358az;
        if (interfaceC2951a != null) {
            interfaceC2951a.mo8890q();
        }
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b
    /* renamed from: s */
    public final boolean mo8895s() {
        mo8894q();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT >= 21) {
            return m8893l(webResourceRequest.getUrl().toString());
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return m8893l(str);
    }
}
