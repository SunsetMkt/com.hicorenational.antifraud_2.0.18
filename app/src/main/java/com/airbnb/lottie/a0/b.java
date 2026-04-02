package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* JADX INFO: compiled from: AnimatableTextPropertiesParser.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static c.a a = c.a.a(bh.ay);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c.a f2039b = c.a.a("fc", "sc", "sw", "t");

    private b() {
    }

    public static com.airbnb.lottie.y.j.k a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        cVar.d();
        com.airbnb.lottie.y.j.k kVarB = null;
        while (cVar.h()) {
            if (cVar.a(a) != 0) {
                cVar.n();
                cVar.o();
            } else {
                kVarB = b(cVar, gVar);
            }
        }
        cVar.f();
        return kVarB == null ? new com.airbnb.lottie.y.j.k(null, null, null, null) : kVarB;
    }

    private static com.airbnb.lottie.y.j.k b(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        cVar.d();
        com.airbnb.lottie.y.j.a aVarA = null;
        com.airbnb.lottie.y.j.a aVarA2 = null;
        com.airbnb.lottie.y.j.b bVarC = null;
        com.airbnb.lottie.y.j.b bVarC2 = null;
        while (cVar.h()) {
            int iA = cVar.a(f2039b);
            if (iA == 0) {
                aVarA = d.a(cVar, gVar);
            } else if (iA == 1) {
                aVarA2 = d.a(cVar, gVar);
            } else if (iA == 2) {
                bVarC = d.c(cVar, gVar);
            } else if (iA != 3) {
                cVar.n();
                cVar.o();
            } else {
                bVarC2 = d.c(cVar, gVar);
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.j.k(aVarA, aVarA2, bVarC, bVarC2);
    }
}
