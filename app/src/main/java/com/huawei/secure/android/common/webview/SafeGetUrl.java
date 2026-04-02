package com.huawei.secure.android.common.webview;

import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class SafeGetUrl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5254c = "SafeGetUrl";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f5255d = 200;
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebView f5256b;

    class a implements Runnable {
        final /* synthetic */ CountDownLatch a;

        a(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.f5256b.getUrl());
            this.a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public String getUrlMethod() {
        if (this.f5256b == null) {
            return "";
        }
        if (b.a()) {
            return this.f5256b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            String str = "getUrlMethod: InterruptedException " + e2.getMessage();
        }
        return this.a;
    }

    public WebView getWebView() {
        return this.f5256b;
    }

    public void setUrl(String str) {
        this.a = str;
    }

    public void setWebView(WebView webView) {
        this.f5256b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.f5256b = webView;
    }
}
