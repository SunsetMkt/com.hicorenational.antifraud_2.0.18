package com.airbnb.lottie.p106y.p108k;

import com.airbnb.lottie.p100b0.C1352b;
import com.airbnb.lottie.p100b0.C1357g;

/* compiled from: GradientColor.java */
/* renamed from: com.airbnb.lottie.y.k.c */
/* loaded from: classes.dex */
public class C1461c {

    /* renamed from: a */
    private final float[] f3636a;

    /* renamed from: b */
    private final int[] f3637b;

    public C1461c(float[] fArr, int[] iArr) {
        this.f3636a = fArr;
        this.f3637b = iArr;
    }

    /* renamed from: a */
    public int[] m3240a() {
        return this.f3637b;
    }

    /* renamed from: b */
    public float[] m3241b() {
        return this.f3636a;
    }

    /* renamed from: c */
    public int m3242c() {
        return this.f3637b.length;
    }

    /* renamed from: a */
    public void m3239a(C1461c c1461c, C1461c c1461c2, float f2) {
        if (c1461c.f3637b.length == c1461c2.f3637b.length) {
            for (int i2 = 0; i2 < c1461c.f3637b.length; i2++) {
                this.f3636a[i2] = C1357g.m2831c(c1461c.f3636a[i2], c1461c2.f3636a[i2], f2);
                this.f3637b[i2] = C1352b.m2781a(f2, c1461c.f3637b[i2], c1461c2.f3637b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + c1461c.f3637b.length + " vs " + c1461c2.f3637b.length + ")");
    }
}
