package p286h.p304m2;

import p286h.InterfaceC5440n0;

/* compiled from: progressionUtil.kt */
/* renamed from: h.m2.m */
/* loaded from: classes2.dex */
public final class C5433m {
    /* renamed from: a */
    private static final int m22182a(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static final int m22186b(int i2, int i3, int i4) {
        if (i4 > 0) {
            return i2 >= i3 ? i3 : i3 - m22183a(i3, i2, i4);
        }
        if (i4 < 0) {
            return i2 <= i3 ? i3 : i3 + m22183a(i2, i3, -i4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: a */
    private static final long m22184a(long j2, long j3) {
        long j4 = j2 % j3;
        return j4 >= 0 ? j4 : j4 + j3;
    }

    /* renamed from: a */
    private static final int m22183a(int i2, int i3, int i4) {
        return m22182a(m22182a(i2, i4) - m22182a(i3, i4), i4);
    }

    /* renamed from: a */
    private static final long m22185a(long j2, long j3, long j4) {
        return m22184a(m22184a(j2, j4) - m22184a(j3, j4), j4);
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static final long m22187b(long j2, long j3, long j4) {
        if (j4 > 0) {
            return j2 >= j3 ? j3 : j3 - m22185a(j3, j2, j4);
        }
        if (j4 < 0) {
            return j2 <= j3 ? j3 : j3 + m22185a(j2, j3, -j4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
