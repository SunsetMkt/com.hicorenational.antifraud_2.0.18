package d.b.c.d0;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: UPCEANReader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class x extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f9664d = 0.48f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f9665e = 0.7f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f9666f = {1, 1, 1};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f9667g = {1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int[][] f9668h = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int[][] f9669i = new int[20][];
    private final StringBuilder a = new StringBuilder(20);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w f9670b = new w();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f9671c = new l();

    static {
        System.arraycopy(f9668h, 0, f9669i, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr = f9668h[i2 - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = iArr[(iArr.length - i3) - 1];
            }
            f9669i[i2] = iArr2;
        }
    }

    protected x() {
    }

    static int[] a(d.b.c.z.a aVar) throws d.b.c.m {
        int[] iArr = new int[f9666f.length];
        int[] iArrA = null;
        boolean zA = false;
        int i2 = 0;
        while (!zA) {
            Arrays.fill(iArr, 0, f9666f.length, 0);
            iArrA = a(aVar, i2, false, f9666f, iArr);
            int i3 = iArrA[0];
            int i4 = iArrA[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                zA = aVar.a(i5, i3, false);
            }
            i2 = i4;
        }
        return iArrA;
    }

    protected abstract int a(d.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws d.b.c.m;

    abstract d.b.c.a a();

    @Override // d.b.c.d0.q
    public d.b.c.r a(int i2, d.b.c.z.a aVar, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.d, d.b.c.h {
        return a(i2, aVar, a(aVar), map);
    }

    public d.b.c.r a(int i2, d.b.c.z.a aVar, int[] iArr, Map<d.b.c.e, ?> map) throws d.b.c.m, d.b.c.d, d.b.c.h {
        int length;
        String strA;
        d.b.c.u uVar = map == null ? null : (d.b.c.u) map.get(d.b.c.e.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (uVar != null) {
            uVar.a(new d.b.c.t((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.a;
        sb.setLength(0);
        int iA = a(aVar, iArr, sb);
        if (uVar != null) {
            uVar.a(new d.b.c.t(iA, i2));
        }
        int[] iArrA = a(aVar, iA);
        if (uVar != null) {
            uVar.a(new d.b.c.t((iArrA[0] + iArrA[1]) / 2.0f, i2));
        }
        int i3 = iArrA[1];
        int i4 = (i3 - iArrA[0]) + i3;
        if (i4 < aVar.c() && aVar.a(i3, i4, false)) {
            String string = sb.toString();
            if (string.length() >= 8) {
                if (a(string)) {
                    d.b.c.a aVarA = a();
                    float f2 = i2;
                    d.b.c.r rVar = new d.b.c.r(string, null, new d.b.c.t[]{new d.b.c.t((iArr[1] + iArr[0]) / 2.0f, f2), new d.b.c.t((iArrA[1] + iArrA[0]) / 2.0f, f2)}, aVarA);
                    try {
                        d.b.c.r rVarA = this.f9670b.a(i2, aVar, iArrA[1]);
                        rVar.a(d.b.c.s.UPC_EAN_EXTENSION, rVarA.e());
                        rVar.a(rVarA.c());
                        rVar.a(rVarA.d());
                        length = rVarA.e().length();
                    } catch (d.b.c.q unused) {
                        length = 0;
                    }
                    int[] iArr2 = map != null ? (int[]) map.get(d.b.c.e.ALLOWED_EAN_EXTENSIONS) : null;
                    if (iArr2 != null) {
                        int length2 = iArr2.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length2) {
                                z = false;
                                break;
                            }
                            if (length == iArr2[i5]) {
                                break;
                            }
                            i5++;
                        }
                        if (!z) {
                            throw d.b.c.m.getNotFoundInstance();
                        }
                    }
                    if ((aVarA == d.b.c.a.EAN_13 || aVarA == d.b.c.a.UPC_A) && (strA = this.f9671c.a(string)) != null) {
                        rVar.a(d.b.c.s.POSSIBLE_COUNTRY, strA);
                    }
                    return rVar;
                }
                throw d.b.c.d.getChecksumInstance();
            }
            throw d.b.c.h.getFormatInstance();
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    boolean a(String str) throws d.b.c.h {
        return a((CharSequence) str);
    }

    static boolean a(CharSequence charSequence) throws d.b.c.h {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            int iCharAt = charSequence.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw d.b.c.h.getFormatInstance();
            }
            i2 += iCharAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            int iCharAt2 = charSequence.charAt(i5) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw d.b.c.h.getFormatInstance();
            }
            i4 += iCharAt2;
        }
        return i4 % 10 == 0;
    }

    int[] a(d.b.c.z.a aVar, int i2) throws d.b.c.m {
        return a(aVar, i2, false, f9666f);
    }

    static int[] a(d.b.c.z.a aVar, int i2, boolean z, int[] iArr) throws d.b.c.m {
        return a(aVar, i2, z, iArr, new int[iArr.length]);
    }

    private static int[] a(d.b.c.z.a aVar, int i2, boolean z, int[] iArr, int[] iArr2) throws d.b.c.m {
        int length = iArr.length;
        int iC = aVar.c();
        int iD = z ? aVar.d(i2) : aVar.c(i2);
        int i3 = iD;
        int i4 = 0;
        while (iD < iC) {
            if (aVar.b(iD) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else {
                    if (q.a(iArr2, iArr, f9665e) < f9664d) {
                        return new int[]{i3, iD};
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
            iD++;
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    static int a(d.b.c.z.a aVar, int[] iArr, int i2, int[][] iArr2) throws d.b.c.m {
        q.a(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = f9664d;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float fA = q.a(iArr, iArr2[i4], f9665e);
            if (fA < f2) {
                i3 = i4;
                f2 = fA;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw d.b.c.m.getNotFoundInstance();
    }
}
