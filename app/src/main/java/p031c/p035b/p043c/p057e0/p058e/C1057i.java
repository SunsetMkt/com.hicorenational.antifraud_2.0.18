package p031c.p035b.p043c.p057e0.p058e;

import java.lang.reflect.Array;
import p031c.p035b.p043c.p057e0.C1045a;

/* compiled from: PDF417CodewordDecoder.java */
/* renamed from: c.b.c.e0.e.i */
/* loaded from: classes.dex */
final class C1057i {

    /* renamed from: a */
    private static final float[][] f2035a = (float[][]) Array.newInstance((Class<?>) float.class, C1045a.f1971i.length, 8);

    static {
        int i2;
        int i3 = 0;
        while (true) {
            int[] iArr = C1045a.f1971i;
            if (i3 >= iArr.length) {
                return;
            }
            int i4 = iArr[i3];
            int i5 = i4 & 1;
            int i6 = i4;
            int i7 = 0;
            while (i7 < 8) {
                float f2 = 0.0f;
                while (true) {
                    i2 = i6 & 1;
                    if (i2 == i5) {
                        f2 += 1.0f;
                        i6 >>= 1;
                    }
                }
                f2035a[i3][(8 - i7) - 1] = f2 / 17.0f;
                i7++;
                i5 = i2;
            }
            i3++;
        }
    }

    private C1057i() {
    }

    /* renamed from: a */
    private static int m1623a(int[] iArr) {
        long j2 = 0;
        int i2 = 0;
        while (i2 < iArr.length) {
            long j3 = j2;
            for (int i3 = 0; i3 < iArr[i2]; i3++) {
                int i4 = 1;
                long j4 = j3 << 1;
                if (i2 % 2 != 0) {
                    i4 = 0;
                }
                j3 = j4 | i4;
            }
            i2++;
            j2 = j3;
        }
        return (int) j2;
    }

    /* renamed from: b */
    private static int m1624b(int[] iArr) {
        int m1538a = C1045a.m1538a(iArr);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = iArr[i2] / m1538a;
        }
        int i3 = -1;
        int i4 = 0;
        float f2 = Float.MAX_VALUE;
        while (true) {
            float[][] fArr2 = f2035a;
            if (i4 >= fArr2.length) {
                return i3;
            }
            float[] fArr3 = fArr2[i4];
            float f3 = 0.0f;
            for (int i5 = 0; i5 < 8; i5++) {
                float f4 = fArr3[i5] - fArr[i5];
                f3 += f4 * f4;
                if (f3 >= f2) {
                    break;
                }
            }
            if (f3 < f2) {
                i3 = C1045a.f1971i[i4];
                f2 = f3;
            }
            i4++;
        }
    }

    /* renamed from: c */
    private static int m1625c(int[] iArr) {
        int m1623a = m1623a(iArr);
        if (C1045a.m1537a(m1623a) == -1) {
            return -1;
        }
        return m1623a;
    }

    /* renamed from: d */
    static int m1626d(int[] iArr) {
        int m1625c = m1625c(m1627e(iArr));
        return m1625c != -1 ? m1625c : m1624b(iArr);
    }

    /* renamed from: e */
    private static int[] m1627e(int[] iArr) {
        float m1538a = C1045a.m1538a(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 17; i4++) {
            if (iArr[i3] + i2 <= (m1538a / 34.0f) + ((i4 * m1538a) / 17.0f)) {
                i2 += iArr[i3];
                i3++;
            }
            iArr2[i3] = iArr2[i3] + 1;
        }
        return iArr2;
    }
}
