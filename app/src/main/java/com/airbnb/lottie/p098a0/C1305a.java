package com.airbnb.lottie.p098a0;

import android.graphics.PointF;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1358h;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.C1448e;
import com.airbnb.lottie.p106y.p107j.C1452i;
import com.airbnb.lottie.p106y.p107j.InterfaceC1456m;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: AnimatablePathValueParser.java */
/* renamed from: com.airbnb.lottie.a0.a */
/* loaded from: classes.dex */
public class C1305a {

    /* renamed from: a */
    private static final AbstractC1330c.a f2997a = AbstractC1330c.a.m2710a("k", "x", "y");

    private C1305a() {
    }

    /* renamed from: a */
    public static C1448e m2654a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (abstractC1330c.peek() == AbstractC1330c.b.BEGIN_ARRAY) {
            abstractC1330c.mo2697c();
            while (abstractC1330c.mo2702h()) {
                arrayList.add(C1347x.m2774a(abstractC1330c, c1376g));
            }
            abstractC1330c.mo2699e();
            C1341r.m2761a(arrayList);
        } else {
            arrayList.add(new C1361a(C1339p.m2750d(abstractC1330c, C1358h.m2832a())));
        }
        return new C1448e(arrayList);
    }

    /* renamed from: b */
    static InterfaceC1456m<PointF, PointF> m2655b(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        abstractC1330c.mo2698d();
        C1448e c1448e = null;
        boolean z = false;
        C1445b c1445b = null;
        C1445b c1445b2 = null;
        while (abstractC1330c.peek() != AbstractC1330c.b.END_OBJECT) {
            int mo2694a = abstractC1330c.mo2694a(f2997a);
            if (mo2694a == 0) {
                c1448e = m2654a(abstractC1330c, c1376g);
            } else if (mo2694a != 1) {
                if (mo2694a != 2) {
                    abstractC1330c.mo2708n();
                    abstractC1330c.mo2709o();
                } else if (abstractC1330c.peek() == AbstractC1330c.b.STRING) {
                    abstractC1330c.mo2709o();
                    z = true;
                } else {
                    c1445b2 = C1311d.m2674c(abstractC1330c, c1376g);
                }
            } else if (abstractC1330c.peek() == AbstractC1330c.b.STRING) {
                abstractC1330c.mo2709o();
                z = true;
            } else {
                c1445b = C1311d.m2674c(abstractC1330c, c1376g);
            }
        }
        abstractC1330c.mo2700f();
        if (z) {
            c1376g.m2892a("Lottie doesn't support expressions.");
        }
        return c1448e != null ? c1448e : new C1452i(c1445b, c1445b2);
    }
}
