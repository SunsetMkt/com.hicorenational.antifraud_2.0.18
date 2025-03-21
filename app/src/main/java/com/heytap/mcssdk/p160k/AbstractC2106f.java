package com.heytap.mcssdk.p160k;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* renamed from: com.heytap.mcssdk.k.f */
/* loaded from: classes.dex */
public abstract class AbstractC2106f {
    /* renamed from: a */
    public static String m5876a(String str, String str2) {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(2, m5877a(str2));
        return new String(cipher.doFinal(Base64.decode(str, 0)), Charset.defaultCharset()).trim();
    }

    /* renamed from: a */
    private static Key m5877a(String str) {
        return SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(Base64.decode(str, 0)));
    }
}
