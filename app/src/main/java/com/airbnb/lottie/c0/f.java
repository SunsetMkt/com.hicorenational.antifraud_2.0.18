package com.airbnb.lottie.c0;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: compiled from: LottieInterpolatedValue.java */
/* JADX INFO: loaded from: classes.dex */
abstract class f<T> extends j<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final T f2131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final T f2132e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Interpolator f2133f;

    f(T t, T t2) {
        this(t, t2, new LinearInterpolator());
    }

    @Override // com.airbnb.lottie.c0.j
    public T a(b<T> bVar) {
        return a(this.f2131d, this.f2132e, this.f2133f.getInterpolation(bVar.e()));
    }

    abstract T a(T t, T t2, float f2);

    f(T t, T t2, Interpolator interpolator) {
        this.f2131d = t;
        this.f2132e = t2;
        this.f2133f = interpolator;
    }
}
