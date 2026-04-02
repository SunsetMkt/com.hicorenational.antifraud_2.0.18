package anet.channel.e;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static b a;

    /* JADX INFO: renamed from: b */
    private static String f1428b;

    /* JADX INFO: renamed from: f */
    private static SharedPreferences f1432f;

    /* JADX INFO: renamed from: c */
    private static AtomicBoolean f1429c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d */
    private static AtomicBoolean f1430d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e */
    private static long f1431e = 21600000;

    /* JADX INFO: renamed from: g */
    private static IStrategyFilter f1433g = new anet.channel.e.b();

    /* JADX INFO: renamed from: h */
    private static AtomicInteger f1434h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i */
    private static IStrategyListener f1435i = new c();

    /* JADX INFO: renamed from: j */
    private static NetworkStatusHelper.INetworkStatusChangeListener f1436j = new d();

    /* JADX INFO: renamed from: anet.channel.e.a$a */
    /* JADX INFO: compiled from: Taobao */
    private static class C0009a {
        long a;

        /* JADX INFO: renamed from: b */
        boolean f1437b;

        private C0009a() {
        }

        /* synthetic */ C0009a(anet.channel.e.b bVar) {
            this();
        }
    }

    public static boolean b() {
        b bVar = a;
        if (bVar != null) {
            return bVar.b(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()));
        }
        return false;
    }

    public static void a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!AwcnConfig.isHttp3Enable()) {
            ALog.i("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return;
        }
        if (f1430d.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return;
        }
        if (NetworkStatusHelper.isConnected()) {
            if (TextUtils.isEmpty(f1428b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(f1428b, f1433g);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return;
            }
            if (f1429c.compareAndSet(false, true)) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable th) {
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    f1430d.set(true);
                    return;
                }
            }
            if (a == null) {
                a = new b();
            }
            if (a.a(NetworkStatusHelper.getUniqueId(networkStatus))) {
                ThreadPoolExecutorFactory.submitDetectTask(new e(connStrategyListByHost, networkStatus));
            }
        }
    }

    public static IConnStrategy b(IConnStrategy iConnStrategy) {
        return new g(iConnStrategy);
    }

    /* JADX INFO: compiled from: Taobao */
    static class b {
        private Map<String, C0009a> a = new ConcurrentHashMap();

        b() {
            a();
        }

        private void a() {
            String string = a.f1432f.getString("networksdk_http3_history_records", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    C0009a c0009a = new C0009a(null);
                    String string2 = jSONObject.getString("networkUniqueId");
                    c0009a.a = jSONObject.getLong("time");
                    c0009a.f1437b = jSONObject.getBoolean("enable");
                    if (a(c0009a.a)) {
                        synchronized (this.a) {
                            this.a.put(string2, c0009a);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        boolean b(String str) {
            synchronized (this.a) {
                C0009a c0009a = this.a.get(str);
                if (c0009a == null) {
                    return false;
                }
                return c0009a.f1437b;
            }
        }

        boolean a(String str) {
            synchronized (this.a) {
                C0009a c0009a = this.a.get(str);
                boolean z = true;
                if (c0009a == null) {
                    return true;
                }
                if (a(c0009a.a)) {
                    z = false;
                }
                return z;
            }
        }

        private boolean a(long j2) {
            return System.currentTimeMillis() - j2 < a.f1431e;
        }

        void a(String str, boolean z) {
            C0009a c0009a = new C0009a(null);
            c0009a.f1437b = z;
            c0009a.a = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.a) {
                this.a.put(str, c0009a);
                for (Map.Entry<String, C0009a> entry : this.a.entrySet()) {
                    String key = entry.getKey();
                    C0009a value = entry.getValue();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkUniqueId", key);
                        jSONObject.put("time", value.a);
                        jSONObject.put("enable", value.f1437b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            a.f1432f.edit().putString("networksdk_http3_history_records", jSONArray.toString()).apply();
        }
    }

    public static void a() {
        try {
            ALog.e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(AwcnConfig.isHttp3Enable()));
            f1432f = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            f1428b = f1432f.getString("http3_detector_host", "");
            a(NetworkStatusHelper.getStatus());
            NetworkStatusHelper.addStatusChangeListener(f1436j);
            StrategyCenter.getInstance().registerListener(f1435i);
        } catch (Exception e2) {
            ALog.e("awcn.Http3ConnDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            return;
        }
        f1431e = j2;
    }

    public static void a(boolean z) {
        b bVar = a;
        if (bVar != null) {
            bVar.a(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()), z);
        }
    }
}
