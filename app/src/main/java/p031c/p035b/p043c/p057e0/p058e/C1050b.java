package p031c.p035b.p043c.p057e0.p058e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p031c.p035b.p043c.p057e0.C1045a;

/* compiled from: BarcodeValue.java */
/* renamed from: c.b.c.e0.e.b */
/* loaded from: classes.dex */
final class C1050b {

    /* renamed from: a */
    private final Map<Integer, Integer> f1984a = new HashMap();

    C1050b() {
    }

    /* renamed from: a */
    int[] m1562a() {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (Map.Entry<Integer, Integer> entry : this.f1984a.entrySet()) {
            if (entry.getValue().intValue() > i2) {
                i2 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i2) {
                arrayList.add(entry.getKey());
            }
        }
        return C1045a.m1539a(arrayList);
    }

    /* renamed from: b */
    void m1563b(int i2) {
        Integer num = this.f1984a.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.f1984a.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }

    /* renamed from: a */
    public Integer m1561a(int i2) {
        return this.f1984a.get(Integer.valueOf(i2));
    }
}
