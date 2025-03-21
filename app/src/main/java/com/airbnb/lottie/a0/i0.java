package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.p;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ShapeStrokeParser.java */
/* loaded from: classes.dex */
class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3346a = c.a.a("nm", bh.aI, "w", "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3347b = c.a.a("n", "v");

    private i0() {
    }

    static com.airbnb.lottie.y.k.p a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        char c2;
        ArrayList arrayList = new ArrayList();
        com.airbnb.lottie.y.j.d dVar = null;
        String str = null;
        com.airbnb.lottie.y.j.b bVar = null;
        com.airbnb.lottie.y.j.a aVar = null;
        com.airbnb.lottie.y.j.b bVar2 = null;
        p.b bVar3 = null;
        p.c cVar2 = null;
        float f2 = 0.0f;
        boolean z = false;
        while (true) {
            int i2 = 100;
            if (!cVar.h()) {
                return new com.airbnb.lottie.y.k.p(str, bVar, arrayList, aVar, dVar == null ? new com.airbnb.lottie.y.j.d(Collections.singletonList(new com.airbnb.lottie.c0.a(100))) : dVar, bVar2, bVar3, cVar2, f2, z);
            }
            int i3 = 1;
            switch (cVar.a(f3346a)) {
                case 0:
                    str = cVar.m();
                    break;
                case 1:
                    aVar = d.a(cVar, gVar);
                    break;
                case 2:
                    bVar2 = d.c(cVar, gVar);
                    break;
                case 3:
                    dVar = d.d(cVar, gVar);
                    break;
                case 4:
                    bVar3 = p.b.values()[cVar.k() - 1];
                    break;
                case 5:
                    cVar2 = p.c.values()[cVar.k() - 1];
                    break;
                case 6:
                    f2 = (float) cVar.j();
                    break;
                case 7:
                    z = cVar.i();
                    break;
                case 8:
                    cVar.c();
                    while (cVar.h()) {
                        cVar.d();
                        com.airbnb.lottie.y.j.b bVar4 = null;
                        String str2 = null;
                        while (cVar.h()) {
                            int a2 = cVar.a(f3347b);
                            if (a2 == 0) {
                                str2 = cVar.m();
                            } else if (a2 != i3) {
                                cVar.n();
                                cVar.o();
                            } else {
                                bVar4 = d.c(cVar, gVar);
                            }
                        }
                        cVar.f();
                        int hashCode = str2.hashCode();
                        if (hashCode == i2) {
                            if (str2.equals("d")) {
                                c2 = 1;
                            }
                            c2 = 65535;
                        } else if (hashCode != 103) {
                            if (hashCode == 111 && str2.equals("o")) {
                                c2 = 0;
                            }
                            c2 = 65535;
                        } else {
                            if (str2.equals("g")) {
                                c2 = 2;
                            }
                            c2 = 65535;
                        }
                        if (c2 == 0) {
                            bVar = bVar4;
                        } else if (c2 == 1 || c2 == 2) {
                            gVar.a(true);
                            arrayList.add(bVar4);
                        }
                        i2 = 100;
                        i3 = 1;
                    }
                    cVar.e();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                default:
                    cVar.o();
                    break;
            }
        }
    }
}
