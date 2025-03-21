package com.xiaomi.push;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/* renamed from: com.xiaomi.push.bb */
/* loaded from: classes2.dex */
public class C4100bb {
    /* renamed from: a */
    public static String m13884a(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return m13885a(objArr, str, 0, objArr.length);
    }

    /* renamed from: b */
    public static String m13888b(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(m13887a(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static String m13885a(Object[] objArr, String str, int i2, int i3) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(i4 * ((objArr[i2] == null ? 16 : objArr[i2].toString().length()) + str.length()));
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                stringBuffer.append(str);
            }
            if (objArr[i5] != null) {
                stringBuffer.append(objArr[i5]);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static String m13889b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    /* renamed from: a */
    public static String m13882a(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return next.toString();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        if (next != null) {
            stringBuffer.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                stringBuffer.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                stringBuffer.append(next2);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m13881a(Collection<?> collection, String str) {
        if (collection == null) {
            return null;
        }
        return m13882a(collection.iterator(), str);
    }

    /* renamed from: a */
    public static String m13878a(int i2) {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m13879a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(m13887a(str));
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static String m13883a(byte[] bArr) {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            str = String.format("%1$032X", new BigInteger(1, messageDigest.digest()));
        } catch (Exception unused) {
            str = "";
        }
        return str.toLowerCase();
    }

    /* renamed from: a */
    public static byte[] m13887a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* renamed from: a */
    public static boolean m13886a(String str) {
        if (str == null) {
            return true;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 0 || charAt > 127) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static String m13880a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        if (i2 <= 0 || length < i2) {
            i2 = length / 3;
            if (i2 <= 1) {
                i2 = 1;
            }
            if (i2 > 3) {
                i2 = 3;
            }
        }
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (i4 % i2 == 0) {
                sb.append("*");
            } else {
                sb.append(str.charAt(i3));
            }
            i3 = i4;
        }
        return sb.toString();
    }
}
