package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.monitor.b */
/* loaded from: classes.dex */
public class C0796b {

    /* renamed from: a */
    static int f881a = 0;

    /* renamed from: b */
    static long f882b = 0;

    /* renamed from: c */
    static long f883c = 0;

    /* renamed from: d */
    static long f884d = 0;

    /* renamed from: e */
    static long f885e = 0;

    /* renamed from: f */
    static long f886f = 0;

    /* renamed from: g */
    static double f887g = 0.0d;

    /* renamed from: h */
    static double f888h = 0.0d;

    /* renamed from: i */
    static double f889i = 0.0d;

    /* renamed from: j */
    static double f890j = 40.0d;

    /* renamed from: k */
    private static volatile boolean f891k = false;

    /* renamed from: l */
    private int f892l;

    /* renamed from: m */
    private int f893m;

    /* renamed from: n */
    private C0799e f894n;

    /* compiled from: Taobao */
    /* renamed from: anet.channel.monitor.b$a */
    static class a {

        /* renamed from: a */
        static C0796b f895a = new C0796b(null);

        a() {
        }
    }

    /* synthetic */ C0796b(C0797c c0797c) {
        this();
    }

    /* renamed from: b */
    static /* synthetic */ int m528b(C0796b c0796b) {
        int i2 = c0796b.f893m;
        c0796b.f893m = i2 + 1;
        return i2;
    }

    /* renamed from: d */
    public synchronized void m534d() {
        try {
            ALog.m716i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.getStatus());
        } catch (Exception e2) {
            ALog.m717w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e2, new Object[0]);
        }
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            f891k = false;
        } else {
            f891k = true;
        }
    }

    /* renamed from: e */
    public void m535e() {
        f891k = false;
    }

    private C0796b() {
        this.f892l = 5;
        this.f893m = 0;
        this.f894n = new C0799e();
        NetworkStatusHelper.addStatusChangeListener(new C0797c(this));
    }

    /* renamed from: c */
    public double m533c() {
        return f889i;
    }

    /* renamed from: a */
    public static C0796b m526a() {
        return a.f895a;
    }

    /* renamed from: b */
    public int m532b() {
        if (NetworkStatusHelper.getStatus() == NetworkStatusHelper.NetworkStatus.G2) {
            return 1;
        }
        return this.f892l;
    }

    /* renamed from: a */
    public void m531a(long j2, long j3, long j4) {
        if (f891k) {
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(j2), "mRequestFinishedTime", Long.valueOf(j3), "mRequestDataSize", Long.valueOf(j4));
            }
            if (j4 <= 3000 || j2 >= j3) {
                return;
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0798d(this, j4, j3, j2));
        }
    }
}
