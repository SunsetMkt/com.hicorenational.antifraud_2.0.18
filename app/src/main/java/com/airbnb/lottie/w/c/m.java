package com.airbnb.lottie.w.c;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f3770i;

    /* renamed from: j, reason: collision with root package name */
    private final PointF f3771j;

    /* renamed from: k, reason: collision with root package name */
    private final a<Float, Float> f3772k;

    /* renamed from: l, reason: collision with root package name */
    private final a<Float, Float> f3773l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    protected com.airbnb.lottie.c0.j<Float> f3774m;

    @Nullable
    protected com.airbnb.lottie.c0.j<Float> n;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f3770i = new PointF();
        this.f3771j = new PointF();
        this.f3772k = aVar;
        this.f3773l = aVar2;
        a(e());
    }

    public void b(@Nullable com.airbnb.lottie.c0.j<Float> jVar) {
        com.airbnb.lottie.c0.j<Float> jVar2 = this.f3774m;
        if (jVar2 != null) {
            jVar2.a((a<?, ?>) null);
        }
        this.f3774m = jVar;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    public void c(@Nullable com.airbnb.lottie.c0.j<Float> jVar) {
        com.airbnb.lottie.c0.j<Float> jVar2 = this.n;
        if (jVar2 != null) {
            jVar2.a((a<?, ?>) null);
        }
        this.n = jVar;
        if (jVar != null) {
            jVar.a(this);
        }
    }

    @Override // com.airbnb.lottie.w.c.a
    public void a(float f2) {
        this.f3772k.a(f2);
        this.f3773l.a(f2);
        this.f3770i.set(this.f3772k.f().floatValue(), this.f3773l.f().floatValue());
        for (int i2 = 0; i2 < this.f3744a.size(); i2++) {
            this.f3744a.get(i2).a();
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
        Float f3;
        com.airbnb.lottie.c0.a<Float> a2;
        com.airbnb.lottie.c0.a<Float> a3;
        Float f4 = null;
        if (this.f3774m == null || (a3 = this.f3772k.a()) == null) {
            f3 = null;
        } else {
            float c2 = this.f3772k.c();
            Float f5 = a3.f3456h;
            com.airbnb.lottie.c0.j<Float> jVar = this.f3774m;
            float f6 = a3.f3455g;
            f3 = jVar.a(f6, f5 == null ? f6 : f5.floatValue(), a3.f3450b, a3.f3451c, f2, f2, c2);
        }
        if (this.n != null && (a2 = this.f3773l.a()) != null) {
            float c3 = this.f3773l.c();
            Float f7 = a2.f3456h;
            com.airbnb.lottie.c0.j<Float> jVar2 = this.n;
            float f8 = a2.f3455g;
            f4 = jVar2.a(f8, f7 == null ? f8 : f7.floatValue(), a2.f3450b, a2.f3451c, f2, f2, c3);
        }
        if (f3 == null) {
            this.f3771j.set(this.f3770i.x, 0.0f);
        } else {
            this.f3771j.set(f3.floatValue(), 0.0f);
        }
        if (f4 == null) {
            PointF pointF = this.f3771j;
            pointF.set(pointF.x, this.f3770i.y);
        } else {
            PointF pointF2 = this.f3771j;
            pointF2.set(pointF2.x, f4.floatValue());
        }
        return this.f3771j;
    }
}
