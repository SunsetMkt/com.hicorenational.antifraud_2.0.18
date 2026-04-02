package d.b.c.f0.c;

import i.f1;
import java.util.Map;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    private final d.b.c.z.n.c a = new d.b.c.z.n.c(d.b.c.z.n.a.f10049l);

    public d.b.c.z.e a(boolean[][] zArr) throws d.b.c.d, d.b.c.h {
        return a(zArr, (Map<d.b.c.e, ?>) null);
    }

    public d.b.c.z.e a(boolean[][] zArr, Map<d.b.c.e, ?> map) throws d.b.c.d, d.b.c.h {
        int length = zArr.length;
        d.b.c.z.b bVar = new d.b.c.z.b(length);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i2][i3]) {
                    bVar.c(i3, i2);
                }
            }
        }
        return a(bVar, map);
    }

    public d.b.c.z.e a(d.b.c.z.b bVar) throws d.b.c.d, d.b.c.h {
        return a(bVar, (Map<d.b.c.e, ?>) null);
    }

    public d.b.c.z.e a(d.b.c.z.b bVar, Map<d.b.c.e, ?> map) throws d.b.c.d, d.b.c.h {
        d.b.c.d e2;
        a aVar = new a(bVar);
        d.b.c.h hVar = null;
        try {
            return a(aVar, map);
        } catch (d.b.c.d e3) {
            e2 = e3;
            try {
                aVar.e();
                aVar.a(true);
                aVar.d();
                aVar.c();
                aVar.a();
                d.b.c.z.e eVarA = a(aVar, map);
                eVarA.a(new i(true));
                return eVarA;
            } catch (d.b.c.d | d.b.c.h e4) {
                if (hVar != null) {
                    throw hVar;
                }
                if (e2 != null) {
                    throw e2;
                }
                throw e4;
            }
        } catch (d.b.c.h e5) {
            e2 = null;
            hVar = e5;
            aVar.e();
            aVar.a(true);
            aVar.d();
            aVar.c();
            aVar.a();
            d.b.c.z.e eVarA2 = a(aVar, map);
            eVarA2.a(new i(true));
            return eVarA2;
        }
    }

    private d.b.c.z.e a(a aVar, Map<d.b.c.e, ?> map) throws d.b.c.d, d.b.c.h {
        j jVarD = aVar.d();
        f fVarB = aVar.c().b();
        b[] bVarArrA = b.a(aVar.b(), jVarD, fVarB);
        int iB = 0;
        for (b bVar : bVarArrA) {
            iB += bVar.b();
        }
        byte[] bArr = new byte[iB];
        int length = bVarArrA.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            b bVar2 = bVarArrA[i2];
            byte[] bArrA = bVar2.a();
            int iB2 = bVar2.b();
            a(bArrA, iB2);
            int i4 = i3;
            int i5 = 0;
            while (i5 < iB2) {
                bArr[i4] = bArrA[i5];
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        return d.a(bArr, jVarD, fVarB, map);
    }

    private void a(byte[] bArr, int i2) throws d.b.c.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & f1.f12066c;
        }
        try {
            this.a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (d.b.c.z.n.e unused) {
            throw d.b.c.d.getChecksumInstance();
        }
    }
}
