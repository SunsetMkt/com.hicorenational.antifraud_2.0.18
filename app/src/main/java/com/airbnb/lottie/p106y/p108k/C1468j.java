package com.airbnb.lottie.p106y.p108k;

import android.graphics.PointF;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1408p;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.InterfaceC1456m;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: RectangleShape.java */
/* renamed from: com.airbnb.lottie.y.k.j */
/* loaded from: classes.dex */
public class C1468j implements InterfaceC1460b {

    /* renamed from: a */
    private final String f3682a;

    /* renamed from: b */
    private final InterfaceC1456m<PointF, PointF> f3683b;

    /* renamed from: c */
    private final InterfaceC1456m<PointF, PointF> f3684c;

    /* renamed from: d */
    private final C1445b f3685d;

    /* renamed from: e */
    private final boolean f3686e;

    public C1468j(String str, InterfaceC1456m<PointF, PointF> interfaceC1456m, InterfaceC1456m<PointF, PointF> interfaceC1456m2, C1445b c1445b, boolean z) {
        this.f3682a = str;
        this.f3683b = interfaceC1456m;
        this.f3684c = interfaceC1456m2;
        this.f3685d = c1445b;
        this.f3686e = z;
    }

    /* renamed from: a */
    public C1445b m3283a() {
        return this.f3685d;
    }

    /* renamed from: b */
    public String m3284b() {
        return this.f3682a;
    }

    /* renamed from: c */
    public InterfaceC1456m<PointF, PointF> m3285c() {
        return this.f3683b;
    }

    /* renamed from: d */
    public InterfaceC1456m<PointF, PointF> m3286d() {
        return this.f3684c;
    }

    /* renamed from: e */
    public boolean m3287e() {
        return this.f3686e;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f3683b + ", size=" + this.f3684c + '}';
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        return new C1408p(c1379j, abstractC1477a, this);
    }
}
