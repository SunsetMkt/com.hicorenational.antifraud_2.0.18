package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;

/* compiled from: CircleShapeParser.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private static c.a f3335a = c.a.a("nm", bh.aA, bh.aE, "hd", "d");

    private e() {
    }

    static com.airbnb.lottie.y.k.a a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, int i2) throws IOException {
        boolean z = i2 == 3;
        String str = null;
        com.airbnb.lottie.y.j.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.y.j.f fVar = null;
        boolean z2 = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3335a);
            if (a2 == 0) {
                str = cVar.m();
            } else if (a2 == 1) {
                mVar = a.b(cVar, gVar);
            } else if (a2 == 2) {
                fVar = d.e(cVar, gVar);
            } else if (a2 == 3) {
                z2 = cVar.i();
            } else if (a2 != 4) {
                cVar.n();
                cVar.o();
            } else {
                z = cVar.k() == 3;
            }
        }
        return new com.airbnb.lottie.y.k.a(str, mVar, fVar, z, z2);
    }
}
