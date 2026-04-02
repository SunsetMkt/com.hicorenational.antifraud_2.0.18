package com.airbnb.lottie.y.k;

import android.graphics.Path;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: GradientFill.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {
    private final f a;

    /* JADX INFO: renamed from: b */
    private final Path.FillType f2444b;

    /* JADX INFO: renamed from: c */
    private final com.airbnb.lottie.y.j.c f2445c;

    /* JADX INFO: renamed from: d */
    private final com.airbnb.lottie.y.j.d f2446d;

    /* JADX INFO: renamed from: e */
    private final com.airbnb.lottie.y.j.f f2447e;

    /* JADX INFO: renamed from: f */
    private final com.airbnb.lottie.y.j.f f2448f;

    /* JADX INFO: renamed from: g */
    private final String f2449g;

    /* JADX INFO: renamed from: h */
    @Nullable
    private final com.airbnb.lottie.y.j.b f2450h;

    /* JADX INFO: renamed from: i */
    @Nullable
    private final com.airbnb.lottie.y.j.b f2451i;

    /* JADX INFO: renamed from: j */
    private final boolean f2452j;

    public d(String str, f fVar, Path.FillType fillType, com.airbnb.lottie.y.j.c cVar, com.airbnb.lottie.y.j.d dVar, com.airbnb.lottie.y.j.f fVar2, com.airbnb.lottie.y.j.f fVar3, com.airbnb.lottie.y.j.b bVar, com.airbnb.lottie.y.j.b bVar2, boolean z) {
        this.a = fVar;
        this.f2444b = fillType;
        this.f2445c = cVar;
        this.f2446d = dVar;
        this.f2447e = fVar2;
        this.f2448f = fVar3;
        this.f2449g = str;
        this.f2450h = bVar;
        this.f2451i = bVar2;
        this.f2452j = z;
    }

    public com.airbnb.lottie.y.j.f a() {
        return this.f2448f;
    }

    public Path.FillType b() {
        return this.f2444b;
    }

    public com.airbnb.lottie.y.j.c c() {
        return this.f2445c;
    }

    public f d() {
        return this.a;
    }

    @Nullable
    com.airbnb.lottie.y.j.b e() {
        return this.f2451i;
    }

    @Nullable
    com.airbnb.lottie.y.j.b f() {
        return this.f2450h;
    }

    public String g() {
        return this.f2449g;
    }

    public com.airbnb.lottie.y.j.d h() {
        return this.f2446d;
    }

    public com.airbnb.lottie.y.j.f i() {
        return this.f2447e;
    }

    public boolean j() {
        return this.f2452j;
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.h(jVar, aVar, this);
    }
}
