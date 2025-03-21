package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.C1438d;
import com.airbnb.lottie.p106y.p108k.C1472n;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FontCharacterParser.java */
/* renamed from: com.airbnb.lottie.a0.j */
/* loaded from: classes.dex */
class C1323j {

    /* renamed from: a */
    private static final AbstractC1330c.a f3019a = AbstractC1330c.a.m2710a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b */
    private static final AbstractC1330c.a f3020b = AbstractC1330c.a.m2710a("shapes");

    private C1323j() {
    }

    /* renamed from: a */
    static C1438d m2686a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        ArrayList arrayList = new ArrayList();
        abstractC1330c.mo2698d();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        char c2 = 0;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3019a);
            if (mo2694a == 0) {
                c2 = abstractC1330c.mo2707m().charAt(0);
            } else if (mo2694a == 1) {
                d2 = abstractC1330c.mo2704j();
            } else if (mo2694a == 2) {
                d3 = abstractC1330c.mo2704j();
            } else if (mo2694a == 3) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 4) {
                str2 = abstractC1330c.mo2707m();
            } else if (mo2694a != 5) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                abstractC1330c.mo2698d();
                while (abstractC1330c.mo2702h()) {
                    if (abstractC1330c.mo2694a(f3020b) != 0) {
                        abstractC1330c.mo2708n();
                        abstractC1330c.mo2709o();
                    } else {
                        abstractC1330c.mo2697c();
                        while (abstractC1330c.mo2702h()) {
                            arrayList.add((C1472n) C1317g.m2682a(abstractC1330c, c1376g));
                        }
                        abstractC1330c.mo2699e();
                    }
                }
                abstractC1330c.mo2700f();
            }
        }
        abstractC1330c.mo2700f();
        return new C1438d(arrayList, c2, d2, d3, str, str2);
    }
}
