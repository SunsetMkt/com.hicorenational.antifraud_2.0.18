package anet.channel.monitor;

import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f1483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f1484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f1485d;

    d(b bVar, long j2, long j3, long j4) {
        this.f1485d = bVar;
        this.a = j2;
        this.f1483b = j3;
        this.f1484c = j4;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a++;
        b.f1473e += this.a;
        if (b.a == 1) {
            b.f1472d = this.f1483b - this.f1484c;
        }
        int i2 = b.a;
        if (i2 >= 2 && i2 <= 3) {
            long j2 = this.f1484c;
            long j3 = b.f1471c;
            if (j2 >= j3) {
                b.f1472d += this.f1483b - j2;
            } else if (j2 < j3) {
                long j4 = this.f1483b;
                if (j4 >= j3) {
                    b.f1472d += j4 - j2;
                    b.f1472d -= b.f1471c - j2;
                }
            }
        }
        b.f1470b = this.f1484c;
        b.f1471c = this.f1483b;
        if (b.a == 3) {
            b.f1477i = (long) this.f1485d.f1482n.a(b.f1473e, b.f1472d);
            b.f1474f++;
            b.b(this.f1485d);
            if (b.f1474f > 30) {
                this.f1485d.f1482n.a();
                b.f1474f = 3L;
            }
            double d2 = (b.f1477i * 0.68d) + (b.f1476h * 0.27d) + (b.f1475g * 0.05d);
            b.f1475g = b.f1476h;
            b.f1476h = b.f1477i;
            if (b.f1477i < b.f1475g * 0.65d || b.f1477i > b.f1475g * 2.0d) {
                b.f1477i = d2;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(b.f1473e), "mKalmanTimeUsed", Long.valueOf(b.f1472d), "speed", Double.valueOf(b.f1477i), "mSpeedKalmanCount", Long.valueOf(b.f1474f));
            }
            if (this.f1485d.f1481m > 5 || b.f1474f == 2) {
                a.a().a(b.f1477i);
                this.f1485d.f1481m = 0;
                this.f1485d.f1480l = b.f1477i < b.f1478j ? 1 : 5;
                ALog.i("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
            }
            b.f1472d = 0L;
            b.f1473e = 0L;
            b.a = 0;
        }
    }
}
