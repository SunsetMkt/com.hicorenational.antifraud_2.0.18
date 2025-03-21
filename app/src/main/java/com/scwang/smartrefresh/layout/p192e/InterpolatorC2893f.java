package com.scwang.smartrefresh.layout.p192e;

import android.view.animation.Interpolator;

/* compiled from: ViscousFluidInterpolator.java */
/* renamed from: com.scwang.smartrefresh.layout.e.f */
/* loaded from: classes.dex */
public class InterpolatorC2893f implements Interpolator {

    /* renamed from: a */
    private static final float f9118a = 8.0f;

    /* renamed from: b */
    private static final float f9119b = 1.0f / m8751a(1.0f);

    /* renamed from: c */
    private static final float f9120c = 1.0f - (f9119b * m8751a(1.0f));

    /* renamed from: a */
    private static float m8751a(float f2) {
        float f3 = f2 * f9118a;
        return f3 < 1.0f ? f3 - (1.0f - ((float) Math.exp(-f3))) : ((1.0f - ((float) Math.exp(1.0f - f3))) * 0.63212055f) + 0.36787945f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float m8751a = f9119b * m8751a(f2);
        return m8751a > 0.0f ? m8751a + f9120c : m8751a;
    }
}
