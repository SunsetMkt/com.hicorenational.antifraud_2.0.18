package com.airbnb.lottie.p106y.p108k;

import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1412t;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: ShapeTrimPath.java */
/* renamed from: com.airbnb.lottie.y.k.q */
/* loaded from: classes.dex */
public class C1475q implements InterfaceC1460b {

    /* renamed from: a */
    private final String f3722a;

    /* renamed from: b */
    private final a f3723b;

    /* renamed from: c */
    private final C1445b f3724c;

    /* renamed from: d */
    private final C1445b f3725d;

    /* renamed from: e */
    private final C1445b f3726e;

    /* renamed from: f */
    private final boolean f3727f;

    /* compiled from: ShapeTrimPath.java */
    /* renamed from: com.airbnb.lottie.y.k.q$a */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a forId(int i2) {
            if (i2 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i2 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i2);
        }
    }

    public C1475q(String str, a aVar, C1445b c1445b, C1445b c1445b2, C1445b c1445b3, boolean z) {
        this.f3722a = str;
        this.f3723b = aVar;
        this.f3724c = c1445b;
        this.f3725d = c1445b2;
        this.f3726e = c1445b3;
        this.f3727f = z;
    }

    /* renamed from: a */
    public C1445b m3319a() {
        return this.f3725d;
    }

    /* renamed from: b */
    public String m3320b() {
        return this.f3722a;
    }

    /* renamed from: c */
    public C1445b m3321c() {
        return this.f3726e;
    }

    /* renamed from: d */
    public C1445b m3322d() {
        return this.f3724c;
    }

    /* renamed from: e */
    public a m3323e() {
        return this.f3723b;
    }

    /* renamed from: f */
    public boolean m3324f() {
        return this.f3727f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f3724c + ", end: " + this.f3725d + ", offset: " + this.f3726e + "}";
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        return new C1412t(abstractC1477a, this);
    }
}
