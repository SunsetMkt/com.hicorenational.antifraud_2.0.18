package com.airbnb.lottie.p106y.p108k;

import android.graphics.PointF;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1398f;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p107j.C1449f;
import com.airbnb.lottie.p106y.p107j.InterfaceC1456m;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: CircleShape.java */
/* renamed from: com.airbnb.lottie.y.k.a */
/* loaded from: classes.dex */
public class C1459a implements InterfaceC1460b {

    /* renamed from: a */
    private final String f3631a;

    /* renamed from: b */
    private final InterfaceC1456m<PointF, PointF> f3632b;

    /* renamed from: c */
    private final C1449f f3633c;

    /* renamed from: d */
    private final boolean f3634d;

    /* renamed from: e */
    private final boolean f3635e;

    public C1459a(String str, InterfaceC1456m<PointF, PointF> interfaceC1456m, C1449f c1449f, boolean z, boolean z2) {
        this.f3631a = str;
        this.f3632b = interfaceC1456m;
        this.f3633c = c1449f;
        this.f3634d = z;
        this.f3635e = z2;
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        return new C1398f(c1379j, abstractC1477a, this);
    }

    /* renamed from: b */
    public InterfaceC1456m<PointF, PointF> m3235b() {
        return this.f3632b;
    }

    /* renamed from: c */
    public C1449f m3236c() {
        return this.f3633c;
    }

    /* renamed from: d */
    public boolean m3237d() {
        return this.f3635e;
    }

    /* renamed from: e */
    public boolean m3238e() {
        return this.f3634d;
    }

    /* renamed from: a */
    public String m3234a() {
        return this.f3631a;
    }
}
