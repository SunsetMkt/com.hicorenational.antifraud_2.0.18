package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BaseStrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.j f2248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final com.airbnb.lottie.y.l.a f2249f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f2251h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f2253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Integer> f2254k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<com.airbnb.lottie.w.c.a<?, Float>> f2255l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.w.c.a<?, Float> f2256m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> f2257n;
    private final PathMeasure a = new PathMeasure();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f2245b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f2246c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RectF f2247d = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<b> f2250g = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Paint f2252i = new com.airbnb.lottie.w.a(1);

    /* JADX INFO: compiled from: BaseStrokeContent.java */
    private static final class b {
        private final List<n> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final t f2258b;

        private b(@Nullable t tVar) {
            this.a = new ArrayList();
            this.f2258b = tVar;
        }
    }

    a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.airbnb.lottie.y.j.d dVar, com.airbnb.lottie.y.j.b bVar, List<com.airbnb.lottie.y.j.b> list, com.airbnb.lottie.y.j.b bVar2) {
        this.f2248e = jVar;
        this.f2249f = aVar;
        this.f2252i.setStyle(Paint.Style.STROKE);
        this.f2252i.setStrokeCap(cap);
        this.f2252i.setStrokeJoin(join);
        this.f2252i.setStrokeMiter(f2);
        this.f2254k = dVar.a();
        this.f2253j = bVar.a();
        if (bVar2 == null) {
            this.f2256m = null;
        } else {
            this.f2256m = bVar2.a();
        }
        this.f2255l = new ArrayList(list.size());
        this.f2251h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f2255l.add(list.get(i2).a());
        }
        aVar.a(this.f2254k);
        aVar.a(this.f2253j);
        for (int i3 = 0; i3 < this.f2255l.size(); i3++) {
            aVar.a(this.f2255l.get(i3));
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar2 = this.f2256m;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.f2254k.a(this);
        this.f2253j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f2255l.get(i4).a(this);
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar3 = this.f2256m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f2248e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    @Override // com.airbnb.lottie.w.b.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(List<c> list, List<c> list2) {
        t tVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof t) {
                t tVar2 = (t) cVar;
                if (tVar2.e() == q.a.INDIVIDUALLY) {
                    tVar = tVar2;
                }
            }
        }
        if (tVar != null) {
            tVar.a(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof t) {
                t tVar3 = (t) cVar2;
                if (tVar3.e() == q.a.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f2250g.add(bVar);
                    }
                    bVar = new b(tVar3);
                    tVar3.a(this);
                } else if (cVar2 instanceof n) {
                    if (bVar == null) {
                        bVar = new b(tVar);
                    }
                    bVar.a.add((n) cVar2);
                }
            }
        }
        if (bVar != null) {
            this.f2250g.add(bVar);
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.e.a("StrokeContent#draw");
        if (com.airbnb.lottie.b0.h.b(matrix)) {
            com.airbnb.lottie.e.b("StrokeContent#draw");
            return;
        }
        this.f2252i.setAlpha(com.airbnb.lottie.b0.g.a((int) ((((i2 / 255.0f) * ((com.airbnb.lottie.w.c.e) this.f2254k).i()) / 100.0f) * 255.0f), 0, 255));
        this.f2252i.setStrokeWidth(((com.airbnb.lottie.w.c.c) this.f2253j).i() * com.airbnb.lottie.b0.h.a(matrix));
        if (this.f2252i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.e.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.f2257n;
        if (aVar != null) {
            this.f2252i.setColorFilter(aVar.f());
        }
        for (int i3 = 0; i3 < this.f2250g.size(); i3++) {
            b bVar = this.f2250g.get(i3);
            if (bVar.f2258b != null) {
                a(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.e.a("StrokeContent#buildPath");
                this.f2245b.reset();
                for (int size = bVar.a.size() - 1; size >= 0; size--) {
                    this.f2245b.addPath(((n) bVar.a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.e.b("StrokeContent#buildPath");
                com.airbnb.lottie.e.a("StrokeContent#drawPath");
                canvas.drawPath(this.f2245b, this.f2252i);
                com.airbnb.lottie.e.b("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.e.b("StrokeContent#draw");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Canvas canvas, b bVar, Matrix matrix) {
        com.airbnb.lottie.e.a("StrokeContent#applyTrimPath");
        if (bVar.f2258b == null) {
            com.airbnb.lottie.e.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f2245b.reset();
        for (int size = bVar.a.size() - 1; size >= 0; size--) {
            this.f2245b.addPath(((n) bVar.a.get(size)).getPath(), matrix);
        }
        this.a.setPath(this.f2245b, false);
        float length = this.a.getLength();
        while (this.a.nextContour()) {
            length += this.a.getLength();
        }
        float fFloatValue = (bVar.f2258b.c().f().floatValue() * length) / 360.0f;
        float fFloatValue2 = ((bVar.f2258b.d().f().floatValue() * length) / 100.0f) + fFloatValue;
        float fFloatValue3 = ((bVar.f2258b.b().f().floatValue() * length) / 100.0f) + fFloatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.a.size() - 1; size2 >= 0; size2--) {
            this.f2246c.set(((n) bVar.a.get(size2)).getPath());
            this.f2246c.transform(matrix);
            this.a.setPath(this.f2246c, false);
            float length2 = this.a.getLength();
            if (fFloatValue3 > length) {
                float f3 = fFloatValue3 - length;
                if (f3 >= f2 + length2 || f2 >= f3) {
                    float f4 = f2 + length2;
                    if (f4 >= fFloatValue2 && f2 <= fFloatValue3) {
                        if (f4 <= fFloatValue3 && fFloatValue2 < f2) {
                            canvas.drawPath(this.f2246c, this.f2252i);
                        } else {
                            com.airbnb.lottie.b0.h.a(this.f2246c, fFloatValue2 < f2 ? 0.0f : (fFloatValue2 - f2) / length2, fFloatValue3 <= f4 ? (fFloatValue3 - f2) / length2 : 1.0f, 0.0f);
                            canvas.drawPath(this.f2246c, this.f2252i);
                        }
                    }
                } else {
                    com.airbnb.lottie.b0.h.a(this.f2246c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f2246c, this.f2252i);
                }
            }
            f2 += length2;
        }
        com.airbnb.lottie.e.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        com.airbnb.lottie.e.a("StrokeContent#getBounds");
        this.f2245b.reset();
        for (int i2 = 0; i2 < this.f2250g.size(); i2++) {
            b bVar = this.f2250g.get(i2);
            for (int i3 = 0; i3 < bVar.a.size(); i3++) {
                this.f2245b.addPath(((n) bVar.a.get(i3)).getPath(), matrix);
            }
        }
        this.f2245b.computeBounds(this.f2247d, false);
        float fI = ((com.airbnb.lottie.w.c.c) this.f2253j).i();
        RectF rectF2 = this.f2247d;
        float f2 = fI / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f2247d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.e.b("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.e.a("StrokeContent#applyDashPattern");
        if (this.f2255l.isEmpty()) {
            com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
            return;
        }
        float fA = com.airbnb.lottie.b0.h.a(matrix);
        for (int i2 = 0; i2 < this.f2255l.size(); i2++) {
            this.f2251h[i2] = this.f2255l.get(i2).f().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f2251h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f2251h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f2251h;
            fArr3[i2] = fArr3[i2] * fA;
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar = this.f2256m;
        this.f2252i.setPathEffect(new DashPathEffect(this.f2251h, aVar == null ? 0.0f : fA * aVar.f().floatValue()));
        com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (t == com.airbnb.lottie.o.f2223d) {
            this.f2254k.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.q) {
            this.f2253j.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.E) {
            com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.f2257n;
            if (aVar != null) {
                this.f2249f.b(aVar);
            }
            if (jVar == null) {
                this.f2257n = null;
                return;
            }
            this.f2257n = new com.airbnb.lottie.w.c.p(jVar);
            this.f2257n.a(this);
            this.f2249f.a(this.f2257n);
        }
    }
}
