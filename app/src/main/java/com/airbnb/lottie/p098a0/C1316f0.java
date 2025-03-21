package com.airbnb.lottie.p098a0;

import android.graphics.Path;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p106y.p107j.C1444a;
import com.airbnb.lottie.p106y.p107j.C1447d;
import com.airbnb.lottie.p106y.p108k.C1471m;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.util.Collections;

/* compiled from: ShapeFillParser.java */
/* renamed from: com.airbnb.lottie.a0.f0 */
/* loaded from: classes.dex */
class C1316f0 {

    /* renamed from: a */
    private static final AbstractC1330c.a f3010a = AbstractC1330c.a.m2710a("nm", C3351bh.f11584aI, "o", "fillEnabled", "r", "hd");

    private C1316f0() {
    }

    /* renamed from: a */
    static C1471m m2681a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        C1447d c1447d = null;
        String str = null;
        C1444a c1444a = null;
        int i2 = 1;
        boolean z = false;
        boolean z2 = false;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3010a);
            if (mo2694a == 0) {
                str = abstractC1330c.mo2707m();
            } else if (mo2694a == 1) {
                c1444a = C1311d.m2668a(abstractC1330c, c1376g);
            } else if (mo2694a == 2) {
                c1447d = C1311d.m2675d(abstractC1330c, c1376g);
            } else if (mo2694a == 3) {
                z = abstractC1330c.mo2703i();
            } else if (mo2694a == 4) {
                i2 = abstractC1330c.mo2705k();
            } else if (mo2694a != 5) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                z2 = abstractC1330c.mo2703i();
            }
        }
        if (c1447d == null) {
            c1447d = new C1447d(Collections.singletonList(new C1361a(100)));
        }
        return new C1471m(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, c1444a, c1447d, z2);
    }
}
