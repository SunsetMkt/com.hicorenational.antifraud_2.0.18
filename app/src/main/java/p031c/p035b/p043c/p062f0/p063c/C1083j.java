package p031c.p035b.p043c.p062f0.p063c;

import com.luck.picture.lib.config.PictureConfig;
import com.tencent.bugly.beta.tinker.TinkerReport;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: Version.java */
/* renamed from: c.b.c.f0.c.j */
/* loaded from: classes.dex */
public final class C1083j {

    /* renamed from: e */
    private static final int[] f2136e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: f */
    private static final C1083j[] f2137f = m1771f();

    /* renamed from: a */
    private final int f2138a;

    /* renamed from: b */
    private final int[] f2139b;

    /* renamed from: c */
    private final b[] f2140c;

    /* renamed from: d */
    private final int f2141d;

    /* compiled from: Version.java */
    /* renamed from: c.b.c.f0.c.j$a */
    public static final class a {

        /* renamed from: a */
        private final int f2142a;

        /* renamed from: b */
        private final int f2143b;

        a(int i2, int i3) {
            this.f2142a = i2;
            this.f2143b = i3;
        }

        /* renamed from: a */
        public int m1778a() {
            return this.f2142a;
        }

        /* renamed from: b */
        public int m1779b() {
            return this.f2143b;
        }
    }

    /* compiled from: Version.java */
    /* renamed from: c.b.c.f0.c.j$b */
    public static final class b {

        /* renamed from: a */
        private final int f2144a;

        /* renamed from: b */
        private final a[] f2145b;

        b(int i2, a... aVarArr) {
            this.f2144a = i2;
            this.f2145b = aVarArr;
        }

        /* renamed from: a */
        public a[] m1780a() {
            return this.f2145b;
        }

        /* renamed from: b */
        public int m1781b() {
            return this.f2144a;
        }

        /* renamed from: c */
        public int m1782c() {
            int i2 = 0;
            for (a aVar : this.f2145b) {
                i2 += aVar.m1778a();
            }
            return i2;
        }

        /* renamed from: d */
        public int m1783d() {
            return this.f2144a * m1782c();
        }
    }

    private C1083j(int i2, int[] iArr, b... bVarArr) {
        this.f2138a = i2;
        this.f2139b = iArr;
        this.f2140c = bVarArr;
        int m1781b = bVarArr[0].m1781b();
        int i3 = 0;
        for (a aVar : bVarArr[0].m1780a()) {
            i3 += aVar.m1778a() * (aVar.m1779b() + m1781b);
        }
        this.f2141d = i3;
    }

