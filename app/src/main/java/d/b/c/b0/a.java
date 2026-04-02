package d.b.c.b0;

import d.b.c.b0.b.c;
import d.b.c.d;
import d.b.c.e;
import d.b.c.h;
import d.b.c.m;
import d.b.c.p;
import d.b.c.r;
import d.b.c.s;
import d.b.c.t;
import d.b.c.z.b;
import java.util.Map;

/* JADX INFO: compiled from: MaxiCodeReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final t[] f9506b = new t[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9507c = 30;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9508d = 33;
    private final c a = new c();

    @Override // d.b.c.p
    public r a(d.b.c.c cVar) throws m, d, h {
        return a(cVar, null);
    }

    @Override // d.b.c.p
    public void reset() {
    }

    @Override // d.b.c.p
    public r a(d.b.c.c cVar, Map<e, ?> map) throws m, d, h {
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            throw m.getNotFoundInstance();
        }
        d.b.c.z.e eVarA = this.a.a(a(cVar.a()), map);
        r rVar = new r(eVarA.i(), eVarA.f(), f9506b, d.b.c.a.MAXICODE);
        String strB = eVarA.b();
        if (strB != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, strB);
        }
        return rVar;
    }

    private static b a(b bVar) throws m {
        int[] iArrC = bVar.c();
        if (iArrC != null) {
            int i2 = iArrC[0];
            int i3 = iArrC[1];
            int i4 = iArrC[2];
            int i5 = iArrC[3];
            b bVar2 = new b(30, 33);
            for (int i6 = 0; i6 < 33; i6++) {
                int i7 = (((i6 * i5) + (i5 / 2)) / 33) + i3;
                for (int i8 = 0; i8 < 30; i8++) {
                    if (bVar.b(((((i8 * i4) + (i4 / 2)) + (((i6 & 1) * i4) / 2)) / 30) + i2, i7)) {
                        bVar2.c(i8, i6);
                    }
                }
            }
            return bVar2;
        }
        throw m.getNotFoundInstance();
    }
}
