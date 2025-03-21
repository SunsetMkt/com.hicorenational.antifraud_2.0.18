package p031c.p035b.p043c.p057e0.p058e;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: BoundingBox.java */
/* renamed from: c.b.c.e0.e.c */
/* loaded from: classes.dex */
final class C1051c {

    /* renamed from: a */
    private C1163b f1985a;

    /* renamed from: b */
    private C1109t f1986b;

    /* renamed from: c */
    private C1109t f1987c;

    /* renamed from: d */
    private C1109t f1988d;

    /* renamed from: e */
    private C1109t f1989e;

    /* renamed from: f */
    private int f1990f;

    /* renamed from: g */
    private int f1991g;

    /* renamed from: h */
    private int f1992h;

    /* renamed from: i */
    private int f1993i;

    C1051c(C1163b c1163b, C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4) throws C1102m {
        if ((c1109t == null && c1109t3 == null) || ((c1109t2 == null && c1109t4 == null) || ((c1109t != null && c1109t2 == null) || (c1109t3 != null && c1109t4 == null)))) {
            throw C1102m.getNotFoundInstance();
        }
        m1565a(c1163b, c1109t, c1109t2, c1109t3, c1109t4);
    }

    /* renamed from: a */
    private void m1565a(C1163b c1163b, C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4) {
        this.f1985a = c1163b;
        this.f1986b = c1109t;
        this.f1987c = c1109t2;
        this.f1988d = c1109t3;
        this.f1989e = c1109t4;
        m1566i();
    }

    /* renamed from: i */
    private void m1566i() {
        if (this.f1986b == null) {
            this.f1986b = new C1109t(0.0f, this.f1988d.m1923b());
            this.f1987c = new C1109t(0.0f, this.f1989e.m1923b());
        } else if (this.f1988d == null) {
            this.f1988d = new C1109t(this.f1985a.m2181g() - 1, this.f1986b.m1923b());
            this.f1989e = new C1109t(this.f1985a.m2181g() - 1, this.f1987c.m1923b());
        }
        this.f1990f = (int) Math.min(this.f1986b.m1922a(), this.f1987c.m1922a());
        this.f1991g = (int) Math.max(this.f1988d.m1922a(), this.f1989e.m1922a());
        this.f1992h = (int) Math.min(this.f1986b.m1923b(), this.f1988d.m1923b());
        this.f1993i = (int) Math.max(this.f1987c.m1923b(), this.f1989e.m1923b());
    }

    /* renamed from: b */
    C1109t m1569b() {
        return this.f1989e;
    }

    /* renamed from: c */
    int m1570c() {
        return this.f1991g;
    }

    /* renamed from: d */
    int m1571d() {
        return this.f1993i;
    }

    /* renamed from: e */
    int m1572e() {
        return this.f1990f;
    }

    /* renamed from: f */
    int m1573f() {
        return this.f1992h;
    }

    /* renamed from: g */
    C1109t m1574g() {
        return this.f1986b;
    }

    /* renamed from: h */
    C1109t m1575h() {
        return this.f1988d;
    }

    C1051c(C1051c c1051c) {
        m1565a(c1051c.f1985a, c1051c.f1986b, c1051c.f1987c, c1051c.f1988d, c1051c.f1989e);
    }

    /* renamed from: a */
    static C1051c m1564a(C1051c c1051c, C1051c c1051c2) throws C1102m {
        return c1051c == null ? c1051c2 : c1051c2 == null ? c1051c : new C1051c(c1051c.f1985a, c1051c.f1986b, c1051c.f1987c, c1051c2.f1988d, c1051c2.f1989e);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    p031c.p035b.p043c.p057e0.p058e.C1051c m1567a(int r13, int r14, boolean r15) throws p031c.p035b.p043c.C1102m {
        /*
            r12 = this;
            c.b.c.t r0 = r12.f1986b
            c.b.c.t r1 = r12.f1987c
            c.b.c.t r2 = r12.f1988d
            c.b.c.t r3 = r12.f1989e
            if (r13 <= 0) goto L29
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.m1923b()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            c.b.c.t r13 = new c.b.c.t
            float r4 = r4.m1922a()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L26
            r8 = r13
            goto L2a
        L26:
            r10 = r13
            r8 = r0
            goto L2b
        L29:
            r8 = r0
        L2a:
            r10 = r2
        L2b:
            if (r14 <= 0) goto L5b
            if (r15 == 0) goto L32
            c.b.c.t r13 = r12.f1987c
            goto L34
        L32:
            c.b.c.t r13 = r12.f1989e
        L34:
            float r0 = r13.m1923b()
            int r0 = (int) r0
            int r0 = r0 + r14
            c.b.c.z.b r14 = r12.f1985a
            int r14 = r14.m2177d()
            if (r0 < r14) goto L4a
            c.b.c.z.b r14 = r12.f1985a
            int r14 = r14.m2177d()
            int r0 = r14 + (-1)
        L4a:
            c.b.c.t r14 = new c.b.c.t
            float r13 = r13.m1922a()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L58
            r9 = r14
            goto L5c
        L58:
            r11 = r14
            r9 = r1
            goto L5d
        L5b:
            r9 = r1
        L5c:
            r11 = r3
        L5d:
            r12.m1566i()
            c.b.c.e0.e.c r13 = new c.b.c.e0.e.c
            c.b.c.z.b r7 = r12.f1985a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p057e0.p058e.C1051c.m1567a(int, int, boolean):c.b.c.e0.e.c");
    }

    /* renamed from: a */
    C1109t m1568a() {
        return this.f1987c;
    }
}
