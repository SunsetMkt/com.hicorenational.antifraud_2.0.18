package anet.channel.monitor;

import anet.channel.util.ALog;

/* compiled from: Taobao */
/* renamed from: anet.channel.monitor.d */
/* loaded from: classes.dex */
class RunnableC0798d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f897a;

    /* renamed from: b */
    final /* synthetic */ long f898b;

    /* renamed from: c */
    final /* synthetic */ long f899c;

    /* renamed from: d */
    final /* synthetic */ C0796b f900d;

    RunnableC0798d(C0796b c0796b, long j2, long j3, long j4) {
        this.f900d = c0796b;
        this.f897a = j2;
        this.f898b = j3;
        this.f899c = j4;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0799e c0799e;
        int i2;
        C0799e c0799e2;
        C0796b.f881a++;
        C0796b.f885e += this.f897a;
        if (C0796b.f881a == 1) {
            C0796b.f884d = this.f898b - this.f899c;
        }
        int i3 = C0796b.f881a;
        if (i3 >= 2 && i3 <= 3) {
            long j2 = this.f899c;
            long j3 = C0796b.f883c;
            if (j2 >= j3) {
                C0796b.f884d += this.f898b - j2;
            } else if (j2 < j3) {
                long j4 = this.f898b;
                if (j4 >= j3) {
                    C0796b.f884d += j4 - j2;
                    C0796b.f884d -= C0796b.f883c - j2;
                }
            }
        }
        C0796b.f882b = this.f899c;
        C0796b.f883c = this.f898b;
        if (C0796b.f881a == 3) {
            c0799e = this.f900d.f894n;
            C0796b.f889i = (long) c0799e.m536a(C0796b.f885e, C0796b.f884d);
            C0796b.f886f++;
            C0796b.m528b(this.f900d);
            if (C0796b.f886f > 30) {
                c0799e2 = this.f900d.f894n;
                c0799e2.m537a();
                C0796b.f886f = 3L;
            }
            double d2 = (C0796b.f889i * 0.68d) + (C0796b.f888h * 0.27d) + (C0796b.f887g * 0.05d);
            C0796b.f887g = C0796b.f888h;
            C0796b.f888h = C0796b.f889i;
            if (C0796b.f889i < C0796b.f887g * 0.65d || C0796b.f889i > C0796b.f887g * 2.0d) {
                C0796b.f889i = d2;
            }
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(C0796b.f885e), "mKalmanTimeUsed", Long.valueOf(C0796b.f884d), "speed", Double.valueOf(C0796b.f889i), "mSpeedKalmanCount", Long.valueOf(C0796b.f886f));
            }
            i2 = this.f900d.f893m;
            if (i2 > 5 || C0796b.f886f == 2) {
                C0795a.m521a().m522a(C0796b.f889i);
                this.f900d.f893m = 0;
                this.f900d.f892l = C0796b.f889i < C0796b.f890j ? 1 : 5;
                ALog.m716i("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
            }
            C0796b.f884d = 0L;
            C0796b.f885e = 0L;
            C0796b.f881a = 0;
        }
    }
}
