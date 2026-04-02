package com.airbnb.lottie.y.k;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.j.h f2497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2498d;

    public o(String str, int i2, com.airbnb.lottie.y.j.h hVar, boolean z) {
        this.a = str;
        this.f2496b = i2;
        this.f2497c = hVar;
        this.f2498d = z;
    }

    public String a() {
        return this.a;
    }

    public com.airbnb.lottie.y.j.h b() {
        return this.f2497c;
    }

    public boolean c() {
        return this.f2498d;
    }

    public String toString() {
        return "ShapePath{name=" + this.a + ", index=" + this.f2496b + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.r(jVar, aVar, this);
    }
}
