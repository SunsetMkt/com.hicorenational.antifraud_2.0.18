package com.airbnb.lottie.p102w.p104c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import java.util.List;

/* compiled from: PathKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.i */
/* loaded from: classes.dex */
public class C1422i extends AbstractC1419f<PointF> {

    /* renamed from: i */
    private final PointF f3536i;

    /* renamed from: j */
    private final float[] f3537j;

    /* renamed from: k */
    private final PathMeasure f3538k;

    /* renamed from: l */
    private C1421h f3539l;

    public C1422i(List<? extends C1361a<PointF>> list) {
        super(list);
        this.f3536i = new PointF();
        this.f3537j = new float[2];
        this.f3538k = new PathMeasure();
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo3134a(C1361a c1361a, float f2) {
        return mo3134a((C1361a<PointF>) c1361a, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public PointF mo3134a(C1361a<PointF> c1361a, float f2) {
        PointF pointF;
        C1421h c1421h = (C1421h) c1361a;
        Path m3162i = c1421h.m3162i();
        if (m3162i == null) {
            return c1361a.f3156b;
        }
        C1370j<A> c1370j = this.f3520e;
        if (c1370j != 0 && (pointF = (PointF) c1370j.m2869a(c1421h.f3161g, c1421h.f3162h.floatValue(), c1421h.f3156b, c1421h.f3157c, m3141d(), f2, m3142e())) != null) {
            return pointF;
        }
        if (this.f3539l != c1421h) {
            this.f3538k.setPath(m3162i, false);
            this.f3539l = c1421h;
        }
        PathMeasure pathMeasure = this.f3538k;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f3537j, null);
        PointF pointF2 = this.f3536i;
        float[] fArr = this.f3537j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f3536i;
    }
}
