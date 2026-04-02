package d.b.c.d0.a0;

/* JADX INFO: compiled from: DataCharacter.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9555b;

    public b(int i2, int i3) {
        this.a = i2;
        this.f9555b = i3;
    }

    public final int a() {
        return this.f9555b;
    }

    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.f9555b == bVar.f9555b;
    }

    public final int hashCode() {
        return this.a ^ this.f9555b;
    }

    public final String toString() {
        return this.a + "(" + this.f9555b + ')';
    }
}
