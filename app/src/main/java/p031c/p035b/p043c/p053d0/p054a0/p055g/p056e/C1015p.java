package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

import p031c.p035b.p043c.C1097h;

/* compiled from: DecodedNumeric.java */
/* renamed from: c.b.c.d0.a0.g.e.p */
/* loaded from: classes.dex */
final class C1015p extends AbstractC1016q {

    /* renamed from: d */
    static final int f1861d = 10;

    /* renamed from: b */
    private final int f1862b;

    /* renamed from: c */
    private final int f1863c;

    C1015p(int i2, int i3, int i4) throws C1097h {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw C1097h.getFormatInstance();
        }
        this.f1862b = i3;
        this.f1863c = i4;
    }

    /* renamed from: b */
    int m1453b() {
        return this.f1862b;
    }

    /* renamed from: c */
    int m1454c() {
        return this.f1863c;
    }

    /* renamed from: d */
    int m1455d() {
        return (this.f1862b * 10) + this.f1863c;
    }

    /* renamed from: e */
    boolean m1456e() {
        return this.f1862b == 10 || this.f1863c == 10;
    }

    /* renamed from: f */
    boolean m1457f() {
        return this.f1862b == 10;
    }

    /* renamed from: g */
    boolean m1458g() {
        return this.f1863c == 10;
    }
}
