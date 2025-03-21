package com.huawei.agconnect.config.impl;

import com.umeng.analytics.pro.C3393cw;

/* loaded from: classes.dex */
public class Hex {
    private static final char[] HEX_CODE = "0123456789ABCDEF".toCharArray();

    private static byte[] decodeHex(char[] cArr) {
        if ((cArr.length & 1) != 0) {
            throw new IllegalArgumentException("Odd number of characters.");
        }
        byte[] bArr = new byte[cArr.length >> 1];
        int i2 = 0;
        int i3 = 0;
        while (i2 < cArr.length) {
            int digit = Character.digit(cArr[i2], 16);
            if (digit == -1) {
                throw new IllegalArgumentException("Illegal hexadecimal character at index " + i2);
            }
            int i4 = i2 + 1;
            int digit2 = Character.digit(cArr[i4], 16);
            if (digit2 == -1) {
                throw new IllegalArgumentException("Illegal hexadecimal character at index " + i4);
            }
            i2 = i4 + 1;
            bArr[i3] = (byte) (((digit << 4) | digit2) & 255);
            i3++;
        }
        return bArr;
    }

    public static byte[] decodeHexString(String str) {
        return decodeHex(str.toCharArray());
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(HEX_CODE[(b2 >> 4) & 15]);
            sb.append(HEX_CODE[b2 & C3393cw.f11873m]);
        }
        return sb.toString();
    }
}
