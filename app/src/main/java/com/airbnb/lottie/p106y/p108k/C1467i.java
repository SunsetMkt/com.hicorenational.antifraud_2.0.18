package com.airbnb.lottie.p106y.p108k;

import android.graphics.PointF;
import com.airbnb.lottie.C1379j;
import com.airbnb.lottie.p102w.p103b.C1407o;
import com.airbnb.lottie.p102w.p103b.InterfaceC1395c;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.InterfaceC1456m;
import com.airbnb.lottie.p106y.p109l.AbstractC1477a;

/* compiled from: PolystarShape.java */
/* renamed from: com.airbnb.lottie.y.k.i */
/* loaded from: classes.dex */
public class C1467i implements InterfaceC1460b {

    /* renamed from: a */
    private final String f3671a;

    /* renamed from: b */
    private final a f3672b;

    /* renamed from: c */
    private final C1445b f3673c;

    /* renamed from: d */
    private final InterfaceC1456m<PointF, PointF> f3674d;

    /* renamed from: e */
    private final C1445b f3675e;

    /* renamed from: f */
    private final C1445b f3676f;

    /* renamed from: g */
    private final C1445b f3677g;

    /* renamed from: h */
    private final C1445b f3678h;

    /* renamed from: i */
    private final C1445b f3679i;

    /* renamed from: j */
    private final boolean f3680j;

    /* compiled from: PolystarShape.java */
    /* renamed from: com.airbnb.lottie.y.k.i$a */
    public enum a {
        STAR(1),
        POLYGON(2);

        private final int value;

        a(int i2) {
            this.value = i2;
        }

        public static a forValue(int i2) {
            for (a aVar : values()) {
                if (aVar.value == i2) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public C1467i(String str, a aVar, C1445b c1445b, InterfaceC1456m<PointF, PointF> interfaceC1456m, C1445b c1445b2, C1445b c1445b3, C1445b c1445b4, C1445b c1445b5, C1445b c1445b6, boolean z) {
        this.f3671a = str;
        this.f3672b = aVar;
        this.f3673c = c1445b;
        this.f3674d = interfaceC1456m;
        this.f3675e = c1445b2;
        this.f3676f = c1445b3;
        this.f3677g = c1445b4;
        this.f3678h = c1445b5;
        this.f3679i = c1445b6;
        this.f3680j = z;
    }

    /* renamed from: a */
    public C1445b m3273a() {
        return this.f3676f;
    }

    /* renamed from: b */
    public C1445b m3274b() {
        return this.f3678h;
    }

    /* renamed from: c */
    public String m3275c() {
        return this.f3671a;
    }

    /* renamed from: d */
    public C1445b m3276d() {
        return this.f3677g;
    }

    /* renamed from: e */
    public C1445b m3277e() {
        return this.f3679i;
    }

    /* renamed from: f */
    public C1445b m3278f() {
        return this.f3673c;
    }

    /* renamed from: g */
    public InterfaceC1456m<PointF, PointF> m3279g() {
        return this.f3674d;
    }

    /* renamed from: h */
    public C1445b m3280h() {
        return this.f3675e;
    }

    /* renamed from: i */
    public a m3281i() {
        return this.f3672b;
    }

    /* renamed from: j */
    public boolean m3282j() {
        return this.f3680j;
    }

    @Override // com.airbnb.lottie.p106y.p108k.InterfaceC1460b
    /* renamed from: a */
    public InterfaceC1395c mo3223a(C1379j c1379j, AbstractC1477a abstractC1477a) {
        return new C1407o(c1379j, abstractC1477a, this);
    }
}
