package com.tencent.open.web;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.cloudwalk.util.LogUtils;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.web.a */
/* loaded from: classes2.dex */
public class C3298a {
    /* renamed from: a */
    public static void m10720a(WebView webView) {
        if (webView == null) {
            return;
        }
        m10722b(webView);
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            m10719a(settings);
            m10721b(settings);
        }
    }

    /* renamed from: b */
    private static void m10722b(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
    }

    /* renamed from: a */
    private static void m10719a(WebSettings webSettings) {
        try {
            webSettings.setSavePassword(false);
            webSettings.setAllowFileAccess(false);
            if (Build.VERSION.SDK_INT >= 16) {
                webSettings.setAllowFileAccessFromFileURLs(false);
                webSettings.setAllowUniversalAccessFromFileURLs(false);
            }
        } catch (Exception e2) {
            SLog.m10501e("WebViewUtils", LogUtils.LOG_EXCEPTION, e2);
        }
    }

    /* renamed from: b */
    private static void m10721b(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
    }
}
