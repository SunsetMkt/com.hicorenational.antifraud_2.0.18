package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.entity.C0781a;
import anet.channel.entity.C0782b;
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
import com.heytap.mcssdk.constant.C2084a;
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

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class Session implements Comparable<Session> {

    /* renamed from: v */
    static ExecutorService f682v = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    public Context f683a;

    /* renamed from: c */
    public String f685c;

    /* renamed from: d */
    public String f686d;

    /* renamed from: e */
    public String f687e;

    /* renamed from: f */
    public String f688f;

    /* renamed from: g */
    public int f689g;

    /* renamed from: h */
    public String f690h;

    /* renamed from: i */
    public int f691i;

    /* renamed from: j */
    public ConnType f692j;

    /* renamed from: k */
    public IConnStrategy f693k;

    /* renamed from: m */
    public boolean f695m;

    /* renamed from: o */
    protected Runnable f697o;

    /* renamed from: p */
    public final String f698p;

    /* renamed from: q */
    public final SessionStatistic f699q;

    /* renamed from: r */
    public int f700r;

    /* renamed from: s */
    public int f701s;

    /* renamed from: x */
    private Future<?> f705x;

    /* renamed from: b */
    Map<EventCb, Integer> f684b = new LinkedHashMap();

    /* renamed from: w */
    private boolean f704w = false;

    /* renamed from: l */
    public String f694l = null;

    /* renamed from: n */
    public int f696n = 6;

    /* renamed from: t */
    public boolean f702t = false;

    /* renamed from: u */
    protected boolean f703u = true;

    /* renamed from: y */
    private List<Long> f706y = null;

    /* renamed from: z */
    private long f707z = 0;

    /* compiled from: Taobao */
    /* renamed from: anet.channel.Session$a */
    public static class C0737a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;

        /* renamed from: a */
        static final String[] f708a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        /* renamed from: a */
        static String m410a(int i2) {
            return f708a[i2];
        }
    }

    public Session(Context context, C0781a c0781a) {
        boolean z = false;
        this.f695m = false;
        this.f683a = context;
        this.f687e = c0781a.m508a();
        this.f688f = this.f687e;
        this.f689g = c0781a.m509b();
        this.f692j = c0781a.m510c();
        this.f685c = c0781a.m513f();
        String str = this.f685c;
        this.f686d = str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.f701s = c0781a.m512e();
        this.f700r = c0781a.m511d();
        this.f693k = c0781a.f835a;
        IConnStrategy iConnStrategy = this.f693k;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z = true;
        }
        this.f695m = z;
        this.f698p = c0781a.m515h();
        this.f699q = new SessionStatistic(c0781a);
        this.f699q.host = this.f686d;
    }

    public static void configTnetALog(Context context, String str, int i2, int i3) {
        SpdyAgent spdyAgent = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (spdyAgent == null || !SpdyAgent.checkLoadSucc()) {
            ALog.m715e("agent null or configTnetALog load so fail!!!", null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
        } else {
            spdyAgent.configLogFile(str, i2, i3);
        }
    }

    /* renamed from: a */
    protected void m409a() {
        Future<?> future;
        if (this.f697o == null || (future = this.f705x) == null) {
            return;
        }
        future.cancel(true);
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z) {
        this.f702t = z;
        close();
    }

    public void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.f693k;
    }

    public ConnType getConnType() {
        return this.f692j;
    }

    public String getHost() {
        return this.f685c;
    }

    public String getIp() {
        return this.f687e;
    }

    public int getPort() {
        return this.f689g;
    }

    public String getRealHost() {
        return this.f686d;
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public String getUnit() {
        return this.f694l;
    }

    public void handleCallbacks(int i2, C0782b c0782b) {
        f682v.submit(new RunnableC0747b(this, i2, c0782b));
    }

    public void handleResponseCode(Request request, int i2) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV) && i2 >= 500 && i2 < 600) {
            synchronized (this) {
                if (this.f706y == null) {
                    this.f706y = new LinkedList();
                }
                if (this.f706y.size() < 5) {
                    this.f706y.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long longValue = this.f706y.remove(0).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue <= C2084a.f6122d) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.f706y.clear();
                    } else {
                        this.f706y.add(Long.valueOf(currentTimeMillis));
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
                if (StringUtils.isStringEqual(this.f694l, singleHeaderFieldByKey)) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f707z > C2084a.f6122d) {
                    StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                    this.f707z = currentTimeMillis;
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean isAvailable();

    public synchronized void notifyStatus(int i2, C0782b c0782b) {
        ALog.m715e("awcn.Session", "notifyStatus", this.f698p, NotificationCompat.CATEGORY_STATUS, C0737a.m410a(i2));
        if (i2 == this.f696n) {
            ALog.m716i("awcn.Session", "ignore notifyStatus", this.f698p, new Object[0]);
            return;
        }
        this.f696n = i2;
        switch (this.f696n) {
            case 0:
                handleCallbacks(1, c0782b);
                break;
            case 2:
                handleCallbacks(256, c0782b);
                break;
            case 4:
                this.f694l = StrategyCenter.getInstance().getUnitByHost(this.f686d);
                handleCallbacks(512, c0782b);
                break;
            case 5:
                handleCallbacks(1024, c0782b);
                break;
            case 6:
                onDisconnect();
                if (!this.f704w) {
                    handleCallbacks(2, c0782b);
                    break;
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
        Map<EventCb, Integer> map = this.f684b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i2));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
    }

    public void setPingTimeout(int i2) {
        if (this.f697o == null) {
            this.f697o = getRecvTimeOutRunnable();
        }
        m409a();
        Runnable runnable = this.f697o;
        if (runnable != null) {
            this.f705x = ThreadPoolExecutorFactory.submitScheduledTask(runnable, i2, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        return "Session@[" + this.f698p + '|' + this.f692j + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(Session session) {
        return ConnType.compare(this.f692j, session.f692j);
    }
}
