package com.airbnb.lottie.a0;

import com.airbnb.lottie.a0.l0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: KeyframesParser.java */
/* JADX INFO: loaded from: classes.dex */
class r {
    static c.a a = c.a.a("k");

    private r() {
    }

    static <T> List<com.airbnb.lottie.c0.a<T>> a(com.airbnb.lottie.a0.l0.c cVar, com.airbnb.lottie.g gVar, float f2, k0<T> k0Var, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.peek() == c.b.STRING) {
            gVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        cVar.d();
        while (cVar.h()) {
            if (cVar.a(a) != 0) {
                cVar.o();
            } else if (cVar.peek() == c.b.BEGIN_ARRAY) {
                cVar.c();
                if (cVar.peek() == c.b.NUMBER) {
                    arrayList.add(q.a(cVar, gVar, f2, k0Var, false, z));
                } else {
                    while (cVar.h()) {
                        arrayList.add(q.a(cVar, gVar, f2, k0Var, true, z));
                    }
                }
                cVar.e();
            } else {
                arrayList.add(q.a(cVar, gVar, f2, k0Var, false, z));
            }
        }
        cVar.f();
        a(arrayList);
        return arrayList;
    }

    public static <T> void a(List<? extends com.airbnb.lottie.c0.a<T>> list) {
        int i2;
        T t;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            com.airbnb.lottie.c0.a<T> aVar = list.get(i3);
            i3++;
            com.airbnb.lottie.c0.a<T> aVar2 = list.get(i3);
            aVar.f2117h = Float.valueOf(aVar2.f2116g);
            if (aVar.f2112c == null && (t = aVar2.f2111b) != null) {
                aVar.f2112c = t;
                if (aVar instanceof com.airbnb.lottie.w.c.h) {
                    ((com.airbnb.lottie.w.c.h) aVar).h();
                }
            }
        }
        com.airbnb.lottie.c0.a<T> aVar3 = list.get(i2);
        if ((aVar3.f2111b == null || aVar3.f2112c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
