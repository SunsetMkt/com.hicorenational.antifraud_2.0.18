package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* compiled from: ShapePathParser.java */
/* loaded from: classes.dex */
class h0 {

    /* renamed from: a, reason: collision with root package name */
    static c.a f3344a = c.a.a("nm", "ind", "ks", "hd");

    private h0() {
    }

    static com.airbnb.lottie.y.k.o a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        int i2 = 0;
        String str = null;
        com.airbnb.lottie.y.j.h hVar = null;
        boolean z = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3344a);
            if (a2 == 0) {
                str = cVar.m();
            } else if (a2 == 1) {
                i2 = cVar.k();
            } else if (a2 == 2) {
                hVar = d.g(cVar, gVar);
            } else if (a2 != 3) {
                cVar.o();
            } else {
                z = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.o(str, i2, hVar, z);
    }
}
