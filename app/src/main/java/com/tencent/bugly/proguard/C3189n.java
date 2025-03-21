package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.n */
/* loaded from: classes2.dex */
public final class C3189n {

    /* renamed from: a */
    private static final byte[] f10763a;

    /* renamed from: b */
    private static final byte[] f10764b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = bArr[i2 >>> 4];
            bArr3[i2] = bArr[i2 & 15];
        }
        f10763a = bArr2;
        f10764b = bArr3;
    }

    /* renamed from: a */
    public static boolean m10120a(byte b2, byte b3) {
        return b2 == b3;
    }

    /* renamed from: a */
    public static boolean m10121a(int i2, int i3) {
        return i2 == i3;
    }

    /* renamed from: a */
    public static boolean m10122a(long j2, long j3) {
        return j2 == j3;
    }

    /* renamed from: a */
    public static boolean m10123a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static boolean m10124a(boolean z, boolean z2) {
        return z == z2;
    }

    /* renamed from: a */
    public static byte[] m10125a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        return bArr;
    }
}
