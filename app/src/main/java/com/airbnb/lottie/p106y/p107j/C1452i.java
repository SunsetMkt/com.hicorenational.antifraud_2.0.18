package com.airbnb.lottie.p106y.p107j;

import android.graphics.PointF;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p102w.p104c.C1426m;
import java.util.List;

/* compiled from: AnimatableSplitDimensionPathValue.java */
/* renamed from: com.airbnb.lottie.y.j.i */
/* loaded from: classes.dex */
public class C1452i implements InterfaceC1456m<PointF, PointF> {

    /* renamed from: a */
    private final C1445b f3615a;

    /* renamed from: b */
    private final C1445b f3616b;

    public C1452i(C1445b c1445b, C1445b c1445b2) {
        this.f3615a = c1445b;
        this.f3616b = c1445b2;
    }

    @Override // com.airbnb.lottie.p106y.p107j.InterfaceC1456m
    /* renamed from: a */
    public AbstractC1414a<PointF, PointF> mo3220a() {
        return new C1426m(this.f3615a.mo3220a(), this.f3616b.mo3220a());
    }

    @Override // com.airbnb.lottie.p106y.p107j.InterfaceC1456m
    /* renamed from: b */
    public List<C1361a<PointF>> mo3221b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.p106y.p107j.InterfaceC1456m
    /* renamed from: c */
    public boolean mo3222c() {
        return this.f3615a.mo3222c() && this.f3616b.mo3222c();
    }
}
