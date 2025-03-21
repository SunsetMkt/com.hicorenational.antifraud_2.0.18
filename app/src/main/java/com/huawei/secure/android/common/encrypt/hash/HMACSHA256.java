package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C2551b;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class HMACSHA256 {

    /* renamed from: a */
    private static final String f8041a = "HMACSHA256";

    /* renamed from: b */
    private static final String f8042b = "HmacSHA256";

    /* renamed from: c */
    private static final String f8043c = "";

    /* renamed from: d */
    private static final int f8044d = 32;

    public static byte[] hmacEncrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            C2551b.m7898b(f8041a, "content or key is null.");
            return new byte[0];
        }
        if (bArr2.length < 32) {
            C2551b.m7898b(f8041a, "hmac key length is not right");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f8042b);
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException e2) {
            C2551b.m7898b(f8041a, "hmacsha256 encrypt exception" + e2.getMessage());
            return new byte[0];
        }
    }

    public static String hmacSHA256Encrypt(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : hmacSHA256Encrypt(str, HexUtil.hexStr2ByteArray(str2));
    }

    public static String hmacSHA256Encrypt(String str, byte[] bArr) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return "";
        }
        if (bArr.length < 32) {
            C2551b.m7898b(f8041a, "hmac key length is not right");
            return "";
        }
        try {
            bArr2 = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C2551b.m7898b(f8041a, "hmacsha256 encrypt exception" + e2.getMessage());
            bArr2 = new byte[0];
        }
        return HexUtil.byteArray2HexStr(hmacEncrypt(bArr2, bArr));
    }
}
