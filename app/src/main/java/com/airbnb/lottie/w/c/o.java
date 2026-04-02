package com.airbnb.lottie.w.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.Collections;

/* JADX INFO: compiled from: TransformKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    private final Matrix a = new Matrix();

    /* JADX INFO: renamed from: b */
    private final Matrix f2375b;

    /* JADX INFO: renamed from: c */
    private final Matrix f2376c;

    /* JADX INFO: renamed from: d */
    private final Matrix f2377d;

    /* JADX INFO: renamed from: e */
    private final float[] f2378e;

    /* JADX INFO: renamed from: f */
    @NonNull
    private a<PointF, PointF> f2379f;

    /* JADX INFO: renamed from: g */
    @NonNull
    private a<?, PointF> f2380g;

    /* JADX INFO: renamed from: h */
    @NonNull
    private a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> f2381h;

    /* JADX INFO: renamed from: i */
    @NonNull
    private a<Float, Float> f2382i;

    /* JADX INFO: renamed from: j */
    @NonNull
    private a<Integer, Integer> f2383j;

    /* JADX INFO: renamed from: k */
    @Nullable
    private c f2384k;

    /* JADX INFO: renamed from: l */
    @Nullable
    private c f2385l;

    /* JADX INFO: renamed from: m */
    @Nullable
    private a<?, Float> f2386m;

    /* JADX INFO: renamed from: n */
    @Nullable
    private a<?, Float> f2387n;

    public o(com.airbnb.lottie.y.j.l lVar) {
        this.f2379f = lVar.b() == null ? null : lVar.b().a();
        this.f2380g = lVar.e() == null ? null : lVar.e().a();
        this.f2381h = lVar.g() == null ? null : lVar.g().a();
        this.f2382i = lVar.f() == null ? null : lVar.f().a();
        this.f2384k = lVar.h() == null ? null : (c) lVar.h().a();
        if (this.f2384k != null) {
            this.f2375b = new Matrix();
            this.f2376c = new Matrix();
            this.f2377d = new Matrix();
            this.f2378e = new float[9];
        } else {
            this.f2375b = null;
            this.f2376c = null;
            this.f2377d = null;
            this.f2378e = null;
        }
        this.f2385l = lVar.i() == null ? null : (c) lVar.i().a();
        if (lVar.d() != null) {
            this.f2383j = lVar.d().a();
        }
        if (lVar.j() != null) {
            this.f2386m = lVar.j().a();
        } else {
            this.f2386m = null;
        }
        if (lVar.c() != null) {
            this.f2387n = lVar.c().a();
        } else {
            this.f2387n = null;
        }
    }

    private void e() {
        for (int i2 = 0; i2 < 9; i2++) {
            this.f2378e[i2] = 0.0f;
        }
    }

    public void a(com.airbnb.lottie.y.l.a aVar) {
        aVar.a(this.f2383j);
        aVar.a(this.f2386m);
        aVar.a(this.f2387n);
        aVar.a(this.f2379f);
        aVar.a(this.f2380g);
        aVar.a(this.f2381h);
        aVar.a(this.f2382i);
        aVar.a(this.f2384k);
        aVar.a(this.f2385l);
    }

    public void b(float f2) {
        a<Integer, Integer> aVar = this.f2383j;
        if (aVar != null) {
            aVar.a(f2);
        }
        a<?, Float> aVar2 = this.f2386m;
        if (aVar2 != null) {
            aVar2.a(f2);
        }
        a<?, Float> aVar3 = this.f2387n;
        if (aVar3 != null) {
            aVar3.a(f2);
        }
        a<PointF, PointF> aVar4 = this.f2379f;
        if (aVar4 != null) {
            aVar4.a(f2);
        }
        a<?, PointF> aVar5 = this.f2380g;
        if (aVar5 != null) {
            aVar5.a(f2);
        }
        a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar6 = this.f2381h;
        if (aVar6 != null) {
            aVar6.a(f2);
        }
        a<Float, Float> aVar7 = this.f2382i;
        if (aVar7 != null) {
            aVar7.a(f2);
        }
        c cVar = this.f2384k;
        if (cVar != null) {
            cVar.a(f2);
        }
        c cVar2 = this.f2385l;
        if (cVar2 != null) {
            cVar2.a(f2);
        }
    }

    @Nullable
    public a<?, Integer> c() {
        return this.f2383j;
    }

    @Nullable
    public a<?, Float> d() {
        return this.f2386m;
    }

    public void a(a.b bVar) {
        a<Integer, Integer> aVar = this.f2383j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.f2386m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.f2387n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f2379f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f2380g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar6 = this.f2381h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f2382i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        c cVar = this.f2384k;
        if (cVar != null) {
            cVar.a(bVar);
        }
        c cVar2 = this.f2385l;
        if (cVar2 != null) {
            cVar2.a(bVar);
        }
    }

    public Matrix b() {
        float fI;
        this.a.reset();
        a<?, PointF> aVar = this.f2380g;
        if (aVar != null) {
            PointF pointFF = aVar.f();
            if (pointFF.x != 0.0f || pointFF.y != 0.0f) {
                this.a.preTranslate(pointFF.x, pointFF.y);
            }
        }
        a<Float, Float> aVar2 = this.f2382i;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                fI = aVar2.f().floatValue();
            } else {
                fI = ((c) aVar2).i();
            }
            if (fI != 0.0f) {
                this.a.preRotate(fI);
            }
        }
        if (this.f2384k != null) {
            float fCos = this.f2385l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r0.i()) + 90.0f));
            float fSin = this.f2385l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r4.i()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f2384k.i()));
            e();
            float[] fArr = this.f2378e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f2375b.setValues(fArr);
            e();
            float[] fArr2 = this.f2378e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f2376c.setValues(fArr2);
            e();
            float[] fArr3 = this.f2378e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f2377d.setValues(fArr3);
            this.f2376c.preConcat(this.f2375b);
            this.f2377d.preConcat(this.f2376c);
            this.a.preConcat(this.f2377d);
        }
        a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar3 = this.f2381h;
        if (aVar3 != null) {
            com.airbnb.lottie.c0.k kVarF = aVar3.f();
            if (kVarF.a() != 1.0f || kVarF.b() != 1.0f) {
                this.a.preScale(kVarF.a(), kVarF.b());
            }
        }
        a<PointF, PointF> aVar4 = this.f2379f;
        if (aVar4 != null) {
            PointF pointFF2 = aVar4.f();
            if (pointFF2.x != 0.0f || pointFF2.y != 0.0f) {
                this.a.preTranslate(-pointFF2.x, -pointFF2.y);
            }
        }
        return this.a;
    }

    @Nullable
    public a<?, Float> a() {
        return this.f2387n;
    }

    public Matrix a(float f2) {
        a<?, PointF> aVar = this.f2380g;
        PointF pointFF = aVar == null ? null : aVar.f();
        a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar2 = this.f2381h;
        com.airbnb.lottie.c0.k kVarF = aVar2 == null ? null : aVar2.f();
        this.a.reset();
        if (pointFF != null) {
            this.a.preTranslate(pointFF.x * f2, pointFF.y * f2);
        }
        if (kVarF != null) {
            double d2 = f2;
            this.a.preScale((float) Math.pow(kVarF.a(), d2), (float) Math.pow(kVarF.b(), d2));
        }
        a<Float, Float> aVar3 = this.f2382i;
        if (aVar3 != null) {
            float fFloatValue = aVar3.f().floatValue();
            a<PointF, PointF> aVar4 = this.f2379f;
            PointF pointFF2 = aVar4 != null ? aVar4.f() : null;
            this.a.preRotate(fFloatValue * f2, pointFF2 == null ? 0.0f : pointFF2.x, pointFF2 != null ? pointFF2.y : 0.0f);
        }
        return this.a;
    }

    public <T> boolean a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        c cVar;
        c cVar2;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == com.airbnb.lottie.o.f2224e) {
            a<PointF, PointF> aVar3 = this.f2379f;
            if (aVar3 == null) {
                this.f2379f = new p(jVar, new PointF());
                return true;
            }
            aVar3.a((com.airbnb.lottie.c0.j<PointF>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.f2225f) {
            a<?, PointF> aVar4 = this.f2380g;
            if (aVar4 == null) {
                this.f2380g = new p(jVar, new PointF());
                return true;
            }
            aVar4.a((com.airbnb.lottie.c0.j<PointF>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.f2226g) {
            a<?, PointF> aVar5 = this.f2380g;
            if (aVar5 instanceof m) {
                ((m) aVar5).b(jVar);
                return true;
            }
        }
        if (t == com.airbnb.lottie.o.f2227h) {
            a<?, PointF> aVar6 = this.f2380g;
            if (aVar6 instanceof m) {
                ((m) aVar6).c(jVar);
                return true;
            }
        }
        if (t == com.airbnb.lottie.o.f2232m) {
            a<com.airbnb.lottie.c0.k, com.airbnb.lottie.c0.k> aVar7 = this.f2381h;
            if (aVar7 == null) {
                this.f2381h = new p(jVar, new com.airbnb.lottie.c0.k());
                return true;
            }
            aVar7.a((com.airbnb.lottie.c0.j<com.airbnb.lottie.c0.k>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.f2233n) {
            a<Float, Float> aVar8 = this.f2382i;
            if (aVar8 == null) {
                this.f2382i = new p(jVar, Float.valueOf(0.0f));
                return true;
            }
            aVar8.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.f2222c) {
            a<Integer, Integer> aVar9 = this.f2383j;
            if (aVar9 == null) {
                this.f2383j = new p(jVar, 100);
                return true;
            }
            aVar9.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.A && (aVar2 = this.f2386m) != null) {
            if (aVar2 == null) {
                this.f2386m = new p(jVar, 100);
                return true;
            }
            aVar2.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.B && (aVar = this.f2387n) != null) {
            if (aVar == null) {
                this.f2387n = new p(jVar, 100);
                return true;
            }
            aVar.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return true;
        }
        if (t == com.airbnb.lottie.o.o && (cVar2 = this.f2384k) != null) {
            if (cVar2 == null) {
                this.f2384k = new c(Collections.singletonList(new com.airbnb.lottie.c0.a(Float.valueOf(0.0f))));
            }
            this.f2384k.a(jVar);
            return true;
        }
        if (t != com.airbnb.lottie.o.p || (cVar = this.f2385l) == null) {
            return false;
        }
        if (cVar == null) {
            this.f2385l = new c(Collections.singletonList(new com.airbnb.lottie.c0.a(Float.valueOf(0.0f))));
        }
        this.f2385l.a(jVar);
        return true;
    }
}
