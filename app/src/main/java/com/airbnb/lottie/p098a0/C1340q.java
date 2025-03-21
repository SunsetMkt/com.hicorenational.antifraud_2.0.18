package com.airbnb.lottie.p098a0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1361a;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* renamed from: com.airbnb.lottie.a0.q */
/* loaded from: classes.dex */
class C1340q {

    /* renamed from: a */
    private static final float f3112a = 100.0f;

    /* renamed from: c */
    private static SparseArrayCompat<WeakReference<Interpolator>> f3114c;

    /* renamed from: b */
    private static final Interpolator f3113b = new LinearInterpolator();

    /* renamed from: d */
    static AbstractC1330c.a f3115d = AbstractC1330c.a.m2710a("t", C3351bh.f11580aE, "e", "o", C3351bh.f11581aF, C3351bh.f11585aJ, "to", "ti");

    /* renamed from: e */
    static AbstractC1330c.a f3116e = AbstractC1330c.a.m2710a("x", "y");

    C1340q() {
    }

    /* renamed from: a */
    private static SparseArrayCompat<WeakReference<Interpolator>> m2753a() {
        if (f3114c == null) {
            f3114c = new SparseArrayCompat<>();
        }
        return f3114c;
    }

    /* renamed from: b */
    private static <T> C1361a<T> m2759b(C1376g c1376g, AbstractC1330c abstractC1330c, float f2, InterfaceC1326k0<T> interfaceC1326k0) throws IOException {
        Interpolator interpolator;
        Interpolator m2752a;
        Interpolator interpolator2;
        T t;
        PointF pointF;
        C1361a<T> c1361a;
        PointF pointF2;
        float f3;
        PointF pointF3;
        float f4;
        abstractC1330c.mo2698d();
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
        while (abstractC1330c.mo2702h()) {
            switch (abstractC1330c.mo2694a(f3115d)) {
                case 0:
                    pointF2 = pointF4;
                    f5 = (float) abstractC1330c.mo2704j();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    t2 = interfaceC1326k0.mo2679a(abstractC1330c, f2);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    t3 = interfaceC1326k0.mo2679a(abstractC1330c, f2);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f3 = f5;
                    PointF pointF12 = pointF11;
                    if (abstractC1330c.peek() == AbstractC1330c.b.BEGIN_OBJECT) {
                        abstractC1330c.mo2698d();
                        float f6 = 0.0f;
                        float f7 = 0.0f;
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        while (abstractC1330c.mo2702h()) {
                            int mo2694a = abstractC1330c.mo2694a(f3116e);
                            if (mo2694a != 0) {
                                if (mo2694a != 1) {
                                    abstractC1330c.mo2709o();
                                } else if (abstractC1330c.peek() == AbstractC1330c.b.NUMBER) {
                                    f9 = (float) abstractC1330c.mo2704j();
                                    f7 = f9;
                                } else {
                                    abstractC1330c.mo2697c();
                                    f7 = (float) abstractC1330c.mo2704j();
                                    f9 = abstractC1330c.peek() == AbstractC1330c.b.NUMBER ? (float) abstractC1330c.mo2704j() : f7;
                                    abstractC1330c.mo2699e();
                                }
                            } else if (abstractC1330c.peek() == AbstractC1330c.b.NUMBER) {
                                f8 = (float) abstractC1330c.mo2704j();
                                f6 = f8;
                            } else {
                                abstractC1330c.mo2697c();
                                f6 = (float) abstractC1330c.mo2704j();
                                f8 = abstractC1330c.peek() == AbstractC1330c.b.NUMBER ? (float) abstractC1330c.mo2704j() : f6;
                                abstractC1330c.mo2699e();
                            }
                        }
                        PointF pointF13 = new PointF(f6, f7);
                        PointF pointF14 = new PointF(f8, f9);
                        abstractC1330c.mo2700f();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f5 = f3;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = C1339p.m2750d(abstractC1330c, f2);
                        f5 = f3;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (abstractC1330c.peek() == AbstractC1330c.b.BEGIN_OBJECT) {
                        abstractC1330c.mo2698d();
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        float f12 = 0.0f;
                        float f13 = 0.0f;
                        while (abstractC1330c.mo2702h()) {
                            PointF pointF15 = pointF11;
                            int mo2694a2 = abstractC1330c.mo2694a(f3116e);
                            if (mo2694a2 != 0) {
                                pointF3 = pointF4;
                                if (mo2694a2 != 1) {
                                    abstractC1330c.mo2709o();
                                } else if (abstractC1330c.peek() == AbstractC1330c.b.NUMBER) {
                                    f13 = (float) abstractC1330c.mo2704j();
                                    f5 = f5;
                                    f11 = f13;
                                } else {
                                    f4 = f5;
                                    abstractC1330c.mo2697c();
                                    f11 = (float) abstractC1330c.mo2704j();
                                    f13 = abstractC1330c.peek() == AbstractC1330c.b.NUMBER ? (float) abstractC1330c.mo2704j() : f11;
                                    abstractC1330c.mo2699e();
                                    f5 = f4;
                                }
                            } else {
                                pointF3 = pointF4;
                                f4 = f5;
                                if (abstractC1330c.peek() == AbstractC1330c.b.NUMBER) {
                                    f12 = (float) abstractC1330c.mo2704j();
                                    f5 = f4;
                                    f10 = f12;
                                } else {
                                    abstractC1330c.mo2697c();
                                    f10 = (float) abstractC1330c.mo2704j();
                                    f12 = abstractC1330c.peek() == AbstractC1330c.b.NUMBER ? (float) abstractC1330c.mo2704j() : f10;
                                    abstractC1330c.mo2699e();
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
                        abstractC1330c.mo2700f();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f5 = f3;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = C1339p.m2750d(abstractC1330c, f2);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (abstractC1330c.mo2705k() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF11 = C1339p.m2750d(abstractC1330c, f2);
                    break;
                case 7:
                    pointF4 = C1339p.m2750d(abstractC1330c, f2);
                    break;
                default:
                    pointF2 = pointF4;
                    abstractC1330c.mo2709o();
                    pointF4 = pointF2;
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f14 = f5;
        PointF pointF19 = pointF11;
        abstractC1330c.mo2700f();
        if (z) {
            interpolator = f3113b;
            t = t2;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = m2752a(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    Interpolator m2752a2 = m2752a(pointF7, pointF9);
                    m2752a = m2752a(pointF8, pointF10);
                    interpolator2 = m2752a2;
                    t = t3;
                    interpolator = null;
                    if (interpolator2 != null || m2752a == null) {
                        pointF = pointF19;
                        c1361a = new C1361a<>(c1376g, t2, t, interpolator, f14, null);
                    } else {
                        pointF = pointF19;
                        c1361a = new C1361a<>(c1376g, t2, t, interpolator2, m2752a, f14, null);
                    }
                    c1361a.f3169o = pointF;
                    c1361a.f3170p = pointF18;
                    return c1361a;
                }
                interpolator = f3113b;
            }
            t = t3;
        }
        interpolator2 = null;
        m2752a = null;
        if (interpolator2 != null) {
        }
        pointF = pointF19;
        c1361a = new C1361a<>(c1376g, t2, t, interpolator, f14, null);
        c1361a.f3169o = pointF;
        c1361a.f3170p = pointF18;
        return c1361a;
    }

    @Nullable
    /* renamed from: a */
    private static WeakReference<Interpolator> m2757a(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (C1340q.class) {
            weakReference = m2753a().get(i2);
        }
        return weakReference;
    }

    /* renamed from: a */
    private static void m2758a(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (C1340q.class) {
            f3114c.put(i2, weakReference);
        }
    }

    /* renamed from: a */
    static <T> C1361a<T> m2755a(AbstractC1330c abstractC1330c, C1376g c1376g, float f2, InterfaceC1326k0<T> interfaceC1326k0, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return m2759b(c1376g, abstractC1330c, f2, interfaceC1326k0);
        }
        if (z) {
            return m2756a(c1376g, abstractC1330c, f2, interfaceC1326k0);
        }
        return m2754a(abstractC1330c, f2, interfaceC1326k0);
    }

    /* renamed from: a */
    private static <T> C1361a<T> m2756a(C1376g c1376g, AbstractC1330c abstractC1330c, float f2, InterfaceC1326k0<T> interfaceC1326k0) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t;
        abstractC1330c.mo2698d();
        PointF pointF = null;
        PointF pointF2 = null;
        T t2 = null;
        T t3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f3 = 0.0f;
        while (abstractC1330c.mo2702h()) {
            switch (abstractC1330c.mo2694a(f3115d)) {
                case 0:
                    f3 = (float) abstractC1330c.mo2704j();
                    break;
                case 1:
                    t3 = interfaceC1326k0.mo2679a(abstractC1330c, f2);
                    break;
                case 2:
                    t2 = interfaceC1326k0.mo2679a(abstractC1330c, f2);
                    break;
                case 3:
                    pointF = C1339p.m2750d(abstractC1330c, 1.0f);
                    break;
                case 4:
                    pointF2 = C1339p.m2750d(abstractC1330c, 1.0f);
                    break;
                case 5:
                    if (abstractC1330c.mo2705k() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF3 = C1339p.m2750d(abstractC1330c, f2);
                    break;
                case 7:
                    pointF4 = C1339p.m2750d(abstractC1330c, f2);
                    break;
                default:
                    abstractC1330c.mo2709o();
                    break;
            }
        }
        abstractC1330c.mo2700f();
        if (z) {
            interpolator2 = f3113b;
            t = t3;
        } else {
            if (pointF != null && pointF2 != null) {
                interpolator = m2752a(pointF, pointF2);
            } else {
                interpolator = f3113b;
            }
            interpolator2 = interpolator;
            t = t2;
        }
        C1361a<T> c1361a = new C1361a<>(c1376g, t3, t, interpolator2, f3, null);
        c1361a.f3169o = pointF3;
        c1361a.f3170p = pointF4;
        return c1361a;
    }

    /* renamed from: a */
    private static Interpolator m2752a(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = C1357g.m2820a(pointF.x, -1.0f, 1.0f);
        pointF.y = C1357g.m2820a(pointF.y, -100.0f, f3112a);
        pointF2.x = C1357g.m2820a(pointF2.x, -1.0f, 1.0f);
        pointF2.y = C1357g.m2820a(pointF2.y, -100.0f, f3112a);
        int m2835a = C1358h.m2835a(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> m2757a = m2757a(m2835a);
        Interpolator interpolator = m2757a != null ? m2757a.get() : null;
        if (m2757a == null || interpolator == null) {
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
                m2758a(m2835a, (WeakReference<Interpolator>) new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    /* renamed from: a */
    private static <T> C1361a<T> m2754a(AbstractC1330c abstractC1330c, float f2, InterfaceC1326k0<T> interfaceC1326k0) throws IOException {
        return new C1361a<>(interfaceC1326k0.mo2679a(abstractC1330c, f2));
    }
}
