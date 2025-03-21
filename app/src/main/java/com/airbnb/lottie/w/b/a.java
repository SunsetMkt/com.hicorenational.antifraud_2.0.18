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

/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.j f3634e;

    /* renamed from: f, reason: collision with root package name */
    protected final com.airbnb.lottie.y.l.a f3635f;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f3637h;

    /* renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f3639j;

    /* renamed from: k, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Integer> f3640k;

    /* renamed from: l, reason: collision with root package name */
    private final List<com.airbnb.lottie.w.c.a<?, Float>> f3641l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private final com.airbnb.lottie.w.c.a<?, Float> f3642m;

    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> n;

    /* renamed from: a, reason: collision with root package name */
    private final PathMeasure f3630a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    private final Path f3631b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f3632c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f3633d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final List<b> f3636g = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    final Paint f3638i = new com.airbnb.lottie.w.a(1);

    /* compiled from: BaseStrokeContent.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final List<n> f3643a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final t f3644b;

        private b(@Nullable t tVar) {
            this.f3643a = new ArrayList();
            this.f3644b = tVar;
        }
    }

    a(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, Paint.Cap cap, Paint.Join join, float f2, com.airbnb.lottie.y.j.d dVar, com.airbnb.lottie.y.j.b bVar, List<com.airbnb.lottie.y.j.b> list, com.airbnb.lottie.y.j.b bVar2) {
        this.f3634e = jVar;
        this.f3635f = aVar;
        this.f3638i.setStyle(Paint.Style.STROKE);
        this.f3638i.setStrokeCap(cap);
        this.f3638i.setStrokeJoin(join);
        this.f3638i.setStrokeMiter(f2);
        this.f3640k = dVar.a();
        this.f3639j = bVar.a();
        if (bVar2 == null) {
            this.f3642m = null;
        } else {
            this.f3642m = bVar2.a();
        }
        this.f3641l = new ArrayList(list.size());
        this.f3637h = new float[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f3641l.add(list.get(i2).a());
        }
        aVar.a(this.f3640k);
        aVar.a(this.f3639j);
        for (int i3 = 0; i3 < this.f3641l.size(); i3++) {
            aVar.a(this.f3641l.get(i3));
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar2 = this.f3642m;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        this.f3640k.a(this);
        this.f3639j.a(this);
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f3641l.get(i4).a(this);
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar3 = this.f3642m;
        if (aVar3 != null) {
            aVar3.a(this);
        }
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f3634e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.b.c
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
                        this.f3636g.add(bVar);
                    }
                    bVar = new b(tVar3);
                    tVar3.a(this);
                }
            }
            if (cVar2 instanceof n) {
                if (bVar == null) {
                    bVar = new b(tVar);
                }
                bVar.f3643a.add((n) cVar2);
            }
        }
        if (bVar != null) {
            this.f3636g.add(bVar);
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        com.airbnb.lottie.e.a("StrokeContent#draw");
        if (com.airbnb.lottie.b0.h.b(matrix)) {
            com.airbnb.lottie.e.b("StrokeContent#draw");
            return;
        }
        this.f3638i.setAlpha(com.airbnb.lottie.b0.g.a((int) ((((i2 / 255.0f) * ((com.airbnb.lottie.w.c.e) this.f3640k).i()) / 100.0f) * 255.0f), 0, 255));
        this.f3638i.setStrokeWidth(((com.airbnb.lottie.w.c.c) this.f3639j).i() * com.airbnb.lottie.b0.h.a(matrix));
        if (this.f3638i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.e.b("StrokeContent#draw");
            return;
        }
        a(matrix);
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.n;
        if (aVar != null) {
            this.f3638i.setColorFilter(aVar.f());
        }
        for (int i3 = 0; i3 < this.f3636g.size(); i3++) {
            b bVar = this.f3636g.get(i3);
            if (bVar.f3644b != null) {
                a(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.e.a("StrokeContent#buildPath");
                this.f3631b.reset();
                for (int size = bVar.f3643a.size() - 1; size >= 0; size--) {
                    this.f3631b.addPath(((n) bVar.f3643a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.e.b("StrokeContent#buildPath");
                com.airbnb.lottie.e.a("StrokeContent#drawPath");
                canvas.drawPath(this.f3631b, this.f3638i);
                com.airbnb.lottie.e.b("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.e.b("StrokeContent#draw");
    }

    private void a(Canvas canvas, b bVar, Matrix matrix) {
        com.airbnb.lottie.e.a("StrokeContent#applyTrimPath");
        if (bVar.f3644b == null) {
            com.airbnb.lottie.e.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f3631b.reset();
        for (int size = bVar.f3643a.size() - 1; size >= 0; size--) {
            this.f3631b.addPath(((n) bVar.f3643a.get(size)).getPath(), matrix);
        }
        this.f3630a.setPath(this.f3631b, false);
        float length = this.f3630a.getLength();
        while (this.f3630a.nextContour()) {
            length += this.f3630a.getLength();
        }
        float floatValue = (bVar.f3644b.c().f().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f3644b.d().f().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f3644b.b().f().floatValue() * length) / 100.0f) + floatValue;
        float f2 = 0.0f;
        for (int size2 = bVar.f3643a.size() - 1; size2 >= 0; size2--) {
            this.f3632c.set(((n) bVar.f3643a.get(size2)).getPath());
            this.f3632c.transform(matrix);
            this.f3630a.setPath(this.f3632c, false);
            float length2 = this.f3630a.getLength();
            if (floatValue3 > length) {
                float f3 = floatValue3 - length;
                if (f3 < f2 + length2 && f2 < f3) {
                    com.airbnb.lottie.b0.h.a(this.f3632c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f3 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f3632c, this.f3638i);
                    f2 += length2;
                }
            }
            float f4 = f2 + length2;
            if (f4 >= floatValue2 && f2 <= floatValue3) {
                if (f4 <= floatValue3 && floatValue2 < f2) {
                    canvas.drawPath(this.f3632c, this.f3638i);
                } else {
                    com.airbnb.lottie.b0.h.a(this.f3632c, floatValue2 < f2 ? 0.0f : (floatValue2 - f2) / length2, floatValue3 <= f4 ? (floatValue3 - f2) / length2 : 1.0f, 0.0f);
                    canvas.drawPath(this.f3632c, this.f3638i);
                }
            }
            f2 += length2;
        }
        com.airbnb.lottie.e.b("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        com.airbnb.lottie.e.a("StrokeContent#getBounds");
        this.f3631b.reset();
        for (int i2 = 0; i2 < this.f3636g.size(); i2++) {
            b bVar = this.f3636g.get(i2);
            for (int i3 = 0; i3 < bVar.f3643a.size(); i3++) {
                this.f3631b.addPath(((n) bVar.f3643a.get(i3)).getPath(), matrix);
            }
        }
        this.f3631b.computeBounds(this.f3633d, false);
        float i4 = ((com.airbnb.lottie.w.c.c) this.f3639j).i();
        RectF rectF2 = this.f3633d;
        float f2 = i4 / 2.0f;
        rectF2.set(rectF2.left - f2, rectF2.top - f2, rectF2.right + f2, rectF2.bottom + f2);
        rectF.set(this.f3633d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.e.b("StrokeContent#getBounds");
    }

    private void a(Matrix matrix) {
        com.airbnb.lottie.e.a("StrokeContent#applyDashPattern");
        if (this.f3641l.isEmpty()) {
            com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
            return;
        }
        float a2 = com.airbnb.lottie.b0.h.a(matrix);
        for (int i2 = 0; i2 < this.f3641l.size(); i2++) {
            this.f3637h[i2] = this.f3641l.get(i2).f().floatValue();
            if (i2 % 2 == 0) {
                float[] fArr = this.f3637h;
                if (fArr[i2] < 1.0f) {
                    fArr[i2] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f3637h;
                if (fArr2[i2] < 0.1f) {
                    fArr2[i2] = 0.1f;
                }
            }
            float[] fArr3 = this.f3637h;
            fArr3[i2] = fArr3[i2] * a2;
        }
        com.airbnb.lottie.w.c.a<?, Float> aVar = this.f3642m;
        this.f3638i.setPathEffect(new DashPathEffect(this.f3637h, aVar == null ? 0.0f : a2 * aVar.f().floatValue()));
        com.airbnb.lottie.e.b("StrokeContent#applyDashPattern");
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    @CallSuper
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (t == com.airbnb.lottie.o.f3601d) {
            this.f3640k.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.q) {
            this.f3639j.a((com.airbnb.lottie.c0.j<Float>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.E) {
            com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.n;
            if (aVar != null) {
                this.f3635f.b(aVar);
            }
            if (jVar == null) {
                this.n = null;
                return;
            }
            this.n = new com.airbnb.lottie.w.c.p(jVar);
            this.n.a(this);
            this.f3635f.a(this.n);
        }
    }
}
