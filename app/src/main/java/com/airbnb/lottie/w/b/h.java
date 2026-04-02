package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GradientFillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements e, a.b, k {
    private static final int s = 32;

    @NonNull
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f2286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.l.a f2287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f2288d = new LongSparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f2289e = new LongSparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f2290f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f2291g = new com.airbnb.lottie.w.a(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f2292h = new RectF();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<n> f2293i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.y.k.f f2294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<com.airbnb.lottie.y.k.c, com.airbnb.lottie.y.k.c> f2295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Integer, Integer> f2296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<PointF, PointF> f2297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<PointF, PointF> f2298n;

    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> o;

    @Nullable
    private com.airbnb.lottie.w.c.p p;
    private final com.airbnb.lottie.j q;
    private final int r;

    public h(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.d dVar) {
        this.f2287c = aVar;
        this.a = dVar.g();
        this.f2286b = dVar.j();
        this.q = jVar;
        this.f2294j = dVar.d();
        this.f2290f.setFillType(dVar.b());
        this.r = (int) (jVar.f().c() / 32.0f);
        this.f2295k = dVar.c().a();
        this.f2295k.a(this);
        aVar.a(this.f2295k);
        this.f2296l = dVar.h().a();
        this.f2296l.a(this);
        aVar.a(this.f2296l);
        this.f2297m = dVar.i().a();
        this.f2297m.a(this);
        aVar.a(this.f2297m);
        this.f2298n = dVar.a().a();
        this.f2298n.a(this);
        aVar.a(this.f2298n);
    }

    private int b() {
        int iRound = Math.round(this.f2297m.e() * this.r);
        int iRound2 = Math.round(this.f2298n.e() * this.r);
        int iRound3 = Math.round(this.f2295k.e() * this.r);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }

    private LinearGradient c() {
        long jB = b();
        LinearGradient linearGradient = this.f2288d.get(jB);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFF = this.f2297m.f();
        PointF pointFF2 = this.f2298n.f();
        com.airbnb.lottie.y.k.c cVarF = this.f2295k.f();
        LinearGradient linearGradient2 = new LinearGradient(pointFF.x, pointFF.y, pointFF2.x, pointFF2.y, a(cVarF.a()), cVarF.b(), Shader.TileMode.CLAMP);
        this.f2288d.put(jB, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient d() {
        long jB = b();
        RadialGradient radialGradient = this.f2289e.get(jB);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFF = this.f2297m.f();
        PointF pointFF2 = this.f2298n.f();
        com.airbnb.lottie.y.k.c cVarF = this.f2295k.f();
        int[] iArrA = a(cVarF.a());
        float[] fArrB = cVarF.b();
        float f2 = pointFF.x;
        float f3 = pointFF.y;
        float fHypot = (float) Math.hypot(pointFF2.x - f2, pointFF2.y - f3);
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, fHypot <= 0.0f ? 0.001f : fHypot, iArrA, fArrB, Shader.TileMode.CLAMP);
        this.f2289e.put(jB, radialGradient2);
        return radialGradient2;
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof n) {
                this.f2293i.add((n) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        Shader shaderD;
        if (this.f2286b) {
            return;
        }
        com.airbnb.lottie.e.a("GradientFillContent#draw");
        this.f2290f.reset();
        for (int i3 = 0; i3 < this.f2293i.size(); i3++) {
            this.f2290f.addPath(this.f2293i.get(i3).getPath(), matrix);
        }
        this.f2290f.computeBounds(this.f2292h, false);
        if (this.f2294j == com.airbnb.lottie.y.k.f.LINEAR) {
            shaderD = c();
        } else {
            shaderD = d();
        }
        shaderD.setLocalMatrix(matrix);
        this.f2291g.setShader(shaderD);
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.f2291g.setColorFilter(aVar.f());
        }
        this.f2291g.setAlpha(com.airbnb.lottie.b0.g.a((int) ((((i2 / 255.0f) * this.f2296l.f().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f2290f, this.f2291g);
        com.airbnb.lottie.e.b("GradientFillContent#draw");
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f2290f.reset();
        for (int i2 = 0; i2 < this.f2293i.size(); i2++) {
            this.f2290f.addPath(this.f2293i.get(i2).getPath(), matrix);
        }
        this.f2290f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private int[] a(int[] iArr) {
        com.airbnb.lottie.w.c.p pVar = this.p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.f();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (t == com.airbnb.lottie.o.f2223d) {
            this.f2296l.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.E) {
            com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.o;
            if (aVar != null) {
                this.f2287c.b(aVar);
            }
            if (jVar == null) {
                this.o = null;
                return;
            }
            this.o = new com.airbnb.lottie.w.c.p(jVar);
            this.o.a(this);
            this.f2287c.a(this.o);
            return;
        }
        if (t == com.airbnb.lottie.o.F) {
            com.airbnb.lottie.w.c.p pVar = this.p;
            if (pVar != null) {
                this.f2287c.b(pVar);
            }
            if (jVar == null) {
                this.p = null;
                return;
            }
            this.f2288d.clear();
            this.f2289e.clear();
            this.p = new com.airbnb.lottie.w.c.p(jVar);
            this.p.a(this);
            this.f2287c.a(this.p);
        }
    }
}
