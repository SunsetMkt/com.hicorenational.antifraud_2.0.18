package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3330a = c.a.a("nm", bh.aA, bh.aE, "r", "hd");

    private b0() {
    }

    static com.airbnb.lottie.y.k.j a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        String str = null;
        com.airbnb.lottie.y.j.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.y.j.f fVar = null;
        com.airbnb.lottie.y.j.b bVar = null;
        boolean z = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3330a);
            if (a2 == 0) {
                str = cVar.m();
            } else if (a2 == 1) {
                mVar = a.b(cVar, gVar);
            } else if (a2 == 2) {
                fVar = d.e(cVar, gVar);
            } else if (a2 == 3) {
                bVar = d.c(cVar, gVar);
            } else if (a2 != 4) {
                cVar.o();
            } else {
                z = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.j(str, mVar, fVar, bVar, z);
    }
}
