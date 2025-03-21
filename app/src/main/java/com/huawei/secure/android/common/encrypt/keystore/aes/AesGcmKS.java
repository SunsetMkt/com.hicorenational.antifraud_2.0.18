package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes.dex */
public class AesGcmKS {

    /* renamed from: a */
    private static final String f8065a = "GCMKS";

    /* renamed from: b */
    private static final String f8066b = "AndroidKeyStore";

    /* renamed from: c */
    private static final String f8067c = "AES/GCM/NoPadding";

    /* renamed from: d */
    private static final String f8068d = "";

    /* renamed from: e */
    private static final int f8069e = 12;

    /* renamed from: f */
    private static final int f8070f = 256;

    /* renamed from: g */
    private static Map<String, SecretKey> f8071g = new HashMap();

    /* renamed from: a */
    private static SecretKey m7856a(String str) {
        C2551b.m7899c(f8065a, "load key");
        SecretKey secretKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(f8066b);
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                secretKey = (SecretKey) key;
            } else {
                C2551b.m7899c(f8065a, "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", f8066b);
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                secretKey = keyGenerator.generateKey();
            }
        } catch (IOException e2) {
            C2551b.m7898b(f8065a, "IOException : " + e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            C2551b.m7898b(f8065a, "InvalidAlgorithmParameterException : " + e3.getMessage());
        } catch (KeyStoreException e4) {
            C2551b.m7898b(f8065a, "KeyStoreException : " + e4.getMessage());
        } catch (NoSuchAlgorithmException e5) {
            C2551b.m7898b(f8065a, "NoSuchAlgorithmException : " + e5.getMessage());
        } catch (NoSuchProviderException e6) {
            C2551b.m7898b(f8065a, "NoSuchProviderException : " + e6.getMessage());
        } catch (UnrecoverableKeyException e7) {
            C2551b.m7898b(f8065a, "UnrecoverableKeyException : " + e7.getMessage());
        } catch (CertificateException e8) {
            C2551b.m7898b(f8065a, "CertificateException : " + e8.getMessage());
        } catch (Exception e9) {
            C2551b.m7898b(f8065a, "Exception: " + e9.getMessage());
        }
        f8071g.put(str, secretKey);
        return secretKey;
    }

    /* renamed from: b */
    private static SecretKey m7858b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f8071g.get(str) == null) {
            m7856a(str);
        }
        return f8071g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8065a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8065a, "decrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8065a, "alias or encrypt content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8065a, "encrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!m7857a()) {
                C2551b.m7898b(f8065a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 12) {
                C2551b.m7898b(f8065a, "Decrypt source data is invalid.");
                return bArr2;
            }
            return decrypt(m7858b(str), bArr);
        }
        C2551b.m7898b(f8065a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!m7857a()) {
                C2551b.m7898b(f8065a, "sdk version is too low");
                return bArr2;
            }
            return encrypt(m7858b(str), bArr);
        }
        C2551b.m7898b(f8065a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            C2551b.m7898b(f8065a, "content is null");
            return bArr2;
        }
        if (secretKey == null) {
            C2551b.m7898b(f8065a, "secret key is null");
            return bArr2;
        }
        if (!m7857a()) {
            C2551b.m7898b(f8065a, "sdk version is too low");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f8067c);
            cipher.init(1, secretKey);
            byte[] doFinal = cipher.doFinal(bArr);
            byte[] iv = cipher.getIV();
            if (iv != null && iv.length == 12) {
                byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                return copyOf;
            }
            C2551b.m7898b(f8065a, "IV is invalid.");
            return bArr2;
        } catch (InvalidKeyException e2) {
            C2551b.m7898b(f8065a, "InvalidKeyException : " + e2.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e3) {
            C2551b.m7898b(f8065a, "NoSuchAlgorithmException : " + e3.getMessage());
            return bArr2;
        } catch (BadPaddingException e4) {
            C2551b.m7898b(f8065a, "BadPaddingException : " + e4.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e5) {
            C2551b.m7898b(f8065a, "IllegalBlockSizeException : " + e5.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e6) {
            C2551b.m7898b(f8065a, "NoSuchPaddingException : " + e6.getMessage());
            return bArr2;
        } catch (Exception e7) {
            C2551b.m7898b(f8065a, "Exception: " + e7.getMessage());
            return bArr2;
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            C2551b.m7898b(f8065a, "Decrypt secret key is null");
            return bArr2;
        }
        if (bArr == null) {
            C2551b.m7898b(f8065a, "content is null");
            return bArr2;
        }
        if (!m7857a()) {
            C2551b.m7898b(f8065a, "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            C2551b.m7898b(f8065a, "Decrypt source data is invalid.");
            return bArr2;
        }
        byte[] copyOf = Arrays.copyOf(bArr, 12);
        try {
            Cipher cipher = Cipher.getInstance(f8067c);
            cipher.init(2, secretKey, new GCMParameterSpec(128, copyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (InvalidAlgorithmParameterException e2) {
            C2551b.m7898b(f8065a, "InvalidAlgorithmParameterException : " + e2.getMessage());
            return bArr2;
        } catch (InvalidKeyException e3) {
            C2551b.m7898b(f8065a, "InvalidKeyException : " + e3.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e4) {
            C2551b.m7898b(f8065a, "NoSuchAlgorithmException : " + e4.getMessage());
            return bArr2;
        } catch (BadPaddingException e5) {
            C2551b.m7898b(f8065a, "BadPaddingException : " + e5.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e6) {
            C2551b.m7898b(f8065a, "IllegalBlockSizeException : " + e6.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e7) {
            C2551b.m7898b(f8065a, "NoSuchPaddingException : " + e7.getMessage());
            return bArr2;
        } catch (Exception e8) {
            C2551b.m7898b(f8065a, "Exception: " + e8.getMessage());
            return bArr2;
        }
    }

    /* renamed from: a */
    private static boolean m7857a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
