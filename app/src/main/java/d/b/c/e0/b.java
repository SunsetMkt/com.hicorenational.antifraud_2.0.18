package d.b.c.e0;

import d.b.c.e;
import d.b.c.e0.e.j;
import d.b.c.h;
import d.b.c.m;
import d.b.c.p;
import d.b.c.r;
import d.b.c.s;
import d.b.c.t;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: PDF417Reader.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p, d.b.c.c0.c {
    @Override // d.b.c.p
    public r a(d.b.c.c cVar) throws m, d.b.c.d, h {
        return a(cVar, (Map<e, ?>) null);
    }

    @Override // d.b.c.c0.c
    public r[] b(d.b.c.c cVar) throws m {
        return b(cVar, (Map<e, ?>) null);
    }

    @Override // d.b.c.p
    public void reset() {
    }

    @Override // d.b.c.p
    public r a(d.b.c.c cVar, Map<e, ?> map) throws m, d.b.c.d, h {
        r[] rVarArrA = a(cVar, map, false);
        if (rVarArrA == null || rVarArrA.length == 0 || rVarArrA[0] == null) {
            throw m.getNotFoundInstance();
        }
        return rVarArrA[0];
    }

    @Override // d.b.c.c0.c
    public r[] b(d.b.c.c cVar, Map<e, ?> map) throws m {
        try {
            return a(cVar, map, true);
        } catch (d.b.c.d | h unused) {
            throw m.getNotFoundInstance();
        }
    }

    private static int b(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(tVar.a() - tVar2.a());
    }

    private static int b(t[] tVarArr) {
        return Math.min(Math.min(b(tVarArr[0], tVarArr[4]), (b(tVarArr[6], tVarArr[2]) * 17) / 18), Math.min(b(tVarArr[1], tVarArr[5]), (b(tVarArr[7], tVarArr[3]) * 17) / 18));
    }

    private static r[] a(d.b.c.c cVar, Map<e, ?> map, boolean z) throws m, d.b.c.d, h {
        ArrayList arrayList = new ArrayList();
        d.b.c.e0.f.b bVarA = d.b.c.e0.f.a.a(cVar, map, z);
        for (t[] tVarArr : bVarA.b()) {
            d.b.c.z.e eVarA = j.a(bVarA.a(), tVarArr[4], tVarArr[5], tVarArr[6], tVarArr[7], b(tVarArr), a(tVarArr));
            r rVar = new r(eVarA.i(), eVarA.f(), tVarArr, d.b.c.a.PDF_417);
            rVar.a(s.ERROR_CORRECTION_LEVEL, eVarA.b());
            c cVar2 = (c) eVarA.e();
            if (cVar2 != null) {
                rVar.a(s.PDF417_EXTRA_METADATA, cVar2);
            }
            arrayList.add(rVar);
        }
        return (r[]) arrayList.toArray(new r[arrayList.size()]);
    }

    private static int a(t tVar, t tVar2) {
        if (tVar == null || tVar2 == null) {
            return 0;
        }
        return (int) Math.abs(tVar.a() - tVar2.a());
    }

    private static int a(t[] tVarArr) {
        return Math.max(Math.max(a(tVarArr[0], tVarArr[4]), (a(tVarArr[6], tVarArr[2]) * 17) / 18), Math.max(a(tVarArr[1], tVarArr[5]), (a(tVarArr[7], tVarArr[3]) * 17) / 18));
    }
}
