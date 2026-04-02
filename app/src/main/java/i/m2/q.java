package i.m2;

import i.b2;
import i.j1;
import i.n0;
import i.n1;
import i.t0;

/* JADX INFO: compiled from: UProgressionUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {
    private static final int a(int i2, int i3, int i4) {
        int iC = b2.c(i2, i4);
        int iC2 = b2.c(i3, i4);
        int iA = b2.a(iC, iC2);
        int iC3 = j1.c(iC - iC2);
        return iA >= 0 ? iC3 : j1.c(iC3 + i4);
    }

    @n0
    @t0(version = "1.3")
    public static final int b(int i2, int i3, int i4) {
        if (i4 > 0) {
            return b2.a(i2, i3) >= 0 ? i3 : j1.c(i3 - a(i3, i2, j1.c(i4)));
        }
        if (i4 < 0) {
            return b2.a(i2, i3) <= 0 ? i3 : j1.c(i3 + a(i2, i3, j1.c(-i4)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final long a(long j2, long j3, long j4) {
        long jC = b2.c(j2, j4);
        long jC2 = b2.c(j3, j4);
        int iA = b2.a(jC, jC2);
        long jC3 = n1.c(jC - jC2);
        return iA >= 0 ? jC3 : n1.c(jC3 + j4);
    }

    @n0
    @t0(version = "1.3")
    public static final long b(long j2, long j3, long j4) {
        if (j4 > 0) {
            return b2.a(j2, j3) >= 0 ? j3 : n1.c(j3 - a(j3, j2, n1.c(j4)));
        }
        if (j4 < 0) {
            return b2.a(j2, j3) <= 0 ? j3 : n1.c(j3 + a(j2, j3, n1.c(-j4)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
