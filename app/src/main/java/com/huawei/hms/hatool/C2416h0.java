package com.huawei.hms.hatool;

import android.util.Base64;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.huawei.hms.hatool.h0 */
/* loaded from: classes.dex */
public class C2416h0 {
    /* renamed from: a */
    public static String m7153a(String str, String str2) {
        try {
            return m7154a(str, str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            C2452v.m7385c("hmsSdk", "Unsupported encoding exception,utf-8");
            return "";
        }
    }

    /* renamed from: a */
    public static String m7154a(String str, byte[] bArr) {
        String str2;
        if (bArr == null || bArr.length == 0) {
            C2452v.m7390f("hmsSdk", "encrypt: content is empty or null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(m7156a(bArr, m7155a(Base64.decode(str, 0))));
        } catch (NoSuchAlgorithmException unused) {
            str2 = "encrypt(): getInstance - No such algorithm,transformation";
            C2452v.m7390f("hmsSdk", str2);
            return "";
        } catch (InvalidKeySpecException unused2) {
            str2 = "encrypt(): Invalid key specification";
            C2452v.m7390f("hmsSdk", str2);
            return "";
        }
    }

    /* renamed from: a */
    private static PublicKey m7155a(byte[] bArr) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
    }

    /* renamed from: a */
    private static byte[] m7156a(byte[] bArr, PublicKey publicKey) {
        String str;
        try {
            if (publicKey == null) {
                throw new UnsupportedEncodingException("The loaded public key is null");
            }
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (UnsupportedEncodingException unused) {
            str = "rsaEncrypt(): getBytes - Unsupported coding format!";
            C2452v.m7390f("hmsSdk", str);
            return new byte[0];
        } catch (InvalidKeyException unused2) {
            str = "rsaEncrypt(): init - Invalid key!";
            C2452v.m7390f("hmsSdk", str);
            return new byte[0];
        } catch (NoSuchAlgorithmException unused3) {
            str = "rsaEncrypt(): getInstance - No such algorithm,transformation";
            C2452v.m7390f("hmsSdk", str);
            return new byte[0];
        } catch (BadPaddingException unused4) {
            str = "rsaEncrypt():False filling parameters!";
            C2452v.m7390f("hmsSdk", str);
            return new byte[0];
        } catch (IllegalBlockSizeException unused5) {
            str = "rsaEncrypt(): doFinal - The provided block is not filled with";
            C2452v.m7390f("hmsSdk", str);
            return new byte[0];
        } catch (NoSuchPaddingException unused6) {
            str = "rsaEncrypt():  No such filling parameters ";
            C2452v.m7390f("hmsSdk", str);
            return new byte[0];
        }
    }
}
