package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* JADX INFO: compiled from: ShapePathParser.java */
/* JADX INFO: loaded from: classes.dex */
class h0 {
    static c.a a = c.a.a("nm", "ind", "ks", "hd");

    private h0() {
    }

    static com.airbnb.lottie.y.k.o a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        int iK = 0;
        String strM = null;
        com.airbnb.lottie.y.j.h hVarG = null;
        boolean zI = false;
        while (cVar.h()) {
            int iA = cVar.a(a);
            if (iA == 0) {
                strM = cVar.m();
            } else if (iA == 1) {
                iK = cVar.k();
            } else if (iA == 2) {
                hVarG = d.g(cVar, gVar);
            } else if (iA != 3) {
                cVar.o();
            } else {
                zI = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.o(strM, iK, hVarG, zI);
    }
}
