package com.sina.weibo.sdk.p194b;

import com.umeng.analytics.pro.C3393cw;
import java.security.MessageDigest;

/* renamed from: com.sina.weibo.sdk.b.d */
/* loaded from: classes.dex */
public final class C2926d {

    /* renamed from: aj */
    private static final char[] f9304aj = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static String m8839a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[32];
            int i2 = 0;
            for (int i3 = 0; i3 < 16; i3++) {
                byte b2 = digest[i3];
                int i4 = i2 + 1;
                cArr[i2] = f9304aj[(b2 >>> 4) & 15];
                i2 = i4 + 1;
                cArr[i4] = f9304aj[b2 & C3393cw.f11873m];
            }
            return new String(cArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public static String m8840f(String str) {
        try {
            return m8839a(str.getBytes());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
