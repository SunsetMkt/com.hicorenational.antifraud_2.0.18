package com.airbnb.lottie.y.k;

import android.graphics.PointF;

/* JADX INFO: compiled from: RectangleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements b {
    private final String a;

    /* JADX INFO: renamed from: b */
    private final com.airbnb.lottie.y.j.m<PointF, PointF> f2479b;

    /* JADX INFO: renamed from: c */
    private final com.airbnb.lottie.y.j.m<PointF, PointF> f2480c;

    /* JADX INFO: renamed from: d */
    private final com.airbnb.lottie.y.j.b f2481d;

    /* JADX INFO: renamed from: e */
    private final boolean f2482e;

    public j(String str, com.airbnb.lottie.y.j.m<PointF, PointF> mVar, com.airbnb.lottie.y.j.m<PointF, PointF> mVar2, com.airbnb.lottie.y.j.b bVar, boolean z) {
        this.a = str;
        this.f2479b = mVar;
        this.f2480c = mVar2;
        this.f2481d = bVar;
        this.f2482e = z;
    }

    public com.airbnb.lottie.y.j.b a() {
        return this.f2481d;
    }

    public String b() {
        return this.a;
    }

    public com.airbnb.lottie.y.j.m<PointF, PointF> c() {
        return this.f2479b;
    }

    public com.airbnb.lottie.y.j.m<PointF, PointF> d() {
        return this.f2480c;
    }

    public boolean e() {
        return this.f2482e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f2479b + ", size=" + this.f2480c + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.p(jVar, aVar, this);
    }
}
