package p031c.p035b.p043c.p053d0.p054a0.p055g.p056e;

/* compiled from: CurrentParsingState.java */
/* renamed from: c.b.c.d0.a0.g.e.m */
/* loaded from: classes.dex */
final class C1012m {

    /* renamed from: a */
    private int f1853a = 0;

    /* renamed from: b */
    private a f1854b = a.NUMERIC;

    /* compiled from: CurrentParsingState.java */
    /* renamed from: c.b.c.d0.a0.g.e.m$a */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    C1012m() {
    }

    /* renamed from: a */
    int m1439a() {
        return this.f1853a;
    }

    /* renamed from: b */
    void m1441b(int i2) {
        this.f1853a = i2;
    }

    /* renamed from: c */
    boolean m1443c() {
        return this.f1854b == a.ISO_IEC_646;
    }

    /* renamed from: d */
    boolean m1444d() {
        return this.f1854b == a.NUMERIC;
    }

    /* renamed from: e */
    void m1445e() {
        this.f1854b = a.ALPHA;
    }

    /* renamed from: f */
    void m1446f() {
        this.f1854b = a.ISO_IEC_646;
    }

    /* renamed from: g */
    void m1447g() {
        this.f1854b = a.NUMERIC;
    }

    /* renamed from: a */
    void m1440a(int i2) {
        this.f1853a += i2;
    }

    /* renamed from: b */
    boolean m1442b() {
        return this.f1854b == a.ALPHA;
    }
}
