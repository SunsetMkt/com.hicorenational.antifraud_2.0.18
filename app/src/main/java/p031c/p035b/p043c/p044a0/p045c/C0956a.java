package p031c.p035b.p043c.p044a0.p045c;

import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: BitMatrixParser.java */
/* renamed from: c.b.c.a0.c.a */
/* loaded from: classes.dex */
final class C0956a {

    /* renamed from: a */
    private final C1163b f1650a;

    /* renamed from: b */
    private final C1163b f1651b;

    /* renamed from: c */
    private final C0960e f1652c;

    C0956a(C1163b c1163b) throws C1097h {
        int m2177d = c1163b.m2177d();
        if (m2177d < 8 || m2177d > 144 || (m2177d & 1) != 0) {
            throw C1097h.getFormatInstance();
        }
        this.f1652c = m1191b(c1163b);
        this.f1650a = m1194a(c1163b);
        this.f1651b = new C1163b(this.f1650a.m2181g(), this.f1650a.m2177d());
    }

    /* renamed from: b */
    private static C0960e m1191b(C1163b c1163b) throws C1097h {
        return C0960e.m1216a(c1163b.m2177d(), c1163b.m2181g());
    }

    /* renamed from: a */
    C0960e m1193a() {
        return this.f1652c;
    }

