package c.b.c.a0;

import c.b.c.a0.c.d;
import c.b.c.c;
import c.b.c.e;
import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;
import c.b.c.s;
import c.b.c.t;
import c.b.c.z.g;
import java.util.List;
import java.util.Map;

/* compiled from: DataMatrixReader.java */
/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: b, reason: collision with root package name */
    private static final t[] f2334b = new t[0];

    /* renamed from: a, reason: collision with root package name */
    private final d f2335a = new d();

    @Override // c.b.c.p
    public r a(c cVar) throws m, c.b.c.d, h {
        return a(cVar, (Map<e, ?>) null);
    }

    @Override // c.b.c.p
    public void reset() {
    }

    @Override // c.b.c.p
    public r a(c cVar, Map<e, ?> map) throws m, c.b.c.d, h {
        t[] b2;
        c.b.c.z.e eVar;
        if (map == null || !map.containsKey(e.PURE_BARCODE)) {
            g a2 = new c.b.c.a0.d.a(cVar.a()).a();
            c.b.c.z.e a3 = this.f2335a.a(a2.a());
            b2 = a2.b();
            eVar = a3;
        } else {
            eVar = this.f2335a.a(a(cVar.a()));
            b2 = f2334b;
        }
        r rVar = new r(eVar.i(), eVar.f(), b2, c.b.c.a.DATA_MATRIX);
        List<byte[]> a4 = eVar.a();
        if (a4 != null) {
            rVar.a(s.BYTE_SEGMENTS, a4);
        }
        String b3 = eVar.b();
        if (b3 != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, b3);
        }
        return rVar;
    }

    private static c.b.c.z.b a(c.b.c.z.b bVar) throws m {
        int[] f2 = bVar.f();
        int[] b2 = bVar.b();
        if (f2 != null && b2 != null) {
            int a2 = a(f2, bVar);
            int i2 = f2[1];
            int i3 = b2[1];
            int i4 = f2[0];
            int i5 = ((b2[0] - i4) + 1) / a2;
            int i6 = ((i3 - i2) + 1) / a2;
            if (i5 > 0 && i6 > 0) {
                int i7 = a2 / 2;
                int i8 = i2 + i7;
                int i9 = i4 + i7;
                c.b.c.z.b bVar2 = new c.b.c.z.b(i5, i6);
                for (int i10 = 0; i10 < i6; i10++) {
                    int i11 = (i10 * a2) + i8;
                    for (int i12 = 0; i12 < i5; i12++) {
                        if (bVar.b((i12 * a2) + i9, i11)) {
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

    private static int a(int[] iArr, c.b.c.z.b bVar) throws m {
        int g2 = bVar.g();
        int i2 = iArr[0];
        int i3 = iArr[1];
        while (i2 < g2 && bVar.b(i2, i3)) {
            i2++;
        }
        if (i2 != g2) {
            int i4 = i2 - iArr[0];
            if (i4 != 0) {
                return i4;
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }
}
