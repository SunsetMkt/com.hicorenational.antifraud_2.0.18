package com.airbnb.lottie.a0;

import android.graphics.PointF;
import com.airbnb.lottie.a0.l0.c;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class e0 implements k0<com.airbnb.lottie.y.k.l> {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f3336a = new e0();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f3337b = c.a.a(bh.aI, "v", bh.aF, "o");

    private e0() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.a0.k0
    public com.airbnb.lottie.y.k.l a(com.airbnb.lottie.a0.l0.c cVar, float f2) throws IOException {
        if (cVar.peek() == c.b.BEGIN_ARRAY) {
            cVar.c();
        }
        cVar.d();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (cVar.h()) {
            int a2 = cVar.a(f3337b);
            if (a2 == 0) {
                z = cVar.i();
            } else if (a2 == 1) {
                list = p.e(cVar, f2);
            } else if (a2 == 2) {
                list2 = p.e(cVar, f2);
            } else if (a2 != 3) {
                cVar.n();
                cVar.o();
            } else {
                list3 = p.e(cVar, f2);
            }
        }
        cVar.f();
        if (cVar.peek() == c.b.END_ARRAY) {
            cVar.e();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new com.airbnb.lottie.y.k.l(new PointF(), false, Collections.emptyList());
        }
        int size = list.size();
        PointF pointF = list.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 1; i2 < size; i2++) {
            PointF pointF2 = list.get(i2);
            int i3 = i2 - 1;
            arrayList.add(new com.airbnb.lottie.y.a(com.airbnb.lottie.b0.g.a(list.get(i3), list3.get(i3)), com.airbnb.lottie.b0.g.a(pointF2, list2.get(i2)), pointF2));
        }
        if (z) {
            PointF pointF3 = list.get(0);
            int i4 = size - 1;
            arrayList.add(new com.airbnb.lottie.y.a(com.airbnb.lottie.b0.g.a(list.get(i4), list3.get(i4)), com.airbnb.lottie.b0.g.a(pointF3, list2.get(0)), pointF3));
        }
        return new com.airbnb.lottie.y.k.l(pointF, z, arrayList);
    }
}
