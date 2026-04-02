package com.airbnb.lottie.c0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: Keyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> {
    private static final float q = -3987645.8f;
    private static final int r = 784923401;

    @Nullable
    private final com.airbnb.lottie.g a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final T f2111b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public T f2112c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final Interpolator f2113d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final Interpolator f2114e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final Interpolator f2115f;

    /* JADX INFO: renamed from: g */
    public final float f2116g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public Float f2117h;

    /* JADX INFO: renamed from: i */
    private float f2118i;

    /* JADX INFO: renamed from: j */
    private float f2119j;

    /* JADX INFO: renamed from: k */
    private int f2120k;

    /* JADX INFO: renamed from: l */
    private int f2121l;

    /* JADX INFO: renamed from: m */
    private float f2122m;

    /* JADX INFO: renamed from: n */
    private float f2123n;
    public PointF o;
    public PointF p;

    public a(com.airbnb.lottie.g gVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f2118i = q;
        this.f2119j = q;
        this.f2120k = r;
        this.f2121l = r;
        this.f2122m = Float.MIN_VALUE;
        this.f2123n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = gVar;
        this.f2111b = t;
        this.f2112c = t2;
        this.f2113d = interpolator;
        this.f2114e = null;
        this.f2115f = null;
        this.f2116g = f2;
        this.f2117h = f3;
    }

    public float a() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.f2123n == Float.MIN_VALUE) {
            if (this.f2117h == null) {
                this.f2123n = 1.0f;
            } else {
                this.f2123n = d() + ((this.f2117h.floatValue() - this.f2116g) / this.a.d());
            }
        }
        return this.f2123n;
    }

    public float b() {
        if (this.f2119j == q) {
            this.f2119j = ((Float) this.f2112c).floatValue();
        }
        return this.f2119j;
    }

    public int c() {
        if (this.f2121l == r) {
            this.f2121l = ((Integer) this.f2112c).intValue();
        }
        return this.f2121l;
    }

    public float d() {
        com.airbnb.lottie.g gVar = this.a;
        if (gVar == null) {
            return 0.0f;
        }
        if (this.f2122m == Float.MIN_VALUE) {
            this.f2122m = (this.f2116g - gVar.m()) / this.a.d();
        }
        return this.f2122m;
    }

    public float e() {
        if (this.f2118i == q) {
            this.f2118i = ((Float) this.f2111b).floatValue();
        }
        return this.f2118i;
    }

    public int f() {
        if (this.f2120k == r) {
            this.f2120k = ((Integer) this.f2111b).intValue();
        }
        return this.f2120k;
    }

    public boolean g() {
        return this.f2113d == null && this.f2114e == null && this.f2115f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f2111b + ", endValue=" + this.f2112c + ", startFrame=" + this.f2116g + ", endFrame=" + this.f2117h + ", interpolator=" + this.f2113d + '}';
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= d() && f2 < a();
    }

    public a(com.airbnb.lottie.g gVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f2, @Nullable Float f3) {
        this.f2118i = q;
        this.f2119j = q;
        this.f2120k = r;
        this.f2121l = r;
        this.f2122m = Float.MIN_VALUE;
        this.f2123n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = gVar;
        this.f2111b = t;
        this.f2112c = t2;
        this.f2113d = null;
        this.f2114e = interpolator;
        this.f2115f = interpolator2;
        this.f2116g = f2;
        this.f2117h = f3;
    }

    protected a(com.airbnb.lottie.g gVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f2, @Nullable Float f3) {
        this.f2118i = q;
        this.f2119j = q;
        this.f2120k = r;
        this.f2121l = r;
        this.f2122m = Float.MIN_VALUE;
        this.f2123n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = gVar;
        this.f2111b = t;
        this.f2112c = t2;
        this.f2113d = interpolator;
        this.f2114e = interpolator2;
        this.f2115f = interpolator3;
        this.f2116g = f2;
        this.f2117h = f3;
    }

    public a(T t) {
        this.f2118i = q;
        this.f2119j = q;
        this.f2120k = r;
        this.f2121l = r;
        this.f2122m = Float.MIN_VALUE;
        this.f2123n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.a = null;
        this.f2111b = t;
        this.f2112c = t;
        this.f2113d = null;
        this.f2114e = null;
        this.f2115f = null;
        this.f2116g = Float.MIN_VALUE;
        this.f2117h = Float.valueOf(Float.MAX_VALUE);
    }
}
