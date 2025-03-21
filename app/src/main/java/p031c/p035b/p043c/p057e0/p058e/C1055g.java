package p031c.p035b.p043c.p057e0.p058e;

import java.util.Formatter;

/* compiled from: DetectionResultColumn.java */
/* renamed from: c.b.c.e0.e.g */
/* loaded from: classes.dex */
class C1055g {

    /* renamed from: c */
    private static final int f2031c = 5;

    /* renamed from: a */
    private final C1051c f2032a;

    /* renamed from: b */
    private final C1052d[] f2033b;

    C1055g(C1051c c1051c) {
        this.f2032a = new C1051c(c1051c);
        this.f2033b = new C1052d[(c1051c.m1571d() - c1051c.m1573f()) + 1];
    }

    /* renamed from: a */
    final void m1612a(int i2, C1052d c1052d) {
        this.f2033b[m1615c(i2)] = c1052d;
    }

    /* renamed from: b */
    final C1052d m1613b(int i2) {
        C1052d c1052d;
        C1052d c1052d2;
        C1052d m1611a = m1611a(i2);
        if (m1611a != null) {
            return m1611a;
        }
        for (int i3 = 1; i3 < 5; i3++) {
            int m1615c = m1615c(i2) - i3;
            if (m1615c >= 0 && (c1052d2 = this.f2033b[m1615c]) != null) {
                return c1052d2;
            }
            int m1615c2 = m1615c(i2) + i3;
            C1052d[] c1052dArr = this.f2033b;
            if (m1615c2 < c1052dArr.length && (c1052d = c1052dArr[m1615c2]) != null) {
                return c1052d;
            }
        }
        return null;
    }

    /* renamed from: c */
    final int m1615c(int i2) {
        return i2 - this.f2032a.m1573f();
    }

    public String toString() {
        Formatter formatter = new Formatter();
        int i2 = 0;
        for (C1052d c1052d : this.f2033b) {
            if (c1052d == null) {
                formatter.format("%3d:    |   %n", Integer.valueOf(i2));
                i2++;
            } else {
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i2), Integer.valueOf(c1052d.m1580c()), Integer.valueOf(c1052d.m1582e()));
                i2++;
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }

    /* renamed from: a */
    final C1052d m1611a(int i2) {
        return this.f2033b[m1615c(i2)];
    }

    /* renamed from: a */
    final C1051c m1610a() {
        return this.f2032a;
    }

    /* renamed from: b */
    final C1052d[] m1614b() {
        return this.f2033b;
    }
}
