package com.airbnb.lottie.p102w.p103b;

import android.graphics.Path;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p104c.AbstractC1414a;
import com.airbnb.lottie.p106y.p108k.C1473o;
import com.airbnb.lottie.p106y.p108k.C1475q;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.List;

/* compiled from: ShapeContent.java */
/* renamed from: com.airbnb.lottie.w.b.r */
/* loaded from: classes.dex */
public class C1410r implements InterfaceC1406n, AbstractC1414a.b {

    /* renamed from: b */
    private final String f3498b;

    /* renamed from: c */
    private final boolean f3499c;

    /* renamed from: d */
    private final C1379j f3500d;

    /* renamed from: e */
    private final AbstractC1414a<?, Path> f3501e;

    /* renamed from: f */
    private boolean f3502f;

    /* renamed from: a */
    private final Path f3497a = new Path();

    /* renamed from: g */
    private C1394b f3503g = new C1394b();

    public C1410r(C1379j c1379j, AbstractC1477a abstractC1477a, C1473o c1473o) {
        this.f3498b = c1473o.m3306a();
        this.f3499c = c1473o.m3308c();
        this.f3500d = c1379j;
        this.f3501e = c1473o.m3307b().mo3220a();
        abstractC1477a.m3345a(this.f3501e);
        this.f3501e.m3138a(this);
    }

    /* renamed from: b */
    private void m3124b() {
        this.f3502f = false;
        this.f3500d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.p102w.p104c.AbstractC1414a.b
    /* renamed from: a */
    public void mo3093a() {
        m3124b();
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    public String getName() {
        return this.f3498b;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1406n
    public Path getPath() {
        if (this.f3502f) {
            return this.f3497a;
        }
        this.f3497a.reset();
        if (this.f3499c) {
            this.f3502f = true;
            return this.f3497a;
        }
        this.f3497a.set(this.f3501e.mo3143f());
        this.f3497a.setFillType(Path.FillType.EVEN_ODD);
        this.f3503g.m3101a(this.f3497a);
        this.f3502f = true;
        return this.f3497a;
    }

    @Override // com.airbnb.lottie.p102w.p103b.InterfaceC1395c
    /* renamed from: a */
    public void mo3098a(List<InterfaceC1395c> list, List<InterfaceC1395c> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            InterfaceC1395c interfaceC1395c = list.get(i2);
            if (interfaceC1395c instanceof C1412t) {
                C1412t c1412t = (C1412t) interfaceC1395c;
                if (c1412t.m3129e() == C1475q.a.SIMULTANEOUSLY) {
                    this.f3503g.m3102a(c1412t);
                    c1412t.m3125a(this);
                }
            }
        }
    }
}
