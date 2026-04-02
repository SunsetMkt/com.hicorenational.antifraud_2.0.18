package com.airbnb.lottie.y.j;

import android.graphics.PointF;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AnimatablePathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.c0.a<PointF>> a;

    public e() {
        this.a = Collections.singletonList(new com.airbnb.lottie.c0.a(new PointF(0.0f, 0.0f)));
    }

    @Override // com.airbnb.lottie.y.j.m
    public com.airbnb.lottie.w.c.a<PointF, PointF> a() {
        return this.a.get(0).g() ? new com.airbnb.lottie.w.c.j(this.a) : new com.airbnb.lottie.w.c.i(this.a);
    }

    @Override // com.airbnb.lottie.y.j.m
    public List<com.airbnb.lottie.c0.a<PointF>> b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.y.j.m
    public boolean c() {
        return this.a.size() == 1 && this.a.get(0).g();
    }

    public e(List<com.airbnb.lottie.c0.a<PointF>> list) {
        this.a = list;
    }
}
