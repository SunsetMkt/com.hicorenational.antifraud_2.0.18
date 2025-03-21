package com.huawei.secure.android.common.encrypt.rsa;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class RSASign {

    /* renamed from: a */
    private static final String f8090a = "SHA256WithRSA";

    /* renamed from: b */
    private static final String f8091b = "SHA256WithRSA/PSS";

    /* renamed from: c */
    private static final String f8092c = "RSASign";

    /* renamed from: d */
    private static final String f8093d = "UTF-8";

    /* renamed from: e */
    private static final String f8094e = "";

    /* renamed from: a */
    private static String m7871a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8092c, "sign content or key is null");
            return "";
        }
        PrivateKey privateKey = EncryptUtil.getPrivateKey(str2);
        return z ? newSign(str, privateKey) : sign(str, privateKey);
    }

    public static boolean isBuildVersionHigherThan23() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static String newSign(String str, String str2) {
        if (isBuildVersionHigherThan23()) {
            return m7871a(str, str2, true);
        }
        C2551b.m7898b(f8092c, "sdk version is too low");
        return "";
    }

    public static boolean newVerifySign(String str, String str2, String str3) {
        if (isBuildVersionHigherThan23()) {
            return m7873a(str, str2, str3, true);
        }
        C2551b.m7898b(f8092c, "sdk version is too low");
        return false;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        return m7871a(str, str2, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        return m7873a(str, str2, str3, false);
    }

    @Deprecated
    public static String sign(String str, PrivateKey privateKey) {
        return m7872a(str, privateKey, false);
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, PublicKey publicKey) {
        return m7874a(str, str2, publicKey, false);
    }

    public static byte[] sign(byte[] bArr, PrivateKey privateKey, boolean z) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr != null && privateKey != null && RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            try {
                if (z) {
                    signature = Signature.getInstance(f8091b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f8090a);
                }
                signature.initSign(privateKey);
                signature.update(bArr);
                return signature.sign();
            } catch (InvalidAlgorithmParameterException e2) {
                C2551b.m7898b(f8092c, "sign InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                C2551b.m7898b(f8092c, "sign InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                C2551b.m7898b(f8092c, "sign NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (SignatureException e5) {
                C2551b.m7898b(f8092c, "sign SignatureException: " + e5.getMessage());
                return bArr2;
            } catch (Exception e6) {
                C2551b.m7898b(f8092c, "sign Exception: " + e6.getMessage());
                return bArr2;
            }
        }
        C2551b.m7898b(f8092c, "content or privateKey is null , or length is too short");
        return bArr2;
    }

    public static boolean verifySign(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z) {
        Signature signature;
        if (bArr != null && publicKey != null && bArr2 != null && RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                if (z) {
                    signature = Signature.getInstance(f8091b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f8090a);
                }
                signature.initVerify(publicKey);
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (GeneralSecurityException e2) {
                C2551b.m7898b(f8092c, "check sign exception: " + e2.getMessage());
                return false;
            } catch (Exception e3) {
                C2551b.m7898b(f8092c, "exception : " + e3.getMessage());
                return false;
            }
        }
        C2551b.m7898b(f8092c, "content or publicKey is null , or length is too short");
        return false;
    }

    public static String newSign(String str, PrivateKey privateKey) {
        if (!isBuildVersionHigherThan23()) {
            C2551b.m7898b(f8092c, "sdk version is too low");
            return "";
        }
        return m7872a(str, privateKey, true);
    }

    public static boolean newVerifySign(String str, String str2, PublicKey publicKey) {
        if (!isBuildVersionHigherThan23()) {
            C2551b.m7898b(f8092c, "sdk version is too low");
            return false;
        }
        return m7874a(str, str2, publicKey, true);
    }

    /* renamed from: a */
    private static String m7872a(String str, PrivateKey privateKey, boolean z) {
        try {
            return Base64.encodeToString(sign(str.getBytes("UTF-8"), privateKey, z), 0);
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8092c, "sign UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    /* renamed from: a */
    private static boolean m7873a(String str, String str2, String str3, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            RSAPublicKey publicKey = EncryptUtil.getPublicKey(str3);
            if (z) {
                return newVerifySign(str, str2, publicKey);
            }
            return verifySign(str, str2, publicKey);
        }
        C2551b.m7898b(f8092c, "content or public key or sign value is null");
        return false;
    }

    /* renamed from: a */
    private static boolean m7874a(String str, String str2, PublicKey publicKey, boolean z) {
        try {
            return verifySign(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z);
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8092c, "verifySign UnsupportedEncodingException: " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            C2551b.m7898b(f8092c, "base64 decode Exception : " + e3.getMessage());
            return false;
        }
    }

    public static boolean verifySign(ByteBuffer byteBuffer, byte[] bArr, PublicKey publicKey, boolean z) {
        Signature signature;
        if (byteBuffer != null && publicKey != null && bArr != null && RSAEncrypt.isPublicKeyLengthRight((RSAPublicKey) publicKey)) {
            try {
                if (z) {
                    signature = Signature.getInstance(f8091b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f8090a);
                }
                signature.initVerify(publicKey);
                signature.update(byteBuffer);
                return signature.verify(bArr);
            } catch (GeneralSecurityException e2) {
                C2551b.m7898b(f8092c, "check sign exception: " + e2.getMessage());
                return false;
            } catch (Exception e3) {
                C2551b.m7898b(f8092c, "exception : " + e3.getMessage());
                return false;
            }
        }
        C2551b.m7898b(f8092c, "content or publicKey is null , or length is too short");
        return false;
    }

    public static byte[] sign(ByteBuffer byteBuffer, PrivateKey privateKey, boolean z) {
        Signature signature;
        byte[] bArr = new byte[0];
        if (byteBuffer != null && privateKey != null && RSAEncrypt.isPrivateKeyLengthRight((RSAPrivateKey) privateKey)) {
            try {
                if (z) {
                    signature = Signature.getInstance(f8091b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(f8090a);
                }
                signature.initSign(privateKey);
                signature.update(byteBuffer);
                bArr = signature.sign();
                C2551b.m7899c(f8092c, "result is : " + Arrays.toString(bArr));
                return bArr;
            } catch (InvalidAlgorithmParameterException e2) {
                C2551b.m7898b(f8092c, "sign InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr;
            } catch (InvalidKeyException e3) {
                C2551b.m7898b(f8092c, "sign InvalidKeyException: " + e3.getMessage());
                return bArr;
            } catch (NoSuchAlgorithmException e4) {
                C2551b.m7898b(f8092c, "sign NoSuchAlgorithmException: " + e4.getMessage());
                return bArr;
            } catch (SignatureException e5) {
                C2551b.m7898b(f8092c, "sign SignatureException: " + e5.getMessage());
                return bArr;
            } catch (Exception e6) {
                C2551b.m7898b(f8092c, "sign Exception: " + e6.getMessage());
                return bArr;
            }
        }
        C2551b.m7898b(f8092c, "content or privateKey is null , or length is too short");
        return bArr;
    }
}
