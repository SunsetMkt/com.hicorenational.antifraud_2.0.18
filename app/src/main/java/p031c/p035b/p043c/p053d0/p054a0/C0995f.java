package p031c.p035b.p043c.p053d0.p054a0;

/* compiled from: RSSUtils.java */
/* renamed from: c.b.c.d0.a0.f */
/* loaded from: classes.dex */
public final class C0995f {
    private C0995f() {
    }

    /* renamed from: a */
    public static int m1395a(int[] iArr, int i2, boolean z) {
        int[] iArr2 = iArr;
        int length = iArr2.length;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int i5 = i3;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = length - 1;
            if (i6 >= i9) {
                return i7;
            }
            int i10 = 1 << i6;
            int i11 = i8 | i10;
            int i12 = i7;
            int i13 = 1;
            while (i13 < iArr2[i6]) {
                int i14 = i5 - i13;
                int i15 = length - i6;
                int i16 = i15 - 2;
                int m1394a = m1394a(i14 - 1, i16);
                if (z && i11 == 0) {
                    int i17 = i15 - 1;
                    if (i14 - i17 >= i17) {
                        m1394a -= m1394a(i14 - i15, i16);
                    }
                }
                if (i15 - 1 > 1) {
                    int i18 = 0;
                    for (int i19 = i14 - i16; i19 > i2; i19--) {
                        i18 += m1394a((i14 - i19) - 1, i15 - 3);
                    }
                    m1394a -= i18 * (i9 - i6);
                } else if (i14 > i2) {
                    m1394a--;
                }
                i12 += m1394a;
                i13++;
                i11 &= ~i10;
                iArr2 = iArr;
            }
            i5 -= i13;
            i6++;
            iArr2 = iArr;
            i7 = i12;
            i8 = i11;
        }
    }

    /* renamed from: a */
    private static int m1394a(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > i3) {
            i4 = i3;
            i3 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i2 > i3) {
            i5 *= i2;
            if (i6 <= i4) {
                i5 /= i6;
                i6++;
            }
            i2--;
        }
        while (i6 <= i4) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }
}
