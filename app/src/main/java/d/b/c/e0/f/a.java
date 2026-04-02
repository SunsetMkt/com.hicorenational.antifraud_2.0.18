package d.b.c.e0.f;

import d.b.c.c;
import d.b.c.e;
import d.b.c.m;
import d.b.c.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f9735c = 0.42f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f9736d = 0.8f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9739g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9740h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9741i = 25;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f9742j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f9743k = 10;
    private static final int[] a = {0, 4, 1, 5};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f9734b = {6, 2, 7, 3};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f9737e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f9738f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private a() {
    }

    public static b a(c cVar, Map<e, ?> map, boolean z) throws m {
        d.b.c.z.b bVarA = cVar.a();
        List<t[]> listA = a(z, bVarA);
        if (listA.isEmpty()) {
            bVarA = bVarA.m766clone();
            bVarA.h();
            listA = a(z, bVarA);
        }
        return new b(bVarA, listA);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r4.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        r5 = (d.b.c.t[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r5[1] == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (r5[3] == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].b());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<t[]> a(boolean z, d.b.c.z.b bVar) {
        int iA;
        float fB;
        ArrayList arrayList = new ArrayList();
        int iMax = 0;
        loop0: while (true) {
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                if (iMax >= bVar.d()) {
                    break loop0;
                }
                t[] tVarArrA = a(bVar, iMax, i2);
                if (tVarArrA[0] == null && tVarArrA[3] == null) {
                    break;
                }
                arrayList.add(tVarArrA);
                if (!z) {
                    break loop0;
                }
                if (tVarArrA[2] != null) {
                    iA = (int) tVarArrA[2].a();
                    fB = tVarArrA[2].b();
                } else {
                    iA = (int) tVarArrA[4].a();
                    fB = tVarArrA[4].b();
                }
                iMax = (int) fB;
                i2 = iA;
                z2 = true;
            }
            iMax += 5;
        }
        return arrayList;
    }

    private static t[] a(d.b.c.z.b bVar, int i2, int i3) {
        int iD = bVar.d();
        int iG = bVar.g();
        t[] tVarArr = new t[8];
        a(tVarArr, a(bVar, iD, iG, i2, i3, f9737e), a);
        if (tVarArr[4] != null) {
            i3 = (int) tVarArr[4].a();
            i2 = (int) tVarArr[4].b();
        }
        a(tVarArr, a(bVar, iD, iG, i2, i3, f9738f), f9734b);
        return tVarArr;
    }

    private static void a(t[] tVarArr, t[] tVarArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            tVarArr[iArr[i2]] = tVarArr2[i2];
        }
    }

    private static t[] a(d.b.c.z.b bVar, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        boolean z;
        int i7;
        int[] iArr2;
        t[] tVarArr = new t[4];
        int[] iArr3 = new int[iArr.length];
        int i8 = i4;
        while (true) {
            if (i8 >= i2) {
                z = false;
                break;
            }
            int[] iArrA = a(bVar, i5, i8, i3, false, iArr, iArr3);
            if (iArrA != null) {
                while (true) {
                    iArr2 = iArrA;
                    if (i8 <= 0) {
                        break;
                    }
                    i8--;
                    iArrA = a(bVar, i5, i8, i3, false, iArr, iArr3);
                    if (iArrA == null) {
                        i8++;
                        break;
                    }
                }
                float f2 = i8;
                tVarArr[0] = new t(iArr2[0], f2);
                tVarArr[1] = new t(iArr2[1], f2);
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i9 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) tVarArr[0].a(), (int) tVarArr[1].a()};
            int i10 = i9;
            int i11 = 0;
            while (true) {
                if (i10 >= i2) {
                    i7 = i11;
                    break;
                }
                i7 = i11;
                int[] iArrA2 = a(bVar, iArr4[0], i10, i3, false, iArr, iArr3);
                if (iArrA2 != null && Math.abs(iArr4[0] - iArrA2[0]) < 5 && Math.abs(iArr4[1] - iArrA2[1]) < 5) {
                    iArr4 = iArrA2;
                    i11 = 0;
                } else {
                    if (i7 > 25) {
                        break;
                    }
                    i11 = i7 + 1;
                }
                i10++;
            }
            i9 = i10 - (i7 + 1);
            float f3 = i9;
            tVarArr[2] = new t(iArr4[0], f3);
            tVarArr[3] = new t(iArr4[1], f3);
        }
        if (i9 - i8 < 10) {
            for (i6 = 0; i6 < tVarArr.length; i6++) {
                tVarArr[i6] = null;
            }
        }
        return tVarArr;
    }

    private static int[] a(d.b.c.z.b bVar, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = 0;
        while (bVar.b(i2, i3) && i2 > 0) {
            int i6 = i5 + 1;
            if (i5 >= 3) {
                break;
            }
            i2--;
            i5 = i6;
        }
        int i7 = i2;
        boolean z2 = z;
        int i8 = 0;
        while (i2 < i4) {
            if (bVar.b(i2, i3) ^ z2) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                int i9 = length - 1;
                if (i8 != i9) {
                    i8++;
                } else {
                    if (a(iArr2, iArr, f9736d) < f9735c) {
                        return new int[]{i7, i2};
                    }
                    i7 += iArr2[0] + iArr2[1];
                    int i10 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i10);
                    iArr2[i10] = 0;
                    iArr2[i9] = 0;
                    i8--;
                }
                iArr2[i8] = 1;
                z2 = !z2;
            }
            i2++;
        }
        if (i8 != length - 1 || a(iArr2, iArr, f9736d) >= f9735c) {
            return null;
        }
        return new int[]{i7, i2 - 1};
    }

    private static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = i2;
        float f4 = f3 / i3;
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            float f7 = iArr2[i5] * f4;
            float f8 = iArr[i5];
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }
}
