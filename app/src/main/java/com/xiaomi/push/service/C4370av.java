package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.C3393cw;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.xiaomi.push.service.av */
/* loaded from: classes2.dex */
public class C4370av {

    /* renamed from: a */
    private static RSAPublicKey f16649a;

    /* renamed from: a */
    private static final byte[] f16650a = {48, -127, -97, 48, C3393cw.f11871k, 6, 9, 42, -122, 72, -122, -9, C3393cw.f11871k, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -109, -38, -114, 26, -72, 78, C3393cw.f11874n, 70, -90, 113, -30, 36, 85, -3, -43, 123, 61, -98, 4, -16, 67, 19, -90, -73, -5, -89, 36, 44, -27, 59, -123, 72, -73, -48, 49, C3393cw.f11871k, C3393cw.f11874n, 50, -27, -82, 18, -28, 84, 0, -41, C3393cw.f11874n, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, 98, 33, 123, -34, -49, 111, -11, 49, 28, 117, -74, 114, -122, -29, -84, 82, 22, -122, 42, -40, -79, 18, -116, -42, 101, -70, 44, 11, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, 34, 121, 69, 10, -81, -57, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, 29, 47, -24, 110, -66, -7, 87, C3393cw.f11874n, -125, -91, -43, -103, 67, -20, 41, 117, -37, -11, 2, 3, 1, 0, 1};

    static {
        try {
            f16649a = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(f16650a));
        } catch (Throwable unused) {
            AbstractC4022b.m13361d("rsa key pair init failure!!!");
        }
    }

    /* renamed from: a */
    public static String m16012a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, f16649a);
            return Base64.encodeToString(m16013a(cipher, 1, str.getBytes("UTF-8"), f16649a.getModulus().bitLength()), 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m16013a(Cipher cipher, int i2, byte[] bArr, int i3) {
        int i4;
        byte[] doFinal;
        if (cipher == null || bArr == null) {
            return null;
        }
        if (i2 == 2) {
            i4 = i3 / 8;
        } else {
            i4 = (i3 / 8) - 11;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i5 = 0;
            int i6 = 0;
            while (bArr.length > i5) {
                if (bArr.length - i5 > i4) {
                    doFinal = cipher.doFinal(bArr, i5, i4);
                } else {
                    doFinal = cipher.doFinal(bArr, i5, bArr.length - i5);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i6++;
                i5 = i6 * i4;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
