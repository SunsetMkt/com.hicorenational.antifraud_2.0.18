package com.airbnb.lottie.p102w.p103b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.InterfaceC1384o;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p106y.C1439e;
import com.airbnb.lottie.p106y.p108k.C1467i;
import com.airbnb.lottie.p106y.p108k.C1475q;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.List;

/* compiled from: PolystarContent.java */
/* renamed from: com.airbnb.lottie.w.b.o */
/* loaded from: classes.dex */
public class C1407o implements InterfaceC1406n, AbstractC1414a.b, InterfaceC1403k {

    /* renamed from: o */
    private static final float f3460o = 0.47829f;

    /* renamed from: p */
    private static final float f3461p = 0.25f;

    /* renamed from: b */
    private final String f3463b;

    /* renamed from: c */
    private final C1379j f3464c;

    /* renamed from: d */
    private final C1467i.a f3465d;

    /* renamed from: e */
    private final boolean f3466e;

    /* renamed from: f */
    private final AbstractC1414a<?, Float> f3467f;

    /* renamed from: g */
    private final AbstractC1414a<?, PointF> f3468g;

    /* renamed from: h */
    private final AbstractC1414a<?, Float> f3469h;

    /* renamed from: i */
    @Nullable
    private final AbstractC1414a<?, Float> f3470i;

    /* renamed from: j */
    private final AbstractC1414a<?, Float> f3471j;

    /* renamed from: k */
    @Nullable
    private final AbstractC1414a<?, Float> f3472k;

    /* renamed from: l */
    private final AbstractC1414a<?, Float> f3473l;

    /* renamed from: n */
    private boolean f3475n;

    /* renamed from: a */
    private final Path f3462a = new Path();

    /* renamed from: m */
    private C1394b f3474m = new C1394b();

