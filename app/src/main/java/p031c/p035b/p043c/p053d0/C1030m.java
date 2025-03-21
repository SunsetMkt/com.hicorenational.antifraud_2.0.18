package p031c.p035b.p043c.p053d0;

import java.util.Map;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1107r;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1162a;

/* compiled from: ITFReader.java */
/* renamed from: c.b.c.d0.m */
/* loaded from: classes.dex */
public final class C1030m extends AbstractC1034q {

    /* renamed from: b */
    private static final float f1927b = 0.38f;

    /* renamed from: c */
    private static final float f1928c = 0.78f;

    /* renamed from: d */
    private static final int f1929d = 3;

    /* renamed from: e */
    private static final int f1930e = 1;

    /* renamed from: f */
    private static final int[] f1931f = {6, 8, 10, 12, 14};

    /* renamed from: g */
    private static final int[] f1932g = {1, 1, 1, 1};

    /* renamed from: h */
    private static final int[] f1933h = {1, 1, 3};

    /* renamed from: i */
    static final int[][] f1934i = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a */
    private int f1935a = -1;

    /* renamed from: c */
    private static int m1504c(C1162a c1162a) throws C1102m {
        int m2157c = c1162a.m2157c();
        int m2158c = c1162a.m2158c(0);
        if (m2158c != m2157c) {
            return m2158c;
        }
        throw C1102m.getNotFoundInstance();
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1034q
    /* renamed from: a */
    public C1107r mo1365a(int i2, C1162a c1162a, Map<EnumC1044e, ?> map) throws C1097h, C1102m {
        boolean z;
        int[] m1507b = m1507b(c1162a);
        int[] m1506a = m1506a(c1162a);
        StringBuilder sb = new StringBuilder(20);
        m1503a(c1162a, m1507b[1], m1506a[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(EnumC1044e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f1931f;
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
            throw C1097h.getFormatInstance();
        }
        float f2 = i2;
        return new C1107r(sb2, null, new C1109t[]{new C1109t(m1507b[1], f2), new C1109t(m1506a[0], f2)}, EnumC0953a.ITF);
    }

    /* renamed from: b */
    int[] m1507b(C1162a c1162a) throws C1102m {
        int[] m1505c = m1505c(c1162a, m1504c(c1162a), f1932g);
        this.f1935a = (m1505c[1] - m1505c[0]) / 4;
        m1502a(c1162a, m1505c[0]);
        return m1505c;
    }

    /* renamed from: c */
    private static int[] m1505c(C1162a c1162a, int i2, int[] iArr) throws C1102m {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int m2157c = c1162a.m2157c();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < m2157c) {
            if (c1162a.m2155b(i2) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else {
                    if (AbstractC1034q.m1508a(iArr2, iArr, f1928c) < f1927b) {
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
        throw C1102m.getNotFoundInstance();
    }

    /* renamed from: a */
    private static void m1503a(C1162a c1162a, int i2, int i3, StringBuilder sb) throws C1102m {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            AbstractC1034q.m1509a(c1162a, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (m1501a(iArr2) + 48));
            sb.append((char) (m1501a(iArr3) + 48));
            for (int i6 : iArr) {
                i2 += i6;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        return;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m1502a(p031c.p035b.p043c.p072z.C1162a r3, int r4) throws p031c.p035b.p043c.C1102m {
        /*
            r2 = this;
            int r0 = r2.f1935a
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
            boolean r1 = r3.m2155b(r4)
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
            c.b.c.m r3 = p031c.p035b.p043c.C1102m.getNotFoundInstance()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p053d0.C1030m.m1502a(c.b.c.z.a, int):void");
    }

    /* renamed from: a */
    int[] m1506a(C1162a c1162a) throws C1102m {
        c1162a.m2162e();
        try {
            int[] m1505c = m1505c(c1162a, m1504c(c1162a), f1933h);
            m1502a(c1162a, m1505c[0]);
            int i2 = m1505c[0];
            m1505c[0] = c1162a.m2157c() - m1505c[1];
            m1505c[1] = c1162a.m2157c() - i2;
            return m1505c;
        } finally {
            c1162a.m2162e();
        }
    }

    /* renamed from: a */
    private static int m1501a(int[] iArr) throws C1102m {
        int length = f1934i.length;
        float f2 = f1927b;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float m1508a = AbstractC1034q.m1508a(iArr, f1934i[i3], f1928c);
            if (m1508a < f2) {
                i2 = i3;
                f2 = m1508a;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw C1102m.getNotFoundInstance();
    }
}
