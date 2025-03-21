package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* loaded from: classes.dex */
public abstract class RSAEncryptKS {

    /* renamed from: a */
    private static final String f8072a = "RSAEncryptKS";

    /* renamed from: b */
    private static final String f8073b = "AndroidKeyStore";

    /* renamed from: c */
    private static final String f8074c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: d */
    private static final String f8075d = "";

    /* renamed from: e */
    private static final int f8076e = 2048;

    /* renamed from: f */
    private static final int f8077f = 3072;

    /* renamed from: a */
    private static byte[] m7862a(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C2551b.m7898b(f8072a, "alias or content is null");
            return bArr2;
        }
        if (!m7861a()) {
            C2551b.m7898b(f8072a, "sdk version is too low");
            return bArr2;
        }
        PublicKey m7863b = m7863b(str, z);
        if (m7863b == null) {
            C2551b.m7898b(f8072a, "Public key is null");
            return bArr2;
        }
        try {
            Cipher cipher = Cipher.getInstance(f8074c);
            cipher.init(1, m7863b, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e2) {
            C2551b.m7898b(f8072a, "InvalidAlgorithmParameterException: " + e2.getMessage());
            return bArr2;
        } catch (InvalidKeyException e3) {
            C2551b.m7898b(f8072a, "InvalidKeyException: " + e3.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e4) {
            C2551b.m7898b(f8072a, "NoSuchAlgorithmException: " + e4.getMessage());
            return bArr2;
        } catch (BadPaddingException e5) {
            C2551b.m7898b(f8072a, "BadPaddingException: " + e5.getMessage());
            return bArr2;
        } catch (IllegalBlockSizeException e6) {
            C2551b.m7898b(f8072a, "IllegalBlockSizeException: " + e6.getMessage());
            return bArr2;
        } catch (NoSuchPaddingException e7) {
            C2551b.m7898b(f8072a, "NoSuchPaddingException: " + e7.getMessage());
            return bArr2;
        } catch (Exception e8) {
            C2551b.m7898b(f8072a, "Exception: " + e8.getMessage());
            return bArr2;
        }
    }

    /* renamed from: b */
    private static PublicKey m7863b(String str, boolean z) {
        if (!m7864b(str)) {
            m7859a(str, z);
        }
        Certificate m7865c = m7865c(str);
        if (m7865c != null) {
            return m7865c.getPublicKey();
        }
        return null;
    }

    /* renamed from: c */
    private static Certificate m7865c(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f8073b);
            keyStore.load(null);
            return keyStore.getCertificate(str);
        } catch (IOException e2) {
            C2551b.m7898b(f8072a, "IOException: " + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            C2551b.m7898b(f8072a, "KeyStoreException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            C2551b.m7898b(f8072a, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (CertificateException e5) {
            C2551b.m7898b(f8072a, "CertificateException: " + e5.getMessage());
            return null;
        } catch (Exception e6) {
            C2551b.m7898b(f8072a, "Exception: " + e6.getMessage());
            return null;
        }
    }

    @Deprecated
    public static String decrpyt(String str, String str2) {
        try {
            return new String(decrpyt(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8072a, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            C2551b.m7898b(f8072a, "Exception: " + e3.getMessage());
            return "";
        }
    }

    public static String decrpytNew(String str, String str2) {
        try {
            return new String(decrpytNew(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8072a, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            C2551b.m7898b(f8072a, "Exception: " + e3.getMessage());
            return "";
        }
    }

    @Deprecated
    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encrypt(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8072a, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    public static String encryptNew(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(encryptNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8072a, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] decrpyt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!m7861a()) {
                C2551b.m7898b(f8072a, "sdk version is too low");
                return bArr2;
            }
            PrivateKey m7860a = m7860a(str);
            if (m7860a == null) {
                C2551b.m7898b(f8072a, "Private key is null");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f8074c);
                cipher.init(2, m7860a, new OAEPParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e2) {
                C2551b.m7898b(f8072a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                C2551b.m7898b(f8072a, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                C2551b.m7898b(f8072a, "NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                C2551b.m7898b(f8072a, "BadPaddingException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                C2551b.m7898b(f8072a, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                C2551b.m7898b(f8072a, "NoSuchPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                C2551b.m7898b(f8072a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
        C2551b.m7898b(f8072a, "alias or encrypted content is null");
        return bArr2;
    }

    public static byte[] decrpytNew(String str, byte[] bArr) {
        return decrpyt(str, bArr);
    }

    @Deprecated
    public static byte[] encrypt(String str, byte[] bArr) {
        return m7862a(str, bArr, false);
    }

    public static byte[] encryptNew(String str, byte[] bArr) {
        return m7862a(str, bArr, true);
    }

    /* renamed from: b */
    private static boolean m7864b(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f8073b);
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e2) {
            C2551b.m7898b(f8072a, "IOException: " + e2.getMessage());
            return false;
        } catch (KeyStoreException e3) {
            C2551b.m7898b(f8072a, "KeyStoreException: " + e3.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e4) {
            C2551b.m7898b(f8072a, "NoSuchAlgorithmException: " + e4.getMessage());
            return false;
        } catch (UnrecoverableKeyException e5) {
            C2551b.m7898b(f8072a, "UnrecoverableKeyException: " + e5.getMessage());
            return false;
        } catch (CertificateException e6) {
            C2551b.m7898b(f8072a, "CertificateException: " + e6.getMessage());
            return false;
        } catch (Exception e7) {
            C2551b.m7898b(f8072a, "Exception: " + e7.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    private static synchronized KeyPair m7859a(String str, boolean z) {
        synchronized (RSAEncryptKS.class) {
            KeyPair keyPair = null;
            if (m7864b(str)) {
                C2551b.m7898b(f8072a, "Key pair exits");
                return null;
            }
            C2551b.m7899c(f8072a, "generate key pair.");
            try {
                try {
                    try {
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", f8073b);
                        if (!z) {
                            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(2048).build());
                        } else {
                            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(f8077f).build());
                        }
                        keyPair = keyPairGenerator.generateKeyPair();
                    } catch (NoSuchProviderException e2) {
                        C2551b.m7898b(f8072a, "NoSuchProviderException: " + e2.getMessage());
                    } catch (Exception e3) {
                        C2551b.m7898b(f8072a, "Exception: " + e3.getMessage());
                    }
                } catch (InvalidAlgorithmParameterException e4) {
                    C2551b.m7898b(f8072a, "InvalidAlgorithmParameterException: " + e4.getMessage());
                }
            } catch (NoSuchAlgorithmException e5) {
                C2551b.m7898b(f8072a, "NoSuchAlgorithmException: " + e5.getMessage());
            }
            return keyPair;
        }
    }

    /* renamed from: a */
    private static PrivateKey m7860a(String str) {
        if (!m7864b(str)) {
            return null;
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(f8073b);
            keyStore.load(null);
            return (PrivateKey) keyStore.getKey(str, null);
        } catch (IOException e2) {
            C2551b.m7898b(f8072a, "IOException: " + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            C2551b.m7898b(f8072a, "KeyStoreException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            C2551b.m7898b(f8072a, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (UnrecoverableKeyException e5) {
            C2551b.m7898b(f8072a, "UnrecoverableKeyException: " + e5.getMessage());
            return null;
        } catch (CertificateException e6) {
            C2551b.m7898b(f8072a, "CertificateException: " + e6.getMessage());
            return null;
        } catch (Exception e7) {
            C2551b.m7898b(f8072a, "Exception: " + e7.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m7861a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
