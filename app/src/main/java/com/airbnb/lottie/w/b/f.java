package com.airbnb.lottie.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import com.airbnb.lottie.y.k.q;
import java.util.List;

/* JADX INFO: compiled from: EllipseContent.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements n, a.b, k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f2269i = 0.55228f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.j f2271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f2272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<?, PointF> f2273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.y.k.a f2274f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2276h;
    private final Path a = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f2275g = new b();

    public f(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.a aVar2) {
        this.f2270b = aVar2.a();
        this.f2271c = jVar;
        this.f2272d = aVar2.c().a();
        this.f2273e = aVar2.b().a();
        this.f2274f = aVar2;
        aVar.a(this.f2272d);
        aVar.a(this.f2273e);
        this.f2272d.a(this);
        this.f2273e.a(this);
    }

    private void b() {
        this.f2276h = false;
        this.f2271c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f2270b;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        if (this.f2276h) {
            return this.a;
        }
        this.a.reset();
        if (this.f2274f.d()) {
            this.f2276h = true;
            return this.a;
        }
        PointF pointFF = this.f2272d.f();
        float f2 = pointFF.x / 2.0f;
        float f3 = pointFF.y / 2.0f;
        float f4 = f2 * f2269i;
        float f5 = f2269i * f3;
        this.a.reset();
        if (this.f2274f.e()) {
            float f6 = -f3;
            this.a.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            this.a.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            this.a.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            this.a.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            this.a.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            this.a.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            this.a.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            this.a.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            this.a.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            this.a.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF pointFF2 = this.f2273e.f();
        this.a.offset(pointFF2.x, pointFF2.y);
        this.a.close();
        this.f2275g.a(this.a);
        this.f2276h = true;
        return this.a;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.e() == q.a.SIMULTANEOUSLY) {
                    this.f2275g.a(tVar);
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
        if (t == com.airbnb.lottie.o.f2228i) {
            this.f2272d.a((com.airbnb.lottie.c0.j<PointF>) jVar);
        } else if (t == com.airbnb.lottie.o.f2231l) {
            this.f2273e.a((com.airbnb.lottie.c0.j<PointF>) jVar);
        }
    }
}
