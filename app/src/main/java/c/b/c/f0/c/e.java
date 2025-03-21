package c.b.c.f0.c;

import h.f1;
import java.util.Map;

/* compiled from: Decoder.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.n.c f2753a = new c.b.c.z.n.c(c.b.c.z.n.a.f3067l);

    public c.b.c.z.e a(boolean[][] zArr) throws c.b.c.d, c.b.c.h {
        return a(zArr, (Map<c.b.c.e, ?>) null);
    }

    public c.b.c.z.e a(boolean[][] zArr, Map<c.b.c.e, ?> map) throws c.b.c.d, c.b.c.h {
        int length = zArr.length;
        c.b.c.z.b bVar = new c.b.c.z.b(length);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i2][i3]) {
                    bVar.c(i3, i2);
                }
            }
        }
        return a(bVar, map);
    }

    public c.b.c.z.e a(c.b.c.z.b bVar) throws c.b.c.d, c.b.c.h {
        return a(bVar, (Map<c.b.c.e, ?>) null);
    }

    public c.b.c.z.e a(c.b.c.z.b bVar, Map<c.b.c.e, ?> map) throws c.b.c.h, c.b.c.d {
        c.b.c.d e2;
        a aVar = new a(bVar);
        c.b.c.h hVar = null;
        try {
            return a(aVar, map);
        } catch (c.b.c.d e3) {
            e2 = e3;
            try {
                aVar.e();
                aVar.a(true);
                aVar.d();
                aVar.c();
                aVar.a();
                c.b.c.z.e a2 = a(aVar, map);
                a2.a(new i(true));
                return a2;
            } catch (c.b.c.d | c.b.c.h e4) {
                if (hVar != null) {
                    throw hVar;
                }
                if (e2 != null) {
                    throw e2;
                }
                throw e4;
            }
        } catch (c.b.c.h e5) {
            e2 = null;
            hVar = e5;
            aVar.e();
            aVar.a(true);
            aVar.d();
            aVar.c();
            aVar.a();
            c.b.c.z.e a22 = a(aVar, map);
            a22.a(new i(true));
            return a22;
        }
    }

    private c.b.c.z.e a(a aVar, Map<c.b.c.e, ?> map) throws c.b.c.h, c.b.c.d {
        j d2 = aVar.d();
        f b2 = aVar.c().b();
        b[] a2 = b.a(aVar.b(), d2, b2);
        int i2 = 0;
        for (b bVar : a2) {
            i2 += bVar.b();
        }
        byte[] bArr = new byte[i2];
        int length = a2.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            b bVar2 = a2[i3];
            byte[] a3 = bVar2.a();
            int b3 = bVar2.b();
            a(a3, b3);
            int i5 = i4;
            int i6 = 0;
            while (i6 < b3) {
                bArr[i5] = a3[i6];
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
        return d.a(bArr, d2, b2, map);
    }

    private void a(byte[] bArr, int i2) throws c.b.c.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & f1.f16099c;
        }
        try {
            this.f2753a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (c.b.c.z.n.e unused) {
            throw c.b.c.d.getChecksumInstance();
        }
    }
}
