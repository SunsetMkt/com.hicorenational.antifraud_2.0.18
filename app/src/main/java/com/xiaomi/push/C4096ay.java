package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import p286h.C5230f1;

/* renamed from: com.xiaomi.push.ay */
/* loaded from: classes2.dex */
public class C4096ay {

    /* renamed from: a */
    private static byte[] f14591a;

    /* renamed from: a */
    private static final String f14590a = System.getProperty("line.separator");

    /* renamed from: a */
    private static char[] f14592a = new char[64];

    static {
        char c2 = 'A';
        int i2 = 0;
        while (c2 <= 'Z') {
            f14592a[i2] = c2;
            c2 = (char) (c2 + 1);
            i2++;
        }
        char c3 = 'a';
        while (c3 <= 'z') {
            f14592a[i2] = c3;
            c3 = (char) (c3 + 1);
            i2++;
        }
        char c4 = '0';
        while (c4 <= '9') {
            f14592a[i2] = c4;
            c4 = (char) (c4 + 1);
            i2++;
        }
        char[] cArr = f14592a;
        cArr[i2] = '+';
        cArr[i2 + 1] = '/';
        f14591a = new byte[128];
        int i3 = 0;
        while (true) {
            byte[] bArr = f14591a;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = -1;
            i3++;
        }
        for (int i4 = 0; i4 < 64; i4++) {
            f14591a[f14592a[i4]] = (byte) i4;
        }
    }

    /* renamed from: a */
    public static String m13839a(String str) {
        return new String(m13843a(str.getBytes()));
    }

    /* renamed from: b */
    public static String m13845b(String str) {
        return new String(m13840a(str));
    }

    /* renamed from: a */
    public static char[] m13843a(byte[] bArr) {
        return m13844a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static char[] m13844a(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = ((i3 * 4) + 2) / 3;
        char[] cArr = new char[((i3 + 2) / 3) * 4];
        int i9 = i3 + i2;
        int i10 = 0;
        while (i2 < i9) {
            int i11 = i2 + 1;
            int i12 = bArr[i2] & C5230f1.f20085c;
            if (i11 < i9) {
                i4 = i11 + 1;
                i5 = bArr[i11] & C5230f1.f20085c;
            } else {
                i4 = i11;
                i5 = 0;
            }
            if (i4 < i9) {
                i6 = i4 + 1;
                i7 = bArr[i4] & C5230f1.f20085c;
            } else {
                i6 = i4;
                i7 = 0;
            }
            int i13 = i12 >>> 2;
            int i14 = ((i12 & 3) << 4) | (i5 >>> 4);
            int i15 = ((i5 & 15) << 2) | (i7 >>> 6);
            int i16 = i7 & 63;
            int i17 = i10 + 1;
            char[] cArr2 = f14592a;
            cArr[i10] = cArr2[i13];
            int i18 = i17 + 1;
            cArr[i17] = cArr2[i14];
            char c2 = '=';
            cArr[i18] = i18 < i8 ? cArr2[i15] : '=';
            int i19 = i18 + 1;
            if (i19 < i8) {
                c2 = f14592a[i16];
            }
            cArr[i19] = c2;
            i10 = i19 + 1;
            i2 = i6;
        }
        return cArr;
    }

    /* renamed from: a */
    public static byte[] m13840a(String str) {
        return m13841a(str.toCharArray());
    }

    /* renamed from: a */
    public static byte[] m13841a(char[] cArr) {
        return m13842a(cArr, 0, cArr.length);
    }

    /* renamed from: a */
    public static byte[] m13842a(char[] cArr, int i2, int i3) {
        int i4;
        char c2;
        int i5;
        if (i3 % 4 == 0) {
            while (i3 > 0 && cArr[(i2 + i3) - 1] == '=') {
                i3--;
            }
            int i6 = (i3 * 3) / 4;
            byte[] bArr = new byte[i6];
            int i7 = i3 + i2;
            int i8 = 0;
            while (i2 < i7) {
                int i9 = i2 + 1;
                char c3 = cArr[i2];
                int i10 = i9 + 1;
                char c4 = cArr[i9];
                char c5 = 'A';
                if (i10 < i7) {
                    i4 = i10 + 1;
                    c2 = cArr[i10];
                } else {
                    i4 = i10;
                    c2 = 'A';
                }
                if (i4 < i7) {
                    int i11 = i4 + 1;
                    char c6 = cArr[i4];
                    i4 = i11;
                    c5 = c6;
                }
                if (c3 <= 127 && c4 <= 127 && c2 <= 127 && c5 <= 127) {
                    byte[] bArr2 = f14591a;
                    byte b2 = bArr2[c3];
                    byte b3 = bArr2[c4];
                    byte b4 = bArr2[c2];
                    byte b5 = bArr2[c5];
                    if (b2 >= 0 && b3 >= 0 && b4 >= 0 && b5 >= 0) {
                        int i12 = (b2 << 2) | (b3 >>> 4);
                        int i13 = ((b3 & C3393cw.f11873m) << 4) | (b4 >>> 2);
                        int i14 = ((b4 & 3) << 6) | b5;
                        int i15 = i8 + 1;
                        bArr[i8] = (byte) i12;
                        if (i15 < i6) {
                            i5 = i15 + 1;
                            bArr[i15] = (byte) i13;
                        } else {
                            i5 = i15;
                        }
                        if (i5 < i6) {
                            i8 = i5 + 1;
                            bArr[i5] = (byte) i14;
                        } else {
                            i8 = i5;
                        }
                        i2 = i4;
                    } else {
                        throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                    }
                } else {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }
}
