package com.airbnb.lottie.w.c;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: compiled from: ShapeKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends a<com.airbnb.lottie.y.k.l, Path> {

    /* JADX INFO: renamed from: i */
    private final com.airbnb.lottie.y.k.l f2367i;

    /* JADX INFO: renamed from: j */
    private final Path f2368j;

    public l(List<com.airbnb.lottie.c0.a<com.airbnb.lottie.y.k.l>> list) {
        super(list);
        this.f2367i = new com.airbnb.lottie.y.k.l();
        this.f2368j = new Path();
    }

    @Override // com.airbnb.lottie.w.c.a
    public Path a(com.airbnb.lottie.c0.a<com.airbnb.lottie.y.k.l> aVar, float f2) {
        this.f2367i.a(aVar.f2111b, aVar.f2112c, f2);
        com.airbnb.lottie.b0.g.a(this.f2367i, this.f2368j);
        return this.f2368j;
    }
}
