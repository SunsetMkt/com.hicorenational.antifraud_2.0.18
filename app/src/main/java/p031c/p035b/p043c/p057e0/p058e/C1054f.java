package p031c.p035b.p043c.p057e0.p058e;

import java.util.Formatter;
import p031c.p035b.p043c.p057e0.C1045a;

/* compiled from: DetectionResult.java */
/* renamed from: c.b.c.e0.e.f */
/* loaded from: classes.dex */
final class C1054f {

    /* renamed from: e */
    private static final int f2026e = 2;

    /* renamed from: a */
    private final C1049a f2027a;

    /* renamed from: b */
    private final C1055g[] f2028b;

    /* renamed from: c */
    private C1051c f2029c;

    /* renamed from: d */
    private final int f2030d;

    C1054f(C1049a c1049a, C1051c c1051c) {
        this.f2027a = c1049a;
        this.f2030d = c1049a.m1556a();
        this.f2029c = c1051c;
        this.f2028b = new C1055g[this.f2030d + 2];
    }

    /* renamed from: a */
    private void m1595a(C1055g c1055g) {
        if (c1055g != null) {
            ((C1056h) c1055g).m1617a(this.f2027a);
        }
    }

    /* renamed from: f */
    private int m1597f() {
        int m1598g = m1598g();
        if (m1598g == 0) {
            return 0;
        }
        for (int i2 = 1; i2 < this.f2030d + 1; i2++) {
            C1052d[] m1614b = this.f2028b[i2].m1614b();
            for (int i3 = 0; i3 < m1614b.length; i3++) {
                if (m1614b[i3] != null && !m1614b[i3].m1584g()) {
                    m1594a(i2, i3, m1614b);
                }
            }
        }
        return m1598g;
    }

    /* renamed from: g */
    private int m1598g() {
        m1599h();
        return m1600i() + m1601j();
    }

