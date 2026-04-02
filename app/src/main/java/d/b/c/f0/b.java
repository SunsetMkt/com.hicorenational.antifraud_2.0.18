package d.b.c.f0;

import d.b.c.f0.c.f;
import d.b.c.f0.e.c;
import d.b.c.g;
import d.b.c.v;
import d.b.c.w;
import java.util.Map;

/* JADX INFO: compiled from: QRCodeWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements v {
    private static final int a = 4;

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3) throws w {
        return a(str, aVar, i2, i3, null);
    }

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != d.b.c.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        f fVar = f.L;
        int iIntValue = 4;
        if (map != null) {
            f fVar2 = (f) map.get(g.ERROR_CORRECTION);
            if (fVar2 != null) {
                fVar = fVar2;
            }
            Integer num = (Integer) map.get(g.MARGIN);
            if (num != null) {
                iIntValue = num.intValue();
            }
        }
        return a(c.a(str, fVar, map), i2, i3, iIntValue);
    }

    private static d.b.c.z.b a(d.b.c.f0.e.f fVar, int i2, int i3, int i4) {
        d.b.c.f0.e.b bVarC = fVar.c();
        if (bVarC != null) {
            int iC = bVarC.c();
            int iB = bVarC.b();
            int i5 = i4 * 2;
            int i6 = iC + i5;
            int i7 = i5 + iB;
            int iMax = Math.max(i2, i6);
            int iMax2 = Math.max(i3, i7);
            int iMin = Math.min(iMax / i6, iMax2 / i7);
            int i8 = (iMax - (iC * iMin)) / 2;
            int i9 = (iMax2 - (iB * iMin)) / 2;
            d.b.c.z.b bVar = new d.b.c.z.b(iMax, iMax2);
            int i10 = 0;
            while (i10 < iB) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < iC) {
                    if (bVarC.a(i12, i10) == 1) {
                        bVar.a(i11, i9, iMin, iMin);
                    }
                    i12++;
                    i11 += iMin;
                }
                i10++;
                i9 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
