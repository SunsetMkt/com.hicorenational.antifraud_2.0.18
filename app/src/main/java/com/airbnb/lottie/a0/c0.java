package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: RepeaterParser.java */
/* loaded from: classes.dex */
class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3333a = c.a.a("nm", bh.aI, "o", "tr", "hd");

    private c0() {
    }

    static com.airbnb.lottie.y.k.k a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        String str = null;
        com.airbnb.lottie.y.j.b bVar = null;
        com.airbnb.lottie.y.j.b bVar2 = null;
        com.airbnb.lottie.y.j.l lVar = null;
        boolean z = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3333a);
            if (a2 == 0) {
                str = cVar.m();
            } else if (a2 == 1) {
                bVar = d.a(cVar, gVar, false);
            } else if (a2 == 2) {
                bVar2 = d.a(cVar, gVar, false);
            } else if (a2 == 3) {
                lVar = c.a(cVar, gVar);
            } else if (a2 != 4) {
                cVar.o();
            } else {
                z = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.k(str, bVar, bVar2, lVar, z);
    }
}
