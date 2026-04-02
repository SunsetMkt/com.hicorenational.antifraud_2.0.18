package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class H5JavaScriptInterface {
    private static HashSet<Integer> a = new HashSet<>();

    /* JADX INFO: renamed from: b */
    private String f6301b = null;

    /* JADX INFO: renamed from: c */
    private Thread f6302c = null;

    /* JADX INFO: renamed from: d */
    private String f6303d = null;

    /* JADX INFO: renamed from: e */
    private Map<String, String> f6304e = null;

    private H5JavaScriptInterface() {
    }

    private static String a(Thread thread) {
        if (thread == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i2 = 2; i2 < thread.getStackTrace().length; i2++) {
            StackTraceElement stackTraceElement = thread.getStackTrace()[i2];
            if (!stackTraceElement.toString().contains("crashreport")) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface webViewInterface) {
        if (webViewInterface == null || a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        a.add(Integer.valueOf(webViewInterface.hashCode()));
        h5JavaScriptInterface.f6302c = Thread.currentThread();
        h5JavaScriptInterface.f6303d = a(h5JavaScriptInterface.f6302c);
        h5JavaScriptInterface.f6304e = a(webViewInterface);
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        an.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            an.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String strB = aq.b(str.getBytes());
        String str2 = this.f6301b;
        if (str2 != null && str2.equals(strB)) {
            an.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f6301b = strB;
        an.d("Handling JS exception ...", new Object[0]);
        a aVarA = a(str);
        if (aVarA == null) {
            an.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(aVarA.a());
        linkedHashMap.putAll(this.f6304e);
        linkedHashMap.put("Java Stack", this.f6303d);
        a(aVarA, this.f6302c, linkedHashMap);
    }

    private static Map<String, String> a(CrashReport.WebViewInterface webViewInterface) {
        HashMap map = new HashMap();
        map.put("[WebView] ContentDescription", "" + ((Object) webViewInterface.getContentDescription()));
        return map;
    }

    private a a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a();
                aVar.a = jSONObject.getString("projectRoot");
                if (aVar.a == null) {
                    return null;
                }
                aVar.f6305b = jSONObject.getString(d.R);
                if (aVar.f6305b == null) {
                    return null;
                }
                aVar.f6306c = jSONObject.getString("url");
                if (aVar.f6306c == null) {
                    return null;
                }
                aVar.f6307d = jSONObject.getString("userAgent");
                if (aVar.f6307d == null) {
                    return null;
                }
                aVar.f6308e = jSONObject.getString(bh.N);
                if (aVar.f6308e == null) {
                    return null;
                }
                aVar.f6309f = jSONObject.getString(CommonNetImpl.NAME);
                if (aVar.f6309f == null || aVar.f6309f.equals(d.c.a.b.a.a.f10075h) || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int iIndexOf = string.indexOf("\n");
                if (iIndexOf < 0) {
                    an.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                aVar.f6311h = string.substring(iIndexOf + 1);
                aVar.f6310g = string.substring(0, iIndexOf);
                int iIndexOf2 = aVar.f6310g.indexOf(Constants.COLON_SEPARATOR);
                if (iIndexOf2 > 0) {
                    aVar.f6310g = aVar.f6310g.substring(iIndexOf2 + 1);
                }
                aVar.f6312i = jSONObject.getString("file");
                if (aVar.f6309f == null) {
                    return null;
                }
                aVar.f6313j = jSONObject.getLong("lineNumber");
                if (aVar.f6313j < 0) {
                    return null;
                }
                aVar.f6314k = jSONObject.getLong("columnNumber");
                if (aVar.f6314k < 0) {
                    return null;
                }
                an.a("H5 crash information is following: ", new Object[0]);
                an.a("[projectRoot]: " + aVar.a, new Object[0]);
                an.a("[context]: " + aVar.f6305b, new Object[0]);
                an.a("[url]: " + aVar.f6306c, new Object[0]);
                an.a("[userAgent]: " + aVar.f6307d, new Object[0]);
                an.a("[language]: " + aVar.f6308e, new Object[0]);
                an.a("[name]: " + aVar.f6309f, new Object[0]);
                an.a("[message]: " + aVar.f6310g, new Object[0]);
                an.a("[stacktrace]: \n" + aVar.f6311h, new Object[0]);
                an.a("[file]: " + aVar.f6312i, new Object[0]);
                an.a("[lineNumber]: " + aVar.f6313j, new Object[0]);
                an.a("[columnNumber]: " + aVar.f6314k, new Object[0]);
                return aVar;
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void a(a aVar, Thread thread, Map<String, String> map) {
        if (aVar != null) {
            InnerApi.postH5CrashAsync(thread, aVar.f6309f, aVar.f6310g, aVar.f6311h, map);
        }
    }
}
