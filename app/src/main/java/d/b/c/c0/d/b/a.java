package d.b.c.c0.d.b;

import d.b.c.e;
import d.b.c.f0.d.c;
import d.b.c.f0.d.f;
import d.b.c.m;
import d.b.c.q;
import d.b.c.u;
import d.b.c.z.g;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: MultiDetector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final g[] f9531c = new g[0];

    public a(d.b.c.z.b bVar) {
        super(bVar);
    }

    public g[] b(Map<e, ?> map) throws m {
        f[] fVarArrB = new b(b(), map == null ? null : (u) map.get(e.NEED_RESULT_POINT_CALLBACK)).b(map);
        if (fVarArrB.length == 0) {
            throw m.getNotFoundInstance();
        }
        ArrayList arrayList = new ArrayList();
        for (f fVar : fVarArrB) {
            try {
                arrayList.add(a(fVar));
            } catch (q unused) {
            }
        }
        return arrayList.isEmpty() ? f9531c : (g[]) arrayList.toArray(new g[arrayList.size()]);
    }
}
