package p031c.p035b.p043c.p072z.p073m;

import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: MonochromeRectangleDetector.java */
/* renamed from: c.b.c.z.m.b */
/* loaded from: classes.dex */
public final class C1175b {

    /* renamed from: b */
    private static final int f2438b = 32;

    /* renamed from: a */
    private final C1163b f2439a;

    public C1175b(C1163b c1163b) {
        this.f2439a = c1163b;
    }

    /* renamed from: a */
    public C1109t[] m2226a() throws C1102m {
        int m2177d = this.f2439a.m2177d();
        int m2181g = this.f2439a.m2181g();
        int i2 = m2177d / 2;
        int i3 = m2181g / 2;
        int max = Math.max(1, m2177d / 256);
        int max2 = Math.max(1, m2181g / 256);
        int i4 = -max;
        int i5 = i3 / 2;
        int m1923b = ((int) m2224a(i3, 0, 0, m2181g, i2, i4, 0, m2177d, i5).m1923b()) - 1;
        int i6 = i2 / 2;
        C1109t m2224a = m2224a(i3, -max2, 0, m2181g, i2, 0, m1923b, m2177d, i6);
        int m1922a = ((int) m2224a.m1922a()) - 1;
        C1109t m2224a2 = m2224a(i3, max2, m1922a, m2181g, i2, 0, m1923b, m2177d, i6);
        int m1922a2 = ((int) m2224a2.m1922a()) + 1;
        C1109t m2224a3 = m2224a(i3, 0, m1922a, m1922a2, i2, max, m1923b, m2177d, i5);
        return new C1109t[]{m2224a(i3, 0, m1922a, m1922a2, i2, i4, m1923b, ((int) m2224a3.m1923b()) + 1, i3 / 4), m2224a, m2224a2, m2224a3};
    }

    /* renamed from: a */
    private C1109t m2224a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) throws C1102m {
        int[] m2225a;
        int i11 = i2;
        int i12 = i6;
        int[] iArr = null;
        while (i12 < i9 && i12 >= i8 && i11 < i5 && i11 >= i4) {
            if (i3 == 0) {
                m2225a = m2225a(i12, i10, i4, i5, true);
            } else {
                m2225a = m2225a(i11, i10, i8, i9, false);
            }
            if (m2225a == null) {
                if (iArr == null) {
                    throw C1102m.getNotFoundInstance();
                }
                if (i3 == 0) {
                    int i13 = i12 - i7;
                    if (iArr[0] < i2) {
                        if (iArr[1] > i2) {
                            return new C1109t(i7 > 0 ? iArr[0] : iArr[1], i13);
                        }
                        return new C1109t(iArr[0], i13);
                    }
                    return new C1109t(iArr[1], i13);
                }
                int i14 = i11 - i3;
                if (iArr[0] < i6) {
                    if (iArr[1] > i6) {
                        return new C1109t(i14, i3 < 0 ? iArr[0] : iArr[1]);
                    }
                    return new C1109t(i14, iArr[0]);
                }
                return new C1109t(i14, iArr[1]);
            }
            i12 += i7;
            i11 += i3;
            iArr = m2225a;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0067 A[EDGE_INSN: B:67:0x0067->B:47:0x0067 BREAK  A[LOOP:3: B:39:0x0053->B:61:0x0053], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0031 A[EDGE_INSN: B:81:0x0031->B:21:0x0031 BREAK  A[LOOP:1: B:13:0x001c->B:75:0x001c], SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int[] m2225a(int r6, int r7, int r8, int r9, boolean r10) {
        /*
            r5 = this;
            int r0 = r8 + r9
            r1 = 2
            int r0 = r0 / r1
            r2 = r0
        L5:
            if (r2 < r8) goto L3a
            c.b.c.z.b r3 = r5.f2439a
            if (r10 == 0) goto L12
            boolean r3 = r3.m2173b(r2, r6)
            if (r3 == 0) goto L1b
            goto L18
        L12:
            boolean r3 = r3.m2173b(r6, r2)
            if (r3 == 0) goto L1b
        L18:
            int r2 = r2 + (-1)
            goto L5
        L1b:
            r3 = r2
        L1c:
            int r3 = r3 + (-1)
            if (r3 < r8) goto L31
            c.b.c.z.b r4 = r5.f2439a
            if (r10 == 0) goto L2b
            boolean r4 = r4.m2173b(r3, r6)
            if (r4 == 0) goto L1c
            goto L31
        L2b:
            boolean r4 = r4.m2173b(r6, r3)
            if (r4 == 0) goto L1c
        L31:
            int r4 = r2 - r3
            if (r3 < r8) goto L3a
            if (r4 <= r7) goto L38
            goto L3a
        L38:
            r2 = r3
            goto L5
        L3a:
            r8 = 1
            int r2 = r2 + r8
        L3c:
            if (r0 >= r9) goto L70
            c.b.c.z.b r3 = r5.f2439a
            if (r10 == 0) goto L49
            boolean r3 = r3.m2173b(r0, r6)
            if (r3 == 0) goto L52
            goto L4f
        L49:
            boolean r3 = r3.m2173b(r6, r0)
            if (r3 == 0) goto L52
        L4f:
            int r0 = r0 + 1
            goto L3c
        L52:
            r3 = r0
        L53:
            int r3 = r3 + r8
            if (r3 >= r9) goto L67
            c.b.c.z.b r4 = r5.f2439a
            if (r10 == 0) goto L61
            boolean r4 = r4.m2173b(r3, r6)
            if (r4 == 0) goto L53
            goto L67
        L61:
            boolean r4 = r4.m2173b(r6, r3)
            if (r4 == 0) goto L53
        L67:
            int r4 = r3 - r0
            if (r3 >= r9) goto L70
            if (r4 <= r7) goto L6e
            goto L70
        L6e:
            r0 = r3
            goto L3c
        L70:
            int r0 = r0 + (-1)
            if (r0 <= r2) goto L7c
            int[] r6 = new int[r1]
            r7 = 0
            r6[r7] = r2
            r6[r8] = r0
            goto L7d
        L7c:
            r6 = 0
        L7d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p072z.p073m.C1175b.m2225a(int, int, int, int, boolean):int[]");
    }
}
