package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3326a = c.a.a("k", "x", "y");

    private a() {
    }

    public static com.airbnb.lottie.y.j.e a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.peek() == c.b.BEGIN_ARRAY) {
            cVar.c();
            while (cVar.h()) {
                arrayList.add(x.a(cVar, gVar));
            }
            cVar.e();
            r.a(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.c0.a(p.d(cVar, com.airbnb.lottie.b0.h.a())));
        }
        return new com.airbnb.lottie.y.j.e(arrayList);
    }

    static com.airbnb.lottie.y.j.m<PointF, PointF> b(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar) throws IOException {
        cVar.d();
        com.airbnb.lottie.y.j.e eVar = null;
        boolean z = false;
        com.airbnb.lottie.y.j.b bVar = null;
        com.airbnb.lottie.y.j.b bVar2 = null;
        while (cVar.peek() != c.b.END_OBJECT) {
            int a2 = cVar.a(f3326a);
            if (a2 == 0) {
                eVar = a(cVar, gVar);
            } else if (a2 != 1) {
                if (a2 != 2) {
                    cVar.n();
                    cVar.o();
                } else if (cVar.peek() == c.b.STRING) {
                    cVar.o();
                    z = true;
                } else {
                    bVar2 = d.c(cVar, gVar);
                }
            } else if (cVar.peek() == c.b.STRING) {
                cVar.o();
                z = true;
            } else {
                bVar = d.c(cVar, gVar);
            }
        }
        cVar.f();
        if (z) {
            gVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new com.airbnb.lottie.y.j.i(bVar, bVar2);
    }
}
