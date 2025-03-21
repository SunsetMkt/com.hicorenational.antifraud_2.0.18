package com.luck.picture.lib.tools;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.C5230f1;

/* loaded from: classes.dex */
public class DESUtils {
    private static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    public static final String DES_KEY_STRING = "lmw#2020";

    private static String byte2String(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; bArr != null && i2 < bArr.length; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & C5230f1.f20085c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.CHINA);
    }

    public static String encode(String str, String str2, int i2, int i3) {
        if (str2 == null) {
            return null;
        }
        String str3 = str2 + AbstractC1191a.f2606s1 + i2 + "x" + i3;
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes()));
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            cipher.init(1, generateSecret, new IvParameterSpec(DES_KEY_STRING.getBytes()));
            String encode = URLEncoder.encode(byte2String(cipher.doFinal(str3.getBytes())), "UTF-8");
            if (TextUtils.isEmpty(encode)) {
                return null;
            }
            return encode.length() > 30 ? encode.substring(encode.length() - 30) : encode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
