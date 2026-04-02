package com.airbnb.lottie.c0;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: LottieFrameInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T> {
    private float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f2125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private T f2126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f2129g;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public b<T> a(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        this.a = f2;
        this.f2124b = f3;
        this.f2125c = t;
        this.f2126d = t2;
        this.f2127e = f4;
        this.f2128f = f5;
        this.f2129g = f6;
        return this;
    }

    public T b() {
        return this.f2126d;
    }

    public float c() {
        return this.f2128f;
    }

    public float d() {
        return this.f2127e;
    }

    public float e() {
        return this.f2129g;
    }

    public float f() {
        return this.a;
    }

    public T g() {
        return this.f2125c;
    }

    public float a() {
        return this.f2124b;
    }
}
