package p031c.p035b.p043c.p057e0.p058e;

import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1109t;

/* compiled from: DetectionResultRowIndicatorColumn.java */
/* renamed from: c.b.c.e0.e.h */
/* loaded from: classes.dex */
final class C1056h extends C1055g {

    /* renamed from: d */
    private final boolean f2034d;

    C1056h(C1051c c1051c, boolean z) {
        super(c1051c);
        this.f2034d = z;
    }

    /* renamed from: a */
    int m1617a(C1049a c1049a) {
        C1052d[] m1614b = m1614b();
        m1622f();
        m1616a(m1614b, c1049a);
        C1051c m1610a = m1610a();
        C1109t m1574g = this.f2034d ? m1610a.m1574g() : m1610a.m1575h();
        C1109t m1568a = this.f2034d ? m1610a.m1568a() : m1610a.m1569b();
        int m1615c = m1615c((int) m1574g.m1923b());
        int m1615c2 = m1615c((int) m1568a.m1923b());
        float m1558c = (m1615c2 - m1615c) / c1049a.m1558c();
        int i2 = -1;
        int i3 = 0;
        int i4 = 1;
        while (m1615c < m1615c2) {
            if (m1614b[m1615c] != null) {
                C1052d c1052d = m1614b[m1615c];
                int m1580c = c1052d.m1580c() - i2;
                if (m1580c == 0) {
                    i3++;
                } else {
                    if (m1580c == 1) {
                        i4 = Math.max(i4, i3);
                        i2 = c1052d.m1580c();
                    } else if (m1580c < 0 || c1052d.m1580c() >= c1049a.m1558c() || m1580c > m1615c) {
                        m1614b[m1615c] = null;
                    } else {
                        if (i4 > 2) {
                            m1580c *= i4 - 2;
                        }
                        boolean z = m1580c >= m1615c;
                        for (int i5 = 1; i5 <= m1580c && !z; i5++) {
                            z = m1614b[m1615c - i5] != null;
                        }
                        if (z) {
                            m1614b[m1615c] = null;
                        } else {
                            i2 = c1052d.m1580c();
                        }
                    }
                    i3 = 1;
                }
            }
            m1615c++;
        }
        return (int) (m1558c + 0.5d);
    }

    /* renamed from: b */
    int m1618b(C1049a c1049a) {
        C1051c m1610a = m1610a();
        C1109t m1574g = this.f2034d ? m1610a.m1574g() : m1610a.m1575h();
        C1109t m1568a = this.f2034d ? m1610a.m1568a() : m1610a.m1569b();
        int m1615c = m1615c((int) m1574g.m1923b());
        int m1615c2 = m1615c((int) m1568a.m1923b());
        float m1558c = (m1615c2 - m1615c) / c1049a.m1558c();
        C1052d[] m1614b = m1614b();
        int i2 = -1;
        int i3 = 0;
        int i4 = 1;
        while (m1615c < m1615c2) {
            if (m1614b[m1615c] != null) {
                C1052d c1052d = m1614b[m1615c];
                c1052d.m1585h();
                int m1580c = c1052d.m1580c() - i2;
                if (m1580c == 0) {
                    i3++;
                } else {
                    if (m1580c == 1) {
                        i4 = Math.max(i4, i3);
                        i2 = c1052d.m1580c();
                    } else if (c1052d.m1580c() >= c1049a.m1558c()) {
                        m1614b[m1615c] = null;
                    } else {
                        i2 = c1052d.m1580c();
                    }
                    i3 = 1;
                }
            }
            m1615c++;
        }
        return (int) (m1558c + 0.5d);
    }

    /* renamed from: c */
    C1049a m1619c() {
        C1052d[] m1614b = m1614b();
        C1050b c1050b = new C1050b();
        C1050b c1050b2 = new C1050b();
        C1050b c1050b3 = new C1050b();
        C1050b c1050b4 = new C1050b();
        for (C1052d c1052d : m1614b) {
            if (c1052d != null) {
                c1052d.m1585h();
                int m1582e = c1052d.m1582e() % 30;
                int m1580c = c1052d.m1580c();
                if (!this.f2034d) {
                    m1580c += 2;
                }
                int i2 = m1580c % 3;
                if (i2 == 0) {
                    c1050b2.m1563b((m1582e * 3) + 1);
                } else if (i2 == 1) {
                    c1050b4.m1563b(m1582e / 3);
                    c1050b3.m1563b(m1582e % 3);
                } else if (i2 == 2) {
                    c1050b.m1563b(m1582e + 1);
                }
            }
        }
        if (c1050b.m1562a().length == 0 || c1050b2.m1562a().length == 0 || c1050b3.m1562a().length == 0 || c1050b4.m1562a().length == 0 || c1050b.m1562a()[0] < 1 || c1050b2.m1562a()[0] + c1050b3.m1562a()[0] < 3 || c1050b2.m1562a()[0] + c1050b3.m1562a()[0] > 90) {
            return null;
        }
        C1049a c1049a = new C1049a(c1050b.m1562a()[0], c1050b2.m1562a()[0], c1050b3.m1562a()[0], c1050b4.m1562a()[0]);
        m1616a(m1614b, c1049a);
        return c1049a;
    }

    /* renamed from: d */
    int[] m1620d() throws C1097h {
        C1049a m1619c = m1619c();
        if (m1619c == null) {
            return null;
        }
        m1618b(m1619c);
        int[] iArr = new int[m1619c.m1558c()];
        for (C1052d c1052d : m1614b()) {
            if (c1052d != null) {
                int m1580c = c1052d.m1580c();
                if (m1580c >= iArr.length) {
                    throw C1097h.getFormatInstance();
                }
                iArr[m1580c] = iArr[m1580c] + 1;
            }
        }
        return iArr;
    }

    /* renamed from: e */
    boolean m1621e() {
        return this.f2034d;
    }

    /* renamed from: f */
    void m1622f() {
        for (C1052d c1052d : m1614b()) {
            if (c1052d != null) {
                c1052d.m1585h();
            }
        }
    }

    @Override // p031c.p035b.p043c.p057e0.p058e.C1055g
    public String toString() {
        return "IsLeft: " + this.f2034d + '\n' + super.toString();
    }

    /* renamed from: a */
    private void m1616a(C1052d[] c1052dArr, C1049a c1049a) {
        for (int i2 = 0; i2 < c1052dArr.length; i2++) {
            C1052d c1052d = c1052dArr[i2];
            if (c1052dArr[i2] != null) {
                int m1582e = c1052d.m1582e() % 30;
                int m1580c = c1052d.m1580c();
                if (m1580c > c1049a.m1558c()) {
                    c1052dArr[i2] = null;
                } else {
                    if (!this.f2034d) {
                        m1580c += 2;
                    }
                    int i3 = m1580c % 3;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 == 2 && m1582e + 1 != c1049a.m1556a()) {
                                c1052dArr[i2] = null;
                            }
                        } else if (m1582e / 3 != c1049a.m1557b() || m1582e % 3 != c1049a.m1559d()) {
                            c1052dArr[i2] = null;
                        }
                    } else if ((m1582e * 3) + 1 != c1049a.m1560e()) {
                        c1052dArr[i2] = null;
                    }
                }
            }
        }
    }
}
