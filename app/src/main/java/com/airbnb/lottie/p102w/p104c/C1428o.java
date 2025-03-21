package com.airbnb.lottie.p102w.p104c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p101c0.C1371k;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p106y.p107j.C1455l;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.Collections;

/* compiled from: TransformKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.o */
/* loaded from: classes.dex */
public class C1428o {

    /* renamed from: a */
    private final Matrix f3550a = new Matrix();

    /* renamed from: b */
    private final Matrix f3551b;

    /* renamed from: c */
    private final Matrix f3552c;

    /* renamed from: d */
    private final Matrix f3553d;

    /* renamed from: e */
    private final float[] f3554e;

    /* renamed from: f */
    @NonNull
    private AbstractC1414a<PointF, PointF> f3555f;

    /* renamed from: g */
    @NonNull
    private AbstractC1414a<?, PointF> f3556g;

    /* renamed from: h */
    @NonNull
    private AbstractC1414a<C1371k, C1371k> f3557h;

    /* renamed from: i */
    @NonNull
    private AbstractC1414a<Float, Float> f3558i;

    /* renamed from: j */
    @NonNull
    private AbstractC1414a<Integer, Integer> f3559j;

    /* renamed from: k */
    @Nullable
    private C1416c f3560k;

    /* renamed from: l */
    @Nullable
    private C1416c f3561l;

    /* renamed from: m */
    @Nullable
    private AbstractC1414a<?, Float> f3562m;

    /* renamed from: n */
    @Nullable
    private AbstractC1414a<?, Float> f3563n;

    public C1428o(C1455l c1455l) {
        this.f3555f = c1455l.m3225b() == null ? null : c1455l.m3225b().mo3220a();
        this.f3556g = c1455l.m3228e() == null ? null : c1455l.m3228e().mo3220a();
        this.f3557h = c1455l.m3230g() == null ? null : c1455l.m3230g().mo3220a();
        this.f3558i = c1455l.m3229f() == null ? null : c1455l.m3229f().mo3220a();
        this.f3560k = c1455l.m3231h() == null ? null : (C1416c) c1455l.m3231h().mo3220a();
        if (this.f3560k != null) {
            this.f3551b = new Matrix();
            this.f3552c = new Matrix();
            this.f3553d = new Matrix();
            this.f3554e = new float[9];
        } else {
            this.f3551b = null;
            this.f3552c = null;
            this.f3553d = null;
            this.f3554e = null;
        }
        this.f3561l = c1455l.m3232i() == null ? null : (C1416c) c1455l.m3232i().mo3220a();
        if (c1455l.m3227d() != null) {
            this.f3559j = c1455l.m3227d().mo3220a();
        }
        if (c1455l.m3233j() != null) {
            this.f3562m = c1455l.m3233j().mo3220a();
        } else {
            this.f3562m = null;
        }
        if (c1455l.m3226c() != null) {
            this.f3563n = c1455l.m3226c().mo3220a();
        } else {
            this.f3563n = null;
        }
    }

