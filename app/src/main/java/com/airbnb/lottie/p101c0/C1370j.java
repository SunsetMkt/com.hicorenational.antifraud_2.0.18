package com.airbnb.lottie.p101c0;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;

/* compiled from: LottieValueCallback.java */
/* renamed from: com.airbnb.lottie.c0.j */
/* loaded from: classes.dex */
public class C1370j<T> {

    /* renamed from: a */
    private final C1362b<T> f3183a;

    /* renamed from: b */
    @Nullable
    private AbstractC1414a<?, ?> f3184b;

    /* renamed from: c */
    @Nullable
    protected T f3185c;

    public C1370j() {
        this.f3183a = new C1362b<>();
        this.f3185c = null;
    }

    @Nullable
    /* renamed from: a */
    public T mo2653a(C1362b<T> c1362b) {
        return this.f3185c;
    }

    /* renamed from: a */
    public final void m2871a(@Nullable T t) {
        this.f3185c = t;
        AbstractC1414a<?, ?> abstractC1414a = this.f3184b;
        if (abstractC1414a != null) {
            abstractC1414a.mo3144g();
        }
    }

    public C1370j(@Nullable T t) {
        this.f3183a = new C1362b<>();
        this.f3185c = null;
        this.f3185c = t;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final T m2869a(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        return mo2653a((C1362b) this.f3183a.m2858a(f2, f3, t, t2, f4, f5, f6));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void m2870a(@Nullable AbstractC1414a<?, ?> abstractC1414a) {
        this.f3184b = abstractC1414a;
    }
}
