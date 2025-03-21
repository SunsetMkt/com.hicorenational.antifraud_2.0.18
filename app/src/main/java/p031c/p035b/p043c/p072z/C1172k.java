package p031c.p035b.p043c.p072z;

/* compiled from: PerspectiveTransform.java */
/* renamed from: c.b.c.z.k */
/* loaded from: classes.dex */
public final class C1172k {

    /* renamed from: a */
    private final float f2422a;

    /* renamed from: b */
    private final float f2423b;

    /* renamed from: c */
    private final float f2424c;

    /* renamed from: d */
    private final float f2425d;

    /* renamed from: e */
    private final float f2426e;

    /* renamed from: f */
    private final float f2427f;

    /* renamed from: g */
    private final float f2428g;

    /* renamed from: h */
    private final float f2429h;

    /* renamed from: i */
    private final float f2430i;

    private C1172k(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f2422a = f2;
        this.f2423b = f5;
        this.f2424c = f8;
        this.f2425d = f3;
        this.f2426e = f6;
        this.f2427f = f9;
        this.f2428g = f4;
        this.f2429h = f7;
        this.f2430i = f10;
    }

    /* renamed from: a */
    public static C1172k m2214a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return m2215b(f10, f11, f12, f13, f14, f15, f16, f17).m2217a(m2213a(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    /* renamed from: b */
    public static C1172k m2215b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new C1172k(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new C1172k((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f5 - f3) + (f17 * f5), (f9 - f3) + (f18 * f9), f3, f17, f18, 1.0f);
    }

    /* renamed from: a */
    public void m2218a(float[] fArr) {
        int length = fArr.length;
        float f2 = this.f2422a;
        float f3 = this.f2423b;
        float f4 = this.f2424c;
        float f5 = this.f2425d;
        float f6 = this.f2426e;
        float f7 = this.f2427f;
        float f8 = this.f2428g;
        float f9 = this.f2429h;
        float f10 = this.f2430i;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr[i2];
            int i3 = i2 + 1;
            float f12 = fArr[i3];
            float f13 = (f4 * f11) + (f7 * f12) + f10;
            fArr[i2] = (((f2 * f11) + (f5 * f12)) + f8) / f13;
            fArr[i3] = (((f11 * f3) + (f12 * f6)) + f9) / f13;
        }
    }

    /* renamed from: a */
    public void m2219a(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr[i2];
            float f3 = fArr2[i2];
            float f4 = (this.f2424c * f2) + (this.f2427f * f3) + this.f2430i;
            fArr[i2] = (((this.f2422a * f2) + (this.f2425d * f3)) + this.f2428g) / f4;
            fArr2[i2] = (((this.f2423b * f2) + (this.f2426e * f3)) + this.f2429h) / f4;
        }
    }

    /* renamed from: a */
    public static C1172k m2213a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return m2215b(f2, f3, f4, f5, f6, f7, f8, f9).m2216a();
    }

    /* renamed from: a */
    C1172k m2216a() {
        float f2 = this.f2426e;
        float f3 = this.f2430i;
        float f4 = this.f2427f;
        float f5 = this.f2429h;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = this.f2428g;
        float f8 = this.f2425d;
        float f9 = (f4 * f7) - (f8 * f3);
        float f10 = (f8 * f5) - (f2 * f7);
        float f11 = this.f2424c;
        float f12 = this.f2423b;
        float f13 = (f11 * f5) - (f12 * f3);
        float f14 = this.f2422a;
        return new C1172k(f6, f9, f10, f13, (f3 * f14) - (f11 * f7), (f7 * f12) - (f5 * f14), (f12 * f4) - (f11 * f2), (f11 * f8) - (f4 * f14), (f14 * f2) - (f12 * f8));
    }

    /* renamed from: a */
    C1172k m2217a(C1172k c1172k) {
        float f2 = this.f2422a;
        float f3 = c1172k.f2422a;
        float f4 = this.f2425d;
        float f5 = c1172k.f2423b;
        float f6 = this.f2428g;
        float f7 = c1172k.f2424c;
        float f8 = (f2 * f3) + (f4 * f5) + (f6 * f7);
        float f9 = c1172k.f2425d;
        float f10 = c1172k.f2426e;
        float f11 = c1172k.f2427f;
        float f12 = (f2 * f9) + (f4 * f10) + (f6 * f11);
        float f13 = c1172k.f2428g;
        float f14 = c1172k.f2429h;
        float f15 = c1172k.f2430i;
        float f16 = (f2 * f13) + (f4 * f14) + (f6 * f15);
        float f17 = this.f2423b;
        float f18 = this.f2426e;
        float f19 = this.f2429h;
        float f20 = (f17 * f3) + (f18 * f5) + (f19 * f7);
        float f21 = (f17 * f9) + (f18 * f10) + (f19 * f11);
        float f22 = (f19 * f15) + (f17 * f13) + (f18 * f14);
        float f23 = this.f2424c;
        float f24 = this.f2427f;
        float f25 = (f3 * f23) + (f5 * f24);
        float f26 = this.f2430i;
        return new C1172k(f8, f12, f16, f20, f21, f22, (f7 * f26) + f25, (f9 * f23) + (f10 * f24) + (f11 * f26), (f23 * f13) + (f24 * f14) + (f26 * f15));
    }
}
