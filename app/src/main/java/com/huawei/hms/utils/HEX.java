package com.huawei.hms.utils;

import com.umeng.analytics.pro.C3393cw;

/* loaded from: classes.dex */
public final class HEX {

    /* renamed from: a */
    private static final char[] f7934a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final char[] f7935b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private HEX() {
    }

    /* renamed from: a */
    private static char[] m7735a(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return new char[0];
        }
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            cArr2[i2] = cArr[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr2[i4] = cArr[bArr[i3] & C3393cw.f11873m];
        }
        return cArr2;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z) {
        return new String(encodeHex(bArr, z));
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return m7735a(bArr, z ? f7935b : f7934a);
    }
}
