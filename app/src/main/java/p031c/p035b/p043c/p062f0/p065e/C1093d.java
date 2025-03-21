package p031c.p035b.p043c.p062f0.p065e;

/* compiled from: MaskUtil.java */
/* renamed from: c.b.c.f0.e.d */
/* loaded from: classes.dex */
final class C1093d {

    /* renamed from: a */
    private static final int f2179a = 3;

    /* renamed from: b */
    private static final int f2180b = 3;

    /* renamed from: c */
    private static final int f2181c = 40;

    /* renamed from: d */
    private static final int f2182d = 10;

    private C1093d() {
    }

    /* renamed from: a */
    static int m1855a(C1091b c1091b) {
        return m1856a(c1091b, true) + m1856a(c1091b, false);
    }

    /* renamed from: b */
    static int m1860b(C1091b c1091b) {
        byte[][] m1831a = c1091b.m1831a();
        int m1833c = c1091b.m1833c();
        int m1832b = c1091b.m1832b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < m1832b - 1) {
            int i4 = i3;
            int i5 = 0;
            while (i5 < m1833c - 1) {
                byte b2 = m1831a[i2][i5];
                int i6 = i5 + 1;
                if (b2 == m1831a[i2][i6]) {
                    int i7 = i2 + 1;
                    if (b2 == m1831a[i7][i5] && b2 == m1831a[i7][i6]) {
                        i4++;
                    }
                }
                i5 = i6;
            }
            i2++;
            i3 = i4;
        }
        return i3 * 3;
    }

    /* renamed from: c */
    static int m1861c(C1091b c1091b) {
        byte[][] m1831a = c1091b.m1831a();
        int m1833c = c1091b.m1833c();
        int m1832b = c1091b.m1832b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < m1832b) {
            int i4 = i3;
            for (int i5 = 0; i5 < m1833c; i5++) {
                byte[] bArr = m1831a[i2];
                int i6 = i5 + 6;
                if (i6 < m1833c && bArr[i5] == 1 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == 1 && bArr[i5 + 3] == 1 && bArr[i5 + 4] == 1 && bArr[i5 + 5] == 0 && bArr[i6] == 1 && (m1858a(bArr, i5 - 4, i5) || m1858a(bArr, i5 + 7, i5 + 11))) {
                    i4++;
                }
                int i7 = i2 + 6;
                if (i7 < m1832b && m1831a[i2][i5] == 1 && m1831a[i2 + 1][i5] == 0 && m1831a[i2 + 2][i5] == 1 && m1831a[i2 + 3][i5] == 1 && m1831a[i2 + 4][i5] == 1 && m1831a[i2 + 5][i5] == 0 && m1831a[i7][i5] == 1 && (m1859a(m1831a, i5, i2 - 4, i2) || m1859a(m1831a, i5, i2 + 7, i2 + 11))) {
                    i4++;
                }
            }
            i2++;
            i3 = i4;
        }
        return i3 * 40;
    }

    /* renamed from: d */
    static int m1862d(C1091b c1091b) {
        byte[][] m1831a = c1091b.m1831a();
        int m1833c = c1091b.m1833c();
        int m1832b = c1091b.m1832b();
        int i2 = 0;
        int i3 = 0;
        while (i2 < m1832b) {
            byte[] bArr = m1831a[i2];
            int i4 = i3;
            for (int i5 = 0; i5 < m1833c; i5++) {
                if (bArr[i5] == 1) {
                    i4++;
                }
            }
            i2++;
            i3 = i4;
        }
        int m1832b2 = c1091b.m1832b() * c1091b.m1833c();
        return ((Math.abs((i3 * 2) - m1832b2) * 10) / m1832b2) * 10;
    }

    /* renamed from: a */
    private static boolean m1858a(byte[] bArr, int i2, int i3) {
        while (i2 < i3) {
            if (i2 >= 0 && i2 < bArr.length && bArr[i2] == 1) {
                return false;
            }
            i2++;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m1859a(byte[][] bArr, int i2, int i3, int i4) {
        while (i3 < i4) {
            if (i3 >= 0 && i3 < bArr.length && bArr[i3][i2] == 1) {
                return false;
            }
            i3++;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047 A[ORIG_RETURN, RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean m1857a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L41;
                case 1: goto L42;
                case 2: goto L3e;
                case 3: goto L3a;
                case 4: goto L35;
                case 5: goto L2d;
                case 6: goto L24;
                case 7: goto L1b;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L1b:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L2b
        L24:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L2b:
            r1 = r1 & r0
            goto L44
        L2d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L44
        L35:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L41
        L3a:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L44
        L3e:
            int r1 = r2 % 3
            goto L44
        L41:
            int r3 = r3 + r2
        L42:
            r1 = r3 & 1
        L44:
            if (r1 != 0) goto L47
            goto L48
        L47:
            r0 = 0
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p062f0.p065e.C1093d.m1857a(int, int, int):boolean");
    }

    /* renamed from: a */
    private static int m1856a(C1091b c1091b, boolean z) {
        int m1832b = z ? c1091b.m1832b() : c1091b.m1833c();
        int m1833c = z ? c1091b.m1833c() : c1091b.m1832b();
        byte[][] m1831a = c1091b.m1831a();
        int i2 = 0;
        for (int i3 = 0; i3 < m1832b; i3++) {
            int i4 = i2;
            int i5 = 0;
            byte b2 = -1;
            for (int i6 = 0; i6 < m1833c; i6++) {
                byte b3 = z ? m1831a[i3][i6] : m1831a[i6][i3];
                if (b3 == b2) {
                    i5++;
                } else {
                    if (i5 >= 5) {
                        i4 += (i5 - 5) + 3;
                    }
                    i5 = 1;
                    b2 = b3;
                }
            }
            if (i5 >= 5) {
                i4 += (i5 - 5) + 3;
            }
            i2 = i4;
        }
        return i2;
    }
}
