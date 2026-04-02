package d.b.c.a0;

import d.b.c.a0.c.d;
import d.b.c.c;
import d.b.c.e;
import d.b.c.h;
import d.b.c.m;
import d.b.c.p;
import d.b.c.r;
import d.b.c.s;
import d.b.c.t;
import d.b.c.z.g;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DataMatrixReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t[] f9449b = new t[0];
    private final d a = new d();

    @Override // d.b.c.p
    public r a(c cVar) throws m, d.b.c.d, h {
        return a(cVar, (Map<e, ?>) null);
    }

    @Override // d.b.c.p
    public void reset() {
    }

    @Override // d.b.c.p
    public r a(c cVar, Map<e, ?> map) throws m, d.b.c.d, h {
        t[] tVarArrB;
        d.b.c.z.e eVarA;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g gVarA = new d.b.c.a0.d.a(cVar.a()).a();
            d.b.c.z.e eVarA2 = this.a.a(gVarA.a());
            tVarArrB = gVarA.b();
            eVarA = eVarA2;
        } else {
            eVarA = this.a.a(a(cVar.a()));
            tVarArrB = f9449b;
        }
        r rVar = new r(eVarA.i(), eVarA.f(), tVarArrB, d.b.c.a.DATA_MATRIX);
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

    private static d.b.c.z.b a(d.b.c.z.b bVar) throws m {
        int[] iArrF = bVar.f();
        int[] iArrB = bVar.b();
        if (iArrF != null && iArrB != null) {
            int iA = a(iArrF, bVar);
            int i2 = iArrF[1];
            int i3 = iArrB[1];
            int i4 = iArrF[0];
            int i5 = ((iArrB[0] - i4) + 1) / iA;
            int i6 = ((i3 - i2) + 1) / iA;
            if (i5 > 0 && i6 > 0) {
                int i7 = iA / 2;
                int i8 = i2 + i7;
                int i9 = i4 + i7;
                d.b.c.z.b bVar2 = new d.b.c.z.b(i5, i6);
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = (i10 * iA) + i8;
                    for (int i12 = 0; i12 < i5; i12++) {
                        if (bVar.b((i12 * iA) + i9, i11)) {
                            bVar2.c(i12, i10);
                        }
                    }
                }
                return bVar2;
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private static int a(int[] iArr, d.b.c.z.b bVar) throws m {
        int iG = bVar.g();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < iG && bVar.b(i2, i3)) {
            i2++;
        }
        if (i2 != iG) {
            int i4 = i2 - iArr[0];
            if (i4 != 0) {
                return i4;
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }
}
