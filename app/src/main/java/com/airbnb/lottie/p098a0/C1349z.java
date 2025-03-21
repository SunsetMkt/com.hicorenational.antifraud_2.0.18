package com.airbnb.lottie.p098a0;

import android.graphics.PointF;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import java.io.IOException;

/* compiled from: PointFParser.java */
/* renamed from: com.airbnb.lottie.a0.z */
/* loaded from: classes.dex */
public class C1349z implements InterfaceC1326k0<PointF> {

    /* renamed from: a */
    public static final C1349z f3129a = new C1349z();

    private C1349z() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p098a0.InterfaceC1326k0
    /* renamed from: a */
    public PointF mo2679a(AbstractC1330c abstractC1330c, float f2) throws IOException {
        AbstractC1330c.b peek = abstractC1330c.peek();
        if (peek == AbstractC1330c.b.BEGIN_ARRAY) {
            return C1339p.m2750d(abstractC1330c, f2);
        }
        if (peek == AbstractC1330c.b.BEGIN_OBJECT) {
            return C1339p.m2750d(abstractC1330c, f2);
        }
        if (peek == AbstractC1330c.b.NUMBER) {
            PointF pointF = new PointF(((float) abstractC1330c.mo2704j()) * f2, ((float) abstractC1330c.mo2704j()) * f2);
            while (abstractC1330c.mo2702h()) {
                abstractC1330c.mo2709o();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
    }
}
