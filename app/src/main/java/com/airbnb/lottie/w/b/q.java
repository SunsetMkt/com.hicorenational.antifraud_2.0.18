package com.airbnb.lottie.w.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.w.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: RepeaterContent.java */
/* JADX INFO: loaded from: classes.dex */
public class q implements e, n, j, a.b, k {
    private final Matrix a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f2326b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.j f2327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.y.l.a f2328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f2330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Float, Float> f2331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.a<Float, Float> f2332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.w.c.o f2333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d f2334j;

    public q(com.airbnb.lottie.j jVar, com.airbnb.lottie.y.l.a aVar, com.airbnb.lottie.y.k.k kVar) {
        this.f2327c = jVar;
        this.f2328d = aVar;
        this.f2329e = kVar.b();
        this.f2330f = kVar.e();
        this.f2331g = kVar.a().a();
        aVar.a(this.f2331g);
        this.f2331g.a(this);
        this.f2332h = kVar.c().a();
        aVar.a(this.f2332h);
        this.f2332h.a(this);
        this.f2333i = kVar.d().a();
        this.f2333i.a(aVar);
        this.f2333i.a(this);
    }

    @Override // com.airbnb.lottie.w.b.j
    public void a(ListIterator<c> listIterator) {
        if (this.f2334j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f2334j = new d(this.f2327c, this.f2328d, "Repeater", this.f2330f, arrayList, null);
    }

    @Override // com.airbnb.lottie.w.b.c
    public String getName() {
        return this.f2329e;
    }

    @Override // com.airbnb.lottie.w.b.n
    public Path getPath() {
        Path path = this.f2334j.getPath();
        this.f2326b.reset();
        float fFloatValue = this.f2331g.f().floatValue();
        float fFloatValue2 = this.f2332h.f().floatValue();
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(this.f2333i.a(i2 + fFloatValue2));
            this.f2326b.addPath(path, this.a);
        }
        return this.f2326b;
    }

    @Override // com.airbnb.lottie.w.b.c
    public void a(List<c> list, List<c> list2) {
        this.f2334j.a(list, list2);
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(Canvas canvas, Matrix matrix, int i2) {
        float fFloatValue = this.f2331g.f().floatValue();
        float fFloatValue2 = this.f2332h.f().floatValue();
        float fFloatValue3 = this.f2333i.d().f().floatValue() / 100.0f;
        float fFloatValue4 = this.f2333i.a().f().floatValue() / 100.0f;
        for (int i3 = ((int) fFloatValue) - 1; i3 >= 0; i3--) {
            this.a.set(matrix);
            float f2 = i3;
            this.a.preConcat(this.f2333i.a(f2 + fFloatValue2));
            this.f2334j.a(canvas, this.a, (int) (i2 * com.airbnb.lottie.b0.g.c(fFloatValue3, fFloatValue4, f2 / fFloatValue)));
        }
    }

    @Override // com.airbnb.lottie.w.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f2334j.a(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.w.c.a.b
    public void a() {
        this.f2327c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.y.f
    public void a(com.airbnb.lottie.y.e eVar, int i2, List<com.airbnb.lottie.y.e> list, com.airbnb.lottie.y.e eVar2) {
        com.airbnb.lottie.b0.g.a(eVar, i2, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.y.f
    public <T> void a(T t, @Nullable com.airbnb.lottie.c0.j<T> jVar) {
        if (this.f2333i.a(t, jVar)) {
            return;
        }
        if (t == com.airbnb.lottie.o.s) {
            this.f2331g.a((com.airbnb.lottie.c0.j<Float>) jVar);
        } else if (t == com.airbnb.lottie.o.t) {
            this.f2332h.a((com.airbnb.lottie.c0.j<Float>) jVar);
        }
    }
}
