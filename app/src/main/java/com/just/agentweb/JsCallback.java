package com.just.agentweb;

import android.webkit.WebView;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsCallback {
    private static final String CALLBACK_JS_FORMAT = "javascript:%s.callback(%d, %d %s);";
    private boolean mCouldGoOn = true;
    private int mIndex;
    private String mInjectedName;
    private int mIsPermanent;
    private WeakReference<WebView> mWebViewRef;

    public static class JsCallbackException extends Exception {
        public JsCallbackException(String str) {
            super(str);
        }
    }

    public JsCallback(WebView webView, String str, int i2) {
        this.mWebViewRef = new WeakReference<>(webView);
        this.mInjectedName = str;
        this.mIndex = i2;
    }

    private boolean isJavaScriptObject(Object obj) {
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return true;
        }
        String obj2 = obj.toString();
        try {
            try {
                new JSONObject(obj2);
            } catch (JSONException unused) {
                return false;
            }
        } catch (JSONException unused2) {
            new JSONArray(obj2);
        }
        return true;
    }

    public void apply(Object... objArr) throws JsCallbackException {
        if (this.mWebViewRef.get() == null) {
            throw new JsCallbackException("the WebView related to the JsCallback has been recycled");
        }
        if (!this.mCouldGoOn) {
            throw new JsCallbackException("the JsCallback isn't permanent,cannot be called more than once");
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            boolean z = obj instanceof String;
            boolean isJavaScriptObject = isJavaScriptObject(obj);
            if (z && !isJavaScriptObject) {
                sb.append("\"");
            }
            sb.append(String.valueOf(obj));
            if (z && !isJavaScriptObject) {
                sb.append("\"");
            }
        }
        String format = String.format(CALLBACK_JS_FORMAT, this.mInjectedName, Integer.valueOf(this.mIndex), Integer.valueOf(this.mIsPermanent), sb.toString());
        LogUtils.isDebug();
        this.mWebViewRef.get().loadUrl(format);
        this.mCouldGoOn = this.mIsPermanent > 0;
    }

    public void setPermanent(boolean z) {
        this.mIsPermanent = z ? 1 : 0;
    }
}