    /* compiled from: PolystarContent.java */
    /* renamed from: com.airbnb.lottie.w.b.o$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f3476a = new int[C1467i.a.values().length];

        static {
            try {
                f3476a[C1467i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3476a[C1467i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C1407o(C1379j c1379j, AbstractC1477a abstractC1477a, C1467i c1467i) {
        this.f3464c = c1379j;
        this.f3463b = c1467i.m3275c();
        this.f3465d = c1467i.m3281i();
        this.f3466e = c1467i.m3282j();
        this.f3467f = c1467i.m3278f().mo3220a();
        this.f3468g = c1467i.m3279g().mo3220a();
        this.f3469h = c1467i.m3280h().mo3220a();
        this.f3471j = c1467i.m3276d().mo3220a();
        this.f3473l = c1467i.m3277e().mo3220a();
        if (this.f3465d == C1467i.a.STAR) {
            this.f3470i = c1467i.m3273a().mo3220a();
            this.f3472k = c1467i.m3274b().mo3220a();
        } else {
            this.f3470i = null;
            this.f3472k = null;
        }
        abstractC1477a.m3345a(this.f3467f);
        abstractC1477a.m3345a(this.f3468g);
        abstractC1477a.m3345a(this.f3469h);
        abstractC1477a.m3345a(this.f3471j);
        abstractC1477a.m3345a(this.f3473l);
        if (this.f3465d == C1467i.a.STAR) {
            abstractC1477a.m3345a(this.f3470i);
            abstractC1477a.m3345a(this.f3472k);
        }
        this.f3467f.m3138a(this);
        this.f3468g.m3138a(this);
        this.f3469h.m3138a(this);
        this.f3471j.m3138a(this);
        this.f3473l.m3138a(this);
        if (this.f3465d == C1467i.a.STAR) {
            this.f3470i.m3138a(this);
            this.f3472k.m3138a(this);
        }
    }

    /* renamed from: b */
    private void m3120b() {
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor(this.f3467f.mo3143f().floatValue());
        double radians = Math.toRadians((this.f3469h == null ? 0.0d : r2.mo3143f().floatValue()) - 90.0d);
        double d5 = floor;
        float floatValue = this.f3473l.mo3143f().floatValue() / 100.0f;
        float floatValue2 = this.f3471j.mo3143f().floatValue();
        double d6 = floatValue2;
        float cos = (float) (Math.cos(radians) * d6);
        float sin = (float) (Math.sin(radians) * d6);
        this.f3462a.moveTo(cos, sin);
        double d7 = (float) (6.283185307179586d / d5);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i3 = 0;
        while (i3 < ceil) {
            float cos2 = (float) (Math.cos(d8) * d6);
            double d9 = ceil;
            float sin2 = (float) (d6 * Math.sin(d8));
            if (floatValue != 0.0f) {
                d3 = d6;
                i2 = i3;
                d2 = d8;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d4 = d7;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f2 = floatValue2 * floatValue * f3461p;
                this.f3462a.cubicTo(cos - (cos3 * f2), sin - (sin3 * f2), cos2 + (cos4 * f2), sin2 + (f2 * sin4), cos2, sin2);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i2 = i3;
                this.f3462a.lineTo(cos2, sin2);
            }
            d8 = d2 + d4;
            i3 = i2 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF mo3143f = this.f3468g.mo3143f();
        this.f3462a.offset(mo3143f.x, mo3143f.y);
        this.f3462a.close();
    }

    /* renamed from: c */
    private void m3121c() {
        double d2;
        int i2;
        double d3;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float floatValue = this.f3467f.mo3143f().floatValue();
        double radians = Math.toRadians((this.f3469h == null ? 0.0d : r2.mo3143f().floatValue()) - 90.0d);
        double d4 = floatValue;
        float f14 = (float) (6.283185307179586d / d4);
        float f15 = f14 / 2.0f;
        float f16 = floatValue - ((int) floatValue);
        int i3 = (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f16) * f15;
        }
        float floatValue2 = this.f3471j.mo3143f().floatValue();
        float floatValue3 = this.f3470i.mo3143f().floatValue();
        AbstractC1414a<?, Float> abstractC1414a = this.f3472k;
        float floatValue4 = abstractC1414a != null ? abstractC1414a.mo3143f().floatValue() / 100.0f : 0.0f;
        AbstractC1414a<?, Float> abstractC1414a2 = this.f3473l;
        float floatValue5 = abstractC1414a2 != null ? abstractC1414a2.mo3143f().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f4 = ((floatValue2 - floatValue3) * f16) + floatValue3;
            i2 = i3;
            double d5 = f4;
            d2 = d4;
            f2 = (float) (d5 * Math.cos(radians));
            f3 = (float) (d5 * Math.sin(radians));
            this.f3462a.moveTo(f2, f3);
            d3 = radians + ((f14 * f16) / 2.0f);
        } else {
            d2 = d4;
            i2 = i3;
            double d6 = floatValue2;
            float cos = (float) (Math.cos(radians) * d6);
            float sin = (float) (d6 * Math.sin(radians));
            this.f3462a.moveTo(cos, sin);
            d3 = radians + f15;
            f2 = cos;
            f3 = sin;
            f4 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        boolean z = false;
        double d7 = d3;
        float f17 = f15;
        int i4 = 0;
        while (true) {
            double d8 = i4;
            if (d8 >= ceil) {
                PointF mo3143f = this.f3468g.mo3143f();
                this.f3462a.offset(mo3143f.x, mo3143f.y);
                this.f3462a.close();
                return;
            }
            float f18 = z ? floatValue2 : floatValue3;
            if (f4 == 0.0f || d8 != ceil - 2.0d) {
                f5 = f17;
            } else {
                f5 = f17;
                f17 = (f14 * f16) / 2.0f;
            }
            if (f4 == 0.0f || d8 != ceil - 1.0d) {
                f6 = f14;
                f7 = floatValue3;
                f8 = f18;
                f9 = floatValue2;
            } else {
                f6 = f14;
                f9 = floatValue2;
                f7 = floatValue3;
                f8 = f4;
            }
            double d9 = f8;
            float f19 = f17;
            float cos2 = (float) (d9 * Math.cos(d7));
            float sin2 = (float) (d9 * Math.sin(d7));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.f3462a.lineTo(cos2, sin2);
                f13 = sin2;
                f10 = floatValue4;
                f11 = floatValue5;
                f12 = f4;
            } else {
                f10 = floatValue4;
                f11 = floatValue5;
                double atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                f12 = f4;
                f13 = sin2;
                float f20 = f2;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f21 = z ? f10 : f11;
                float f22 = z ? f11 : f10;
                float f23 = z ? f7 : f9;
                float f24 = z ? f9 : f7;
                float f25 = f23 * f21 * f3460o;
                float f26 = cos3 * f25;
                float f27 = f25 * sin3;
                float f28 = f24 * f22 * f3460o;
                float f29 = cos4 * f28;
                float f30 = f28 * sin4;
                if (i2 != 0) {
                    if (i4 == 0) {
                        f26 *= f16;
                        f27 *= f16;
                    } else if (d8 == ceil - 1.0d) {
                        f29 *= f16;
                        f30 *= f16;
                    }
                }
                this.f3462a.cubicTo(f20 - f26, f3 - f27, cos2 + f29, f13 + f30, cos2, f13);
            }
            d7 += f19;
            z = !z;
            i4++;
            f2 = cos2;
            f4 = f12;
            floatValue2 = f9;
            f14 = f6;
            f17 = f5;
            floatValue3 = f7;
            floatValue4 = f10;
            floatValue5 = f11;
            f3 = f13;
        }
    }

    /* renamed from: d */
    private void m3122d() {
        this.f3475n = false;
        this.f3464c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        m3122d();
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3463b;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1406n
    public Path getPath() {
        if (this.f3475n) {
            return this.f3462a;
        }
        this.f3462a.reset();
        if (this.f3466e) {
            this.f3475n = true;
            return this.f3462a;
        }
        int i2 = a.f3476a[this.f3465d.ordinal()];
        if (i2 == 1) {
            m3121c();
        } else if (i2 == 2) {
            m3120b();
        }
        this.f3462a.close();
        this.f3474m.m3101a(this.f3462a);
        this.f3475n = true;
        return this.f3462a;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            InterfaceC1395c interfaceC1395c = list.get(i2);
            if (interfaceC1395c instanceof C1412t) {
                C1412t c1412t = (C1412t) interfaceC1395c;
                if (c1412t.m3129e() == C1475q.a.SIMULTANEOUSLY) {
                    this.f3474m.m3102a(c1412t);
                    c1412t.m3125a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public void mo3096a(C1439e c1439e, int i2, List<C1439e> list, C1439e c1439e2) {
        C1357g.m2826a(c1439e, i2, list, c1439e2, this);
    }

    @Override // com.airbnb.lottie.p106y.InterfaceC1440f
    /* renamed from: a */
    public <T> void mo3097a(T t, @Nullable C1370j<T> c1370j) {
        AbstractC1414a<?, Float> abstractC1414a;
        AbstractC1414a<?, Float> abstractC1414a2;
        if (t == InterfaceC1384o.f3350u) {
            this.f3467f.m3137a((C1370j<Float>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3351v) {
            this.f3469h.m3137a((C1370j<Float>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3341l) {
            this.f3468g.m3137a((C1370j<PointF>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3352w && (abstractC1414a2 = this.f3470i) != null) {
            abstractC1414a2.m3137a((C1370j<Float>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3353x) {
            this.f3471j.m3137a((C1370j<Float>) c1370j);
            return;
        }
        if (t == InterfaceC1384o.f3354y && (abstractC1414a = this.f3472k) != null) {
            abstractC1414a.m3137a((C1370j<Float>) c1370j);
        } else if (t == InterfaceC1384o.f3355z) {
            this.f3473l.m3137a((C1370j<Float>) c1370j);
        }
    }
}
