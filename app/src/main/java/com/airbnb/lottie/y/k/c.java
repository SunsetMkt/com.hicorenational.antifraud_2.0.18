package com.airbnb.lottie.y.k;

/* JADX INFO: compiled from: GradientColor.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final float[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f2443b;

    public c(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.f2443b = iArr;
    }

    public int[] a() {
        return this.f2443b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.f2443b.length;
    }

    public void a(c cVar, c cVar2, float f2) {
        if (cVar.f2443b.length == cVar2.f2443b.length) {
            for (int i2 = 0; i2 < cVar.f2443b.length; i2++) {
                this.a[i2] = com.airbnb.lottie.b0.g.c(cVar.a[i2], cVar2.a[i2], f2);
                this.f2443b[i2] = com.airbnb.lottie.b0.b.a(f2, cVar.f2443b[i2], cVar2.f2443b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f2443b.length + " vs " + cVar2.f2443b.length + ")");
    }
}
