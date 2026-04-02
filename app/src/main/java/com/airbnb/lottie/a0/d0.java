package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* JADX INFO: compiled from: ScaleXYParser.java */
/* JADX INFO: loaded from: classes.dex */
public class d0 implements k0<com.airbnb.lottie.c0.k> {
    public static final d0 a = new d0();

    private d0() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public com.airbnb.lottie.c0.k a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        boolean z = cVar.peek() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.c();
        }
        float fJ = (float) cVar.j();
        float fJ2 = (float) cVar.j();
        while (cVar.h()) {
            cVar.o();
        }
        if (z) {
            cVar.e();
        }
        return new com.airbnb.lottie.c0.k((fJ / 100.0f) * f2, (fJ2 / 100.0f) * f2);
    }
}
