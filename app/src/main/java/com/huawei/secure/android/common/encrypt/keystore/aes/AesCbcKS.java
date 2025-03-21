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
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes.dex */
public class AesCbcKS {

    /* renamed from: a */
    private static final String f8058a = "CBCKS";

    /* renamed from: b */
    private static final String f8059b = "AndroidKeyStore";

    /* renamed from: c */
    private static final String f8060c = "AES/CBC/PKCS7Padding";

    /* renamed from: d */
    private static final String f8061d = "";

    /* renamed from: e */
    private static final int f8062e = 16;

    /* renamed from: f */
    private static final int f8063f = 256;

    /* renamed from: g */
    private static Map<String, SecretKey> f8064g = new HashMap();

    /* renamed from: a */
    private static synchronized SecretKey m7853a(String str) {
        SecretKey secretKey;
        synchronized (AesCbcKS.class) {
            C2551b.m7899c(f8058a, "load key");
            secretKey = null;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    KeyStore keyStore = KeyStore.getInstance(f8059b);
                                    keyStore.load(null);
                                    Key key = keyStore.getKey(str, null);
                                    if (key == null || !(key instanceof SecretKey)) {
                                        C2551b.m7899c(f8058a, "generate key");
                                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", f8059b);
                                        keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).build());
                                        secretKey = keyGenerator.generateKey();
                                    } else {
                                        secretKey = (SecretKey) key;
                                    }
                                } catch (KeyStoreException e2) {
                                    C2551b.m7898b(f8058a, "KeyStoreException: " + e2.getMessage());
                                } catch (NoSuchAlgorithmException e3) {
                                    C2551b.m7898b(f8058a, "NoSuchAlgorithmException: " + e3.getMessage());
                                }
                            } catch (IOException e4) {
                                C2551b.m7898b(f8058a, "IOException: " + e4.getMessage());
                            } catch (Exception e5) {
                                C2551b.m7898b(f8058a, "Exception: " + e5.getMessage());
                            }
                        } catch (UnrecoverableKeyException e6) {
                            C2551b.m7898b(f8058a, "UnrecoverableKeyException: " + e6.getMessage());
                        }
                    } catch (NoSuchProviderException e7) {
                        C2551b.m7898b(f8058a, "NoSuchProviderException: " + e7.getMessage());
                    }
                } catch (InvalidAlgorithmParameterException e8) {
                    C2551b.m7898b(f8058a, "InvalidAlgorithmParameterException: " + e8.getMessage());
                }
            } catch (CertificateException e9) {
                C2551b.m7898b(f8058a, "CertificateException: " + e9.getMessage());
            }
            f8064g.put(str, secretKey);
        }
        return secretKey;
    }

    /* renamed from: b */
    private static SecretKey m7855b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f8064g.get(str) == null) {
            m7853a(str);
        }
        return f8064g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8058a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            C2551b.m7898b(f8058a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8058a, "encrypt 1 content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            C2551b.m7898b(f8058a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!m7854a()) {
                C2551b.m7898b(f8058a, "sdk version is too low");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f8060c);
                SecretKey m7855b = m7855b(str);
                if (m7855b == null) {
                    C2551b.m7898b(f8058a, "encrypt secret key is null");
                    return bArr2;
                }
                cipher.init(1, m7855b);
                byte[] doFinal = cipher.doFinal(bArr);
                byte[] iv = cipher.getIV();
                if (iv != null && iv.length == 16) {
                    byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                    System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                    return copyOf;
                }
                C2551b.m7898b(f8058a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e2) {
                C2551b.m7898b(f8058a, "InvalidKeyException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e3) {
                C2551b.m7898b(f8058a, "NoSuchAlgorithmException: " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                C2551b.m7898b(f8058a, "BadPaddingException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                C2551b.m7898b(f8058a, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e6) {
                C2551b.m7898b(f8058a, "NoSuchPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                C2551b.m7898b(f8058a, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
        C2551b.m7898b(f8058a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!m7854a()) {
                C2551b.m7898b(f8058a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 16) {
                C2551b.m7898b(f8058a, "Decrypt source data is invalid.");
                return bArr2;
            }
            SecretKey m7855b = m7855b(str);
            if (m7855b == null) {
                C2551b.m7898b(f8058a, "decrypt secret key is null");
                return bArr2;
            }
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            try {
                Cipher cipher = Cipher.getInstance(f8060c);
                cipher.init(2, m7855b, new IvParameterSpec(copyOf));
                return cipher.doFinal(bArr, 16, bArr.length - 16);
            } catch (InvalidAlgorithmParameterException e2) {
                C2551b.m7898b(f8058a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                C2551b.m7898b(f8058a, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                C2551b.m7898b(f8058a, "NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                C2551b.m7898b(f8058a, "BadPaddingException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                C2551b.m7898b(f8058a, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                C2551b.m7898b(f8058a, "NoSuchPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                C2551b.m7898b(f8058a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
        C2551b.m7898b(f8058a, "alias or encrypt content is null");
        return bArr2;
    }

    /* renamed from: a */
    private static boolean m7854a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
