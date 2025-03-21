package com.airbnb.lottie.p100b0;

/* compiled from: GammaEvaluator.java */
/* renamed from: com.airbnb.lottie.b0.b */
/* loaded from: classes.dex */
public class C1352b {
    /* renamed from: a */
    private static float m2780a(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    /* renamed from: b */
    private static float m2782b(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow(f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    /* renamed from: a */
    public static int m2781a(float f2, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        float f3 = ((i2 >> 24) & 255) / 255.0f;
        float m2780a = m2780a(((i2 >> 16) & 255) / 255.0f);
        float m2780a2 = m2780a(((i2 >> 8) & 255) / 255.0f);
        float m2780a3 = m2780a((i2 & 255) / 255.0f);
        float m2780a4 = m2780a(((i3 >> 16) & 255) / 255.0f);
        float f4 = f3 + (((((i3 >> 24) & 255) / 255.0f) - f3) * f2);
        float m2780a5 = m2780a2 + ((m2780a(((i3 >> 8) & 255) / 255.0f) - m2780a2) * f2);
        float m2780a6 = m2780a3 + (f2 * (m2780a((i3 & 255) / 255.0f) - m2780a3));
        return (Math.round(m2782b(m2780a + ((m2780a4 - m2780a) * f2)) * 255.0f) << 16) | (Math.round(f4 * 255.0f) << 24) | (Math.round(m2782b(m2780a5) * 255.0f) << 8) | Math.round(m2782b(m2780a6) * 255.0f);
    }
}
