package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p106y.p107j.C1444a;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1447d;
import com.airbnb.lottie.p106y.p108k.C1474p;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: ShapeStrokeParser.java */
/* renamed from: com.airbnb.lottie.a0.i0 */
/* loaded from: classes.dex */
class C1322i0 {

    /* renamed from: a */
    private static AbstractC1330c.a f3017a = AbstractC1330c.a.m2710a("nm", C3351bh.f11584aI, "w", "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b */
    private static final AbstractC1330c.a f3018b = AbstractC1330c.a.m2710a("n", "v");

    private C1322i0() {
    }

    /* renamed from: a */
    static C1474p m2685a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        char c2;
        ArrayList arrayList = new ArrayList();
        C1447d c1447d = null;
        String str = null;
        C1445b c1445b = null;
        C1444a c1444a = null;
        C1445b c1445b2 = null;
        C1474p.b bVar = null;
        C1474p.c cVar = null;
        float f2 = 0.0f;
        boolean z = false;
        while (true) {
            int i2 = 100;
            if (!abstractC1330c.mo2702h()) {
                return new C1474p(str, c1445b, arrayList, c1444a, c1447d == null ? new C1447d(Collections.singletonList(new C1361a(100))) : c1447d, c1445b2, bVar, cVar, f2, z);
            }
            int i3 = 1;
            switch (abstractC1330c.mo2694a(f3017a)) {
                case 0:
                    str = abstractC1330c.mo2707m();
                    break;
                case 1:
                    c1444a = C1311d.m2668a(abstractC1330c, c1376g);
                    break;
                case 2:
                    c1445b2 = C1311d.m2674c(abstractC1330c, c1376g);
                    break;
                case 3:
                    c1447d = C1311d.m2675d(abstractC1330c, c1376g);
                    break;
                case 4:
                    bVar = C1474p.b.values()[abstractC1330c.mo2705k() - 1];
                    break;
                case 5:
                    cVar = C1474p.c.values()[abstractC1330c.mo2705k() - 1];
                    break;
                case 6:
                    f2 = (float) abstractC1330c.mo2704j();
                    break;
                case 7:
                    z = abstractC1330c.mo2703i();
                    break;
                case 8:
                    abstractC1330c.mo2697c();
                    while (abstractC1330c.mo2702h()) {
                        abstractC1330c.mo2698d();
                        C1445b c1445b3 = null;
                        String str2 = null;
                        while (abstractC1330c.mo2702h()) {
                            int mo2694a = abstractC1330c.mo2694a(f3018b);
                            if (mo2694a == 0) {
                                str2 = abstractC1330c.mo2707m();
                            } else if (mo2694a != i3) {
                                abstractC1330c.mo2708n();
                                abstractC1330c.mo2709o();
                            } else {
                                c1445b3 = C1311d.m2674c(abstractC1330c, c1376g);
                            }
                        }
                        abstractC1330c.mo2700f();
                        int hashCode = str2.hashCode();
                        if (hashCode == i2) {
                            if (str2.equals("d")) {
                                c2 = 1;
                            }
                            c2 = 65535;
                        } else if (hashCode != 103) {
                            if (hashCode == 111 && str2.equals("o")) {
                                c2 = 0;
                            }
                            c2 = 65535;
                        } else {
                            if (str2.equals("g")) {
                                c2 = 2;
                            }
                            c2 = 65535;
                        }
                        if (c2 == 0) {
                            c1445b = c1445b3;
                        } else if (c2 == 1 || c2 == 2) {
                            c1376g.m2893a(true);
                            arrayList.add(c1445b3);
                        }
                        i2 = 100;
                        i3 = 1;
                    }
                    abstractC1330c.mo2699e();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                default:
                    abstractC1330c.mo2709o();
                    break;
            }
        }
    }
}