    /* renamed from: f */
    private static C1083j[] m1771f() {
        return new C1083j[]{new C1083j(1, new int[0], new b(7, new a(1, 19)), new b(10, new a(1, 16)), new b(13, new a(1, 13)), new b(17, new a(1, 9))), new C1083j(2, new int[]{6, 18}, new b(10, new a(1, 34)), new b(16, new a(1, 28)), new b(22, new a(1, 22)), new b(28, new a(1, 16))), new C1083j(3, new int[]{6, 22}, new b(15, new a(1, 55)), new b(26, new a(1, 44)), new b(18, new a(2, 17)), new b(22, new a(2, 13))), new C1083j(4, new int[]{6, 26}, new b(20, new a(1, 80)), new b(18, new a(2, 32)), new b(26, new a(2, 24)), new b(16, new a(4, 9))), new C1083j(5, new int[]{6, 30}, new b(26, new a(1, 108)), new b(24, new a(2, 43)), new b(18, new a(2, 15), new a(2, 16)), new b(22, new a(2, 11), new a(2, 12))), new C1083j(6, new int[]{6, 34}, new b(18, new a(2, 68)), new b(16, new a(4, 27)), new b(24, new a(4, 19)), new b(28, new a(4, 15))), new C1083j(7, new int[]{6, 22, 38}, new b(20, new a(2, 78)), new b(18, new a(4, 31)), new b(18, new a(2, 14), new a(4, 15)), new b(26, new a(4, 13), new a(1, 14))), new C1083j(8, new int[]{6, 24, 42}, new b(24, new a(2, 97)), new b(22, new a(2, 38), new a(2, 39)), new b(22, new a(4, 18), new a(2, 19)), new b(26, new a(4, 14), new a(2, 15))), new C1083j(9, new int[]{6, 26, 46}, new b(30, new a(2, 116)), new b(22, new a(3, 36), new a(2, 37)), new b(20, new a(4, 16), new a(4, 17)), new b(24, new a(4, 12), new a(4, 13))), new C1083j(10, new int[]{6, 28, 50}, new b(18, new a(2, 68), new a(2, 69)), new b(26, new a(4, 43), new a(1, 44)), new b(24, new a(6, 19), new a(2, 20)), new b(28, new a(6, 15), new a(2, 16))), new C1083j(11, new int[]{6, 30, 54}, new b(20, new a(4, 81)), new b(30, new a(1, 50), new a(4, 51)), new b(28, new a(4, 22), new a(4, 23)), new b(24, new a(3, 12), new a(8, 13))), new C1083j(12, new int[]{6, 32, 58}, new b(24, new a(2, 92), new a(2, 93)), new b(22, new a(6, 36), new a(2, 37)), new b(26, new a(4, 20), new a(6, 21)), new b(28, new a(7, 14), new a(4, 15))), new C1083j(13, new int[]{6, 34, 62}, new b(26, new a(4, 107)), new b(22, new a(8, 37), new a(1, 38)), new b(24, new a(8, 20), new a(4, 21)), new b(22, new a(12, 11), new a(4, 12))), new C1083j(14, new int[]{6, 26, 46, 66}, new b(30, new a(3, 115), new a(1, 116)), new b(24, new a(4, 40), new a(5, 41)), new b(20, new a(11, 16), new a(5, 17)), new b(24, new a(11, 12), new a(5, 13))), new C1083j(15, new int[]{6, 26, 48, 70}, new b(22, new a(5, 87), new a(1, 88)), new b(24, new a(5, 41), new a(5, 42)), new b(30, new a(5, 24), new a(7, 25)), new b(24, new a(11, 12), new a(7, 13))), new C1083j(16, new int[]{6, 26, 50, 74}, new b(24, new a(5, 98), new a(1, 99)), new b(28, new a(7, 45), new a(3, 46)), new b(24, new a(15, 19), new a(2, 20)), new b(30, new a(3, 15), new a(13, 16))), new C1083j(17, new int[]{6, 30, 54, 78}, new b(28, new a(1, 107), new a(5, 108)), new b(28, new a(10, 46), new a(1, 47)), new b(28, new a(1, 22), new a(15, 23)), new b(28, new a(2, 14), new a(17, 15))), new C1083j(18, new int[]{6, 30, 56, 82}, new b(30, new a(5, 120), new a(1, 121)), new b(26, new a(9, 43), new a(4, 44)), new b(28, new a(17, 22), new a(1, 23)), new b(28, new a(2, 14), new a(19, 15))), new C1083j(19, new int[]{6, 30, 58, 86}, new b(28, new a(3, 113), new a(4, 114)), new b(26, new a(3, 44), new a(11, 45)), new b(26, new a(17, 21), new a(4, 22)), new b(26, new a(9, 13), new a(16, 14))), new C1083j(20, new int[]{6, 34, 62, 90}, new b(28, new a(3, 107), new a(5, 108)), new b(26, new a(3, 41), new a(13, 42)), new b(30, new a(15, 24), new a(5, 25)), new b(28, new a(15, 15), new a(10, 16))), new C1083j(21, new int[]{6, 28, 50, 72, 94}, new b(28, new a(4, 116), new a(4, 117)), new b(26, new a(17, 42)), new b(28, new a(17, 22), new a(6, 23)), new b(30, new a(19, 16), new a(6, 17))), new C1083j(22, new int[]{6, 26, 50, 74, 98}, new b(28, new a(2, 111), new a(7, 112)), new b(28, new a(17, 46)), new b(30, new a(7, 24), new a(16, 25)), new b(24, new a(34, 13))), new C1083j(23, new int[]{6, 30, 54, 78, 102}, new b(30, new a(4, 121), new a(5, 122)), new b(28, new a(4, 47), new a(14, 48)), new b(30, new a(11, 24), new a(14, 25)), new b(30, new a(16, 15), new a(14, 16))), new C1083j(24, new int[]{6, 28, 54, 80, 106}, new b(30, new a(6, 117), new a(4, 118)), new b(28, new a(6, 45), new a(14, 46)), new b(30, new a(11, 24), new a(16, 25)), new b(30, new a(30, 16), new a(2, 17))), new C1083j(25, new int[]{6, 32, 58, 84, 110}, new b(26, new a(8, 106), new a(4, 107)), new b(28, new a(8, 47), new a(13, 48)), new b(30, new a(7, 24), new a(22, 25)), new b(30, new a(22, 15), new a(13, 16))), new C1083j(26, new int[]{6, 30, 58, 86, 114}, new b(28, new a(10, 114), new a(2, 115)), new b(28, new a(19, 46), new a(4, 47)), new b(28, new a(28, 22), new a(6, 23)), new b(30, new a(33, 16), new a(4, 17))), new C1083j(27, new int[]{6, 34, 62, 90, 118}, new b(30, new a(8, 122), new a(4, 123)), new b(28, new a(22, 45), new a(3, 46)), new b(30, new a(8, 23), new a(26, 24)), new b(30, new a(12, 15), new a(28, 16))), new C1083j(28, new int[]{6, 26, 50, 74, 98, 122}, new b(30, new a(3, 117), new a(10, 118)), new b(28, new a(3, 45), new a(23, 46)), new b(30, new a(4, 24), new a(31, 25)), new b(30, new a(11, 15), new a(31, 16))), new C1083j(29, new int[]{6, 30, 54, 78, 102, 126}, new b(30, new a(7, 116), new a(7, 117)), new b(28, new a(21, 45), new a(7, 46)), new b(30, new a(1, 23), new a(37, 24)), new b(30, new a(19, 15), new a(26, 16))), new C1083j(30, new int[]{6, 26, 52, 78, 104, 130}, new b(30, new a(5, 115), new a(10, 116)), new b(28, new a(19, 47), new a(10, 48)), new b(30, new a(15, 24), new a(25, 25)), new b(30, new a(23, 15), new a(25, 16))), new C1083j(31, new int[]{6, 30, 56, 82, 108, 134}, new b(30, new a(13, 115), new a(3, 116)), new b(28, new a(2, 46), new a(29, 47)), new b(30, new a(42, 24), new a(1, 25)), new b(30, new a(23, 15), new a(28, 16))), new C1083j(32, new int[]{6, 34, 60, 86, 112, 138}, new b(30, new a(17, 115)), new b(28, new a(10, 46), new a(23, 47)), new b(30, new a(10, 24), new a(35, 25)), new b(30, new a(19, 15), new a(35, 16))), new C1083j(33, new int[]{6, 30, 58, 86, 114, 142}, new b(30, new a(17, 115), new a(1, 116)), new b(28, new a(14, 46), new a(21, 47)), new b(30, new a(29, 24), new a(19, 25)), new b(30, new a(11, 15), new a(46, 16))), new C1083j(34, new int[]{6, 34, 62, 90, 118, 146}, new b(30, new a(13, 115), new a(6, 116)), new b(28, new a(14, 46), new a(23, 47)), new b(30, new a(44, 24), new a(7, 25)), new b(30, new a(59, 16), new a(1, 17))), new C1083j(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new b(30, new a(12, 121), new a(7, 122)), new b(28, new a(12, 47), new a(26, 48)), new b(30, new a(39, 24), new a(14, 25)), new b(30, new a(22, 15), new a(41, 16))), new C1083j(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new b(30, new a(6, 121), new a(14, 122)), new b(28, new a(6, 47), new a(34, 48)), new b(30, new a(46, 24), new a(10, 25)), new b(30, new a(2, 15), new a(64, 16))), new C1083j(37, new int[]{6, 28, 54, 80, 106, 132, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT}, new b(30, new a(17, 122), new a(4, 123)), new b(28, new a(29, 46), new a(14, 47)), new b(30, new a(49, 24), new a(10, 25)), new b(30, new a(24, 15), new a(46, 16))), new C1083j(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new b(30, new a(4, 122), new a(18, 123)), new b(28, new a(13, 46), new a(32, 47)), new b(30, new a(48, 24), new a(14, 25)), new b(30, new a(42, 15), new a(32, 16))), new C1083j(39, new int[]{6, 26, 54, 82, 110, 138, PictureConfig.PREVIEW_VIDEO_CODE}, new b(30, new a(20, 117), new a(4, 118)), new b(28, new a(40, 47), new a(7, 48)), new b(30, new a(43, 24), new a(22, 25)), new b(30, new a(10, 15), new a(67, 16))), new C1083j(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new b(30, new a(19, 118), new a(6, 119)), new b(28, new a(18, 47), new a(31, 48)), new b(30, new a(34, 24), new a(34, 25)), new b(30, new a(20, 15), new a(61, 16)))};
    }

