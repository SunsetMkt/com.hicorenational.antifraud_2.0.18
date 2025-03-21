package p031c.p035b.p043c.p053d0;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: Code128Reader.java */
/* renamed from: c.b.c.d0.c */
/* loaded from: classes.dex */
public final class C1020c extends AbstractC1034q {

    /* renamed from: a */
    static final int[][] f1877a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* renamed from: b */
    private static final float f1878b = 0.25f;

    /* renamed from: c */
    private static final float f1879c = 0.7f;

    /* renamed from: d */
    private static final int f1880d = 98;

    /* renamed from: e */
    private static final int f1881e = 99;

    /* renamed from: f */
    private static final int f1882f = 100;

    /* renamed from: g */
    private static final int f1883g = 101;

    /* renamed from: h */
    private static final int f1884h = 102;

    /* renamed from: i */
    private static final int f1885i = 97;

    /* renamed from: j */
    private static final int f1886j = 96;

    /* renamed from: k */
    private static final int f1887k = 101;

    /* renamed from: l */
    private static final int f1888l = 100;

    /* renamed from: m */
    private static final int f1889m = 103;

    /* renamed from: n */
    private static final int f1890n = 104;

    /* renamed from: o */
    private static final int f1891o = 105;

    /* renamed from: p */
    private static final int f1892p = 106;

    /* renamed from: a */
    private static int[] m1482a(C1162a c1162a) throws C1102m {
        int m2157c = c1162a.m2157c();
        int m2158c = c1162a.m2158c(0);
        int[] iArr = new int[6];
        int length = iArr.length;
        int i2 = m2158c;
        boolean z = false;
        int i3 = 0;
        while (m2158c < m2157c) {
            if (c1162a.m2155b(m2158c) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 == i4) {
                    float f2 = f1878b;
                    int i5 = -1;
                    for (int i6 = 103; i6 <= 105; i6++) {
                        float m1508a = AbstractC1034q.m1508a(iArr, f1877a[i6], f1879c);
                        if (m1508a < f2) {
                            i5 = i6;
                            f2 = m1508a;
                        }
                    }
                    if (i5 >= 0 && c1162a.m2152a(Math.max(0, i2 - ((m2158c - i2) / 2)), i2, false)) {
                        return new int[]{i2, m2158c, i5};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i7 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i7);
                    iArr[i7] = 0;
                    iArr[i4] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            m2158c++;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static int m1481a(C1162a c1162a, int[] iArr, int i2) throws C1102m {
        AbstractC1034q.m1509a(c1162a, i2, iArr);
        float f2 = f1878b;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[][] iArr2 = f1877a;
            if (i4 >= iArr2.length) {
                break;
            }
            float m1508a = AbstractC1034q.m1508a(iArr, iArr2[i4], f1879c);
            if (m1508a < f2) {
                i3 = i4;
                f2 = m1508a;
            }
            i4++;
        }
        if (i3 >= 0) {
            return i3;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0149 A[PHI: r19
  0x0149: PHI (r19v7 boolean) = (r19v5 boolean), (r19v12 boolean) binds: [B:82:0x011b, B:52:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p031c.p035b.p043c.C1107r mo1365a(int r25, p031c.p035b.p043c.p072z.C1162a r26, java.util.Map<p031c.p035b.p043c.EnumC1044e, ?> r27) throws p031c.p035b.p043c.C1102m, p031c.p035b.p043c.C1097h, p031c.p035b.p043c.C0988d {
        /*
            Method dump skipped, instructions count: 664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p053d0.C1020c.mo1365a(int, c.b.c.z.a, java.util.Map):c.b.c.r");
    }
}
