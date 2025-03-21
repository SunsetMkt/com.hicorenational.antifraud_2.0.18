package p000a.p001a.p003k;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.C0848c;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002j.C0010b;
import p000a.p001a.p007o.C0025c;

/* compiled from: Taobao */
/* renamed from: a.a.k.b */
/* loaded from: classes.dex */
public class C0014b {

    /* renamed from: a */
    public static final String f9a = "SERVICE_OPTIMIZE";

    /* renamed from: b */
    public static final String f10b = "SESSION_ASYNC_OPTIMIZE";

    /* renamed from: c */
    private static volatile boolean f11c = true;

    /* renamed from: d */
    private static volatile boolean f12d = true;

    /* renamed from: e */
    private static volatile boolean f13e = true;

    /* renamed from: f */
    private static volatile int f14f = 5;

    /* renamed from: g */
    private static volatile boolean f15g = true;

    /* renamed from: h */
    private static volatile boolean f16h = true;

    /* renamed from: i */
    private static volatile boolean f17i = false;

    /* renamed from: j */
    private static volatile long f18j = 0;

    /* renamed from: k */
    private static volatile boolean f19k = false;

    /* renamed from: l */
    private static volatile ConcurrentHashMap<String, List<String>> f20l;

    /* renamed from: m */
    private static volatile CopyOnWriteArrayList<String> f21m;

    /* renamed from: n */
    private static final List<String> f22n = new ArrayList();

    /* renamed from: o */
    private static volatile int f23o = 10000;

    /* renamed from: p */
    private static volatile boolean f24p = true;

    /* renamed from: q */
    private static volatile boolean f25q = false;

    /* renamed from: r */
    private static volatile int f26r = 60000;

    /* renamed from: s */
    private static volatile CopyOnWriteArrayList<String> f27s = null;

    /* renamed from: t */
    private static volatile ConcurrentHashMap<String, List<String>> f28t = null;

    /* renamed from: u */
    private static volatile boolean f29u = true;

    /* renamed from: v */
    private static volatile boolean f30v = false;

    /* renamed from: w */
    private static volatile boolean f31w = false;

    /* renamed from: x */
    private static volatile boolean f32x = true;

    /* renamed from: y */
    private static volatile boolean f33y = true;

    /* renamed from: z */
    private static volatile InterfaceC0013a f34z;

    /* renamed from: a */
    public static void m68a(InterfaceC0013a interfaceC0013a) {
        if (f34z != null) {
            f34z.unRegister();
        }
        if (interfaceC0013a != null) {
            interfaceC0013a.register();
        }
        f34z = interfaceC0013a;
    }

    /* renamed from: b */
    public static void m76b(boolean z) {
        f17i = z;
    }

    /* renamed from: c */
    public static void m79c(int i2) {
        f14f = i2;
    }

