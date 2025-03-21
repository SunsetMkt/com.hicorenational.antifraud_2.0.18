package com.heytap.msp.push.encrypt;

import com.heytap.mcssdk.p160k.C2107g;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class AESEncrypt {
    private static final String ALGORITHM = "AES";
    private static final String IV_CONNECT = "%IV1%";
    private static final int KEY_BYTE_SIZE = 256;
    public static final String SDK_APP_SECRET = "isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=";
    private static final String TRANSFORMATION = "AES/CTR/NoPadding";

    public static String decrypt(String str, String str2) {
        String[] split = str2.split(IV_CONNECT);
        byte[] m5923b = C2110a.m5923b(split[0]);
        byte[] m5923b2 = C2110a.m5923b(split[1]);
        SecretKeySpec secretKeySpec = new SecretKeySpec(C2110a.m5923b(str), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeySpec, new IvParameterSpec(m5923b2));
        return new String(cipher.doFinal(m5923b));
    }

    public static String encrypt(String str) {
        try {
            return encrypt(SDK_APP_SECRET, str);
        } catch (Exception e2) {
            C2107g.m5884b(e2.getLocalizedMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(C2110a.m5923b(str), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKeySpec);
        String m5926d = C2110a.m5926d(cipher.getIV());
        return C2110a.m5926d(cipher.doFinal(str2.getBytes())) + IV_CONNECT + m5926d;
    }

    public static String genKey() {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(256);
        return C2110a.m5926d(keyGenerator.generateKey().getEncoded());
    }
}
