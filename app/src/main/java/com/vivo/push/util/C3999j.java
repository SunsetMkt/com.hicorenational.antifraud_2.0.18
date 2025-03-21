package com.vivo.push.util;

import com.umeng.analytics.pro.C3393cw;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: CryptographicTool.java */
/* renamed from: com.vivo.push.util.j */
/* loaded from: classes2.dex */
public final class C3999j {
    /* renamed from: a */
    public static String m13259a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = (char) (bArr[i2] ^ C3393cw.f11874n);
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static byte[] m13260a(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes("utf-8")));
        return cipher.doFinal(bArr);
    }
}
