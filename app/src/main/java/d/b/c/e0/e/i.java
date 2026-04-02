package d.b.c.e0.e;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: PDF417CodewordDecoder.java */
/* JADX INFO: loaded from: classes.dex */
final class i {
    private static final float[][] a = (float[][]) Array.newInstance((Class<?>) float.class, d.b.c.e0.a.f9682i.length, 8);

    static {
        int i2;
        int i3 = 0;
        while (true) {
            int[] iArr = d.b.c.e0.a.f9682i;
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
                a[i3][(8 - i7) - 1] = f2 / 17.0f;
                i7++;
                i5 = i2;
            }
            i3++;
        }
    }

    private i() {
    }

    private static int a(int[] iArr) {
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
                j3 = j4 | ((long) i4);
            }
            i2++;
            j2 = j3;
        }
        return (int) j2;
    }

    private static int b(int[] iArr) {
        int iA = d.b.c.e0.a.a(iArr);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = iArr[i2] / iA;
        }
        int i3 = -1;
        int i4 = 0;
        float f2 = Float.MAX_VALUE;
        while (true) {
            float[][] fArr2 = a;
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
                i3 = d.b.c.e0.a.f9682i[i4];
                f2 = f3;
            }
            i4++;
        }
    }

    private static int c(int[] iArr) {
        int iA = a(iArr);
        if (d.b.c.e0.a.a(iA) == -1) {
            return -1;
        }
        return iA;
    }

    static int d(int[] iArr) {
        int iC = c(e(iArr));
        return iC != -1 ? iC : b(iArr);
    }

    private static int[] e(int[] iArr) {
        float fA = d.b.c.e0.a.a(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 17; i4++) {
            if (iArr[i3] + i2 <= (fA / 34.0f) + ((i4 * fA) / 17.0f)) {
                i2 += iArr[i3];
                i3++;
            }
            iArr2[i3] = iArr2[i3] + 1;
        }
        return iArr2;
    }
}
