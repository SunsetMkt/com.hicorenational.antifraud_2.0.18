package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.p107j.C1444a;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1454k;
import java.io.IOException;

/* compiled from: AnimatableTextPropertiesParser.java */
/* renamed from: com.airbnb.lottie.a0.b */
/* loaded from: classes.dex */
public class C1307b {

    /* renamed from: a */
    private static AbstractC1330c.a f2999a = AbstractC1330c.a.m2710a("a");

    /* renamed from: b */
    private static AbstractC1330c.a f3000b = AbstractC1330c.a.m2710a("fc", "sc", "sw", "t");

    private C1307b() {
    }

    /* renamed from: a */
    public static C1454k m2657a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        abstractC1330c.mo2698d();
        C1454k c1454k = null;
        while (abstractC1330c.mo2702h()) {
            if (abstractC1330c.mo2694a(f2999a) != 0) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                c1454k = m2658b(abstractC1330c, c1376g);
            }
        }
        abstractC1330c.mo2700f();
        return c1454k == null ? new C1454k(null, null, null, null) : c1454k;
    }

    /* renamed from: b */
    private static C1454k m2658b(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        abstractC1330c.mo2698d();
        C1444a c1444a = null;
        C1444a c1444a2 = null;
        C1445b c1445b = null;
        C1445b c1445b2 = null;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3000b);
            if (mo2694a == 0) {
                c1444a = C1311d.m2668a(abstractC1330c, c1376g);
            } else if (mo2694a == 1) {
                c1444a2 = C1311d.m2668a(abstractC1330c, c1376g);
            } else if (mo2694a == 2) {
                c1445b = C1311d.m2674c(abstractC1330c, c1376g);
            } else if (mo2694a != 3) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                c1445b2 = C1311d.m2674c(abstractC1330c, c1376g);
            }
        }
        abstractC1330c.mo2700f();
        return new C1454k(c1444a, c1444a2, c1445b, c1445b2);
    }
}