    /* renamed from: d */
    public static void m82d() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(C0025c.getContext());
        f18j = defaultSharedPreferences.getLong("Cache.Flag", 0L);
        f31w = defaultSharedPreferences.getBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", false);
        f32x = defaultSharedPreferences.getBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", true);
    }

    /* renamed from: e */
    public static boolean m87e() {
        return f15g && f17i;
    }

    /* renamed from: f */
    public static void m88f(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.NetworkConfigCenter", "updateWhiteUrlList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f20l = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, f22n);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.m714e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        f20l = concurrentHashMap;
    }

    /* renamed from: g */
    public static boolean m92g() {
        return f19k;
    }

    /* renamed from: h */
    public static void m93h(boolean z) {
        f25q = z;
    }

    /* renamed from: i */
    public static void m95i(boolean z) {
        f16h = z;
    }

    /* renamed from: j */
    public static void m97j(boolean z) {
        f15g = z;
    }

    @Deprecated
    /* renamed from: k */
    public static void m99k(boolean z) {
    }

    /* renamed from: k */
    public static boolean m100k() {
        return f25q;
    }

    /* renamed from: l */
    public static void m101l(boolean z) {
        f13e = z;
    }

    /* renamed from: m */
    public static boolean m104m() {
        return f15g;
    }

    /* renamed from: n */
    public static boolean m106n() {
        return f13e;
    }

    /* renamed from: o */
    public static void m107o(boolean z) {
        ALog.m716i("anet.NetworkConfigCenter", "[setSSLEnabled]", null, "enable", Boolean.valueOf(z));
        f11c = z;
    }

    /* renamed from: p */
    public static void m109p(boolean z) {
        ALog.m716i("anet.NetworkConfigCenter", "[setSpdyEnabled]", null, "enable", Boolean.valueOf(z));
        f12d = z;
    }

    /* renamed from: q */
    public static boolean m111q() {
        return f11c;
    }

    /* renamed from: r */
    public static boolean m112r() {
        return f12d;
    }

    /* renamed from: b */
    public static boolean m77b(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = f20l) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == f22n) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static int m78c() {
        return f14f;
    }

    /* renamed from: e */
    public static void m85e(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.NetworkConfigCenter", "updateRequestWhiteList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f21m = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f21m = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.m714e("anet.NetworkConfigCenter", "parse bizId failed", null, e2, new Object[0]);
        }
    }

    /* renamed from: g */
    public static void m91g(boolean z) {
        f33y = z;
    }

    /* renamed from: h */
    public static boolean m94h() {
        return f30v;
    }

    /* renamed from: i */
    public static boolean m96i() {
        return f31w;
    }

    /* renamed from: j */
    public static boolean m98j() {
        return f33y;
    }

    /* renamed from: l */
    public static boolean m102l() {
        return f16h;
    }

    /* renamed from: m */
    public static void m103m(boolean z) {
        f29u = z;
    }

    /* renamed from: n */
    public static void m105n(boolean z) {
        f24p = z;
    }

    /* renamed from: c */
    public static void m80c(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.m716i("anet.NetworkConfigCenter", "setDegradeRequestList", null, "Degrade List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f28t = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, f22n);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.m714e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        f28t = concurrentHashMap;
    }

    /* renamed from: o */
    public static boolean m108o() {
        return f29u;
    }

    /* renamed from: p */
    public static boolean m110p() {
        return f24p;
    }

    /* renamed from: a */
    public static void m67a(long j2) {
        if (j2 != f18j) {
            ALog.m716i("anet.NetworkConfigCenter", "set cache flag", null, "old", Long.valueOf(f18j), "new", Long.valueOf(j2));
            f18j = j2;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(C0025c.getContext()).edit();
            edit.putLong("Cache.Flag", f18j);
            edit.apply();
            C0010b.m57a();
        }
    }

    /* renamed from: d */
    public static void m84d(boolean z) {
        f19k = z;
    }

    /* renamed from: d */
    public static void m83d(String str) {
        if (TextUtils.isEmpty(str)) {
            f27s = null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(Constants.KEY_HOST);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (C0848c.m709c(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f27s = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.m714e("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
        }
    }

    /* renamed from: b */
    public static int m73b() {
        return f23o;
    }

    /* renamed from: b */
    public static void m74b(int i2) {
        f23o = i2;
    }

    /* renamed from: b */
    public static void m75b(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    String string = jSONArray.getString(i2);
                    if (C0848c.m709c(string)) {
                        arrayList.add(string);
                    }
                }
                HttpDispatcher.getInstance().addHosts(arrayList);
            } catch (JSONException e2) {
                ALog.m714e("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static boolean m72a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = f21m;
        if (f21m == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static void m86e(boolean z) {
        f30v = z;
    }

    /* renamed from: a */
    public static int m65a() {
        return f26r;
    }

    /* renamed from: a */
    public static void m66a(int i2) {
        f26r = i2;
    }

    /* renamed from: a */
    public static boolean m70a(RequestStatistic requestStatistic) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (requestStatistic == null || (copyOnWriteArrayList = f27s) == null || TextUtils.isEmpty(requestStatistic.host)) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (requestStatistic.host.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m71a(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = f28t) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == f22n) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static void m89f(boolean z) {
        f31w = z;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(C0025c.getContext()).edit();
        edit.putBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", f31w);
        edit.apply();
    }

    /* renamed from: c */
    public static void m81c(boolean z) {
        f32x = z;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(C0025c.getContext()).edit();
        edit.putBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", f32x);
        edit.apply();
    }

    /* renamed from: a */
    public static void m69a(boolean z) {
        if (z) {
            m93h(true);
            ThreadPoolExecutorFactory.setNormalExecutorPoolSize(16);
            AwcnConfig.registerPresetSessions("[{\"host\":\"trade-acs.m.taobao.com\", \"protocol\":\"http2\", \"rtt\":\"0rtt\", \"publicKey\": \"acs\", \"isKeepAlive\":true}]");
        } else {
            m93h(false);
            ThreadPoolExecutorFactory.setNormalExecutorPoolSize(6);
        }
    }

    /* renamed from: f */
    public static boolean m90f() {
        return f32x;
    }
}
