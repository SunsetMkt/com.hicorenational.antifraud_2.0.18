package p031c.p035b.p043c;

/* compiled from: Dimension.java */
/* renamed from: c.b.c.f */
/* loaded from: classes.dex */
public final class C1071f {

    /* renamed from: a */
    private final int f2108a;

    /* renamed from: b */
    private final int f2109b;

    public C1071f(int i2, int i3) {
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException();
        }
        this.f2108a = i2;
        this.f2109b = i3;
    }

    /* renamed from: a */
    public int m1728a() {
        return this.f2109b;
    }

    /* renamed from: b */
    public int m1729b() {
        return this.f2108a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1071f)) {
            return false;
        }
        C1071f c1071f = (C1071f) obj;
        return this.f2108a == c1071f.f2108a && this.f2109b == c1071f.f2109b;
    }

    public int hashCode() {
        return (this.f2108a * 32713) + this.f2109b;
    }

    public String toString() {
        return this.f2108a + "x" + this.f2109b;
    }
}
