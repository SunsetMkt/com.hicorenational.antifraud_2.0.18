package com.airbnb.lottie.p098a0;

import android.graphics.PointF;
import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p106y.p107j.C1445b;
import com.airbnb.lottie.p106y.p107j.InterfaceC1456m;
import com.airbnb.lottie.p106y.p108k.C1467i;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;

/* compiled from: PolystarShapeParser.java */
/* renamed from: com.airbnb.lottie.a0.a0 */
/* loaded from: classes.dex */
class C1306a0 {

    /* renamed from: a */
    private static final AbstractC1330c.a f2998a = AbstractC1330c.a.m2710a("nm", "sy", "pt", C3351bh.f11576aA, "r", "or", "os", "ir", C3351bh.f11606ae, "hd");

    private C1306a0() {
    }

    /* renamed from: a */
    static C1467i m2656a(AbstractC1330c abstractC1330c, C1376g c1376g) throws IOException {
        String str = null;
        C1467i.a aVar = null;
        C1445b c1445b = null;
        InterfaceC1456m<PointF, PointF> interfaceC1456m = null;
        C1445b c1445b2 = null;
        C1445b c1445b3 = null;
        C1445b c1445b4 = null;
        C1445b c1445b5 = null;
        C1445b c1445b6 = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            switch (abstractC1330c.mo2694a(f2998a)) {
                case 0:
                    str = abstractC1330c.mo2707m();
                    break;
                case 1:
                    aVar = C1467i.a.forValue(abstractC1330c.mo2705k());
                    break;
                case 2:
                    c1445b = C1311d.m2669a(abstractC1330c, c1376g, false);
                    break;
                case 3:
                    interfaceC1456m = C1305a.m2655b(abstractC1330c, c1376g);
                    break;
                case 4:
                    c1445b2 = C1311d.m2669a(abstractC1330c, c1376g, false);
                    break;
                case 5:
                    c1445b4 = C1311d.m2674c(abstractC1330c, c1376g);
                    break;
                case 6:
                    c1445b6 = C1311d.m2669a(abstractC1330c, c1376g, false);
                    break;
                case 7:
                    c1445b3 = C1311d.m2674c(abstractC1330c, c1376g);
                    break;
                case 8:
                    c1445b5 = C1311d.m2669a(abstractC1330c, c1376g, false);
                    break;
                case 9:
                    z = abstractC1330c.mo2703i();
                    break;
                default:
                    abstractC1330c.mo2708n();
                    abstractC1330c.mo2709o();
                    break;
            }
        }
        return new C1467i(str, aVar, c1445b, interfaceC1456m, c1445b2, c1445b3, c1445b4, c1445b5, c1445b6, z);
    }
}
