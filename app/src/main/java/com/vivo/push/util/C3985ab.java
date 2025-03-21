package com.vivo.push.util;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: RSAUtils.java */
/* renamed from: com.vivo.push.util.ab */
/* loaded from: classes2.dex */
public final class C3985ab {

    /* renamed from: a */
    private static String f14216a = "RSA";

    /* renamed from: a */
    public static String m13192a(Key key) {
        return Base64.encodeToString(key.getEncoded(), 2);
    }

    /* renamed from: a */
    public static PublicKey m13193a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(f14216a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    /* renamed from: a */
    public static boolean m13194a(byte[] bArr, PublicKey publicKey, byte[] bArr2) throws Exception {
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
