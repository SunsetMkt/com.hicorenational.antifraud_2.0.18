package com.airbnb.lottie.p102w.p104c;

import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import com.airbnb.lottie.p101c0.C1371k;
import java.util.List;

/* compiled from: ScaleKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.k */
/* loaded from: classes.dex */
public class C1424k extends AbstractC1419f<C1371k> {

    /* renamed from: i */
    private final C1371k f3541i;

    public C1424k(List<C1361a<C1371k>> list) {
        super(list);
        this.f3541i = new C1371k();
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public /* bridge */ /* synthetic */ Object mo3134a(C1361a c1361a, float f2) {
        return mo3134a((C1361a<C1371k>) c1361a, f2);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public C1371k mo3134a(C1361a<C1371k> c1361a, float f2) {
        C1371k c1371k;
        C1371k c1371k2;
        C1371k c1371k3 = c1361a.f3156b;
        if (c1371k3 == null || (c1371k = c1361a.f3157c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C1371k c1371k4 = c1371k3;
        C1371k c1371k5 = c1371k;
        C1370j<A> c1370j = this.f3520e;
        if (c1370j != 0 && (c1371k2 = (C1371k) c1370j.m2869a(c1361a.f3161g, c1361a.f3162h.floatValue(), c1371k4, c1371k5, f2, m3141d(), m3142e())) != null) {
            return c1371k2;
        }
        this.f3541i.m2875b(C1357g.m2831c(c1371k4.m2872a(), c1371k5.m2872a(), f2), C1357g.m2831c(c1371k4.m2874b(), c1371k5.m2874b(), f2));
        return this.f3541i;
    }
}
