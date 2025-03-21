package c.b.c.f0;

import c.b.c.c;
import c.b.c.d;
import c.b.c.f0.c.e;
import c.b.c.f0.c.i;
import c.b.c.h;
import c.b.c.m;
import c.b.c.p;
import c.b.c.r;
import c.b.c.s;
import c.b.c.t;
import c.b.c.z.g;
import java.util.List;
import java.util.Map;

/* compiled from: QRCodeReader.java */
/* loaded from: classes.dex */
public class a implements p {

    /* renamed from: b, reason: collision with root package name */
    private static final t[] f2741b = new t[0];

    /* renamed from: a, reason: collision with root package name */
    private final e f2742a = new e();

    protected final e a() {
        return this.f2742a;
    }

    @Override // c.b.c.p
    public void reset() {
    }

    @Override // c.b.c.p
    public r a(c cVar) throws m, d, h {
        return a(cVar, (Map<c.b.c.e, ?>) null);
    }

    @Override // c.b.c.p
    public final r a(c cVar, Map<c.b.c.e, ?> map) throws m, d, h {
        t[] b2;
        c.b.c.z.e eVar;
        if (map != null && map.containsKey(c.b.c.e.PURE_BARCODE)) {
            eVar = this.f2742a.a(a(cVar.a()), map);
            b2 = f2741b;
        } else {
            g a2 = new c.b.c.f0.d.c(cVar.a()).a(map);
            c.b.c.z.e a3 = this.f2742a.a(a2.a(), map);
            b2 = a2.b();
            eVar = a3;
        }
        if (eVar.e() instanceof i) {
            ((i) eVar.e()).a(b2);
        }
        r rVar = new r(eVar.i(), eVar.f(), b2, c.b.c.a.QR_CODE);
        List<byte[]> a4 = eVar.a();
        if (a4 != null) {
            rVar.a(s.BYTE_SEGMENTS, a4);
        }
        String b3 = eVar.b();
        if (b3 != null) {
            rVar.a(s.ERROR_CORRECTION_LEVEL, b3);
        }
        if (eVar.j()) {
            rVar.a(s.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(eVar.h()));
            rVar.a(s.STRUCTURED_APPEND_PARITY, Integer.valueOf(eVar.g()));
        }
        return rVar;
    }

    private static c.b.c.z.b a(c.b.c.z.b bVar) throws m {
        int[] f2 = bVar.f();
        int[] b2 = bVar.b();
        if (f2 != null && b2 != null) {
            float a2 = a(f2, bVar);
            int i2 = f2[1];
            int i3 = b2[1];
            int i4 = f2[0];
            int i5 = b2[0];
            if (i4 < i5 && i2 < i3) {
                int i6 = i3 - i2;
                if (i6 != i5 - i4) {
                    i5 = i4 + i6;
                }
                int round = Math.round(((i5 - i4) + 1) / a2);
                int round2 = Math.round((i6 + 1) / a2);
                if (round <= 0 || round2 <= 0) {
                    throw m.getNotFoundInstance();
                }
                if (round2 == round) {
                    int i7 = (int) (a2 / 2.0f);
                    int i8 = i2 + i7;
                    int i9 = i4 + i7;
                    int i10 = (((int) ((round - 1) * a2)) + i9) - i5;
                    if (i10 > 0) {
                        if (i10 > i7) {
                            throw m.getNotFoundInstance();
                        }
                        i9 -= i10;
                    }
                    int i11 = (((int) ((round2 - 1) * a2)) + i8) - i3;
                    if (i11 > 0) {
                        if (i11 > i7) {
                            throw m.getNotFoundInstance();
                        }
                        i8 -= i11;
                    }
                    c.b.c.z.b bVar2 = new c.b.c.z.b(round, round2);
                    for (int i12 = 0; i12 < round2; i12++) {
                        int i13 = ((int) (i12 * a2)) + i8;
                        for (int i14 = 0; i14 < round; i14++) {
                            if (bVar.b(((int) (i14 * a2)) + i9, i13)) {
                                bVar2.c(i14, i12);
                            }
                        }
                    }
                    return bVar2;
                }
                throw m.getNotFoundInstance();
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private static float a(int[] iArr, c.b.c.z.b bVar) throws m {
        int d2 = bVar.d();
        int g2 = bVar.g();
        int i2 = iArr[0];
        boolean z = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < g2 && i3 < d2) {
            if (z != bVar.b(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z = !z;
            }
            i2++;
            i3++;
        }
        if (i2 != g2 && i3 != d2) {
            return (i2 - iArr[0]) / 7.0f;
        }
        throw m.getNotFoundInstance();
    }
}
