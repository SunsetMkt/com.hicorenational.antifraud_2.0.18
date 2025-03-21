package com.airbnb.lottie.p102w.p104c;

import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import java.util.List;

/* compiled from: IntegerKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.e */
/* loaded from: classes.dex */
public class C1418e extends AbstractC1419f<Integer> {
    public C1418e(List<C1361a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    /* bridge */ /* synthetic */ Object mo3134a(C1361a c1361a, float f2) {
        return mo3134a((C1361a<Integer>) c1361a, f2);
    }

    /* renamed from: b */
    int m3156b(C1361a<Integer> c1361a, float f2) {
        Integer num;
        if (c1361a.f3156b == null || c1361a.f3157c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C1370j<A> c1370j = this.f3520e;
        return (c1370j == 0 || (num = (Integer) c1370j.m2869a(c1361a.f3161g, c1361a.f3162h.floatValue(), c1361a.f3156b, c1361a.f3157c, f2, m3141d(), m3142e())) == null) ? C1357g.m2823a(c1361a.m2855f(), c1361a.m2852c(), f2) : num.intValue();
    }

    /* renamed from: i */
    public int m3157i() {
        return m3156b(m3133a(), m3140c());
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    Integer mo3134a(C1361a<Integer> c1361a, float f2) {
        return Integer.valueOf(m3156b(c1361a, f2));
    }
}
