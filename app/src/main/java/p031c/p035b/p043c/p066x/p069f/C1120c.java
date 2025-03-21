package p031c.p035b.p043c.p066x.p069f;

import p031c.p035b.p043c.p072z.C1162a;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.p074n.C1177a;
import p031c.p035b.p043c.p072z.p074n.C1180d;

/* compiled from: Encoder.java */
/* renamed from: c.b.c.x.f.c */
/* loaded from: classes.dex */
public final class C1120c {

    /* renamed from: a */
    public static final int f2253a = 33;

    /* renamed from: b */
    public static final int f2254b = 0;

    /* renamed from: c */
    private static final int f2255c = 32;

    /* renamed from: d */
    private static final int f2256d = 4;

    /* renamed from: e */
    private static final int[] f2257e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private C1120c() {
    }

    /* renamed from: a */
    private static int m1972a(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 * 16)) * i2;
    }

    /* renamed from: a */
    public static C1118a m1973a(byte[] bArr) {
        return m1974a(bArr, 33, 0);
    }

    /* renamed from: b */
    private static C1162a m1981b(C1162a c1162a, int i2, int i3) {
        int m2157c = c1162a.m2157c() / i3;
        C1180d c1180d = new C1180d(m1977a(i3));
        int i4 = i2 / i3;
        int[] m1980a = m1980a(c1162a, i3, i4);
        c1180d.m2256a(m1980a, i4 - m2157c);
        C1162a c1162a2 = new C1162a();
        c1162a2.m2148a(0, i2 % i3);
        for (int i5 : m1980a) {
            c1162a2.m2148a(i5, i3);
        }
        return c1162a2;
    }

    /* renamed from: a */
    public static C1118a m1974a(byte[] bArr, int i2, int i3) {
        int i4;
        C1162a c1162a;
        boolean z;
        int i5;
        int i6;
        int i7;
        C1162a m1987a = new C1121d(bArr).m1987a();
        int m2157c = ((m1987a.m2157c() * i2) / 100) + 11;
        int m2157c2 = m1987a.m2157c() + m2157c;
        int i8 = 0;
        int i9 = 1;
        if (i3 == 0) {
            C1162a c1162a2 = null;
            int i10 = 0;
            i4 = 0;
            while (i10 <= 32) {
                boolean z2 = i10 <= 3;
                int i11 = z2 ? i10 + 1 : i10;
                int m1972a = m1972a(i11, z2);
                if (m2157c2 <= m1972a) {
                    int[] iArr = f2257e;
                    if (i4 != iArr[i11]) {
                        i4 = iArr[i11];
                        c1162a2 = m1975a(m1987a, i4);
                    }
                    int i12 = m1972a - (m1972a % i4);
                    if ((!z2 || c1162a2.m2157c() <= i4 * 64) && c1162a2.m2157c() + m2157c <= i12) {
                        c1162a = c1162a2;
                        z = z2;
                        i5 = i11;
                        i6 = m1972a;
                    }
                }
                i10++;
                i8 = 0;
                i9 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z = i3 < 0;
        i5 = Math.abs(i3);
        if (i5 > (z ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
        }
        i6 = m1972a(i5, z);
        i4 = f2257e[i5];
        int i13 = i6 - (i6 % i4);
        c1162a = m1975a(m1987a, i4);
        if (c1162a.m2157c() + m2157c > i13) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z && c1162a.m2157c() > i4 * 64) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        C1162a m1981b = m1981b(c1162a, i6, i4);
        int m2157c3 = c1162a.m2157c() / i4;
        C1162a m1976a = m1976a(z, i5, m2157c3);
        int i14 = z ? (i5 * 4) + 11 : (i5 * 4) + 14;
        int[] iArr2 = new int[i14];
        int i15 = 2;
        if (z) {
            for (int i16 = 0; i16 < iArr2.length; i16++) {
                iArr2[i16] = i16;
            }
            i7 = i14;
        } else {
            int i17 = i14 / 2;
            i7 = i14 + 1 + (((i17 - 1) / 15) * 2);
            int i18 = i7 / 2;
            for (int i19 = 0; i19 < i17; i19++) {
                iArr2[(i17 - i19) - 1] = (i18 - r15) - 1;
                iArr2[i17 + i19] = (i19 / 15) + i19 + i18 + i9;
            }
        }
        C1163b c1163b = new C1163b(i7);
        int i20 = 0;
        int i21 = 0;
        while (i20 < i5) {
            int i22 = (i5 - i20) * 4;
            int i23 = z ? i22 + 9 : i22 + 12;
            int i24 = 0;
            while (i24 < i23) {
                int i25 = i24 * 2;
                while (i8 < i15) {
                    if (m1981b.m2155b(i21 + i25 + i8)) {
                        int i26 = i20 * 2;
                        c1163b.m2175c(iArr2[i26 + i8], iArr2[i26 + i24]);
                    }
                    if (m1981b.m2155b((i23 * 2) + i21 + i25 + i8)) {
                        int i27 = i20 * 2;
                        c1163b.m2175c(iArr2[i27 + i24], iArr2[((i14 - 1) - i27) - i8]);
                    }
                    if (m1981b.m2155b((i23 * 4) + i21 + i25 + i8)) {
                        int i28 = (i14 - 1) - (i20 * 2);
                        c1163b.m2175c(iArr2[i28 - i8], iArr2[i28 - i24]);
                    }
                    if (m1981b.m2155b((i23 * 6) + i21 + i25 + i8)) {
                        int i29 = i20 * 2;
                        c1163b.m2175c(iArr2[((i14 - 1) - i29) - i24], iArr2[i29 + i8]);
                    }
                    i8++;
                    i15 = 2;
                }
                i24++;
                i8 = 0;
                i15 = 2;
            }
            i21 += i23 * 8;
            i20++;
            i8 = 0;
            i15 = 2;
        }
        m1979a(c1163b, z, i7, m1976a);
        if (z) {
            m1978a(c1163b, i7 / 2, 5);
        } else {
            int i30 = i7 / 2;
            m1978a(c1163b, i30, 7);
            int i31 = 0;
            int i32 = 0;
            while (i31 < (i14 / 2) - 1) {
                for (int i33 = i30 & 1; i33 < i7; i33 += 2) {
                    int i34 = i30 - i32;
                    c1163b.m2175c(i34, i33);
                    int i35 = i30 + i32;
                    c1163b.m2175c(i35, i33);
                    c1163b.m2175c(i33, i34);
                    c1163b.m2175c(i33, i35);
                }
                i31 += 15;
                i32 += 16;
            }
        }
        C1118a c1118a = new C1118a();
        c1118a.m1964a(z);
        c1118a.m1968c(i7);
        c1118a.m1966b(i5);
        c1118a.m1962a(m2157c3);
        c1118a.m1963a(c1163b);
        return c1118a;
    }

    /* renamed from: a */
    private static void m1978a(C1163b c1163b, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    c1163b.m2175c(i6, i5);
                    c1163b.m2175c(i6, i7);
                    c1163b.m2175c(i5, i6);
                    c1163b.m2175c(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        c1163b.m2175c(i8, i8);
        int i9 = i8 + 1;
        c1163b.m2175c(i9, i8);
        c1163b.m2175c(i8, i9);
        int i10 = i2 + i3;
        c1163b.m2175c(i10, i8);
        c1163b.m2175c(i10, i9);
        c1163b.m2175c(i10, i10 - 1);
    }

    /* renamed from: a */
    static C1162a m1976a(boolean z, int i2, int i3) {
        C1162a c1162a = new C1162a();
        if (z) {
            c1162a.m2148a(i2 - 1, 2);
            c1162a.m2148a(i3 - 1, 6);
            return m1981b(c1162a, 28, 4);
        }
        c1162a.m2148a(i2 - 1, 5);
        c1162a.m2148a(i3 - 1, 11);
        return m1981b(c1162a, 40, 4);
    }

    /* renamed from: a */
    private static void m1979a(C1163b c1163b, boolean z, int i2, C1162a c1162a) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (c1162a.m2155b(i4)) {
                    c1163b.m2175c(i5, i3 - 5);
                }
                if (c1162a.m2155b(i4 + 7)) {
                    c1163b.m2175c(i3 + 5, i5);
                }
                if (c1162a.m2155b(20 - i4)) {
                    c1163b.m2175c(i5, i3 + 5);
                }
                if (c1162a.m2155b(27 - i4)) {
                    c1163b.m2175c(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (c1162a.m2155b(i4)) {
                c1163b.m2175c(i6, i3 - 7);
            }
            if (c1162a.m2155b(i4 + 10)) {
                c1163b.m2175c(i3 + 7, i6);
            }
            if (c1162a.m2155b(29 - i4)) {
                c1163b.m2175c(i6, i3 + 7);
            }
            if (c1162a.m2155b(39 - i4)) {
                c1163b.m2175c(i3 - 7, i6);
            }
            i4++;
        }
    }

    /* renamed from: a */
    private static int[] m1980a(C1162a c1162a, int i2, int i3) {
        int[] iArr = new int[i3];
        int m2157c = c1162a.m2157c() / i2;
        for (int i4 = 0; i4 < m2157c; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= c1162a.m2155b((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    /* renamed from: a */
    private static C1177a m1977a(int i2) {
        if (i2 == 4) {
            return C1177a.f2452k;
        }
        if (i2 == 6) {
            return C1177a.f2451j;
        }
        if (i2 == 8) {
            return C1177a.f2455n;
        }
        if (i2 == 10) {
            return C1177a.f2450i;
        }
        if (i2 == 12) {
            return C1177a.f2449h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i2);
    }

    /* renamed from: a */
    static C1162a m1975a(C1162a c1162a, int i2) {
        C1162a c1162a2 = new C1162a();
        int m2157c = c1162a.m2157c();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < m2157c) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= m2157c || c1162a.m2155b(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                c1162a2.m2148a(i8, i2);
            } else if (i8 == 0) {
                c1162a2.m2148a(i5 | 1, i2);
            } else {
                c1162a2.m2148a(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return c1162a2;
    }
}
