package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.cw;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f6526b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final byte[] a = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f6526b;
            cArr[i3 + 1] = cArr2[b2 & cw.f7205m];
            cArr[i3 + 0] = cArr2[((byte) (b2 >>> 4)) & cw.f7205m];
        }
        return new String(cArr);
    }
}
