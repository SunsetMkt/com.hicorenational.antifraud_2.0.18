package c.b.c.e0.e.k;

import c.b.c.d;

/* compiled from: ErrorCorrection.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f2679a = b.f2680f;

    public int a(int[] iArr, int i2, int[] iArr2) throws d {
        c cVar = new c(this.f2679a, iArr);
        int[] iArr3 = new int[i2];
        boolean z = false;
        for (int i3 = i2; i3 > 0; i3--) {
            int a2 = cVar.a(this.f2679a.a(i3));
            iArr3[i2 - i3] = a2;
            if (a2 != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        c a3 = this.f2679a.a();
        if (iArr2 != null) {
            c cVar2 = a3;
            for (int i4 : iArr2) {
                int a4 = this.f2679a.a((iArr.length - 1) - i4);
                b bVar = this.f2679a;
                cVar2 = cVar2.c(new c(bVar, new int[]{bVar.d(0, a4), 1}));
            }
        }
        c[] a5 = a(this.f2679a.b(i2, 1), new c(this.f2679a, iArr3), i2);
        c cVar3 = a5[0];
        c cVar4 = a5[1];
        int[] a6 = a(cVar3);
        int[] a7 = a(cVar4, cVar3, a6);
        for (int i5 = 0; i5 < a6.length; i5++) {
            int length = (iArr.length - 1) - this.f2679a.c(a6[i5]);
            if (length < 0) {
                throw d.getChecksumInstance();
            }
            iArr[length] = this.f2679a.d(iArr[length], a7[i5]);
        }
        return a6.length;
    }

    private c[] a(c cVar, c cVar2, int i2) throws d {
        if (cVar.b() < cVar2.b()) {
            cVar2 = cVar;
            cVar = cVar2;
        }
        c c2 = this.f2679a.c();
        c a2 = this.f2679a.a();
        while (true) {
            c cVar3 = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
            c cVar4 = a2;
            c cVar5 = c2;
            c2 = cVar4;
            if (cVar.b() >= i2 / 2) {
                if (!cVar.c()) {
                    c c3 = this.f2679a.c();
                    int b2 = this.f2679a.b(cVar.b(cVar.b()));
                    while (cVar2.b() >= cVar.b() && !cVar2.c()) {
                        int b3 = cVar2.b() - cVar.b();
                        int c4 = this.f2679a.c(cVar2.b(cVar2.b()), b2);
                        c3 = c3.a(this.f2679a.b(b3, c4));
                        cVar2 = cVar2.d(cVar.a(b3, c4));
                    }
                    a2 = c3.c(c2).d(cVar5).d();
                } else {
                    throw d.getChecksumInstance();
                }
            } else {
                int b4 = c2.b(0);
                if (b4 != 0) {
                    int b5 = this.f2679a.b(b4);
                    return new c[]{c2.c(b5), cVar.c(b5)};
                }
                throw d.getChecksumInstance();
            }
        }
    }

    private int[] a(c cVar) throws d {
        int b2 = cVar.b();
        int[] iArr = new int[b2];
        int i2 = 0;
        for (int i3 = 1; i3 < this.f2679a.b() && i2 < b2; i3++) {
            if (cVar.a(i3) == 0) {
                iArr[i2] = this.f2679a.b(i3);
                i2++;
            }
        }
        if (i2 == b2) {
            return iArr;
        }
        throw d.getChecksumInstance();
    }

    private int[] a(c cVar, c cVar2, int[] iArr) {
        int b2 = cVar2.b();
        int[] iArr2 = new int[b2];
        for (int i2 = 1; i2 <= b2; i2++) {
            iArr2[b2 - i2] = this.f2679a.c(i2, cVar2.b(i2));
        }
        c cVar3 = new c(this.f2679a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            int b3 = this.f2679a.b(iArr[i3]);
            iArr3[i3] = this.f2679a.c(this.f2679a.d(0, cVar.a(b3)), this.f2679a.b(cVar3.a(b3)));
        }
        return iArr3;
    }
}
