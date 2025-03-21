package p031c.p035b.p043c.p053d0;

/* compiled from: CodaBarWriter.java */
/* renamed from: c.b.c.d0.b */
/* loaded from: classes.dex */
public final class C1019b extends AbstractC1035r {

    /* renamed from: a */
    private static final char[] f1873a = {'A', 'B', 'C', 'D'};

    /* renamed from: b */
    private static final char[] f1874b = {'T', 'N', '*', 'E'};

    /* renamed from: c */
    private static final char[] f1875c = {'/', ':', '+', '.'};

    /* renamed from: d */
    private static final char f1876d = f1873a[0];

    @Override // p031c.p035b.p043c.p053d0.AbstractC1035r
    /* renamed from: a */
    public boolean[] mo1480a(String str) {
        int i2;
        if (str.length() < 2) {
            str = f1876d + str + f1876d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean m1362a = C0989a.m1362a(f1873a, upperCase);
            boolean m1362a2 = C0989a.m1362a(f1873a, upperCase2);
            boolean m1362a3 = C0989a.m1362a(f1874b, upperCase);
            boolean m1362a4 = C0989a.m1362a(f1874b, upperCase2);
            if (m1362a) {
                if (!m1362a2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!m1362a3) {
                if (m1362a2 || m1362a4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                str = f1876d + str + f1876d;
            } else if (!m1362a4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i3 = 20;
        for (int i4 = 1; i4 < str.length() - 1; i4++) {
            if (Character.isDigit(str.charAt(i4)) || str.charAt(i4) == '-' || str.charAt(i4) == '$') {
                i3 += 9;
            } else {
                if (!C0989a.m1362a(f1875c, str.charAt(i4))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i4) + '\'');
                }
                i3 += 10;
            }
        }
        boolean[] zArr = new boolean[i3 + (str.length() - 1)];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i6));
            if (i6 == 0 || i6 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i7 = 0;
            while (true) {
                char[] cArr = C0989a.f1777g;
                if (i7 >= cArr.length) {
                    i2 = 0;
                    break;
                }
                if (upperCase3 == cArr[i7]) {
                    i2 = C0989a.f1778h[i7];
                    break;
                }
                i7++;
            }
            int i8 = i5;
            int i9 = 0;
            boolean z = true;
            while (true) {
                int i10 = 0;
                while (i9 < 7) {
                    zArr[i8] = z;
                    i8++;
                    if (((i2 >> (6 - i9)) & 1) == 0 || i10 == 1) {
                        z = !z;
                        i9++;
                    } else {
                        i10++;
                    }
                }
                break;
            }
            if (i6 < str.length() - 1) {
                zArr[i8] = false;
                i8++;
            }
            i5 = i8;
        }
        return zArr;
    }
}
