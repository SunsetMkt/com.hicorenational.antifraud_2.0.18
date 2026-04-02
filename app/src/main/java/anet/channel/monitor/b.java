package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b {
    static int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static long f1470b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static long f1471c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static long f1472d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static long f1473e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static long f1474f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static double f1475g = 0.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static double f1476h = 0.0d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static double f1477i = 0.0d;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static double f1478j = 40.0d;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f1479k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1480l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1481m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private e f1482n;

    /* JADX INFO: compiled from: Taobao */
    static class a {
        static b a = new b(null);

        a() {
        }
    }

    /* synthetic */ b(c cVar) {
        this();
    }

    static /* synthetic */ int b(b bVar) {
        int i2 = bVar.f1481m;
        bVar.f1481m = i2 + 1;
        return i2;
    }

    public synchronized void d() {
        try {
            ALog.i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.getStatus());
        } catch (Exception e2) {
            ALog.w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e2, new Object[0]);
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            f1479k = false;
        } else {
            f1479k = true;
        }
    }

    public void e() {
        f1479k = false;
    }

    private b() {
        this.f1480l = 5;
        this.f1481m = 0;
        this.f1482n = new e();
        NetworkStatusHelper.addStatusChangeListener(new c(this));
    }

    public double c() {
        return f1477i;
    }

    public static b a() {
        return a.a;
    }

    public int b() {
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.f1480l;
    }

    public void a(long j2, long j3, long j4) {
        if (f1479k) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j2), "mRequestFinishedTime", Long.valueOf(j3), "mRequestDataSize", Long.valueOf(j4));
            }
            if (j4 <= 3000 || j2 >= j3) {
                return;
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this, j4, j3, j2));
        }
    }
}
