package p031c.p035b.p043c.p057e0.p058e.p059k;

/* compiled from: ModulusPoly.java */
/* renamed from: c.b.c.e0.e.k.c */
/* loaded from: classes.dex */
final class C1061c {

    /* renamed from: a */
    private final C1060b f2047a;

    /* renamed from: b */
    private final int[] f2048b;

    C1061c(C1060b c1060b, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2047a = c1060b;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f2048b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f2048b = new int[]{0};
            return;
        }
        this.f2048b = new int[length - i2];
        int[] iArr2 = this.f2048b;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    /* renamed from: a */
    int[] m1669a() {
        return this.f2048b;
    }

    /* renamed from: b */
    int m1670b() {
        return this.f2048b.length - 1;
    }

    /* renamed from: c */
    boolean m1675c() {
        return this.f2048b[0] == 0;
    }

    /* renamed from: d */
    C1061c m1677d(C1061c c1061c) {
        if (this.f2047a.equals(c1061c.f2047a)) {
            return c1061c.m1675c() ? this : m1668a(c1061c.m1676d());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(m1670b() * 8);
        for (int m1670b = m1670b(); m1670b >= 0; m1670b--) {
            int m1671b = m1671b(m1670b);
            if (m1671b != 0) {
                if (m1671b < 0) {
                    sb.append(" - ");
                    m1671b = -m1671b;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (m1670b == 0 || m1671b != 1) {
                    sb.append(m1671b);
                }
                if (m1670b != 0) {
                    if (m1670b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(m1670b);
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    int m1666a(int i2) {
        if (i2 == 0) {
            return m1671b(0);
        }
        int[] iArr = this.f2048b;
        int length = iArr.length;
        if (i2 != 1) {
            int i3 = iArr[0];
            for (int i4 = 1; i4 < length; i4++) {
                C1060b c1060b = this.f2047a;
                i3 = c1060b.m1657a(c1060b.m1663c(i2, i3), this.f2048b[i4]);
            }
            return i3;
        }
        int i5 = 0;
        for (int i6 : iArr) {
            i5 = this.f2047a.m1657a(i5, i6);
        }
        return i5;
    }

    /* renamed from: b */
    int m1671b(int i2) {
        return this.f2048b[(r0.length - 1) - i2];
    }

    /* renamed from: c */
    C1061c m1674c(C1061c c1061c) {
        if (!this.f2047a.equals(c1061c.f2047a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (m1675c() || c1061c.m1675c()) {
            return this.f2047a.m1664c();
        }
        int[] iArr = this.f2048b;
        int length = iArr.length;
        int[] iArr2 = c1061c.f2048b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                C1060b c1060b = this.f2047a;
                iArr3[i5] = c1060b.m1657a(iArr3[i5], c1060b.m1663c(i3, iArr2[i4]));
            }
        }
        return new C1061c(this.f2047a, iArr3);
    }

    /* renamed from: b */
    C1061c[] m1672b(C1061c c1061c) {
        if (this.f2047a.equals(c1061c.f2047a)) {
            if (!c1061c.m1675c()) {
                C1061c m1664c = this.f2047a.m1664c();
                int m1660b = this.f2047a.m1660b(c1061c.m1671b(c1061c.m1670b()));
                C1061c c1061c2 = m1664c;
                C1061c c1061c3 = this;
                while (c1061c3.m1670b() >= c1061c.m1670b() && !c1061c3.m1675c()) {
                    int m1670b = c1061c3.m1670b() - c1061c.m1670b();
                    int m1663c = this.f2047a.m1663c(c1061c3.m1671b(c1061c3.m1670b()), m1660b);
                    C1061c m1667a = c1061c.m1667a(m1670b, m1663c);
                    c1061c2 = c1061c2.m1668a(this.f2047a.m1661b(m1670b, m1663c));
                    c1061c3 = c1061c3.m1677d(m1667a);
                }
                return new C1061c[]{c1061c2, c1061c3};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    /* renamed from: d */
    C1061c m1676d() {
        int length = this.f2048b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f2047a.m1665d(0, this.f2048b[i2]);
        }
        return new C1061c(this.f2047a, iArr);
    }

    /* renamed from: a */
    C1061c m1668a(C1061c c1061c) {
        if (this.f2047a.equals(c1061c.f2047a)) {
            if (m1675c()) {
                return c1061c;
            }
            if (c1061c.m1675c()) {
                return this;
            }
            int[] iArr = this.f2048b;
            int[] iArr2 = c1061c.f2048b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr3[i2] = this.f2047a.m1657a(iArr[i2 - length], iArr2[i2]);
            }
            return new C1061c(this.f2047a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    /* renamed from: c */
    C1061c m1673c(int i2) {
        if (i2 == 0) {
            return this.f2047a.m1664c();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f2048b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f2047a.m1663c(this.f2048b[i3], i2);
        }
        return new C1061c(this.f2047a, iArr);
    }

    /* renamed from: a */
    C1061c m1667a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f2047a.m1664c();
        }
        int length = this.f2048b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f2047a.m1663c(this.f2048b[i4], i3);
        }
        return new C1061c(this.f2047a, iArr);
    }
}
