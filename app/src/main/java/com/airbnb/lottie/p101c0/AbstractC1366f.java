package com.airbnb.lottie.p101c0;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: LottieInterpolatedValue.java */
/* renamed from: com.airbnb.lottie.c0.f */
/* loaded from: classes.dex */
abstract class AbstractC1366f<T> extends C1370j<T> {

    /* renamed from: d */
    private final T f3179d;

    /* renamed from: e */
    private final T f3180e;

    /* renamed from: f */
    private final Interpolator f3181f;

    AbstractC1366f(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    @Override // com.airbnb.lottie.p101c0.C1370j
    /* renamed from: a */
    public T mo2653a(C1362b<T> c1362b) {
        return mo2865a(this.f3179d, this.f3180e, this.f3181f.getInterpolation(c1362b.m2862e()));
    }

    /* renamed from: a */
    abstract T mo2865a(T t, T t2, float f2);

    AbstractC1366f(T t, T t2, Interpolator interpolator) {
        this.f3179d = t;
        this.f3180e = t2;
        this.f3181f = interpolator;
    }
}
