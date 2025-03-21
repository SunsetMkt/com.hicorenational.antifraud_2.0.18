package p286h.p287a3;

import java.util.concurrent.TimeUnit;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: TimeSources.kt */
@InterfaceC5202j
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.a3.n */
/* loaded from: classes2.dex */
public final class C5206n extends AbstractC5194b {

    /* renamed from: c */
    private long f20074c;

    public C5206n() {
        super(TimeUnit.NANOSECONDS);
    }

    /* renamed from: b */
    private final void m18790b(double d2) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f20074c + "ns is advanced by " + C5196d.m18722x(d2) + '.');
    }

    /* renamed from: a */
    public final void m18791a(double d2) {
        long j2;
        double m18675a = C5196d.m18675a(d2, m18670b());
        long j3 = (long) m18675a;
        if (j3 == Long.MIN_VALUE || j3 == C5556m0.f20396b) {
            double d3 = this.f20074c + m18675a;
            if (d3 > C5556m0.f20396b || d3 < Long.MIN_VALUE) {
                m18790b(d2);
            }
            j2 = (long) d3;
        } else {
            long j4 = this.f20074c;
            j2 = j4 + j3;
            if ((j3 ^ j4) >= 0 && (j4 ^ j2) < 0) {
                m18790b(d2);
            }
        }
        this.f20074c = j2;
    }

    @Override // p286h.p287a3.AbstractC5194b
    /* renamed from: c */
    protected long mo18671c() {
        return this.f20074c;
    }
}
