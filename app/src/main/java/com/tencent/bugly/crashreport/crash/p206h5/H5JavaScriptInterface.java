package com.tencent.bugly.crashreport.crash.p206h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class H5JavaScriptInterface {

    /* renamed from: a */
    private static HashSet<Integer> f10418a = new HashSet<>();

    /* renamed from: b */
    private String f10419b = null;

    /* renamed from: c */
    private Thread f10420c = null;

    /* renamed from: d */
    private String f10421d = null;

    /* renamed from: e */
    private Map<String, String> f10422e = null;

    private H5JavaScriptInterface() {
    }

    /* renamed from: a */
    private static String m9759a(Thread thread) {
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
        if (webViewInterface == null || f10418a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f10418a.add(Integer.valueOf(webViewInterface.hashCode()));
        h5JavaScriptInterface.f10420c = Thread.currentThread();
        h5JavaScriptInterface.f10421d = m9759a(h5JavaScriptInterface.f10420c);
        h5JavaScriptInterface.f10422e = m9760a(webViewInterface);
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        C3151an.m9922d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            C3151an.m9922d("Payload from JS is null.", new Object[0]);
            return;
        }
        String m9981b = C3154aq.m9981b(str.getBytes());
        String str2 = this.f10419b;
        if (str2 != null && str2.equals(m9981b)) {
            C3151an.m9922d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f10419b = m9981b;
        C3151an.m9922d("Handling JS exception ...", new Object[0]);
        C3131a m9758a = m9758a(str);
        if (m9758a == null) {
            C3151an.m9922d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(m9758a.m9762a());
        linkedHashMap.putAll(this.f10422e);
        linkedHashMap.put("Java Stack", this.f10421d);
        m9761a(m9758a, this.f10420c, linkedHashMap);
    }

    /* renamed from: a */
    private static Map<String, String> m9760a(CrashReport.WebViewInterface webViewInterface) {
        HashMap hashMap = new HashMap();
        hashMap.put("[WebView] ContentDescription", "" + ((Object) webViewInterface.getContentDescription()));
        return hashMap;
    }

    /* renamed from: a */
    private C3131a m9758a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C3131a c3131a = new C3131a();
                c3131a.f10423a = jSONObject.getString("projectRoot");
                if (c3131a.f10423a == null) {
                    return null;
                }
                c3131a.f10424b = jSONObject.getString(C3397d.f11892R);
                if (c3131a.f10424b == null) {
                    return null;
                }
                c3131a.f10425c = jSONObject.getString("url");
                if (c3131a.f10425c == null) {
                    return null;
                }
                c3131a.f10426d = jSONObject.getString("userAgent");
                if (c3131a.f10426d == null) {
                    return null;
                }
                c3131a.f10427e = jSONObject.getString(C3351bh.f11562N);
                if (c3131a.f10427e == null) {
                    return null;
                }
                c3131a.f10428f = jSONObject.getString(CommonNetImpl.NAME);
                if (c3131a.f10428f == null || c3131a.f10428f.equals(AbstractC1191a.f2571h) || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int indexOf = string.indexOf("\n");
                if (indexOf < 0) {
                    C3151an.m9922d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                c3131a.f10430h = string.substring(indexOf + 1);
                c3131a.f10429g = string.substring(0, indexOf);
                int indexOf2 = c3131a.f10429g.indexOf(Constants.COLON_SEPARATOR);
                if (indexOf2 > 0) {
                    c3131a.f10429g = c3131a.f10429g.substring(indexOf2 + 1);
                }
                c3131a.f10431i = jSONObject.getString("file");
                if (c3131a.f10428f == null) {
                    return null;
                }
                c3131a.f10432j = jSONObject.getLong("lineNumber");
                if (c3131a.f10432j < 0) {
                    return null;
                }
                c3131a.f10433k = jSONObject.getLong("columnNumber");
                if (c3131a.f10433k < 0) {
                    return null;
                }
                C3151an.m9915a("H5 crash information is following: ", new Object[0]);
                C3151an.m9915a("[projectRoot]: " + c3131a.f10423a, new Object[0]);
                C3151an.m9915a("[context]: " + c3131a.f10424b, new Object[0]);
                C3151an.m9915a("[url]: " + c3131a.f10425c, new Object[0]);
                C3151an.m9915a("[userAgent]: " + c3131a.f10426d, new Object[0]);
                C3151an.m9915a("[language]: " + c3131a.f10427e, new Object[0]);
                C3151an.m9915a("[name]: " + c3131a.f10428f, new Object[0]);
                C3151an.m9915a("[message]: " + c3131a.f10429g, new Object[0]);
                C3151an.m9915a("[stacktrace]: \n" + c3131a.f10430h, new Object[0]);
                C3151an.m9915a("[file]: " + c3131a.f10431i, new Object[0]);
                C3151an.m9915a("[lineNumber]: " + c3131a.f10432j, new Object[0]);
                C3151an.m9915a("[columnNumber]: " + c3131a.f10433k, new Object[0]);
                return c3131a;
            } catch (Throwable th) {
                if (!C3151an.m9916a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m9761a(C3131a c3131a, Thread thread, Map<String, String> map) {
        if (c3131a != null) {
            InnerApi.postH5CrashAsync(thread, c3131a.f10428f, c3131a.f10429g, c3131a.f10430h, map);
        }
    }
}
