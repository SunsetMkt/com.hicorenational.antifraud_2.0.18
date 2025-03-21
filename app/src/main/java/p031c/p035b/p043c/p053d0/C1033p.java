package p031c.p035b.p043c.p053d0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import p031c.p035b.p043c.AbstractC1106q;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: MultiFormatUPCEANReader.java */
/* renamed from: c.b.c.d0.p */
/* loaded from: classes.dex */
public final class C1033p extends AbstractC1034q {

    /* renamed from: a */
    private final AbstractC1041x[] f1939a;

    public C1033p(Map<EnumC1044e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC1044e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(EnumC0953a.EAN_13)) {
                arrayList.add(new C1025h());
            } else if (collection.contains(EnumC0953a.UPC_A)) {
                arrayList.add(new C1036s());
            }
            if (collection.contains(EnumC0953a.EAN_8)) {
                arrayList.add(new C1027j());
            }
            if (collection.contains(EnumC0953a.UPC_E)) {
                arrayList.add(new C1043z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C1025h());
            arrayList.add(new C1027j());
            arrayList.add(new C1043z());
        }
        this.f1939a = (AbstractC1041x[]) arrayList.toArray(new AbstractC1041x[arrayList.size()]);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m {
        int[] m1530a = AbstractC1041x.m1530a(c1162a);
        for (AbstractC1041x abstractC1041x : this.f1939a) {
            try {
                C1107r mo1516a = abstractC1041x.mo1516a(i2, c1162a, m1530a, map);
                boolean z = mo1516a.m1910a() == EnumC0953a.EAN_13 && mo1516a.m1917e().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(EnumC1044e.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(EnumC0953a.UPC_A);
                if (!z || !z2) {
                    return mo1516a;
                }
                C1107r c1107r = new C1107r(mo1516a.m1917e().substring(1), mo1516a.m1914b(), mo1516a.m1916d(), EnumC0953a.UPC_A);
                c1107r.m1912a(mo1516a.m1915c());
                return c1107r;
            } catch (AbstractC1106q unused) {
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q, p031c.p035b.p043c.InterfaceC1105p
    public void reset() {
        for (AbstractC1041x abstractC1041x : this.f1939a) {
            abstractC1041x.reset();
        }
    }
}
