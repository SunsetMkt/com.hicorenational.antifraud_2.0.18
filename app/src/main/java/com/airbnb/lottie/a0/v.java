package com.airbnb.lottie.a0;

import com.airbnb.lottie.y.k.g;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: MaskParser.java */
/* loaded from: classes.dex */
class v {
    private v() {
    }

    static com.airbnb.lottie.y.k.g a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        char c2;
        cVar.d();
        g.a aVar = null;
        com.airbnb.lottie.y.j.h hVar = null;
        com.airbnb.lottie.y.j.d dVar = null;
        boolean z = false;
        while (cVar.h()) {
            String l2 = cVar.l();
            int hashCode = l2.hashCode();
            char c3 = 65535;
            if (hashCode == 111) {
                if (l2.equals("o")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode == 3588) {
                if (l2.equals("pt")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode != 104433) {
                if (hashCode == 3357091 && l2.equals(Constants.KEY_MODE)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (l2.equals("inv")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                String m2 = cVar.m();
                int hashCode2 = m2.hashCode();
                if (hashCode2 != 97) {
                    if (hashCode2 != 105) {
                        if (hashCode2 != 110) {
                            if (hashCode2 == 115 && m2.equals(bh.aE)) {
                                c3 = 1;
                            }
                        } else if (m2.equals("n")) {
                            c3 = 2;
                        }
                    } else if (m2.equals(bh.aF)) {
                        c3 = 3;
                    }
                } else if (m2.equals("a")) {
                    c3 = 0;
                }
                if (c3 == 0) {
                    aVar = g.a.MASK_MODE_ADD;
                } else if (c3 == 1) {
                    aVar = g.a.MASK_MODE_SUBTRACT;
                } else if (c3 == 2) {
                    aVar = g.a.MASK_MODE_NONE;
                } else if (c3 != 3) {
                    com.airbnb.lottie.b0.d.b("Unknown mask mode " + l2 + ". Defaulting to Add.");
                    aVar = g.a.MASK_MODE_ADD;
                } else {
                    gVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    aVar = g.a.MASK_MODE_INTERSECT;
                }
            } else if (c2 == 1) {
                hVar = d.g(cVar, gVar);
            } else if (c2 == 2) {
                dVar = d.d(cVar, gVar);
            } else if (c2 != 3) {
                cVar.o();
            } else {
                z = cVar.i();
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.k.g(aVar, hVar, dVar, z);
    }
}
