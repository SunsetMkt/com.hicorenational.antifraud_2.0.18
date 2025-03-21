package c.b.c.x.f;

/* compiled from: Encoder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f2880a = 33;

    /* renamed from: b, reason: collision with root package name */
    public static final int f2881b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2882c = 32;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2883d = 4;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f2884e = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private c() {
    }

    private static int a(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 * 16)) * i2;
    }

    public static a a(byte[] bArr) {
        return a(bArr, 33, 0);
    }

    private static c.b.c.z.a b(c.b.c.z.a aVar, int i2, int i3) {
        int c2 = aVar.c() / i3;
        c.b.c.z.n.d dVar = new c.b.c.z.n.d(a(i3));
        int i4 = i2 / i3;
        int[] a2 = a(aVar, i3, i4);
        dVar.a(a2, i4 - c2);
        c.b.c.z.a aVar2 = new c.b.c.z.a();
        aVar2.a(0, i2 % i3);
        for (int i5 : a2) {
            aVar2.a(i5, i3);
        }
        return aVar2;
    }

    public static a a(byte[] bArr, int i2, int i3) {
        int i4;
        c.b.c.z.a aVar;
        boolean z;
        int i5;
        int i6;
        int i7;
        c.b.c.z.a a2 = new d(bArr).a();
        int c2 = ((a2.c() * i2) / 100) + 11;
        int c3 = a2.c() + c2;
        int i8 = 0;
        int i9 = 1;
        if (i3 == 0) {
            c.b.c.z.a aVar2 = null;
            int i10 = 0;
            i4 = 0;
            while (i10 <= 32) {
                boolean z2 = i10 <= 3;
                int i11 = z2 ? i10 + 1 : i10;
                int a3 = a(i11, z2);
                if (c3 <= a3) {
                    int[] iArr = f2884e;
                    if (i4 != iArr[i11]) {
                        i4 = iArr[i11];
                        aVar2 = a(a2, i4);
                    }
                    int i12 = a3 - (a3 % i4);
                    if ((!z2 || aVar2.c() <= i4 * 64) && aVar2.c() + c2 <= i12) {
                        aVar = aVar2;
                        z = z2;
                        i5 = i11;
                        i6 = a3;
                    }
                }
                i10++;
                i8 = 0;
                i9 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z = i3 < 0;
        i5 = Math.abs(i3);
        if (i5 > (z ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
        }
        i6 = a(i5, z);
        i4 = f2884e[i5];
        int i13 = i6 - (i6 % i4);
        aVar = a(a2, i4);
        if (aVar.c() + c2 > i13) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z && aVar.c() > i4 * 64) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        c.b.c.z.a b2 = b(aVar, i6, i4);
        int c4 = aVar.c() / i4;
        c.b.c.z.a a4 = a(z, i5, c4);
        int i14 = z ? (i5 * 4) + 11 : (i5 * 4) + 14;
        int[] iArr2 = new int[i14];
        int i15 = 2;
        if (z) {
            for (int i16 = 0; i16 < iArr2.length; i16++) {
                iArr2[i16] = i16;
            }
            i7 = i14;
        } else {
            int i17 = i14 / 2;
            i7 = i14 + 1 + (((i17 - 1) / 15) * 2);
            int i18 = i7 / 2;
            for (int i19 = 0; i19 < i17; i19++) {
                iArr2[(i17 - i19) - 1] = (i18 - r15) - 1;
                iArr2[i17 + i19] = (i19 / 15) + i19 + i18 + i9;
            }
        }
        c.b.c.z.b bVar = new c.b.c.z.b(i7);
        int i20 = 0;
        int i21 = 0;
        while (i20 < i5) {
            int i22 = (i5 - i20) * 4;
            int i23 = z ? i22 + 9 : i22 + 12;
            int i24 = 0;
            while (i24 < i23) {
                int i25 = i24 * 2;
                while (i8 < i15) {
                    if (b2.b(i21 + i25 + i8)) {
                        int i26 = i20 * 2;
                        bVar.c(iArr2[i26 + i8], iArr2[i26 + i24]);
                    }
                    if (b2.b((i23 * 2) + i21 + i25 + i8)) {
                        int i27 = i20 * 2;
                        bVar.c(iArr2[i27 + i24], iArr2[((i14 - 1) - i27) - i8]);
                    }
                    if (b2.b((i23 * 4) + i21 + i25 + i8)) {
                        int i28 = (i14 - 1) - (i20 * 2);
                        bVar.c(iArr2[i28 - i8], iArr2[i28 - i24]);
                    }
                    if (b2.b((i23 * 6) + i21 + i25 + i8)) {
                        int i29 = i20 * 2;
                        bVar.c(iArr2[((i14 - 1) - i29) - i24], iArr2[i29 + i8]);
                    }
                    i8++;
                    i15 = 2;
                }
                i24++;
                i8 = 0;
                i15 = 2;
            }
            i21 += i23 * 8;
            i20++;
            i8 = 0;
            i15 = 2;
        }
        a(bVar, z, i7, a4);
        if (z) {
            a(bVar, i7 / 2, 5);
        } else {
            int i30 = i7 / 2;
            a(bVar, i30, 7);
            int i31 = 0;
            int i32 = 0;
            while (i31 < (i14 / 2) - 1) {
                for (int i33 = i30 & 1; i33 < i7; i33 += 2) {
                    int i34 = i30 - i32;
                    bVar.c(i34, i33);
                    int i35 = i30 + i32;
                    bVar.c(i35, i33);
                    bVar.c(i33, i34);
                    bVar.c(i33, i35);
                }
                i31 += 15;
                i32 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.a(z);
        aVar3.c(i7);
        aVar3.b(i5);
        aVar3.a(c4);
        aVar3.a(bVar);
        return aVar3;
    }

    private static void a(c.b.c.z.b bVar, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    bVar.c(i6, i5);
                    bVar.c(i6, i7);
                    bVar.c(i5, i6);
                    bVar.c(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        bVar.c(i8, i8);
        int i9 = i8 + 1;
        bVar.c(i9, i8);
        bVar.c(i8, i9);
        int i10 = i2 + i3;
        bVar.c(i10, i8);
        bVar.c(i10, i9);
        bVar.c(i10, i10 - 1);
    }

    static c.b.c.z.a a(boolean z, int i2, int i3) {
        c.b.c.z.a aVar = new c.b.c.z.a();
        if (z) {
            aVar.a(i2 - 1, 2);
            aVar.a(i3 - 1, 6);
            return b(aVar, 28, 4);
        }
        aVar.a(i2 - 1, 5);
        aVar.a(i3 - 1, 11);
        return b(aVar, 40, 4);
    }

    private static void a(c.b.c.z.b bVar, boolean z, int i2, c.b.c.z.a aVar) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (aVar.b(i4)) {
                    bVar.c(i5, i3 - 5);
                }
                if (aVar.b(i4 + 7)) {
                    bVar.c(i3 + 5, i5);
                }
                if (aVar.b(20 - i4)) {
                    bVar.c(i5, i3 + 5);
                }
                if (aVar.b(27 - i4)) {
                    bVar.c(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (aVar.b(i4)) {
                bVar.c(i6, i3 - 7);
            }
            if (aVar.b(i4 + 10)) {
                bVar.c(i3 + 7, i6);
            }
            if (aVar.b(29 - i4)) {
                bVar.c(i6, i3 + 7);
            }
            if (aVar.b(39 - i4)) {
                bVar.c(i3 - 7, i6);
            }
            i4++;
        }
    }

    private static int[] a(c.b.c.z.a aVar, int i2, int i3) {
        int[] iArr = new int[i3];
        int c2 = aVar.c() / i2;
        for (int i4 = 0; i4 < c2; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= aVar.b((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    private static c.b.c.z.n.a a(int i2) {
        if (i2 == 4) {
            return c.b.c.z.n.a.f3066k;
        }
        if (i2 == 6) {
            return c.b.c.z.n.a.f3065j;
        }
        if (i2 == 8) {
            return c.b.c.z.n.a.n;
        }
        if (i2 == 10) {
            return c.b.c.z.n.a.f3064i;
        }
        if (i2 == 12) {
            return c.b.c.z.n.a.f3063h;
        }
        throw new IllegalArgumentException("Unsupported word size " + i2);
    }

    static c.b.c.z.a a(c.b.c.z.a aVar, int i2) {
        c.b.c.z.a aVar2 = new c.b.c.z.a();
        int c2 = aVar.c();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < c2) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= c2 || aVar.b(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                aVar2.a(i8, i2);
            } else if (i8 == 0) {
                aVar2.a(i5 | 1, i2);
            } else {
                aVar2.a(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return aVar2;
    }
}
