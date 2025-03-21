package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import com.airbnb.lottie.y.k.h;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* loaded from: classes.dex */
class w {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3423a = c.a.a("nm", "mm", "hd");

    private w() {
    }

    static com.airbnb.lottie.y.k.h a(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        String str = null;
        h.a aVar = null;
        boolean z = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3423a);
            if (a2 == 0) {
                str = cVar.m();
            } else if (a2 == 1) {
                aVar = h.a.forId(cVar.k());
            } else if (a2 != 2) {
                cVar.n();
                cVar.o();
            } else {
                z = cVar.i();
            }
        }
        return new com.airbnb.lottie.y.k.h(str, aVar, z);
    }
}
