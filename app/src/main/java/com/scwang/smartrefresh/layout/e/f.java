package com.scwang.smartrefresh.layout.e;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: ViscousFluidInterpolator.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements Interpolator {
    private static final float a = 8.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f5613b = 1.0f / a(1.0f);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f5614c = 1.0f - (f5613b * a(1.0f));

    private static float a(float f2) {
        float f3 = f2 * a;
        return f3 < 1.0f ? f3 - (1.0f - ((float) Math.exp(-f3))) : ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float fA = f5613b * a(f2);
        return fA > 0.0f ? fA + f5614c : fA;
    }
}
