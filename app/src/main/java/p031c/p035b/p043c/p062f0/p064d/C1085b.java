package p031c.p035b.p043c.p062f0.p064d;

import java.util.ArrayList;
import java.util.List;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.InterfaceC1110u;
import p031c.p035b.p043c.p072z.C1163b;

/* compiled from: AlignmentPatternFinder.java */
/* renamed from: c.b.c.f0.d.b */
/* loaded from: classes.dex */
final class C1085b {

    /* renamed from: a */
    private final C1163b f2147a;

    /* renamed from: c */
    private final int f2149c;

    /* renamed from: d */
    private final int f2150d;

    /* renamed from: e */
    private final int f2151e;

    /* renamed from: f */
    private final int f2152f;

    /* renamed from: g */
    private final float f2153g;

    /* renamed from: i */
    private final InterfaceC1110u f2155i;

    /* renamed from: b */
    private final List<C1084a> f2148b = new ArrayList(5);

    /* renamed from: h */
    private final int[] f2154h = new int[3];

    C1085b(C1163b c1163b, int i2, int i3, int i4, int i5, float f2, InterfaceC1110u interfaceC1110u) {
        this.f2147a = c1163b;
        this.f2149c = i2;
        this.f2150d = i3;
        this.f2151e = i4;
        this.f2152f = i5;
        this.f2153g = f2;
        this.f2155i = interfaceC1110u;
    }

    /* renamed from: a */
    C1084a m1790a() throws C1102m {
        C1084a m1788a;
        C1084a m1788a2;
        int i2 = this.f2149c;
        int i3 = this.f2152f;
        int i4 = this.f2151e + i2;
        int i5 = this.f2150d + (i3 / 2);
        int[] iArr = new int[3];
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = ((i6 & 1) == 0 ? (i6 + 1) / 2 : -((i6 + 1) / 2)) + i5;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i8 = i2;
            while (i8 < i4 && !this.f2147a.m2173b(i8, i7)) {
                i8++;
            }
            int i9 = 0;
            while (i8 < i4) {
                if (!this.f2147a.m2173b(i8, i7)) {
                    if (i9 == 1) {
                        i9++;
                    }
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 == 1) {
                    iArr[i9] = iArr[i9] + 1;
                } else if (i9 != 2) {
                    i9++;
                    iArr[i9] = iArr[i9] + 1;
                } else {
                    if (m1789a(iArr) && (m1788a2 = m1788a(iArr, i7, i8)) != null) {
                        return m1788a2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i9 = 1;
                }
                i8++;
            }
            if (m1789a(iArr) && (m1788a = m1788a(iArr, i7, i4)) != null) {
                return m1788a;
            }
        }
        if (this.f2148b.isEmpty()) {
            throw C1102m.getNotFoundInstance();
        }
        return this.f2148b.get(0);
    }

    /* renamed from: a */
    private static float m1787a(int[] iArr, int i2) {
        return (i2 - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* renamed from: a */
    private boolean m1789a(int[] iArr) {
        float f2 = this.f2153g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - iArr[i2]) >= f3) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
    
        if (r2[1] <= r12) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
    
        if (r10 >= r1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
    
        if (r0.m2173b(r11, r10) != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
    
        if (r2[2] > r12) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0071, code lost:
    
        r2[2] = r2[2] + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
    
        if (r2[2] <= r12) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
    
        if ((java.lang.Math.abs(((r2[0] + r2[1]) + r2[2]) - r13) * 5) < (r13 * 2)) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0091, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0096, code lost:
    
        if (m1789a(r2) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009c, code lost:
    
        return m1787a(r2, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return Float.NaN;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float m1786a(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            c.b.c.z.b r0 = r9.f2147a
            int r1 = r0.m2177d()
            int[] r2 = r9.f2154h
            r3 = 0
            r2[r3] = r3
            r4 = 1
            r2[r4] = r3
            r5 = 2
            r2[r5] = r3
            r6 = r10
        L12:
            if (r6 < 0) goto L26
            boolean r7 = r0.m2173b(r11, r6)
            if (r7 == 0) goto L26
            r7 = r2[r4]
            if (r7 > r12) goto L26
            r7 = r2[r4]
            int r7 = r7 + r4
            r2[r4] = r7
            int r6 = r6 + (-1)
            goto L12
        L26:
            r7 = 2143289344(0x7fc00000, float:NaN)
            if (r6 < 0) goto L9c
            r8 = r2[r4]
            if (r8 <= r12) goto L30
            goto L9c
        L30:
            if (r6 < 0) goto L44
            boolean r8 = r0.m2173b(r11, r6)
            if (r8 != 0) goto L44
            r8 = r2[r3]
            if (r8 > r12) goto L44
            r8 = r2[r3]
            int r8 = r8 + r4
            r2[r3] = r8
            int r6 = r6 + (-1)
            goto L30
        L44:
            r6 = r2[r3]
            if (r6 <= r12) goto L49
            return r7
        L49:
            int r10 = r10 + r4
        L4a:
            if (r10 >= r1) goto L5e
            boolean r6 = r0.m2173b(r11, r10)
            if (r6 == 0) goto L5e
            r6 = r2[r4]
            if (r6 > r12) goto L5e
            r6 = r2[r4]
            int r6 = r6 + r4
            r2[r4] = r6
            int r10 = r10 + 1
            goto L4a
        L5e:
            if (r10 == r1) goto L9c
            r6 = r2[r4]
            if (r6 <= r12) goto L65
            goto L9c
        L65:
            if (r10 >= r1) goto L79
            boolean r6 = r0.m2173b(r11, r10)
            if (r6 != 0) goto L79
            r6 = r2[r5]
            if (r6 > r12) goto L79
            r6 = r2[r5]
            int r6 = r6 + r4
            r2[r5] = r6
            int r10 = r10 + 1
            goto L65
        L79:
            r11 = r2[r5]
            if (r11 <= r12) goto L7e
            return r7
        L7e:
            r11 = r2[r3]
            r12 = r2[r4]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            int r13 = r13 * 2
            if (r11 < r13) goto L92
            return r7
        L92:
            boolean r11 = r9.m1789a(r2)
            if (r11 == 0) goto L9c
            float r7 = m1787a(r2, r10)
        L9c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p062f0.p064d.C1085b.m1786a(int, int, int, int):float");
    }

    /* renamed from: a */
    private C1084a m1788a(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2];
        float m1787a = m1787a(iArr, i3);
        float m1786a = m1786a(i2, (int) m1787a, iArr[1] * 2, i4);
        if (Float.isNaN(m1786a)) {
            return null;
        }
        float f2 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (C1084a c1084a : this.f2148b) {
            if (c1084a.m1784a(f2, m1786a, m1787a)) {
                return c1084a.m1785b(m1786a, m1787a, f2);
            }
        }
        C1084a c1084a2 = new C1084a(m1787a, m1786a, f2);
        this.f2148b.add(c1084a2);
        InterfaceC1110u interfaceC1110u = this.f2155i;
        if (interfaceC1110u == null) {
            return null;
        }
        interfaceC1110u.mo1924a(c1084a2);
        return null;
    }
}
