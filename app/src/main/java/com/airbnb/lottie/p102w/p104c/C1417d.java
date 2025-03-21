package com.airbnb.lottie.p102w.p104c;

import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p106y.p108k.C1461c;
import java.util.List;

/* compiled from: GradientColorKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.d */
/* loaded from: classes.dex */
public class C1417d extends AbstractC1419f<C1461c> {

    /* renamed from: i */
    private final C1461c f3530i;

    public C1417d(List<C1361a<C1461c>> list) {
        super(list);
        C1461c c1461c = list.get(0).f3156b;
        int m3242c = c1461c != null ? c1461c.m3242c() : 0;
        this.f3530i = new C1461c(new float[m3242c], new int[m3242c]);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    /* bridge */ /* synthetic */ Object mo3134a(C1361a c1361a, float f2) {
        return mo3134a((C1361a<C1461c>) c1361a, f2);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    C1461c mo3134a(C1361a<C1461c> c1361a, float f2) {
        this.f3530i.m3239a(c1361a.f3156b, c1361a.f3157c, f2);
        return this.f3530i;
    }
}
