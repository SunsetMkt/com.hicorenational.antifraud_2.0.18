package com.huawei.secure.android.common.encrypt.aes;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesGcm {

    /* renamed from: a */
    private static final String f8020a = "security:";

    /* renamed from: b */
    private static final String f8021b = "AES/GCM/NoPadding";

    /* renamed from: c */
    private static final String f8022c = "AES";

    /* renamed from: d */
    private static final String f8023d = "GCM";

    /* renamed from: e */
    private static final String f8024e = "";

    /* renamed from: f */
    private static final int f8025f = 16;

    /* renamed from: g */
    private static final int f8026g = 12;

    /* renamed from: h */
    private static final int f8027h = 2;

    private AesGcm() {
    }

    /* renamed from: a */
    private static byte[] m7839a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            C2551b.m7898b(f8023d, "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8023d, "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8023d, "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 12) {
            C2551b.m7898b(f8023d, "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "encrypt 5 build version not higher than 19");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8023d, "GCM encrypt data error" + e2.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: b */
    private static byte[] m7842b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 12];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    /* renamed from: c */
    private static byte[] m7843c(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8023d, "decrypt 1 key is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "decrypt 1 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return decrypt(str, hexStr2ByteArray);
        }
        C2551b.m7898b(f8023d, "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String m7834c = AesCbc.m7834c(str);
            if ("".equals(m7834c)) {
                return "";
            }
            int indexOf = m7834c.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(m7834c.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(m7834c.substring(0, indexOf)));
            }
            C2551b.m7898b(f8023d, " gcm cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] m7836d = AesCbc.m7836d(bArr);
        if (m7836d.length == 0) {
            return new byte[0];
        }
        int m7837a = m7837a(m7836d);
        if (m7837a < 0) {
            C2551b.m7898b(f8023d, " gcm cipherText data missing colon");
            return new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(m7836d, m7837a);
        int length = (m7836d.length - copyOf.length) - 1;
        byte[] bArr3 = new byte[length];
        System.arraycopy(m7836d, m7837a + 1, bArr3, 0, length);
        return decrypt(bArr3, bArr2, copyOf);
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8023d, "encrypt 1 key is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "encrypt 1 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        if (hexStr2ByteArray.length >= 16) {
            return encrypt(str, hexStr2ByteArray);
        }
        C2551b.m7898b(f8023d, "encrypt key error: key length less than 16 bytes.");
        return "";
    }

    public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] bArr) {
        return Build.VERSION.SDK_INT < 21 ? new IvParameterSpec(bArr) : new GCMParameterSpec(128, bArr);
    }

    public static boolean isBuildVersionHigherThan19() {
        return Build.VERSION.SDK_INT >= 19;
    }

    /* renamed from: b */
    private static String m7841b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        C2551b.m7898b(f8023d, "IV is invalid.");
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            C2551b.m7898b(f8023d, "UnsupportedEncodingException");
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C2551b.m7898b(f8023d, "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8023d, "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "decrypt 2 build version not higher than 19");
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f8022c);
            Cipher cipher = Cipher.getInstance(f8021b);
            String m7841b = m7841b(str);
            String m7838a = m7838a(str);
            if (TextUtils.isEmpty(m7841b)) {
                C2551b.m7898b(f8023d, "decrypt 2 iv is null");
                return "";
            }
            if (TextUtils.isEmpty(m7838a)) {
                C2551b.m7898b(f8023d, "decrypt 2 encrypt content is null");
                return "";
            }
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(HexUtil.hexStr2ByteArray(m7841b)));
            return new String(cipher.doFinal(HexUtil.hexStr2ByteArray(m7838a)), "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException | GeneralSecurityException e2) {
            C2551b.m7898b(f8023d, "GCM decrypt data exception: " + e2.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C2551b.m7898b(f8023d, "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8023d, "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "encrypt 2 build version not higher than 19");
            return "";
        }
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        byte[] m7839a = m7839a(str, bArr, generateSecureRandom);
        if (m7839a == null || m7839a.length == 0) {
            return "";
        }
        return HexUtil.byteArray2HexStr(generateSecureRandom) + HexUtil.byteArray2HexStr(m7839a);
    }

    /* renamed from: a */
    private static byte[] m7840a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: a */
    private static String m7838a(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    /* renamed from: a */
    private static int m7837a(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "encrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8023d, "encrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            C2551b.m7898b(f8023d, "encrypt 3 iv is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "encrypt 3 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            C2551b.m7898b(f8023d, "encrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (hexStr2ByteArray2.length < 12) {
            C2551b.m7898b(f8023d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "decrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8023d, "decrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            C2551b.m7898b(f8023d, "decrypt 3 iv is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "decrypt 3 build version not higher than 19");
            return "";
        }
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
        if (hexStr2ByteArray.length < 16) {
            C2551b.m7898b(f8023d, "decrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (hexStr2ByteArray2.length < 12) {
            C2551b.m7898b(f8023d, "decrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C2551b.m7898b(f8023d, "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8023d, "encrypt 4 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8023d, "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            C2551b.m7898b(f8023d, "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "encrypt 4 build version not higher than 19");
            return "";
        }
        return HexUtil.byteArray2HexStr(m7839a(str, bArr, bArr2));
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8023d, "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C2551b.m7898b(f8023d, "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C2551b.m7898b(f8023d, "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8023d, "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            C2551b.m7898b(f8023d, "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "decrypt 4 build version not higher than 19");
            return "";
        }
        try {
            return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8023d, "GCM decrypt data exception: " + e2.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            C2551b.m7898b(f8023d, "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C2551b.m7898b(f8023d, "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8023d, "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C2551b.m7898b(f8023d, "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C2551b.m7898b(f8023d, "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            C2551b.m7898b(f8023d, "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "encrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f8022c);
            Cipher cipher = Cipher.getInstance(f8021b);
            cipher.init(1, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e2) {
            C2551b.m7898b(f8023d, "GCM encrypt data error" + e2.getMessage());
            return new byte[0];
        } catch (GeneralSecurityException e3) {
            C2551b.m7898b(f8023d, "GCM encrypt data error" + e3.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            C2551b.m7898b(f8023d, "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C2551b.m7898b(f8023d, "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C2551b.m7898b(f8023d, "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C2551b.m7898b(f8023d, "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C2551b.m7898b(f8023d, "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            C2551b.m7898b(f8023d, "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8023d, "decrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f8022c);
            Cipher cipher = Cipher.getInstance(f8021b);
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e2) {
            C2551b.m7898b(f8023d, "GCM decrypt data exception: " + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        return m7840a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(m7842b(bArr), bArr2, m7843c(bArr));
    }
}
