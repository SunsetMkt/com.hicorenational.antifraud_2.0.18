package p031c.p035b.p043c.p072z;

import java.lang.reflect.Array;
import p031c.p035b.p043c.AbstractC0976b;
import p031c.p035b.p043c.AbstractC1099j;
import p031c.p035b.p043c.C1102m;
import p286h.C5230f1;

/* compiled from: HybridBinarizer.java */
/* renamed from: c.b.c.z.j */
/* loaded from: classes.dex */
public final class C1171j extends C1169h {

    /* renamed from: i */
    private static final int f2416i = 3;

    /* renamed from: j */
    private static final int f2417j = 8;

    /* renamed from: k */
    private static final int f2418k = 7;

    /* renamed from: l */
    private static final int f2419l = 40;

    /* renamed from: m */
    private static final int f2420m = 24;

    /* renamed from: h */
    private C1163b f2421h;

    public C1171j(AbstractC1099j abstractC1099j) {
        super(abstractC1099j);
    }

    /* renamed from: a */
    private static int m2209a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    @Override // p031c.p035b.p043c.p072z.C1169h, p031c.p035b.p043c.AbstractC0976b
    /* renamed from: a */
    public C1163b mo1324a() throws C1102m {
        C1163b c1163b = this.f2421h;
        if (c1163b != null) {
            return c1163b;
        }
        AbstractC1099j m1326c = m1326c();
        int m1902c = m1326c.m1902c();
        int m1901a = m1326c.m1901a();
        if (m1902c < 40 || m1901a < 40) {
            this.f2421h = super.mo1324a();
        } else {
            byte[] mo1895b = m1326c.mo1895b();
            int i2 = m1902c >> 3;
            if ((m1902c & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = m1901a >> 3;
            if ((m1901a & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] m2212a = m2212a(mo1895b, i3, i5, m1902c, m1901a);
            C1163b c1163b2 = new C1163b(m1902c, m1901a);
            m2211a(mo1895b, i3, i5, m1902c, m1901a, m2212a, c1163b2);
            this.f2421h = c1163b2;
        }
        return this.f2421h;
    }

    @Override // p031c.p035b.p043c.p072z.C1169h, p031c.p035b.p043c.AbstractC0976b
    /* renamed from: a */
    public AbstractC0976b mo1322a(AbstractC1099j abstractC1099j) {
        return new C1171j(abstractC1099j);
    }

    /* renamed from: a */
    private static void m2211a(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, C1163b c1163b) {
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i6 << 3;
            int i8 = i5 - 8;
            if (i7 > i8) {
                i7 = i8;
            }
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = i9 << 3;
                int i11 = i4 - 8;
                if (i10 <= i11) {
                    i11 = i10;
                }
                int m2209a = m2209a(i9, 2, i2 - 3);
                int m2209a2 = m2209a(i6, 2, i3 - 3);
                int i12 = 0;
                for (int i13 = -2; i13 <= 2; i13++) {
                    int[] iArr2 = iArr[m2209a2 + i13];
                    i12 += iArr2[m2209a - 2] + iArr2[m2209a - 1] + iArr2[m2209a] + iArr2[m2209a + 1] + iArr2[m2209a + 2];
                }
                m2210a(bArr, i11, i7, i12 / 25, i4, c1163b);
            }
        }
    }

    /* renamed from: a */
    private static void m2210a(byte[] bArr, int i2, int i3, int i4, int i5, C1163b c1163b) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    c1163b.m2175c(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    /* renamed from: a */
    private static int[][] m2212a(byte[] bArr, int i2, int i3, int i4, int i5) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i3, i2);
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i6 << 3;
            int i8 = i5 - 8;
            if (i7 > i8) {
                i7 = i8;
            }
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = i9 << 3;
                int i11 = i4 - 8;
                if (i10 > i11) {
                    i10 = i11;
                }
                int i12 = (i7 * i4) + i10;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                int i16 = 255;
                while (i13 < 8) {
                    int i17 = i14;
                    for (int i18 = 0; i18 < 8; i18++) {
                        int i19 = bArr[i12 + i18] & C5230f1.f20085c;
                        i17 += i19;
                        if (i19 < i16) {
                            i16 = i19;
                        }
                        if (i19 > i15) {
                            i15 = i19;
                        }
                    }
                    if (i15 - i16 > 24) {
                        while (true) {
                            i13++;
                            i12 += i4;
                            if (i13 < 8) {
                                for (int i20 = 0; i20 < 8; i20++) {
                                    i17 += bArr[i12 + i20] & C5230f1.f20085c;
                                }
                            }
                        }
                    }
                    i14 = i17;
                    i13++;
                    i12 += i4;
                }
                int i21 = i14 >> 6;
                if (i15 - i16 <= 24) {
                    i21 = i16 / 2;
                    if (i6 > 0 && i9 > 0) {
                        int i22 = i6 - 1;
                        int i23 = i9 - 1;
                        int i24 = ((iArr[i22][i9] + (iArr[i6][i23] * 2)) + iArr[i22][i23]) / 4;
                        if (i16 < i24) {
                            i21 = i24;
                        }
                    }
                }
                iArr[i6][i9] = i21;
            }
        }
        return iArr;
    }
}
