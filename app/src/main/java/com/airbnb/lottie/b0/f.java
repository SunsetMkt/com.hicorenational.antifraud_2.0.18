package com.airbnb.lottie.b0;

/* JADX INFO: compiled from: MeanCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2104b;

    public void a(float f2) {
        this.a += f2;
        this.f2104b++;
        int i2 = this.f2104b;
        if (i2 == Integer.MAX_VALUE) {
            this.a /= 2.0f;
            this.f2104b = i2 / 2;
        }
    }

    public float a() {
        int i2 = this.f2104b;
        if (i2 == 0) {
            return 0.0f;
        }
        return this.a / i2;
    }
}
