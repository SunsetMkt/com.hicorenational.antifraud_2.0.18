package d.b.c.f0.c;

import d.b.c.f0.c.j;

/* JADX INFO: compiled from: DataBlock.java */
/* JADX INFO: loaded from: classes.dex */
final class b {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f9783b;

    private b(int i2, byte[] bArr) {
        this.a = i2;
        this.f9783b = bArr;
    }

    static b[] a(byte[] bArr, j jVar, f fVar) {
        if (bArr.length != jVar.d()) {
            throw new IllegalArgumentException();
        }
        j.b bVarA = jVar.a(fVar);
        j.a[] aVarArrA = bVarA.a();
        int iA = 0;
        for (j.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        b[] bVarArr = new b[iA];
        int length = aVarArrA.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            j.a aVar2 = aVarArrA[i2];
            int i4 = i3;
            int i5 = 0;
            while (i5 < aVar2.a()) {
                int iB = aVar2.b();
                bVarArr[i4] = new b(iB, new byte[bVarA.b() + iB]);
                i5++;
                i4++;
            }
            i2++;
            i3 = i4;
        }
        int length2 = bVarArr[0].f9783b.length;
        int length3 = bVarArr.length - 1;
        while (length3 >= 0 && bVarArr[length3].f9783b.length != length2) {
            length3--;
        }
        int i6 = length3 + 1;
        int iB2 = length2 - bVarA.b();
        int i7 = 0;
        int i8 = 0;
        while (i7 < iB2) {
            int i9 = i8;
            int i10 = 0;
            while (i10 < i3) {
                bVarArr[i10].f9783b[i7] = bArr[i9];
                i10++;
                i9++;
            }
            i7++;
            i8 = i9;
        }
        int i11 = i6;
        while (i11 < i3) {
            bVarArr[i11].f9783b[iB2] = bArr[i8];
            i11++;
            i8++;
        }
        int length4 = bVarArr[0].f9783b.length;
        while (iB2 < length4) {
            int i12 = i8;
            int i13 = 0;
            while (i13 < i3) {
                bVarArr[i13].f9783b[i13 < i6 ? iB2 : iB2 + 1] = bArr[i12];
                i13++;
                i12++;
            }
            iB2++;
            i8 = i12;
        }
        return bVarArr;
    }

    int b() {
        return this.a;
    }

    byte[] a() {
        return this.f9783b;
    }
}
