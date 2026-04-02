package d.b.c.d0;

import java.util.Map;

/* JADX INFO: compiled from: ITFReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class m extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f9649b = 0.38f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f9650c = 0.78f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9651d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9652e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f9653f = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f9654g = {1, 1, 1, 1};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f9655h = {1, 1, 3};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[][] f9656i = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private int a = -1;

    private static int c(d.b.c.z.a aVar) throws d.b.c.m {
        int iC = aVar.c();
        int iC2 = aVar.c(0);
        if (iC2 != iC) {
            return iC2;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    @Override // d.b.c.d0.q
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.h {
        boolean z;
        int[] iArrB = b(aVar);
        int[] iArrA = a(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, iArrB[1], iArrA[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(d.b.c.e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f9653f;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length2) {
                z = false;
                break;
            }
            int i5 = iArr[i3];
            if (length == i5) {
                z = true;
                break;
            }
            if (i5 > i4) {
                i4 = i5;
            }
            i3++;
        }
        if (!z && length > i4) {
            z = true;
        }
        if (!z) {
            throw d.b.c.h.getFormatInstance();
        }
        float f2 = i2;
        return new d.b.c.r(string, null, new d.b.c.t[]{new d.b.c.t(iArrB[1], f2), new d.b.c.t(iArrA[0], f2)}, d.b.c.a.ITF);
    }

    int[] b(d.b.c.z.a aVar) throws d.b.c.m {
        int[] iArrC = c(aVar, c(aVar), f9654g);
        this.a = (iArrC[1] - iArrC[0]) / 4;
        a(aVar, iArrC[0]);
        return iArrC;
    }

    private static int[] c(d.b.c.z.a aVar, int i2, int[] iArr) throws d.b.c.m {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iC = aVar.c();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < iC) {
            if (aVar.b(i2) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else {
                    if (q.a(iArr2, iArr, f9650c) < 0.38f) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i2++;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    private static void a(d.b.c.z.a aVar, int i2, int i3, StringBuilder sb) throws d.b.c.m {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            q.a(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (a(iArr2) + 48));
            sb.append((char) (a(iArr3) + 48));
            for (int i6 : iArr) {
                i2 += i6;
            }
        }
    }

    private void a(d.b.c.z.a aVar, int i2) throws d.b.c.m {
        int i3 = this.a * 10;
        if (i3 >= i2) {
            i3 = i2;
        }
        for (int i4 = i2 - 1; i3 > 0 && i4 >= 0 && !aVar.b(i4); i4--) {
            i3--;
        }
        if (i3 != 0) {
            throw d.b.c.m.getNotFoundInstance();
        }
    }

    int[] a(d.b.c.z.a aVar) throws d.b.c.m {
        aVar.e();
        try {
            int[] iArrC = c(aVar, c(aVar), f9655h);
            a(aVar, iArrC[0]);
            int i2 = iArrC[0];
            iArrC[0] = aVar.c() - iArrC[1];
            iArrC[1] = aVar.c() - i2;
            return iArrC;
        } finally {
            aVar.e();
        }
    }

    private static int a(int[] iArr) throws d.b.c.m {
        int length = f9656i.length;
        float f2 = 0.38f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fA = q.a(iArr, f9656i[i3], f9650c);
            if (fA < f2) {
                i2 = i3;
                f2 = fA;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw d.b.c.m.getNotFoundInstance();
    }
}
