package p031c.p035b.p043c.p066x.p068e;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.p066x.C1113a;
import p031c.p035b.p043c.p072z.AbstractC1170i;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.p073m.C1174a;
import p031c.p035b.p043c.p072z.p073m.C1176c;
import p031c.p035b.p043c.p072z.p074n.C1177a;
import p031c.p035b.p043c.p072z.p074n.C1179c;
import p031c.p035b.p043c.p072z.p074n.C1181e;
import p286h.p323z2.C5736h0;

/* compiled from: Detector.java */
/* renamed from: c.b.c.x.e.a */
/* loaded from: classes.dex */
public final class C1117a {

    /* renamed from: g */
    private static final int[] f2237g = {3808, 476, 2107, 1799};

    /* renamed from: a */
    private final C1163b f2238a;

    /* renamed from: b */
    private boolean f2239b;

    /* renamed from: c */
    private int f2240c;

    /* renamed from: d */
    private int f2241d;

    /* renamed from: e */
    private int f2242e;

    /* renamed from: f */
    private int f2243f;

    /* compiled from: Detector.java */
    /* renamed from: c.b.c.x.e.a$a */
    static final class a {

        /* renamed from: a */
        private final int f2244a;

        /* renamed from: b */
        private final int f2245b;

        a(int i2, int i3) {
            this.f2244a = i2;
            this.f2245b = i3;
        }

        /* renamed from: a */
        int m1958a() {
            return this.f2244a;
        }

        /* renamed from: b */
        int m1959b() {
            return this.f2245b;
        }

        /* renamed from: c */
        C1109t m1960c() {
            return new C1109t(m1958a(), m1959b());
        }

        public String toString() {
            return "<" + this.f2244a + ' ' + this.f2245b + C5736h0.f20716e;
        }
    }

    public C1117a(C1163b c1163b) {
        this.f2238a = c1163b;
    }

    /* renamed from: b */
    private C1109t[] m1954b(C1109t[] c1109tArr) {
        return m1951a(c1109tArr, this.f2242e * 2, m1952b());
    }

    /* renamed from: c */
    private a m1955c() {
        C1109t m1960c;
        C1109t c1109t;
        C1109t c1109t2;
        C1109t c1109t3;
        C1109t m1960c2;
        C1109t m1960c3;
        C1109t m1960c4;
        C1109t m1960c5;
        try {
            C1109t[] m2230a = new C1176c(this.f2238a).m2230a();
            c1109t2 = m2230a[0];
            c1109t3 = m2230a[1];
            c1109t = m2230a[2];
            m1960c = m2230a[3];
        } catch (C1102m unused) {
            int m2181g = this.f2238a.m2181g() / 2;
            int m2177d = this.f2238a.m2177d() / 2;
            int i2 = m2181g + 7;
            int i3 = m2177d - 7;
            C1109t m1960c6 = m1944a(new a(i2, i3), false, 1, -1).m1960c();
            int i4 = m2177d + 7;
            C1109t m1960c7 = m1944a(new a(i2, i4), false, 1, 1).m1960c();
            int i5 = m2181g - 7;
            C1109t m1960c8 = m1944a(new a(i5, i4), false, -1, 1).m1960c();
            m1960c = m1944a(new a(i5, i3), false, -1, -1).m1960c();
            c1109t = m1960c8;
            c1109t2 = m1960c6;
            c1109t3 = m1960c7;
        }
        int m2223a = C1174a.m2223a((((c1109t2.m1922a() + m1960c.m1922a()) + c1109t3.m1922a()) + c1109t.m1922a()) / 4.0f);
        int m2223a2 = C1174a.m2223a((((c1109t2.m1923b() + m1960c.m1923b()) + c1109t3.m1923b()) + c1109t.m1923b()) / 4.0f);
        try {
            C1109t[] m2230a2 = new C1176c(this.f2238a, 15, m2223a, m2223a2).m2230a();
            m1960c2 = m2230a2[0];
            m1960c3 = m2230a2[1];
            m1960c4 = m2230a2[2];
            m1960c5 = m2230a2[3];
        } catch (C1102m unused2) {
            int i6 = m2223a + 7;
            int i7 = m2223a2 - 7;
            m1960c2 = m1944a(new a(i6, i7), false, 1, -1).m1960c();
            int i8 = m2223a2 + 7;
            m1960c3 = m1944a(new a(i6, i8), false, 1, 1).m1960c();
            int i9 = m2223a - 7;
            m1960c4 = m1944a(new a(i9, i8), false, -1, 1).m1960c();
            m1960c5 = m1944a(new a(i9, i7), false, -1, -1).m1960c();
        }
        return new a(C1174a.m2223a((((m1960c2.m1922a() + m1960c5.m1922a()) + m1960c3.m1922a()) + m1960c4.m1922a()) / 4.0f), C1174a.m2223a((((m1960c2.m1923b() + m1960c5.m1923b()) + m1960c3.m1923b()) + m1960c4.m1923b()) / 4.0f));
    }

