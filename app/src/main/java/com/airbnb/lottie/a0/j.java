package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3348a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3349b = c.a.a("shapes");

    private j() {
    }

    static com.airbnb.lottie.y.d a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.d();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        char c2 = 0;
        while (cVar.h()) {
            int a2 = cVar.a(f3348a);
            if (a2 == 0) {
                c2 = cVar.m().charAt(0);
            } else if (a2 == 1) {
                d2 = cVar.j();
            } else if (a2 == 2) {
                d3 = cVar.j();
            } else if (a2 == 3) {
                str = cVar.m();
            } else if (a2 == 4) {
                str2 = cVar.m();
            } else if (a2 != 5) {
                cVar.n();
                cVar.o();
            } else {
                cVar.d();
                while (cVar.h()) {
                    if (cVar.a(f3349b) != 0) {
                        cVar.n();
                        cVar.o();
                    } else {
                        cVar.c();
                        while (cVar.h()) {
                            arrayList.add((com.airbnb.lottie.y.k.n) g.a(cVar, gVar));
                        }
                        cVar.e();
                    }
                }
                cVar.f();
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.d(arrayList, c2, d2, d3, str, str2);
    }
}
