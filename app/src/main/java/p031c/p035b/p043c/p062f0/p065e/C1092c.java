package p031c.p035b.p043c.p062f0.p065e;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.EnumC1096g;
import p031c.p035b.p043c.p062f0.p063c.C1083j;
import p031c.p035b.p043c.p062f0.p063c.EnumC1079f;
import p031c.p035b.p043c.p062f0.p063c.EnumC1081h;
import p031c.p035b.p043c.p072z.C1162a;
import p031c.p035b.p043c.p072z.EnumC1165d;
import p031c.p035b.p043c.p072z.p074n.C1177a;
import p031c.p035b.p043c.p072z.p074n.C1180d;
import p286h.C5230f1;

/* compiled from: Encoder.java */
/* renamed from: c.b.c.f0.e.c */
/* loaded from: classes.dex */
public final class C1092c {

    /* renamed from: a */
    private static final int[] f2176a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b */
    static final String f2177b = "ISO-8859-1";

    /* compiled from: Encoder.java */
    /* renamed from: c.b.c.f0.e.c$a */
    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f2178a = new int[EnumC1081h.values().length];

        static {
            try {
                f2178a[EnumC1081h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2178a[EnumC1081h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2178a[EnumC1081h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2178a[EnumC1081h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private C1092c() {
    }

    /* renamed from: a */
    private static int m1835a(C1091b c1091b) {
        return C1093d.m1855a(c1091b) + C1093d.m1860b(c1091b) + C1093d.m1861c(c1091b) + C1093d.m1862d(c1091b);
    }

    /* renamed from: b */
    private static boolean m1854b(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & C5230f1.f20085c;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static C1095f m1840a(String str, EnumC1079f enumC1079f) throws C1112w {
        return m1841a(str, enumC1079f, (Map<EnumC1096g, ?>) null);
    }

    /* renamed from: b */
    static void m1853b(CharSequence charSequence, C1162a c1162a) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                c1162a.m2148a((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    c1162a.m2148a((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    c1162a.m2148a(charAt, 4);
                }
            }
        }
    }

    /* renamed from: a */
    public static C1095f m1841a(String str, EnumC1079f enumC1079f, Map<EnumC1096g, ?> map) throws C1112w {
        EnumC1165d characterSetECIByName;
        String str2 = map == null ? null : (String) map.get(EnumC1096g.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        EnumC1081h m1838a = m1838a(str, str2);
        C1162a c1162a = new C1162a();
        if (m1838a == EnumC1081h.BYTE && !"ISO-8859-1".equals(str2) && (characterSetECIByName = EnumC1165d.getCharacterSetECIByName(str2)) != null) {
            m1847a(characterSetECIByName, c1162a);
        }
        m1846a(m1838a, c1162a);
        C1162a c1162a2 = new C1162a();
        m1849a(str, m1838a, c1162a2, str2);
        C1083j m1839a = m1839a(c1162a.m2157c() + m1838a.getCharacterCountBits(m1839a(c1162a.m2157c() + m1838a.getCharacterCountBits(C1083j.m1770c(1)) + c1162a2.m2157c(), enumC1079f)) + c1162a2.m2157c(), enumC1079f);
        C1162a c1162a3 = new C1162a();
        c1162a3.m2150a(c1162a);
        m1844a(m1838a == EnumC1081h.BYTE ? c1162a2.m2160d() : str.length(), m1839a, m1838a, c1162a3);
        c1162a3.m2150a(c1162a2);
        C1083j.b m1772a = m1839a.m1772a(enumC1079f);
        int m1776d = m1839a.m1776d() - m1772a.m1783d();
        m1845a(m1776d, c1162a3);
        C1162a m1842a = m1842a(c1162a3, m1839a.m1776d(), m1776d, m1772a.m1782c());
        C1095f c1095f = new C1095f();
        c1095f.m1885a(enumC1079f);
        c1095f.m1886a(m1838a);
        c1095f.m1887a(m1839a);
        int m1775c = m1839a.m1775c();
        C1091b c1091b = new C1091b(m1775c, m1775c);
        int m1836a = m1836a(m1842a, enumC1079f, m1839a, c1091b);
        c1095f.m1884a(m1836a);
        C1094e.m1872a(m1842a, enumC1079f, m1839a, m1836a, c1091b);
        c1095f.m1888a(c1091b);
        return c1095f;
    }

    /* renamed from: a */
    static int m1834a(int i2) {
        int[] iArr = f2176a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    /* renamed from: a */
    public static EnumC1081h m1837a(String str) {
        return m1838a(str, (String) null);
    }

    /* renamed from: a */
    private static EnumC1081h m1838a(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return m1854b(str) ? EnumC1081h.KANJI : EnumC1081h.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else {
                if (m1834a(charAt) == -1) {
                    return EnumC1081h.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return EnumC1081h.ALPHANUMERIC;
        }
        if (z2) {
            return EnumC1081h.NUMERIC;
        }
        return EnumC1081h.BYTE;
    }

    /* renamed from: a */
    private static int m1836a(C1162a c1162a, EnumC1079f enumC1079f, C1083j c1083j, C1091b c1091b) throws C1112w {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            C1094e.m1872a(c1162a, enumC1079f, c1083j, i4, c1091b);
            int m1835a = m1835a(c1091b);
            if (m1835a < i2) {
                i3 = i4;
                i2 = m1835a;
            }
        }
        return i3;
    }

    /* renamed from: a */
    private static C1083j m1839a(int i2, EnumC1079f enumC1079f) throws C1112w {
        for (int i3 = 1; i3 <= 40; i3++) {
            C1083j m1770c = C1083j.m1770c(i3);
            if (m1770c.m1776d() - m1770c.m1772a(enumC1079f).m1783d() >= (i2 + 7) / 8) {
                return m1770c;
            }
        }
        throw new C1112w("Data too big");
    }

    /* renamed from: a */
    static void m1845a(int i2, C1162a c1162a) throws C1112w {
        int i3 = i2 * 8;
        if (c1162a.m2157c() <= i3) {
            for (int i4 = 0; i4 < 4 && c1162a.m2157c() < i3; i4++) {
                c1162a.m2151a(false);
            }
            int m2157c = c1162a.m2157c() & 7;
            if (m2157c > 0) {
                while (m2157c < 8) {
                    c1162a.m2151a(false);
                    m2157c++;
                }
            }
            int m2160d = i2 - c1162a.m2160d();
            for (int i5 = 0; i5 < m2160d; i5++) {
                c1162a.m2148a((i5 & 1) == 0 ? 236 : 17, 8);
            }
            if (c1162a.m2157c() != i3) {
                throw new C1112w("Bits size does not equal capacity");
            }
            return;
        }
        throw new C1112w("data bits cannot fit in the QR Code" + c1162a.m2157c() + " > " + i3);
    }

    /* renamed from: a */
    static void m1843a(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws C1112w {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new C1112w("EC bytes mismatch");
            }
            if (i4 != i7 + i6) {
                throw new C1112w("RS blocks mismatch");
            }
            if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new C1112w("Total bytes mismatch");
            }
            if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            } else {
                iArr[0] = i11;
                iArr2[0] = i13;
                return;
            }
        }
        throw new C1112w("Block ID too large");
    }

    /* renamed from: a */
    static C1162a m1842a(C1162a c1162a, int i2, int i3, int i4) throws C1112w {
        if (c1162a.m2160d() == i3) {
            ArrayList arrayList = new ArrayList(i4);
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                m1843a(i2, i3, i4, i8, iArr, iArr2);
                int i9 = iArr[0];
                byte[] bArr = new byte[i9];
                c1162a.m2149a(i5 * 8, bArr, 0, i9);
                byte[] m1852a = m1852a(bArr, iArr2[0]);
                arrayList.add(new C1090a(bArr, m1852a));
                i6 = Math.max(i6, i9);
                i7 = Math.max(i7, m1852a.length);
                i5 += iArr[0];
            }
            if (i3 == i5) {
                C1162a c1162a2 = new C1162a();
                for (int i10 = 0; i10 < i6; i10++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] m1824a = ((C1090a) it.next()).m1824a();
                        if (i10 < m1824a.length) {
                            c1162a2.m2148a(m1824a[i10], 8);
                        }
                    }
                }
                for (int i11 = 0; i11 < i7; i11++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] m1825b = ((C1090a) it2.next()).m1825b();
                        if (i11 < m1825b.length) {
                            c1162a2.m2148a(m1825b[i11], 8);
                        }
                    }
                }
                if (i2 == c1162a2.m2160d()) {
                    return c1162a2;
                }
                throw new C1112w("Interleaving error: " + i2 + " and " + c1162a2.m2160d() + " differ.");
            }
            throw new C1112w("Data bytes does not match offset");
        }
        throw new C1112w("Number of bits and data bytes does not match");
    }

    /* renamed from: a */
    static byte[] m1852a(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & C5230f1.f20085c;
        }
        new C1180d(C1177a.f2453l).m2256a(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    /* renamed from: a */
    static void m1846a(EnumC1081h enumC1081h, C1162a c1162a) {
        c1162a.m2148a(enumC1081h.getBits(), 4);
    }

    /* renamed from: a */
    static void m1844a(int i2, C1083j c1083j, EnumC1081h enumC1081h, C1162a c1162a) throws C1112w {
        int characterCountBits = enumC1081h.getCharacterCountBits(c1083j);
        int i3 = 1 << characterCountBits;
        if (i2 < i3) {
            c1162a.m2148a(i2, characterCountBits);
            return;
        }
        throw new C1112w(i2 + " is bigger than " + (i3 - 1));
    }

    /* renamed from: a */
    static void m1849a(String str, EnumC1081h enumC1081h, C1162a c1162a, String str2) throws C1112w {
        int i2 = a.f2178a[enumC1081h.ordinal()];
        if (i2 == 1) {
            m1853b(str, c1162a);
            return;
        }
        if (i2 == 2) {
            m1848a((CharSequence) str, c1162a);
            return;
        }
        if (i2 == 3) {
            m1851a(str, c1162a, str2);
        } else {
            if (i2 == 4) {
                m1850a(str, c1162a);
                return;
            }
            throw new C1112w("Invalid mode: " + enumC1081h);
        }
    }

    /* renamed from: a */
    static void m1848a(CharSequence charSequence, C1162a c1162a) throws C1112w {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int m1834a = m1834a(charSequence.charAt(i2));
            if (m1834a == -1) {
                throw new C1112w();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int m1834a2 = m1834a(charSequence.charAt(i3));
                if (m1834a2 != -1) {
                    c1162a.m2148a((m1834a * 45) + m1834a2, 11);
                    i2 += 2;
                } else {
                    throw new C1112w();
                }
            } else {
                c1162a.m2148a(m1834a, 6);
                i2 = i3;
            }
        }
    }

    /* renamed from: a */
    static void m1851a(String str, C1162a c1162a, String str2) throws C1112w {
        try {
            for (byte b2 : str.getBytes(str2)) {
                c1162a.m2148a(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new C1112w(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void m1850a(java.lang.String r6, p031c.p035b.p043c.p072z.C1162a r7) throws p031c.p035b.p043c.C1112w {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.m2148a(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            c.b.c.w r6 = new c.b.c.w
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            c.b.c.w r7 = new c.b.c.w
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p062f0.p065e.C1092c.m1850a(java.lang.String, c.b.c.z.a):void");
    }

    /* renamed from: a */
    private static void m1847a(EnumC1165d enumC1165d, C1162a c1162a) {
        c1162a.m2148a(EnumC1081h.ECI.getBits(), 4);
        c1162a.m2148a(enumC1165d.getValue(), 8);
    }
}
