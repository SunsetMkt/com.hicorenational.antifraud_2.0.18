package com.airbnb.lottie.p101c0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.p100b0.C1357g;

/* compiled from: LottieInterpolatedPointValue.java */
/* renamed from: com.airbnb.lottie.c0.e */
/* loaded from: classes.dex */
public class C1365e extends AbstractC1366f<PointF> {

    /* renamed from: g */
    private final PointF f3178g;

    public C1365e(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
        this.f3178g = new PointF();
    }

    @Override // com.airbnb.lottie.p101c0.AbstractC1366f, com.airbnb.lottie.p101c0.C1370j
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo2653a(C1362b c1362b) {
        return super.mo2653a(c1362b);
    }

    public C1365e(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
        this.f3178g = new PointF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.p101c0.AbstractC1366f
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public PointF mo2865a(PointF pointF, PointF pointF2, float f2) {
        this.f3178g.set(C1357g.m2831c(pointF.x, pointF2.x, f2), C1357g.m2831c(pointF.y, pointF2.y, f2));
        return this.f3178g;
    }
}
