package com.huawei.secure.android.common.webview;

import android.webkit.WebView;
import com.huawei.secure.android.common.util.C2570b;
import com.huawei.secure.android.common.util.C2571c;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public class SafeGetUrl {

    /* renamed from: c */
    private static final String f8302c = "SafeGetUrl";

    /* renamed from: d */
    private static final long f8303d = 200;

    /* renamed from: a */
    private String f8304a;

    /* renamed from: b */
    private WebView f8305b;

    /* renamed from: com.huawei.secure.android.common.webview.SafeGetUrl$a */
    class RunnableC2573a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f8306a;

        RunnableC2573a(CountDownLatch countDownLatch) {
            this.f8306a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.f8305b.getUrl());
            this.f8306a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public String getUrlMethod() {
        if (this.f8305b == null) {
            return "";
        }
        if (C2570b.m8072a()) {
            return this.f8305b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        C2571c.m8073a(new RunnableC2573a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            String str = "getUrlMethod: InterruptedException " + e2.getMessage();
        }
        return this.f8304a;
    }

    public WebView getWebView() {
        return this.f8305b;
    }

    public void setUrl(String str) {
        this.f8304a = str;
    }

    public void setWebView(WebView webView) {
        this.f8305b = webView;
    }

    public SafeGetUrl(WebView webView) {
        this.f8305b = webView;
    }
}
