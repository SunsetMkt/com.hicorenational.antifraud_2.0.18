package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.q;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes.dex */
class j0 {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3350a = c.a.a(bh.aE, "e", "o", "nm", "m", "hd");

    private j0() {
    }

    static com.airbnb.lottie.y.k.q a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        String str = null;
        q.a aVar = null;
        com.airbnb.lottie.y.j.b bVar = null;
        com.airbnb.lottie.y.j.b bVar2 = null;
        com.airbnb.lottie.y.j.b bVar3 = null;
        boolean z = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3350a);
            if (a2 == 0) {
                bVar = d.a(cVar, gVar, false);
            } else if (a2 == 1) {
                bVar2 = d.a(cVar, gVar, false);
            } else if (a2 == 2) {
                bVar3 = d.a(cVar, gVar, false);
            } else if (a2 == 3) {
                str = cVar.m();
            } else if (a2 == 4) {
                aVar = q.a.forId(cVar.k());
            } else if (a2 != 5) {
                cVar.o();
            } else {
                z = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.q(str, aVar, bVar, bVar2, bVar3, z);
    }
}
