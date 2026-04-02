package d.b.c.d0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatUPCEANReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class p extends q {
    private final x[] a;

    public p(Map<d.b.c.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(d.b.c.e.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(d.b.c.a.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(d.b.c.a.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(d.b.c.a.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(d.b.c.a.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.a = (x[]) arrayList.toArray(new x[arrayList.size()]);
    }

    @Override // d.b.c.d0.q
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m {
        int[] iArrA = x.a(aVar);
        for (x xVar : this.a) {
            try {
                d.b.c.r rVarA = xVar.a(i2, aVar, iArrA, map);
                boolean z = rVarA.a() == d.b.c.a.EAN_13 && rVarA.e().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(d.b.c.e.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(d.b.c.a.UPC_A);
                if (!z || !z2) {
                    return rVarA;
                }
                d.b.c.r rVar = new d.b.c.r(rVarA.e().substring(1), rVarA.b(), rVarA.d(), d.b.c.a.UPC_A);
                rVar.a(rVarA.c());
                return rVar;
            } catch (d.b.c.q unused) {
            }
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    @Override // d.b.c.d0.q, d.b.c.p
    public void reset() {
        for (x xVar : this.a) {
            xVar.reset();
        }
    }
}
