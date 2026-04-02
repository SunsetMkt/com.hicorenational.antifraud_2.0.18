package d.b.c.e0.g;

import com.umeng.analytics.pro.cw;
import d.b.c.w;
import i.f1;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: compiled from: PDF417HighLevelEncoder.java */
/* JADX INFO: loaded from: classes.dex */
final class g {
    private static final int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f9765b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9766c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9767d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9768e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9769f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9770g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9771h = 900;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9772i = 901;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f9773j = 902;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f9774k = 913;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9775l = 924;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9776m = 925;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f9777n = 926;
    private static final int o = 927;
    private static final byte[] p = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, cw.f7203k, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] q = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, cw.f7203k, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};
    private static final byte[] r = new byte[128];
    private static final byte[] s = new byte[128];
    private static final Charset t = Charset.forName(j.a.a.a.c.a);

    static {
        Arrays.fill(r, (byte) -1);
        byte b2 = 0;
        byte b3 = 0;
        while (true) {
            byte[] bArr = p;
            if (b3 >= bArr.length) {
                break;
            }
            byte b4 = bArr[b3];
            if (b4 > 0) {
                r[b4] = b3;
            }
            b3 = (byte) (b3 + 1);
        }
        Arrays.fill(s, (byte) -1);
        while (true) {
            byte[] bArr2 = q;
            if (b2 >= bArr2.length) {
                return;
            }
            byte b5 = bArr2[b2];
            if (b5 > 0) {
                s[b5] = b2;
            }
            b2 = (byte) (b2 + 1);
        }
    }

    private g() {
    }

    static String a(String str, c cVar, Charset charset) throws w {
        d.b.c.z.d characterSetECIByName;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = t;
        } else if (!t.equals(charset) && (characterSetECIByName = d.b.c.z.d.getCharacterSetECIByName(charset.name())) != null) {
            a(characterSetECIByName.getValue(), sb);
        }
        int length = str.length();
        if (cVar == c.TEXT) {
            a(str, 0, length, sb, 0);
        } else if (cVar == c.BYTE) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, 0, bytes.length, 1, sb);
        } else if (cVar == c.NUMERIC) {
            sb.append('\u0386');
            a(str, 0, length, sb);
        } else {
            int i2 = 0;
            int iA = 0;
            int i3 = 0;
            while (i2 < length) {
                int iA2 = a(str, i2);
                if (iA2 >= 13) {
                    sb.append('\u0386');
                    a(str, i2, iA2, sb);
                    i2 += iA2;
                    iA = 0;
                    i3 = 2;
                } else {
                    int iB = b(str, i2);
                    if (iB >= 5 || iA2 == length) {
                        if (i3 != 0) {
                            sb.append('\u0384');
                            iA = 0;
                            i3 = 0;
                        }
                        iA = a(str, i2, iB, sb, iA);
                        i2 += iB;
                    } else {
                        int iA3 = a(str, i2, charset);
                        if (iA3 == 0) {
                            iA3 = 1;
                        }
                        int i4 = iA3 + i2;
                        byte[] bytes2 = str.substring(i2, i4).getBytes(charset);
                        if (bytes2.length == 1 && i3 == 0) {
                            a(bytes2, 0, 1, 0, sb);
                        } else {
                            a(bytes2, 0, bytes2.length, i3, sb);
                            iA = 0;
                            i3 = 1;
                        }
                        i2 = i4;
                    }
                }
            }
        }
        return sb.toString();
    }

    private static boolean a(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    private static int b(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = i2;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && c(cCharAt) && i3 < length) {
                i4++;
                i3++;
                if (i3 < length) {
                    cCharAt = charSequence.charAt(i3);
                }
            }
            if (i4 >= 13) {
                return (i3 - i2) - i4;
            }
            if (i4 <= 0) {
                if (!f(charSequence.charAt(i3))) {
                    break;
                }
                i3++;
            }
        }
        return i3 - i2;
    }

    private static boolean b(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean c(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean d(char c2) {
        return r[c2] != -1;
    }

    private static boolean e(char c2) {
        return s[c2] != -1;
    }

    private static boolean f(char c2) {
        return c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= '~');
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00f6 A[EDGE_INSN: B:76:0x00f6->B:55:0x00f6 BREAK  A[LOOP:0: B:3:0x0011->B:93:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0011 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(CharSequence charSequence, int i2, int i3, StringBuilder sb, int i4) {
        StringBuilder sb2 = new StringBuilder(i3);
        int i5 = i4;
        int i6 = 0;
        while (true) {
            int i7 = i2 + i6;
            char cCharAt = charSequence.charAt(i7);
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (e(cCharAt)) {
                            sb2.append((char) s[cCharAt]);
                        } else {
                            sb2.append((char) 29);
                            i5 = 0;
                        }
                    } else if (d(cCharAt)) {
                        sb2.append((char) r[cCharAt]);
                    } else if (b(cCharAt)) {
                        sb2.append((char) 28);
                        i5 = 0;
                    } else if (a(cCharAt)) {
                        sb2.append((char) 27);
                        i5 = 1;
                    } else {
                        int i8 = i7 + 1;
                        if (i8 < i3 && e(charSequence.charAt(i8))) {
                            i5 = 3;
                            sb2.append((char) 25);
                        } else {
                            sb2.append((char) 29);
                            sb2.append((char) s[cCharAt]);
                        }
                    }
                } else if (a(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'a'));
                    }
                } else if (b(cCharAt)) {
                    sb2.append((char) 27);
                    sb2.append((char) (cCharAt - 'A'));
                } else if (d(cCharAt)) {
                    sb2.append((char) 28);
                    i5 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) s[cCharAt]);
                }
                i6++;
                if (i6 < i3) {
                    break;
                }
            } else {
                if (b(cCharAt)) {
                    if (cCharAt == ' ') {
                        sb2.append((char) 26);
                    } else {
                        sb2.append((char) (cCharAt - 'A'));
                    }
                } else if (a(cCharAt)) {
                    sb2.append((char) 27);
                    i5 = 1;
                } else if (d(cCharAt)) {
                    sb2.append((char) 28);
                    i5 = 2;
                } else {
                    sb2.append((char) 29);
                    sb2.append((char) s[cCharAt]);
                }
                i6++;
                if (i6 < i3) {
                }
            }
        }
        int length = sb2.length();
        char cCharAt2 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            if (i9 % 2 != 0) {
                cCharAt2 = (char) ((cCharAt2 * 30) + sb2.charAt(i9));
                sb.append(cCharAt2);
            } else {
                cCharAt2 = sb2.charAt(i9);
            }
        }
        if (length % 2 != 0) {
            sb.append((char) ((cCharAt2 * 30) + 29));
        }
        return i5;
    }

    private static void a(byte[] bArr, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        if (i3 == 1 && i4 == 0) {
            sb.append('\u0391');
        } else if (i3 % 6 == 0) {
            sb.append('\u039c');
        } else {
            sb.append('\u0385');
        }
        if (i3 >= 6) {
            char[] cArr = new char[5];
            i5 = i2;
            while ((i2 + i3) - i5 >= 6) {
                long j2 = 0;
                for (int i6 = 0; i6 < 6; i6++) {
                    j2 = (j2 << 8) + ((long) (bArr[i5 + i6] & f1.f12066c));
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
            sb.append((char) (bArr[i5] & f1.f12066c));
            i5++;
        }
    }

    private static void a(String str, int i2, int i3, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i4 = 0;
        while (i4 < i3) {
            sb2.setLength(0);
            int iMin = Math.min(44, i3 - i4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append('1');
            int i5 = i2 + i4;
            sb3.append(str.substring(i5, i5 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += iMin;
        }
    }

    private static int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            while (c(cCharAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    cCharAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    private static int a(String str, int i2, Charset charset) throws w {
        int i3;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i4 = i2;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            int i5 = 0;
            while (i5 < 13 && c(cCharAt) && (i3 = i4 + (i5 = i5 + 1)) < length) {
                cCharAt = str.charAt(i3);
            }
            if (i5 >= 13) {
                return i4 - i2;
            }
            char cCharAt2 = str.charAt(i4);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new w("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i4++;
        }
        return i4 - i2;
    }

    private static void a(int i2, StringBuilder sb) throws w {
        if (i2 >= 0 && i2 < f9771h) {
            sb.append('\u039f');
            sb.append((char) i2);
            return;
        }
        if (i2 < 810900) {
            sb.append('\u039e');
            sb.append((char) ((i2 / f9771h) - 1));
            sb.append((char) (i2 % f9771h));
        } else if (i2 < 811800) {
            sb.append('\u039d');
            sb.append((char) (810900 - i2));
        } else {
            throw new w("ECI number not in valid range from 0..811799, but was " + i2);
        }
    }
}
