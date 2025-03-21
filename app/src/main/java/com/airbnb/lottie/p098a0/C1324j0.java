package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p108k.C1475q;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser.java */
/* renamed from: com.airbnb.lottie.a0.j0 */
/* loaded from: classes.dex */
class C1324j0 {

    /* renamed from: a */
    private static AbstractC1330c.a f3021a = AbstractC1330c.a.m2710a(C3351bh.f11580aE, "e", "o", "nm", "m", "hd");

    private C1324j0() {
    }

    /* renamed from: a */
    static C1475q m2687a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        String str = null;
        C1475q.a aVar = null;
        C1445b c1445b = null;
        C1445b c1445b2 = null;
        C1445b c1445b3 = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3021a);
            if (mo2694a == 0) {
                c1445b = C1311d.m2669a(abstractC1330c, c1376g, false);
            } else if (mo2694a == 1) {
                c1445b2 = C1311d.m2669a(abstractC1330c, c1376g, false);
            } else if (mo2694a == 2) {
                c1445b3 = C1311d.m2669a(abstractC1330c, c1376g, false);
            } else if (mo2694a == 3) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 4) {
                aVar = C1475q.a.forId(abstractC1330c.mo2705k());
            } else if (mo2694a != 5) {
                abstractC1330c.mo2709o();
            } else {
                z = abstractC1330c.mo2703i();
            }
        }
        return new C1475q(str, aVar, c1445b, c1445b2, c1445b3, z);
    }
}
