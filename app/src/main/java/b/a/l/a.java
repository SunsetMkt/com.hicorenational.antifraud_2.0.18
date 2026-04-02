package b.a.l;

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

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final String a = "anet.CookieManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f1816b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static CookieManager f1817c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1818d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static C0023a f1819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static SharedPreferences f1820f;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b.a.l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    static class C0023a {
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f1821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f1822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f1823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f1824e;

        C0023a(String str) {
            this.a = str;
            String string = a.f1820f.getString("networksdk_cookie_monitor", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (!TextUtils.isEmpty(this.a) && this.a.equals(jSONObject.getString("cookieName"))) {
                    this.f1824e = jSONObject.getLong("time");
                    if (System.currentTimeMillis() - this.f1824e < 86400000) {
                        this.f1821b = jSONObject.getString("cookieText");
                        this.f1822c = jSONObject.getString("setCookie");
                        this.f1823d = jSONObject.getString(DispatchConstants.DOMAIN);
                    } else {
                        this.f1824e = 0L;
                        a.f1820f.edit().remove("networksdk_cookie_monitor").apply();
                    }
                }
            } catch (JSONException e2) {
                ALog.e(a.a, "cookie json parse error.", null, e2, new Object[0]);
            }
        }

        void a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cookieName", this.a);
                jSONObject.put("cookieText", this.f1821b);
                jSONObject.put("setCookie", this.f1822c);
                this.f1824e = System.currentTimeMillis();
                jSONObject.put("time", this.f1824e);
                jSONObject.put(DispatchConstants.DOMAIN, this.f1823d);
                a.f1820f.edit().putString("networksdk_cookie_monitor", jSONObject.toString()).apply();
            } catch (Exception e2) {
                ALog.e(a.a, "cookie json save error.", null, e2, new Object[0]);
            }
        }
    }

    private static boolean d() {
        if (!f1816b && b.a.o.c.getContext() != null) {
            a(b.a.o.c.getContext());
        }
        return f1816b;
    }

    private static void e() {
        ThreadPoolExecutorFactory.submitCookieMonitor(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f() {
        SharedPreferences sharedPreferences = f1820f;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("networksdk_target_cookie_name", null);
    }

    public static synchronized void b(String str, String str2) {
        if (b.a.k.b.j()) {
            if (d() && f1818d) {
                try {
                    f1817c.setCookie(str, str2);
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        f1817c.flush();
                    }
                } catch (Throwable th) {
                    ALog.e(a, "set cookie failed.", null, th, "url", str, "cookies", str2);
                }
            }
        }
    }

    public static void c(String str) {
        SharedPreferences sharedPreferences;
        if (str == null || (sharedPreferences = f1820f) == null) {
            return;
        }
        sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
    }

    public static synchronized void a(Context context) {
        if (b.a.k.b.j()) {
            if (f1816b) {
                return;
            }
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(context);
                }
                f1817c = CookieManager.getInstance();
                f1817c.setAcceptCookie(true);
                if (Build.VERSION.SDK_INT < 21) {
                    f1817c.removeExpiredCookie();
                }
                f1820f = PreferenceManager.getDefaultSharedPreferences(context);
                e();
                ALog.e(a, "CookieManager setup.", null, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th) {
                f1818d = false;
                ALog.e(a, "Cookie Manager setup failed!!!", null, th, new Object[0]);
            }
            f1816b = true;
        }
    }

    public static synchronized String b(String str) {
        String cookie = null;
        if (!b.a.k.b.j()) {
            return null;
        }
        if (!d() || !f1818d) {
            return null;
        }
        try {
            cookie = f1817c.getCookie(str);
        } catch (Throwable th) {
            ALog.e(a, "get cookie failed. url=" + str, null, th, new Object[0]);
        }
        a(str, cookie);
        return cookie;
    }

    public static void a(String str, Map<String, List<String>> map) {
        if (!b.a.k.b.j() || str == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && (key.equalsIgnoreCase(HttpConstant.SET_COOKIE) || key.equalsIgnoreCase(HttpConstant.SET_COOKIE2))) {
                    for (String str2 : entry.getValue()) {
                        b(str, str2);
                        a(str2);
                    }
                }
            }
        } catch (Exception e2) {
            ALog.e(a, "set cookie failed", null, e2, "url", str, "\nheaders", map);
        }
    }

    private static void a(String str) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new c(str));
    }

    private static void a(String str, String str2) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new d(str, str2));
    }
}
