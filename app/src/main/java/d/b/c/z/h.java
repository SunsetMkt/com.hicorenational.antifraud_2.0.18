package d.b.c.z;

import d.b.c.m;
import i.f1;

/* JADX INFO: compiled from: GlobalHistogramBinarizer.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends d.b.c.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f10010d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f10011e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10012f = 32;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f10013g = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f10014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f10015c;

    public h(d.b.c.j jVar) {
        super(jVar);
        this.f10014b = f10013g;
        this.f10015c = new int[32];
    }

    @Override // d.b.c.b
    public a a(int i2, a aVar) throws m {
        d.b.c.j jVarC = c();
        int iC = jVarC.c();
        if (aVar == null || aVar.c() < iC) {
            aVar = new a(iC);
        } else {
            aVar.a();
        }
        a(iC);
        byte[] bArrA = jVarC.a(i2, this.f10014b);
        int[] iArr = this.f10015c;
        for (int i3 = 0; i3 < iC; i3++) {
            int i4 = (bArrA[i3] & f1.f12066c) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int iA = a(iArr);
        int i5 = bArrA[0] & f1.f12066c;
        int i6 = bArrA[1] & f1.f12066c;
        int i7 = i5;
        int i8 = 1;
        while (i8 < iC - 1) {
            int i9 = i8 + 1;
            int i10 = bArrA[i9] & f1.f12066c;
            if ((((i6 * 4) - i7) - i10) / 2 < iA) {
                aVar.e(i8);
            }
            i7 = i6;
            i8 = i9;
            i6 = i10;
        }
        return aVar;
    }

    @Override // d.b.c.b
    public b a() throws m {
        d.b.c.j jVarC = c();
        int iC = jVarC.c();
        int iA = jVarC.a();
        b bVar = new b(iC, iA);
        a(iC);
        int[] iArr = this.f10015c;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] bArrA = jVarC.a((iA * i2) / 5, this.f10014b);
            int i3 = (iC * 4) / 5;
            for (int i4 = iC / 5; i4 < i3; i4++) {
                int i5 = (bArrA[i4] & f1.f12066c) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int iA2 = a(iArr);
        byte[] bArrB = jVarC.b();
        for (int i6 = 0; i6 < iA; i6++) {
            int i7 = i6 * iC;
            for (int i8 = 0; i8 < iC; i8++) {
                if ((bArrB[i7 + i8] & f1.f12066c) < iA2) {
                    bVar.c(i8, i6);
                }
            }
        }
        return bVar;
    }

    @Override // d.b.c.b
    public d.b.c.b a(d.b.c.j jVar) {
        return new h(jVar);
    }

    private void a(int i2) {
        if (this.f10014b.length < i2) {
            this.f10014b = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f10015c[i3] = 0;
        }
    }

    private static int a(int[] iArr) throws m {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] > i2) {
                i2 = iArr[i5];
                i4 = i5;
            }
            if (iArr[i5] > i3) {
                i3 = iArr[i5];
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i4;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i4 > i6) {
            int i11 = i4;
            i4 = i6;
            i6 = i11;
        }
        if (i6 - i4 <= length / 16) {
            throw m.getNotFoundInstance();
        }
        int i12 = i6 - 1;
        int i13 = i12;
        int i14 = -1;
        while (i12 > i4) {
            int i15 = i12 - i4;
            int i16 = i15 * i15 * (i6 - i12) * (i3 - iArr[i12]);
            if (i16 > i14) {
                i13 = i12;
                i14 = i16;
            }
            i12--;
        }
        return i13 << 3;
    }
}