    /* renamed from: c */
    int m1199c(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (m1195a(i4, 0, i2, i3) ? 1 : 0) << 1;
        int i6 = i3 - 1;
        if (m1195a(i4, i6, i2, i3)) {
            i5 |= 1;
        }
        int i7 = i5 << 1;
        int i8 = i3 - 3;
        if (m1195a(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i3 - 2;
        if (m1195a(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (m1195a(0, i6, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (m1195a(1, i8, i2, i3)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (m1195a(1, i10, i2, i3)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        return m1195a(1, i6, i2, i3) ? i14 | 1 : i14;
    }

    /* renamed from: d */
    int m1200d(int i2, int i3) {
        int i4 = (m1195a(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (m1195a(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (m1195a(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (m1195a(0, i3 - 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i3 - 1;
        if (m1195a(0, i8, i2, i3)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (m1195a(1, i8, i2, i3)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (m1195a(2, i8, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return m1195a(3, i8, i2, i3) ? i11 | 1 : i11;
    }

    /* renamed from: a */
    boolean m1195a(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            i2 += i4;
            i3 += 4 - ((i4 + 4) & 7);
        }
        if (i3 < 0) {
            i3 += i5;
            i2 += 4 - ((i5 + 4) & 7);
        }
        this.f1651b.m2175c(i3, i2);
        return this.f1650a.m2173b(i3, i2);
    }

    /* renamed from: a */
    int m1192a(int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = (m1195a(i4, 0, i2, i3) ? 1 : 0) << 1;
        if (m1195a(i4, 1, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (m1195a(i4, 2, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (m1195a(0, i3 - 2, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i3 - 1;
        if (m1195a(0, i9, i2, i3)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (m1195a(1, i9, i2, i3)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (m1195a(2, i9, i2, i3)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        return m1195a(3, i9, i2, i3) ? i12 | 1 : i12;
    }

    /* renamed from: b */
    byte[] m1198b() throws C1097h {
        byte[] bArr = new byte[this.f1652c.m1223f()];
        int m2177d = this.f1650a.m2177d();
        int m2181g = this.f1650a.m2181g();
        int i2 = 4;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            if (i2 == m2177d && i3 == 0 && !z) {
                bArr[i4] = (byte) m1192a(m2177d, m2181g);
                i2 -= 2;
                i3 += 2;
                i4++;
                z = true;
            } else {
                int i5 = m2177d - 2;
                if (i2 == i5 && i3 == 0 && (m2181g & 3) != 0 && !z2) {
                    bArr[i4] = (byte) m1196b(m2177d, m2181g);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z2 = true;
                } else if (i2 == m2177d + 4 && i3 == 2 && (m2181g & 7) == 0 && !z3) {
                    bArr[i4] = (byte) m1199c(m2177d, m2181g);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z3 = true;
                } else if (i2 == i5 && i3 == 0 && (m2181g & 7) == 4 && !z4) {
                    bArr[i4] = (byte) m1200d(m2177d, m2181g);
                    i2 -= 2;
                    i3 += 2;
                    i4++;
                    z4 = true;
                } else {
                    do {
                        if (i2 < m2177d && i3 >= 0 && !this.f1651b.m2173b(i3, i2)) {
                            bArr[i4] = (byte) m1197b(i2, i3, m2177d, m2181g);
                            i4++;
                        }
                        i2 -= 2;
                        i3 += 2;
                        if (i2 < 0) {
                            break;
                        }
                    } while (i3 < m2181g);
                    int i6 = i2 + 1;
                    int i7 = i3 + 3;
                    do {
                        if (i6 >= 0 && i7 < m2181g && !this.f1651b.m2173b(i7, i6)) {
                            bArr[i4] = (byte) m1197b(i6, i7, m2177d, m2181g);
                            i4++;
                        }
                        i6 += 2;
                        i7 -= 2;
                        if (i6 >= m2177d) {
                            break;
                        }
                    } while (i7 >= 0);
                    i2 = i6 + 3;
                    i3 = i7 + 1;
                }
            }
            if (i2 >= m2177d && i3 >= m2181g) {
                break;
            }
        }
        if (i4 == this.f1652c.m1223f()) {
            return bArr;
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: a */
    C1163b m1194a(C1163b c1163b) {
        int m1222e = this.f1652c.m1222e();
        int m1221d = this.f1652c.m1221d();
        if (c1163b.m2177d() == m1222e) {
            int m1219b = this.f1652c.m1219b();
            int m1218a = this.f1652c.m1218a();
            int i2 = m1222e / m1219b;
            int i3 = m1221d / m1218a;
            C1163b c1163b2 = new C1163b(i3 * m1218a, i2 * m1219b);
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = i4 * m1219b;
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = i6 * m1218a;
                    for (int i8 = 0; i8 < m1219b; i8++) {
                        int i9 = ((m1219b + 2) * i4) + 1 + i8;
                        int i10 = i5 + i8;
                        for (int i11 = 0; i11 < m1218a; i11++) {
                            if (c1163b.m2173b(((m1218a + 2) * i6) + 1 + i11, i9)) {
                                c1163b2.m2175c(i7 + i11, i10);
                            }
                        }
                    }
                }
            }
            return c1163b2;
        }
        throw new IllegalArgumentException("Dimension of bitMarix must match the version size");
    }

    /* renamed from: b */
    int m1197b(int i2, int i3, int i4, int i5) {
        int i6 = i2 - 2;
        int i7 = i3 - 2;
        int i8 = (m1195a(i6, i7, i4, i5) ? 1 : 0) << 1;
        int i9 = i3 - 1;
        if (m1195a(i6, i9, i4, i5)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        int i11 = i2 - 1;
        if (m1195a(i11, i7, i4, i5)) {
            i10 |= 1;
        }
        int i12 = i10 << 1;
        if (m1195a(i11, i9, i4, i5)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (m1195a(i11, i3, i4, i5)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (m1195a(i2, i7, i4, i5)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (m1195a(i2, i9, i4, i5)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        return m1195a(i2, i3, i4, i5) ? i16 | 1 : i16;
    }

    /* renamed from: b */
    int m1196b(int i2, int i3) {
        int i4 = (m1195a(i2 + (-3), 0, i2, i3) ? 1 : 0) << 1;
        if (m1195a(i2 - 2, 0, i2, i3)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (m1195a(i2 - 1, 0, i2, i3)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (m1195a(0, i3 - 4, i2, i3)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (m1195a(0, i3 - 3, i2, i3)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        if (m1195a(0, i3 - 2, i2, i3)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        int i10 = i3 - 1;
        if (m1195a(0, i10, i2, i3)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        return m1195a(1, i10, i2, i3) ? i11 | 1 : i11;
    }
}
