package com.airbnb.lottie.p098a0;

import android.graphics.Color;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import java.io.IOException;

/* compiled from: ColorParser.java */
/* renamed from: com.airbnb.lottie.a0.f */
/* loaded from: classes.dex */
public class C1315f implements InterfaceC1326k0<Integer> {

    /* renamed from: a */
    public static final C1315f f3009a = new C1315f();

    private C1315f() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p098a0.InterfaceC1326k0
    /* renamed from: a */
    public Integer mo2679a(AbstractC1330c abstractC1330c, float f2) throws IOException {
        boolean z = abstractC1330c.peek() == AbstractC1330c.b.BEGIN_ARRAY;
        if (z) {
            abstractC1330c.mo2697c();
        }
        double mo2704j = abstractC1330c.mo2704j();
        double mo2704j2 = abstractC1330c.mo2704j();
        double mo2704j3 = abstractC1330c.mo2704j();
        double mo2704j4 = abstractC1330c.peek() == AbstractC1330c.b.NUMBER ? abstractC1330c.mo2704j() : 1.0d;
        if (z) {
            abstractC1330c.mo2699e();
        }
        if (mo2704j <= 1.0d && mo2704j2 <= 1.0d && mo2704j3 <= 1.0d) {
            mo2704j *= 255.0d;
            mo2704j2 *= 255.0d;
            mo2704j3 *= 255.0d;
            if (mo2704j4 <= 1.0d) {
                mo2704j4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) mo2704j4, (int) mo2704j, (int) mo2704j2, (int) mo2704j3));
    }
}
