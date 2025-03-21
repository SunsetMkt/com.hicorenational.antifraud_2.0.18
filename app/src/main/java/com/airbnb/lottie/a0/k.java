package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* compiled from: FontParser.java */
/* loaded from: classes.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f3351a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    private k() {
    }

    static com.airbnb.lottie.y.c a(com.airbnb.lottie.a0.l0.c cVar) throws IOException {
        cVar.d();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (cVar.h()) {
            int a2 = cVar.a(f3351a);
            if (a2 == 0) {
                str = cVar.m();
            } else if (a2 == 1) {
                str2 = cVar.m();
            } else if (a2 == 2) {
                str3 = cVar.m();
            } else if (a2 != 3) {
                cVar.n();
                cVar.o();
            } else {
                f2 = (float) cVar.j();
            }
        }
        cVar.f();
        return new com.airbnb.lottie.y.c(str, str2, str3, f2);
    }
}
