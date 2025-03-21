package com.airbnb.lottie.p106y.p108k;

import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1396d;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* renamed from: com.airbnb.lottie.y.k.n */
/* loaded from: classes.dex */
public class C1472n implements InterfaceC1460b {

    /* renamed from: a */
    private final String f3701a;

    /* renamed from: b */
    private final List<InterfaceC1460b> f3702b;

    /* renamed from: c */
    private final boolean f3703c;

    public C1472n(String str, List<InterfaceC1460b> list, boolean z) {
        this.f3701a = str;
        this.f3702b = list;
        this.f3703c = z;
    }

    /* renamed from: a */
    public List<InterfaceC1460b> m3303a() {
        return this.f3702b;
    }

    /* renamed from: b */
    public String m3304b() {
        return this.f3701a;
    }

    /* renamed from: c */
    public boolean m3305c() {
        return this.f3703c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f3701a + "' Shapes: " + Arrays.toString(this.f3702b.toArray()) + '}';
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        return new C1396d(c1379j, abstractC1477a, this);
    }
}
