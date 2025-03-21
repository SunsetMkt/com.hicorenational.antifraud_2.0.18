package com.heytap.mcssdk.p160k;

import android.text.TextUtils;
import com.heytap.mcssdk.p154b.C2081a;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.heytap.mcssdk.k.e */
/* loaded from: classes.dex */
public class C2105e {

    /* renamed from: a */
    public static String f6246a = null;

    /* renamed from: b */
    public static final String f6247b = "Y29tLm5lYXJtZS5tY3M=";

    /* renamed from: c */
    public static String f6248c = "";

    /* renamed from: a */
    private static String m5870a() {
        if (TextUtils.isEmpty(f6248c)) {
            f6248c = new String(C2081a.m5759d(f6247b));
        }
        byte[] m5872a = m5872a(m5871a(f6248c));
        return m5872a != null ? new String(m5872a, Charset.forName("UTF-8")) : "";
    }

    /* renamed from: a */
    public static byte[] m5871a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    /* renamed from: a */
    public static byte[] m5872a(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i2 = 0; i2 < length; i2 += 2) {
            byte b2 = bArr[i2];
            int i3 = i2 + 1;
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m5873b(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = AbstractC2106f.m5876a(str, m5870a());
            C2107g.m5884b("sdkDecrypt desDecrypt des data " + str2);
            z = true;
        } catch (Exception e2) {
            C2107g.m5884b("sdkDecrypt DES excepiton " + e2.toString());
            z = false;
        }
        if (TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            f6246a = "AES";
            C2108h.m5907c().m5909a(f6246a);
            C2107g.m5884b("sdkDecrypt desDecrypt aes data " + str2);
            return str2;
        } catch (Exception e3) {
            C2107g.m5884b("sdkDecrypt AES excepiton " + e3.toString());
            return str2;
        }
    }

    /* renamed from: c */
    public static String m5874c(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            C2107g.m5884b("sdkDecrypt aesDecrypt aes data " + str2);
            z = true;
        } catch (Exception e2) {
            C2107g.m5884b("sdkDecrypt AES excepiton " + e2.toString());
            z = false;
        }
        if (TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = AbstractC2106f.m5876a(str, m5870a());
            f6246a = "DES";
            C2108h.m5907c().m5909a(f6246a);
            C2107g.m5884b("sdkDecrypt aesDecrypt des data " + str2);
            return str2;
        } catch (Exception e3) {
            C2107g.m5884b("sdkDecrypt DES excepiton " + e3.toString());
            return str2;
        }
    }

    /* renamed from: d */
    public static String m5875d(String str) {
        C2107g.m5884b("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(f6246a)) {
            f6246a = C2108h.m5907c().m5912b();
        }
        if ("DES".equals(f6246a)) {
            C2107g.m5884b("sdkDecrypt start DES");
            return m5873b(str);
        }
        C2107g.m5884b("sdkDecrypt start AES");
        return m5874c(str);
    }
}
