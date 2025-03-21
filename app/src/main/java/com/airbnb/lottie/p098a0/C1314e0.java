package com.airbnb.lottie.p098a0;

import android.graphics.PointF;
import com.airbnb.lottie.p098a0.p099l0.AbstractC1330c;
import com.airbnb.lottie.p100b0.C1357g;
import com.airbnb.lottie.p106y.C1435a;
import com.airbnb.lottie.p106y.p108k.C1470l;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* renamed from: com.airbnb.lottie.a0.e0 */
/* loaded from: classes.dex */
public class C1314e0 implements InterfaceC1326k0<C1470l> {

    /* renamed from: a */
    public static final C1314e0 f3007a = new C1314e0();

    /* renamed from: b */
    private static final AbstractC1330c.a f3008b = AbstractC1330c.a.m2710a(C3351bh.f11584aI, "v", C3351bh.f11581aF, "o");

    private C1314e0() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.p098a0.InterfaceC1326k0
    /* renamed from: a */
    public C1470l mo2679a(AbstractC1330c abstractC1330c, float f2) throws IOException {
        if (abstractC1330c.peek() == AbstractC1330c.b.BEGIN_ARRAY) {
            abstractC1330c.mo2697c();
        }
        abstractC1330c.mo2698d();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (abstractC1330c.mo2702h()) {
            int mo2694a = abstractC1330c.mo2694a(f3008b);
            if (mo2694a == 0) {
                z = abstractC1330c.mo2703i();
            } else if (mo2694a == 1) {
                list = C1339p.m2751e(abstractC1330c, f2);
            } else if (mo2694a == 2) {
                list2 = C1339p.m2751e(abstractC1330c, f2);
            } else if (mo2694a != 3) {
                abstractC1330c.mo2708n();
                abstractC1330c.mo2709o();
            } else {
                list3 = C1339p.m2751e(abstractC1330c, f2);
            }
        }
        abstractC1330c.mo2700f();
        if (abstractC1330c.peek() == AbstractC1330c.b.END_ARRAY) {
            abstractC1330c.mo2699e();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new C1470l(new PointF(), false, Collections.emptyList());
        }
        int size = list.size();
        PointF pointF = list.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 1; i2 < size; i2++) {
            PointF pointF2 = list.get(i2);
            int i3 = i2 - 1;
            arrayList.add(new C1435a(C1357g.m2825a(list.get(i3), list3.get(i3)), C1357g.m2825a(pointF2, list2.get(i2)), pointF2));
        }
        if (z) {
            PointF pointF3 = list.get(0);
            int i4 = size - 1;
            arrayList.add(new C1435a(C1357g.m2825a(list.get(i4), list3.get(i4)), C1357g.m2825a(pointF3, list2.get(0)), pointF3));
        }
        return new C1470l(pointF, z, arrayList);
    }
}
