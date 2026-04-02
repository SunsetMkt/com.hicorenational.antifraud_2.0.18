package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* JADX INFO: compiled from: RepeaterParser.java */
/* JADX INFO: loaded from: classes.dex */
class c0 {
    private static c.a a = c.a.a("nm", bh.aI, "o", "tr", "hd");

    private c0() {
    }

    static com.airbnb.lottie.y.k.k a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        String strM = null;
        com.airbnb.lottie.y.j.b bVarA = null;
        com.airbnb.lottie.y.j.b bVarA2 = null;
        com.airbnb.lottie.y.j.l lVarA = null;
        boolean zI = false;
        while (cVar.h()) {
            int iA = cVar.a(a);
            if (iA == 0) {
                strM = cVar.m();
            } else if (iA == 1) {
                bVarA = d.a(cVar, gVar, false);
            } else if (iA == 2) {
                bVarA2 = d.a(cVar, gVar, false);
            } else if (iA == 3) {
                lVarA = c.a(cVar, gVar);
            } else if (iA != 4) {
                cVar.o();
            } else {
                zI = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.k(strM, bVarA, bVarA2, lVarA, zI);
    }
}
