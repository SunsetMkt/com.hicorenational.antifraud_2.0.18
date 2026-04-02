package com.airbnb.lottie.c0;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: LottieValueCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class j<T> {
    private final b<T> a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private com.airbnb.lottie.w.c.a<?, ?> f2135b;

    /* JADX INFO: renamed from: c */
    @Nullable
    protected T f2136c;

    public j() {
        this.a = new b<>();
        this.f2136c = null;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.f2136c;
    }

    public final void a(@Nullable T t) {
        this.f2136c = t;
        com.airbnb.lottie.w.c.a<?, ?> aVar = this.f2135b;
        if (aVar != null) {
            aVar.g();
        }
    }

    public j(@Nullable T t) {
        this.a = new b<>();
        this.f2136c = null;
        this.f2136c = t;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T a(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        return a((b) this.a.a(f2, f3, t, t2, f4, f5, f6));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void a(@Nullable com.airbnb.lottie.w.c.a<?, ?> aVar) {
        this.f2135b = aVar;
    }
}
