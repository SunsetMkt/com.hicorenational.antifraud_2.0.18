package com.airbnb.lottie.p098a0;

import android.graphics.PointF;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.p107j.C1449f;
import com.airbnb.lottie.p106y.p107j.InterfaceC1456m;
import com.airbnb.lottie.p106y.p108k.C1459a;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;

/* compiled from: CircleShapeParser.java */
/* renamed from: com.airbnb.lottie.a0.e */
/* loaded from: classes.dex */
class C1313e {

    /* renamed from: a */
    private static AbstractC1330c.a f3006a = AbstractC1330c.a.m2710a("nm", C3351bh.f11576aA, C3351bh.f11580aE, "hd", "d");

    private C1313e() {
    }

    /* renamed from: a */
    static C1459a m2680a(AbstractC1330c abstractC1330c, C1376g c1376g, int i2) throws IOException {
        boolean z = i2 == 3;
        String str = null;
        InterfaceC1456m<PointF, PointF> interfaceC1456m = null;
        C1449f c1449f = null;
        boolean z2 = false;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3006a);
            if (mo2694a == 0) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 1) {
                interfaceC1456m = C1305a.m2655b(abstractC1330c, c1376g);
            } else if (mo2694a == 2) {
                c1449f = C1311d.m2676e(abstractC1330c, c1376g);
            } else if (mo2694a == 3) {
                z2 = abstractC1330c.mo2703i();
            } else if (mo2694a != 4) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                z = abstractC1330c.mo2705k() == 3;
            }
        }
        return new C1459a(str, interfaceC1456m, c1449f, z, z2);
    }
}
