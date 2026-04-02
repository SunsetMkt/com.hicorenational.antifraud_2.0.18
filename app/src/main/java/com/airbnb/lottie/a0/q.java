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

/* JADX INFO: compiled from: KeyframeParser.java */
/* JADX INFO: loaded from: classes.dex */
class q {
    private static final float a = 100.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SparseArrayCompat<WeakReference<Interpolator>> f2086c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Interpolator f2085b = new LinearInterpolator();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static c.a f2087d = c.a.a("t", bh.aE, "e", "o", bh.aF, bh.aJ, "to", "ti");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static c.a f2088e = c.a.a("x", "y");

    q() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> a() {
        if (f2086c == null) {
            f2086c = new SparseArrayCompat<>();
        }
        return f2086c;
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static <T> com.airbnb.lottie.c0.a<T> b(com.airbnb.lottie.g gVar, com.airbnb.lottie.a0.l0.c cVar, float f2, k0<T> k0Var) throws IOException {
        Interpolator interpolatorA;
        Interpolator interpolatorA2;
        Interpolator interpolator;
        T t;
        PointF pointF;
        com.airbnb.lottie.c0.a<T> aVar;
        PointF pointF2;
        float f3;
        PointF pointF3;
        float f4;
        cVar.d();
        PointF pointFD = null;
        boolean z = false;
        PointF pointFD2 = null;
        PointF pointFD3 = null;
        PointF pointF4 = null;
        T tA = null;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        float fJ = 0.0f;
        PointF pointFD4 = null;
        T tA2 = null;
        while (cVar.h()) {
            switch (cVar.a(f2087d)) {
                case 0:
                    pointF2 = pointFD;
                    fJ = (float) cVar.j();
                    pointFD = pointF2;
                    break;
                case 1:
                    pointF2 = pointFD;
                    tA = k0Var.a(cVar, f2);
                    pointFD = pointF2;
                    break;
                case 2:
                    pointF2 = pointFD;
                    tA2 = k0Var.a(cVar, f2);
                    pointFD = pointF2;
                    break;
                case 3:
                    pointF2 = pointFD;
                    f3 = fJ;
                    PointF pointF8 = pointFD4;
                    if (cVar.peek() != c.b.BEGIN_OBJECT) {
                        pointFD2 = p.d(cVar, f2);
                        fJ = f3;
                        pointFD4 = pointF8;
                        pointFD = pointF2;
                    } else {
                        cVar.d();
                        float fJ2 = 0.0f;
                        float fJ3 = 0.0f;
                        float fJ4 = 0.0f;
                        float fJ5 = 0.0f;
                        while (cVar.h()) {
                            int iA = cVar.a(f2088e);
                            if (iA != 0) {
                                if (iA != 1) {
                                    cVar.o();
                                } else if (cVar.peek() == c.b.NUMBER) {
                                    fJ5 = (float) cVar.j();
                                    fJ3 = fJ5;
                                } else {
                                    cVar.c();
                                    fJ3 = (float) cVar.j();
                                    fJ5 = cVar.peek() == c.b.NUMBER ? (float) cVar.j() : fJ3;
                                    cVar.e();
                                }
                            } else if (cVar.peek() == c.b.NUMBER) {
                                fJ4 = (float) cVar.j();
                                fJ2 = fJ4;
                            } else {
                                cVar.c();
                                fJ2 = (float) cVar.j();
                                fJ4 = cVar.peek() == c.b.NUMBER ? (float) cVar.j() : fJ2;
                                cVar.e();
                            }
                        }
                        PointF pointF9 = new PointF(fJ2, fJ3);
                        PointF pointF10 = new PointF(fJ4, fJ5);
                        cVar.f();
                        pointF5 = pointF10;
                        pointF4 = pointF9;
                        pointFD4 = pointF8;
                        fJ = f3;
                        pointFD = pointF2;
                    }
                    break;
                case 4:
                    if (cVar.peek() != c.b.BEGIN_OBJECT) {
                        pointF2 = pointFD;
                        pointFD3 = p.d(cVar, f2);
                        pointFD = pointF2;
                    } else {
                        cVar.d();
                        float fJ6 = 0.0f;
                        float fJ7 = 0.0f;
                        float fJ8 = 0.0f;
                        float fJ9 = 0.0f;
                        while (cVar.h()) {
                            PointF pointF11 = pointFD4;
                            int iA2 = cVar.a(f2088e);
                            if (iA2 != 0) {
                                pointF3 = pointFD;
                                if (iA2 != 1) {
                                    cVar.o();
                                } else if (cVar.peek() == c.b.NUMBER) {
                                    fJ9 = (float) cVar.j();
                                    fJ = fJ;
                                    fJ7 = fJ9;
                                } else {
                                    f4 = fJ;
                                    cVar.c();
                                    fJ7 = (float) cVar.j();
                                    fJ9 = cVar.peek() == c.b.NUMBER ? (float) cVar.j() : fJ7;
                                    cVar.e();
                                    fJ = f4;
                                }
                            } else {
                                pointF3 = pointFD;
                                f4 = fJ;
                                if (cVar.peek() == c.b.NUMBER) {
                                    fJ8 = (float) cVar.j();
                                    fJ = f4;
                                    fJ6 = fJ8;
                                } else {
                                    cVar.c();
                                    fJ6 = (float) cVar.j();
                                    fJ8 = cVar.peek() == c.b.NUMBER ? (float) cVar.j() : fJ6;
                                    cVar.e();
                                    fJ = f4;
                                }
                            }
                            pointFD4 = pointF11;
                            pointFD = pointF3;
                        }
                        pointF2 = pointFD;
                        f3 = fJ;
                        PointF pointF12 = new PointF(fJ6, fJ7);
                        PointF pointF13 = new PointF(fJ8, fJ9);
                        cVar.f();
                        pointF7 = pointF13;
                        pointF6 = pointF12;
                        fJ = f3;
                        pointFD = pointF2;
                    }
                    break;
                case 5:
                    z = cVar.k() == 1;
                    break;
                case 6:
                    pointFD4 = p.d(cVar, f2);
                    break;
                case 7:
                    pointFD = p.d(cVar, f2);
                    break;
                default:
                    pointF2 = pointFD;
                    cVar.o();
                    pointFD = pointF2;
                    break;
            }
        }
        PointF pointF14 = pointFD;
        float f5 = fJ;
        PointF pointF15 = pointFD4;
        cVar.f();
        if (z) {
            interpolatorA = f2085b;
            t = tA;
        } else {
            if (pointFD2 == null || pointFD3 == null) {
                if (pointF4 != null && pointF5 != null && pointF6 != null && pointF7 != null) {
                    Interpolator interpolatorA3 = a(pointF4, pointF6);
                    interpolatorA2 = a(pointF5, pointF7);
                    interpolator = interpolatorA3;
                    t = tA2;
                    interpolatorA = null;
                    if (interpolator != null || interpolatorA2 == null) {
                        pointF = pointF15;
                        aVar = new com.airbnb.lottie.c0.a<>(gVar, tA, t, interpolatorA, f5, null);
                    } else {
                        pointF = pointF15;
                        aVar = new com.airbnb.lottie.c0.a<>(gVar, tA, t, interpolator, interpolatorA2, f5, null);
                    }
                    aVar.o = pointF;
                    aVar.p = pointF14;
                    return aVar;
                }
                interpolatorA = f2085b;
            } else {
                interpolatorA = a(pointFD2, pointFD3);
            }
            t = tA2;
        }
        interpolator = null;
        interpolatorA2 = null;
        if (interpolator != null) {
            pointF = pointF15;
            aVar = new com.airbnb.lottie.c0.a<>(gVar, tA, t, interpolatorA, f5, null);
        }
        aVar.o = pointF;
        aVar.p = pointF14;
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
            f2086c.put(i2, weakReference);
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
        Interpolator interpolatorA;
        Interpolator interpolator;
        T t;
        cVar.d();
        PointF pointFD = null;
        PointF pointFD2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFD3 = null;
        PointF pointFD4 = null;
        boolean z = false;
        float fJ = 0.0f;
        while (cVar.h()) {
            switch (cVar.a(f2087d)) {
                case 0:
                    fJ = (float) cVar.j();
                    break;
                case 1:
                    tA2 = k0Var.a(cVar, f2);
                    break;
                case 2:
                    tA = k0Var.a(cVar, f2);
                    break;
                case 3:
                    pointFD = p.d(cVar, 1.0f);
                    break;
                case 4:
                    pointFD2 = p.d(cVar, 1.0f);
                    break;
                case 5:
                    z = cVar.k() == 1;
                    break;
                case 6:
                    pointFD3 = p.d(cVar, f2);
                    break;
                case 7:
                    pointFD4 = p.d(cVar, f2);
                    break;
                default:
                    cVar.o();
                    break;
            }
        }
        cVar.f();
        if (z) {
            interpolator = f2085b;
            t = tA2;
        } else {
            if (pointFD != null && pointFD2 != null) {
                interpolatorA = a(pointFD, pointFD2);
            } else {
                interpolatorA = f2085b;
            }
            interpolator = interpolatorA;
            t = tA;
        }
        com.airbnb.lottie.c0.a<T> aVar = new com.airbnb.lottie.c0.a<>(gVar, tA2, t, interpolator, fJ, null);
        aVar.o = pointFD3;
        aVar.p = pointFD4;
        return aVar;
    }

    private static Interpolator a(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.airbnb.lottie.b0.g.a(pointF.x, -1.0f, 1.0f);
        pointF.y = com.airbnb.lottie.b0.g.a(pointF.y, -100.0f, a);
        pointF2.x = com.airbnb.lottie.b0.g.a(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.airbnb.lottie.b0.g.a(pointF2.y, -100.0f, a);
        int iA = com.airbnb.lottie.b0.h.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceA = a(iA);
        Interpolator interpolator = weakReferenceA != null ? weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
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
                a(iA, (WeakReference<Interpolator>) new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    private static <T> com.airbnb.lottie.c0.a<T> a(com.airbnb.lottie.a0.l0.c cVar, float f2, k0<T> k0Var) throws IOException {
        return new com.airbnb.lottie.c0.a<>(k0Var.a(cVar, f2));
    }
}
