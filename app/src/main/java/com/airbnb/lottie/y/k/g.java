package com.airbnb.lottie.y.k;

/* JADX INFO: compiled from: Mask.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    private final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.h f2465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.d f2466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2467d;

    /* JADX INFO: compiled from: Mask.java */
    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public g(a aVar, com.airbnb.lottie.y.j.h hVar, com.airbnb.lottie.y.j.d dVar, boolean z) {
        this.a = aVar;
        this.f2465b = hVar;
        this.f2466c = dVar;
        this.f2467d = z;
    }

    public a a() {
        return this.a;
    }

    public com.airbnb.lottie.y.j.h b() {
        return this.f2465b;
    }

    public com.airbnb.lottie.y.j.d c() {
        return this.f2466c;
    }

    public boolean d() {
        return this.f2467d;
    }
}
