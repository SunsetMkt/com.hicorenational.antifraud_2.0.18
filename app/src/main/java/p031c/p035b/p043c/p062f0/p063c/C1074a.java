package p031c.p035b.p043c.p062f0.p063c;

import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: BitMatrixParser.java */
/* renamed from: c.b.c.f0.c.a */
/* loaded from: classes.dex */
final class C1074a {

    /* renamed from: a */
    private final C1163b f2113a;

    /* renamed from: b */
    private C1083j f2114b;

    /* renamed from: c */
    private C1080g f2115c;

    /* renamed from: d */
    private boolean f2116d;

    C1074a(C1163b c1163b) throws C1097h {
        int m2177d = c1163b.m2177d();
        if (m2177d < 21 || (m2177d & 3) != 1) {
            throw C1097h.getFormatInstance();
        }
        this.f2113a = c1163b;
    }

    /* renamed from: a */
    private int m1734a(int i2, int i3, int i4) {
        return this.f2116d ? this.f2113a.m2173b(i3, i2) : this.f2113a.m2173b(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    /* renamed from: b */
    byte[] m1737b() throws C1097h {
        C1080g m1738c = m1738c();
        C1083j m1739d = m1739d();
        AbstractC1076c m1744a = AbstractC1076c.m1744a(m1738c.m1764a());
        int m2177d = this.f2113a.m2177d();
        m1744a.m1745a(this.f2113a, m2177d);
        C1163b m1773a = m1739d.m1773a();
        byte[] bArr = new byte[m1739d.m1776d()];
        int i2 = m2177d - 1;
        int i3 = i2;
        int i4 = 0;
        boolean z = true;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            int i7 = i6;
            int i8 = i5;
            int i9 = i4;
            int i10 = 0;
            while (i10 < m2177d) {
                int i11 = z ? i2 - i10 : i10;
                int i12 = i7;
                int i13 = i8;
                int i14 = i9;
                for (int i15 = 0; i15 < 2; i15++) {
                    int i16 = i3 - i15;
                    if (!m1773a.m2173b(i16, i11)) {
                        i13++;
                        int i17 = i12 << 1;
                        int i18 = this.f2113a.m2173b(i16, i11) ? i17 | 1 : i17;
                        if (i13 == 8) {
                            bArr[i14] = (byte) i18;
                            i14++;
                            i13 = 0;
                            i12 = 0;
                        } else {
                            i12 = i18;
                        }
                    }
                }
                i10++;
                i9 = i14;
                i8 = i13;
                i7 = i12;
            }
            z = !z;
            i3 -= 2;
            i4 = i9;
            i5 = i8;
            i6 = i7;
        }
        if (i4 == m1739d.m1776d()) {
            return bArr;
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: c */
    C1080g m1738c() throws C1097h {
        C1080g c1080g = this.f2115c;
        if (c1080g != null) {
            return c1080g;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            i3 = m1734a(i4, 8, i3);
        }
        int m1734a = m1734a(8, 7, m1734a(8, 8, m1734a(7, 8, i3)));
        for (int i5 = 5; i5 >= 0; i5--) {
            m1734a = m1734a(8, i5, m1734a);
        }
        int m2177d = this.f2113a.m2177d();
        int i6 = m2177d - 7;
        for (int i7 = m2177d - 1; i7 >= i6; i7--) {
            i2 = m1734a(8, i7, i2);
        }
        for (int i8 = m2177d - 8; i8 < m2177d; i8++) {
            i2 = m1734a(i8, 8, i2);
        }
        this.f2115c = C1080g.m1761a(m1734a, i2);
        C1080g c1080g2 = this.f2115c;
        if (c1080g2 != null) {
            return c1080g2;
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: d */
    C1083j m1739d() throws C1097h {
        C1083j c1083j = this.f2114b;
        if (c1083j != null) {
            return c1083j;
        }
        int m2177d = this.f2113a.m2177d();
        int i2 = (m2177d - 17) / 4;
        if (i2 <= 6) {
            return C1083j.m1770c(i2);
        }
        int i3 = m2177d - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = m2177d - 9; i7 >= i3; i7--) {
                i5 = m1734a(i7, i6, i5);
            }
        }
        C1083j m1768a = C1083j.m1768a(i5);
        if (m1768a != null && m1768a.m1775c() == m2177d) {
            this.f2114b = m1768a;
            return m1768a;
        }
        for (int i8 = 5; i8 >= 0; i8--) {
            for (int i9 = m2177d - 9; i9 >= i3; i9--) {
                i4 = m1734a(i8, i9, i4);
            }
        }
        C1083j m1768a2 = C1083j.m1768a(i4);
        if (m1768a2 == null || m1768a2.m1775c() != m2177d) {
            throw C1097h.getFormatInstance();
        }
        this.f2114b = m1768a2;
        return m1768a2;
    }

    /* renamed from: e */
    void m1740e() {
        C1080g c1080g = this.f2115c;
        if (c1080g == null) {
            return;
        }
        AbstractC1076c.m1744a(c1080g.m1764a()).m1745a(this.f2113a, this.f2113a.m2177d());
    }

    /* renamed from: a */
    void m1736a(boolean z) {
        this.f2114b = null;
        this.f2115c = null;
        this.f2116d = z;
    }

    /* renamed from: a */
    void m1735a() {
        int i2 = 0;
        while (i2 < this.f2113a.m2181g()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f2113a.m2177d(); i4++) {
                if (this.f2113a.m2173b(i2, i4) != this.f2113a.m2173b(i4, i2)) {
                    this.f2113a.m2169a(i4, i2);
                    this.f2113a.m2169a(i2, i4);
                }
            }
            i2 = i3;
        }
    }
}
