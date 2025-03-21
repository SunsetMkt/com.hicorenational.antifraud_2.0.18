package com.airbnb.lottie.p102w.p103b;

import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p106y.p108k.C1475q;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* renamed from: com.airbnb.lottie.w.b.t */
/* loaded from: classes.dex */
public class C1412t implements InterfaceC1395c, AbstractC1414a.b {

    /* renamed from: a */
    private final String f3509a;

    /* renamed from: b */
    private final boolean f3510b;

    /* renamed from: c */
    private final List<AbstractC1414a.b> f3511c = new ArrayList();

    /* renamed from: d */
    private final C1475q.a f3512d;

    /* renamed from: e */
    private final AbstractC1414a<?, Float> f3513e;

    /* renamed from: f */
    private final AbstractC1414a<?, Float> f3514f;

    /* renamed from: g */
    private final AbstractC1414a<?, Float> f3515g;

    public C1412t(AbstractC1477a abstractC1477a, C1475q c1475q) {
        this.f3509a = c1475q.m3320b();
        this.f3510b = c1475q.m3324f();
        this.f3512d = c1475q.m3323e();
        this.f3513e = c1475q.m3322d().mo3220a();
        this.f3514f = c1475q.m3319a().mo3220a();
        this.f3515g = c1475q.m3321c().mo3220a();
        abstractC1477a.m3345a(this.f3513e);
        abstractC1477a.m3345a(this.f3514f);
        abstractC1477a.m3345a(this.f3515g);
        this.f3513e.m3138a(this);
        this.f3514f.m3138a(this);
        this.f3515g.m3138a(this);
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        for (int i2 = 0; i2 < this.f3511c.size(); i2++) {
            this.f3511c.get(i2).mo3093a();
        }
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
    }

    /* renamed from: b */
    public AbstractC1414a<?, Float> m3126b() {
        return this.f3514f;
    }

    /* renamed from: c */
    public AbstractC1414a<?, Float> m3127c() {
        return this.f3515g;
    }

    /* renamed from: d */
    public AbstractC1414a<?, Float> m3128d() {
        return this.f3513e;
    }

    /* renamed from: e */
    C1475q.a m3129e() {
        return this.f3512d;
    }

    /* renamed from: f */
    public boolean m3130f() {
        return this.f3510b;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3509a;
    }

    /* renamed from: a */
    void m3125a(AbstractC1414a.b bVar) {
        this.f3511c.add(bVar);
    }
}
