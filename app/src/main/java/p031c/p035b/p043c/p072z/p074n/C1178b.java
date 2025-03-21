package p031c.p035b.p043c.p072z.p074n;

/* compiled from: GenericGFPoly.java */
/* renamed from: c.b.c.z.n.b */
/* loaded from: classes.dex */
final class C1178b {

    /* renamed from: a */
    private final C1177a f2464a;

    /* renamed from: b */
    private final int[] f2465b;

    C1178b(C1177a c1177a, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2464a = c1177a;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f2465b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f2465b = new int[]{0};
            return;
        }
        this.f2465b = new int[length - i2];
        int[] iArr2 = this.f2465b;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    /* renamed from: a */
    int[] m2244a() {
        return this.f2465b;
    }

    /* renamed from: b */
    int m2245b() {
        return this.f2465b.length - 1;
    }

    /* renamed from: c */
    boolean m2250c() {
        return this.f2465b[0] == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(m2245b() * 8);
        for (int m2245b = m2245b(); m2245b >= 0; m2245b--) {
            int m2246b = m2246b(m2245b);
            if (m2246b != 0) {
                if (m2246b < 0) {
                    sb.append(" - ");
                    m2246b = -m2246b;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (m2245b == 0 || m2246b != 1) {
                    int m2239c = this.f2464a.m2239c(m2246b);
                    if (m2239c == 0) {
                        sb.append('1');
                    } else if (m2239c == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(m2239c);
                    }
                }
                if (m2245b != 0) {
                    if (m2245b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(m2245b);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    int m2241a(int i2) {
        if (i2 == 0) {
            return m2246b(0);
        }
        int[] iArr = this.f2465b;
        int length = iArr.length;
        if (i2 != 1) {
            int i3 = iArr[0];
            for (int i4 = 1; i4 < length; i4++) {
                i3 = C1177a.m2231c(this.f2464a.m2236b(i2, i3), this.f2465b[i4]);
            }
            return i3;
        }
        int i5 = 0;
        for (int i6 : iArr) {
            i5 = C1177a.m2231c(i5, i6);
        }
        return i5;
    }

    /* renamed from: b */
    int m2246b(int i2) {
        return this.f2465b[(r0.length - 1) - i2];
    }

    /* renamed from: c */
    C1178b m2249c(C1178b c1178b) {
        if (!this.f2464a.equals(c1178b.f2464a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (m2250c() || c1178b.m2250c()) {
            return this.f2464a.m2240d();
        }
        int[] iArr = this.f2465b;
        int length = iArr.length;
        int[] iArr2 = c1178b.f2465b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                iArr3[i5] = C1177a.m2231c(iArr3[i5], this.f2464a.m2236b(i3, iArr2[i4]));
            }
        }
        return new C1178b(this.f2464a, iArr3);
    }

    /* renamed from: b */
    C1178b[] m2247b(C1178b c1178b) {
        if (this.f2464a.equals(c1178b.f2464a)) {
            if (!c1178b.m2250c()) {
                C1178b m2240d = this.f2464a.m2240d();
                int m2235b = this.f2464a.m2235b(c1178b.m2246b(c1178b.m2245b()));
                C1178b c1178b2 = m2240d;
                C1178b c1178b3 = this;
                while (c1178b3.m2245b() >= c1178b.m2245b() && !c1178b3.m2250c()) {
                    int m2245b = c1178b3.m2245b() - c1178b.m2245b();
                    int m2236b = this.f2464a.m2236b(c1178b3.m2246b(c1178b3.m2245b()), m2235b);
                    C1178b m2242a = c1178b.m2242a(m2245b, m2236b);
                    c1178b2 = c1178b2.m2243a(this.f2464a.m2234a(m2245b, m2236b));
                    c1178b3 = c1178b3.m2243a(m2242a);
                }
                return new C1178b[]{c1178b2, c1178b3};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* renamed from: a */
    C1178b m2243a(C1178b c1178b) {
        if (this.f2464a.equals(c1178b.f2464a)) {
            if (m2250c()) {
                return c1178b;
            }
            if (c1178b.m2250c()) {
                return this;
            }
            int[] iArr = this.f2465b;
            int[] iArr2 = c1178b.f2465b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr3[i2] = C1177a.m2231c(iArr[i2 - length], iArr2[i2]);
            }
            return new C1178b(this.f2464a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* renamed from: c */
    C1178b m2248c(int i2) {
        if (i2 == 0) {
            return this.f2464a.m2240d();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f2465b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f2464a.m2236b(this.f2465b[i3], i2);
        }
        return new C1178b(this.f2464a, iArr);
    }

    /* renamed from: a */
    C1178b m2242a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f2464a.m2240d();
        }
        int length = this.f2465b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f2464a.m2236b(this.f2465b[i4], i3);
        }
        return new C1178b(this.f2464a, iArr);
    }
}
