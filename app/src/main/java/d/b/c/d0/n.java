package d.b.c.d0;

import java.util.Map;

/* JADX INFO: compiled from: ITFWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class n extends r {
    private static final int[] a = {1, 1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f9657b = {3, 1, 1};

    @Override // d.b.c.d0.r, d.b.c.v
    public d.b.c.z.b a(String str, d.b.c.a aVar, int i2, int i3, Map<d.b.c.g, ?> map) throws d.b.c.w {
        if (aVar == d.b.c.a.ITF) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + aVar);
    }

    @Override // d.b.c.d0.r
    public boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The lenght of the input should be even");
        }
        if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int iA = r.a(zArr, 0, a, true);
            for (int i2 = 0; i2 < length; i2 += 2) {
                int iDigit = Character.digit(str.charAt(i2), 10);
                int iDigit2 = Character.digit(str.charAt(i2 + 1), 10);
                int[] iArr = new int[18];
                for (int i3 = 0; i3 < 5; i3++) {
                    int i4 = i3 * 2;
                    int[][] iArr2 = m.f9656i;
                    iArr[i4] = iArr2[iDigit][i3];
                    iArr[i4 + 1] = iArr2[iDigit2][i3];
                }
                iA += r.a(zArr, iA, iArr, true);
            }
            r.a(zArr, iA, f9657b, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
