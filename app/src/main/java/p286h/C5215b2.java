package p286h;

import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5556m0;
import p286h.p323z2.C5727d;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: UnsignedUtils.kt */
@InterfaceC5481e(name = "UnsignedKt")
/* renamed from: h.b2 */
/* loaded from: classes2.dex */
public final class C5215b2 {
    @InterfaceC5440n0
    /* renamed from: a */
    public static final double m18809a(int i2) {
        return (Integer.MAX_VALUE & i2) + (((i2 >>> 31) << 30) * 2);
    }

    @InterfaceC5440n0
    /* renamed from: a */
    public static final double m18810a(long j2) {
        return ((j2 >>> 11) * 2048) + (j2 & 2047);
    }

    @InterfaceC5440n0
    /* renamed from: a */
    public static final int m18812a(int i2, int i3) {
        return C5544i0.m22512a(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    @InterfaceC5440n0
    /* renamed from: a */
    public static final int m18813a(long j2, long j3) {
        return ((j2 ^ Long.MIN_VALUE) > (j3 ^ Long.MIN_VALUE) ? 1 : ((j2 ^ Long.MIN_VALUE) == (j3 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static final int m18815b(int i2, int i3) {
        return C5341j1.m21929c((int) ((i2 & 4294967295L) / (i3 & 4294967295L)));
    }

    @InterfaceC5440n0
    /* renamed from: c */
    public static final int m18819c(int i2, int i3) {
        return C5341j1.m21929c((int) ((i2 & 4294967295L) % (i3 & 4294967295L)));
    }

    @InterfaceC5440n0
    /* renamed from: a */
    public static final int m18811a(double d2) {
        if (Double.isNaN(d2) || d2 <= m18809a(0)) {
            return 0;
        }
        if (d2 >= m18809a(-1)) {
            return -1;
        }
        double d3 = Integer.MAX_VALUE;
        return d2 <= d3 ? C5341j1.m21929c((int) d2) : C5341j1.m21929c(C5341j1.m21929c((int) (d2 - d3)) + C5341j1.m21929c(Integer.MAX_VALUE));
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static final long m18817b(long j2, long j3) {
        if (j3 < 0) {
            return m18813a(j2, j3) < 0 ? C5441n1.m22205c(0L) : C5441n1.m22205c(1L);
        }
        if (j2 >= 0) {
            return C5441n1.m22205c(j2 / j3);
        }
        long j4 = ((j2 >>> 1) / j3) << 1;
        return C5441n1.m22205c(j4 + (m18813a(C5441n1.m22205c(j2 - (j4 * j3)), C5441n1.m22205c(j3)) < 0 ? 0 : 1));
    }

    @InterfaceC5440n0
    /* renamed from: c */
    public static final long m18820c(long j2, long j3) {
        if (j3 < 0) {
            return m18813a(j2, j3) < 0 ? j2 : C5441n1.m22205c(j2 - j3);
        }
        if (j2 >= 0) {
            return C5441n1.m22205c(j2 % j3);
        }
        long j4 = j2 - ((((j2 >>> 1) / j3) << 1) * j3);
        if (m18813a(C5441n1.m22205c(j4), C5441n1.m22205c(j3)) < 0) {
            j3 = 0;
        }
        return C5441n1.m22205c(j4 - j3);
    }

    @InterfaceC5440n0
    /* renamed from: b */
    public static final long m18816b(double d2) {
        if (Double.isNaN(d2) || d2 <= m18810a(0L)) {
            return 0L;
        }
        if (d2 >= m18810a(-1L)) {
            return -1L;
        }
        if (d2 < C5556m0.f20396b) {
            return C5441n1.m22205c((long) d2);
        }
        return C5441n1.m22205c(C5441n1.m22205c((long) (d2 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final String m18814a(long j2, int i2) {
        int m23807a;
        int m23807a2;
        int m23807a3;
        if (j2 >= 0) {
            m23807a3 = C5727d.m23807a(i2);
            String l2 = Long.toString(j2, m23807a3);
            C5544i0.m22521a((Object) l2, "java.lang.Long.toString(this, checkRadix(radix))");
            return l2;
        }
        long j3 = i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        m23807a = C5727d.m23807a(i2);
        String l3 = Long.toString(j4, m23807a);
        C5544i0.m22521a((Object) l3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l3);
        m23807a2 = C5727d.m23807a(i2);
        String l4 = Long.toString(j5, m23807a2);
        C5544i0.m22521a((Object) l4, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l4);
        return sb.toString();
    }

    @InterfaceC5816d
    /* renamed from: b */
    public static final String m18818b(long j2) {
        return m18814a(j2, 10);
    }
}
