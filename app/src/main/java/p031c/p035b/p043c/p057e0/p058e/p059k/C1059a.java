package p031c.p035b.p043c.p057e0.p058e.p059k;

import p031c.p035b.p043c.C0988d;

/* compiled from: ErrorCorrection.java */
/* renamed from: c.b.c.e0.e.k.a */
/* loaded from: classes.dex */
public final class C1059a {

    /* renamed from: a */
    private final C1060b f2040a = C1060b.f2041f;

    /* renamed from: a */
    public int m1655a(int[] iArr, int i2, int[] iArr2) throws C0988d {
        C1061c c1061c = new C1061c(this.f2040a, iArr);
        int[] iArr3 = new int[i2];
        boolean z = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int m1666a = c1061c.m1666a(this.f2040a.m1656a(i3));
            iArr3[i2 - i3] = m1666a;
            if (m1666a != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        C1061c m1658a = this.f2040a.m1658a();
        if (iArr2 != null) {
            C1061c c1061c2 = m1658a;
            for (int i4 : iArr2) {
                int m1656a = this.f2040a.m1656a((iArr.length - 1) - i4);
                C1060b c1060b = this.f2040a;
                c1061c2 = c1061c2.m1674c(new C1061c(c1060b, new int[]{c1060b.m1665d(0, m1656a), 1}));
            }
        }
        C1061c[] m1654a = m1654a(this.f2040a.m1661b(i2, 1), new C1061c(this.f2040a, iArr3), i2);
        C1061c c1061c3 = m1654a[0];
        C1061c c1061c4 = m1654a[1];
        int[] m1652a = m1652a(c1061c3);
        int[] m1653a = m1653a(c1061c4, c1061c3, m1652a);
        for (int i5 = 0; i5 < m1652a.length; i5++) {
            int length = (iArr.length - 1) - this.f2040a.m1662c(m1652a[i5]);
            if (length < 0) {
                throw C0988d.getChecksumInstance();
            }
            iArr[length] = this.f2040a.m1665d(iArr[length], m1653a[i5]);
        }
        return m1652a.length;
    }

    /* renamed from: a */
    private C1061c[] m1654a(C1061c c1061c, C1061c c1061c2, int i2) throws C0988d {
        if (c1061c.m1670b() < c1061c2.m1670b()) {
            c1061c2 = c1061c;
            c1061c = c1061c2;
        }
        C1061c m1664c = this.f2040a.m1664c();
        C1061c m1658a = this.f2040a.m1658a();
        while (true) {
            C1061c c1061c3 = c1061c2;
            c1061c2 = c1061c;
            c1061c = c1061c3;
            C1061c c1061c4 = m1658a;
            C1061c c1061c5 = m1664c;
            m1664c = c1061c4;
            if (c1061c.m1670b() >= i2 / 2) {
                if (!c1061c.m1675c()) {
                    C1061c m1664c2 = this.f2040a.m1664c();
                    int m1660b = this.f2040a.m1660b(c1061c.m1671b(c1061c.m1670b()));
                    while (c1061c2.m1670b() >= c1061c.m1670b() && !c1061c2.m1675c()) {
                        int m1670b = c1061c2.m1670b() - c1061c.m1670b();
                        int m1663c = this.f2040a.m1663c(c1061c2.m1671b(c1061c2.m1670b()), m1660b);
                        m1664c2 = m1664c2.m1668a(this.f2040a.m1661b(m1670b, m1663c));
                        c1061c2 = c1061c2.m1677d(c1061c.m1667a(m1670b, m1663c));
                    }
                    m1658a = m1664c2.m1674c(m1664c).m1677d(c1061c5).m1676d();
                } else {
                    throw C0988d.getChecksumInstance();
                }
            } else {
                int m1671b = m1664c.m1671b(0);
                if (m1671b != 0) {
                    int m1660b2 = this.f2040a.m1660b(m1671b);
                    return new C1061c[]{m1664c.m1673c(m1660b2), c1061c.m1673c(m1660b2)};
                }
                throw C0988d.getChecksumInstance();
            }
        }
    }

    /* renamed from: a */
    private int[] m1652a(C1061c c1061c) throws C0988d {
        int m1670b = c1061c.m1670b();
        int[] iArr = new int[m1670b];
        int i2 = 0;
        for (int i3 = 1; i3 < this.f2040a.m1659b() && i2 < m1670b; i3++) {
            if (c1061c.m1666a(i3) == 0) {
                iArr[i2] = this.f2040a.m1660b(i3);
                i2++;
            }
        }
        if (i2 == m1670b) {
            return iArr;
        }
        throw C0988d.getChecksumInstance();
    }

    /* renamed from: a */
    private int[] m1653a(C1061c c1061c, C1061c c1061c2, int[] iArr) {
        int m1670b = c1061c2.m1670b();
        int[] iArr2 = new int[m1670b];
        for (int i2 = 1; i2 <= m1670b; i2++) {
            iArr2[m1670b - i2] = this.f2040a.m1663c(i2, c1061c2.m1671b(i2));
        }
        C1061c c1061c3 = new C1061c(this.f2040a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int m1660b = this.f2040a.m1660b(iArr[i3]);
            iArr3[i3] = this.f2040a.m1663c(this.f2040a.m1665d(0, c1061c.m1666a(m1660b)), this.f2040a.m1660b(c1061c3.m1666a(m1660b)));
        }
        return iArr3;
    }
}
