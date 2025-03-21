package h.m2;

import h.b2;
import h.j1;
import h.n0;
import h.n1;
import h.t0;

/* compiled from: UProgressionUtil.kt */
/* loaded from: classes2.dex */
public final class q {
    private static final int a(int i2, int i3, int i4) {
        int c2 = b2.c(i2, i4);
        int c3 = b2.c(i3, i4);
        int a2 = b2.a(c2, c3);
        int c4 = j1.c(c2 - c3);
        return a2 >= 0 ? c4 : j1.c(c4 + i4);
    }

    @t0(version = "1.3")
    @n0
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
        long c2 = b2.c(j2, j4);
        long c3 = b2.c(j3, j4);
        int a2 = b2.a(c2, c3);
        long c4 = n1.c(c2 - c3);
        return a2 >= 0 ? c4 : n1.c(c4 + j4);
    }

    @t0(version = "1.3")
    @n0
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
