package com.airbnb.lottie.w.c;

import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: compiled from: ValueCallbackKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class p<K, A> extends a<K, A> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.c0.b<A> f2388i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final A f2389j;

    public p(com.airbnb.lottie.c0.j<A> jVar) {
        this(jVar, null);
    }

    @Override // com.airbnb.lottie.w.c.a
    public void a(float f2) {
        this.f2349d = f2;
    }

    @Override // com.airbnb.lottie.w.c.a
    float b() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.w.c.a
    public A f() {
        com.airbnb.lottie.c0.j<A> jVar = this.f2350e;
        A a = this.f2389j;
        return jVar.a(0.0f, 0.0f, a, a, e(), e(), e());
    }

    @Override // com.airbnb.lottie.w.c.a
    public void g() {
        if (this.f2350e != null) {
            super.g();
        }
    }

    public p(com.airbnb.lottie.c0.j<A> jVar, @Nullable A a) {
        super(Collections.emptyList());
        this.f2388i = new com.airbnb.lottie.c0.b<>();
        a(jVar);
        this.f2389j = a;
    }

    @Override // com.airbnb.lottie.w.c.a
    A a(com.airbnb.lottie.c0.a<K> aVar, float f2) {
        return f();
    }
}
