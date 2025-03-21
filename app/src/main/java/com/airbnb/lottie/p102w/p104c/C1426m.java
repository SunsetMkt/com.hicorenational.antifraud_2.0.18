package com.airbnb.lottie.p102w.p104c;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p101c0.C1370j;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.w.c.m */
/* loaded from: classes.dex */
public class C1426m extends AbstractC1414a<PointF, PointF> {

    /* renamed from: i */
    private final PointF f3544i;

    /* renamed from: j */
    private final PointF f3545j;

    /* renamed from: k */
    private final AbstractC1414a<Float, Float> f3546k;

    /* renamed from: l */
    private final AbstractC1414a<Float, Float> f3547l;

    /* renamed from: m */
    @Nullable
    protected C1370j<Float> f3548m;

    /* renamed from: n */
    @Nullable
    protected C1370j<Float> f3549n;

    public C1426m(AbstractC1414a<Float, Float> abstractC1414a, AbstractC1414a<Float, Float> abstractC1414a2) {
        super(Collections.emptyList());
        this.f3544i = new PointF();
        this.f3545j = new PointF();
        this.f3546k = abstractC1414a;
        this.f3547l = abstractC1414a2;
        mo3136a(m3142e());
    }

    /* renamed from: b */
    public void m3163b(@Nullable C1370j<Float> c1370j) {
        C1370j<Float> c1370j2 = this.f3548m;
        if (c1370j2 != null) {
            c1370j2.m2870a((AbstractC1414a<?, ?>) null);
        }
        this.f3548m = c1370j;
        if (c1370j != null) {
            c1370j.m2870a(this);
        }
    }

    /* renamed from: c */
    public void m3164c(@Nullable C1370j<Float> c1370j) {
        C1370j<Float> c1370j2 = this.f3549n;
        if (c1370j2 != null) {
            c1370j2.m2870a((AbstractC1414a<?, ?>) null);
        }
        this.f3549n = c1370j;
        if (c1370j != null) {
            c1370j.m2870a(this);
        }
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public void mo3136a(float f2) {
        this.f3546k.mo3136a(f2);
        this.f3547l.mo3136a(f2);
        this.f3544i.set(this.f3546k.mo3143f().floatValue(), this.f3547l.mo3143f().floatValue());
        for (int i2 = 0; i2 < this.f3516a.size(); i2++) {
            this.f3516a.get(i2).mo3093a();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: f */
    public PointF mo3143f() {
        return mo3134a((C1361a<PointF>) null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a
    /* renamed from: a */
    public PointF mo3134a(C1361a<PointF> c1361a, float f2) {
        Float f3;
        C1361a<Float> m3133a;
        C1361a<Float> m3133a2;
        Float f4 = null;
        if (this.f3548m == null || (m3133a2 = this.f3546k.m3133a()) == null) {
            f3 = null;
        } else {
            float m3140c = this.f3546k.m3140c();
            Float f5 = m3133a2.f3162h;
            C1370j<Float> c1370j = this.f3548m;
            float f6 = m3133a2.f3161g;
            f3 = c1370j.m2869a(f6, f5 == null ? f6 : f5.floatValue(), m3133a2.f3156b, m3133a2.f3157c, f2, f2, m3140c);
        }
        if (this.f3549n != null && (m3133a = this.f3547l.m3133a()) != null) {
            float m3140c2 = this.f3547l.m3140c();
            Float f7 = m3133a.f3162h;
            C1370j<Float> c1370j2 = this.f3549n;
            float f8 = m3133a.f3161g;
            f4 = c1370j2.m2869a(f8, f7 == null ? f8 : f7.floatValue(), m3133a.f3156b, m3133a.f3157c, f2, f2, m3140c2);
        }
        if (f3 == null) {
            this.f3545j.set(this.f3544i.x, 0.0f);
        } else {
            this.f3545j.set(f3.floatValue(), 0.0f);
        }
        if (f4 == null) {
            PointF pointF = this.f3545j;
            pointF.set(pointF.x, this.f3544i.y);
        } else {
            PointF pointF2 = this.f3545j;
            pointF2.set(pointF2.x, f4.floatValue());
        }
        return this.f3545j;
    }
}
