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
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/* loaded from: classes.dex */
public abstract class RSASignKS {

    /* renamed from: a */
    private static final String f8078a = "RSASignKS";

    /* renamed from: b */
    private static final String f8079b = "AndroidKeyStore";

    /* renamed from: c */
    private static final String f8080c = "SHA256withRSA/PSS";

    /* renamed from: d */
    private static final String f8081d = "";

    /* renamed from: e */
    private static final int f8082e = 2048;

    /* renamed from: f */
    private static final int f8083f = 3072;

    /* renamed from: a */
    private static byte[] m7869a(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (TextUtils.isEmpty(str) || bArr == null) {
            C2551b.m7898b(f8078a, "alias or content is null");
            return bArr2;
        }
        if (!isBuildVersionHigherThan22()) {
            C2551b.m7898b(f8078a, "sdk version is too low");
            return bArr2;
        }
        KeyStore.Entry m7870b = m7870b(str, z);
        if (!(m7870b instanceof KeyStore.PrivateKeyEntry)) {
            C2551b.m7898b(f8078a, "Not an instance of a PrivateKeyEntry");
            return bArr2;
        }
        try {
            Signature signature = Signature.getInstance(f8080c);
            signature.initSign(((KeyStore.PrivateKeyEntry) m7870b).getPrivateKey());
            signature.update(bArr);
            return signature.sign();
        } catch (InvalidKeyException e2) {
            C2551b.m7898b(f8078a, "InvalidKeyException: " + e2.getMessage());
            return bArr2;
        } catch (NoSuchAlgorithmException e3) {
            C2551b.m7898b(f8078a, "NoSuchAlgorithmException: " + e3.getMessage());
            return bArr2;
        } catch (SignatureException e4) {
            C2551b.m7898b(f8078a, "SignatureException: " + e4.getMessage());
            return bArr2;
        } catch (Exception e5) {
            C2551b.m7898b(f8078a, "Exception: " + e5.getMessage());
            return bArr2;
        }
    }

    /* renamed from: b */
    private static KeyStore.Entry m7870b(String str, boolean z) {
        if (!m7867a(str)) {
            m7866a(str, z);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(f8079b);
            keyStore.load(null);
            return keyStore.getEntry(str, null);
        } catch (IOException e2) {
            C2551b.m7898b(f8078a, "IOException: " + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            C2551b.m7898b(f8078a, "KeyStoreException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            C2551b.m7898b(f8078a, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (UnrecoverableEntryException e5) {
            C2551b.m7898b(f8078a, "UnrecoverableEntryException: " + e5.getMessage());
            return null;
        } catch (CertificateException e6) {
            C2551b.m7898b(f8078a, "CertificateException: " + e6.getMessage());
            return null;
        }
    }

    public static boolean isBuildVersionHigherThan22() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        try {
            return Base64.encodeToString(sign(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = "sign UnsupportedEncodingException : " + e2.getMessage();
            return "";
        }
    }

    public static String signNew(String str, String str2) {
        try {
            return Base64.encodeToString(signNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = "sign UnsupportedEncodingException : " + e2.getMessage();
            return "";
        }
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        try {
            return verifySign(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e2) {
            String str4 = "verifySign UnsupportedEncodingException: " + e2.getMessage();
            return false;
        } catch (Exception e3) {
            C2551b.m7898b(f8078a, "base64 decode Exception" + e3.getMessage());
            return false;
        }
    }

    public static boolean verifySignNew(String str, String str2, String str3) {
        try {
            return verifySignNew(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e2) {
            String str4 = "verifySign UnsupportedEncodingException: " + e2.getMessage();
            return false;
        } catch (Exception e3) {
            C2551b.m7898b(f8078a, "base64 decode Exception" + e3.getMessage());
            return false;
        }
    }

    @Deprecated
    public static byte[] sign(String str, byte[] bArr) {
        return m7869a(str, bArr, false);
    }

    public static byte[] signNew(String str, byte[] bArr) {
        return m7869a(str, bArr, true);
    }

    @Deprecated
    public static boolean verifySign(String str, byte[] bArr, byte[] bArr2) {
        return m7868a(str, bArr, bArr2, false);
    }

    public static boolean verifySignNew(String str, byte[] bArr, byte[] bArr2) {
        return m7868a(str, bArr, bArr2, true);
    }

    /* renamed from: a */
    private static boolean m7868a(String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr2 != null) {
            if (!isBuildVersionHigherThan22()) {
                C2551b.m7898b(f8078a, "sdk version is too low");
                return false;
            }
            KeyStore.Entry m7870b = m7870b(str, z);
            if (!(m7870b instanceof KeyStore.PrivateKeyEntry)) {
                C2551b.m7898b(f8078a, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature signature = Signature.getInstance(f8080c);
                signature.initVerify(((KeyStore.PrivateKeyEntry) m7870b).getCertificate());
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (InvalidKeyException e2) {
                C2551b.m7898b(f8078a, "InvalidKeyException: " + e2.getMessage());
                return false;
            } catch (NoSuchAlgorithmException e3) {
                C2551b.m7898b(f8078a, "NoSuchAlgorithmException: " + e3.getMessage());
                return false;
            } catch (SignatureException e4) {
                C2551b.m7898b(f8078a, "SignatureException: " + e4.getMessage());
                return false;
            } catch (Exception e5) {
                C2551b.m7898b(f8078a, "Exception: " + e5.getMessage());
                return false;
            }
        }
        C2551b.m7898b(f8078a, "alias or content or sign value is null");
        return false;
    }

    /* renamed from: a */
    private static synchronized KeyPair m7866a(String str, boolean z) {
        synchronized (RSASignKS.class) {
            KeyPair keyPair = null;
            if (m7867a(str)) {
                C2551b.m7898b(f8078a, "Key pair exits");
                return null;
            }
            try {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", f8079b);
                    if (!z) {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512").setSignaturePaddings("PSS").setKeySize(2048).build());
                    } else {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512").setSignaturePaddings("PSS").setKeySize(f8083f).build());
                    }
                    keyPair = keyPairGenerator.generateKeyPair();
                } catch (InvalidAlgorithmParameterException e2) {
                    C2551b.m7898b(f8078a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                } catch (NoSuchProviderException e3) {
                    C2551b.m7898b(f8078a, "NoSuchProviderException: " + e3.getMessage());
                }
            } catch (NoSuchAlgorithmException e4) {
                C2551b.m7898b(f8078a, "NoSuchAlgorithmException: " + e4.getMessage());
            }
            return keyPair;
        }
    }

    /* renamed from: a */
    private static boolean m7867a(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(f8079b);
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e2) {
            C2551b.m7898b(f8078a, "IOException: " + e2.getMessage());
            return false;
        } catch (KeyStoreException e3) {
            C2551b.m7898b(f8078a, "KeyStoreException: " + e3.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e4) {
            C2551b.m7898b(f8078a, "NoSuchAlgorithmException: " + e4.getMessage());
            return false;
        } catch (UnrecoverableKeyException e5) {
            C2551b.m7898b(f8078a, "UnrecoverableKeyException: " + e5.getMessage());
            return false;
        } catch (CertificateException e6) {
            C2551b.m7898b(f8078a, "CertificateException: " + e6.getMessage());
            return false;
        }
    }
}
