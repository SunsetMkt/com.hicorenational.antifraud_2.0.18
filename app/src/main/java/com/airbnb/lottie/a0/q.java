package com.airbnb.lottie.a0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* loaded from: classes.dex */
class q {

    /* renamed from: a, reason: collision with root package name */
    private static final float f3408a = 100.0f;

    /* renamed from: c, reason: collision with root package name */
    private static SparseArrayCompat<WeakReference<Interpolator>> f3410c;

    /* renamed from: b, reason: collision with root package name */
    private static final Interpolator f3409b = new LinearInterpolator();

    /* renamed from: d, reason: collision with root package name */
    static c.a f3411d = c.a.a("t", bh.aE, "e", "o", bh.aF, bh.aJ, "to", "ti");

    /* renamed from: e, reason: collision with root package name */
    static c.a f3412e = c.a.a("x", "y");

    q() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> a() {
        if (f3410c == null) {
            f3410c = new SparseArrayCompat<>();
        }
        return f3410c;
    }

    private static <T> com.airbnb.lottie.c0.a<T> b(com.airbnb.lottie.g gVar, com.airbnb.lottie.a0.l0.c cVar, float f2, k0<T> k0Var) throws IOException {
        Interpolator interpolator;
        Interpolator a2;
        Interpolator interpolator2;
        T t;
        PointF pointF;
        com.airbnb.lottie.c0.a<T> aVar;
        PointF pointF2;
        float f3;
        PointF pointF3;
        float f4;
        cVar.d();
        PointF pointF4 = null;
        boolean z = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t2 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f5 = 0.0f;
        PointF pointF11 = null;
        T t3 = null;
        while (cVar.h()) {
            switch (cVar.a(f3411d)) {
                case 0:
                    pointF2 = pointF4;
                    f5 = (float) cVar.j();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    t2 = k0Var.a(cVar, f2);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    t3 = k0Var.a(cVar, f2);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f3 = f5;
                    PointF pointF12 = pointF11;
                    if (cVar.peek() == c.b.BEGIN_OBJECT) {
                        cVar.d();
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        while (cVar.h()) {
                            int a3 = cVar.a(f3412e);
                            if (a3 != 0) {
                                if (a3 != 1) {
                                    cVar.o();
                                } else if (cVar.peek() == c.b.NUMBER) {
                                    f9 = (float) cVar.j();
                                    f7 = f9;
                                } else {
                                    cVar.c();
                                    f7 = (float) cVar.j();
                                    f9 = cVar.peek() == c.b.NUMBER ? (float) cVar.j() : f7;
                                    cVar.e();
                                }
                            } else if (cVar.peek() == c.b.NUMBER) {
                                f8 = (float) cVar.j();
                                f6 = f8;
                            } else {
                                cVar.c();
                                f6 = (float) cVar.j();
                                f8 = cVar.peek() == c.b.NUMBER ? (float) cVar.j() : f6;
                                cVar.e();
                            }
                        }
                        PointF pointF13 = new PointF(f6, f7);
                        PointF pointF14 = new PointF(f8, f9);
                        cVar.f();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f5 = f3;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = p.d(cVar, f2);
                        f5 = f3;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (cVar.peek() == c.b.BEGIN_OBJECT) {
                        cVar.d();
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        float f13 = 0.0f;
                        while (cVar.h()) {
                            PointF pointF15 = pointF11;
                            int a4 = cVar.a(f3412e);
                            if (a4 != 0) {
                                pointF3 = pointF4;
                                if (a4 != 1) {
                                    cVar.o();
                                } else if (cVar.peek() == c.b.NUMBER) {
                                    f13 = (float) cVar.j();
                                    f5 = f5;
                                    f11 = f13;
                                } else {
                                    f4 = f5;
                                    cVar.c();
                                    f11 = (float) cVar.j();
                                    f13 = cVar.peek() == c.b.NUMBER ? (float) cVar.j() : f11;
                                    cVar.e();
                                    f5 = f4;
                                }
                            } else {
                                pointF3 = pointF4;
                                f4 = f5;
                                if (cVar.peek() == c.b.NUMBER) {
                                    f12 = (float) cVar.j();
                                    f5 = f4;
                                    f10 = f12;
                                } else {
                                    cVar.c();
                                    f10 = (float) cVar.j();
                                    f12 = cVar.peek() == c.b.NUMBER ? (float) cVar.j() : f10;
                                    cVar.e();
                                    f5 = f4;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f3 = f5;
                        PointF pointF16 = new PointF(f10, f11);
                        PointF pointF17 = new PointF(f12, f13);
                        cVar.f();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f5 = f3;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = p.d(cVar, f2);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (cVar.k() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF11 = p.d(cVar, f2);
                    break;
                case 7:
                    pointF4 = p.d(cVar, f2);
                    break;
                default:
                    pointF2 = pointF4;
                    cVar.o();
                    pointF4 = pointF2;
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f14 = f5;
        PointF pointF19 = pointF11;
        cVar.f();
        if (z) {
            interpolator = f3409b;
            t = t2;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = a(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    Interpolator a5 = a(pointF7, pointF9);
                    a2 = a(pointF8, pointF10);
                    interpolator2 = a5;
                    t = t3;
                    interpolator = null;
                    if (interpolator2 != null || a2 == null) {
                        pointF = pointF19;
                        aVar = new com.airbnb.lottie.c0.a<>(gVar, t2, t, interpolator, f14, null);
                    } else {
                        pointF = pointF19;
                        aVar = new com.airbnb.lottie.c0.a<>(gVar, t2, t, interpolator2, a2, f14, null);
                    }
                    aVar.o = pointF;
                    aVar.p = pointF18;
                    return aVar;
                }
                interpolator = f3409b;
            }
            t = t3;
        }
        interpolator2 = null;
        a2 = null;
        if (interpolator2 != null) {
        }
        pointF = pointF19;
        aVar = new com.airbnb.lottie.c0.a<>(gVar, t2, t, interpolator, f14, null);
        aVar.o = pointF;
        aVar.p = pointF18;
        return aVar;
    }

    @Nullable
    private static WeakReference<Interpolator> a(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (q.class) {
            weakReference = a().get(i2);
        }
        return weakReference;
    }

    private static void a(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (q.class) {
            f3410c.put(i2, weakReference);
        }
    }

    static <T> com.airbnb.lottie.c0.a<T> a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, float f2, k0<T> k0Var, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return b(gVar, cVar, f2, k0Var);
        }
        if (z) {
            return a(gVar, cVar, f2, k0Var);
        }
        return a(cVar, f2, k0Var);
    }

    private static <T> com.airbnb.lottie.c0.a<T> a(com.airbnb.lottie.g gVar, com.airbnb.lottie.a0.l0.c cVar, float f2, k0<T> k0Var) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t;
        cVar.d();
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f3 = 0.0f;
        while (cVar.h()) {
            switch (cVar.a(f3411d)) {
                case 0:
                    f3 = (float) cVar.j();
                    break;
                case 1:
                    t3 = k0Var.a(cVar, f2);
                    break;
                case 2:
                    t2 = k0Var.a(cVar, f2);
                    break;
                case 3:
                    pointF = p.d(cVar, 1.0f);
                    break;
                case 4:
                    pointF2 = p.d(cVar, 1.0f);
                    break;
                case 5:
                    if (cVar.k() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF3 = p.d(cVar, f2);
                    break;
                case 7:
                    pointF4 = p.d(cVar, f2);
                    break;
                default:
                    cVar.o();
                    break;
            }
        }
        cVar.f();
        if (z) {
            interpolator2 = f3409b;
            t = t3;
        } else {
            if (pointF != null && pointF2 != null) {
                interpolator = a(pointF, pointF2);
            } else {
                interpolator = f3409b;
            }
            interpolator2 = interpolator;
            t = t2;
        }
        com.airbnb.lottie.c0.a<T> aVar = new com.airbnb.lottie.c0.a<>(gVar, t3, t, interpolator2, f3, null);
        aVar.o = pointF3;
        aVar.p = pointF4;
        return aVar;
    }

    private static Interpolator a(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.airbnb.lottie.b0.g.a(pointF.x, -1.0f, 1.0f);
        pointF.y = com.airbnb.lottie.b0.g.a(pointF.y, -100.0f, f3408a);
        pointF2.x = com.airbnb.lottie.b0.g.a(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.airbnb.lottie.b0.g.a(pointF2.y, -100.0f, f3408a);
        int a2 = com.airbnb.lottie.b0.h.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> a3 = a(a2);
        Interpolator interpolator = a3 != null ? a3.get() : null;
        if (a3 == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e2) {
                if ("The Path cannot loop back on itself.".equals(e2.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                a(a2, (WeakReference<Interpolator>) new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    private static <T> com.airbnb.lottie.c0.a<T> a(com.airbnb.lottie.a0.l0.c cVar, float f2, k0<T> k0Var) throws IOException {
        return new com.airbnb.lottie.c0.a<>(k0Var.a(cVar, f2));
    }
}
