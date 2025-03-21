package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.p;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3402a = c.a.a("nm", "g", "o", "t", bh.aE, "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3403b = c.a.a(bh.aA, "k");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f3404c = c.a.a("n", "v");

    private n() {
    }

    static com.airbnb.lottie.y.k.e a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        com.airbnb.lottie.y.j.c cVar2;
        ArrayList arrayList = new ArrayList();
        com.airbnb.lottie.y.j.d dVar = null;
        String str = null;
        com.airbnb.lottie.y.k.f fVar = null;
        com.airbnb.lottie.y.j.c cVar3 = null;
        com.airbnb.lottie.y.j.f fVar2 = null;
        com.airbnb.lottie.y.j.f fVar3 = null;
        com.airbnb.lottie.y.j.b bVar = null;
        p.b bVar2 = null;
        p.c cVar4 = null;
        float f2 = 0.0f;
        com.airbnb.lottie.y.j.b bVar3 = null;
        boolean z = false;
        while (cVar.h()) {
            switch (cVar.a(f3402a)) {
                case 0:
                    str = cVar.m();
                    break;
                case 1:
                    int i2 = -1;
                    cVar.d();
                    while (cVar.h()) {
                        int a2 = cVar.a(f3403b);
                        if (a2 != 0) {
                            cVar2 = cVar3;
                            if (a2 != 1) {
                                cVar.n();
                                cVar.o();
                            } else {
                                cVar3 = d.a(cVar, gVar, i2);
                            }
                        } else {
                            cVar2 = cVar3;
                            i2 = cVar.k();
                        }
                        cVar3 = cVar2;
                    }
                    cVar.f();
                    break;
                case 2:
                    dVar = d.d(cVar, gVar);
                    break;
                case 3:
                    fVar = cVar.k() == 1 ? com.airbnb.lottie.y.k.f.LINEAR : com.airbnb.lottie.y.k.f.RADIAL;
                    break;
                case 4:
                    fVar2 = d.e(cVar, gVar);
                    break;
                case 5:
                    fVar3 = d.e(cVar, gVar);
                    break;
                case 6:
                    bVar = d.c(cVar, gVar);
                    break;
                case 7:
                    bVar2 = p.b.values()[cVar.k() - 1];
                    break;
                case 8:
                    cVar4 = p.c.values()[cVar.k() - 1];
                    break;
                case 9:
                    f2 = (float) cVar.j();
                    break;
                case 10:
                    z = cVar.i();
                    break;
                case 11:
                    cVar.c();
                    while (cVar.h()) {
                        cVar.d();
                        String str2 = null;
                        com.airbnb.lottie.y.j.b bVar4 = null;
                        while (cVar.h()) {
                            int a3 = cVar.a(f3404c);
                            if (a3 != 0) {
                                com.airbnb.lottie.y.j.b bVar5 = bVar3;
                                if (a3 != 1) {
                                    cVar.n();
                                    cVar.o();
                                } else {
                                    bVar4 = d.c(cVar, gVar);
                                }
                                bVar3 = bVar5;
                            } else {
                                str2 = cVar.m();
                            }
                        }
                        com.airbnb.lottie.y.j.b bVar6 = bVar3;
                        cVar.f();
                        if (str2.equals("o")) {
                            bVar3 = bVar4;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                gVar.a(true);
                                arrayList.add(bVar4);
                            }
                            bVar3 = bVar6;
                        }
                    }
                    com.airbnb.lottie.y.j.b bVar7 = bVar3;
                    cVar.e();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar3 = bVar7;
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new com.airbnb.lottie.y.j.d(Collections.singletonList(new com.airbnb.lottie.c0.a(100)));
        }
        return new com.airbnb.lottie.y.k.e(str, fVar, cVar3, dVar, fVar2, fVar3, bVar, bVar2, cVar4, f2, arrayList, bVar3, z);
    }
}
