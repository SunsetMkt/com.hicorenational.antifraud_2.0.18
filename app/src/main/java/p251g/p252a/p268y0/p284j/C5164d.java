package p251g.p252a.p268y0.p284j;

import java.util.concurrent.atomic.AtomicLong;
import p251g.p252a.p255c1.C4476a;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: BackpressureHelper.java */
/* renamed from: g.a.y0.j.d */
/* loaded from: classes2.dex */
public final class C5164d {
    private C5164d() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static long m18606a(long j2, long j3) {
        long j4 = j2 + j3;
        return j4 < 0 ? C5556m0.f20396b : j4;
    }

    /* renamed from: a */
    public static long m18607a(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == C5556m0.f20396b) {
                return C5556m0.f20396b;
            }
        } while (!atomicLong.compareAndSet(j3, m18606a(j3, j2)));
        return j3;
    }

    /* renamed from: b */
    public static long m18608b(long j2, long j3) {
        long j4 = j2 * j3;
        return (((j2 | j3) >>> 31) == 0 || j4 / j2 == j3) ? j4 : C5556m0.f20396b;
    }

    /* renamed from: c */
    public static long m18610c(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            if (j3 == C5556m0.f20396b) {
                return C5556m0.f20396b;
            }
            j4 = j3 - j2;
            if (j4 < 0) {
                C4476a.m17152b(new IllegalStateException("More produced than requested: " + j4));
                j4 = 0L;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }

    /* renamed from: d */
    public static long m18611d(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j3 == C5556m0.f20396b) {
                return C5556m0.f20396b;
            }
            j4 = j3 - j2;
            if (j4 < 0) {
                C4476a.m17152b(new IllegalStateException("More produced than requested: " + j4));
                j4 = 0L;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }

    /* renamed from: b */
    public static long m18609b(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j3 == C5556m0.f20396b) {
                return C5556m0.f20396b;
            }
        } while (!atomicLong.compareAndSet(j3, m18606a(j3, j2)));
        return j3;
    }
}
