package com.airbnb.lottie.y.k;

import android.graphics.PointF;

/* JADX INFO: compiled from: CircleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    private final String a;

    /* JADX INFO: renamed from: b */
    private final com.airbnb.lottie.y.j.m<PointF, PointF> f2439b;

    /* JADX INFO: renamed from: c */
    private final com.airbnb.lottie.y.j.f f2440c;

    /* JADX INFO: renamed from: d */
    private final boolean f2441d;

    /* JADX INFO: renamed from: e */
    private final boolean f2442e;

    public a(String str, com.airbnb.lottie.y.j.m<PointF, PointF> mVar, com.airbnb.lottie.y.j.f fVar, boolean z, boolean z2) {
        this.a = str;
        this.f2439b = mVar;
        this.f2440c = fVar;
        this.f2441d = z;
        this.f2442e = z2;
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.f(jVar, aVar, this);
    }

    public com.airbnb.lottie.y.j.m<PointF, PointF> b() {
        return this.f2439b;
    }

    public com.airbnb.lottie.y.j.f c() {
        return this.f2440c;
    }

    public boolean d() {
        return this.f2442e;
    }

    public boolean e() {
        return this.f2441d;
    }

    public String a() {
        return this.a;
    }
}
