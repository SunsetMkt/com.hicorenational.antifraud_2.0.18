package c.b.c.z.n;

/* compiled from: ReedSolomonDecoder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final a f3078a;

    public c(a aVar) {
        this.f3078a = aVar;
    }

    public void a(int[] iArr, int i2) throws e {
        b bVar = new b(this.f3078a, iArr);
        int[] iArr2 = new int[i2];
        boolean z = true;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.f3078a;
            int a2 = bVar.a(aVar.a(aVar.a() + i3));
            iArr2[(iArr2.length - 1) - i3] = a2;
            if (a2 != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        b[] a3 = a(this.f3078a.a(i2, 1), new b(this.f3078a, iArr2), i2);
        b bVar2 = a3[0];
        b bVar3 = a3[1];
        int[] a4 = a(bVar2);
        int[] a5 = a(bVar3, a4);
        for (int i4 = 0; i4 < a4.length; i4++) {
            int length = (iArr.length - 1) - this.f3078a.c(a4[i4]);
            if (length < 0) {
                throw new e("Bad error location");
            }
            iArr[length] = a.c(iArr[length], a5[i4]);
        }
    }

    private b[] a(b bVar, b bVar2, int i2) throws e {
        if (bVar.b() < bVar2.b()) {
            bVar2 = bVar;
            bVar = bVar2;
        }
        b d2 = this.f3078a.d();
        b b2 = this.f3078a.b();
        do {
            b bVar3 = bVar2;
            bVar2 = bVar;
            bVar = bVar3;
            b bVar4 = b2;
            b bVar5 = d2;
            d2 = bVar4;
            if (bVar.b() >= i2 / 2) {
                if (!bVar.c()) {
                    b d3 = this.f3078a.d();
                    int b3 = this.f3078a.b(bVar.b(bVar.b()));
                    while (bVar2.b() >= bVar.b() && !bVar2.c()) {
                        int b4 = bVar2.b() - bVar.b();
                        int b5 = this.f3078a.b(bVar2.b(bVar2.b()), b3);
                        d3 = d3.a(this.f3078a.a(b4, b5));
                        bVar2 = bVar2.a(bVar.a(b4, b5));
                    }
                    b2 = d3.c(d2).a(bVar5);
                } else {
                    throw new e("r_{i-1} was zero");
                }
            } else {
                int b6 = d2.b(0);
                if (b6 != 0) {
                    int b7 = this.f3078a.b(b6);
                    return new b[]{d2.c(b7), bVar.c(b7)};
                }
                throw new e("sigmaTilde(0) was zero");
            }
        } while (bVar2.b() < bVar.b());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    private int[] a(b bVar) throws e {
        int b2 = bVar.b();
        int i2 = 0;
        if (b2 == 1) {
            return new int[]{bVar.b(1)};
        }
        int[] iArr = new int[b2];
        for (int i3 = 1; i3 < this.f3078a.c() && i2 < b2; i3++) {
            if (bVar.a(i3) == 0) {
                iArr[i2] = this.f3078a.b(i3);
                i2++;
            }
        }
        if (i2 == b2) {
            return iArr;
        }
        throw new e("Error locator degree does not match number of roots");
    }

    private int[] a(b bVar, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int b2 = this.f3078a.b(iArr[i2]);
            int i3 = 1;
            for (int i4 = 0; i4 < length; i4++) {
                if (i2 != i4) {
                    int b3 = this.f3078a.b(iArr[i4], b2);
                    i3 = this.f3078a.b(i3, (b3 & 1) == 0 ? b3 | 1 : b3 & (-2));
                }
            }
            iArr2[i2] = this.f3078a.b(bVar.a(b2), this.f3078a.b(i3));
            if (this.f3078a.a() != 0) {
                iArr2[i2] = this.f3078a.b(iArr2[i2], b2);
            }
        }
        return iArr2;
    }
}
