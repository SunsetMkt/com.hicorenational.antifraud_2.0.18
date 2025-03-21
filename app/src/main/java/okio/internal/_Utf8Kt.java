package okio.internal;

import h.q2.t.i0;
import h.y;
import i.c.a.d;
import java.util.Arrays;
import okio.Utf8;

/* compiled from: -Utf8.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class _Utf8Kt {
    @d
    public static final byte[] commonAsUtf8ToByteArray(@d String str) {
        int i2;
        int i3;
        char charAt;
        i0.f(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt2 = str.charAt(i4);
            if (charAt2 >= 128) {
                int length2 = str.length();
                int i5 = i4;
                while (i4 < length2) {
                    char charAt3 = str.charAt(i4);
                    if (charAt3 < 128) {
                        int i6 = i5 + 1;
                        bArr[i5] = (byte) charAt3;
                        i4++;
                        while (i4 < length2 && str.charAt(i4) < 128) {
                            bArr[i6] = (byte) str.charAt(i4);
                            i4++;
                            i6++;
                        }
                        i5 = i6;
                    } else {
                        if (charAt3 < 2048) {
                            int i7 = i5 + 1;
                            bArr[i5] = (byte) ((charAt3 >> 6) | 192);
                            byte b2 = (byte) ((charAt3 & '?') | 128);
                            i2 = i7 + 1;
                            bArr[i7] = b2;
                        } else if (55296 > charAt3 || 57343 < charAt3) {
                            int i8 = i5 + 1;
                            bArr[i5] = (byte) ((charAt3 >> '\f') | 224);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((charAt3 >> 6) & 63) | 128);
                            byte b3 = (byte) ((charAt3 & '?') | 128);
                            i2 = i9 + 1;
                            bArr[i9] = b3;
                        } else if (charAt3 > 56319 || length2 <= (i3 = i4 + 1) || 56320 > (charAt = str.charAt(i3)) || 57343 < charAt) {
                            i2 = i5 + 1;
                            bArr[i5] = Utf8.REPLACEMENT_BYTE;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + str.charAt(i3)) - 56613888;
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((charAt4 >> 18) | 240);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((charAt4 >> 12) & 63) | 128);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((charAt4 >> 6) & 63) | 128);
                            byte b4 = (byte) ((charAt4 & 63) | 128);
                            i2 = i12 + 1;
                            bArr[i12] = b4;
                            i4 += 2;
                            i5 = i2;
                        }
                        i4++;
                        i5 = i2;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i5);
                i0.a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i4] = (byte) charAt2;
            i4++;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        i0.a((Object) copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x010f, code lost:
    
        if (((r17[r5] & 192) == 128) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0097, code lost:
    
        if (((r17[r5] & 192) == 128) == false) goto L22;
     */
    @i.c.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String commonToUtf8String(@i.c.a.d byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
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
