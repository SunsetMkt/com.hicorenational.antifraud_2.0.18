package com.umeng.p221ut.p226b.p227a.p228a;

/* renamed from: com.umeng.ut.b.a.a.b */
/* loaded from: classes2.dex */
public class C3812b {
    public static byte[] getBytes(int i2) {
        byte[] bArr = {(byte) ((r3 >> 8) % 256), (byte) (r3 % 256), (byte) (r3 % 256), (byte) (i2 % 256)};
        int i3 = i2 >> 8;
        int i4 = i3 >> 8;
        return bArr;
    }
}
