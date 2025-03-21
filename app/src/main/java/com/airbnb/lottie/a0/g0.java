package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser.java */
/* loaded from: classes.dex */
class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3341a = c.a.a("nm", "hd", "it");

    private g0() {
    }

    static com.airbnb.lottie.y.k.n a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3341a);
            if (a2 == 0) {
                str = cVar.m();
            } else if (a2 == 1) {
                z = cVar.i();
            } else if (a2 != 2) {
                cVar.o();
            } else {
                cVar.c();
                while (cVar.h()) {
                    com.airbnb.lottie.y.k.b a3 = g.a(cVar, gVar);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
                cVar.e();
            }
        }
        return new com.airbnb.lottie.y.k.n(str, arrayList, z);
    }
}
