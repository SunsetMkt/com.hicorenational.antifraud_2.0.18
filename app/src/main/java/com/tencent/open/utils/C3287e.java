package com.tencent.open.utils;

import android.util.Base64;
import com.tencent.open.log.SLog;
import com.umeng.analytics.pro.C3393cw;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.e */
/* loaded from: classes2.dex */
public class C3287e {

    /* renamed from: a */
    private static final char[] f11300a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m10593a(String str, String str2, byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e2) {
            SLog.m10501e("DESUtils", "encryptAES", e2);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m10595a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception e2) {
            SLog.m10501e("DESUtils", "encryptSha", e2);
            return null;
        }
    }

    /* renamed from: a */
    public static String m10594a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = f11300a;
            cArr[i3 + 1] = cArr2[b2 & C3393cw.f11873m];
            cArr[i3] = cArr2[((byte) (b2 >>> 4)) & C3393cw.f11873m];
        }
        return new String(cArr);
    }
}
