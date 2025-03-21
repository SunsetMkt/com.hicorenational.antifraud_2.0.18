package p031c.p035b.p043c.p057e0.p060f;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import p031c.p035b.p043c.C0981c;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: Detector.java */
/* renamed from: c.b.c.e0.f.a */
/* loaded from: classes.dex */
public final class C1062a {

    /* renamed from: c */
    private static final float f2051c = 0.42f;

    /* renamed from: d */
    private static final float f2052d = 0.8f;

    /* renamed from: g */
    private static final int f2055g = 3;

    /* renamed from: h */
    private static final int f2056h = 5;

    /* renamed from: i */
    private static final int f2057i = 25;

    /* renamed from: j */
    private static final int f2058j = 5;

    /* renamed from: k */
    private static final int f2059k = 10;

    /* renamed from: a */
    private static final int[] f2049a = {0, 4, 1, 5};

    /* renamed from: b */
    private static final int[] f2050b = {6, 2, 7, 3};

    /* renamed from: e */
    private static final int[] f2053e = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: f */
    private static final int[] f2054f = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private C1062a() {
    }

    /* renamed from: a */
    public static C1063b m1679a(C0981c c0981c, Map<EnumC1044e, ?> map, boolean z) throws C1102m {
        C1163b m1344a = c0981c.m1344a();
        List<C1109t[]> m1680a = m1680a(z, m1344a);
        if (m1680a.isEmpty()) {
            m1344a = m1344a.m26849clone();
            m1344a.m2182h();
            m1680a = m1680a(z, m1344a);
        }
        return new C1063b(m1344a, m1680a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r5 != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r4.hasNext() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        r5 = (p031c.p035b.p043c.C1109t[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r5[1] == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r3 = (int) java.lang.Math.max(r3, r5[1].m1923b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
    
        if (r5[3] == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
    
        r3 = java.lang.Math.max(r3, (int) r5[3].m1923b());
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<p031c.p035b.p043c.C1109t[]> m1680a(boolean r8, p031c.p035b.p043c.p072z.C1163b r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 1
            r2 = 0
            r3 = 0
        L8:
            r4 = 0
            r5 = 0
        La:
            int r6 = r9.m2177d()
            if (r3 >= r6) goto L7e
            c.b.c.t[] r4 = m1683a(r9, r3, r4)
            r6 = r4[r2]
            if (r6 != 0) goto L53
            r6 = 3
            r7 = r4[r6]
            if (r7 != 0) goto L53
            if (r5 != 0) goto L20
            goto L7e
        L20:
            java.util.Iterator r4 = r0.iterator()
        L24:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L50
            java.lang.Object r5 = r4.next()
            c.b.c.t[] r5 = (p031c.p035b.p043c.C1109t[]) r5
            r7 = r5[r1]
            if (r7 == 0) goto L40
            float r3 = (float) r3
            r7 = r5[r1]
            float r7 = r7.m1923b()
            float r3 = java.lang.Math.max(r3, r7)
            int r3 = (int) r3
        L40:
            r7 = r5[r6]
            if (r7 == 0) goto L24
            r5 = r5[r6]
            float r5 = r5.m1923b()
            int r5 = (int) r5
            int r3 = java.lang.Math.max(r3, r5)
            goto L24
        L50:
            int r3 = r3 + 5
            goto L8
        L53:
            r0.add(r4)
            if (r8 != 0) goto L59
            goto L7e
        L59:
            r3 = 2
            r5 = r4[r3]
            if (r5 == 0) goto L6c
            r5 = r4[r3]
            float r5 = r5.m1922a()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.m1923b()
            goto L7a
        L6c:
            r3 = 4
            r5 = r4[r3]
            float r5 = r5.m1922a()
            int r5 = (int) r5
            r3 = r4[r3]
            float r3 = r3.m1923b()
        L7a:
            int r3 = (int) r3
            r4 = r5
            r5 = 1
            goto La
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p057e0.p060f.C1062a.m1680a(boolean, c.b.c.z.b):java.util.List");
    }

    /* renamed from: a */
    private static C1109t[] m1683a(C1163b c1163b, int i2, int i3) {
        int m2177d = c1163b.m2177d();
        int m2181g = c1163b.m2181g();
        C1109t[] c1109tArr = new C1109t[8];
        m1681a(c1109tArr, m1684a(c1163b, m2177d, m2181g, i2, i3, f2053e), f2049a);
        if (c1109tArr[4] != null) {
            i3 = (int) c1109tArr[4].m1922a();
            i2 = (int) c1109tArr[4].m1923b();
        }
        m1681a(c1109tArr, m1684a(c1163b, m2177d, m2181g, i2, i3, f2054f), f2050b);
        return c1109tArr;
    }

    /* renamed from: a */
    private static void m1681a(C1109t[] c1109tArr, C1109t[] c1109tArr2, int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            c1109tArr[iArr[i2]] = c1109tArr2[i2];
        }
    }

    /* renamed from: a */
    private static C1109t[] m1684a(C1163b c1163b, int i2, int i3, int i4, int i5, int[] iArr) {
        int i6;
        boolean z;
        int i7;
        int[] iArr2;
        C1109t[] c1109tArr = new C1109t[4];
        int[] iArr3 = new int[iArr.length];
        int i8 = i4;
        while (true) {
            if (i8 >= i2) {
                z = false;
                break;
            }
            int[] m1682a = m1682a(c1163b, i5, i8, i3, false, iArr, iArr3);
            if (m1682a != null) {
                while (true) {
                    iArr2 = m1682a;
                    if (i8 <= 0) {
                        break;
                    }
                    i8--;
                    m1682a = m1682a(c1163b, i5, i8, i3, false, iArr, iArr3);
                    if (m1682a == null) {
                        i8++;
                        break;
                    }
                }
                float f2 = i8;
                c1109tArr[0] = new C1109t(iArr2[0], f2);
                c1109tArr[1] = new C1109t(iArr2[1], f2);
                z = true;
            } else {
                i8 += 5;
            }
        }
        int i9 = i8 + 1;
        if (z) {
            int[] iArr4 = {(int) c1109tArr[0].m1922a(), (int) c1109tArr[1].m1922a()};
            int i10 = i9;
            int i11 = 0;
            while (true) {
                if (i10 >= i2) {
                    i7 = i11;
                    break;
                }
                i7 = i11;
                int[] m1682a2 = m1682a(c1163b, iArr4[0], i10, i3, false, iArr, iArr3);
                if (m1682a2 != null && Math.abs(iArr4[0] - m1682a2[0]) < 5 && Math.abs(iArr4[1] - m1682a2[1]) < 5) {
                    iArr4 = m1682a2;
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
            c1109tArr[2] = new C1109t(iArr4[0], f3);
            c1109tArr[3] = new C1109t(iArr4[1], f3);
        }
        if (i9 - i8 < 10) {
            for (i6 = 0; i6 < c1109tArr.length; i6++) {
                c1109tArr[i6] = null;
            }
        }
        return c1109tArr;
    }

    /* renamed from: a */
    private static int[] m1682a(C1163b c1163b, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = 0;
        while (c1163b.m2173b(i2, i3) && i2 > 0) {
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
            if (c1163b.m2173b(i2, i3) ^ z2) {
                iArr2[i8] = iArr2[i8] + 1;
            } else {
                int i9 = length - 1;
                if (i8 != i9) {
                    i8++;
                } else {
                    if (m1678a(iArr2, iArr, f2052d) < f2051c) {
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
        if (i8 != length - 1 || m1678a(iArr2, iArr, f2052d) >= f2051c) {
            return null;
        }
        return new int[]{i7, i2 - 1};
    }

    /* renamed from: a */
    private static float m1678a(int[] iArr, int[] iArr2, float f2) {
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
