package p031c.p035b.p043c.p072z.p074n;

/* compiled from: ReedSolomonDecoder.java */
/* renamed from: c.b.c.z.n.c */
/* loaded from: classes.dex */
public final class C1179c {

    /* renamed from: a */
    private final C1177a f2466a;

    public C1179c(C1177a c1177a) {
        this.f2466a = c1177a;
    }

    /* renamed from: a */
    public void m2254a(int[] iArr, int i2) throws C1181e {
        C1178b c1178b = new C1178b(this.f2466a, iArr);
        int[] iArr2 = new int[i2];
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            C1177a c1177a = this.f2466a;
            int m2241a = c1178b.m2241a(c1177a.m2233a(c1177a.m2232a() + i3));
            iArr2[(iArr2.length - 1) - i3] = m2241a;
            if (m2241a != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        C1178b[] m2253a = m2253a(this.f2466a.m2234a(i2, 1), new C1178b(this.f2466a, iArr2), i2);
        C1178b c1178b2 = m2253a[0];
        C1178b c1178b3 = m2253a[1];
        int[] m2251a = m2251a(c1178b2);
        int[] m2252a = m2252a(c1178b3, m2251a);
        for (int i4 = 0; i4 < m2251a.length; i4++) {
            int length = (iArr.length - 1) - this.f2466a.m2239c(m2251a[i4]);
            if (length < 0) {
                throw new C1181e("Bad error location");
            }
            iArr[length] = C1177a.m2231c(iArr[length], m2252a[i4]);
        }
    }

    /* renamed from: a */
    private C1178b[] m2253a(C1178b c1178b, C1178b c1178b2, int i2) throws C1181e {
        if (c1178b.m2245b() < c1178b2.m2245b()) {
            c1178b2 = c1178b;
            c1178b = c1178b2;
        }
        C1178b m2240d = this.f2466a.m2240d();
        C1178b m2237b = this.f2466a.m2237b();
        do {
            C1178b c1178b3 = c1178b2;
            c1178b2 = c1178b;
            c1178b = c1178b3;
            C1178b c1178b4 = m2237b;
            C1178b c1178b5 = m2240d;
            m2240d = c1178b4;
            if (c1178b.m2245b() >= i2 / 2) {
                if (!c1178b.m2250c()) {
                    C1178b m2240d2 = this.f2466a.m2240d();
                    int m2235b = this.f2466a.m2235b(c1178b.m2246b(c1178b.m2245b()));
                    while (c1178b2.m2245b() >= c1178b.m2245b() && !c1178b2.m2250c()) {
                        int m2245b = c1178b2.m2245b() - c1178b.m2245b();
                        int m2236b = this.f2466a.m2236b(c1178b2.m2246b(c1178b2.m2245b()), m2235b);
                        m2240d2 = m2240d2.m2243a(this.f2466a.m2234a(m2245b, m2236b));
                        c1178b2 = c1178b2.m2243a(c1178b.m2242a(m2245b, m2236b));
                    }
                    m2237b = m2240d2.m2249c(m2240d).m2243a(c1178b5);
                } else {
                    throw new C1181e("r_{i-1} was zero");
                }
            } else {
                int m2246b = m2240d.m2246b(0);
                if (m2246b != 0) {
                    int m2235b2 = this.f2466a.m2235b(m2246b);
                    return new C1178b[]{m2240d.m2248c(m2235b2), c1178b.m2248c(m2235b2)};
                }
                throw new C1181e("sigmaTilde(0) was zero");
            }
        } while (c1178b2.m2245b() < c1178b.m2245b());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    /* renamed from: a */
    private int[] m2251a(C1178b c1178b) throws C1181e {
        int m2245b = c1178b.m2245b();
        int i2 = 0;
        if (m2245b == 1) {
            return new int[]{c1178b.m2246b(1)};
        }
        int[] iArr = new int[m2245b];
        for (int i3 = 1; i3 < this.f2466a.m2238c() && i2 < m2245b; i3++) {
            if (c1178b.m2241a(i3) == 0) {
                iArr[i2] = this.f2466a.m2235b(i3);
                i2++;
            }
        }
        if (i2 == m2245b) {
            return iArr;
        }
        throw new C1181e("Error locator degree does not match number of roots");
    }

    /* renamed from: a */
    private int[] m2252a(C1178b c1178b, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int m2235b = this.f2466a.m2235b(iArr[i2]);
            int i3 = 1;
            for (int i4 = 0; i4 < length; i4++) {
                if (i2 != i4) {
                    int m2236b = this.f2466a.m2236b(iArr[i4], m2235b);
                    i3 = this.f2466a.m2236b(i3, (m2236b & 1) == 0 ? m2236b | 1 : m2236b & (-2));
                }
            }
            iArr2[i2] = this.f2466a.m2236b(c1178b.m2241a(m2235b), this.f2466a.m2235b(i3));
            if (this.f2466a.m2232a() != 0) {
                iArr2[i2] = this.f2466a.m2236b(iArr2[i2], m2235b);
            }
        }
        return iArr2;
    }
}
