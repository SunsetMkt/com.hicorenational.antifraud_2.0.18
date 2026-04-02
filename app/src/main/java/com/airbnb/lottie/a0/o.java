package com.airbnb.lottie.a0;

import java.io.IOException;

/* JADX INFO: compiled from: IntegerParser.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements k0<Integer> {
    public static final o a = new o();

    private o() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public Integer a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        return Integer.valueOf(Math.round(p.b(cVar) * f2));
    }
}
