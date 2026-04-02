package d.b.c;

/* JADX INFO: compiled from: Dimension.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9778b;

    public f(int i2, int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException();
        }
        this.a = i2;
        this.f9778b = i3;
    }

    public int a() {
        return this.f9778b;
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a == fVar.a && this.f9778b == fVar.f9778b;
    }

    public int hashCode() {
        return (this.a * 32713) + this.f9778b;
    }

    public String toString() {
        return this.a + "x" + this.f9778b;
    }
}
