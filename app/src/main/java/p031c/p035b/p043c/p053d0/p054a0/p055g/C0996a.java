package p031c.p035b.p043c.p053d0.p054a0.p055g;

import java.util.List;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: BitArrayBuilder.java */
/* renamed from: c.b.c.d0.a0.g.a */
/* loaded from: classes.dex */
final class C0996a {
    private C0996a() {
    }

    /* renamed from: a */
    static C1162a m1396a(List<C0997b> list) {
        int size = (list.size() * 2) - 1;
        if (list.get(list.size() - 1).m1401c() == null) {
            size--;
        }
        C1162a c1162a = new C1162a(size * 12);
        int m1379b = list.get(0).m1401c().m1379b();
        int i2 = 0;
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & m1379b) != 0) {
                c1162a.m2163e(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            C0997b c0997b = list.get(i4);
            int m1379b2 = c0997b.m1400b().m1379b();
            int i5 = i2;
            for (int i6 = 11; i6 >= 0; i6--) {
                if (((1 << i6) & m1379b2) != 0) {
                    c1162a.m2163e(i5);
                }
                i5++;
            }
            if (c0997b.m1401c() != null) {
                int m1379b3 = c0997b.m1401c().m1379b();
                for (int i7 = 11; i7 >= 0; i7--) {
                    if (((1 << i7) & m1379b3) != 0) {
                        c1162a.m2163e(i5);
                    }
                    i5++;
                }
            }
            i2 = i5;
        }
        return c1162a;
    }
}
