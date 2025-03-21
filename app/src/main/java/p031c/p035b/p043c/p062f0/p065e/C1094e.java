package p031c.p035b.p043c.p062f0.p065e;

import com.luck.picture.lib.config.PictureConfig;
import com.tencent.bugly.beta.tinker.TinkerReport;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.p062f0.p063c.C1083j;
import p031c.p035b.p043c.p062f0.p063c.EnumC1079f;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: MatrixUtil.java */
/* renamed from: c.b.c.f0.e.e */
/* loaded from: classes.dex */
final class C1094e {

    /* renamed from: a */
    private static final int[][] f2183a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b */
    private static final int[][] f2184b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c */
    private static final int[][] f2185c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, PictureConfig.PREVIEW_VIDEO_CODE}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d */
    private static final int[][] f2186d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: e */
    private static final int f2187e = 7973;

    /* renamed from: f */
    private static final int f2188f = 1335;

    /* renamed from: g */
    private static final int f2189g = 21522;

    private C1094e() {
    }

    /* renamed from: a */
    static int m1863a(int i2) {
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    /* renamed from: a */
    static void m1870a(C1091b c1091b) {
        c1091b.m1827a((byte) -1);
    }

    /* renamed from: b */
    private static void m1875b(C1091b c1091b) throws C1112w {
        if (c1091b.m1826a(8, c1091b.m1832b() - 8) == 0) {
            throw new C1112w();
        }
        c1091b.m1829a(8, c1091b.m1832b() - 8, 1);
    }

    /* renamed from: b */
    private static boolean m1876b(int i2) {
        return i2 == -1;
    }

    /* renamed from: c */
    static void m1878c(C1083j c1083j, C1091b c1091b) throws C1112w {
        if (c1083j.m1777e() < 7) {
            return;
        }
        C1162a c1162a = new C1162a();
        m1869a(c1083j, c1162a);
        int i2 = 0;
        int i3 = 17;
        while (i2 < 6) {
            int i4 = i3;
            for (int i5 = 0; i5 < 3; i5++) {
                boolean m2155b = c1162a.m2155b(i4);
                i4--;
                c1091b.m1830a(i2, (c1091b.m1832b() - 11) + i5, m2155b);
                c1091b.m1830a((c1091b.m1832b() - 11) + i5, i2, m2155b);
            }
            i2++;
            i3 = i4;
        }
    }

    /* renamed from: d */
    private static void m1881d(C1091b c1091b) {
        int i2 = 8;
        while (i2 < c1091b.m1833c() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (m1876b(c1091b.m1826a(i2, 6))) {
                c1091b.m1829a(i2, 6, i4);
            }
            if (m1876b(c1091b.m1826a(6, i2))) {
                c1091b.m1829a(6, i2, i4);
            }
            i2 = i3;
        }
    }

    /* renamed from: a */
    static void m1872a(C1162a c1162a, EnumC1079f enumC1079f, C1083j c1083j, int i2, C1091b c1091b) throws C1112w {
        m1870a(c1091b);
        m1868a(c1083j, c1091b);
        m1866a(enumC1079f, i2, c1091b);
        m1878c(c1083j, c1091b);
        m1871a(c1162a, i2, c1091b);
    }

    /* renamed from: b */
    private static void m1873b(int i2, int i3, C1091b c1091b) {
        for (int i4 = 0; i4 < 5; i4++) {
            for (int i5 = 0; i5 < 5; i5++) {
                c1091b.m1829a(i2 + i5, i3 + i4, f2184b[i4][i5]);
            }
        }
    }

    /* renamed from: b */
    private static void m1874b(C1083j c1083j, C1091b c1091b) {
        if (c1083j.m1777e() < 2) {
            return;
        }
        int m1777e = c1083j.m1777e() - 1;
        int[][] iArr = f2185c;
        int[] iArr2 = iArr[m1777e];
        int length = iArr[m1777e].length;
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = iArr2[i2];
                int i5 = iArr2[i3];
                if (i5 != -1 && i4 != -1 && m1876b(c1091b.m1826a(i5, i4))) {
                    m1873b(i5 - 2, i4 - 2, c1091b);
                }
            }
        }
    }

    /* renamed from: a */
    static void m1868a(C1083j c1083j, C1091b c1091b) throws C1112w {
        m1879c(c1091b);
        m1875b(c1091b);
        m1874b(c1083j, c1091b);
        m1881d(c1091b);
    }

    /* renamed from: c */
    private static void m1877c(int i2, int i3, C1091b c1091b) {
        for (int i4 = 0; i4 < 7; i4++) {
            for (int i5 = 0; i5 < 7; i5++) {
                c1091b.m1829a(i2 + i5, i3 + i4, f2183a[i4][i5]);
            }
        }
    }

    /* renamed from: d */
    private static void m1880d(int i2, int i3, C1091b c1091b) throws C1112w {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (m1876b(c1091b.m1826a(i2, i5))) {
                c1091b.m1829a(i2, i5, 0);
            } else {
                throw new C1112w();
            }
        }
    }

    /* renamed from: c */
    private static void m1879c(C1091b c1091b) throws C1112w {
        int length = f2183a[0].length;
        m1877c(0, 0, c1091b);
        m1877c(c1091b.m1833c() - length, 0, c1091b);
        m1877c(0, c1091b.m1833c() - length, c1091b);
        m1865a(0, 7, c1091b);
        m1865a(c1091b.m1833c() - 8, 7, c1091b);
        m1865a(0, c1091b.m1833c() - 8, c1091b);
        m1880d(7, 0, c1091b);
        m1880d((c1091b.m1832b() - 7) - 1, 0, c1091b);
        m1880d(7, c1091b.m1832b() - 7, c1091b);
    }

    /* renamed from: a */
    static void m1866a(EnumC1079f enumC1079f, int i2, C1091b c1091b) throws C1112w {
        C1162a c1162a = new C1162a();
        m1867a(enumC1079f, i2, c1162a);
        for (int i3 = 0; i3 < c1162a.m2157c(); i3++) {
            boolean m2155b = c1162a.m2155b((c1162a.m2157c() - 1) - i3);
            int[][] iArr = f2186d;
            c1091b.m1830a(iArr[i3][0], iArr[i3][1], m2155b);
            if (i3 < 8) {
                c1091b.m1830a((c1091b.m1833c() - i3) - 1, 8, m2155b);
            } else {
                c1091b.m1830a(8, (c1091b.m1832b() - 7) + (i3 - 8), m2155b);
            }
        }
    }

    /* renamed from: a */
    static void m1871a(C1162a c1162a, int i2, C1091b c1091b) throws C1112w {
        boolean z;
        int m1833c = c1091b.m1833c() - 1;
        int m1832b = c1091b.m1832b() - 1;
        int i3 = 0;
        int i4 = -1;
        while (m1833c > 0) {
            if (m1833c == 6) {
                m1833c--;
            }
            while (m1832b >= 0 && m1832b < c1091b.m1832b()) {
                int i5 = i3;
                for (int i6 = 0; i6 < 2; i6++) {
                    int i7 = m1833c - i6;
                    if (m1876b(c1091b.m1826a(i7, m1832b))) {
                        if (i5 < c1162a.m2157c()) {
                            z = c1162a.m2155b(i5);
                            i5++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1 && C1093d.m1857a(i2, i7, m1832b)) {
                            z = !z;
                        }
                        c1091b.m1830a(i7, m1832b, z);
                    }
                }
                m1832b += i4;
                i3 = i5;
            }
            i4 = -i4;
            m1832b += i4;
            m1833c -= 2;
        }
        if (i3 == c1162a.m2157c()) {
            return;
        }
        throw new C1112w("Not all bits consumed: " + i3 + '/' + c1162a.m2157c());
    }

    /* renamed from: a */
    static int m1864a(int i2, int i3) {
        if (i3 != 0) {
            int m1863a = m1863a(i3);
            int i4 = i2 << (m1863a - 1);
            while (m1863a(i4) >= m1863a) {
                i4 ^= i3 << (m1863a(i4) - m1863a);
            }
            return i4;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    /* renamed from: a */
    static void m1867a(EnumC1079f enumC1079f, int i2, C1162a c1162a) throws C1112w {
        if (C1095f.m1882b(i2)) {
            int bits = (enumC1079f.getBits() << 3) | i2;
            c1162a.m2148a(bits, 5);
            c1162a.m2148a(m1864a(bits, f2188f), 10);
            C1162a c1162a2 = new C1162a();
            c1162a2.m2148a(f2189g, 15);
            c1162a.m2154b(c1162a2);
            if (c1162a.m2157c() == 15) {
                return;
            }
            throw new C1112w("should not happen but we got: " + c1162a.m2157c());
        }
        throw new C1112w("Invalid mask pattern");
    }

    /* renamed from: a */
    static void m1869a(C1083j c1083j, C1162a c1162a) throws C1112w {
        c1162a.m2148a(c1083j.m1777e(), 6);
        c1162a.m2148a(m1864a(c1083j.m1777e(), f2187e), 12);
        if (c1162a.m2157c() == 18) {
            return;
        }
        throw new C1112w("should not happen but we got: " + c1162a.m2157c());
    }

    /* renamed from: a */
    private static void m1865a(int i2, int i3, C1091b c1091b) throws C1112w {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (m1876b(c1091b.m1826a(i5, i3))) {
                c1091b.m1829a(i5, i3, 0);
            } else {
                throw new C1112w();
            }
        }
    }
}
