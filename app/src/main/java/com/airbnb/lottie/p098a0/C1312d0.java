package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p101c0.C1371k;
import java.io.IOException;

/* compiled from: ScaleXYParser.java */
/* renamed from: com.airbnb.lottie.a0.d0 */
/* loaded from: classes.dex */
public class C1312d0 implements InterfaceC1326k0<C1371k> {

    /* renamed from: a */
    public static final C1312d0 f3005a = new C1312d0();

    private C1312d0() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p098a0.InterfaceC1326k0
    /* renamed from: a */
    public C1371k mo2679a(AbstractC1330c abstractC1330c, float f2) throws IOException {
        boolean z = abstractC1330c.peek() == AbstractC1330c.b.BEGIN_ARRAY;
        if (z) {
            abstractC1330c.mo2697c();
        }
        float mo2704j = (float) abstractC1330c.mo2704j();
        float mo2704j2 = (float) abstractC1330c.mo2704j();
        while (abstractC1330c.mo2702h()) {
            abstractC1330c.mo2709o();
        }
        if (z) {
            abstractC1330c.mo2699e();
        }
        return new C1371k((mo2704j / 100.0f) * f2, (mo2704j2 / 100.0f) * f2);
    }
}
