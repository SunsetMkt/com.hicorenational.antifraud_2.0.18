package com.huawei.hms.framework.network.grs.p178h;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import p286h.C5230f1;

/* renamed from: com.huawei.hms.framework.network.grs.h.b */
/* loaded from: classes.dex */
public class C2383b {

    /* renamed from: a */
    private static final String f7439a = "b";

    /* renamed from: b */
    private static final Pattern f7440b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: a */
    public static String m6976a(String str) {
        return m6977a(str, "SHA-256");
    }

    /* renamed from: a */
    private static String m6977a(String str, String str2) {
        String str3;
        String str4;
        try {
        } catch (UnsupportedEncodingException unused) {
            str3 = f7439a;
            str4 = "encrypt UnsupportedEncodingException";
        }
        try {
            return m6978a(MessageDigest.getInstance(str2).digest(str.getBytes("UTF-8")));
        } catch (NoSuchAlgorithmException unused2) {
            str3 = f7439a;
            str4 = "encrypt NoSuchAlgorithmException";
            Logger.m6803w(str3, str4);
            return null;
        }
    }

    /* renamed from: a */
    private static String m6978a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & C5230f1.f20085c);
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m6979b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i2 = 1;
        if (str.length() == 1) {
            return "*";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < str.length(); i3++) {
            String str2 = str.charAt(i3) + "";
            if (f7440b.matcher(str2).matches()) {
                if (i2 % 2 == 0) {
                    str2 = "*";
                }
                i2++;
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }
}
