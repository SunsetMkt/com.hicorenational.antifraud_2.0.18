package com.huawei.secure.android.common.encrypt.rsa;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

/* loaded from: classes.dex */
public abstract class RSAEncrypt {

    /* renamed from: a */
    private static final String f8084a = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: b */
    private static final String f8085b = "RSAEncrypt";

    /* renamed from: c */
    private static final String f8086c = "UTF-8";

    /* renamed from: d */
    private static final String f8087d = "";

    /* renamed from: e */
    private static final int f8088e = 2048;

    /* renamed from: f */
    private static final String f8089f = "RSA";

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return decrypt(str, EncryptUtil.getPrivateKey(str2));
        }
        C2551b.m7898b(f8085b, "content or private key is null");
        return "";
    }

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return encrypt(str, EncryptUtil.getPublicKey(str2));
        }
        C2551b.m7898b(f8085b, "content or public key is null");
        return "";
    }

    public static Map<String, Key> generateRSAKeyPair(int i2) throws NoSuchAlgorithmException {
        HashMap hashMap = new HashMap(2);
        if (i2 < 2048) {
            C2551b.m7898b(f8085b, "generateRSAKeyPair: key length is too short");
            return hashMap;
        }
        SecureRandom genSecureRandom = EncryptUtil.genSecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(f8089f);
        keyPairGenerator.initialize(i2, genSecureRandom);
        KeyPair generateKeyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        hashMap.put("publicKey", publicKey);
        hashMap.put("privateKey", privateKey);
        return hashMap;
    }

    public static boolean isPrivateKeyLengthRight(RSAPrivateKey rSAPrivateKey) {
        return rSAPrivateKey != null && rSAPrivateKey.getModulus().bitLength() >= 2048;
    }

    public static boolean isPublicKeyLengthRight(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 2048;
    }

    public static String decrypt(String str, PrivateKey privateKey) {
        if (!TextUtils.isEmpty(str) && privateKey != null && isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            try {
                return new String(decrypt(Base64.decode(str, 0), privateKey), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                C2551b.m7898b(f8085b, "RSA decrypt exception : " + e2.getMessage());
                return "";
            } catch (Exception e3) {
                C2551b.m7898b(f8085b, "exception : " + e3.getMessage());
                return "";
            }
        }
        C2551b.m7898b(f8085b, "content or privateKey is null , or length is too short");
        return "";
    }

    public static String encrypt(String str, PublicKey publicKey) {
        if (!TextUtils.isEmpty(str) && publicKey != null && isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                return Base64.encodeToString(encrypt(str.getBytes("UTF-8"), publicKey), 0);
            } catch (UnsupportedEncodingException unused) {
                C2551b.m7898b(f8085b, "encrypt: UnsupportedEncodingException");
                return "";
            } catch (Exception e2) {
                C2551b.m7898b(f8085b, "exception : " + e2.getMessage());
                return "";
            }
        }
        C2551b.m7898b(f8085b, "content or PublicKey is null , or length is too short");
        return "";
    }

    public static byte[] decrypt(byte[] bArr, PrivateKey privateKey) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && privateKey != null && isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            try {
                Cipher cipher = Cipher.getInstance(f8084a);
                cipher.init(2, privateKey);
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e2) {
                C2551b.m7898b(f8085b, "RSA decrypt exception : " + e2.getMessage());
                return bArr2;
            }
        }
        C2551b.m7898b(f8085b, "content or privateKey is null , or length is too short");
        return bArr2;
    }

    public static byte[] encrypt(byte[] bArr, PublicKey publicKey) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && publicKey != null && isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                Cipher cipher = Cipher.getInstance(f8084a);
                cipher.init(1, publicKey);
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e2) {
                C2551b.m7898b(f8085b, "RSA encrypt exception : " + e2.getMessage());
                return bArr2;
            }
        }
        C2551b.m7898b(f8085b, "content or PublicKey is null , or length is too short");
        return bArr2;
    }
}
