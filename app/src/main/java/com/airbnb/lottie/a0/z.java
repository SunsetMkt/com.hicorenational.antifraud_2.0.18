package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;

/* JADX INFO: compiled from: PointFParser.java */
/* JADX INFO: loaded from: classes.dex */
public class z implements k0<PointF> {
    public static final z a = new z();

    private z() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public PointF a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        c.b bVarPeek = cVar.peek();
        if (bVarPeek == c.b.BEGIN_ARRAY) {
            return p.d(cVar, f2);
        }
        if (bVarPeek == c.b.BEGIN_OBJECT) {
            return p.d(cVar, f2);
        }
        if (bVarPeek == c.b.NUMBER) {
            PointF pointF = new PointF(((float) cVar.j()) * f2, ((float) cVar.j()) * f2);
            while (cVar.h()) {
                cVar.o();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + bVarPeek);
    }
}
