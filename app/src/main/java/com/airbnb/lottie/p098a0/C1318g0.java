package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.p108k.C1472n;
import com.airbnb.lottie.p106y.p108k.InterfaceC1460b;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser.java */
/* renamed from: com.airbnb.lottie.a0.g0 */
/* loaded from: classes.dex */
class C1318g0 {

    /* renamed from: a */
    private static AbstractC1330c.a f3012a = AbstractC1330c.a.m2710a("nm", "hd", "it");

    private C1318g0() {
    }

    /* renamed from: a */
    static C1472n m2683a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3012a);
            if (mo2694a == 0) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 1) {
                z = abstractC1330c.mo2703i();
            } else if (mo2694a != 2) {
                abstractC1330c.mo2709o();
            } else {
                abstractC1330c.mo2697c();
                while (abstractC1330c.mo2702h()) {
                    InterfaceC1460b m2682a = C1317g.m2682a(abstractC1330c, c1376g);
                    if (m2682a != null) {
                        arrayList.add(m2682a);
                    }
                }
                abstractC1330c.mo2699e();
            }
        }
        return new C1472n(str, arrayList, z);
    }
}
