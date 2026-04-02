package okio.internal;

import i.q2.t.i0;
import i.q2.t.n;
import i.y;
import j.c.a.d;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: compiled from: -Utf8.kt */
/* JADX INFO: loaded from: classes2.dex */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a8\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 1, 16})
public final class _Utf8Kt {
    @d
    public static final byte[] commonAsUtf8ToByteArray(@d String str) {
        int i2;
        int i3;
        char cCharAt;
        i0.f(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 >= '\u0080') {
                int length2 = str.length();
                int i5 = i4;
                while (i4 < length2) {
                    char cCharAt3 = str.charAt(i4);
                    if (cCharAt3 < '\u0080') {
                        int i6 = i5 + 1;
                        bArr[i5] = (byte) cCharAt3;
                        i4++;
                        while (i4 < length2 && str.charAt(i4) < '\u0080') {
                            bArr[i6] = (byte) str.charAt(i4);
                            i4++;
                            i6++;
                        }
                        i5 = i6;
                    } else {
                        if (cCharAt3 < '\u0800') {
                            int i7 = i5 + 1;
                            bArr[i5] = (byte) ((cCharAt3 >> 6) | 192);
                            byte b2 = (byte) ((cCharAt3 & '?') | 128);
                            i2 = i7 + 1;
                            bArr[i7] = b2;
                        } else if ('\ud800' > cCharAt3 || '\udfff' < cCharAt3) {
                            int i8 = i5 + 1;
                            bArr[i5] = (byte) ((cCharAt3 >> '\f') | 224);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((cCharAt3 >> 6) & 63) | 128);
                            byte b3 = (byte) ((cCharAt3 & '?') | 128);
                            i2 = i9 + 1;
                            bArr[i9] = b3;
                        } else if (cCharAt3 > '\udbff' || length2 <= (i3 = i4 + 1) || '\udc00' > (cCharAt = str.charAt(i3)) || '\udfff' < cCharAt) {
                            i2 = i5 + 1;
                            bArr[i5] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int iCharAt = ((cCharAt3 << '\n') + str.charAt(i3)) - 56613888;
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((iCharAt >> 18) | 240);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((iCharAt >> 12) & 63) | 128);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((iCharAt >> 6) & 63) | 128);
                            byte b4 = (byte) ((iCharAt & 63) | 128);
                            i2 = i12 + 1;
                            bArr[i12] = b4;
                            i4 += 2;
                            i5 = i2;
                        }
                        i4++;
                        i5 = i2;
                    }
                }
                byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
                i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                return bArrCopyOf;
            }
            bArr[i4] = (byte) cCharAt2;
            i4++;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        i0.a((Object) bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    /* JADX WARN: Removed duplicated region for block: B:225:0x0111 A[PHI: r6
  0x0111: PHI (r6v42 int) = (r6v39 int), (r6v44 int), (r6v44 int) binds: [B:238:0x0138, B:219:0x0104, B:224:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0114 A[PHI: r6
  0x0114: PHI (r6v41 int) = (r6v40 int), (r6v44 int), (r6v44 int) binds: [B:232:0x0126, B:211:0x00f4, B:216:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    @d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String commonToUtf8String(@d byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = i2;
        i0.f(bArr, "$this$commonToUtf8String");
        if (i7 < 0 || i3 > bArr.length || i7 > i3) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr.length + " beginIndex=" + i7 + " endIndex=" + i3);
        }
        char[] cArr = new char[i3 - i7];
        int i8 = 0;
        while (i7 < i3) {
            byte b2 = bArr[i7];
            if (b2 >= 0) {
                i4 = i8 + 1;
                cArr[i8] = (char) b2;
                i7++;
                while (i7 < i3 && bArr[i7] >= 0) {
                    cArr[i4] = (char) bArr[i7];
                    i7++;
                    i4++;
                }
            } else {
                if ((b2 >> 5) == -2) {
                    int i9 = i7 + 1;
                    if (i3 <= i9) {
                        i4 = i8 + 1;
                        cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    } else {
                        byte b3 = bArr[i7];
                        byte b4 = bArr[i9];
                        if ((b4 & 192) == 128) {
                            int i10 = (b4 ^ n.a) ^ (b3 << 6);
                            if (i10 < 128) {
                                i4 = i8 + 1;
                                cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else {
                                i4 = i8 + 1;
                                cArr[i8] = (char) i10;
                            }
                            i5 = 2;
                        } else {
                            i4 = i8 + 1;
                            cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        }
                    }
                    i5 = 1;
                } else {
                    int i11 = 3;
                    if ((b2 >> 4) == -2) {
                        int i12 = i7 + 2;
                        if (i3 <= i12) {
                            i4 = i8 + 1;
                            cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            int i13 = i7 + 1;
                            if (i3 > i13) {
                                if ((bArr[i13] & 192) == 128) {
                                    i5 = 2;
                                }
                            }
                            i5 = 1;
                        } else {
                            byte b5 = bArr[i7];
                            byte b6 = bArr[i7 + 1];
                            if ((b6 & 192) == 128) {
                                byte b7 = bArr[i12];
                                if ((b7 & 192) == 128) {
                                    int i14 = ((b7 ^ n.a) ^ (b6 << 6)) ^ (b5 << 12);
                                    if (i14 < 2048) {
                                        i4 = i8 + 1;
                                        cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                    } else if (55296 <= i14 && 57343 >= i14) {
                                        i4 = i8 + 1;
                                        cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                    } else {
                                        i4 = i8 + 1;
                                        cArr[i8] = (char) i14;
                                    }
                                    i5 = 3;
                                } else {
                                    i4 = i8 + 1;
                                    cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                    i5 = 2;
                                }
                            } else {
                                i4 = i8 + 1;
                                cArr[i8] = (char) Utf8.REPLACEMENT_CODE_POINT;
                                i5 = 1;
                            }
                        }
                    } else {
                        if ((b2 >> 3) == -2) {
                            int i15 = i7 + 3;
                            if (i3 <= i15) {
                                i6 = i8 + 1;
                                cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                int i16 = i7 + 1;
                                if (i3 <= i16) {
                                    i11 = 1;
                                    i7 += i11;
                                } else {
                                    if ((bArr[i16] & 192) == 128) {
                                        int i17 = i7 + 2;
                                        if (i3 <= i17) {
                                            i11 = 2;
                                        } else {
                                            if (!((bArr[i17] & 192) == 128)) {
                                            }
                                        }
                                    }
                                    i7 += i11;
                                }
                            } else {
                                byte b8 = bArr[i7];
                                byte b9 = bArr[i7 + 1];
                                if ((b9 & 192) == 128) {
                                    byte b10 = bArr[i7 + 2];
                                    if ((b10 & 192) == 128) {
                                        byte b11 = bArr[i15];
                                        if ((b11 & 192) == 128) {
                                            int i18 = (((b11 ^ n.a) ^ (b10 << 6)) ^ (b9 << 12)) ^ (b8 << 18);
                                            if (i18 > 1114111) {
                                                i6 = i8 + 1;
                                                cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                            } else if ((55296 <= i18 && 57343 >= i18) || i18 < 65536 || i18 == 65533) {
                                                i6 = i8 + 1;
                                                cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                            } else {
                                                int i19 = i8 + 1;
                                                cArr[i8] = (char) ((i18 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                                char c2 = (char) ((i18 & 1023) + Utf8.LOG_SURROGATE_HEADER);
                                                i6 = i19 + 1;
                                                cArr[i19] = c2;
                                            }
                                            i11 = 4;
                                        } else {
                                            i6 = i8 + 1;
                                            cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                        }
                                        i7 += i11;
                                    } else {
                                        i6 = i8 + 1;
                                        cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                        i11 = 2;
                                        i7 += i11;
                                    }
                                } else {
                                    i6 = i8 + 1;
                                    cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                                    i11 = 1;
                                    i7 += i11;
                                }
                            }
                        } else {
                            i6 = i8 + 1;
                            cArr[i8] = Utf8.REPLACEMENT_CHARACTER;
                            i7++;
                        }
                        i8 = i6;
                    }
                }
                i7 += i5;
            }
            i8 = i4;
        }
        return new String(cArr, 0, i8);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        return commonToUtf8String(bArr, i2, i3);
    }
}
