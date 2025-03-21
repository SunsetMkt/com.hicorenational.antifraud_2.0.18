package com.airbnb.lottie.p100b0;

/* compiled from: MeanCalculator.java */
/* renamed from: com.airbnb.lottie.b0.f */
/* loaded from: classes.dex */
public class C1356f {

    /* renamed from: a */
    private float f3143a;

    /* renamed from: b */
    private int f3144b;

    /* renamed from: a */
    public void m2818a(float f2) {
        this.f3143a += f2;
        this.f3144b++;
        int i2 = this.f3144b;
        if (i2 == Integer.MAX_VALUE) {
            this.f3143a /= 2.0f;
            this.f3144b = i2 / 2;
        }
    }

    /* renamed from: a */
    public float m2817a() {
        int i2 = this.f3144b;
        if (i2 == 0) {
            return 0.0f;
        }
        return this.f3143a / i2;
    }
}
