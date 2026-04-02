package com.airbnb.lottie.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.List;

/* JADX INFO: compiled from: RectangleContent.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements a.b, k, n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f2319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.j f2320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f2321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f2322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, Float> f2323h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2325j;
    private final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f2317b = new RectF();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private b f2324i = new b();

    public p(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.j jVar2) {
        this.f2318c = jVar2.b();
        this.f2319d = jVar2.e();
        this.f2320e = jVar;
        this.f2321f = jVar2.c().a();
        this.f2322g = jVar2.d().a();
        this.f2323h = jVar2.a().a();
        aVar.a(this.f2321f);
        aVar.a(this.f2322g);
        aVar.a(this.f2323h);
        this.f2321f.a(this);
        this.f2322g.a(this);
        this.f2323h.a(this);
    }

    private void b() {
        this.f2325j = false;
        this.f2320e.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f2318c;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        if (this.f2325j) {
            return this.a;
        }
        this.a.reset();
        if (this.f2319d) {
            this.f2325j = true;
            return this.a;
        }
        PointF pointFF = this.f2322g.f();
        float f2 = pointFF.x / 2.0f;
        float f3 = pointFF.y / 2.0f;
        com.airbnb.lottie.w.c.a<?, Float> aVar = this.f2323h;
        float fI = aVar == null ? 0.0f : ((com.airbnb.lottie.w.c.c) aVar).i();
        float fMin = Math.min(f2, f3);
        if (fI > fMin) {
            fI = fMin;
        }
        PointF pointFF2 = this.f2321f.f();
        this.a.moveTo(pointFF2.x + f2, (pointFF2.y - f3) + fI);
        this.a.lineTo(pointFF2.x + f2, (pointFF2.y + f3) - fI);
        if (fI > 0.0f) {
            RectF rectF = this.f2317b;
            float f4 = pointFF2.x;
            float f5 = fI * 2.0f;
            float f6 = pointFF2.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.a.arcTo(this.f2317b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointFF2.x - f2) + fI, pointFF2.y + f3);
        if (fI > 0.0f) {
            RectF rectF2 = this.f2317b;
            float f7 = pointFF2.x;
            float f8 = pointFF2.y;
            float f9 = fI * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.a.arcTo(this.f2317b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointFF2.x - f2, (pointFF2.y - f3) + fI);
        if (fI > 0.0f) {
            RectF rectF3 = this.f2317b;
            float f10 = pointFF2.x;
            float f11 = pointFF2.y;
            float f12 = fI * 2.0f;
            rectF3.set(f10 - f2, f11 - f3, (f10 - f2) + f12, (f11 - f3) + f12);
            this.a.arcTo(this.f2317b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointFF2.x + f2) - fI, pointFF2.y - f3);
        if (fI > 0.0f) {
            RectF rectF4 = this.f2317b;
            float f13 = pointFF2.x;
            float f14 = fI * 2.0f;
            float f15 = pointFF2.y;
            rectF4.set((f13 + f2) - f14, f15 - f3, f13 + f2, (f15 - f3) + f14);
            this.a.arcTo(this.f2317b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.f2324i.a(this.a);
        this.f2325j = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.e() == q.a.SIMULTANEOUSLY) {
                    this.f2324i.a(tVar);
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
        if (t == com.airbnb.lottie.o.f2229j) {
            this.f2322g.a((com.airbnb.lottie.c0.j<PointF>) jVar);
        } else if (t == com.airbnb.lottie.o.f2231l) {
            this.f2321f.a((com.airbnb.lottie.c0.j<PointF>) jVar);
        } else if (t == com.airbnb.lottie.o.f2230k) {
            this.f2323h.a((com.airbnb.lottie.c0.j<Float>) jVar);
        }
    }
}
