package com.tencent.open.p213c;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.open.log.SLog;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.c.b */
/* loaded from: classes2.dex */
public class C3269b extends WebView {
    public C3269b(Context context) {
        super(context);
        m10482a();
    }

    /* renamed from: a */
    protected void m10482a() {
        if (Build.VERSION.SDK_INT >= 11) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
            SLog.m10502i("openSDK_LOG.OpenWebView", "removeJSInterface");
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            getSettings().setBuiltInZoomControls(true);
            getSettings().setDisplayZoomControls(false);
            setVisibility(8);
            SLog.m10502i("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls");
        } catch (Exception e2) {
            SLog.m10501e("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls", e2);
        }
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        WebSettings settings = getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        try {
            Method method = settings.getClass().getMethod("removeJavascriptInterface", String.class);
            if (method != null) {
                method.invoke(this, "searchBoxJavaBridge_");
                method.invoke(this, "accessibility");
                method.invoke(this, "accessibilityTraversal");
                SLog.m10502i("openSDK_LOG.OpenWebView", "remove js interface");
            }
        } catch (Exception e2) {
            SLog.m10500e("openSDK_LOG.OpenWebView", "remove js interface.e:" + e2.toString());
        }
    }
}
