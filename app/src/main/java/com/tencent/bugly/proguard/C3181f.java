package com.tencent.bugly.proguard;

import com.umeng.analytics.pro.C3393cw;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.f */
/* loaded from: classes2.dex */
public class C3181f {

    /* renamed from: b */
    private static final char[] f10741b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static final byte[] f10740a = new byte[0];

    /* renamed from: a */
    public static String m10041a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f10741b;
            cArr[i3 + 1] = cArr2[b2 & C3393cw.f11873m];
            cArr[i3 + 0] = cArr2[((byte) (b2 >>> 4)) & C3393cw.f11873m];
        }
        return new String(cArr);
    }
}
