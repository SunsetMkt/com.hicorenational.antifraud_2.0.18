package com.airbnb.lottie.p101c0;

import android.view.animation.Interpolator;
import com.airbnb.lottie.p100b0.C1357g;

/* compiled from: LottieInterpolatedFloatValue.java */
/* renamed from: com.airbnb.lottie.c0.c */
/* loaded from: classes.dex */
public class C1363c extends AbstractC1366f<Float> {
    public C1363c(Float f2, Float f3) {
        super(f2, f3);
    }

    @Override // com.airbnb.lottie.p101c0.AbstractC1366f, com.airbnb.lottie.p101c0.C1370j
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo2653a(C1362b c1362b) {
        return super.mo2653a(c1362b);
    }

    public C1363c(Float f2, Float f3, Interpolator interpolator) {
        super(f2, f3, interpolator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.p101c0.AbstractC1366f
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Float mo2865a(Float f2, Float f3, float f4) {
        return Float.valueOf(C1357g.m2831c(f2.floatValue(), f3.floatValue(), f4));
    }
}
