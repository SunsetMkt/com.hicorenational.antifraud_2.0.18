package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.p107j.C1451h;
import com.airbnb.lottie.p106y.p108k.C1473o;
import java.io.IOException;

/* compiled from: ShapePathParser.java */
/* renamed from: com.airbnb.lottie.a0.h0 */
/* loaded from: classes.dex */
class C1320h0 {

    /* renamed from: a */
    static AbstractC1330c.a f3015a = AbstractC1330c.a.m2710a("nm", "ind", "ks", "hd");

    private C1320h0() {
    }

    /* renamed from: a */
    static C1473o m2684a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        int i2 = 0;
        String str = null;
        C1451h c1451h = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3015a);
            if (mo2694a == 0) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 1) {
                i2 = abstractC1330c.mo2705k();
            } else if (mo2694a == 2) {
                c1451h = C1311d.m2678g(abstractC1330c, c1376g);
            } else if (mo2694a != 3) {
                abstractC1330c.mo2709o();
            } else {
                z = abstractC1330c.mo2703i();
            }
        }
        return new C1473o(str, i2, c1451h, z);
    }
}
