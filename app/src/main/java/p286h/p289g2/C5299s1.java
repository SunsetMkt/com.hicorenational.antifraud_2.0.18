package p286h.p289g2;

import p286h.C5215b2;
import p286h.C5230f1;
import p286h.C5239g1;
import p286h.C5354k1;
import p286h.C5468o1;
import p286h.C5611t1;
import p286h.C5619u1;
import p286h.InterfaceC5352k;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: UArraySorting.kt */
/* renamed from: h.g2.s1 */
/* loaded from: classes2.dex */
public final class C5299s1 {
    @InterfaceC5352k
    /* renamed from: a */
    private static final int m21675a(byte[] bArr, int i2, int i3) {
        int i4;
        byte m18973a = C5239g1.m18973a(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int m18973a2 = C5239g1.m18973a(bArr, i2) & C5230f1.f20085c;
                i4 = m18973a & C5230f1.f20085c;
                if (C5544i0.m22512a(m18973a2, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (C5544i0.m22512a(C5239g1.m18973a(bArr, i3) & C5230f1.f20085c, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte m18973a3 = C5239g1.m18973a(bArr, i2);
                C5239g1.m18975a(bArr, i2, C5239g1.m18973a(bArr, i3));
                C5239g1.m18975a(bArr, i3, m18973a3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @InterfaceC5352k
    /* renamed from: b */
    private static final void m21683b(byte[] bArr, int i2, int i3) {
        int m21675a = m21675a(bArr, i2, i3);
        int i4 = m21675a - 1;
        if (i2 < i4) {
            m21683b(bArr, i2, i4);
        }
        if (m21675a < i3) {
            m21683b(bArr, m21675a, i3);
        }
    }

    @InterfaceC5352k
    /* renamed from: b */
    private static final void m21686b(short[] sArr, int i2, int i3) {
        int m21678a = m21678a(sArr, i2, i3);
        int i4 = m21678a - 1;
        if (i2 < i4) {
            m21686b(sArr, i2, i4);
        }
        if (m21678a < i3) {
            m21686b(sArr, m21678a, i3);
        }
    }

    @InterfaceC5352k
    /* renamed from: a */
    private static final int m21678a(short[] sArr, int i2, int i3) {
        int i4;
        short m22925a = C5619u1.m22925a(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                int m22925a2 = C5619u1.m22925a(sArr, i2) & C5611t1.f20467c;
                i4 = m22925a & C5611t1.f20467c;
                if (C5544i0.m22512a(m22925a2, i4) >= 0) {
                    break;
                }
                i2++;
            }
            while (C5544i0.m22512a(C5619u1.m22925a(sArr, i3) & C5611t1.f20467c, i4) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short m22925a3 = C5619u1.m22925a(sArr, i2);
                C5619u1.m22926a(sArr, i2, C5619u1.m22925a(sArr, i3));
                C5619u1.m22926a(sArr, i3, m22925a3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @InterfaceC5352k
    /* renamed from: b */
    private static final void m21684b(int[] iArr, int i2, int i3) {
        int m21676a = m21676a(iArr, i2, i3);
        int i4 = m21676a - 1;
        if (i2 < i4) {
            m21684b(iArr, i2, i4);
        }
        if (m21676a < i3) {
            m21684b(iArr, m21676a, i3);
        }
    }

    @InterfaceC5352k
    /* renamed from: b */
    private static final void m21685b(long[] jArr, int i2, int i3) {
        int m21677a = m21677a(jArr, i2, i3);
        int i4 = m21677a - 1;
        if (i2 < i4) {
            m21685b(jArr, i2, i4);
        }
        if (m21677a < i3) {
            m21685b(jArr, m21677a, i3);
        }
    }

    @InterfaceC5352k
    /* renamed from: a */
    private static final int m21676a(int[] iArr, int i2, int i3) {
        int m21982b = C5354k1.m21982b(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (C5215b2.m18812a(C5354k1.m21982b(iArr, i2), m21982b) < 0) {
                i2++;
            }
            while (C5215b2.m18812a(C5354k1.m21982b(iArr, i3), m21982b) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int m21982b2 = C5354k1.m21982b(iArr, i2);
                C5354k1.m21977a(iArr, i2, C5354k1.m21982b(iArr, i3));
                C5354k1.m21977a(iArr, i3, m21982b2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @InterfaceC5352k
    /* renamed from: a */
    private static final int m21677a(long[] jArr, int i2, int i3) {
        long m22414a = C5468o1.m22414a(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (C5215b2.m18813a(C5468o1.m22414a(jArr, i2), m22414a) < 0) {
                i2++;
            }
            while (C5215b2.m18813a(C5468o1.m22414a(jArr, i3), m22414a) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long m22414a2 = C5468o1.m22414a(jArr, i2);
                C5468o1.m22416a(jArr, i2, C5468o1.m22414a(jArr, i3));
                C5468o1.m22416a(jArr, i3, m22414a2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @InterfaceC5352k
    /* renamed from: a */
    public static final void m21679a(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "array");
        m21683b(bArr, 0, C5239g1.m18982c(bArr) - 1);
    }

    @InterfaceC5352k
    /* renamed from: a */
    public static final void m21682a(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "array");
        m21686b(sArr, 0, C5619u1.m22933c(sArr) - 1);
    }

    @InterfaceC5352k
    /* renamed from: a */
    public static final void m21680a(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "array");
        m21684b(iArr, 0, C5354k1.m21984c(iArr) - 1);
    }

    @InterfaceC5352k
    /* renamed from: a */
    public static final void m21681a(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "array");
        m21685b(jArr, 0, C5468o1.m22423c(jArr) - 1);
    }
}
