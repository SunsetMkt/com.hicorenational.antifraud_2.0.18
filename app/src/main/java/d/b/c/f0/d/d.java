package d.b.c.f0.d;

import d.b.c.t;

/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f9807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9808d;

    d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - b()) > f2 || Math.abs(f4 - a()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f9807c);
        return fAbs <= 1.0f || fAbs <= this.f9807c;
    }

    d b(float f2, float f3, float f4) {
        int i2 = this.f9808d;
        int i3 = i2 + 1;
        float fA = (i2 * a()) + f3;
        float f5 = i3;
        return new d(fA / f5, ((this.f9808d * b()) + f2) / f5, ((this.f9808d * this.f9807c) + f4) / f5, i3);
    }

    int c() {
        return this.f9808d;
    }

    public float d() {
        return this.f9807c;
    }

    private d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f9807c = f4;
        this.f9808d = i2;
    }
}
