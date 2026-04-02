package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.q;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* JADX INFO: compiled from: ShapeTrimPathParser.java */
/* JADX INFO: loaded from: classes.dex */
class j0 {
    private static c.a a = c.a.a(bh.aE, "e", "o", "nm", "m", "hd");

    private j0() {
    }

    static com.airbnb.lottie.y.k.q a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        String strM = null;
        q.a aVarForId = null;
        com.airbnb.lottie.y.j.b bVarA = null;
        com.airbnb.lottie.y.j.b bVarA2 = null;
        com.airbnb.lottie.y.j.b bVarA3 = null;
        boolean zI = false;
        while (cVar.h()) {
            int iA = cVar.a(a);
            if (iA == 0) {
                bVarA = d.a(cVar, gVar, false);
            } else if (iA == 1) {
                bVarA2 = d.a(cVar, gVar, false);
            } else if (iA == 2) {
                bVarA3 = d.a(cVar, gVar, false);
            } else if (iA == 3) {
                strM = cVar.m();
            } else if (iA == 4) {
                aVarForId = q.a.forId(cVar.k());
            } else if (iA != 5) {
                cVar.o();
            } else {
                zI = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.q(strM, aVarForId, bVarA, bVarA2, bVarA3, zI);
    }
}