    /* renamed from: a */
    public b m1772a(EnumC1079f enumC1079f) {
        return this.f2140c[enumC1079f.ordinal()];
    }

    /* renamed from: b */
    public int[] m1774b() {
        return this.f2139b;
    }

    /* renamed from: c */
    public int m1775c() {
        return (this.f2138a * 4) + 17;
    }

    /* renamed from: d */
    public int m1776d() {
        return this.f2141d;
    }

    /* renamed from: e */
    public int m1777e() {
        return this.f2138a;
    }

    public String toString() {
        return String.valueOf(this.f2138a);
    }

    /* renamed from: a */
    static C1083j m1768a(int i2) {
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        while (true) {
            int[] iArr = f2136e;
            if (i3 >= iArr.length) {
                if (i4 <= 3) {
                    return m1770c(i5);
                }
                return null;
            }
            int i6 = iArr[i3];
            if (i6 == i2) {
                return m1770c(i3 + 7);
            }
            int m1763c = C1080g.m1763c(i2, i6);
            if (m1763c < i4) {
                i5 = i3 + 7;
                i4 = m1763c;
            }
            i3++;
        }
    }

    /* renamed from: b */
    public static C1083j m1769b(int i2) throws C1097h {
        if (i2 % 4 != 1) {
            throw C1097h.getFormatInstance();
        }
        try {
            return m1770c((i2 - 17) / 4);
        } catch (IllegalArgumentException unused) {
            throw C1097h.getFormatInstance();
        }
    }