    /* renamed from: a */
    public C1113a m1956a() throws C1102m {
        return m1957a(false);
    }

    /* renamed from: b */
    private int m1953b(a aVar, a aVar2) {
        float m1940a = m1940a(aVar, aVar2);
        float m1958a = (aVar2.m1958a() - aVar.m1958a()) / m1940a;
        float m1959b = (aVar2.m1959b() - aVar.m1959b()) / m1940a;
        float m1958a2 = aVar.m1958a();
        float m1959b2 = aVar.m1959b();
        boolean m2173b = this.f2238a.m2173b(aVar.m1958a(), aVar.m1959b());
        float f2 = m1958a2;
        float f3 = m1959b2;
        int i2 = 0;
        for (int i3 = 0; i3 < m1940a; i3++) {
            f2 += m1958a;
            f3 += m1959b;
            if (this.f2238a.m2173b(C1174a.m2223a(f2), C1174a.m2223a(f3)) != m2173b) {
                i2++;
            }
        }
        float f4 = i2 / m1940a;
        if (f4 <= 0.1f || f4 >= 0.9f) {
            return (f4 <= 0.1f) == m2173b ? 1 : -1;
        }
        return 0;
    }

    /* renamed from: a */
    public C1113a m1957a(boolean z) throws C1102m {
        C1109t[] m1950a = m1950a(m1955c());
        if (z) {
            C1109t c1109t = m1950a[0];
            m1950a[0] = m1950a[2];
            m1950a[2] = c1109t;
        }
        m1946a(m1950a);
        C1163b c1163b = this.f2238a;
        int i2 = this.f2243f;
        return new C1113a(m1945a(c1163b, m1950a[i2 % 4], m1950a[(i2 + 1) % 4], m1950a[(i2 + 2) % 4], m1950a[(i2 + 3) % 4]), m1954b(m1950a), this.f2239b, this.f2241d, this.f2240c);
    }

    /* renamed from: b */
    private int m1952b() {
        if (this.f2239b) {
            return (this.f2240c * 4) + 11;
        }
        int i2 = this.f2240c;
        return i2 <= 4 ? (i2 * 4) + 15 : (i2 * 4) + ((((i2 - 4) / 8) + 1) * 2) + 15;
    }

