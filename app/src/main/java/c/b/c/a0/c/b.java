package c.b.c.a0.c;

import c.b.c.a0.c.e;

/* compiled from: DataBlock.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f2339a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2340b;

    private b(int i2, byte[] bArr) {
        this.f2339a = i2;
        this.f2340b = bArr;
    }

    static b[] a(byte[] bArr, e eVar) {
        e.c c2 = eVar.c();
        e.b[] a2 = c2.a();
        int i2 = 0;
        for (e.b bVar : a2) {
            i2 += bVar.a();
        }
        b[] bVarArr = new b[i2];
        int length = a2.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            e.b bVar2 = a2[i3];
            int i5 = i4;
            int i6 = 0;
            while (i6 < bVar2.a()) {
                int b2 = bVar2.b();
                bVarArr[i5] = new b(b2, new byte[c2.b() + b2]);
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
        int length2 = bVarArr[0].f2340b.length - c2.b();
        int i7 = length2 - 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i7) {
            int i10 = i9;
            int i11 = 0;
            while (i11 < i4) {
                bVarArr[i11].f2340b[i8] = bArr[i10];
                i11++;
                i10++;
            }
            i8++;
            i9 = i10;
        }
        boolean z = eVar.g() == 24;
        int i12 = z ? 8 : i4;
        int i13 = i9;
        int i14 = 0;
        while (i14 < i12) {
            bVarArr[i14].f2340b[i7] = bArr[i13];
            i14++;
            i13++;
        }
        int length3 = bVarArr[0].f2340b.length;
        while (length2 < length3) {
            int i15 = 0;
            while (i15 < i4) {
                int i16 = z ? (i15 + 8) % i4 : i15;
                bVarArr[i16].f2340b[(!z || i16 <= 7) ? length2 : length2 - 1] = bArr[i13];
                i15++;
                i13++;
            }
            length2++;
        }
        if (i13 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    int b() {
        return this.f2339a;
    }

    byte[] a() {
        return this.f2340b;
    }
}
