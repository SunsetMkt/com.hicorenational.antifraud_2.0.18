package c.b.c.e0.e.k;

/* compiled from: ModulusPoly.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f2686a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f2687b;

    c(b bVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f2686a = bVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f2687b = iArr;
            return;
        }
        int i2 = 1;
        while (i2 < length && iArr[i2] == 0) {
            i2++;
        }
        if (i2 == length) {
            this.f2687b = new int[]{0};
            return;
        }
        this.f2687b = new int[length - i2];
        int[] iArr2 = this.f2687b;
        System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
    }

    int[] a() {
        return this.f2687b;
    }

    int b() {
        return this.f2687b.length - 1;
    }

    boolean c() {
        return this.f2687b[0] == 0;
    }

    c d(c cVar) {
        if (this.f2686a.equals(cVar.f2686a)) {
            return cVar.c() ? this : a(cVar.d());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b2 = b(); b2 >= 0; b2--) {
            int b3 = b(b2);
            if (b3 != 0) {
                if (b3 < 0) {
                    sb.append(" - ");
                    b3 = -b3;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b2 == 0 || b3 != 1) {
                    sb.append(b3);
                }
                if (b2 != 0) {
                    if (b2 == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b2);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i2) {
        if (i2 == 0) {
            return b(0);
        }
        int[] iArr = this.f2687b;
        int length = iArr.length;
        if (i2 != 1) {
            int i3 = iArr[0];
            for (int i4 = 1; i4 < length; i4++) {
                b bVar = this.f2686a;
                i3 = bVar.a(bVar.c(i2, i3), this.f2687b[i4]);
            }
            return i3;
        }
        int i5 = 0;
        for (int i6 : iArr) {
            i5 = this.f2686a.a(i5, i6);
        }
        return i5;
    }

    int b(int i2) {
        return this.f2687b[(r0.length - 1) - i2];
    }

    c c(c cVar) {
        if (!this.f2686a.equals(cVar.f2686a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (c() || cVar.c()) {
            return this.f2686a.c();
        }
        int[] iArr = this.f2687b;
        int length = iArr.length;
        int[] iArr2 = cVar.f2687b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = iArr[i2];
            for (int i4 = 0; i4 < length2; i4++) {
                int i5 = i2 + i4;
                b bVar = this.f2686a;
                iArr3[i5] = bVar.a(iArr3[i5], bVar.c(i3, iArr2[i4]));
            }
        }
        return new c(this.f2686a, iArr3);
    }

    c[] b(c cVar) {
        if (this.f2686a.equals(cVar.f2686a)) {
            if (!cVar.c()) {
                c c2 = this.f2686a.c();
                int b2 = this.f2686a.b(cVar.b(cVar.b()));
                c cVar2 = c2;
                c cVar3 = this;
                while (cVar3.b() >= cVar.b() && !cVar3.c()) {
                    int b3 = cVar3.b() - cVar.b();
                    int c3 = this.f2686a.c(cVar3.b(cVar3.b()), b2);
                    c a2 = cVar.a(b3, c3);
                    cVar2 = cVar2.a(this.f2686a.b(b3, c3));
                    cVar3 = cVar3.d(a2);
                }
                return new c[]{cVar2, cVar3};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    c d() {
        int length = this.f2687b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f2686a.d(0, this.f2687b[i2]);
        }
        return new c(this.f2686a, iArr);
    }

    c a(c cVar) {
        if (this.f2686a.equals(cVar.f2686a)) {
            if (c()) {
                return cVar;
            }
            if (cVar.c()) {
                return this;
            }
            int[] iArr = this.f2687b;
            int[] iArr2 = cVar.f2687b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr2.length; i2++) {
                iArr3[i2] = this.f2686a.a(iArr[i2 - length], iArr2[i2]);
            }
            return new c(this.f2686a, iArr3);
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    c c(int i2) {
        if (i2 == 0) {
            return this.f2686a.c();
        }
        if (i2 == 1) {
            return this;
        }
        int length = this.f2687b.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f2686a.c(this.f2687b[i3], i2);
        }
        return new c(this.f2686a, iArr);
    }

    c a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f2686a.c();
        }
        int length = this.f2687b.length;
        int[] iArr = new int[i2 + length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f2686a.c(this.f2687b[i4], i3);
        }
        return new c(this.f2686a, iArr);
    }
}
