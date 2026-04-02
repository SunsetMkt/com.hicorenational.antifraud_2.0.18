package d.b.c.x;

import d.b.c.e;
import d.b.c.h;
import d.b.c.m;
import d.b.c.p;
import d.b.c.r;
import d.b.c.s;
import d.b.c.t;
import d.b.c.u;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AztecReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p {
    @Override // d.b.c.p
    public r a(d.b.c.c cVar) throws m, h {
        return a(cVar, null);
    }

    @Override // d.b.c.p
    public void reset() {
    }

    @Override // d.b.c.p
    public r a(d.b.c.c cVar, Map<e, ?> map) throws m, h {
        t[] tVarArrB;
        t[] tVarArrB2;
        h hVar;
        u uVar;
        d.b.c.x.e.a aVar = new d.b.c.x.e.a(cVar.a());
        d.b.c.z.e eVarA = null;
        try {
            a aVarA = aVar.a(false);
            tVarArrB = aVarA.b();
            try {
                tVarArrB2 = tVarArrB;
                hVar = null;
                eVarA = new d.b.c.x.d.a().a(aVarA);
                e = null;
            } catch (h e2) {
                e = e2;
                tVarArrB2 = tVarArrB;
                hVar = e;
                e = null;
            } catch (m e3) {
                e = e3;
                tVarArrB2 = tVarArrB;
                hVar = null;
            }
        } catch (h e4) {
            e = e4;
            tVarArrB = null;
        } catch (m e5) {
            e = e5;
            tVarArrB = null;
        }
        if (eVarA == null) {
            try {
                a aVarA2 = aVar.a(true);
                tVarArrB2 = aVarA2.b();
                eVarA = new d.b.c.x.d.a().a(aVarA2);
            } catch (h | m e6) {
                if (e != null) {
                    throw e;
                }
                if (hVar != null) {
                    throw hVar;
                }
                throw e6;
            }
        }
        if (map != null && (uVar = (u) map.get(e.NEED_RESULT_POINT_CALLBACK)) != null) {
            for (t tVar : tVarArrB2) {
                uVar.a(tVar);
            }
        }
        r rVar = new r(eVarA.i(), eVarA.f(), tVarArrB2, d.b.c.a.AZTEC);
        List<byte[]> listA = eVarA.a();
        if (listA != null) {
            rVar.a(s.BYTE_SEGMENTS, listA);
        }
        String strB = eVarA.b();
        if (strB != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, strB);
        }
        return rVar;
    }
}
