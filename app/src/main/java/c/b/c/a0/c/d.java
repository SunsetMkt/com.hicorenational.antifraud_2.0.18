package c.b.c.a0.c;

import c.b.c.h;
import h.f1;

/* compiled from: Decoder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.n.c f2348a = new c.b.c.z.n.c(c.b.c.z.n.a.f3068m);

    public c.b.c.z.e a(boolean[][] zArr) throws h, c.b.c.d {
        int length = zArr.length;
        c.b.c.z.b bVar = new c.b.c.z.b(length);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i2][i3]) {
                    bVar.c(i3, i2);
                }
            }
        }
        return a(bVar);
    }

    public c.b.c.z.e a(c.b.c.z.b bVar) throws h, c.b.c.d {
        a aVar = new a(bVar);
        b[] a2 = b.a(aVar.b(), aVar.a());
        int length = a2.length;
        int i2 = 0;
        for (b bVar2 : a2) {
            i2 += bVar2.b();
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < length; i3++) {
            b bVar3 = a2[i3];
            byte[] a3 = bVar3.a();
            int b2 = bVar3.b();
            a(a3, b2);
            for (int i4 = 0; i4 < b2; i4++) {
                bArr[(i4 * length) + i3] = a3[i4];
            }
        }
        return c.a(bArr);
    }

    private void a(byte[] bArr, int i2) throws c.b.c.d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & f1.f16099c;
        }
        try {
            this.f2348a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (c.b.c.z.n.e unused) {
            throw c.b.c.d.getChecksumInstance();
        }
    }
}
