package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* JADX INFO: compiled from: AnimatableTransformParser.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final c.a a = c.a.a(bh.ay, bh.aA, bh.aE, "rz", "r", "o", "so", "eo", "sk", "sa");

    /* JADX INFO: renamed from: b */
    private static final c.a f2040b = c.a.a("k");

    private c() {
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.airbnb.lottie.y.j.l a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        com.airbnb.lottie.y.j.b bVarA;
        boolean z = false;
        boolean z2 = cVar.peek() == c.b.BEGIN_OBJECT;
        if (z2) {
            cVar.d();
        }
        com.airbnb.lottie.y.j.b bVar = null;
        com.airbnb.lottie.y.j.e eVarA = null;
        com.airbnb.lottie.y.j.m<PointF, PointF> mVarB = null;
        com.airbnb.lottie.y.j.g gVarF = null;
        com.airbnb.lottie.y.j.b bVarA2 = null;
        com.airbnb.lottie.y.j.b bVarA3 = null;
        com.airbnb.lottie.y.j.d dVarD = null;
        com.airbnb.lottie.y.j.b bVarA4 = null;
        com.airbnb.lottie.y.j.b bVarA5 = null;
        while (cVar.h()) {
            switch (cVar.a(a)) {
                case 0:
                    cVar.d();
                    while (cVar.h()) {
                        if (cVar.a(f2040b) != 0) {
                            cVar.n();
                            cVar.o();
                        } else {
                            eVarA = a.a(cVar, gVar);
                        }
                    }
                    cVar.f();
                    z = false;
                    break;
                case 1:
                    mVarB = a.b(cVar, gVar);
                    z = false;
                    break;
                case 2:
                    gVarF = d.f(cVar, gVar);
                    z = false;
                    break;
                case 3:
                    gVar.a("Lottie doesn't support 3D layers.");
                    bVarA = d.a(cVar, gVar, z);
                    if (bVarA.b().isEmpty()) {
                        if (((com.airbnb.lottie.c0.a) bVarA.b().get(0)).f2111b == 0) {
                            bVarA.b().set(0, new com.airbnb.lottie.c0.a(gVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(gVar.e())));
                        }
                        bVar = bVarA;
                        z = false;
                    } else {
                        bVarA.b().add(new com.airbnb.lottie.c0.a(gVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(gVar.e())));
                    }
                    bVar = bVarA;
                    z = false;
                    break;
                case 4:
                    bVarA = d.a(cVar, gVar, z);
                    if (bVarA.b().isEmpty()) {
                    }
                    bVar = bVarA;
                    z = false;
                    break;
                case 5:
                    dVarD = d.d(cVar, gVar);
                    break;
                case 6:
                    bVarA4 = d.a(cVar, gVar, z);
                    break;
                case 7:
                    bVarA5 = d.a(cVar, gVar, z);
                    break;
                case 8:
                    bVarA2 = d.a(cVar, gVar, z);
                    break;
                case 9:
                    bVarA3 = d.a(cVar, gVar, z);
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    z = false;
                    break;
            }
        }
        if (z2) {
            cVar.f();
        }
        com.airbnb.lottie.y.j.e eVar = a(eVarA) ? null : eVarA;
        com.airbnb.lottie.y.j.m<PointF, PointF> mVar = a(mVarB) ? null : mVarB;
        com.airbnb.lottie.y.j.b bVar2 = a(bVar) ? null : bVar;
        if (a(gVarF)) {
            gVarF = null;
        }
        return new com.airbnb.lottie.y.j.l(eVar, mVar, gVarF, bVar2, dVarD, bVarA4, bVarA5, c(bVarA2) ? null : bVarA2, b(bVarA3) ? null : bVarA3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean b(com.airbnb.lottie.y.j.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((com.airbnb.lottie.c0.a) bVar.b().get(0)).f2111b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean c(com.airbnb.lottie.y.j.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((com.airbnb.lottie.c0.a) bVar.b().get(0)).f2111b).floatValue() == 0.0f);
    }

    private static boolean a(com.airbnb.lottie.y.j.e eVar) {
        return eVar == null || (eVar.c() && eVar.b().get(0).f2111b.equals(0.0f, 0.0f));
    }

    private static boolean a(com.airbnb.lottie.y.j.m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof com.airbnb.lottie.y.j.i) && mVar.c() && mVar.b().get(0).f2111b.equals(0.0f, 0.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(com.airbnb.lottie.y.j.b bVar) {
        return bVar == null || (bVar.c() && ((Float) ((com.airbnb.lottie.c0.a) bVar.b().get(0)).f2111b).floatValue() == 0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean a(com.airbnb.lottie.y.j.g gVar) {
        return gVar == null || (gVar.c() && ((com.airbnb.lottie.c0.k) ((com.airbnb.lottie.c0.a) gVar.b().get(0)).f2111b).a(1.0f, 1.0f));
    }
}
