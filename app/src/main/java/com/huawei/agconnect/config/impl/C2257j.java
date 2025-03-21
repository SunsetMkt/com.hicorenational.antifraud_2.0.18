package com.huawei.agconnect.config.impl;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.agconnect.config.impl.j */
/* loaded from: classes.dex */
public class C2257j {
    /* renamed from: a */
    public static SecretKey m6436a(C2251d c2251d) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (c2251d == null || !c2251d.m6420a()) {
            throw new IllegalArgumentException("invalid data for generating the key.");
        }
        String str = "build aes key, iterationCount:" + c2251d.m6426g();
        return new SecretKeySpec(SecretKeyFactory.getInstance(c2251d.m6425f()).generateSecret(new PBEKeySpec(Hex.encodeHexString(m6440a(Hex.decodeHexString(c2251d.m6421b()), Hex.decodeHexString(c2251d.m6422c()), Hex.decodeHexString(c2251d.m6423d()))).toCharArray(), Hex.decodeHexString(c2251d.m6424e()), c2251d.m6426g(), c2251d.m6427h() * 8)).getEncoded(), "AES");
    }

    /* renamed from: a */
    static byte[] m6437a(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException {
        if (secretKey == null || bArr == null) {
            throw new NullPointerException("key or cipherText must not be null.");
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 17);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKey, new IvParameterSpec(copyOfRange));
        return cipher.doFinal(bArr, copyOfRange.length + 1, (bArr.length - copyOfRange.length) - 1);
    }

    /* renamed from: a */
    private static byte[] m6438a(byte[] bArr, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes must not be null.");
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (i2 < 0) {
                bArr[i3] = (byte) (bArr[i3] << (-i2));
            } else {
                bArr[i3] = (byte) (bArr[i3] >> i2);
            }
        }
        return bArr;
    }

    /* renamed from: a */
    private static byte[] m6439a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("left or right must not be null.");
        }
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("left and right must be the same length.");
        }
        byte[] bArr3 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m6440a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m6439a(m6438a(m6439a(m6438a(bArr, -4), bArr2), 6), bArr3);
    }
}
