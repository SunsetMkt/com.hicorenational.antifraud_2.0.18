package p031c.p035b.p043c.p057e0.p061g;

import com.umeng.analytics.pro.C3393cw;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;
import p031c.p035b.p043c.C1112w;
import p031c.p035b.p043c.p072z.EnumC1165d;
import p286h.C5230f1;
import p324i.p325a.p326a.p327a.C5758c;

/* compiled from: PDF417HighLevelEncoder.java */
/* renamed from: c.b.c.e0.g.g */
/* loaded from: classes.dex */
final class C1070g {

    /* renamed from: a */
    private static final int f2088a = 0;

    /* renamed from: b */
    private static final int f2089b = 1;

    /* renamed from: c */
    private static final int f2090c = 2;

    /* renamed from: d */
    private static final int f2091d = 0;

    /* renamed from: e */
    private static final int f2092e = 1;

    /* renamed from: f */
    private static final int f2093f = 2;

    /* renamed from: g */
    private static final int f2094g = 3;

    /* renamed from: h */
    private static final int f2095h = 900;

    /* renamed from: i */
    private static final int f2096i = 901;

    /* renamed from: j */
    private static final int f2097j = 902;

    /* renamed from: k */
    private static final int f2098k = 913;

    /* renamed from: l */
    private static final int f2099l = 924;

    /* renamed from: m */
    private static final int f2100m = 925;

    /* renamed from: n */
    private static final int f2101n = 926;

    /* renamed from: o */
    private static final int f2102o = 927;

