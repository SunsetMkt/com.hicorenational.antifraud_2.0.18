package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* loaded from: classes.dex */
public abstract class PBKDF2 {

    /* renamed from: a */
    private static final String f8045a = "PBKDF2";

    /* renamed from: b */
    private static final String f8046b = "PBKDF2WithHmacSHA1";

    /* renamed from: c */
    private static final String f8047c = "PBKDF2WithHmacSHA256";

    /* renamed from: d */
    private static final String f8048d = "";

    /* renamed from: e */
    private static final int f8049e = 8;

    /* renamed from: f */
    private static final int f8050f = 16;

    /* renamed from: g */
    private static final int f8051g = 32;

    /* renamed from: h */
    private static final int f8052h = 10000;

    /* renamed from: i */
    private static final int f8053i = 1000;

    /* renamed from: a */
    private static byte[] m7851a(char[] cArr, byte[] bArr, int i2, int i3, boolean z) {
        try {
            return (z ? SecretKeyFactory.getInstance(f8047c) : SecretKeyFactory.getInstance(f8046b)).generateSecret(new PBEKeySpec(cArr, bArr, i2, i3)).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            C2551b.m7898b(f8045a, "pbkdf exception : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] pbkdf2(char[] cArr, byte[] bArr, int i2, int i3) {
        return m7851a(cArr, bArr, i2, i3, false);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str) {
        return pbkdf2Encrypt(str, 10000);
    }

    public static String pbkdf2EncryptNew(String str) {
        return pbkdf2EncryptNew(str, 10000);
    }

    public static byte[] pbkdf2SHA256(char[] cArr, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT >= 26) {
            return m7851a(cArr, bArr, i2, i3, true);
        }
        C2551b.m7898b(f8045a, "system version not high than 26");
        return bArr2;
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2) {
        return validatePassword(str, str2, 10000);
    }

    public static boolean validatePasswordNew(String str, String str2) {
        return validatePasswordNew(str, str2, 10000);
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, int i2) {
        return pbkdf2Encrypt(str, EncryptUtil.generateSecureRandom(8), i2, 32);
    }

    public static String pbkdf2EncryptNew(String str, int i2) {
        return pbkdf2EncryptNew(str, EncryptUtil.generateSecureRandom(16), i2, 32);
    }

    @Deprecated
    public static boolean validatePassword(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return m7850a(pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(str2.substring(0, 16)), i2, 256), HexUtil.hexStr2ByteArray(str2.substring(16)));
    }

    public static boolean validatePasswordNew(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        String substring = str2.substring(0, 32);
        return m7850a(Build.VERSION.SDK_INT < 26 ? pbkdf2(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i2, 256) : pbkdf2SHA256(str.toCharArray(), HexUtil.hexStr2ByteArray(substring), i2, 256), HexUtil.hexStr2ByteArray(str2.substring(32)));
    }

    @Deprecated
    public static String pbkdf2Encrypt(String str, byte[] bArr, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8045a, "pwd is null.");
            return "";
        }
        if (i2 < 1000) {
            C2551b.m7898b(f8045a, "iterations times is not enough.");
            return "";
        }
        if (bArr == null || bArr.length < 8) {
            C2551b.m7898b(f8045a, "salt parameter is null or length is not enough");
            return "";
        }
        if (i3 < 32) {
            C2551b.m7898b(f8045a, "cipherLen length is not enough");
            return "";
        }
        return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2(str.toCharArray(), bArr, i2, i3 * 8));
    }

    public static String pbkdf2EncryptNew(String str, byte[] bArr, int i2, int i3) {
        byte[] pbkdf2SHA256;
        if (TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8045a, "pwd is null.");
            return "";
        }
        if (i2 < 1000) {
            C2551b.m7898b(f8045a, "iterations times is not enough.");
            return "";
        }
        if (bArr == null || bArr.length < 16) {
            C2551b.m7898b(f8045a, "salt parameter is null or length is not enough");
            return "";
        }
        if (i3 < 32) {
            C2551b.m7898b(f8045a, "cipherLen length is not enough");
            return "";
        }
        if (Build.VERSION.SDK_INT < 26) {
            C2551b.m7899c(f8045a, "sha 1");
            pbkdf2SHA256 = pbkdf2(str.toCharArray(), bArr, i2, i3 * 8);
        } else {
            C2551b.m7899c(f8045a, "sha 256");
            pbkdf2SHA256 = pbkdf2SHA256(str.toCharArray(), bArr, i2, i3 * 8);
        }
        return HexUtil.byteArray2HexStr(bArr) + HexUtil.byteArray2HexStr(pbkdf2SHA256);
    }

    /* renamed from: a */
    private static boolean m7850a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        int length = bArr.length ^ bArr2.length;
        for (int i2 = 0; i2 < bArr.length && i2 < bArr2.length; i2++) {
            length |= bArr[i2] ^ bArr2[i2];
        }
        return length == 0;
    }
}
