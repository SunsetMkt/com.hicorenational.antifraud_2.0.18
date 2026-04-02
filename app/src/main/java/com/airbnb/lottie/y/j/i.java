package com.airbnb.lottie.y.j;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: AnimatableSplitDimensionPathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements m<PointF, PointF> {
    private final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f2427b;

    public i(b bVar, b bVar2) {
        this.a = bVar;
        this.f2427b = bVar2;
    }

    @Override // com.airbnb.lottie.y.j.m
    public com.airbnb.lottie.w.c.a<PointF, PointF> a() {
        return new com.airbnb.lottie.w.c.m(this.a.a(), this.f2427b.a());
    }

    @Override // com.airbnb.lottie.y.j.m
    public List<com.airbnb.lottie.c0.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.y.j.m
    public boolean c() {
        return this.a.c() && this.f2427b.c();
    }
}