    /* renamed from: h */
    private void m1599h() {
        C1055g[] c1055gArr = this.f2028b;
        if (c1055gArr[0] == null || c1055gArr[this.f2030d + 1] == null) {
            return;
        }
        C1052d[] m1614b = c1055gArr[0].m1614b();
        C1052d[] m1614b2 = this.f2028b[this.f2030d + 1].m1614b();
        for (int i2 = 0; i2 < m1614b.length; i2++) {
            if (m1614b[i2] != null && m1614b2[i2] != null && m1614b[i2].m1580c() == m1614b2[i2].m1580c()) {
                for (int i3 = 1; i3 <= this.f2030d; i3++) {
                    C1052d c1052d = this.f2028b[i3].m1614b()[i2];
                    if (c1052d != null) {
                        c1052d.m1579b(m1614b[i2].m1580c());
                        if (!c1052d.m1584g()) {
                            this.f2028b[i3].m1614b()[i2] = null;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    private int m1600i() {
        C1055g[] c1055gArr = this.f2028b;
        if (c1055gArr[0] == null) {
            return 0;
        }
        C1052d[] m1614b = c1055gArr[0].m1614b();
        int i2 = 0;
        for (int i3 = 0; i3 < m1614b.length; i3++) {
            if (m1614b[i3] != null) {
                int m1580c = m1614b[i3].m1580c();
                int i4 = i2;
                int i5 = 0;
                for (int i6 = 1; i6 < this.f2030d + 1 && i5 < 2; i6++) {
                    C1052d c1052d = this.f2028b[i6].m1614b()[i3];
                    if (c1052d != null) {
                        i5 = m1593a(m1580c, i5, c1052d);
                        if (!c1052d.m1584g()) {
                            i4++;
                        }
                    }
                }
                i2 = i4;
            }
        }
        return i2;
    }

    /* renamed from: j */
    private int m1601j() {
        C1055g[] c1055gArr = this.f2028b;
        int i2 = this.f2030d;
        if (c1055gArr[i2 + 1] == null) {
            return 0;
        }
        C1052d[] m1614b = c1055gArr[i2 + 1].m1614b();
        int i3 = 0;
        for (int i4 = 0; i4 < m1614b.length; i4++) {
            if (m1614b[i4] != null) {
                int m1580c = m1614b[i4].m1580c();
                int i5 = i3;
                int i6 = 0;
                for (int i7 = this.f2030d + 1; i7 > 0 && i6 < 2; i7--) {
                    C1052d c1052d = this.f2028b[i7].m1614b()[i4];
                    if (c1052d != null) {
                        i6 = m1593a(m1580c, i6, c1052d);
                        if (!c1052d.m1584g()) {
                            i5++;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return i3;
    }

    /* renamed from: b */
    int m1606b() {
        return this.f2027a.m1557b();
    }

    /* renamed from: c */
    int m1607c() {
        return this.f2027a.m1558c();
    }

    /* renamed from: d */
    C1051c m1608d() {
        return this.f2029c;
    }

    /* renamed from: e */
    C1055g[] m1609e() {
        m1595a(this.f2028b[0]);
        m1595a(this.f2028b[this.f2030d + 1]);
        int i2 = C1045a.f1964b;
        while (true) {
            int m1597f = m1597f();
            if (m1597f <= 0 || m1597f >= i2) {
                break;
            }
            i2 = m1597f;
        }
        return this.f2028b;
    }

    public String toString() {
        C1055g[] c1055gArr = this.f2028b;
        C1055g c1055g = c1055gArr[0];
        if (c1055g == null) {
            c1055g = c1055gArr[this.f2030d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < c1055g.m1614b().length; i2++) {
            formatter.format("CW %3d:", Integer.valueOf(i2));
            for (int i3 = 0; i3 < this.f2030d + 2; i3++) {
                C1055g[] c1055gArr2 = this.f2028b;
                if (c1055gArr2[i3] == null) {
                    formatter.format("    |   ", new Object[0]);
                } else {
                    C1052d c1052d = c1055gArr2[i3].m1614b()[i2];
                    if (c1052d == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        formatter.format(" %3d|%3d", Integer.valueOf(c1052d.m1580c()), Integer.valueOf(c1052d.m1582e()));
                    }
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    /* renamed from: a */
    private static int m1593a(int i2, int i3, C1052d c1052d) {
        if (c1052d == null || c1052d.m1584g()) {
            return i3;
        }
        if (!c1052d.m1577a(i2)) {
            return i3 + 1;
        }
        c1052d.m1579b(i2);
        return 0;
    }

    /* renamed from: a */
    private void m1594a(int i2, int i3, C1052d[] c1052dArr) {
        C1052d c1052d = c1052dArr[i3];
        C1052d[] m1614b = this.f2028b[i2 - 1].m1614b();
        C1055g[] c1055gArr = this.f2028b;
        int i4 = i2 + 1;
        C1052d[] m1614b2 = c1055gArr[i4] != null ? c1055gArr[i4].m1614b() : m1614b;
        C1052d[] c1052dArr2 = new C1052d[14];
        c1052dArr2[2] = m1614b[i3];
        c1052dArr2[3] = m1614b2[i3];
        if (i3 > 0) {
            int i5 = i3 - 1;
            c1052dArr2[0] = c1052dArr[i5];
            c1052dArr2[4] = m1614b[i5];
            c1052dArr2[5] = m1614b2[i5];
        }
        if (i3 > 1) {
            int i6 = i3 - 2;
            c1052dArr2[8] = c1052dArr[i6];
            c1052dArr2[10] = m1614b[i6];
            c1052dArr2[11] = m1614b2[i6];
        }
        if (i3 < c1052dArr.length - 1) {
            int i7 = i3 + 1;
            c1052dArr2[1] = c1052dArr[i7];
            c1052dArr2[6] = m1614b[i7];
            c1052dArr2[7] = m1614b2[i7];
        }
        if (i3 < c1052dArr.length - 2) {
            int i8 = i3 + 2;
            c1052dArr2[9] = c1052dArr[i8];
            c1052dArr2[12] = m1614b[i8];
            c1052dArr2[13] = m1614b2[i8];
        }
        int length = c1052dArr2.length;
        for (int i9 = 0; i9 < length && !m1596a(c1052d, c1052dArr2[i9]); i9++) {
        }
    }

    /* renamed from: a */
    private static boolean m1596a(C1052d c1052d, C1052d c1052d2) {
        if (c1052d2 == null || !c1052d2.m1584g() || c1052d2.m1576a() != c1052d.m1576a()) {
            return false;
        }
        c1052d.m1579b(c1052d2.m1580c());
        return true;
    }

    /* renamed from: a */
    int m1602a() {
        return this.f2030d;
    }

    /* renamed from: a */
    public void m1605a(C1051c c1051c) {
        this.f2029c = c1051c;
    }

    /* renamed from: a */
    void m1604a(int i2, C1055g c1055g) {
        this.f2028b[i2] = c1055g;
    }

    /* renamed from: a */
    C1055g m1603a(int i2) {
        return this.f2028b[i2];
    }
}
