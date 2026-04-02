package d.b.c;

/* JADX INFO: compiled from: BinaryBitmap.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.c.z.b f9526b;

    public c(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = bVar;
    }

    public d.b.c.z.a a(int i2, d.b.c.z.a aVar) throws m {
        return this.a.a(i2, aVar);
    }

    public int b() {
        return this.a.b();
    }

    public int c() {
        return this.a.d();
    }

    public boolean d() {
        return this.a.c().e();
    }

    public boolean e() {
        return this.a.c().f();
    }

    public c f() {
        return new c(this.a.a(this.a.c().g()));
    }

    public c g() {
        return new c(this.a.a(this.a.c().h()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (m unused) {
            return "";
        }
    }

    public d.b.c.z.b a() throws m {
        if (this.f9526b == null) {
            this.f9526b = this.a.a();
        }
        return this.f9526b;
    }

    public c a(int i2, int i3, int i4, int i5) {
        return new c(this.a.a(this.a.c().a(i2, i3, i4, i5)));
    }
}
