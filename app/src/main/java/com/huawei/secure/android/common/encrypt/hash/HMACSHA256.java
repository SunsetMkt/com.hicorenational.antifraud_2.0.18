package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class HMACSHA256 {
    private static final String a = "HMACSHA256";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5060b = "HmacSHA256";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5061c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f5062d = 32;

    public static byte[] hmacEncrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            b.b(a, "content or key is null.");
            return new byte[0];
        }
        if (bArr2.length < 32) {
            b.b(a, "hmac key length is not right");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f5060b);
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException e2) {
            b.b(a, "hmacsha256 encrypt exception" + e2.getMessage());
            return new byte[0];
        }
    }

    public static String hmacSHA256Encrypt(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : hmacSHA256Encrypt(str, HexUtil.hexStr2ByteArray(str2));
    }

    public static String hmacSHA256Encrypt(String str, byte[] bArr) {
        byte[] bytes;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return "";
        }
        if (bArr.length < 32) {
            b.b(a, "hmac key length is not right");
            return "";
        }
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(a, "hmacsha256 encrypt exception" + e2.getMessage());
            bytes = new byte[0];
        }
        return HexUtil.byteArray2HexStr(hmacEncrypt(bytes, bArr));
    }
}
