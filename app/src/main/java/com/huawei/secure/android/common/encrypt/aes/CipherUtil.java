package com.huawei.secure.android.common.encrypt.aes;

import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class CipherUtil {

    /* renamed from: a */
    private static final String f8028a = "CipherUtil";

    /* renamed from: b */
    private static final String f8029b = "AES/GCM/NoPadding";

    /* renamed from: c */
    private static final String f8030c = "AES/CBC/PKCS5Padding";

    /* renamed from: d */
    private static final String f8031d = "AES";

    /* renamed from: e */
    private static final String f8032e = "";

    /* renamed from: f */
    private static final int f8033f = 16;

    /* renamed from: g */
    private static final int f8034g = 12;

    /* renamed from: h */
    private static final int f8035h = 16;

    /* renamed from: a */
    private static Cipher m7845a(byte[] bArr, byte[] bArr2, int i2) {
        return m7846a(bArr, bArr2, i2, f8030c);
    }

    /* renamed from: b */
    private static Cipher m7847b(byte[] bArr, byte[] bArr2, int i2) {
        return m7846a(bArr, bArr2, i2, f8029b);
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesCbcDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr) {
        return getAesCbcEncryptCipher(bArr, EncryptUtil.generateSecureRandom(16));
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesCbcEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(16));
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, Cipher cipher) {
        return getAesGcmDecryptCipher(bArr, cipher.getIV());
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        C2551b.m7896a(f8028a, "getEncryptCipher: iv is : " + HexUtil.byteArray2HexStr(generateSecureRandom));
        return getAesGcmEncryptCipher(bArr, generateSecureRandom);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2) {
        return getAesGcmEncryptContentLen(bArr, bArr2, EncryptUtil.generateSecureRandom(12));
    }

    public static int getContent(Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher == null || bArr == null) {
            C2551b.m7898b(f8028a, "getEncryptCOntent: cipher is null or content is null");
            return -1;
        }
        try {
            return cipher.doFinal(bArr, 0, bArr.length, bArr2);
        } catch (BadPaddingException unused) {
            C2551b.m7898b(f8028a, "getContent: BadPaddingException");
            return -1;
        } catch (IllegalBlockSizeException unused2) {
            C2551b.m7898b(f8028a, "getContent: IllegalBlockSizeException");
            return -1;
        } catch (ShortBufferException unused3) {
            C2551b.m7898b(f8028a, "getContent: ShortBufferException");
            return -1;
        }
    }

    /* renamed from: a */
    private static Cipher m7846a(byte[] bArr, byte[] bArr2, int i2, String str) {
        if (bArr == null || bArr.length < 16 || bArr2 == null || bArr2.length < 12 || !AesGcm.isBuildVersionHigherThan19()) {
            C2551b.m7898b(f8028a, "gcm encrypt param is not right");
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f8031d);
            Cipher cipher = Cipher.getInstance(str);
            cipher.init(i2, secretKeySpec, f8029b.equals(str) ? AesGcm.getGcmAlgorithmParams(bArr2) : new IvParameterSpec(bArr2));
            return cipher;
        } catch (GeneralSecurityException e2) {
            C2551b.m7898b(f8028a, "GCM encrypt data error" + e2.getMessage());
            return null;
        }
    }

    public static Cipher getAesCbcDecryptCipher(byte[] bArr, byte[] bArr2) {
        return m7845a(bArr, bArr2, 2);
    }

    public static Cipher getAesCbcEncryptCipher(byte[] bArr, byte[] bArr2) {
        return m7845a(bArr, bArr2, 1);
    }

    public static int getAesCbcEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m7844a(getAesCbcEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmDecryptCipher(byte[] bArr, byte[] bArr2) {
        return m7847b(bArr, bArr2, 2);
    }

    public static int getAesGcmEncryptContentLen(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return m7844a(getAesGcmEncryptCipher(bArr2, bArr3), bArr);
    }

    public static Cipher getAesGcmEncryptCipher(byte[] bArr, byte[] bArr2) {
        return m7847b(bArr, bArr2, 1);
    }

    public static int getContent(Cipher cipher, byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (cipher != null && bArr != null) {
            return cipher.doFinal(bArr, i2, i3, bArr2, i4);
        }
        C2551b.m7898b(f8028a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static byte[] getContent(Cipher cipher, byte[] bArr) {
        if (cipher != null && bArr != null) {
            try {
                return cipher.doFinal(bArr, 0, bArr.length);
            } catch (BadPaddingException unused) {
                C2551b.m7898b(f8028a, "getContent: BadPaddingException");
                return new byte[0];
            } catch (IllegalBlockSizeException unused2) {
                C2551b.m7898b(f8028a, "getContent: IllegalBlockSizeException");
                return new byte[0];
            }
        }
        C2551b.m7898b(f8028a, "getEncryptCOntent: cipher is null or content is null");
        return new byte[0];
    }

    /* renamed from: a */
    private static int m7844a(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }
}