    /* renamed from: p */
    private static final byte[] f2103p = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, C3393cw.f11871k, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: q */
    private static final byte[] f2104q = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, C3393cw.f11871k, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};

    /* renamed from: r */
    private static final byte[] f2105r = new byte[128];

    /* renamed from: s */
    private static final byte[] f2106s = new byte[128];

    /* renamed from: t */
    private static final Charset f2107t = Charset.forName(C5758c.f20750a);

    static {
        Arrays.fill(f2105r, (byte) -1);
        byte b2 = 0;
        byte b3 = 0;
        while (true) {
            byte[] bArr = f2103p;
            if (b3 >= bArr.length) {
                break;
            }
            byte b4 = bArr[b3];
            if (b4 > 0) {
                f2105r[b4] = b3;
            }
            b3 = (byte) (b3 + 1);
        }
        Arrays.fill(f2106s, (byte) -1);
        while (true) {
            byte[] bArr2 = f2104q;
            if (b2 >= bArr2.length) {
                return;
            }
            byte b5 = bArr2[b2];
            if (b5 > 0) {
                f2106s[b5] = b2;
            }
            b2 = (byte) (b2 + 1);
        }
    }

    private C1070g() {
    }

    /* renamed from: a */
    static String m1717a(String str, EnumC1066c enumC1066c, Charset charset) throws C1112w {
        EnumC1165d characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f2107t;
        } else if (!f2107t.equals(charset) && (characterSetECIByName = EnumC1165d.getCharacterSetECIByName(charset.name())) != null) {
            m1718a(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        if (enumC1066c == EnumC1066c.TEXT) {
            m1715a(str, 0, length, sb, 0);
        } else if (enumC1066c == EnumC1066c.BYTE) {
            byte[] bytes = str.getBytes(charset);
            m1720a(bytes, 0, bytes.length, 1, sb);
        } else if (enumC1066c == EnumC1066c.NUMERIC) {
            sb.append((char) 902);
            m1719a(str, 0, length, sb);
        } else {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                int m1714a = m1714a(str, i2);
                if (m1714a >= 13) {
                    sb.append((char) 902);
                    m1719a(str, i2, m1714a, sb);
                    i2 += m1714a;
                    i3 = 0;
                    i4 = 2;
                } else {
                    int m1722b = m1722b(str, i2);
                    if (m1722b >= 5 || m1714a == length) {
                        if (i4 != 0) {
                            sb.append((char) 900);
                            i3 = 0;
                            i4 = 0;
                        }
                        i3 = m1715a(str, i2, m1722b, sb, i3);
                        i2 += m1722b;
                    } else {
                        int m1716a = m1716a(str, i2, charset);
                        if (m1716a == 0) {
                            m1716a = 1;
                        }
                        int i5 = m1716a + i2;
                        byte[] bytes2 = str.substring(i2, i5).getBytes(charset);
                        if (bytes2.length == 1 && i4 == 0) {
                            m1720a(bytes2, 0, 1, 0, sb);
                        } else {
                            m1720a(bytes2, 0, bytes2.length, i4, sb);
                            i3 = 0;
                            i4 = 1;
                        }
                        i2 = i5;
                    }
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static boolean m1721a(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0027, code lost:
    
        return (r1 - r7) - r3;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m1722b(java.lang.CharSequence r6, int r7) {
        /*
            int r0 = r6.length()
            r1 = r7
        L5:
            if (r1 >= r0) goto L39
            char r2 = r6.charAt(r1)
            r3 = 0
        Lc:
            r4 = 13
            if (r3 >= r4) goto L23
            boolean r5 = m1724c(r2)
            if (r5 == 0) goto L23
            if (r1 >= r0) goto L23
            int r3 = r3 + 1
            int r1 = r1 + 1
            if (r1 >= r0) goto Lc
            char r2 = r6.charAt(r1)
            goto Lc
        L23:
            if (r3 < r4) goto L28
            int r1 = r1 - r7
            int r1 = r1 - r3
            return r1
        L28:
            if (r3 <= 0) goto L2b
            goto L5
        L2b:
            char r2 = r6.charAt(r1)
            boolean r2 = m1727f(r2)
            if (r2 != 0) goto L36
            goto L39
        L36:
            int r1 = r1 + 1
            goto L5
        L39:
            int r1 = r1 - r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p057e0.p061g.C1070g.m1722b(java.lang.CharSequence, int):int");
    }

    /* renamed from: b */
    private static boolean m1723b(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    /* renamed from: c */
    private static boolean m1724c(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    /* renamed from: d */
    private static boolean m1725d(char c2) {
        return f2105r[c2] != -1;
    }

    /* renamed from: e */
    private static boolean m1726e(char c2) {
        return f2106s[c2] != -1;
    }

    /* renamed from: f */
    private static boolean m1727f(char c2) {
        return c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= '~');
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f6 A[EDGE_INSN: B:21:0x00f6->B:22:0x00f6 BREAK  A[LOOP:0: B:2:0x0011->B:16:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0011 A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m1715a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p057e0.p061g.C1070g.m1715a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    /* renamed from: a */
    private static void m1720a(byte[] bArr, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        if (i3 == 1 && i4 == 0) {
            sb.append((char) 913);
        } else if (i3 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        if (i3 >= 6) {
            char[] cArr = new char[5];
            i5 = i2;
            while ((i2 + i3) - i5 >= 6) {
                long j2 = 0;
                for (int i6 = 0; i6 < 6; i6++) {
                    j2 = (j2 << 8) + (bArr[i5 + i6] & C5230f1.f20085c);
                }
                for (int i7 = 0; i7 < 5; i7++) {
                    cArr[i7] = (char) (j2 % 900);
                    j2 /= 900;
                }
                for (int length = cArr.length - 1; length >= 0; length--) {
                    sb.append(cArr[length]);
                }
                i5 += 6;
            }
        } else {
            i5 = i2;
        }
        while (i5 < i2 + i3) {
            sb.append((char) (bArr[i5] & C5230f1.f20085c));
            i5++;
        }
    }

    /* renamed from: a */
    private static void m1719a(String str, int i2, int i3, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i4 = 0;
        while (i4 < i3) {
            sb2.setLength(0);
            int min = Math.min(44, i3 - i4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append('1');
            int i5 = i2 + i4;
            sb3.append(str.substring(i5, i5 + min));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += min;
        }
    }

    /* renamed from: a */
    private static int m1714a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char charAt = charSequence.charAt(i2);
            while (m1724c(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        return r1 - r6;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m1716a(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws p031c.p035b.p043c.C1112w {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L9:
            if (r1 >= r0) goto L5b
            char r2 = r5.charAt(r1)
            r3 = 0
        L10:
            r4 = 13
            if (r3 >= r4) goto L26
            boolean r2 = m1724c(r2)
            if (r2 == 0) goto L26
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 < r0) goto L21
            goto L26
        L21:
            char r2 = r5.charAt(r2)
            goto L10
        L26:
            if (r3 < r4) goto L2a
            int r1 = r1 - r6
            return r1
        L2a:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L37
            int r1 = r1 + 1
            goto L9
        L37:
            c.b.c.w r5 = new c.b.c.w
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Non-encodable character detected: "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            r6.append(r7)
            r6.append(r2)
            r7 = 41
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L5b:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p031c.p035b.p043c.p057e0.p061g.C1070g.m1716a(java.lang.String, int, java.nio.charset.Charset):int");
    }

    /* renamed from: a */
    private static void m1718a(int i2, StringBuilder sb) throws C1112w {
        if (i2 >= 0 && i2 < f2095h) {
            sb.append((char) 927);
            sb.append((char) i2);
            return;
        }
        if (i2 < 810900) {
            sb.append((char) 926);
            sb.append((char) ((i2 / f2095h) - 1));
            sb.append((char) (i2 % f2095h));
        } else if (i2 < 811800) {
            sb.append((char) 925);
            sb.append((char) (810900 - i2));
        } else {
            throw new C1112w("ECI number not in valid range from 0..811799, but was " + i2);
        }
    }
}
