package com.airbnb.lottie.c0;

/* JADX INFO: compiled from: ScaleXY.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2137b;

    public k(float f2, float f3) {
        this.a = f2;
        this.f2137b = f3;
    }

    public float a() {
        return this.a;
    }

    public float b() {
        return this.f2137b;
    }

    public String toString() {
        return a() + "x" + b();
    }

    public boolean a(float f2, float f3) {
        return this.a == f2 && this.f2137b == f3;
    }

    public void b(float f2, float f3) {
        this.a = f2;
        this.f2137b = f3;
    }

    public k() {
        this(1.0f, 1.0f);
    }
}
