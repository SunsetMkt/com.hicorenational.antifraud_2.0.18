package c.b.c.d0;

import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader.java */
/* loaded from: classes.dex */
public abstract class x extends q {

    /* renamed from: d, reason: collision with root package name */
    private static final float f2600d = 0.48f;

    /* renamed from: e, reason: collision with root package name */
    private static final float f2601e = 0.7f;

    /* renamed from: f, reason: collision with root package name */
    static final int[] f2602f = {1, 1, 1};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f2603g = {1, 1, 1, 1, 1};

    /* renamed from: h, reason: collision with root package name */
    static final int[][] f2604h = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};

    /* renamed from: i, reason: collision with root package name */
    static final int[][] f2605i = new int[20][];

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f2606a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    private final w f2607b = new w();

    /* renamed from: c, reason: collision with root package name */
    private final l f2608c = new l();

    static {
        System.arraycopy(f2604h, 0, f2605i, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr = f2604h[i2 - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr2[i3] = iArr[(iArr.length - i3) - 1];
            }
            f2605i[i2] = iArr2;
        }
    }

    protected x() {
    }

    static int[] a(c.b.c.z.a aVar) throws c.b.c.m {
        int[] iArr = new int[f2602f.length];
        int[] iArr2 = null;
        boolean z = false;
        int i2 = 0;
        while (!z) {
            Arrays.fill(iArr, 0, f2602f.length, 0);
            iArr2 = a(aVar, i2, false, f2602f, iArr);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                z = aVar.a(i5, i3, false);
            }
            i2 = i4;
        }
        return iArr2;
    }

    protected abstract int a(c.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws c.b.c.m;

    abstract c.b.c.a a();

    @Override // c.b.c.d0.q
    public c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.m, c.b.c.d, c.b.c.h {
        return a(i2, aVar, a(aVar), map);
    }

    public c.b.c.r a(int i2, c.b.c.z.a aVar, int[] iArr, Map<c.b.c.e, ?> map) throws c.b.c.m, c.b.c.d, c.b.c.h {
        int i3;
        String a2;
        c.b.c.u uVar = map == null ? null : (c.b.c.u) map.get(c.b.c.e.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (uVar != null) {
            uVar.a(new c.b.c.t((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.f2606a;
        sb.setLength(0);
        int a3 = a(aVar, iArr, sb);
        if (uVar != null) {
            uVar.a(new c.b.c.t(a3, i2));
        }
        int[] a4 = a(aVar, a3);
        if (uVar != null) {
            uVar.a(new c.b.c.t((a4[0] + a4[1]) / 2.0f, i2));
        }
        int i4 = a4[1];
        int i5 = (i4 - a4[0]) + i4;
        if (i5 < aVar.c() && aVar.a(i4, i5, false)) {
            String sb2 = sb.toString();
            if (sb2.length() >= 8) {
                if (a(sb2)) {
                    c.b.c.a a5 = a();
                    float f2 = i2;
                    c.b.c.r rVar = new c.b.c.r(sb2, null, new c.b.c.t[]{new c.b.c.t((iArr[1] + iArr[0]) / 2.0f, f2), new c.b.c.t((a4[1] + a4[0]) / 2.0f, f2)}, a5);
                    try {
                        c.b.c.r a6 = this.f2607b.a(i2, aVar, a4[1]);
                        rVar.a(c.b.c.s.UPC_EAN_EXTENSION, a6.e());
                        rVar.a(a6.c());
                        rVar.a(a6.d());
                        i3 = a6.e().length();
                    } catch (c.b.c.q unused) {
                        i3 = 0;
                    }
                    int[] iArr2 = map != null ? (int[]) map.get(c.b.c.e.ALLOWED_EAN_EXTENSIONS) : null;
                    if (iArr2 != null) {
                        int length = iArr2.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                z = false;
                                break;
                            }
                            if (i3 == iArr2[i6]) {
                                break;
                            }
                            i6++;
                        }
                        if (!z) {
                            throw c.b.c.m.getNotFoundInstance();
                        }
                    }
                    if ((a5 == c.b.c.a.EAN_13 || a5 == c.b.c.a.UPC_A) && (a2 = this.f2608c.a(sb2)) != null) {
                        rVar.a(c.b.c.s.POSSIBLE_COUNTRY, a2);
                    }
                    return rVar;
                }
                throw c.b.c.d.getChecksumInstance();
            }
            throw c.b.c.h.getFormatInstance();
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    boolean a(String str) throws c.b.c.h {
        return a((CharSequence) str);
    }

    static boolean a(CharSequence charSequence) throws c.b.c.h {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw c.b.c.h.getFormatInstance();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw c.b.c.h.getFormatInstance();
            }
            i4 += charAt2;
        }
        return i4 % 10 == 0;
    }

    int[] a(c.b.c.z.a aVar, int i2) throws c.b.c.m {
        return a(aVar, i2, false, f2602f);
    }

    static int[] a(c.b.c.z.a aVar, int i2, boolean z, int[] iArr) throws c.b.c.m {
        return a(aVar, i2, z, iArr, new int[iArr.length]);
    }

    private static int[] a(c.b.c.z.a aVar, int i2, boolean z, int[] iArr, int[] iArr2) throws c.b.c.m {
        int length = iArr.length;
        int c2 = aVar.c();
        int d2 = z ? aVar.d(i2) : aVar.c(i2);
        int i3 = d2;
        int i4 = 0;
        while (d2 < c2) {
            if (aVar.b(d2) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else {
                    if (q.a(iArr2, iArr, f2601e) < f2600d) {
                        return new int[]{i3, d2};
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
            d2++;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    static int a(c.b.c.z.a aVar, int[] iArr, int i2, int[][] iArr2) throws c.b.c.m {
        q.a(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = f2600d;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float a2 = q.a(iArr, iArr2[i4], f2601e);
            if (a2 < f2) {
                i3 = i4;
                f2 = a2;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw c.b.c.m.getNotFoundInstance();
    }
}
