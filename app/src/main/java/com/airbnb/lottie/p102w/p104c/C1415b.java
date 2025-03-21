package com.airbnb.lottie.p102w.p104c;

import com.airbnb.lottie.p100b0.C1352b;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import java.util.List;

/* compiled from: ColorKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.b */
/* loaded from: classes.dex */
public class C1415b extends AbstractC1419f<Integer> {
    public C1415b(List<C1361a<Integer>> list) {
        super(list);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    /* bridge */ /* synthetic */ Object mo3134a(C1361a c1361a, float f2) {
        return mo3134a((C1361a<Integer>) c1361a, f2);
    }

    /* renamed from: b */
    public int m3152b(C1361a<Integer> c1361a, float f2) {
        Integer num;
        Integer num2 = c1361a.f3156b;
        if (num2 == null || c1361a.f3157c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = num2.intValue();
        int intValue2 = c1361a.f3157c.intValue();
        C1370j<A> c1370j = this.f3520e;
        return (c1370j == 0 || (num = (Integer) c1370j.m2869a(c1361a.f3161g, c1361a.f3162h.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, m3141d(), m3142e())) == null) ? C1352b.m2781a(C1357g.m2820a(f2, 0.0f, 1.0f), intValue, intValue2) : num.intValue();
    }

    /* renamed from: i */
    public int m3153i() {
        return m3152b(m3133a(), m3140c());
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    Integer mo3134a(C1361a<Integer> c1361a, float f2) {
        return Integer.valueOf(m3152b(c1361a, f2));
    }
}
