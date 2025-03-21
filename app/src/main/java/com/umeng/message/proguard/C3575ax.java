package com.umeng.message.proguard;

import android.text.TextUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.umeng.message.proguard.ax */
/* loaded from: classes2.dex */
public final class C3575ax {
    /* renamed from: a */
    public static String m12316a(String str, String str2, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str2) || bArr == null || TextUtils.isEmpty(str)) {
            return "";
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(bArr));
        return C3570as.m12293a(cipher.doFinal(str.getBytes()));
    }

    /* renamed from: b */
    public static String m12317b(String str, String str2, byte[] bArr) throws Exception {
        if (TextUtils.isEmpty(str2) || bArr == null || TextUtils.isEmpty(str)) {
            return "";
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(str2.getBytes(), "AES"), new IvParameterSpec(bArr));
        return new String(cipher.doFinal(C3570as.m12294a(str)));
    }
}
