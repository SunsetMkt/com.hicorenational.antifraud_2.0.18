package com.airbnb.lottie.y.k;

import android.graphics.PointF;

/* JADX INFO: compiled from: PolystarShape.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements b {
    private final String a;

    /* JADX INFO: renamed from: b */
    private final a f2470b;

    /* JADX INFO: renamed from: c */
    private final com.airbnb.lottie.y.j.b f2471c;

    /* JADX INFO: renamed from: d */
    private final com.airbnb.lottie.y.j.m<PointF, PointF> f2472d;

    /* JADX INFO: renamed from: e */
    private final com.airbnb.lottie.y.j.b f2473e;

    /* JADX INFO: renamed from: f */
    private final com.airbnb.lottie.y.j.b f2474f;

    /* JADX INFO: renamed from: g */
    private final com.airbnb.lottie.y.j.b f2475g;

    /* JADX INFO: renamed from: h */
    private final com.airbnb.lottie.y.j.b f2476h;

    /* JADX INFO: renamed from: i */
    private final com.airbnb.lottie.y.j.b f2477i;

    /* JADX INFO: renamed from: j */
    private final boolean f2478j;

    /* JADX INFO: compiled from: PolystarShape.java */
    public enum a {
        STAR(1),
        POLYGON(2);

        private final int value;

        a(int i2) {
            this.value = i2;
        }

        public static a forValue(int i2) {
            for (a aVar : values()) {
                if (aVar.value == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public i(String str, a aVar, com.airbnb.lottie.y.j.b bVar, com.airbnb.lottie.y.j.m<PointF, PointF> mVar, com.airbnb.lottie.y.j.b bVar2, com.airbnb.lottie.y.j.b bVar3, com.airbnb.lottie.y.j.b bVar4, com.airbnb.lottie.y.j.b bVar5, com.airbnb.lottie.y.j.b bVar6, boolean z) {
        this.a = str;
        this.f2470b = aVar;
        this.f2471c = bVar;
        this.f2472d = mVar;
        this.f2473e = bVar2;
        this.f2474f = bVar3;
        this.f2475g = bVar4;
        this.f2476h = bVar5;
        this.f2477i = bVar6;
        this.f2478j = z;
    }

    public com.airbnb.lottie.y.j.b a() {
        return this.f2474f;
    }

    public com.airbnb.lottie.y.j.b b() {
        return this.f2476h;
    }

    public String c() {
        return this.a;
    }

    public com.airbnb.lottie.y.j.b d() {
        return this.f2475g;
    }

    public com.airbnb.lottie.y.j.b e() {
        return this.f2477i;
    }

    public com.airbnb.lottie.y.j.b f() {
        return this.f2471c;
    }

    public com.airbnb.lottie.y.j.m<PointF, PointF> g() {
        return this.f2472d;
    }

    public com.airbnb.lottie.y.j.b h() {
        return this.f2473e;
    }

    public a i() {
        return this.f2470b;
    }

    public boolean j() {
        return this.f2478j;
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.o(jVar, aVar, this);
    }
}
