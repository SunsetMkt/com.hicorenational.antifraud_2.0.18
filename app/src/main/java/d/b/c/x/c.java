package d.b.c.x;

import d.b.c.g;
import d.b.c.v;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: AztecWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements v {
    private static final Charset a = Charset.forName(j.a.a.a.c.a);

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3) {
        return a(str, aVar, i2, i3, null);
    }

    @Override // d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3, Map<g, ?> map) {
        String str2 = map == null ? null : (String) map.get(g.CHARACTER_SET);
        Number number = map == null ? null : (Number) map.get(g.ERROR_CORRECTION);
        Number number2 = map != null ? (Number) map.get(g.AZTEC_LAYERS) : null;
        return a(str, aVar, i2, i3, str2 == null ? a : Charset.forName(str2), number == null ? 33 : number.intValue(), number2 == null ? 0 : number2.intValue());
    }

    private static d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3, Charset charset, int i4, int i5) {
        if (aVar == d.b.c.a.AZTEC) {
            return a(d.b.c.x.f.c.a(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + aVar);
    }

    private static d.b.c.z.b a(d.b.c.x.f.a aVar, int i2, int i3) {
        d.b.c.z.b bVarC = aVar.c();
        if (bVarC != null) {
            int iG = bVarC.g();
            int iD = bVarC.d();
            int iMax = Math.max(i2, iG);
            int iMax2 = Math.max(i3, iD);
            int iMin = Math.min(iMax / iG, iMax2 / iD);
            int i4 = (iMax - (iG * iMin)) / 2;
            int i5 = (iMax2 - (iD * iMin)) / 2;
            d.b.c.z.b bVar = new d.b.c.z.b(iMax, iMax2);
            int i6 = 0;
            while (i6 < iD) {
                int i7 = i4;
                int i8 = 0;
                while (i8 < iG) {
                    if (bVarC.b(i8, i6)) {
                        bVar.a(i7, i5, iMin, iMin);
                    }
                    i8++;
                    i7 += iMin;
                }
                i6++;
                i5 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
