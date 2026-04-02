package d.b.c.d0.a0.g.e;

/* JADX INFO: compiled from: CurrentParsingState.java */
/* JADX INFO: loaded from: classes.dex */
final class m {
    private int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f9590b = a.NUMERIC;

    /* JADX INFO: compiled from: CurrentParsingState.java */
    private enum a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    m() {
    }

    int a() {
        return this.a;
    }

    void b(int i2) {
        this.a = i2;
    }

    boolean c() {
        return this.f9590b == a.ISO_IEC_646;
    }

    boolean d() {
        return this.f9590b == a.NUMERIC;
    }

    void e() {
        this.f9590b = a.ALPHA;
    }

    void f() {
        this.f9590b = a.ISO_IEC_646;
    }

    void g() {
        this.f9590b = a.NUMERIC;
    }

    void a(int i2) {
        this.a += i2;
    }

    boolean b() {
        return this.f9590b == a.ALPHA;
    }
}
