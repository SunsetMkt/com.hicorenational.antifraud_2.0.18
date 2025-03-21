package com.airbnb.lottie.p102w.p104c;

import android.graphics.Path;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p106y.p108k.C1470l;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.l */
/* loaded from: classes.dex */
public class C1425l extends AbstractC1414a<C1470l, Path> {

    /* renamed from: i */
    private final C1470l f3542i;

    /* renamed from: j */
    private final Path f3543j;

    public C1425l(List<C1361a<C1470l>> list) {
        super(list);
        this.f3542i = new C1470l();
        this.f3543j = new Path();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public Path mo3134a(C1361a<C1470l> c1361a, float f2) {
        this.f3542i.m3295a(c1361a.f3156b, c1361a.f3157c, f2);
        C1357g.m2827a(this.f3542i, this.f3543j);
        return this.f3543j;
    }
}
