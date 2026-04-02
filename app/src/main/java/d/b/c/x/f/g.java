package d.b.c.x.f;

/* JADX INFO: compiled from: Token.java */
/* JADX INFO: loaded from: classes.dex */
abstract class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final g f9896b = new e(null, 0, 0);
    private final g a;

    g(g gVar) {
        this.a = gVar;
    }

    final g a() {
        return this.a;
    }

    abstract void a(d.b.c.z.a aVar, byte[] bArr);

    final g b(int i2, int i3) {
        return new b(this, i2, i3);
    }

    final g a(int i2, int i3) {
        return new e(this, i2, i3);
    }
}
