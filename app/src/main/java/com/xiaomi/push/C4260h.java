package com.xiaomi.push;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.xiaomi.push.h */
/* loaded from: classes2.dex */
public class C4260h {

    /* renamed from: a */
    private static final byte[] f15966a = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    /* renamed from: a */
    public static byte[] m15241a(byte[] bArr, byte[] bArr2) {
        return m15240a(bArr, 2).doFinal(bArr2);
    }

    /* renamed from: b */
    public static byte[] m15242b(byte[] bArr, byte[] bArr2) {
        return m15240a(bArr, 1).doFinal(bArr2);
    }

    /* renamed from: a */
    private static Cipher m15240a(byte[] bArr, int i2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f15966a);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i2, secretKeySpec, ivParameterSpec);
        return cipher;
    }
}
