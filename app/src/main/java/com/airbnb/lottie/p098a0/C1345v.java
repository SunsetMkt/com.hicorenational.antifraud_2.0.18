package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1354d;
import com.airbnb.lottie.p106y.p107j.C1447d;
import com.airbnb.lottie.p106y.p107j.C1451h;
import com.airbnb.lottie.p106y.p108k.C1465g;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;

/* compiled from: MaskParser.java */
/* renamed from: com.airbnb.lottie.a0.v */
/* loaded from: classes.dex */
class C1345v {
    private C1345v() {
    }

    /* renamed from: a */
    static C1465g m2772a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        char c2;
        abstractC1330c.mo2698d();
        C1465g.a aVar = null;
        C1451h c1451h = null;
        C1447d c1447d = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            String mo2706l = abstractC1330c.mo2706l();
            int hashCode = mo2706l.hashCode();
            char c3 = 65535;
            if (hashCode == 111) {
                if (mo2706l.equals("o")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 3588) {
                if (mo2706l.equals("pt")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != 104433) {
                if (hashCode == 3357091 && mo2706l.equals(Constants.KEY_MODE)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (mo2706l.equals("inv")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                String mo2707m = abstractC1330c.mo2707m();
                int hashCode2 = mo2707m.hashCode();
                if (hashCode2 != 97) {
                    if (hashCode2 != 105) {
                        if (hashCode2 != 110) {
                            if (hashCode2 == 115 && mo2707m.equals(C3351bh.f11580aE)) {
                                c3 = 1;
                            }
                        } else if (mo2707m.equals("n")) {
                            c3 = 2;
                        }
                    } else if (mo2707m.equals(C3351bh.f11581aF)) {
                        c3 = 3;
                    }
                } else if (mo2707m.equals("a")) {
                    c3 = 0;
                }
                if (c3 == 0) {
                    aVar = C1465g.a.MASK_MODE_ADD;
                } else if (c3 == 1) {
                    aVar = C1465g.a.MASK_MODE_SUBTRACT;
                } else if (c3 == 2) {
                    aVar = C1465g.a.MASK_MODE_NONE;
                } else if (c3 != 3) {
                    C1354d.m2791b("Unknown mask mode " + mo2706l + ". Defaulting to Add.");
                    aVar = C1465g.a.MASK_MODE_ADD;
                } else {
                    c1376g.m2892a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    aVar = C1465g.a.MASK_MODE_INTERSECT;
                }
            } else if (c2 == 1) {
                c1451h = C1311d.m2678g(abstractC1330c, c1376g);
            } else if (c2 == 2) {
                c1447d = C1311d.m2675d(abstractC1330c, c1376g);
            } else if (c2 != 3) {
                abstractC1330c.mo2709o();
            } else {
                z = abstractC1330c.mo2703i();
            }
        }
        abstractC1330c.mo2700f();
        return new C1465g(aVar, c1451h, c1447d, z);
    }
}
