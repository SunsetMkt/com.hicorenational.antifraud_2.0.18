package com.airbnb.lottie.y;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: CubicCurveData.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class a {
    private final PointF a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f2399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PointF f2400c;

    public a() {
        this.a = new PointF();
        this.f2399b = new PointF();
        this.f2400c = new PointF();
    }

    public void a(float f2, float f3) {
        this.a.set(f2, f3);
    }

    public void b(float f2, float f3) {
        this.f2399b.set(f2, f3);
    }

    public void c(float f2, float f3) {
        this.f2400c.set(f2, f3);
    }

    public PointF a() {
        return this.a;
    }

    public PointF b() {
        return this.f2399b;
    }

    public PointF c() {
        return this.f2400c;
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.a = pointF;
        this.f2399b = pointF2;
        this.f2400c = pointF3;
    }
}
