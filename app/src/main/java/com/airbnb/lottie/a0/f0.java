package com.airbnb.lottie.a0;

import android.graphics.Path;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.Collections;

/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
class f0 {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3339a = c.a.a("nm", bh.aI, "o", "fillEnabled", "r", "hd");

    private f0() {
    }

    static com.airbnb.lottie.y.k.m a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        com.airbnb.lottie.y.j.d dVar = null;
        String str = null;
        com.airbnb.lottie.y.j.a aVar = null;
        int i2 = 1;
        boolean z = false;
        boolean z2 = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3339a);
            if (a2 == 0) {
                str = cVar.m();
            } else if (a2 == 1) {
                aVar = d.a(cVar, gVar);
            } else if (a2 == 2) {
                dVar = d.d(cVar, gVar);
            } else if (a2 == 3) {
                z = cVar.i();
            } else if (a2 == 4) {
                i2 = cVar.k();
            } else if (a2 != 5) {
                cVar.n();
                cVar.o();
            } else {
                z2 = cVar.i();
            }
        }
        if (dVar == null) {
            dVar = new com.airbnb.lottie.y.j.d(Collections.singletonList(new com.airbnb.lottie.c0.a(100)));
        }
        return new com.airbnb.lottie.y.k.m(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar, z2);
    }
}
