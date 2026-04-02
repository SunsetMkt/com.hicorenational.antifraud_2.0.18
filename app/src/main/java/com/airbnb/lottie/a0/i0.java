package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.p;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: ShapeStrokeParser.java */
/* JADX INFO: loaded from: classes.dex */
class i0 {
    private static c.a a = c.a.a("nm", bh.aI, "w", "o", "lc", "lj", "ml", "hd", "d");

    /* JADX INFO: renamed from: b */
    private static final c.a f2043b = c.a.a("n", "v");

    private i0() {
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static com.airbnb.lottie.y.k.p a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        byte b2;
        ArrayList arrayList = new ArrayList();
        com.airbnb.lottie.y.j.d dVarD = null;
        String strM = null;
        com.airbnb.lottie.y.j.b bVar = null;
        com.airbnb.lottie.y.j.a aVarA = null;
        com.airbnb.lottie.y.j.b bVarC = null;
        p.b bVar2 = null;
        p.c cVar2 = null;
        float fJ = 0.0f;
        boolean zI = false;
        while (true) {
            int i2 = 100;
            if (!cVar.h()) {
                return new com.airbnb.lottie.y.k.p(strM, bVar, arrayList, aVarA, dVarD == null ? new com.airbnb.lottie.y.j.d(Collections.singletonList(new com.airbnb.lottie.c0.a(100))) : dVarD, bVarC, bVar2, cVar2, fJ, zI);
            }
            int i3 = 1;
            switch (cVar.a(a)) {
                case 0:
                    strM = cVar.m();
                    break;
                case 1:
                    aVarA = d.a(cVar, gVar);
                    break;
                case 2:
                    bVarC = d.c(cVar, gVar);
                    break;
                case 3:
                    dVarD = d.d(cVar, gVar);
                    break;
                case 4:
                    bVar2 = p.b.values()[cVar.k() - 1];
                    break;
                case 5:
                    cVar2 = p.c.values()[cVar.k() - 1];
                    break;
                case 6:
                    fJ = (float) cVar.j();
                    break;
                case 7:
                    zI = cVar.i();
                    break;
                case 8:
                    cVar.c();
                    while (cVar.h()) {
                        cVar.d();
                        com.airbnb.lottie.y.j.b bVarC2 = null;
                        String strM2 = null;
                        while (cVar.h()) {
                            int iA = cVar.a(f2043b);
                            if (iA == 0) {
                                strM2 = cVar.m();
                            } else if (iA != i3) {
                                cVar.n();
                                cVar.o();
                            } else {
                                bVarC2 = d.c(cVar, gVar);
                            }
                        }
                        cVar.f();
                        int iHashCode = strM2.hashCode();
                        if (iHashCode != i2) {
                            if (iHashCode != 103) {
                                b2 = (iHashCode == 111 && strM2.equals("o")) ? (byte) 0 : (byte) -1;
                            } else if (strM2.equals("g")) {
                                b2 = 2;
                            }
                        } else if (strM2.equals("d")) {
                            b2 = 1;
                        }
                        if (b2 == 0) {
                            bVar = bVarC2;
                        } else if (b2 == 1 || b2 == 2) {
                            gVar.a(true);
                            arrayList.add(bVarC2);
                        }
                        i2 = 100;
                        i3 = 1;
                    }
                    cVar.e();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    break;
                default:
                    cVar.o();
                    break;
            }
        }
    }
}
