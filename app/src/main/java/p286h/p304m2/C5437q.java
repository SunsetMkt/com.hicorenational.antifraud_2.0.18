package p286h.p304m2;

import p286h.C5215b2;
import p286h.C5341j1;
import p286h.C5441n1;
import p286h.InterfaceC5440n0;
import p286h.InterfaceC5610t0;

/* compiled from: UProgressionUtil.kt */
/* renamed from: h.m2.q */
/* loaded from: classes2.dex */
public final class C5437q {
    /* renamed from: a */
    private static final int m22188a(int i2, int i3, int i4) {
        int m18819c = C5215b2.m18819c(i2, i4);
        int m18819c2 = C5215b2.m18819c(i3, i4);
        int m18812a = C5215b2.m18812a(m18819c, m18819c2);
        int m21929c = C5341j1.m21929c(m18819c - m18819c2);
        return m18812a >= 0 ? m21929c : C5341j1.m21929c(m21929c + i4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: b */
    public static final int m22190b(int i2, int i3, int i4) {
        if (i4 > 0) {
            return C5215b2.m18812a(i2, i3) >= 0 ? i3 : C5341j1.m21929c(i3 - m22188a(i3, i2, C5341j1.m21929c(i4)));
        }
        if (i4 < 0) {
            return C5215b2.m18812a(i2, i3) <= 0 ? i3 : C5341j1.m21929c(i3 + m22188a(i2, i3, C5341j1.m21929c(-i4)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: a */
    private static final long m22189a(long j2, long j3, long j4) {
        long m18820c = C5215b2.m18820c(j2, j4);
        long m18820c2 = C5215b2.m18820c(j3, j4);
        int m18813a = C5215b2.m18813a(m18820c, m18820c2);
        long m22205c = C5441n1.m22205c(m18820c - m18820c2);
        return m18813a >= 0 ? m22205c : C5441n1.m22205c(m22205c + j4);
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5440n0
    /* renamed from: b */
    public static final long m22191b(long j2, long j3, long j4) {
        if (j4 > 0) {
            return C5215b2.m18813a(j2, j3) >= 0 ? j3 : C5441n1.m22205c(j3 - m22189a(j3, j2, C5441n1.m22205c(j4)));
        }
        if (j4 < 0) {
            return C5215b2.m18813a(j2, j3) <= 0 ? j3 : C5441n1.m22205c(j3 + m22189a(j2, j3, C5441n1.m22205c(-j4)));
        }
        throw new IllegalArgumentException("Step is zero.");
    }
}
