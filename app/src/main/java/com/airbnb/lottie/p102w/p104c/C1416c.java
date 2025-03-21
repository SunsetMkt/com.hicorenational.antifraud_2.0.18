package com.airbnb.lottie.p102w.p104c;

import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import java.util.List;

/* compiled from: FloatKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.c */
/* loaded from: classes.dex */
public class C1416c extends AbstractC1419f<Float> {
    public C1416c(List<C1361a<Float>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    /* bridge */ /* synthetic */ Object mo3134a(C1361a c1361a, float f2) {
        return mo3134a((C1361a<Float>) c1361a, f2);
    }

    /* renamed from: b */
    float m3154b(C1361a<Float> c1361a, float f2) {
        Float f3;
        if (c1361a.f3156b == null || c1361a.f3157c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C1370j<A> c1370j = this.f3520e;
        return (c1370j == 0 || (f3 = (Float) c1370j.m2869a(c1361a.f3161g, c1361a.f3162h.floatValue(), c1361a.f3156b, c1361a.f3157c, f2, m3141d(), m3142e())) == null) ? C1357g.m2831c(c1361a.m2854e(), c1361a.m2851b(), f2) : f3.floatValue();
    }

    /* renamed from: i */
    public float m3155i() {
        return m3154b(m3133a(), m3140c());
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    Float mo3134a(C1361a<Float> c1361a, float f2) {
        return Float.valueOf(m3154b(c1361a, f2));
    }
}
