package p031c.p035b.p043c.p053d0;

import java.util.Arrays;
import java.util.Map;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: CodaBarReader.java */
/* renamed from: c.b.c.d0.a */
/* loaded from: classes.dex */
public final class C0989a extends AbstractC1034q {

    /* renamed from: d */
    private static final float f1774d = 2.0f;

    /* renamed from: e */
    private static final float f1775e = 1.5f;

    /* renamed from: i */
    private static final int f1779i = 3;

    /* renamed from: a */
    private final StringBuilder f1781a = new StringBuilder(20);

    /* renamed from: b */
    private int[] f1782b = new int[80];

    /* renamed from: c */
    private int f1783c = 0;

    /* renamed from: f */
    private static final String f1776f = "0123456789-$:/.+ABCD";

    /* renamed from: g */
    static final char[] f1777g = f1776f.toCharArray();

    /* renamed from: h */
    static final int[] f1778h = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: j */
    private static final char[] f1780j = {'A', 'B', 'C', 'D'};

    /* renamed from: b */
    private void m1363b(int i2) {
        int[] iArr = this.f1782b;
        int i3 = this.f1783c;
        iArr[i3] = i2;
        this.f1783c = i3 + 1;
        int i4 = this.f1783c;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f1782b = iArr2;
        }
    }

    /* renamed from: c */
    private int m1364c(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f1783c) {
            return -1;
        }
        int[] iArr = this.f1782b;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f1778h;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1102m {
        Arrays.fill(this.f1782b, 0);
        m1361a(c1162a);
        int m1360a = m1360a();
        this.f1781a.setLength(0);
        int i3 = m1360a;
        do {
            int m1364c = m1364c(i3);
            if (m1364c == -1) {
                throw C1102m.getNotFoundInstance();
            }
            this.f1781a.append((char) m1364c);
            i3 += 8;
            if (this.f1781a.length() > 1 && m1362a(f1780j, f1777g[m1364c])) {
                break;
            }
        } while (i3 < this.f1783c);
        int i4 = i3 - 1;
        int i5 = this.f1782b[i4];
        int i6 = 0;
        for (int i7 = -8; i7 < -1; i7++) {
            i6 += this.f1782b[i3 + i7];
        }
        if (i3 < this.f1783c && i5 < i6 / 2) {
            throw C1102m.getNotFoundInstance();
        }
        m1366a(m1360a);
        for (int i8 = 0; i8 < this.f1781a.length(); i8++) {
            StringBuilder sb = this.f1781a;
            sb.setCharAt(i8, f1777g[sb.charAt(i8)]);
        }
        if (!m1362a(f1780j, this.f1781a.charAt(0))) {
            throw C1102m.getNotFoundInstance();
        }
        StringBuilder sb2 = this.f1781a;
        if (!m1362a(f1780j, sb2.charAt(sb2.length() - 1))) {
            throw C1102m.getNotFoundInstance();
        }
        if (this.f1781a.length() <= 3) {
            throw C1102m.getNotFoundInstance();
        }
        if (map == null || !map.containsKey(EnumC1044e.RETURN_CODABAR_START_END)) {
            StringBuilder sb3 = this.f1781a;
            sb3.deleteCharAt(sb3.length() - 1);
            this.f1781a.deleteCharAt(0);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < m1360a; i10++) {
            i9 += this.f1782b[i10];
        }
        float f2 = i9;
        while (m1360a < i4) {
            i9 += this.f1782b[m1360a];
            m1360a++;
        }
        float f3 = i2;
        return new C1107r(this.f1781a.toString(), null, new C1109t[]{new C1109t(f2, f3), new C1109t(i9, f3)}, EnumC0953a.CODABAR);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ab, code lost:
    
        throw p031c.p035b.p043c.C1102m.getNotFoundInstance();
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m1366a(int r15) throws p031c.p035b.p043c.C1102m {
        /*
            Method dump skipped, instructions count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p053d0.C0989a.m1366a(int):void");
    }

    /* renamed from: a */
    private void m1361a(C1162a c1162a) throws C1102m {
        int i2 = 0;
        this.f1783c = 0;
        int m2161d = c1162a.m2161d(0);
        int m2157c = c1162a.m2157c();
        if (m2161d < m2157c) {
            boolean z = true;
            while (m2161d < m2157c) {
                if (c1162a.m2155b(m2161d) ^ z) {
                    i2++;
                } else {
                    m1363b(i2);
                    z = !z;
                    i2 = 1;
                }
                m2161d++;
            }
            m1363b(i2);
            return;
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private int m1360a() throws C1102m {
        for (int i2 = 1; i2 < this.f1783c; i2 += 2) {
            int m1364c = m1364c(i2);
            if (m1364c != -1 && m1362a(f1780j, f1777g[m1364c])) {
                int i3 = 0;
                for (int i4 = i2; i4 < i2 + 7; i4++) {
                    i3 += this.f1782b[i4];
                }
                if (i2 == 1 || this.f1782b[i2 - 1] >= i3 / 2) {
                    return i2;
                }
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    static boolean m1362a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }
}
