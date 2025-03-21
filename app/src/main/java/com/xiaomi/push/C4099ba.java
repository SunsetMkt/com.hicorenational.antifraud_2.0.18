package com.xiaomi.push;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p286h.p309q2.p311t.C5558n;

/* renamed from: com.xiaomi.push.ba */
/* loaded from: classes2.dex */
public class C4099ba {
    /* renamed from: a */
    private static String m13874a(byte b2) {
        int i2 = (b2 & C5558n.f20402b) + (b2 < 0 ? 128 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(i2 < 16 ? "0" : "");
        sb.append(Integer.toHexString(i2).toLowerCase());
        return sb.toString();
    }

    /* renamed from: b */
    public static String m13877b(String str) {
        return m13875a(str).subSequence(8, 24).toString();
    }

    /* renamed from: a */
    public static String m13875a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            messageDigest.update(str.getBytes(), 0, str.length());
            for (byte b2 : messageDigest.digest()) {
                stringBuffer.append(m13874a(b2));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m13876a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}
