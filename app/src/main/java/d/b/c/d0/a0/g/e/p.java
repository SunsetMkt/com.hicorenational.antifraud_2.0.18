package d.b.c.d0.a0.g.e;

/* JADX INFO: compiled from: DecodedNumeric.java */
/* JADX INFO: loaded from: classes.dex */
final class p extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f9596d = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9598c;

    p(int i2, int i3, int i4) throws d.b.c.h {
        super(i2);
        if (i3 < 0 || i3 > 10 || i4 < 0 || i4 > 10) {
            throw d.b.c.h.getFormatInstance();
        }
        this.f9597b = i3;
        this.f9598c = i4;
    }

    int b() {
        return this.f9597b;
    }

    int c() {
        return this.f9598c;
    }

    int d() {
        return (this.f9597b * 10) + this.f9598c;
    }

    boolean e() {
        return this.f9597b == 10 || this.f9598c == 10;
    }

    boolean f() {
        return this.f9597b == 10;
    }

    boolean g() {
        return this.f9598c == 10;
    }
}
