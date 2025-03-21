package com.airbnb.lottie.p106y.p108k;

import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1410r;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p107j.C1451h;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: ShapePath.java */
/* renamed from: com.airbnb.lottie.y.k.o */
/* loaded from: classes.dex */
public class C1473o implements InterfaceC1460b {

    /* renamed from: a */
    private final String f3704a;

    /* renamed from: b */
    private final int f3705b;

    /* renamed from: c */
    private final C1451h f3706c;

    /* renamed from: d */
    private final boolean f3707d;

    public C1473o(String str, int i2, C1451h c1451h, boolean z) {
        this.f3704a = str;
        this.f3705b = i2;
        this.f3706c = c1451h;
        this.f3707d = z;
    }

    /* renamed from: a */
    public String m3306a() {
        return this.f3704a;
    }

    /* renamed from: b */
    public C1451h m3307b() {
        return this.f3706c;
    }

    /* renamed from: c */
    public boolean m3308c() {
        return this.f3707d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f3704a + ", index=" + this.f3705b + '}';
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        return new C1410r(c1379j, abstractC1477a, this);
    }
}
