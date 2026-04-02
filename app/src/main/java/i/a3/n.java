package i.a3;

import i.q2.t.m0;
import i.t0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: TimeSources.kt */
/* JADX INFO: loaded from: classes2.dex */
@j
@t0(version = "1.3")
public final class n extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12060c;

    public n() {
        super(TimeUnit.NANOSECONDS);
    }

    private final void b(double d2) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f12060c + "ns is advanced by " + d.x(d2) + '.');
    }

    public final void a(double d2) {
        long j2;
        double dA = d.a(d2, b());
        long j3 = (long) dA;
        if (j3 == Long.MIN_VALUE || j3 == m0.f12222b) {
            double d3 = this.f12060c + dA;
            if (d3 > m0.f12222b || d3 < Long.MIN_VALUE) {
                b(d2);
            }
            j2 = (long) d3;
        } else {
            long j4 = this.f12060c;
            j2 = j4 + j3;
            if ((j3 ^ j4) >= 0 && (j4 ^ j2) < 0) {
                b(d2);
            }
        }
        this.f12060c = j2;
    }

    @Override // i.a3.b
    protected long c() {
        return this.f12060c;
    }
}
