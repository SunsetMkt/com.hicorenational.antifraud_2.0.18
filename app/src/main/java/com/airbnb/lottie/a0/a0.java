package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.i;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3327a = c.a.a("nm", "sy", "pt", bh.aA, "r", "or", "os", "ir", bh.ae, "hd");

    private a0() {
    }

    static com.airbnb.lottie.y.k.i a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        String str = null;
        i.a aVar = null;
        com.airbnb.lottie.y.j.b bVar = null;
        com.airbnb.lottie.y.j.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.y.j.b bVar2 = null;
        com.airbnb.lottie.y.j.b bVar3 = null;
        com.airbnb.lottie.y.j.b bVar4 = null;
        com.airbnb.lottie.y.j.b bVar5 = null;
        com.airbnb.lottie.y.j.b bVar6 = null;
        boolean z = false;
        while (cVar.h()) {
            switch (cVar.a(f3327a)) {
                case 0:
                    str = cVar.m();
                    break;
                case 1:
                    aVar = i.a.forValue(cVar.k());
                    break;
                case 2:
                    bVar = d.a(cVar, gVar, false);
                    break;
                case 3:
                    mVar = a.b(cVar, gVar);
                    break;
                case 4:
                    bVar2 = d.a(cVar, gVar, false);
                    break;
                case 5:
                    bVar4 = d.c(cVar, gVar);
                    break;
                case 6:
                    bVar6 = d.a(cVar, gVar, false);
                    break;
                case 7:
                    bVar3 = d.c(cVar, gVar);
                    break;
                case 8:
                    bVar5 = d.a(cVar, gVar, false);
                    break;
                case 9:
                    z = cVar.i();
                    break;
                default:
                    cVar.n();
                    cVar.o();
                    break;
            }
        }
        return new com.airbnb.lottie.y.k.i(str, aVar, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
    }
}
