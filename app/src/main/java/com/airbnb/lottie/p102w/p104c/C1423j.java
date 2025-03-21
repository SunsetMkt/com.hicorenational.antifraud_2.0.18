package com.airbnb.lottie.p102w.p104c;

import android.graphics.PointF;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import java.util.List;

/* compiled from: PointKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.j */
/* loaded from: classes.dex */
public class C1423j extends AbstractC1419f<PointF> {

    /* renamed from: i */
    private final PointF f3540i;

    public C1423j(List<C1361a<PointF>> list) {
        super(list);
        this.f3540i = new PointF();
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo3134a(C1361a c1361a, float f2) {
        return mo3134a((C1361a<PointF>) c1361a, f2);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    protected /* bridge */ /* synthetic */ Object mo3135a(C1361a c1361a, float f2, float f3, float f4) {
        return mo3135a((C1361a<PointF>) c1361a, f2, f3, f4);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public PointF mo3134a(C1361a<PointF> c1361a, float f2) {
        return mo3135a(c1361a, f2, f2, f2);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    protected PointF mo3135a(C1361a<PointF> c1361a, float f2, float f3, float f4) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = c1361a.f3156b;
        if (pointF3 != null && (pointF = c1361a.f3157c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            C1370j<A> c1370j = this.f3520e;
            if (c1370j != 0 && (pointF2 = (PointF) c1370j.m2869a(c1361a.f3161g, c1361a.f3162h.floatValue(), pointF4, pointF5, f2, m3141d(), m3142e())) != null) {
                return pointF2;
            }
            PointF pointF6 = this.f3540i;
            float f5 = pointF4.x;
            float f6 = f5 + (f3 * (pointF5.x - f5));
            float f7 = pointF4.y;
            pointF6.set(f6, f7 + (f4 * (pointF5.y - f7)));
            return this.f3540i;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
