package com.airbnb.lottie.p098a0;

import android.graphics.Path;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p106y.p107j.C1446c;
import com.airbnb.lottie.p106y.p107j.C1447d;
import com.airbnb.lottie.p106y.p107j.C1449f;
import com.airbnb.lottie.p106y.p108k.C1462d;
import com.airbnb.lottie.p106y.p108k.EnumC1464f;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.util.Collections;

/* compiled from: GradientFillParser.java */
/* renamed from: com.airbnb.lottie.a0.m */
/* loaded from: classes.dex */
class C1335m {

    /* renamed from: a */
    private static final AbstractC1330c.a f3104a = AbstractC1330c.a.m2710a("nm", "g", "o", "t", C3351bh.f11580aE, "e", "r", "hd");

    /* renamed from: b */
    private static final AbstractC1330c.a f3105b = AbstractC1330c.a.m2710a(C3351bh.f11576aA, "k");

    private C1335m() {
    }

    /* renamed from: a */
    static C1462d m2743a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        C1447d c1447d = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        EnumC1464f enumC1464f = null;
        C1446c c1446c = null;
        C1449f c1449f = null;
        C1449f c1449f2 = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            switch (abstractC1330c.mo2694a(f3104a)) {
                case 0:
                    str = abstractC1330c.mo2707m();
                    break;
                case 1:
                    int i2 = -1;
                    abstractC1330c.mo2698d();
                    while (abstractC1330c.mo2702h()) {
                        int mo2694a = abstractC1330c.mo2694a(f3105b);
                        if (mo2694a == 0) {
                            i2 = abstractC1330c.mo2705k();
                        } else if (mo2694a != 1) {
                            abstractC1330c.mo2708n();
                            abstractC1330c.mo2709o();
                        } else {
                            c1446c = C1311d.m2670a(abstractC1330c, c1376g, i2);
                        }
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
                    fillType = abstractC1330c.mo2705k() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = abstractC1330c.mo2703i();
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
        return new C1462d(str, enumC1464f, fillType, c1446c, c1447d, c1449f, c1449f2, null, null, z);
    }
}
