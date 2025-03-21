package p031c.p035b.p043c.p062f0.p063c;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1164c;
import p031c.p035b.p043c.p072z.C1173l;
import p031c.p035b.p043c.p072z.EnumC1165d;
import p286h.p323z2.C5736h0;

/* compiled from: DecodedBitStreamParser.java */
/* renamed from: c.b.c.f0.c.d */
/* loaded from: classes.dex */
final class C1077d {

    /* renamed from: a */
    private static final char[] f2120a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', C5736h0.f20713b, '%', '*', '+', '-', '.', '/', ':'};

    /* renamed from: b */
    private static final int f2121b = 1;

    private C1077d() {
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8 A[LOOP:0: B:2:0x001e->B:47:0x00e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static p031c.p035b.p043c.p072z.C1166e m1749a(byte[] r17, p031c.p035b.p043c.p062f0.p063c.C1083j r18, p031c.p035b.p043c.p062f0.p063c.EnumC1079f r19, java.util.Map<p031c.p035b.p043c.EnumC1044e, ?> r20) throws p031c.p035b.p043c.C1097h {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p062f0.p063c.C1077d.m1749a(byte[], c.b.c.f0.c.j, c.b.c.f0.c.f, java.util.Map):c.b.c.z.e");
    }

    /* renamed from: b */
    private static void m1753b(C1164c c1164c, StringBuilder sb, int i2) throws C1097h {
        if (i2 * 13 > c1164c.m2183a()) {
            throw C1097h.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int m2184a = c1164c.m2184a(13);
            int i4 = (m2184a % 192) | ((m2184a / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, C1173l.f2432b));
        } catch (UnsupportedEncodingException unused) {
            throw C1097h.getFormatInstance();
        }
    }

    /* renamed from: c */
    private static void m1754c(C1164c c1164c, StringBuilder sb, int i2) throws C1097h {
        while (i2 >= 3) {
            if (c1164c.m2183a() < 10) {
                throw C1097h.getFormatInstance();
            }
            int m2184a = c1164c.m2184a(10);
            if (m2184a >= 1000) {
                throw C1097h.getFormatInstance();
            }
            sb.append(m1747a(m2184a / 100));
            sb.append(m1747a((m2184a / 10) % 10));
            sb.append(m1747a(m2184a % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (c1164c.m2183a() < 7) {
                throw C1097h.getFormatInstance();
            }
            int m2184a2 = c1164c.m2184a(7);
            if (m2184a2 >= 100) {
                throw C1097h.getFormatInstance();
            }
            sb.append(m1747a(m2184a2 / 10));
            sb.append(m1747a(m2184a2 % 10));
            return;
        }
        if (i2 == 1) {
            if (c1164c.m2183a() < 4) {
                throw C1097h.getFormatInstance();
            }
            int m2184a3 = c1164c.m2184a(4);
            if (m2184a3 >= 10) {
                throw C1097h.getFormatInstance();
            }
            sb.append(m1747a(m2184a3));
        }
    }

    /* renamed from: a */
    private static void m1750a(C1164c c1164c, StringBuilder sb, int i2) throws C1097h {
        if (i2 * 13 <= c1164c.m2183a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int m2184a = c1164c.m2184a(13);
                int i4 = (m2184a % 96) | ((m2184a / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) ((i5 >> 8) & 255);
                bArr[i3 + 1] = (byte) (i5 & 255);
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, C1173l.f2433c));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw C1097h.getFormatInstance();
            }
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: a */
    private static void m1751a(C1164c c1164c, StringBuilder sb, int i2, EnumC1165d enumC1165d, Collection<byte[]> collection, Map<EnumC1044e, ?> map) throws C1097h {
        String name;
        if (i2 * 8 <= c1164c.m2183a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) c1164c.m2184a(8);
            }
            if (enumC1165d == null) {
                name = C1173l.m2220a(bArr, map);
            } else {
                name = enumC1165d.name();
            }
            try {
                sb.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw C1097h.getFormatInstance();
            }
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: a */
    private static char m1747a(int i2) throws C1097h {
        char[] cArr = f2120a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw C1097h.getFormatInstance();
    }

    /* renamed from: a */
    private static void m1752a(C1164c c1164c, StringBuilder sb, int i2, boolean z) throws C1097h {
        while (i2 > 1) {
            if (c1164c.m2183a() >= 11) {
                int m2184a = c1164c.m2184a(11);
                sb.append(m1747a(m2184a / 45));
                sb.append(m1747a(m2184a % 45));
                i2 -= 2;
            } else {
                throw C1097h.getFormatInstance();
            }
        }
        if (i2 == 1) {
            if (c1164c.m2183a() >= 6) {
                sb.append(m1747a(c1164c.m2184a(6)));
            } else {
                throw C1097h.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    /* renamed from: a */
    private static int m1748a(C1164c c1164c) throws C1097h {
        int m2184a = c1164c.m2184a(8);
        if ((m2184a & 128) == 0) {
            return m2184a & 127;
        }
        if ((m2184a & 192) == 128) {
            return c1164c.m2184a(8) | ((m2184a & 63) << 8);
        }
        if ((m2184a & 224) == 192) {
            return c1164c.m2184a(16) | ((m2184a & 31) << 16);
        }
        throw C1097h.getFormatInstance();
    }
}
