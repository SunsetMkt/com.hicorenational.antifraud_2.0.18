package d.b.c.d0.a0;

import d.b.c.t;

/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f9556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t[] f9557c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.a = i2;
        this.f9556b = iArr;
        float f2 = i5;
        this.f9557c = new t[]{new t(i3, f2), new t(i4, f2)};
    }

    public t[] a() {
        return this.f9557c;
    }

    public int[] b() {
        return this.f9556b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
