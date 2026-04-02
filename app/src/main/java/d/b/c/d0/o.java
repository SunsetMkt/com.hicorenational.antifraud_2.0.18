package d.b.c.d0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatOneDReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class o extends q {
    private final q[] a;

    public o(Map<d.b.c.e, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(d.b.c.e.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(d.b.c.e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(d.b.c.a.EAN_13) || collection.contains(d.b.c.a.UPC_A) || collection.contains(d.b.c.a.EAN_8) || collection.contains(d.b.c.a.UPC_E)) {
                arrayList.add(new p(map));
            }
            if (collection.contains(d.b.c.a.CODE_39)) {
                arrayList.add(new e(z));
            }
            if (collection.contains(d.b.c.a.CODE_93)) {
                arrayList.add(new g());
            }
            if (collection.contains(d.b.c.a.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(d.b.c.a.ITF)) {
                arrayList.add(new m());
            }
            if (collection.contains(d.b.c.a.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(d.b.c.a.RSS_14)) {
                arrayList.add(new d.b.c.d0.a0.e());
            }
            if (collection.contains(d.b.c.a.RSS_EXPANDED)) {
                arrayList.add(new d.b.c.d0.a0.g.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new p(map));
            arrayList.add(new e());
            arrayList.add(new a());
            arrayList.add(new g());
            arrayList.add(new c());
            arrayList.add(new m());
            arrayList.add(new d.b.c.d0.a0.e());
            arrayList.add(new d.b.c.d0.a0.g.d());
        }
        this.a = (q[]) arrayList.toArray(new q[arrayList.size()]);
    }

    @Override // d.b.c.d0.q
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m {
        for (q qVar : this.a) {
            try {
                return qVar.a(i2, aVar, map);
            } catch (d.b.c.q unused) {
            }
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    @Override // d.b.c.d0.q, d.b.c.p
    public void reset() {
        for (q qVar : this.a) {
            qVar.reset();
        }
    }
}
