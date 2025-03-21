package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1446c;
import com.airbnb.lottie.p106y.p107j.C1447d;
import com.airbnb.lottie.p106y.p107j.C1449f;
import com.airbnb.lottie.p106y.p108k.C1463e;
import com.airbnb.lottie.p106y.p108k.C1474p;
import com.airbnb.lottie.p106y.p108k.EnumC1464f;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: GradientStrokeParser.java */
/* renamed from: com.airbnb.lottie.a0.n */
/* loaded from: classes.dex */
class C1337n {

    /* renamed from: a */
    private static AbstractC1330c.a f3106a = AbstractC1330c.a.m2710a("nm", "g", "o", "t", C3351bh.f11580aE, "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b */
    private static final AbstractC1330c.a f3107b = AbstractC1330c.a.m2710a(C3351bh.f11576aA, "k");

    /* renamed from: c */
    private static final AbstractC1330c.a f3108c = AbstractC1330c.a.m2710a("n", "v");

    private C1337n() {
    }

    /* renamed from: a */
    static C1463e m2744a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        C1446c c1446c;
        ArrayList arrayList = new ArrayList();
        C1447d c1447d = null;
        String str = null;
        EnumC1464f enumC1464f = null;
        C1446c c1446c2 = null;
        C1449f c1449f = null;
        C1449f c1449f2 = null;
        C1445b c1445b = null;
        C1474p.b bVar = null;
        C1474p.c cVar = null;
        float f2 = 0.0f;
        C1445b c1445b2 = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            switch (abstractC1330c.mo2694a(f3106a)) {
                case 0:
                    str = abstractC1330c.mo2707m();
                    break;
                case 1:
                    int i2 = -1;
                    abstractC1330c.mo2698d();
                    while (abstractC1330c.mo2702h()) {
                        int mo2694a = abstractC1330c.mo2694a(f3107b);
                        if (mo2694a != 0) {
                            c1446c = c1446c2;
                            if (mo2694a != 1) {
                                abstractC1330c.mo2708n();
                                abstractC1330c.mo2709o();
                            } else {
                                c1446c2 = C1311d.m2670a(abstractC1330c, c1376g, i2);
                            }
                        } else {
                            c1446c = c1446c2;
                            i2 = abstractC1330c.mo2705k();
                        }
                        c1446c2 = c1446c;
                    }
                    abstractC1330c.mo2700f();
                    break;
                case 2:
                    c1447d = C1311d.m2675d(abstractC1330c, c1376g);
                    break;
                case 3:
                    enumC1464f = abstractC1330c.mo2705k() == 1 ? EnumC1464f.LINEAR : EnumC1464f.RADIAL;
                    break;
                case 4:
                    c1449f = C1311d.m2676e(abstractC1330c, c1376g);
                    break;
                case 5:
                    c1449f2 = C1311d.m2676e(abstractC1330c, c1376g);
                    break;
                case 6:
                    c1445b = C1311d.m2674c(abstractC1330c, c1376g);
                    break;
                case 7:
                    bVar = C1474p.b.values()[abstractC1330c.mo2705k() - 1];
                    break;
                case 8:
                    cVar = C1474p.c.values()[abstractC1330c.mo2705k() - 1];
                    break;
                case 9:
                    f2 = (float) abstractC1330c.mo2704j();
                    break;
                case 10:
                    z = abstractC1330c.mo2703i();
                    break;
                case 11:
                    abstractC1330c.mo2697c();
                    while (abstractC1330c.mo2702h()) {
                        abstractC1330c.mo2698d();
                        String str2 = null;
                        C1445b c1445b3 = null;
                        while (abstractC1330c.mo2702h()) {
                            int mo2694a2 = abstractC1330c.mo2694a(f3108c);
                            if (mo2694a2 != 0) {
                                C1445b c1445b4 = c1445b2;
                                if (mo2694a2 != 1) {
                                    abstractC1330c.mo2708n();
                                    abstractC1330c.mo2709o();
                                } else {
                                    c1445b3 = C1311d.m2674c(abstractC1330c, c1376g);
                                }
                                c1445b2 = c1445b4;
                            } else {
                                str2 = abstractC1330c.mo2707m();
                            }
                        }
                        C1445b c1445b5 = c1445b2;
                        abstractC1330c.mo2700f();
                        if (str2.equals("o")) {
                            c1445b2 = c1445b3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                c1376g.m2893a(true);
                                arrayList.add(c1445b3);
                            }
                            c1445b2 = c1445b5;
                        }
                    }
                    C1445b c1445b6 = c1445b2;
                    abstractC1330c.mo2699e();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    c1445b2 = c1445b6;
                    break;
                default:
                    abstractC1330c.mo2708n();
                    abstractC1330c.mo2709o();
                    break;
            }
        }
        if (c1447d == null) {
            c1447d = new C1447d(Collections.singletonList(new C1361a(100)));
        }
        return new C1463e(str, enumC1464f, c1446c2, c1447d, c1449f, c1449f2, c1445b, bVar, cVar, f2, arrayList, c1445b2, z);
    }
}
