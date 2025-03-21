package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3328a = c.a.a("a");

    /* renamed from: b, reason: collision with root package name */
    private static c.a f3329b = c.a.a("fc", "sc", "sw", "t");

    private b() {
    }

    public static com.airbnb.lottie.y.j.k a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        cVar.d();
        com.airbnb.lottie.y.j.k kVar = null;
        while (cVar.h()) {
            if (cVar.a(f3328a) != 0) {
                cVar.n();
                cVar.o();
            } else {
                kVar = b(cVar, gVar);
            }
        }
        cVar.f();
        return kVar == null ? new com.airbnb.lottie.y.j.k(null, null, null, null) : kVar;
    }

    private static com.airbnb.lottie.y.j.k b(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        cVar.d();
        com.airbnb.lottie.y.j.a aVar = null;
        com.airbnb.lottie.y.j.a aVar2 = null;
        com.airbnb.lottie.y.j.b bVar = null;
        com.airbnb.lottie.y.j.b bVar2 = null;
        while (cVar.h()) {
            int a2 = cVar.a(f3329b);
            if (a2 == 0) {
                aVar = d.a(cVar, gVar);
            } else if (a2 == 1) {
                aVar2 = d.a(cVar, gVar);
            } else if (a2 == 2) {
                bVar = d.c(cVar, gVar);
            } else if (a2 != 3) {
                cVar.n();
                cVar.o();
            } else {
                bVar2 = d.c(cVar, gVar);
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.j.k(aVar, aVar2, bVar, bVar2);
    }
}
