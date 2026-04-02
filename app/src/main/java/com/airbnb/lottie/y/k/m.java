package com.airbnb.lottie.y.k;

import android.graphics.Path;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ShapeFill.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements b {
    private final boolean a;

    /* JADX INFO: renamed from: b */
    private final Path.FillType f2489b;

    /* JADX INFO: renamed from: c */
    private final String f2490c;

    /* JADX INFO: renamed from: d */
    @Nullable
    private final com.airbnb.lottie.y.j.a f2491d;

    /* JADX INFO: renamed from: e */
    @Nullable
    private final com.airbnb.lottie.y.j.d f2492e;

    /* JADX INFO: renamed from: f */
    private final boolean f2493f;

    public m(String str, boolean z, Path.FillType fillType, @Nullable com.airbnb.lottie.y.j.a aVar, @Nullable com.airbnb.lottie.y.j.d dVar, boolean z2) {
        this.f2490c = str;
        this.a = z;
        this.f2489b = fillType;
        this.f2491d = aVar;
        this.f2492e = dVar;
        this.f2493f = z2;
    }

    @Nullable
    public com.airbnb.lottie.y.j.a a() {
        return this.f2491d;
    }

    public Path.FillType b() {
        return this.f2489b;
    }

    public String c() {
        return this.f2490c;
    }

    @Nullable
    public com.airbnb.lottie.y.j.d d() {
        return this.f2492e;
    }

    public boolean e() {
        return this.f2493f;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }

    @Override // com.airbnb.lottie.y.k.b
    public com.airbnb.lottie.w.b.c a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar) {
        return new com.airbnb.lottie.w.b.g(jVar, aVar, this);
    }
}
