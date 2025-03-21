package com.sina.weibo.sdk.web.p195a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.p194b.C2927e;
import com.sina.weibo.sdk.web.InterfaceC2951a;
import com.sina.weibo.sdk.web.p196b.AbstractC2957b;

/* renamed from: com.sina.weibo.sdk.web.a.d */
/* loaded from: classes.dex */
public final class C2955d extends AbstractC2953b {
    public C2955d(Activity activity, InterfaceC2951a interfaceC2951a, AbstractC2957b abstractC2957b) {
        super(activity, interfaceC2951a, abstractC2957b);
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b
    /* renamed from: p */
    public final void mo8900p(String str) {
        m8898n(str);
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b
    /* renamed from: q */
    public final void mo8894q() {
        m8899o("cancel share!!!");
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

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle m8845h = C2927e.m8845h(str);
        if (m8845h != null) {
            String string = m8845h.getString("code");
            String string2 = m8845h.getString("msg");
            if ("0".equals(string)) {
                m8897m(string2);
            } else {
                m8898n(string2);
            }
        } else {
            m8898n("bundle is null!!!");
        }
        InterfaceC2951a interfaceC2951a = this.f9358az;
        if (interfaceC2951a == null) {
            return true;
        }
        interfaceC2951a.mo8890q();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.p195a.AbstractC2953b, android.webkit.WebViewClient
    @TargetApi(21)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (TextUtils.isEmpty(uri) || !uri.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        Bundle m8845h = C2927e.m8845h(uri);
        if (m8845h != null) {
            String string = m8845h.getString("code");
            String string2 = m8845h.getString("msg");
            if (TextUtils.isEmpty(string)) {
                m8899o("code is null!!!");
            } else if ("0".equals(string)) {
                m8897m(string2);
            } else {
                m8898n(string2);
            }
        } else {
            m8898n("bundle is null!!!");
        }
        InterfaceC2951a interfaceC2951a = this.f9358az;
        if (interfaceC2951a == null) {
            return true;
        }
        interfaceC2951a.mo8890q();
        return true;
    }
}
