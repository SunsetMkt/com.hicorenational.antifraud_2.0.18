package p031c.p035b.p043c.p057e0.p058e;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Formatter;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.C1109t;
import p031c.p035b.p043c.p057e0.C1045a;
import p031c.p035b.p043c.p057e0.p058e.p059k.C1059a;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1166e;

/* compiled from: PDF417ScanningDecoder.java */
/* renamed from: c.b.c.e0.e.j */
/* loaded from: classes.dex */
public final class C1058j {

    /* renamed from: a */
    private static final int f2036a = 2;

    /* renamed from: b */
    private static final int f2037b = 3;

    /* renamed from: c */
    private static final int f2038c = 512;

    /* renamed from: d */
    private static final C1059a f2039d = new C1059a();

    private C1058j() {
    }

    /* renamed from: a */
    public static C1166e m1637a(C1163b c1163b, C1109t c1109t, C1109t c1109t2, C1109t c1109t3, C1109t c1109t4, int i2, int i3) throws C1102m, C1097h, C0988d {
        C1056h c1056h;
        int i4;
        int i5;
        int i6;
        C1056h c1056h2 = null;
        C1054f c1054f = null;
        C1056h c1056h3 = null;
        C1051c c1051c = new C1051c(c1163b, c1109t, c1109t2, c1109t3, c1109t4);
        int i7 = 0;
        while (i7 < 2) {
            if (c1109t != null) {
                c1056h2 = m1635a(c1163b, c1051c, c1109t, true, i2, i3);
            }
            c1056h = c1056h2;
            if (c1109t3 != null) {
                c1056h3 = m1635a(c1163b, c1051c, c1109t3, false, i2, i3);
            }
            c1054f = m1648b(c1056h, c1056h3);
            if (c1054f == null) {
                throw C1102m.getNotFoundInstance();
            }
            if (i7 != 0 || c1054f.m1608d() == null || (c1054f.m1608d().m1573f() >= c1051c.m1573f() && c1054f.m1608d().m1571d() <= c1051c.m1571d())) {
                c1054f.m1605a(c1051c);
                break;
            }
            c1051c = c1054f.m1608d();
            i7++;
            c1056h2 = c1056h;
        }
        c1056h = c1056h2;
        int m1602a = c1054f.m1602a() + 1;
        c1054f.m1604a(0, c1056h);
        c1054f.m1604a(m1602a, c1056h3);
        boolean z = c1056h != null;
        int i8 = i2;
        int i9 = i3;
        for (int i10 = 1; i10 <= m1602a; i10++) {
            int i11 = z ? i10 : m1602a - i10;
            if (c1054f.m1603a(i11) == null) {
                C1055g c1056h4 = (i11 == 0 || i11 == m1602a) ? new C1056h(c1051c, i11 == 0) : new C1055g(c1051c);
                c1054f.m1604a(i11, c1056h4);
                int i12 = -1;
                int i13 = i9;
                int i14 = -1;
                int i15 = i8;
                int m1573f = c1051c.m1573f();
                while (m1573f <= c1051c.m1571d()) {
                    int m1628a = m1628a(c1054f, i11, m1573f, z);
                    if (m1628a >= 0 && m1628a <= c1051c.m1570c()) {
                        i4 = m1628a;
                    } else if (i14 == i12) {
                        i5 = i14;
                        i6 = i13;
                        i13 = i6;
                        i14 = i5;
                        m1573f++;
                        i12 = -1;
                    } else {
                        i4 = i14;
                    }
                    i5 = i14;
                    int i16 = i13;
                    C1052d m1634a = m1634a(c1163b, c1051c.m1572e(), c1051c.m1570c(), z, i4, m1573f, i15, i16);
                    if (m1634a != null) {
                        c1056h4.m1612a(m1573f, m1634a);
                        i15 = Math.min(i15, m1634a.m1583f());
                        i13 = Math.max(i16, m1634a.m1583f());
                        i14 = i4;
                        m1573f++;
                        i12 = -1;
                    } else {
                        i6 = i16;
                        i13 = i6;
                        i14 = i5;
                        m1573f++;
                        i12 = -1;
                    }
                }
                i8 = i15;
                i9 = i13;
            }
        }
        return m1649b(c1054f);
    }

    /* renamed from: a */
    private static boolean m1642a(int i2, int i3, int i4) {
        return i3 + (-2) <= i2 && i2 <= i4 + 2;
    }

    /* renamed from: b */
    private static C1054f m1648b(C1056h c1056h, C1056h c1056h2) throws C1102m, C1097h {
        C1049a m1632a;
        if ((c1056h == null && c1056h2 == null) || (m1632a = m1632a(c1056h, c1056h2)) == null) {
            return null;
        }
        return new C1054f(m1632a, C1051c.m1564a(m1633a(c1056h), m1633a(c1056h2)));
    }

