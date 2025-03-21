package com.airbnb.lottie.a0;

import android.graphics.Path;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.Collections;

/* compiled from: GradientFillParser.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3400a = c.a.a("nm", "g", "o", "t", bh.aE, "e", "r", "hd");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3401b = c.a.a(bh.aA, "k");

    private m() {
    }

    static com.airbnb.lottie.y.k.d a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        com.airbnb.lottie.y.j.d dVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        com.airbnb.lottie.y.k.f fVar = null;
        com.airbnb.lottie.y.j.c cVar2 = null;
        com.airbnb.lottie.y.j.f fVar2 = null;
        com.airbnb.lottie.y.j.f fVar3 = null;
        boolean z = false;
        while (cVar.h()) {
            switch (cVar.a(f3400a)) {
                case 0:
                    str = cVar.m();
                    break;
                case 1:
                    int i2 = -1;
                    cVar.d();
                    while (cVar.h()) {
                        int a2 = cVar.a(f3401b);
                        if (a2 == 0) {
                            i2 = cVar.k();
                        } else if (a2 != 1) {
                            cVar.n();
                            cVar.o();
                        } else {
                            cVar2 = d.a(cVar, gVar, i2);
                        }
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
                    fillType = cVar.k() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = cVar.i();
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
        return new com.airbnb.lottie.y.k.d(str, fVar, fillType, cVar2, dVar, fVar2, fVar3, null, null, z);
    }
}
