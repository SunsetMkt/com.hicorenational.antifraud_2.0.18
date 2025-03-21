package com.airbnb.lottie.p098a0;

import com.airbnb.lottie.C1376g;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p101c0.C1361a;
import com.airbnb.lottie.p102w.p104c.C1421h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* renamed from: com.airbnb.lottie.a0.r */
/* loaded from: classes.dex */
class C1341r {

    /* renamed from: a */
    static AbstractC1330c.a f3117a = AbstractC1330c.a.m2710a("k");

    private C1341r() {
    }

    /* renamed from: a */
    static <T> List<C1361a<T>> m2760a(AbstractC1330c abstractC1330c, C1376g c1376g, float f2, InterfaceC1326k0<T> interfaceC1326k0, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (abstractC1330c.peek() == AbstractC1330c.b.STRING) {
            c1376g.m2892a("Lottie doesn't support expressions.");
            return arrayList;
        }
        abstractC1330c.mo2698d();
        while (abstractC1330c.mo2702h()) {
            if (abstractC1330c.mo2694a(f3117a) != 0) {
                abstractC1330c.mo2709o();
            } else if (abstractC1330c.peek() == AbstractC1330c.b.BEGIN_ARRAY) {
                abstractC1330c.mo2697c();
                if (abstractC1330c.peek() == AbstractC1330c.b.NUMBER) {
                    arrayList.add(C1340q.m2755a(abstractC1330c, c1376g, f2, interfaceC1326k0, false, z));
                } else {
                    while (abstractC1330c.mo2702h()) {
                        arrayList.add(C1340q.m2755a(abstractC1330c, c1376g, f2, interfaceC1326k0, true, z));
                    }
                }
                abstractC1330c.mo2699e();
            } else {
                arrayList.add(C1340q.m2755a(abstractC1330c, c1376g, f2, interfaceC1326k0, false, z));
            }
        }
        abstractC1330c.mo2700f();
        m2761a(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public static <T> void m2761a(List<? extends C1361a<T>> list) {
        int i2;
        T t;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            C1361a<T> c1361a = list.get(i3);
            i3++;
            C1361a<T> c1361a2 = list.get(i3);
            c1361a.f3162h = Float.valueOf(c1361a2.f3161g);
            if (c1361a.f3157c == null && (t = c1361a2.f3156b) != null) {
                c1361a.f3157c = t;
                if (c1361a instanceof C1421h) {
                    ((C1421h) c1361a).m3161h();
                }
            }
        }
        C1361a<T> c1361a3 = list.get(i2);
        if ((c1361a3.f3156b == null || c1361a3.f3157c == null) && list.size() > 1) {
            list.remove(c1361a3);
        }
    }
}
