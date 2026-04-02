package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements e, a.b, k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.y.l.a f2278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f2280e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Integer, Integer> f2282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Integer, Integer> f2283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> f2284i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.j f2285j;
    private final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f2277b = new com.airbnb.lottie.w.a(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<n> f2281f = new ArrayList();

    public g(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.m mVar) {
        this.f2278c = aVar;
        this.f2279d = mVar.c();
        this.f2280e = mVar.e();
        this.f2285j = jVar;
        if (mVar.a() == null || mVar.d() == null) {
            this.f2282g = null;
            this.f2283h = null;
            return;
        }
        this.a.setFillType(mVar.b());
        this.f2282g = mVar.a().a();
        this.f2282g.a(this);
        aVar.a(this.f2282g);
        this.f2283h = mVar.d().a();
        this.f2283h.a(this);
        aVar.a(this.f2283h);
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f2285j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f2279d;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            c cVar = list2.get(i2);
            if (cVar instanceof n) {
                this.f2281f.add((n) cVar);
            }
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        if (this.f2280e) {
            return;
        }
        com.airbnb.lottie.e.a("FillContent#draw");
        this.f2277b.setColor(((com.airbnb.lottie.w.c.b) this.f2282g).i());
        this.f2277b.setAlpha(com.airbnb.lottie.b0.g.a((int) ((((i2 / 255.0f) * this.f2283h.f().intValue()) / 100.0f) * 255.0f), 0, 255));
        com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.f2284i;
        if (aVar != null) {
            this.f2277b.setColorFilter(aVar.f());
        }
        this.a.reset();
        for (int i3 = 0; i3 < this.f2281f.size(); i3++) {
            this.a.addPath(this.f2281f.get(i3).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.f2277b);
        com.airbnb.lottie.e.b("FillContent#draw");
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.a.reset();
        for (int i2 = 0; i2 < this.f2281f.size(); i2++) {
            this.a.addPath(this.f2281f.get(i2).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (t == com.airbnb.lottie.o.a) {
            this.f2282g.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.f2223d) {
            this.f2283h.a((com.airbnb.lottie.c0.j<Integer>) jVar);
            return;
        }
        if (t == com.airbnb.lottie.o.E) {
            com.airbnb.lottie.w.c.a<ColorFilter, ColorFilter> aVar = this.f2284i;
            if (aVar != null) {
                this.f2278c.b(aVar);
            }
            if (jVar == null) {
                this.f2284i = null;
                return;
            }
            this.f2284i = new com.airbnb.lottie.w.c.p(jVar);
            this.f2284i.a(this);
            this.f2278c.a(this.f2284i);
        }
    }
}
