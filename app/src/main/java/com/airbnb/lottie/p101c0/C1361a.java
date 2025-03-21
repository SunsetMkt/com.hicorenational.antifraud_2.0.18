package com.airbnb.lottie.p101c0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1376g;

/* compiled from: Keyframe.java */
/* renamed from: com.airbnb.lottie.c0.a */
/* loaded from: classes.dex */
public class C1361a<T> {

    /* renamed from: q */
    private static final float f3153q = -3987645.8f;

    /* renamed from: r */
    private static final int f3154r = 784923401;

    /* renamed from: a */
    @Nullable
    private final C1376g f3155a;

    /* renamed from: b */
    @Nullable
    public final T f3156b;

    /* renamed from: c */
    @Nullable
    public T f3157c;

    /* renamed from: d */
    @Nullable
    public final Interpolator f3158d;

    /* renamed from: e */
    @Nullable
    public final Interpolator f3159e;

    /* renamed from: f */
    @Nullable
    public final Interpolator f3160f;

    /* renamed from: g */
    public final float f3161g;

    /* renamed from: h */
    @Nullable
    public Float f3162h;

    /* renamed from: i */
    private float f3163i;

    /* renamed from: j */
    private float f3164j;

    /* renamed from: k */
    private int f3165k;

    /* renamed from: l */
    private int f3166l;

    /* renamed from: m */
    private float f3167m;

    /* renamed from: n */
    private float f3168n;

    /* renamed from: o */
    public PointF f3169o;

    /* renamed from: p */
    public PointF f3170p;

    public C1361a(C1376g c1376g, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f3163i = f3153q;
        this.f3164j = f3153q;
        this.f3165k = f3154r;
        this.f3166l = f3154r;
        this.f3167m = Float.MIN_VALUE;
        this.f3168n = Float.MIN_VALUE;
        this.f3169o = null;
        this.f3170p = null;
        this.f3155a = c1376g;
        this.f3156b = t;
        this.f3157c = t2;
        this.f3158d = interpolator;
        this.f3159e = null;
        this.f3160f = null;
        this.f3161g = f2;
        this.f3162h = f3;
    }

    /* renamed from: a */
    public float m2849a() {
        if (this.f3155a == null) {
            return 1.0f;
        }
        if (this.f3168n == Float.MIN_VALUE) {
            if (this.f3162h == null) {
                this.f3168n = 1.0f;
            } else {
                this.f3168n = m2853d() + ((this.f3162h.floatValue() - this.f3161g) / this.f3155a.m2900d());
            }
        }
        return this.f3168n;
    }

    /* renamed from: b */
    public float m2851b() {
        if (this.f3164j == f3153q) {
            this.f3164j = ((Float) this.f3157c).floatValue();
        }
        return this.f3164j;
    }

    /* renamed from: c */
    public int m2852c() {
        if (this.f3166l == f3154r) {
            this.f3166l = ((Integer) this.f3157c).intValue();
        }
        return this.f3166l;
    }

    /* renamed from: d */
    public float m2853d() {
        C1376g c1376g = this.f3155a;
        if (c1376g == null) {
            return 0.0f;
        }
        if (this.f3167m == Float.MIN_VALUE) {
            this.f3167m = (this.f3161g - c1376g.m2909m()) / this.f3155a.m2900d();
        }
        return this.f3167m;
    }

    /* renamed from: e */
    public float m2854e() {
        if (this.f3163i == f3153q) {
            this.f3163i = ((Float) this.f3156b).floatValue();
        }
        return this.f3163i;
    }

    /* renamed from: f */
    public int m2855f() {
        if (this.f3165k == f3154r) {
            this.f3165k = ((Integer) this.f3156b).intValue();
        }
        return this.f3165k;
    }

    /* renamed from: g */
    public boolean m2856g() {
        return this.f3158d == null && this.f3159e == null && this.f3160f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f3156b + ", endValue=" + this.f3157c + ", startFrame=" + this.f3161g + ", endFrame=" + this.f3162h + ", interpolator=" + this.f3158d + '}';
    }

    /* renamed from: a */
    public boolean m2850a(@FloatRange(from = 0.0d, m293to = 1.0d) float f2) {
        return f2 >= m2853d() && f2 < m2849a();
    }

    public C1361a(C1376g c1376g, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, float f2, @Nullable Float f3) {
        this.f3163i = f3153q;
        this.f3164j = f3153q;
        this.f3165k = f3154r;
        this.f3166l = f3154r;
        this.f3167m = Float.MIN_VALUE;
        this.f3168n = Float.MIN_VALUE;
        this.f3169o = null;
        this.f3170p = null;
        this.f3155a = c1376g;
        this.f3156b = t;
        this.f3157c = t2;
        this.f3158d = null;
        this.f3159e = interpolator;
        this.f3160f = interpolator2;
        this.f3161g = f2;
        this.f3162h = f3;
    }

    protected C1361a(C1376g c1376g, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, @Nullable Interpolator interpolator2, @Nullable Interpolator interpolator3, float f2, @Nullable Float f3) {
        this.f3163i = f3153q;
        this.f3164j = f3153q;
        this.f3165k = f3154r;
        this.f3166l = f3154r;
        this.f3167m = Float.MIN_VALUE;
        this.f3168n = Float.MIN_VALUE;
        this.f3169o = null;
        this.f3170p = null;
        this.f3155a = c1376g;
        this.f3156b = t;
        this.f3157c = t2;
        this.f3158d = interpolator;
        this.f3159e = interpolator2;
        this.f3160f = interpolator3;
        this.f3161g = f2;
        this.f3162h = f3;
    }

    public C1361a(T t) {
        this.f3163i = f3153q;
        this.f3164j = f3153q;
        this.f3165k = f3154r;
        this.f3166l = f3154r;
        this.f3167m = Float.MIN_VALUE;
        this.f3168n = Float.MIN_VALUE;
        this.f3169o = null;
        this.f3170p = null;
        this.f3155a = null;
        this.f3156b = t;
        this.f3157c = t;
        this.f3158d = null;
        this.f3159e = null;
        this.f3160f = null;
        this.f3161g = Float.MIN_VALUE;
        this.f3162h = Float.valueOf(Float.MAX_VALUE);
    }
}
