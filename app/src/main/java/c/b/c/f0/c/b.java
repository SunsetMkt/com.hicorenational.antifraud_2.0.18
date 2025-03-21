package c.b.c.f0.c;

import c.b.c.f0.c.j;

/* compiled from: DataBlock.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f2748a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f2749b;

    private b(int i2, byte[] bArr) {
        this.f2748a = i2;
        this.f2749b = bArr;
    }

    static b[] a(byte[] bArr, j jVar, f fVar) {
        if (bArr.length != jVar.d()) {
            throw new IllegalArgumentException();
        }
        j.b a2 = jVar.a(fVar);
        j.a[] a3 = a2.a();
        int i2 = 0;
        for (j.a aVar : a3) {
            i2 += aVar.a();
        }
        b[] bVarArr = new b[i2];
        int length = a3.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            j.a aVar2 = a3[i3];
            int i5 = i4;
            int i6 = 0;
            while (i6 < aVar2.a()) {
                int b2 = aVar2.b();
                bVarArr[i5] = new b(b2, new byte[a2.b() + b2]);
                i6++;
                i5++;
            }
            i3++;
            i4 = i5;
        }
        int length2 = bVarArr[0].f2749b.length;
        int length3 = bVarArr.length - 1;
        while (length3 >= 0 && bVarArr[length3].f2749b.length != length2) {
            length3--;
        }
        int i7 = length3 + 1;
        int b3 = length2 - a2.b();
        int i8 = 0;
        int i9 = 0;
        while (i8 < b3) {
            int i10 = i9;
            int i11 = 0;
            while (i11 < i4) {
                bVarArr[i11].f2749b[i8] = bArr[i10];
                i11++;
                i10++;
            }
            i8++;
            i9 = i10;
        }
        int i12 = i7;
        while (i12 < i4) {
            bVarArr[i12].f2749b[b3] = bArr[i9];
            i12++;
            i9++;
        }
        int length4 = bVarArr[0].f2749b.length;
        while (b3 < length4) {
            int i13 = i9;
            int i14 = 0;
            while (i14 < i4) {
                bVarArr[i14].f2749b[i14 < i7 ? b3 : b3 + 1] = bArr[i13];
                i14++;
                i13++;
            }
            b3++;
            i9 = i13;
        }
        return bVarArr;
    }

    int b() {
        return this.f2748a;
    }

    byte[] a() {
        return this.f2749b;
    }
}
