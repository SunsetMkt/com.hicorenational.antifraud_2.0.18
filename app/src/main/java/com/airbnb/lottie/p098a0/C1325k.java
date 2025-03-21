package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.C1437c;
import java.io.IOException;

/* compiled from: FontParser.java */
/* renamed from: com.airbnb.lottie.a0.k */
/* loaded from: classes.dex */
class C1325k {

    /* renamed from: a */
    private static final AbstractC1330c.a f3022a = AbstractC1330c.a.m2710a("fFamily", "fName", "fStyle", "ascent");

    private C1325k() {
    }

    /* renamed from: a */
    static C1437c m2688a(AbstractC1330c abstractC1330c) throws IOException {
        abstractC1330c.mo2698d();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3022a);
            if (mo2694a == 0) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 1) {
                str2 = abstractC1330c.mo2707m();
            } else if (mo2694a == 2) {
                str3 = abstractC1330c.mo2707m();
            } else if (mo2694a != 3) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                f2 = (float) abstractC1330c.mo2704j();
            }
        }
        abstractC1330c.mo2700f();
        return new C1437c(str, str2, str3, f2);
    }
}
