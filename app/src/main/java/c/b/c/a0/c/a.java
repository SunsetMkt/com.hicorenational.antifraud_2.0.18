package c.b.c.a0.c;

import c.b.c.h;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2336a;

    /* renamed from: b, reason: collision with root package name */
    private final c.b.c.z.b f2337b;

    /* renamed from: c, reason: collision with root package name */
    private final e f2338c;

    a(c.b.c.z.b bVar) throws h {
        int d2 = bVar.d();
        if (d2 < 8 || d2 > 144 || (d2 & 1) != 0) {
            throw h.getFormatInstance();
        }
        this.f2338c = b(bVar);
        this.f2336a = a(bVar);
        this.f2337b = new c.b.c.z.b(this.f2336a.g(), this.f2336a.d());
    }

    private static e b(c.b.c.z.b bVar) throws h {
        return e.a(bVar.d(), bVar.g());
    }

    e a() {
        return this.f2338c;
    }

    int c(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (a(i4, 0, i2, i3) ? 1 : 0) << 1;
        int i6 = i3 - 1;
        if (a(i4, i6, i2, i3)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i3 - 3;
        if (a(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i3 - 2;
        if (a(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(0, i6, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(1, i8, i2, i3)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(1, i10, i2, i3)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return a(1, i6, i2, i3) ? i14 | 1 : i14;
    }

    int d(int i2, int i3) {
        int i4 = (a(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (a(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i3 - 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i3 - 1;
        if (a(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (a(1, i8, i2, i3)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (a(2, i8, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return a(3, i8, i2, i3) ? i11 | 1 : i11;
    }

    boolean a(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.f2337b.c(i3, i2);
        return this.f2336a.b(i3, i2);
    }

    int a(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (a(i4, 0, i2, i3) ? 1 : 0) << 1;
        if (a(i4, 1, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(i4, 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i3 - 2, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i3 - 1;
        if (a(0, i9, i2, i3)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (a(1, i9, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (a(2, i9, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return a(3, i9, i2, i3) ? i12 | 1 : i12;
    }

    byte[] b() throws h {
        byte[] bArr = new byte[this.f2338c.f()];
        int d2 = this.f2336a.d();
        int g2 = this.f2336a.g();
        int i2 = 4;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i2 == d2 && i3 == 0 && !z) {
                bArr[i4] = (byte) a(d2, g2);
                i2 -= 2;
                i3 += 2;
                i4++;
                z = true;
            } else {
                int i5 = d2 - 2;
                if (i2 == i5 && i3 == 0 && (g2 & 3) != 0 && !z2) {
                    bArr[i4] = (byte) b(d2, g2);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z2 = true;
                } else if (i2 == d2 + 4 && i3 == 2 && (g2 & 7) == 0 && !z3) {
                    bArr[i4] = (byte) c(d2, g2);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z3 = true;
                } else if (i2 == i5 && i3 == 0 && (g2 & 7) == 4 && !z4) {
                    bArr[i4] = (byte) d(d2, g2);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z4 = true;
                } else {
                    do {
                        if (i2 < d2 && i3 >= 0 && !this.f2337b.b(i3, i2)) {
                            bArr[i4] = (byte) b(i2, i3, d2, g2);
                            i4++;
                        }
                        i2 -= 2;
                        i3 += 2;
                        if (i2 < 0) {
                            break;
                        }
                    } while (i3 < g2);
                    int i6 = i2 + 1;
                    int i7 = i3 + 3;
                    do {
                        if (i6 >= 0 && i7 < g2 && !this.f2337b.b(i7, i6)) {
                            bArr[i4] = (byte) b(i6, i7, d2, g2);
                            i4++;
                        }
                        i6 += 2;
                        i7 -= 2;
                        if (i6 >= d2) {
                            break;
                        }
                    } while (i7 >= 0);
                    i2 = i6 + 3;
                    i3 = i7 + 1;
                }
            }
            if (i2 >= d2 && i3 >= g2) {
                break;
            }
        }
        if (i4 == this.f2338c.f()) {
            return bArr;
        }
        throw h.getFormatInstance();
    }

    c.b.c.z.b a(c.b.c.z.b bVar) {
        int e2 = this.f2338c.e();
        int d2 = this.f2338c.d();
        if (bVar.d() == e2) {
            int b2 = this.f2338c.b();
            int a2 = this.f2338c.a();
            int i2 = e2 / b2;
            int i3 = d2 / a2;
            c.b.c.z.b bVar2 = new c.b.c.z.b(i3 * a2, i2 * b2);
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i4 * b2;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = i6 * a2;
                    for (int i8 = 0; i8 < b2; i8++) {
                        int i9 = ((b2 + 2) * i4) + 1 + i8;
                        int i10 = i5 + i8;
                        for (int i11 = 0; i11 < a2; i11++) {
                            if (bVar.b(((a2 + 2) * i6) + 1 + i11, i9)) {
                                bVar2.c(i7 + i11, i10);
                            }
                        }
                    }
                }
            }
            return bVar2;
        }
        throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
    }

    int b(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (a(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (a(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (a(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (a(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (a(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return a(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    int b(int i2, int i3) {
        int i4 = (a(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (a(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (a(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (a(0, i3 - 4, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (a(0, i3 - 3, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (a(0, i3 - 2, i2, i3)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i3 - 1;
        if (a(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        return a(1, i10, i2, i3) ? i11 | 1 : i11;
    }
}