    /* renamed from: a */
    private void m1946a(C1109t[] c1109tArr) throws C1102m {
        long j2;
        long j3;
        if (m1948a(c1109tArr[0]) && m1948a(c1109tArr[1]) && m1948a(c1109tArr[2]) && m1948a(c1109tArr[3])) {
            int i2 = this.f2242e * 2;
            int[] iArr = {m1942a(c1109tArr[0], c1109tArr[1], i2), m1942a(c1109tArr[1], c1109tArr[2], i2), m1942a(c1109tArr[2], c1109tArr[3], i2), m1942a(c1109tArr[3], c1109tArr[0], i2)};
            this.f2243f = m1943a(iArr, i2);
            long j4 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = iArr[(this.f2243f + i3) % 4];
                if (this.f2239b) {
                    j2 = j4 << 7;
                    j3 = (i4 >> 1) & 127;
                } else {
                    j2 = j4 << 10;
                    j3 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
                }
                j4 = j2 + j3;
            }
            int m1941a = m1941a(j4, this.f2239b);
            if (this.f2239b) {
                this.f2240c = (m1941a >> 6) + 1;
                this.f2241d = (m1941a & 63) + 1;
                return;
            } else {
                this.f2240c = (m1941a >> 11) + 1;
                this.f2241d = (m1941a & 2047) + 1;
                return;
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m1943a(int[] iArr, int i2) throws C1102m {
        int i3 = 0;
        for (int i4 : iArr) {
            i3 = (i3 << 3) + ((i4 >> (i2 - 2)) << 1) + (i4 & 1);
        }
        int i5 = ((i3 & 1) << 11) + (i3 >> 1);
        for (int i6 = 0; i6 < 4; i6++) {
            if (Integer.bitCount(f2237g[i6] ^ i5) <= 2) {
                return i6;
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m1941a(long j2, boolean z) throws C1102m {
        int i2;
        int i3;
        if (z) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iArr[i5] = ((int) j2) & 15;
            j2 >>= 4;
        }
        try {
            new C1179c(C1177a.f2452k).m2254a(iArr, i4);
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                i6 = (i6 << 4) + iArr[i7];
            }
            return i6;
        } catch (C1181e unused) {
            throw C1102m.getNotFoundInstance();
        }
    }

    /* renamed from: a */
    private C1109t[] m1950a(a aVar) throws C1102m {
        this.f2242e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        a aVar5 = aVar4;
        boolean z = true;
        while (this.f2242e < 9) {
            a m1944a = m1944a(aVar2, z, 1, -1);
            a m1944a2 = m1944a(aVar3, z, 1, 1);
            a m1944a3 = m1944a(aVar4, z, -1, 1);
            a m1944a4 = m1944a(aVar5, z, -1, -1);
            if (this.f2242e > 2) {
                double m1940a = (m1940a(m1944a4, m1944a) * this.f2242e) / (m1940a(aVar5, aVar2) * (this.f2242e + 2));
                if (m1940a < 0.75d || m1940a > 1.25d || !m1949a(m1944a, m1944a2, m1944a3, m1944a4)) {
                    break;
                }
            }
            z = !z;
            this.f2242e++;
            aVar5 = m1944a4;
            aVar2 = m1944a;
            aVar3 = m1944a2;
            aVar4 = m1944a3;
        }
        int i2 = this.f2242e;
        if (i2 != 5 && i2 != 7) {
            throw C1102m.getNotFoundInstance();
        }
        this.f2239b = this.f2242e == 5;
        C1109t[] c1109tArr = {new C1109t(aVar2.m1958a() + 0.5f, aVar2.m1959b() - 0.5f), new C1109t(aVar3.m1958a() + 0.5f, aVar3.m1959b() + 0.5f), new C1109t(aVar4.m1958a() - 0.5f, aVar4.m1959b() + 0.5f), new C1109t(aVar5.m1958a() - 0.5f, aVar5.m1959b() - 0.5f)};
        int i3 = this.f2242e;
        return m1951a(c1109tArr, (i3 * 2) - 3, i3 * 2);
    }

    /* renamed from: a */
    private C1163b m1945a(C1163b c1163b, C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4) throws C1102m {
        AbstractC1170i m2206a = AbstractC1170i.m2206a();
        int m1952b = m1952b();
        float f2 = m1952b / 2.0f;
        int i2 = this.f2242e;
        float f3 = f2 - i2;
        float f4 = f2 + i2;
        return m2206a.mo2200a(c1163b, m1952b, m1952b, f3, f3, f4, f3, f4, f4, f3, f4, c1109t.m1922a(), c1109t.m1923b(), c1109t2.m1922a(), c1109t2.m1923b(), c1109t3.m1922a(), c1109t3.m1923b(), c1109t4.m1922a(), c1109t4.m1923b());
    }

    /* renamed from: a */
    private int m1942a(C1109t c1109t, C1109t c1109t2, int i2) {
        float m1939a = m1939a(c1109t, c1109t2);
        float f2 = m1939a / i2;
        float m1922a = c1109t.m1922a();
        float m1923b = c1109t.m1923b();
        float m1922a2 = ((c1109t2.m1922a() - c1109t.m1922a()) * f2) / m1939a;
        float m1923b2 = (f2 * (c1109t2.m1923b() - c1109t.m1923b())) / m1939a;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = i4;
            if (this.f2238a.m2173b(C1174a.m2223a((f3 * m1922a2) + m1922a), C1174a.m2223a((f3 * m1923b2) + m1923b))) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* renamed from: a */
    private boolean m1949a(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.m1958a() - 3, aVar.m1959b() + 3);
        a aVar6 = new a(aVar2.m1958a() - 3, aVar2.m1959b() - 3);
        a aVar7 = new a(aVar3.m1958a() + 3, aVar3.m1959b() - 3);
        a aVar8 = new a(aVar4.m1958a() + 3, aVar4.m1959b() + 3);
        int m1953b = m1953b(aVar8, aVar5);
        return m1953b != 0 && m1953b(aVar5, aVar6) == m1953b && m1953b(aVar6, aVar7) == m1953b && m1953b(aVar7, aVar8) == m1953b;
    }

    /* renamed from: a */
    private a m1944a(a aVar, boolean z, int i2, int i3) {
        int m1958a = aVar.m1958a() + i2;
        int m1959b = aVar.m1959b();
        while (true) {
            m1959b += i3;
            if (!m1947a(m1958a, m1959b) || this.f2238a.m2173b(m1958a, m1959b) != z) {
                break;
            }
            m1958a += i2;
        }
        int i4 = m1958a - i2;
        int i5 = m1959b - i3;
        while (m1947a(i4, i5) && this.f2238a.m2173b(i4, i5) == z) {
            i4 += i2;
        }
        int i6 = i4 - i2;
        while (m1947a(i6, i5) && this.f2238a.m2173b(i6, i5) == z) {
            i5 += i3;
        }
        return new a(i6, i5 - i3);
    }

    /* renamed from: a */
    private static C1109t[] m1951a(C1109t[] c1109tArr, float f2, float f3) {
        float f4 = f3 / (f2 * 2.0f);
        float m1922a = c1109tArr[0].m1922a() - c1109tArr[2].m1922a();
        float m1923b = c1109tArr[0].m1923b() - c1109tArr[2].m1923b();
        float m1922a2 = (c1109tArr[0].m1922a() + c1109tArr[2].m1922a()) / 2.0f;
        float m1923b2 = (c1109tArr[0].m1923b() + c1109tArr[2].m1923b()) / 2.0f;
        float f5 = m1922a * f4;
        float f6 = m1923b * f4;
        C1109t c1109t = new C1109t(m1922a2 + f5, m1923b2 + f6);
        C1109t c1109t2 = new C1109t(m1922a2 - f5, m1923b2 - f6);
        float m1922a3 = c1109tArr[1].m1922a() - c1109tArr[3].m1922a();
        float m1923b3 = c1109tArr[1].m1923b() - c1109tArr[3].m1923b();
        float m1922a4 = (c1109tArr[1].m1922a() + c1109tArr[3].m1922a()) / 2.0f;
        float m1923b4 = (c1109tArr[1].m1923b() + c1109tArr[3].m1923b()) / 2.0f;
        float f7 = m1922a3 * f4;
        float f8 = f4 * m1923b3;
        return new C1109t[]{c1109t, new C1109t(m1922a4 + f7, m1923b4 + f8), c1109t2, new C1109t(m1922a4 - f7, m1923b4 - f8)};
    }

    /* renamed from: a */
    private boolean m1947a(int i2, int i3) {
        return i2 >= 0 && i2 < this.f2238a.m2181g() && i3 > 0 && i3 < this.f2238a.m2177d();
    }

    /* renamed from: a */
    private boolean m1948a(C1109t c1109t) {
        return m1947a(C1174a.m2223a(c1109t.m1922a()), C1174a.m2223a(c1109t.m1923b()));
    }

    /* renamed from: a */
    private static float m1940a(a aVar, a aVar2) {
        return C1174a.m2222a(aVar.m1958a(), aVar.m1959b(), aVar2.m1958a(), aVar2.m1959b());
    }

    /* renamed from: a */
    private static float m1939a(C1109t c1109t, C1109t c1109t2) {
        return C1174a.m2221a(c1109t.m1922a(), c1109t.m1923b(), c1109t2.m1922a(), c1109t2.m1923b());
    }
}