    /* renamed from: e */
    private void m3165e() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f3554e[i2] = 0.0f;
        }
    }

    /* renamed from: a */
    public void m3169a(AbstractC1477a abstractC1477a) {
        abstractC1477a.m3345a(this.f3559j);
        abstractC1477a.m3345a(this.f3562m);
        abstractC1477a.m3345a(this.f3563n);
        abstractC1477a.m3345a(this.f3555f);
        abstractC1477a.m3345a(this.f3556g);
        abstractC1477a.m3345a(this.f3557h);
        abstractC1477a.m3345a(this.f3558i);
        abstractC1477a.m3345a(this.f3560k);
        abstractC1477a.m3345a(this.f3561l);
    }

    /* renamed from: b */
    public void m3172b(float f2) {
        AbstractC1414a<Integer, Integer> abstractC1414a = this.f3559j;
        if (abstractC1414a != null) {
            abstractC1414a.mo3136a(f2);
        }
        AbstractC1414a<?, Float> abstractC1414a2 = this.f3562m;
        if (abstractC1414a2 != null) {
            abstractC1414a2.mo3136a(f2);
        }
        AbstractC1414a<?, Float> abstractC1414a3 = this.f3563n;
        if (abstractC1414a3 != null) {
            abstractC1414a3.mo3136a(f2);
        }
        AbstractC1414a<PointF, PointF> abstractC1414a4 = this.f3555f;
        if (abstractC1414a4 != null) {
            abstractC1414a4.mo3136a(f2);
        }
        AbstractC1414a<?, PointF> abstractC1414a5 = this.f3556g;
        if (abstractC1414a5 != null) {
            abstractC1414a5.mo3136a(f2);
        }
        AbstractC1414a<C1371k, C1371k> abstractC1414a6 = this.f3557h;
        if (abstractC1414a6 != null) {
            abstractC1414a6.mo3136a(f2);
        }
        AbstractC1414a<Float, Float> abstractC1414a7 = this.f3558i;
        if (abstractC1414a7 != null) {
            abstractC1414a7.mo3136a(f2);
        }
        C1416c c1416c = this.f3560k;
        if (c1416c != null) {
            c1416c.mo3136a(f2);
        }
        C1416c c1416c2 = this.f3561l;
        if (c1416c2 != null) {
            c1416c2.mo3136a(f2);
        }
    }

    @Nullable
    /* renamed from: c */
    public AbstractC1414a<?, Integer> m3173c() {
        return this.f3559j;
    }

    @Nullable
    /* renamed from: d */
    public AbstractC1414a<?, Float> m3174d() {
        return this.f3562m;
    }

    /* renamed from: a */
    public void m3168a(AbstractC1414a.b bVar) {
        AbstractC1414a<Integer, Integer> abstractC1414a = this.f3559j;
        if (abstractC1414a != null) {
            abstractC1414a.m3138a(bVar);
        }
        AbstractC1414a<?, Float> abstractC1414a2 = this.f3562m;
        if (abstractC1414a2 != null) {
            abstractC1414a2.m3138a(bVar);
        }
        AbstractC1414a<?, Float> abstractC1414a3 = this.f3563n;
        if (abstractC1414a3 != null) {
            abstractC1414a3.m3138a(bVar);
        }
        AbstractC1414a<PointF, PointF> abstractC1414a4 = this.f3555f;
        if (abstractC1414a4 != null) {
            abstractC1414a4.m3138a(bVar);
        }
        AbstractC1414a<?, PointF> abstractC1414a5 = this.f3556g;
        if (abstractC1414a5 != null) {
            abstractC1414a5.m3138a(bVar);
        }
        AbstractC1414a<C1371k, C1371k> abstractC1414a6 = this.f3557h;
        if (abstractC1414a6 != null) {
            abstractC1414a6.m3138a(bVar);
        }
        AbstractC1414a<Float, Float> abstractC1414a7 = this.f3558i;
        if (abstractC1414a7 != null) {
            abstractC1414a7.m3138a(bVar);
        }
        C1416c c1416c = this.f3560k;
        if (c1416c != null) {
            c1416c.m3138a(bVar);
        }
        C1416c c1416c2 = this.f3561l;
        if (c1416c2 != null) {
            c1416c2.m3138a(bVar);
        }
    }

    /* renamed from: b */
    public Matrix m3171b() {
        float m3155i;
        this.f3550a.reset();
        AbstractC1414a<?, PointF> abstractC1414a = this.f3556g;
        if (abstractC1414a != null) {
            PointF mo3143f = abstractC1414a.mo3143f();
            if (mo3143f.x != 0.0f || mo3143f.y != 0.0f) {
                this.f3550a.preTranslate(mo3143f.x, mo3143f.y);
            }
        }
        AbstractC1414a<Float, Float> abstractC1414a2 = this.f3558i;
        if (abstractC1414a2 != null) {
            if (abstractC1414a2 instanceof C1429p) {
                m3155i = abstractC1414a2.mo3143f().floatValue();
            } else {
                m3155i = ((C1416c) abstractC1414a2).m3155i();
            }
            if (m3155i != 0.0f) {
                this.f3550a.preRotate(m3155i);
            }
        }
        if (this.f3560k != null) {
            float cos = this.f3561l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.m3155i()) + 90.0f));
            float sin = this.f3561l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.m3155i()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(this.f3560k.m3155i()));
            m3165e();
            float[] fArr = this.f3554e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f3551b.setValues(fArr);
            m3165e();
            float[] fArr2 = this.f3554e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f3552c.setValues(fArr2);
            m3165e();
            float[] fArr3 = this.f3554e;
            fArr3[0] = cos;
            fArr3[1] = f2;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f3553d.setValues(fArr3);
            this.f3552c.preConcat(this.f3551b);
            this.f3553d.preConcat(this.f3552c);
            this.f3550a.preConcat(this.f3553d);
        }
        AbstractC1414a<C1371k, C1371k> abstractC1414a3 = this.f3557h;
        if (abstractC1414a3 != null) {
            C1371k mo3143f2 = abstractC1414a3.mo3143f();
            if (mo3143f2.m2872a() != 1.0f || mo3143f2.m2874b() != 1.0f) {
                this.f3550a.preScale(mo3143f2.m2872a(), mo3143f2.m2874b());
            }
        }
        AbstractC1414a<PointF, PointF> abstractC1414a4 = this.f3555f;
        if (abstractC1414a4 != null) {
            PointF mo3143f3 = abstractC1414a4.mo3143f();
            if (mo3143f3.x != 0.0f || mo3143f3.y != 0.0f) {
                this.f3550a.preTranslate(-mo3143f3.x, -mo3143f3.y);
            }
        }
        return this.f3550a;
    }

    @Nullable
    /* renamed from: a */
    public AbstractC1414a<?, Float> m3167a() {
        return this.f3563n;
    }

    /* renamed from: a */
    public Matrix m3166a(float f2) {
        AbstractC1414a<?, PointF> abstractC1414a = this.f3556g;
        PointF mo3143f = abstractC1414a == null ? null : abstractC1414a.mo3143f();
        AbstractC1414a<C1371k, C1371k> abstractC1414a2 = this.f3557h;
        C1371k mo3143f2 = abstractC1414a2 == null ? null : abstractC1414a2.mo3143f();
        this.f3550a.reset();
        if (mo3143f != null) {
            this.f3550a.preTranslate(mo3143f.x * f2, mo3143f.y * f2);
        }
        if (mo3143f2 != null) {
            double d2 = f2;
            this.f3550a.preScale((float) Math.pow(mo3143f2.m2872a(), d2), (float) Math.pow(mo3143f2.m2874b(), d2));
        }
        AbstractC1414a<Float, Float> abstractC1414a3 = this.f3558i;
        if (abstractC1414a3 != null) {
            float floatValue = abstractC1414a3.mo3143f().floatValue();
            AbstractC1414a<PointF, PointF> abstractC1414a4 = this.f3555f;
            PointF mo3143f3 = abstractC1414a4 != null ? abstractC1414a4.mo3143f() : null;
            this.f3550a.preRotate(floatValue * f2, mo3143f3 == null ? 0.0f : mo3143f3.x, mo3143f3 != null ? mo3143f3.y : 0.0f);
        }
        return this.f3550a;
    }

    /* renamed from: a */
    public <T> boolean m3170a(T t, @Nullable C1370j<T> c1370j) {
        C1416c c1416c;
        C1416c c1416c2;
        AbstractC1414a<?, Float> abstractC1414a;
        AbstractC1414a<?, Float> abstractC1414a2;
        if (t == InterfaceC1384o.f3334e) {
            AbstractC1414a<PointF, PointF> abstractC1414a3 = this.f3555f;
            if (abstractC1414a3 == null) {
                this.f3555f = new C1429p(c1370j, new PointF());
                return true;
            }
            abstractC1414a3.m3137a((C1370j<PointF>) c1370j);
            return true;
        }
        if (t == InterfaceC1384o.f3335f) {
            AbstractC1414a<?, PointF> abstractC1414a4 = this.f3556g;
            if (abstractC1414a4 == null) {
                this.f3556g = new C1429p(c1370j, new PointF());
                return true;
            }
            abstractC1414a4.m3137a((C1370j<PointF>) c1370j);
            return true;
        }
        if (t == InterfaceC1384o.f3336g) {
            AbstractC1414a<?, PointF> abstractC1414a5 = this.f3556g;
            if (abstractC1414a5 instanceof C1426m) {
                ((C1426m) abstractC1414a5).m3163b(c1370j);
                return true;
            }
        }
        if (t == InterfaceC1384o.f3337h) {
            AbstractC1414a<?, PointF> abstractC1414a6 = this.f3556g;
            if (abstractC1414a6 instanceof C1426m) {
                ((C1426m) abstractC1414a6).m3164c(c1370j);
                return true;
            }
        }
        if (t == InterfaceC1384o.f3342m) {
            AbstractC1414a<C1371k, C1371k> abstractC1414a7 = this.f3557h;
            if (abstractC1414a7 == null) {
                this.f3557h = new C1429p(c1370j, new C1371k());
                return true;
            }
            abstractC1414a7.m3137a((C1370j<C1371k>) c1370j);
            return true;
        }
        if (t == InterfaceC1384o.f3343n) {
            AbstractC1414a<Float, Float> abstractC1414a8 = this.f3558i;
            if (abstractC1414a8 == null) {
                this.f3558i = new C1429p(c1370j, Float.valueOf(0.0f));
                return true;
            }
            abstractC1414a8.m3137a((C1370j<Float>) c1370j);
            return true;
        }
        if (t == InterfaceC1384o.f3332c) {
            AbstractC1414a<Integer, Integer> abstractC1414a9 = this.f3559j;
            if (abstractC1414a9 == null) {
                this.f3559j = new C1429p(c1370j, 100);
                return true;
            }
            abstractC1414a9.m3137a((C1370j<Integer>) c1370j);
            return true;
        }
        if (t == InterfaceC1384o.f3322A && (abstractC1414a2 = this.f3562m) != null) {
            if (abstractC1414a2 == null) {
                this.f3562m = new C1429p(c1370j, 100);
                return true;
            }
            abstractC1414a2.m3137a((C1370j<Float>) c1370j);
            return true;
        }
        if (t == InterfaceC1384o.f3323B && (abstractC1414a = this.f3563n) != null) {
            if (abstractC1414a == null) {
                this.f3563n = new C1429p(c1370j, 100);
                return true;
            }
            abstractC1414a.m3137a((C1370j<Float>) c1370j);
            return true;
        }
        if (t == InterfaceC1384o.f3344o && (c1416c2 = this.f3560k) != null) {
            if (c1416c2 == null) {
                this.f3560k = new C1416c(Collections.singletonList(new C1361a(Float.valueOf(0.0f))));
            }
            this.f3560k.m3137a(c1370j);
            return true;
        }
        if (t != InterfaceC1384o.f3345p || (c1416c = this.f3561l) == null) {
            return false;
        }
        if (c1416c == null) {
            this.f3561l = new C1416c(Collections.singletonList(new C1361a(Float.valueOf(0.0f))));
        }
        this.f3561l.m3137a(c1370j);
        return true;
    }
}
