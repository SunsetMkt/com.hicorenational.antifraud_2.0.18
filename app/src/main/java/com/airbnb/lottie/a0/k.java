package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* JADX INFO: compiled from: FontParser.java */
/* JADX INFO: loaded from: classes.dex */
class k {
    private static final c.a a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    private k() {
    }

    static com.airbnb.lottie.y.c a(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        cVar.d();
        String strM = null;
        String strM2 = null;
        String strM3 = null;
        float fJ = 0.0f;
        while (cVar.h()) {
            int iA = cVar.a(a);
            if (iA == 0) {
                strM = cVar.m();
            } else if (iA == 1) {
                strM2 = cVar.m();
            } else if (iA == 2) {
                strM3 = cVar.m();
            } else if (iA != 3) {
                cVar.n();
                cVar.o();
            } else {
                fJ = (float) cVar.j();
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.c(strM, strM2, strM3, fJ);
    }
}
