package p000a.p001a.p004l;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p003k.C0014b;
import p000a.p001a.p007o.C0025c;

/* compiled from: Taobao */
/* renamed from: a.a.l.a */
/* loaded from: classes.dex */
public class C0015a {

    /* renamed from: a */
    public static final String f35a = "anet.CookieManager";

    /* renamed from: b */
    private static volatile boolean f36b = false;

    /* renamed from: c */
    private static CookieManager f37c = null;

    /* renamed from: d */
    private static boolean f38d = true;

    /* renamed from: e */
    private static a f39e;

    /* renamed from: f */
    private static SharedPreferences f40f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: a.a.l.a$a */
    static class a {

        /* renamed from: a */
        String f41a;

        /* renamed from: b */
        String f42b;

        /* renamed from: c */
        String f43c;

        /* renamed from: d */
        String f44d;

        /* renamed from: e */
        long f45e;

        a(String str) {
            this.f41a = str;
            String string = C0015a.f40f.getString("networksdk_cookie_monitor", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (!TextUtils.isEmpty(this.f41a) && this.f41a.equals(jSONObject.getString("cookieName"))) {
                    this.f45e = jSONObject.getLong("time");
                    if (System.currentTimeMillis() - this.f45e < 86400000) {
                        this.f42b = jSONObject.getString("cookieText");
                        this.f43c = jSONObject.getString("setCookie");
                        this.f44d = jSONObject.getString(DispatchConstants.DOMAIN);
                    } else {
                        this.f45e = 0L;
                        C0015a.f40f.edit().remove("networksdk_cookie_monitor").apply();
                    }
                }
            } catch (JSONException e2) {
                ALog.m714e(C0015a.f35a, "cookie json parse error.", null, e2, new Object[0]);
            }
        }

        /* renamed from: a */
        void m127a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cookieName", this.f41a);
                jSONObject.put("cookieText", this.f42b);
                jSONObject.put("setCookie", this.f43c);
                this.f45e = System.currentTimeMillis();
                jSONObject.put("time", this.f45e);
                jSONObject.put(DispatchConstants.DOMAIN, this.f44d);
                C0015a.f40f.edit().putString("networksdk_cookie_monitor", jSONObject.toString()).apply();
            } catch (Exception e2) {
                ALog.m714e(C0015a.f35a, "cookie json save error.", null, e2, new Object[0]);
            }
        }
    }

    /* renamed from: d */
    private static boolean m124d() {
        if (!f36b && C0025c.getContext() != null) {
            m115a(C0025c.getContext());
        }
        return f36b;
    }

    /* renamed from: e */
    private static void m125e() {
        ThreadPoolExecutorFactory.submitCookieMonitor(new RunnableC0016b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static String m126f() {
        SharedPreferences sharedPreferences = f40f;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("networksdk_target_cookie_name", null);
    }

    /* renamed from: b */
    public static synchronized void m121b(String str, String str2) {
        synchronized (C0015a.class) {
            if (C0014b.m98j()) {
                if (m124d() && f38d) {
                    try {
                        f37c.setCookie(str, str2);
                        if (Build.VERSION.SDK_INT < 21) {
                            CookieSyncManager.getInstance().sync();
                        } else {
                            f37c.flush();
                        }
                    } catch (Throwable th) {
                        ALog.m714e(f35a, "set cookie failed.", null, th, "url", str, "cookies", str2);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public static void m123c(String str) {
        SharedPreferences sharedPreferences;
        if (str == null || (sharedPreferences = f40f) == null) {
            return;
        }
        sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
    }

    /* renamed from: a */
    public static synchronized void m115a(Context context) {
        synchronized (C0015a.class) {
            if (C0014b.m98j()) {
                if (f36b) {
                    return;
                }
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.createInstance(context);
                    }
                    f37c = CookieManager.getInstance();
                    f37c.setAcceptCookie(true);
                    if (Build.VERSION.SDK_INT < 21) {
                        f37c.removeExpiredCookie();
                    }
                    f40f = PreferenceManager.getDefaultSharedPreferences(context);
                    m125e();
                    ALog.m715e(f35a, "CookieManager setup.", null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    f38d = false;
                    ALog.m714e(f35a, "Cookie Manager setup failed!!!", null, th, new Object[0]);
                }
                f36b = true;
            }
        }
    }

    /* renamed from: b */
    public static synchronized String m120b(String str) {
        synchronized (C0015a.class) {
            String str2 = null;
            if (!C0014b.m98j()) {
                return null;
            }
            if (!m124d() || !f38d) {
                return null;
            }
            try {
                str2 = f37c.getCookie(str);
            } catch (Throwable th) {
                ALog.m714e(f35a, "get cookie failed. url=" + str, null, th, new Object[0]);
            }
            m117a(str, str2);
            return str2;
        }
    }

    /* renamed from: a */
    public static void m118a(String str, Map<String, List<String>> map) {
        if (!C0014b.m98j() || str == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && (key.equalsIgnoreCase(HttpConstant.SET_COOKIE) || key.equalsIgnoreCase(HttpConstant.SET_COOKIE2))) {
                    for (String str2 : entry.getValue()) {
                        m121b(str, str2);
                        m116a(str2);
                    }
                }
            }
        } catch (Exception e2) {
            ALog.m714e(f35a, "set cookie failed", null, e2, "url", str, "\nheaders", map);
        }
    }

    /* renamed from: a */
    private static void m116a(String str) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new RunnableC0017c(str));
    }

    /* renamed from: a */
    private static void m117a(String str, String str2) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new RunnableC0018d(str, str2));
    }
}
