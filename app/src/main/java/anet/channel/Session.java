package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public abstract class Session implements Comparable<Session> {
    static ExecutorService v = Executors.newSingleThreadExecutor();
    public Context a;

    /* JADX INFO: renamed from: c */
    public String f1345c;

    /* JADX INFO: renamed from: d */
    public String f1346d;

    /* JADX INFO: renamed from: e */
    public String f1347e;

    /* JADX INFO: renamed from: f */
    public String f1348f;

    /* JADX INFO: renamed from: g */
    public int f1349g;

    /* JADX INFO: renamed from: h */
    public String f1350h;

    /* JADX INFO: renamed from: i */
    public int f1351i;

    /* JADX INFO: renamed from: j */
    public ConnType f1352j;

    /* JADX INFO: renamed from: k */
    public IConnStrategy f1353k;

    /* JADX INFO: renamed from: m */
    public boolean f1355m;
    protected Runnable o;
    public final String p;
    public final SessionStatistic q;
    public int r;
    public int s;
    private Future<?> x;

    /* JADX INFO: renamed from: b */
    Map<EventCb, Integer> f1344b = new LinkedHashMap();
    private boolean w = false;

    /* JADX INFO: renamed from: l */
    public String f1354l = null;

    /* JADX INFO: renamed from: n */
    public int f1356n = 6;
    public boolean t = false;
    protected boolean u = true;
    private List<Long> y = null;
    private long z = 0;

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;
        static final String[] a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        static String a(int i2) {
            return a[i2];
        }
    }

    public Session(Context context, anet.channel.entity.a aVar) {
        boolean z = false;
        this.f1355m = false;
        this.a = context;
        this.f1347e = aVar.a();
        this.f1348f = this.f1347e;
        this.f1349g = aVar.b();
        this.f1352j = aVar.c();
        this.f1345c = aVar.f();
        String str = this.f1345c;
        this.f1346d = str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.s = aVar.e();
        this.r = aVar.d();
        this.f1353k = aVar.a;
        IConnStrategy iConnStrategy = this.f1353k;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z = true;
        }
        this.f1355m = z;
        this.p = aVar.h();
        this.q = new SessionStatistic(aVar);
        this.q.host = this.f1346d;
    }

    public static void configTnetALog(Context context, String str, int i2, int i3) {
        SpdyAgent spdyAgent = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (spdyAgent == null || !SpdyAgent.checkLoadSucc()) {
            ALog.e("agent null or configTnetALog load so fail!!!", null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
        } else {
            spdyAgent.configLogFile(str, i2, i3);
        }
    }

    protected void a() {
        Future<?> future;
        if (this.o == null || (future = this.x) == null) {
            return;
        }
        future.cancel(true);
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z) {
        this.t = z;
        close();
    }

    public void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.f1353k;
    }

    public ConnType getConnType() {
        return this.f1352j;
    }

    public String getHost() {
        return this.f1345c;
    }

    public String getIp() {
        return this.f1347e;
    }

    public int getPort() {
        return this.f1349g;
    }

    public String getRealHost() {
        return this.f1346d;
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public String getUnit() {
        return this.f1354l;
    }

    public void handleCallbacks(int i2, anet.channel.entity.b bVar) {
        v.submit(new b(this, i2, bVar));
    }

    public void handleResponseCode(Request request, int i2) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV) && i2 >= 500 && i2 < 600) {
            synchronized (this) {
                if (this.y == null) {
                    this.y = new LinkedList();
                }
                if (this.y.size() < 5) {
                    this.y.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long jLongValue = this.y.remove(0).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - jLongValue <= com.heytap.mcssdk.constant.a.f3868d) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.y.clear();
                    } else {
                        this.y.add(Long.valueOf(jCurrentTimeMillis));
                    }
                }
            }
        }
    }

    public void handleResponseHeaders(Request request, Map<String, List<String>> map) {
        try {
            if (map.containsKey(HttpConstant.X_SWITCH_UNIT)) {
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.X_SWITCH_UNIT);
                if (TextUtils.isEmpty(singleHeaderFieldByKey)) {
                    singleHeaderFieldByKey = null;
                }
                if (StringUtils.isStringEqual(this.f1354l, singleHeaderFieldByKey)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.z > com.heytap.mcssdk.constant.a.f3868d) {
                    StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                    this.z = jCurrentTimeMillis;
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean isAvailable();

    public synchronized void notifyStatus(int i2, anet.channel.entity.b bVar) {
        ALog.e("awcn.Session", "notifyStatus", this.p, NotificationCompat.CATEGORY_STATUS, a.a(i2));
        if (i2 == this.f1356n) {
            ALog.i("awcn.Session", "ignore notifyStatus", this.p, new Object[0]);
            return;
        }
        this.f1356n = i2;
        switch (this.f1356n) {
            case 0:
                handleCallbacks(1, bVar);
                break;
            case 2:
                handleCallbacks(256, bVar);
                break;
            case 4:
                this.f1354l = StrategyCenter.getInstance().getUnitByHost(this.f1346d);
                handleCallbacks(512, bVar);
                break;
            case 5:
                handleCallbacks(1024, bVar);
                break;
            case 6:
                onDisconnect();
                if (!this.w) {
                    handleCallbacks(2, bVar);
                }
                break;
        }
    }

    public void onDisconnect() {
    }

    public void ping(boolean z) {
    }

    public void ping(boolean z, int i2) {
    }

    public void registerEventcb(int i2, EventCb eventCb) {
        Map<EventCb, Integer> map = this.f1344b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i2));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
    }

    public void setPingTimeout(int i2) {
        if (this.o == null) {
            this.o = getRecvTimeOutRunnable();
        }
        a();
        Runnable runnable = this.o;
        if (runnable != null) {
            this.x = ThreadPoolExecutorFactory.submitScheduledTask(runnable, i2, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        return "Session@[" + this.p + '|' + this.f1352j + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(Session session) {
        return ConnType.compare(this.f1352j, session.f1352j);
    }
}