    /* renamed from: c */
    private static int m1651c(int i2) {
        return 2 << i2;
    }

    /* renamed from: b */
    private static int m1647b(int[] iArr) {
        int i2 = -1;
        for (int i3 : iArr) {
            i2 = Math.max(i2, i3);
        }
        return i2;
    }

    /* renamed from: b */
    private static C1166e m1649b(C1054f c1054f) throws C1097h, C0988d, C1102m {
        C1050b[][] m1645a = m1645a(c1054f);
        m1640a(c1054f, m1645a);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[c1054f.m1607c() * c1054f.m1602a()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < c1054f.m1607c(); i2++) {
            int i3 = 0;
            while (i3 < c1054f.m1602a()) {
                int i4 = i3 + 1;
                int[] m1562a = m1645a[i2][i4].m1562a();
                int m1602a = (c1054f.m1602a() * i2) + i3;
                if (m1562a.length == 0) {
                    arrayList.add(Integer.valueOf(m1602a));
                } else if (m1562a.length == 1) {
                    iArr[m1602a] = m1562a[0];
                } else {
                    arrayList3.add(Integer.valueOf(m1602a));
                    arrayList2.add(m1562a);
                }
                i3 = i4;
            }
        }
        int[][] iArr2 = new int[arrayList2.size()][];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            iArr2[i5] = (int[]) arrayList2.get(i5);
        }
        return m1636a(c1054f.m1606b(), iArr, C1045a.m1539a(arrayList), C1045a.m1539a(arrayList3), iArr2);
    }

    /* renamed from: a */
    private static C1051c m1633a(C1056h c1056h) throws C1102m, C1097h {
        int[] m1620d;
        if (c1056h == null || (m1620d = c1056h.m1620d()) == null) {
            return null;
        }
        int m1647b = m1647b(m1620d);
        int i2 = 0;
        int i3 = 0;
        for (int i4 : m1620d) {
            i3 += m1647b - i4;
            if (i4 > 0) {
                break;
            }
        }
        C1052d[] m1614b = c1056h.m1614b();
        for (int i5 = 0; i3 > 0 && m1614b[i5] == null; i5++) {
            i3--;
        }
        for (int length = m1620d.length - 1; length >= 0; length--) {
            i2 += m1647b - m1620d[length];
            if (m1620d[length] > 0) {
                break;
            }
        }
        for (int length2 = m1614b.length - 1; i2 > 0 && m1614b[length2] == null; length2--) {
            i2--;
        }
        return c1056h.m1610a().m1567a(i3, i2, c1056h.m1621e());
    }

    /* renamed from: b */
    private static int[] m1650b(C1163b c1163b, int i2, int i3, boolean z, int i4, int i5) {
        int[] iArr = new int[8];
        int i6 = z ? 1 : -1;
        int i7 = 0;
        boolean z2 = z;
        while (true) {
            if (((!z || i4 >= i3) && (z || i4 < i2)) || i7 >= iArr.length) {
                break;
            }
            if (c1163b.m2173b(i4, i5) == z2) {
                iArr[i7] = iArr[i7] + 1;
                i4 += i6;
            } else {
                i7++;
                z2 = !z2;
            }
        }
        if (i7 == iArr.length || (((z && i4 == i3) || (!z && i4 == i2)) && i7 == iArr.length - 1)) {
            return iArr;
        }
        return null;
    }

    /* renamed from: b */
    private static int m1646b(int i2) {
        return m1630a(m1644a(i2));
    }

    /* renamed from: a */
    private static C1049a m1632a(C1056h c1056h, C1056h c1056h2) {
        C1049a m1619c;
        C1049a m1619c2;
        if (c1056h == null || (m1619c = c1056h.m1619c()) == null) {
            if (c1056h2 == null) {
                return null;
            }
            return c1056h2.m1619c();
        }
        if (c1056h2 == null || (m1619c2 = c1056h2.m1619c()) == null || m1619c.m1556a() == m1619c2.m1556a() || m1619c.m1557b() == m1619c2.m1557b() || m1619c.m1558c() == m1619c2.m1558c()) {
            return m1619c;
        }
        return null;
    }

    /* renamed from: a */
    private static C1056h m1635a(C1163b c1163b, C1051c c1051c, C1109t c1109t, boolean z, int i2, int i3) {
        C1056h c1056h = new C1056h(c1051c, z);
        int i4 = 0;
        while (i4 < 2) {
            int i5 = i4 == 0 ? 1 : -1;
            int m1922a = (int) c1109t.m1922a();
            for (int m1923b = (int) c1109t.m1923b(); m1923b <= c1051c.m1571d() && m1923b >= c1051c.m1573f(); m1923b += i5) {
                C1052d m1634a = m1634a(c1163b, 0, c1163b.m2181g(), z, m1922a, m1923b, i2, i3);
                if (m1634a != null) {
                    c1056h.m1612a(m1923b, m1634a);
                    if (z) {
                        m1922a = m1634a.m1581d();
                    } else {
                        m1922a = m1634a.m1578b();
                    }
                }
            }
            i4++;
        }
        return c1056h;
    }

    /* renamed from: a */
    private static void m1640a(C1054f c1054f, C1050b[][] c1050bArr) throws C1102m {
        int[] m1562a = c1050bArr[0][1].m1562a();
        int m1602a = (c1054f.m1602a() * c1054f.m1607c()) - m1651c(c1054f.m1606b());
        if (m1562a.length != 0) {
            if (m1562a[0] != m1602a) {
                c1050bArr[0][1].m1563b(m1602a);
            }
        } else {
            if (m1602a >= 1 && m1602a <= 928) {
                c1050bArr[0][1].m1563b(m1602a);
                return;
            }
            throw C1102m.getNotFoundInstance();
        }
    }

    /* renamed from: a */
    private static C1166e m1636a(int i2, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws C1097h, C0988d {
        int[] iArr5 = new int[iArr3.length];
        int i3 = 100;
        while (true) {
            int i4 = i3 - 1;
            if (i3 > 0) {
                for (int i5 = 0; i5 < iArr5.length; i5++) {
                    iArr[iArr3[i5]] = iArr4[i5][iArr5[i5]];
                }
                try {
                    return m1638a(iArr, i2, iArr2);
                } catch (C0988d unused) {
                    if (iArr5.length == 0) {
                        throw C0988d.getChecksumInstance();
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 >= iArr5.length) {
                            break;
                        }
                        if (iArr5[i6] < iArr4[i6].length - 1) {
                            iArr5[i6] = iArr5[i6] + 1;
                            break;
                        }
                        iArr5[i6] = 0;
                        if (i6 == iArr5.length - 1) {
                            throw C0988d.getChecksumInstance();
                        }
                        i6++;
                    }
                    i3 = i4;
                }
            } else {
                throw C0988d.getChecksumInstance();
            }
        }
    }

    /* renamed from: a */
    private static C1050b[][] m1645a(C1054f c1054f) throws C1097h {
        int m1580c;
        C1050b[][] c1050bArr = (C1050b[][]) Array.newInstance((Class<?>) C1050b.class, c1054f.m1607c(), c1054f.m1602a() + 2);
        for (int i2 = 0; i2 < c1050bArr.length; i2++) {
            for (int i3 = 0; i3 < c1050bArr[i2].length; i3++) {
                c1050bArr[i2][i3] = new C1050b();
            }
        }
        int i4 = 0;
        for (C1055g c1055g : c1054f.m1609e()) {
            if (c1055g != null) {
                for (C1052d c1052d : c1055g.m1614b()) {
                    if (c1052d != null && (m1580c = c1052d.m1580c()) >= 0) {
                        if (m1580c < c1050bArr.length) {
                            c1050bArr[m1580c][i4].m1563b(c1052d.m1582e());
                        } else {
                            throw C1097h.getFormatInstance();
                        }
                    }
                }
            }
            i4++;
        }
        return c1050bArr;
    }

    /* renamed from: a */
    private static boolean m1643a(C1054f c1054f, int i2) {
        return i2 >= 0 && i2 <= c1054f.m1602a() + 1;
    }

    /* renamed from: a */
    private static int m1628a(C1054f c1054f, int i2, int i3, boolean z) {
        int i4 = z ? 1 : -1;
        int i5 = i2 - i4;
        C1052d m1611a = m1643a(c1054f, i5) ? c1054f.m1603a(i5).m1611a(i3) : null;
        if (m1611a != null) {
            return z ? m1611a.m1578b() : m1611a.m1581d();
        }
        C1052d m1613b = c1054f.m1603a(i2).m1613b(i3);
        if (m1613b != null) {
            return z ? m1613b.m1581d() : m1613b.m1578b();
        }
        if (m1643a(c1054f, i5)) {
            m1613b = c1054f.m1603a(i5).m1613b(i3);
        }
        if (m1613b != null) {
            return z ? m1613b.m1578b() : m1613b.m1581d();
        }
        int i6 = 0;
        while (true) {
            i2 -= i4;
            if (m1643a(c1054f, i2)) {
                for (C1052d c1052d : c1054f.m1603a(i2).m1614b()) {
                    if (c1052d != null) {
                        return (z ? c1052d.m1578b() : c1052d.m1581d()) + (i4 * i6 * (c1052d.m1578b() - c1052d.m1581d()));
                    }
                }
                i6++;
            } else {
                C1051c m1608d = c1054f.m1608d();
                return z ? m1608d.m1572e() : m1608d.m1570c();
            }
        }
    }

    /* renamed from: a */
    private static C1052d m1634a(C1163b c1163b, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        int i8;
        int m1626d;
        int m1537a;
        int m1629a = m1629a(c1163b, i2, i3, z, i4, i5);
        int[] m1650b = m1650b(c1163b, i2, i3, z, m1629a, i5);
        if (m1650b == null) {
            return null;
        }
        int m1538a = C1045a.m1538a(m1650b);
        if (z) {
            m1629a += m1538a;
            i8 = m1629a;
        } else {
            for (int i9 = 0; i9 < m1650b.length / 2; i9++) {
                int i10 = m1650b[i9];
                m1650b[i9] = m1650b[(m1650b.length - 1) - i9];
                m1650b[(m1650b.length - 1) - i9] = i10;
            }
            i8 = m1629a - m1538a;
        }
        if (m1642a(m1538a, i6, i7) && (m1537a = C1045a.m1537a((m1626d = C1057i.m1626d(m1650b)))) != -1) {
            return new C1052d(i8, m1629a, m1646b(m1626d), m1537a);
        }
        return null;
    }

    /* renamed from: a */
    private static int m1629a(C1163b c1163b, int i2, int i3, boolean z, int i4, int i5) {
        int i6 = z ? -1 : 1;
        boolean z2 = z;
        int i7 = i4;
        for (int i8 = 0; i8 < 2; i8++) {
            while (true) {
                if (((z2 && i7 >= i2) || (!z2 && i7 < i3)) && z2 == c1163b.m2173b(i7, i5)) {
                    if (Math.abs(i4 - i7) > 2) {
                        return i4;
                    }
                    i7 += i6;
                }
            }
            i6 = -i6;
            z2 = !z2;
        }
        return i7;
    }

    /* renamed from: a */
    private static C1166e m1638a(int[] iArr, int i2, int[] iArr2) throws C1097h, C0988d {
        if (iArr.length != 0) {
            int i3 = 1 << (i2 + 1);
            int m1631a = m1631a(iArr, iArr2, i3);
            m1641a(iArr, i3);
            C1166e m1589a = C1053e.m1589a(iArr, String.valueOf(i2));
            m1589a.m2191b(Integer.valueOf(m1631a));
            m1589a.m2188a(Integer.valueOf(iArr2.length));
            return m1589a;
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: a */
    private static int m1631a(int[] iArr, int[] iArr2, int i2) throws C0988d {
        if ((iArr2 == null || iArr2.length <= (i2 / 2) + 3) && i2 >= 0 && i2 <= 512) {
            return f2039d.m1655a(iArr, i2, iArr2);
        }
        throw C0988d.getChecksumInstance();
    }

    /* renamed from: a */
    private static void m1641a(int[] iArr, int i2) throws C1097h {
        if (iArr.length >= 4) {
            int i3 = iArr[0];
            if (i3 > iArr.length) {
                throw C1097h.getFormatInstance();
            }
            if (i3 == 0) {
                if (i2 < iArr.length) {
                    iArr[0] = iArr.length - i2;
                    return;
                }
                throw C1097h.getFormatInstance();
            }
            return;
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: a */
    private static int[] m1644a(int i2) {
        int[] iArr = new int[8];
        int length = iArr.length - 1;
        int i3 = 0;
        while (true) {
            int i4 = i2 & 1;
            if (i4 != i3) {
                length--;
                if (length < 0) {
                    return iArr;
                }
                i3 = i4;
            }
            iArr[length] = iArr[length] + 1;
            i2 >>= 1;
        }
    }

    /* renamed from: a */
    private static int m1630a(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    /* renamed from: a */
    public static String m1639a(C1050b[][] c1050bArr) {
        Formatter formatter = new Formatter();
        for (int i2 = 0; i2 < c1050bArr.length; i2++) {
            formatter.format("Row %2d: ", Integer.valueOf(i2));
            for (int i3 = 0; i3 < c1050bArr[i2].length; i3++) {
                C1050b c1050b = c1050bArr[i2][i3];
                if (c1050b.m1562a().length == 0) {
                    formatter.format("        ", null);
                } else {
                    formatter.format("%4d(%2d)", Integer.valueOf(c1050b.m1562a()[0]), c1050b.m1561a(c1050b.m1562a()[0]));
                }
            }
            formatter.format("%n", new Object[0]);
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
