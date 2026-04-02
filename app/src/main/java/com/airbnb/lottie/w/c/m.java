package com.airbnb.lottie.w.c;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: compiled from: SplitDimensionPathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f2369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PointF f2370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a<Float, Float> f2371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a<Float, Float> f2372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    protected com.airbnb.lottie.c0.j<Float> f2373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    protected com.airbnb.lottie.c0.j<Float> f2374n;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f2369i = new PointF();
        this.f2370j = new PointF();
        this.f2371k = aVar;
        this.f2372l = aVar2;
        a(e());
    }

    public void b(@Nullable com.airbnb.lottie.c0.j<Float> jVar) {
        com.airbnb.lottie.c0.j<Float> jVar2 = this.f2373m;
        if (jVar2 != null) {
            jVar2.a((a<?, ?>) null);
        }
        this.f2373m = jVar;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    public void c(@Nullable com.airbnb.lottie.c0.j<Float> jVar) {
        com.airbnb.lottie.c0.j<Float> jVar2 = this.f2374n;
        if (jVar2 != null) {
            jVar2.a((a<?, ?>) null);
        }
        this.f2374n = jVar;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    @Override // com.airbnb.lottie.w.c.a
    public void a(float f2) {
        this.f2371k.a(f2);
        this.f2372l.a(f2);
        this.f2369i.set(this.f2371k.f().floatValue(), this.f2372l.f().floatValue());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).a();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.c.a
    public PointF f() {
        return a((com.airbnb.lottie.c0.a<PointF>) null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.c.a
    public PointF a(com.airbnb.lottie.c0.a<PointF> aVar, float f2) {
        Float fA;
        com.airbnb.lottie.c0.a<Float> aVarA;
        com.airbnb.lottie.c0.a<Float> aVarA2;
        Float fA2 = null;
        if (this.f2373m == null || (aVarA2 = this.f2371k.a()) == null) {
            fA = null;
        } else {
            float fC = this.f2371k.c();
            Float f3 = aVarA2.f2117h;
            com.airbnb.lottie.c0.j<Float> jVar = this.f2373m;
            float f4 = aVarA2.f2116g;
            fA = jVar.a(f4, f3 == null ? f4 : f3.floatValue(), aVarA2.f2111b, aVarA2.f2112c, f2, f2, fC);
        }
        if (this.f2374n != null && (aVarA = this.f2372l.a()) != null) {
            float fC2 = this.f2372l.c();
            Float f5 = aVarA.f2117h;
            com.airbnb.lottie.c0.j<Float> jVar2 = this.f2374n;
            float f6 = aVarA.f2116g;
            fA2 = jVar2.a(f6, f5 == null ? f6 : f5.floatValue(), aVarA.f2111b, aVarA.f2112c, f2, f2, fC2);
        }
        if (fA == null) {
            this.f2370j.set(this.f2369i.x, 0.0f);
        } else {
            this.f2370j.set(fA.floatValue(), 0.0f);
        }
        if (fA2 == null) {
            PointF pointF = this.f2370j;
            pointF.set(pointF.x, this.f2369i.y);
        } else {
            PointF pointF2 = this.f2370j;
            pointF2.set(pointF2.x, fA2.floatValue());
        }
        return this.f2370j;
    }
}
