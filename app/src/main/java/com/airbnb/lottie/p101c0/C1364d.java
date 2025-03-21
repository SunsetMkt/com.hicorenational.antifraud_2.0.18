package com.airbnb.lottie.p101c0;

import android.view.animation.Interpolator;
import com.airbnb.lottie.p100b0.C1357g;

/* compiled from: LottieInterpolatedIntegerValue.java */
/* renamed from: com.airbnb.lottie.c0.d */
/* loaded from: classes.dex */
public class C1364d extends AbstractC1366f<Integer> {
    public C1364d(Integer num, Integer num2) {
        super(num, num2);
    }

    @Override // com.airbnb.lottie.p101c0.AbstractC1366f, com.airbnb.lottie.p101c0.C1370j
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo2653a(C1362b c1362b) {
        return super.mo2653a(c1362b);
    }

    public C1364d(Integer num, Integer num2, Interpolator interpolator) {
        super(num, num2, interpolator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.p101c0.AbstractC1366f
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Integer mo2865a(Integer num, Integer num2, float f2) {
        return Integer.valueOf(C1357g.m2823a(num.intValue(), num2.intValue(), f2));
    }
}
