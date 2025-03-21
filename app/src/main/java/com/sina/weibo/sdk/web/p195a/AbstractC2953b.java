package com.sina.weibo.sdk.web.p195a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.C2922b;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.web.InterfaceC2951a;
import com.sina.weibo.sdk.web.p196b.AbstractC2957b;

/* renamed from: com.sina.weibo.sdk.web.a.b */
/* loaded from: classes.dex */
public abstract class AbstractC2953b extends WebViewClient {

    /* renamed from: aA */
    protected AbstractC2957b f9354aA;

    /* renamed from: aB */
    protected WbAuthListener f9355aB;

    /* renamed from: ax */
    protected C2922b f9356ax = C2922b.m8817b();

    /* renamed from: ay */
    protected Activity f9357ay;

    /* renamed from: az */
    protected InterfaceC2951a f9358az;

    public AbstractC2953b(Activity activity, InterfaceC2951a interfaceC2951a, AbstractC2957b abstractC2957b) {
        this.f9357ay = activity;
        this.f9358az = interfaceC2951a;
        this.f9354aA = abstractC2957b;
    }

    /* renamed from: a */
    private void m8896a(int i2, String str) {
        Bundle extras = this.f9357ay.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Intent intent = new Intent(this.f9357ay, (Class<?>) ShareTransActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(extras);
        intent.putExtra("_weibo_resp_errcode", i2);
        intent.putExtra("_weibo_resp_errstr", str);
        this.f9357ay.setResult(-1, intent);
    }

    /* renamed from: m */
    protected final void m8897m(String str) {
        m8896a(0, str);
    }

    /* renamed from: n */
    protected final void m8898n(String str) {
        m8896a(2, str);
    }

    /* renamed from: o */
    protected final void m8899o(String str) {
        m8896a(1, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        InterfaceC2951a interfaceC2951a = this.f9358az;
        if (interfaceC2951a != null) {
            webResourceError.getErrorCode();
            webResourceError.getDescription().toString();
            webResourceRequest.getUrl();
            interfaceC2951a.mo8889p();
        }
    }

    /* renamed from: p */
    public void mo8900p(String str) {
    }

    /* renamed from: q */
    public void mo8894q() {
    }

    /* renamed from: s */
    public boolean mo8895s() {
        return false;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}
