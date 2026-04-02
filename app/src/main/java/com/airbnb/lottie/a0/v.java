package com.airbnb.lottie.a0;

import com.airbnb.lottie.y.k.g;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* JADX INFO: compiled from: MaskParser.java */
/* JADX INFO: loaded from: classes.dex */
class v {
    private v() {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static com.airbnb.lottie.y.k.g a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        byte b2;
        cVar.d();
        g.a aVar = null;
        com.airbnb.lottie.y.j.h hVarG = null;
        com.airbnb.lottie.y.j.d dVarD = null;
        boolean zI = false;
        while (cVar.h()) {
            String strL = cVar.l();
            int iHashCode = strL.hashCode();
            byte b3 = -1;
            if (iHashCode != 111) {
                if (iHashCode != 3588) {
                    if (iHashCode != 104433) {
                        b2 = (iHashCode == 3357091 && strL.equals(Constants.KEY_MODE)) ? (byte) 0 : (byte) -1;
                    } else if (strL.equals("inv")) {
                        b2 = 3;
                    }
                } else if (strL.equals("pt")) {
                    b2 = 1;
                }
            } else if (strL.equals("o")) {
                b2 = 2;
            }
            if (b2 == 0) {
                String strM = cVar.m();
                int iHashCode2 = strM.hashCode();
                if (iHashCode2 != 97) {
                    if (iHashCode2 != 105) {
                        if (iHashCode2 != 110) {
                            if (iHashCode2 == 115 && strM.equals(bh.aE)) {
                                b3 = 1;
                            }
                        } else if (strM.equals("n")) {
                            b3 = 2;
                        }
                    } else if (strM.equals(bh.aF)) {
                        b3 = 3;
                    }
                } else if (strM.equals(bh.ay)) {
                    b3 = 0;
                }
                if (b3 == 0) {
                    aVar = g.a.MASK_MODE_ADD;
                } else if (b3 == 1) {
                    aVar = g.a.MASK_MODE_SUBTRACT;
                } else if (b3 == 2) {
                    aVar = g.a.MASK_MODE_NONE;
                } else if (b3 != 3) {
                    com.airbnb.lottie.b0.d.b("Unknown mask mode " + strL + ". Defaulting to Add.");
                    aVar = g.a.MASK_MODE_ADD;
                } else {
                    gVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                    aVar = g.a.MASK_MODE_INTERSECT;
                }
            } else if (b2 == 1) {
                hVarG = d.g(cVar, gVar);
            } else if (b2 == 2) {
                dVarD = d.d(cVar, gVar);
            } else if (b2 != 3) {
                cVar.o();
            } else {
                zI = cVar.i();
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.k.g(aVar, hVarG, dVarD, zI);
    }
}
