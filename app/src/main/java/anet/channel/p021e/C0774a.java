package anet.channel.p021e;

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

/* compiled from: Taobao */
/* renamed from: anet.channel.e.a */
/* loaded from: classes.dex */
public class C0774a {

    /* renamed from: a */
    private static b f817a;

    /* renamed from: b */
    private static String f818b;

    /* renamed from: f */
    private static SharedPreferences f822f;

    /* renamed from: c */
    private static AtomicBoolean f819c = new AtomicBoolean(false);

    /* renamed from: d */
    private static AtomicBoolean f820d = new AtomicBoolean(false);

    /* renamed from: e */
    private static long f821e = 21600000;

    /* renamed from: g */
    private static IStrategyFilter f823g = new C0775b();

    /* renamed from: h */
    private static AtomicInteger f824h = new AtomicInteger(1);

    /* renamed from: i */
    private static IStrategyListener f825i = new C0776c();

    /* renamed from: j */
    private static NetworkStatusHelper.INetworkStatusChangeListener f826j = new C0777d();

    /* compiled from: Taobao */
    /* renamed from: anet.channel.e.a$a */
    private static class a {

        /* renamed from: a */
        long f827a;

        /* renamed from: b */
        boolean f828b;

        private a() {
        }

        /* synthetic */ a(C0775b c0775b) {
            this();
        }
    }

    /* renamed from: b */
    public static boolean m497b() {
        b bVar = f817a;
        if (bVar != null) {
            return bVar.m507b(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()));
        }
        return false;
    }

    /* renamed from: a */
    public static void m494a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!AwcnConfig.isHttp3Enable()) {
            ALog.m716i("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return;
        }
        if (f820d.get()) {
            ALog.m715e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return;
        }
        if (NetworkStatusHelper.isConnected()) {
            if (TextUtils.isEmpty(f818b)) {
                ALog.m715e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(f818b, f823g);
            if (connStrategyListByHost.isEmpty()) {
                ALog.m715e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return;
            }
            if (f819c.compareAndSet(false, true)) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.m715e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th) {
                    ALog.m714e("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    f820d.set(true);
                    return;
                }
            }
            if (f817a == null) {
                f817a = new b();
            }
            if (f817a.m506a(NetworkStatusHelper.getUniqueId(networkStatus))) {
                ThreadPoolExecutorFactory.submitDetectTask(new RunnableC0778e(connStrategyListByHost, networkStatus));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static IConnStrategy m496b(IConnStrategy iConnStrategy) {
        return new C0780g(iConnStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.e.a$b */
    static class b {

        /* renamed from: a */
        private Map<String, a> f829a = new ConcurrentHashMap();

        b() {
            m503a();
        }

        /* renamed from: a */
        private void m503a() {
            C0775b c0775b = null;
            String string = C0774a.f822f.getString("networksdk_http3_history_records", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    a aVar = new a(c0775b);
                    String string2 = jSONObject.getString("networkUniqueId");
                    aVar.f827a = jSONObject.getLong("time");
                    aVar.f828b = jSONObject.getBoolean("enable");
                    if (m504a(aVar.f827a)) {
                        synchronized (this.f829a) {
                            this.f829a.put(string2, aVar);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        /* renamed from: b */
        boolean m507b(String str) {
            synchronized (this.f829a) {
                a aVar = this.f829a.get(str);
                if (aVar == null) {
                    return false;
                }
                return aVar.f828b;
            }
        }

        /* renamed from: a */
        boolean m506a(String str) {
            synchronized (this.f829a) {
                a aVar = this.f829a.get(str);
                boolean z = true;
                if (aVar == null) {
                    return true;
                }
                if (m504a(aVar.f827a)) {
                    z = false;
                }
                return z;
            }
        }

        /* renamed from: a */
        private boolean m504a(long j2) {
            return System.currentTimeMillis() - j2 < C0774a.f821e;
        }

        /* renamed from: a */
        void m505a(String str, boolean z) {
            a aVar = new a(null);
            aVar.f828b = z;
            aVar.f827a = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f829a) {
                this.f829a.put(str, aVar);
                for (Map.Entry<String, a> entry : this.f829a.entrySet()) {
                    String key = entry.getKey();
                    a value = entry.getValue();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkUniqueId", key);
                        jSONObject.put("time", value.f827a);
                        jSONObject.put("enable", value.f828b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            C0774a.f822f.edit().putString("networksdk_http3_history_records", jSONArray.toString()).apply();
        }
    }

    /* renamed from: a */
    public static void m492a() {
        try {
            ALog.m715e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(AwcnConfig.isHttp3Enable()));
            f822f = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            f818b = f822f.getString("http3_detector_host", "");
            m494a(NetworkStatusHelper.getStatus());
            NetworkStatusHelper.addStatusChangeListener(f826j);
            StrategyCenter.getInstance().registerListener(f825i);
        } catch (Exception e2) {
            ALog.m714e("awcn.Http3ConnDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m493a(long j2) {
        if (j2 < 0) {
            return;
        }
        f821e = j2;
    }

    /* renamed from: a */
    public static void m495a(boolean z) {
        b bVar = f817a;
        if (bVar != null) {
            bVar.m505a(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()), z);
        }
    }
}
