package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.p108k.C1466h;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* renamed from: com.airbnb.lottie.a0.w */
/* loaded from: classes.dex */
class C1346w {

    /* renamed from: a */
    private static final AbstractC1330c.a f3127a = AbstractC1330c.a.m2710a("nm", "mm", "hd");

    private C1346w() {
    }

    /* renamed from: a */
    static C1466h m2773a(AbstractC1330c abstractC1330c) throws IOException {
        String str = null;
        C1466h.a aVar = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3127a);
            if (mo2694a == 0) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 1) {
                aVar = C1466h.a.forId(abstractC1330c.mo2705k());
            } else if (mo2694a != 2) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                z = abstractC1330c.mo2703i();
            }
        }
        return new C1466h(str, aVar, z);
    }
}