    /* renamed from: c */
    public static C1083j m1770c(int i2) {
        if (i2 < 1 || i2 > 40) {
            throw new IllegalArgumentException();
        }
        return f2137f[i2 - 1];
    }

    /* renamed from: a */
    C1163b m1773a() {
        int m1775c = m1775c();
        C1163b c1163b = new C1163b(m1775c);
        c1163b.m2170a(0, 0, 9, 9);
        int i2 = m1775c - 8;
        c1163b.m2170a(i2, 0, 8, 9);
        c1163b.m2170a(0, i2, 9, 8);
        int length = this.f2139b.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = this.f2139b[i3] - 2;
            for (int i5 = 0; i5 < length; i5++) {
                if ((i3 != 0 || (i5 != 0 && i5 != length - 1)) && (i3 != length - 1 || i5 != 0)) {
                    c1163b.m2170a(this.f2139b[i5] - 2, i4, 5, 5);
                }
            }
        }
        int i6 = m1775c - 17;
        c1163b.m2170a(6, 9, 1, i6);
        c1163b.m2170a(9, 6, i6, 1);
        if (this.f2138a > 6) {
            int i7 = m1775c - 11;
            c1163b.m2170a(i7, 0, 3, 6);
            c1163b.m2170a(0, i7, 6, 3);
        }
        return c1163b;
    }
}
