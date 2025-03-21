package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1455l;
import com.airbnb.lottie.p106y.p108k.C1469k;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;

/* compiled from: RepeaterParser.java */
/* renamed from: com.airbnb.lottie.a0.c0 */
/* loaded from: classes.dex */
class C1310c0 {

    /* renamed from: a */
    private static AbstractC1330c.a f3004a = AbstractC1330c.a.m2710a("nm", C3351bh.f11584aI, "o", "tr", "hd");

    private C1310c0() {
    }

    /* renamed from: a */
    static C1469k m2667a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        String str = null;
        C1445b c1445b = null;
        C1445b c1445b2 = null;
        C1455l c1455l = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3004a);
            if (mo2694a == 0) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 1) {
                c1445b = C1311d.m2669a(abstractC1330c, c1376g, false);
            } else if (mo2694a == 2) {
                c1445b2 = C1311d.m2669a(abstractC1330c, c1376g, false);
            } else if (mo2694a == 3) {
                c1455l = C1309c.m2660a(abstractC1330c, c1376g);
            } else if (mo2694a != 4) {
                abstractC1330c.mo2709o();
            } else {
                z = abstractC1330c.mo2703i();
            }
        }
        return new C1469k(str, c1445b, c1445b2, c1455l, z);
    }
}
