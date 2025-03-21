package p031c.p035b.p043c.p066x.p069f;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import p286h.C5230f1;

/* compiled from: HighLevelEncoder.java */
/* renamed from: c.b.c.x.f.d */
/* loaded from: classes.dex */
public final class C1121d {

    /* renamed from: c */
    static final int f2259c = 0;

    /* renamed from: d */
    static final int f2260d = 1;

    /* renamed from: e */
    static final int f2261e = 2;

    /* renamed from: f */
    static final int f2262f = 3;

    /* renamed from: g */
    static final int f2263g = 4;

    /* renamed from: j */
    static final int[][] f2266j;

    /* renamed from: a */
    private final byte[] f2267a;

    /* renamed from: b */
    static final String[] f2258b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: h */
    static final int[][] f2264h = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: i */
    private static final int[][] f2265i = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);

    /* compiled from: HighLevelEncoder.java */
    /* renamed from: c.b.c.x.f.d$a */
    class a implements Comparator<C1123f> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1123f c1123f, C1123f c1123f2) {
            return c1123f.m1994b() - c1123f2.m1994b();
        }
    }

    static {
        f2265i[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            f2265i[0][i2] = (i2 - 65) + 2;
        }
        f2265i[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            f2265i[1][i3] = (i3 - 97) + 2;
        }
        f2265i[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            f2265i[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr = f2265i;
        iArr[2][44] = 12;
        iArr[2][46] = 13;
        int[] iArr2 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            f2265i[3][iArr2[i5]] = i5;
        }
        int[] iArr3 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < iArr3.length; i6++) {
            if (iArr3[i6] > 0) {
                f2265i[4][iArr3[i6]] = i6;
            }
        }
        f2266j = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        for (int[] iArr4 : f2266j) {
            Arrays.fill(iArr4, -1);
        }
        int[][] iArr5 = f2266j;
        iArr5[0][4] = 0;
        iArr5[1][4] = 0;
        iArr5[1][0] = 28;
        iArr5[3][4] = 0;
        iArr5[2][4] = 0;
        iArr5[2][0] = 15;
    }

    public C1121d(byte[] bArr) {
        this.f2267a = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p031c.p035b.p043c.p072z.C1162a m1987a() {
        /*
            r8 = this;
            c.b.c.x.f.f r0 = p031c.p035b.p043c.p066x.p069f.C1123f.f2271e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r0
            r0 = 0
        L9:
            byte[] r3 = r8.f2267a
            int r4 = r3.length
            if (r0 >= r4) goto L50
            int r4 = r0 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L16
            r3 = r3[r4]
            goto L17
        L16:
            r3 = 0
        L17:
            byte[] r5 = r8.f2267a
            r5 = r5[r0]
            r6 = 13
            if (r5 == r6) goto L3b
            r6 = 44
            r7 = 32
            if (r5 == r6) goto L37
            r6 = 46
            if (r5 == r6) goto L33
            r6 = 58
            if (r5 == r6) goto L2f
        L2d:
            r3 = 0
            goto L40
        L2f:
            if (r3 != r7) goto L2d
            r3 = 5
            goto L40
        L33:
            if (r3 != r7) goto L2d
            r3 = 3
            goto L40
        L37:
            if (r3 != r7) goto L2d
            r3 = 4
            goto L40
        L3b:
            r5 = 10
            if (r3 != r5) goto L2d
            r3 = 2
        L40:
            if (r3 <= 0) goto L49
            java.util.Collection r0 = m1984a(r2, r0, r3)
            r2 = r0
            r0 = r4
            goto L4d
        L49:
            java.util.Collection r2 = r8.m1983a(r2, r0)
        L4d:
            int r0 = r0 + 1
            goto L9
        L50:
            c.b.c.x.f.d$a r0 = new c.b.c.x.f.d$a
            r0.<init>()
            java.lang.Object r0 = java.util.Collections.min(r2, r0)
            c.b.c.x.f.f r0 = (p031c.p035b.p043c.p066x.p069f.C1123f) r0
            byte[] r1 = r8.f2267a
            c.b.c.z.a r0 = r0.m1992a(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p066x.p069f.C1121d.m1987a():c.b.c.z.a");
    }

    /* renamed from: a */
    private Collection<C1123f> m1983a(Iterable<C1123f> iterable, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<C1123f> it = iterable.iterator();
        while (it.hasNext()) {
            m1986a(it.next(), i2, linkedList);
        }
        return m1982a(linkedList);
    }

    /* renamed from: a */
    private void m1986a(C1123f c1123f, int i2, Collection<C1123f> collection) {
        char c2 = (char) (this.f2267a[i2] & C5230f1.f20085c);
        boolean z = f2265i[c1123f.m1997c()][c2] > 0;
        C1123f c1123f2 = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = f2265i[i3][c2];
            if (i4 > 0) {
                if (c1123f2 == null) {
                    c1123f2 = c1123f.m1995b(i2);
                }
                if (!z || i3 == c1123f.m1997c() || i3 == 2) {
                    collection.add(c1123f2.m1991a(i3, i4));
                }
                if (!z && f2266j[c1123f.m1997c()][i3] >= 0) {
                    collection.add(c1123f2.m1996b(i3, i4));
                }
            }
        }
        if (c1123f.m1989a() > 0 || f2265i[c1123f.m1997c()][c2] == 0) {
            collection.add(c1123f.m1990a(i2));
        }
    }

    /* renamed from: a */
    private static Collection<C1123f> m1984a(Iterable<C1123f> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        Iterator<C1123f> it = iterable.iterator();
        while (it.hasNext()) {
            m1985a(it.next(), i2, i3, linkedList);
        }
        return m1982a(linkedList);
    }

    /* renamed from: a */
    private static void m1985a(C1123f c1123f, int i2, int i3, Collection<C1123f> collection) {
        C1123f m1995b = c1123f.m1995b(i2);
        collection.add(m1995b.m1991a(4, i3));
        if (c1123f.m1997c() != 4) {
            collection.add(m1995b.m1996b(4, i3));
        }
        if (i3 == 3 || i3 == 4) {
            collection.add(m1995b.m1991a(2, 16 - i3).m1991a(2, 1));
        }
        if (c1123f.m1989a() > 0) {
            collection.add(c1123f.m1990a(i2).m1990a(i2 + 1));
        }
    }

    /* renamed from: a */
    private static Collection<C1123f> m1982a(Iterable<C1123f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (C1123f c1123f : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C1123f c1123f2 = (C1123f) it.next();
                if (c1123f2.m1993a(c1123f)) {
                    z = false;
                    break;
                }
                if (c1123f.m1993a(c1123f2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(c1123f);
            }
        }
        return linkedList;
    }
}
