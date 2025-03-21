package c.b.c.d0;

import java.util.Map;

/* compiled from: ITFReader.java */
/* loaded from: classes.dex */
public final class m extends q {

    /* renamed from: b, reason: collision with root package name */
    private static final float f2577b = 0.38f;

    /* renamed from: c, reason: collision with root package name */
    private static final float f2578c = 0.78f;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2579d = 3;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2580e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f2581f = {6, 8, 10, 12, 14};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f2582g = {1, 1, 1, 1};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f2583h = {1, 1, 3};

    /* renamed from: i, reason: collision with root package name */
    static final int[][] f2584i = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a, reason: collision with root package name */
    private int f2585a = -1;

    private static int c(c.b.c.z.a aVar) throws c.b.c.m {
        int c2 = aVar.c();
        int c3 = aVar.c(0);
        if (c3 != c2) {
            return c3;
        }
        throw c.b.c.m.getNotFoundInstance();
    }

    @Override // c.b.c.d0.q
    public c.b.c.r a(int i2, c.b.c.z.a aVar, Map<c.b.c.e, ?> map) throws c.b.c.h, c.b.c.m {
        boolean z;
        int[] b2 = b(aVar);
        int[] a2 = a(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, b2[1], a2[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(c.b.c.e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f2581f;
        }
        int length = sb2.length();
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
            throw c.b.c.h.getFormatInstance();
        }
        float f2 = i2;
        return new c.b.c.r(sb2, null, new c.b.c.t[]{new c.b.c.t(b2[1], f2), new c.b.c.t(a2[0], f2)}, c.b.c.a.ITF);
    }

    int[] b(c.b.c.z.a aVar) throws c.b.c.m {
        int[] c2 = c(aVar, c(aVar), f2582g);
        this.f2585a = (c2[1] - c2[0]) / 4;
        a(aVar, c2[0]);
        return c2;
    }

    private static int[] c(c.b.c.z.a aVar, int i2, int[] iArr) throws c.b.c.m {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int c2 = aVar.c();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < c2) {
            if (aVar.b(i2) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else {
                    if (q.a(iArr2, iArr, f2578c) < f2577b) {
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
        throw c.b.c.m.getNotFoundInstance();
    }

    private static void a(c.b.c.z.a aVar, int i2, int i3, StringBuilder sb) throws c.b.c.m {
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

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(c.b.c.z.a r3, int r4) throws c.b.c.m {
        /*
            r2 = this;
            int r0 = r2.f2585a
            int r0 = r0 * 10
            if (r0 >= r4) goto L7
            goto L8
        L7:
            r0 = r4
        L8:
            int r4 = r4 + (-1)
        La:
            if (r0 <= 0) goto L1a
            if (r4 < 0) goto L1a
            boolean r1 = r3.b(r4)
            if (r1 == 0) goto L15
            goto L1a
        L15:
            int r0 = r0 + (-1)
            int r4 = r4 + (-1)
            goto La
        L1a:
            if (r0 != 0) goto L1d
            return
        L1d:
            c.b.c.m r3 = c.b.c.m.getNotFoundInstance()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.d0.m.a(c.b.c.z.a, int):void");
    }

    int[] a(c.b.c.z.a aVar) throws c.b.c.m {
        aVar.e();
        try {
            int[] c2 = c(aVar, c(aVar), f2583h);
            a(aVar, c2[0]);
            int i2 = c2[0];
            c2[0] = aVar.c() - c2[1];
            c2[1] = aVar.c() - i2;
            return c2;
        } finally {
            aVar.e();
        }
    }

    private static int a(int[] iArr) throws c.b.c.m {
        int length = f2584i.length;
        float f2 = f2577b;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float a2 = q.a(iArr, f2584i[i3], f2578c);
            if (a2 < f2) {
                i2 = i3;
                f2 = a2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw c.b.c.m.getNotFoundInstance();
    }
}
