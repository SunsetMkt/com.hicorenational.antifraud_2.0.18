package com.airbnb.lottie.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.i;
import com.airbnb.lottie.y.k.q;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class o implements n, a.b, k {
    private static final float o = 0.47829f;
    private static final float p = 0.25f;

    /* renamed from: b, reason: collision with root package name */
    private final String f3697b;

    /* renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.j f3698c;

    /* renamed from: d, reason: collision with root package name */
    private final i.a f3699d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f3700e;

    /* renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3701f;

    /* renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f3702g;

    /* renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3703h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.w.c.a<?, Float> f3704i;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3705j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.w.c.a<?, Float> f3706k;

    /* renamed from: l, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3707l;
    private boolean n;

    /* renamed from: a, reason: collision with root package name */
    private final Path f3696a = new Path();

    /* renamed from: m, reason: collision with root package name */
    private b f3708m = new b();

    /* compiled from: PolystarContent.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3709a = new int[i.a.values().length];

        static {
            try {
                f3709a[i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3709a[i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public o(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.i iVar) {
        this.f3698c = jVar;
        this.f3697b = iVar.c();
        this.f3699d = iVar.i();
        this.f3700e = iVar.j();
        this.f3701f = iVar.f().a();
        this.f3702g = iVar.g().a();
        this.f3703h = iVar.h().a();
        this.f3705j = iVar.d().a();
        this.f3707l = iVar.e().a();
        if (this.f3699d == i.a.STAR) {
            this.f3704i = iVar.a().a();
            this.f3706k = iVar.b().a();
        } else {
            this.f3704i = null;
            this.f3706k = null;
        }
        aVar.a(this.f3701f);
        aVar.a(this.f3702g);
        aVar.a(this.f3703h);
        aVar.a(this.f3705j);
        aVar.a(this.f3707l);
        if (this.f3699d == i.a.STAR) {
            aVar.a(this.f3704i);
            aVar.a(this.f3706k);
        }
        this.f3701f.a(this);
        this.f3702g.a(this);
        this.f3703h.a(this);
        this.f3705j.a(this);
        this.f3707l.a(this);
        if (this.f3699d == i.a.STAR) {
            this.f3704i.a(this);
            this.f3706k.a(this);
        }
    }

    private void b() {
        double d2;
        double d3;
        double d4;
        int i2;
        int floor = (int) Math.floor(this.f3701f.f().floatValue());
        double radians = Math.toRadians((this.f3703h == null ? 0.0d : r2.f().floatValue()) - 90.0d);
        double d5 = floor;
        float floatValue = this.f3707l.f().floatValue() / 100.0f;
        float floatValue2 = this.f3705j.f().floatValue();
        double d6 = floatValue2;
        float cos = (float) (Math.cos(radians) * d6);
        float sin = (float) (Math.sin(radians) * d6);
        this.f3696a.moveTo(cos, sin);
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
                float f2 = floatValue2 * floatValue * p;
                this.f3696a.cubicTo(cos - (cos3 * f2), sin - (sin3 * f2), cos2 + (cos4 * f2), sin2 + (f2 * sin4), cos2, sin2);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i2 = i3;
                this.f3696a.lineTo(cos2, sin2);
            }
            d8 = d2 + d4;
            i3 = i2 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF f3 = this.f3702g.f();
        this.f3696a.offset(f3.x, f3.y);
        this.f3696a.close();
    }

    private void c() {
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
        float floatValue = this.f3701f.f().floatValue();
        double radians = Math.toRadians((this.f3703h == null ? 0.0d : r2.f().floatValue()) - 90.0d);
        double d4 = floatValue;
        float f14 = (float) (6.283185307179586d / d4);
        float f15 = f14 / 2.0f;
        float f16 = floatValue - ((int) floatValue);
        int i3 = (f16 > 0.0f ? 1 : (f16 == 0.0f ? 0 : -1));
        if (i3 != 0) {
            radians += (1.0f - f16) * f15;
        }
        float floatValue2 = this.f3705j.f().floatValue();
        float floatValue3 = this.f3704i.f().floatValue();
        com.airbnb.lottie.w.c.a<?, Float> aVar = this.f3706k;
        float floatValue4 = aVar != null ? aVar.f().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.w.c.a<?, Float> aVar2 = this.f3707l;
        float floatValue5 = aVar2 != null ? aVar2.f().floatValue() / 100.0f : 0.0f;
        if (i3 != 0) {
            f4 = ((floatValue2 - floatValue3) * f16) + floatValue3;
            i2 = i3;
            double d5 = f4;
            d2 = d4;
            f2 = (float) (d5 * Math.cos(radians));
            f3 = (float) (d5 * Math.sin(radians));
            this.f3696a.moveTo(f2, f3);
            d3 = radians + ((f14 * f16) / 2.0f);
        } else {
            d2 = d4;
            i2 = i3;
            double d6 = floatValue2;
            float cos = (float) (Math.cos(radians) * d6);
            float sin = (float) (d6 * Math.sin(radians));
            this.f3696a.moveTo(cos, sin);
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
                PointF f18 = this.f3702g.f();
                this.f3696a.offset(f18.x, f18.y);
                this.f3696a.close();
                return;
            }
            float f19 = z ? floatValue2 : floatValue3;
            if (f4 == 0.0f || d8 != ceil - 2.0d) {
                f5 = f17;
            } else {
                f5 = f17;
                f17 = (f14 * f16) / 2.0f;
            }
            if (f4 == 0.0f || d8 != ceil - 1.0d) {
                f6 = f14;
                f7 = floatValue3;
                f8 = f19;
                f9 = floatValue2;
            } else {
                f6 = f14;
                f9 = floatValue2;
                f7 = floatValue3;
                f8 = f4;
            }
            double d9 = f8;
            float f20 = f17;
            float cos2 = (float) (d9 * Math.cos(d7));
            float sin2 = (float) (d9 * Math.sin(d7));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.f3696a.lineTo(cos2, sin2);
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
                float f21 = f2;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f22 = z ? f10 : f11;
                float f23 = z ? f11 : f10;
                float f24 = z ? f7 : f9;
                float f25 = z ? f9 : f7;
                float f26 = f24 * f22 * o;
                float f27 = cos3 * f26;
                float f28 = f26 * sin3;
                float f29 = f25 * f23 * o;
                float f30 = cos4 * f29;
                float f31 = f29 * sin4;
                if (i2 != 0) {
                    if (i4 == 0) {
                        f27 *= f16;
                        f28 *= f16;
                    } else if (d8 == ceil - 1.0d) {
                        f30 *= f16;
                        f31 *= f16;
                    }
                }
                this.f3696a.cubicTo(f21 - f27, f3 - f28, cos2 + f30, f13 + f31, cos2, f13);
            }
            d7 += f20;
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

    private void d() {
        this.n = false;
        this.f3698c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        d();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f3697b;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        if (this.n) {
            return this.f3696a;
        }
        this.f3696a.reset();
        if (this.f3700e) {
            this.n = true;
            return this.f3696a;
        }
        int i2 = a.f3709a[this.f3699d.ordinal()];
        if (i2 == 1) {
            c();
        } else if (i2 == 2) {
            b();
        }
        this.f3696a.close();
        this.f3708m.a(this.f3696a);
        this.n = true;
        return this.f3696a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.e() == q.a.SIMULTANEOUSLY) {
                    this.f3708m.a(tVar);
                    tVar.a(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        com.airbnb.lottie.w.c.a<?, Float> aVar;
        com.airbnb.lottie.w.c.a<?, Float> aVar2;
        if (t == com.airbnb.lottie.o.u) {
            this.f3701f.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.v) {
            this.f3703h.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.f3609l) {
            this.f3702g.a((com.airbnb.lottie.c0.j<PointF>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.w && (aVar2 = this.f3704i) != null) {
            aVar2.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.x) {
            this.f3705j.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.y && (aVar = this.f3706k) != null) {
            aVar.a((com.airbnb.lottie.c0.j<Float>) jVar);
        } else if (t == com.airbnb.lottie.o.z) {
            this.f3707l.a((com.airbnb.lottie.c0.j<Float>) jVar);
        }
    }
}
