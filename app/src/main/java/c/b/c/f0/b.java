package c.b.c.f0;

import c.b.c.f0.c.f;
import c.b.c.f0.e.c;
import c.b.c.g;
import c.b.c.v;
import c.b.c.w;
import java.util.Map;

/* compiled from: QRCodeWriter.java */
/* loaded from: classes.dex */
public final class b implements v {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2743a = 4;

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3) throws w {
        return a(str, aVar, i2, i3, null);
    }

    @Override // c.b.c.v
    public c.b.c.z.b a(String str, c.b.c.a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (aVar != c.b.c.a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        f fVar = f.L;
        int i4 = 4;
        if (map != null) {
            f fVar2 = (f) map.get(g.ERROR_CORRECTION);
            if (fVar2 != null) {
                fVar = fVar2;
            }
            Integer num = (Integer) map.get(g.MARGIN);
            if (num != null) {
                i4 = num.intValue();
            }
        }
        return a(c.a(str, fVar, map), i2, i3, i4);
    }

    private static c.b.c.z.b a(c.b.c.f0.e.f fVar, int i2, int i3, int i4) {
        c.b.c.f0.e.b c2 = fVar.c();
        if (c2 != null) {
            int c3 = c2.c();
            int b2 = c2.b();
            int i5 = i4 * 2;
            int i6 = c3 + i5;
            int i7 = i5 + b2;
            int max = Math.max(i2, i6);
            int max2 = Math.max(i3, i7);
            int min = Math.min(max / i6, max2 / i7);
            int i8 = (max - (c3 * min)) / 2;
            int i9 = (max2 - (b2 * min)) / 2;
            c.b.c.z.b bVar = new c.b.c.z.b(max, max2);
            int i10 = 0;
            while (i10 < b2) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < c3) {
                    if (c2.a(i12, i10) == 1) {
                        bVar.a(i11, i9, min, min);
                    }
                    i12++;
                    i11 += min;
                }
                i10++;
                i9 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
