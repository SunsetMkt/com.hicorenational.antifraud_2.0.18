package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesCbc {

    /* renamed from: a */
    private static final String f8013a = "security:";

    /* renamed from: b */
    private static final String f8014b = "AES/CBC/PKCS5Padding";

    /* renamed from: c */
    private static final String f8015c = "AES";

    /* renamed from: d */
    private static final String f8016d = "CBC";

    /* renamed from: e */
    private static final String f8017e = "";

    /* renamed from: f */
    private static final int f8018f = 16;

    /* renamed from: g */
    private static final int f8019g = 16;

    private AesCbc() {
    }

    /* renamed from: a */
    private static byte[] m7830a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            C2551b.m7898b(f8016d, "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8016d, "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8016d, " cbc encrypt data error" + e2.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    private static byte[] m7833b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    /* renamed from: c */
    private static byte[] m7835c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    /* renamed from: d */
    static byte[] m7836d(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8016d, "stripCryptHead: exception : " + e2.getMessage());
            str = "";
        }
        if (!str.startsWith(f8013a)) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length - 9];
        System.arraycopy(bArr, 9, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8016d, "decrypt 1 key is null");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return decrypt(str, hexStr2ByteArray);
        }
        C2551b.m7898b(f8016d, "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String m7834c = m7834c(str);
            if ("".equals(m7834c)) {
                return "";
            }
            int indexOf = m7834c.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(m7834c.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(m7834c.substring(0, indexOf)));
            }
            C2551b.m7898b(f8016d, " cbc cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] m7836d = m7836d(bArr);
        if (m7836d.length == 0) {
            return new byte[0];
        }
        int m7827a = m7827a(m7836d);
        if (m7827a < 0) {
            C2551b.m7898b(f8016d, " cbc cipherText data missing colon");
            return new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(m7836d, m7827a);
        int length = (m7836d.length - copyOf.length) - 1;
        byte[] bArr3 = new byte[length];
        System.arraycopy(m7836d, m7827a + 1, bArr3, 0, length);
        return decrypt(bArr3, bArr2, copyOf);
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8016d, "encrypt 1 key is null");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return encrypt(str, hexStr2ByteArray);
        }
        C2551b.m7898b(f8016d, "encrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    /* renamed from: c */
    static String m7834c(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf(f8013a) == -1) ? "" : str.substring(9);
    }

    /* renamed from: b */
    private static String m7832b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e2) {
            C2551b.m7898b(f8016d, "getIv exception : " + e2.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C2551b.m7898b(f8016d, "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8016d, "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        String m7832b = m7832b(str);
        String m7828a = m7828a(str);
        if (TextUtils.isEmpty(m7832b)) {
            C2551b.m7898b(f8016d, "decrypt 2 iv is null");
            return "";
        }
        if (TextUtils.isEmpty(m7828a)) {
            C2551b.m7898b(f8016d, "decrypt 2 encrypt content is null");
            return "";
        }
        return decrypt(m7828a, bArr, HexUtil.hexStr2ByteArray(m7832b));
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            C2551b.m7898b(f8016d, "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C2551b.m7898b(f8016d, "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
        byte[] m7830a = m7830a(str, bArr, generateSecureRandom);
        return (m7830a == null || m7830a.length == 0) ? "" : m7829a(HexUtil.byteArray2HexStr(generateSecureRandom), HexUtil.byteArray2HexStr(m7830a));
    }

    /* renamed from: a */
    private static String m7829a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e2) {
                C2551b.m7898b(f8016d, "mix exception: " + e2.getMessage());
            }
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "encrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8016d, "encrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            C2551b.m7898b(f8016d, "encrypt 3 iv is null");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (hexStr2ByteArray2.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "decrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8016d, "decrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            C2551b.m7898b(f8016d, "decrypt 3 iv is null");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            C2551b.m7898b(f8016d, "decrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (hexStr2ByteArray2.length < 16) {
            C2551b.m7898b(f8016d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
    }

    /* renamed from: a */
    private static byte[] m7831a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    private static String m7828a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e2) {
            C2551b.m7898b(f8016d, "get encryptword exception : " + e2.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    private static int m7827a(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C2551b.m7898b(f8016d, "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8016d, "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        return HexUtil.byteArray2HexStr(m7830a(str, bArr, bArr2));
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8016d, "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C2551b.m7898b(f8016d, "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8016d, "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8016d, "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            C2551b.m7898b(f8016d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        try {
            return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8016d, " cbc decrypt data error" + e2.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            C2551b.m7898b(f8016d, "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C2551b.m7898b(f8016d, "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8016d, "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C2551b.m7898b(f8016d, "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            C2551b.m7898b(f8016d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f8015c);
        try {
            Cipher cipher = Cipher.getInstance(f8014b);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e2) {
            C2551b.m7898b(f8016d, "NullPointerException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e3) {
            C2551b.m7898b(f8016d, "InvalidAlgorithmParameterException: " + e3.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e4) {
            C2551b.m7898b(f8016d, "InvalidKeyException: " + e4.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e5) {
            C2551b.m7898b(f8016d, "NoSuchAlgorithmException: " + e5.getMessage());
            return new byte[0];
        } catch (BadPaddingException e6) {
            C2551b.m7898b(f8016d, "BadPaddingException: " + e6.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e7) {
            C2551b.m7898b(f8016d, "IllegalBlockSizeException: " + e7.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e8) {
            C2551b.m7898b(f8016d, "NoSuchPaddingException: " + e8.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            C2551b.m7898b(f8016d, "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C2551b.m7898b(f8016d, "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8016d, "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C2551b.m7898b(f8016d, "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C2551b.m7898b(f8016d, "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            C2551b.m7898b(f8016d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f8015c);
        try {
            Cipher cipher = Cipher.getInstance(f8014b);
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e2) {
            C2551b.m7898b(f8016d, "NullPointerException: " + e2.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e3) {
            C2551b.m7898b(f8016d, "InvalidAlgorithmParameterException: " + e3.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e4) {
            C2551b.m7898b(f8016d, "InvalidKeyException: " + e4.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e5) {
            C2551b.m7898b(f8016d, "NoSuchAlgorithmException: " + e5.getMessage());
            return new byte[0];
        } catch (BadPaddingException e6) {
            C2551b.m7898b(f8016d, "BadPaddingException: " + e6.getMessage());
            C2551b.m7898b(f8016d, "key is not right");
            return new byte[0];
        } catch (IllegalBlockSizeException e7) {
            C2551b.m7898b(f8016d, "IllegalBlockSizeException: " + e7.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e8) {
            C2551b.m7898b(f8016d, "NoSuchPaddingException: " + e8.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
        return m7831a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(m7833b(bArr), bArr2, m7835c(bArr));
    }
}
