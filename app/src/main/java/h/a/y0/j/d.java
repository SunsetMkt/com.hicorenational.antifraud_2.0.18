package h.a.y0.j;

import i.q2.t.m0;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: BackpressureHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private d() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(long j2, long j3) {
        long j4 = j2 + j3;
        return j4 < 0 ? m0.f12222b : j4;
    }

    public static long a(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == m0.f12222b) {
                return m0.f12222b;
            }
        } while (!atomicLong.compareAndSet(j3, a(j3, j2)));
        return j3;
    }

    public static long b(long j2, long j3) {
        long j4 = j2 * j3;
        return (((j2 | j3) >>> 31) == 0 || j4 / j2 == j3) ? j4 : m0.f12222b;
    }

    public static long c(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            if (j3 == m0.f12222b) {
                return m0.f12222b;
            }
            j4 = j3 - j2;
            if (j4 < 0) {
                h.a.c1.a.b(new IllegalStateException("More produced than requested: " + j4));
                j4 = 0L;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }

    public static long d(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j3 == m0.f12222b) {
                return m0.f12222b;
            }
            j4 = j3 - j2;
            if (j4 < 0) {
                h.a.c1.a.b(new IllegalStateException("More produced than requested: " + j4));
                j4 = 0L;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }

    public static long b(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j3 == m0.f12222b) {
                return m0.f12222b;
            }
        } while (!atomicLong.compareAndSet(j3, a(j3, j2)));
        return j3;
    }
}
