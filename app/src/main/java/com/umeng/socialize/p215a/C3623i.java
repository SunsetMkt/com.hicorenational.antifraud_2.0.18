package com.umeng.socialize.p215a;

/* compiled from: UMCryptXor.java */
/* renamed from: com.umeng.socialize.a.i */
/* loaded from: classes2.dex */
public class C3623i {
    /* renamed from: a */
    public static byte[] m12539a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr[i2] = (byte) ((bArr[i2] ^ bArr2[i2 % bArr2.length]) ^ (i2 & 255));
            }
        }
        return bArr;
    }
}
