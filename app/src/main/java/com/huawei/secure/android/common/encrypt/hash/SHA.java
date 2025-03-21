package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class SHA {

    /* renamed from: a */
    private static final String f8054a = "SHA";

    /* renamed from: c */
    private static final String f8056c = "";

    /* renamed from: b */
    private static final String f8055b = "SHA-256";

    /* renamed from: d */
    private static final String[] f8057d = {f8055b, "SHA-384", "SHA-512"};

    private SHA() {
    }

    /* renamed from: a */
    private static boolean m7852a(String str) {
        for (String str2 : f8057d) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String sha256Encrypt(String str) {
        return shaEncrypt(str, f8055b);
    }

    public static String shaEncrypt(String str, String str2) {
        byte[] bArr;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2551b.m7898b(f8054a, "content or algorithm is null.");
            return "";
        }
        if (!m7852a(str2)) {
            C2551b.m7898b(f8054a, "algorithm is not safe or legal");
            return "";
        }
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = new byte[0];
            C2551b.m7898b(f8054a, "Error in generate SHA UnsupportedEncodingException");
        }
        return HexUtil.byteArray2HexStr(shaEncryptByte(bArr, str2));
    }

    public static byte[] shaEncryptByte(byte[] bArr, String str) {
        if (bArr == null || TextUtils.isEmpty(str)) {
            C2551b.m7898b(f8054a, "content or algorithm is null.");
            return new byte[0];
        }
        if (!m7852a(str)) {
            C2551b.m7898b(f8054a, "algorithm is not safe or legal");
            return new byte[0];
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            C2551b.m7898b(f8054a, "Error in generate SHA NoSuchAlgorithmException");
            return new byte[0];
        }
    }

    public static boolean validateSHA(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equals(shaEncrypt(str, str3));
    }

    public static boolean validateSHA256(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(sha256Encrypt(str));
    }
}
