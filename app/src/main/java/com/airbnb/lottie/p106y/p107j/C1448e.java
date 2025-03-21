package com.airbnb.lottie.p106y.p107j;

import android.graphics.PointF;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1422i;
import com.airbnb.lottie.p102w.p104c.C1423j;
import java.util.Collections;
import java.util.List;

/* compiled from: AnimatablePathValue.java */
/* renamed from: com.airbnb.lottie.y.j.e */
/* loaded from: classes.dex */
public class C1448e implements InterfaceC1456m<PointF, PointF> {

    /* renamed from: a */
    private final List<C1361a<PointF>> f3614a;

    public C1448e() {
        this.f3614a = Collections.singletonList(new C1361a(new PointF(0.0f, 0.0f)));
    }

    @Override // com.airbnb.lottie.p106y.p107j.InterfaceC1456m
    /* renamed from: a */
    public AbstractC1414a<PointF, PointF> mo3220a() {
        return this.f3614a.get(0).m2856g() ? new C1423j(this.f3614a) : new C1422i(this.f3614a);
    }

    @Override // com.airbnb.lottie.p106y.p107j.InterfaceC1456m
    /* renamed from: b */
    public List<C1361a<PointF>> mo3221b() {
        return this.f3614a;
    }

    @Override // com.airbnb.lottie.p106y.p107j.InterfaceC1456m
    /* renamed from: c */
    public boolean mo3222c() {
        return this.f3614a.size() == 1 && this.f3614a.get(0).m2856g();
    }

    public C1448e(List<C1361a<PointF>> list) {
        this.f3614a = list;
    }
}
