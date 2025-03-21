package p031c.p035b.p043c.p062f0.p064d;

import p031c.p035b.p043c.C1109t;

/* compiled from: FinderPattern.java */
/* renamed from: c.b.c.f0.d.d */
/* loaded from: classes.dex */
public final class C1087d extends C1109t {

    /* renamed from: c */
    private final float f2158c;

    /* renamed from: d */
    private final int f2159d;

    C1087d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    /* renamed from: a */
    boolean m1804a(float f2, float f3, float f4) {
        if (Math.abs(f3 - m1923b()) > f2 || Math.abs(f4 - m1922a()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.f2158c);
        return abs <= 1.0f || abs <= this.f2158c;
    }

    /* renamed from: b */
    C1087d m1805b(float f2, float f3, float f4) {
        int i2 = this.f2159d;
        int i3 = i2 + 1;
        float m1922a = (i2 * m1922a()) + f3;
        float f5 = i3;
        return new C1087d(m1922a / f5, ((this.f2159d * m1923b()) + f2) / f5, ((this.f2159d * this.f2158c) + f4) / f5, i3);
    }

    /* renamed from: c */
    int m1806c() {
        return this.f2159d;
    }

    /* renamed from: d */
    public float m1807d() {
        return this.f2158c;
    }

    private C1087d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f2158c = f4;
        this.f2159d = i2;
    }
}
