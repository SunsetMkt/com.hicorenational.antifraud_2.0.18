package j.a.a.a.k;

import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static byte[] a(String str) {
        return a(str, j.a.a.a.c.a);
    }

    public static byte[] b(String str) {
        return a(str, j.a.a.a.c.f12440b);
    }

    public static byte[] c(String str) {
        return a(str, j.a.a.a.c.f12441c);
    }

    public static byte[] d(String str) {
        return a(str, j.a.a.a.c.f12442d);
    }

    public static byte[] e(String str) {
        return a(str, j.a.a.a.c.f12443e);
    }

    public static byte[] f(String str) {
        return a(str, "UTF-8");
    }

    public static byte[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e2) {
            throw a(str2, e2);
        }
    }

    public static String b(byte[] bArr) {
        return a(bArr, j.a.a.a.c.f12440b);
    }

    public static String c(byte[] bArr) {
        return a(bArr, j.a.a.a.c.f12441c);
    }

    public static String d(byte[] bArr) {
        return a(bArr, j.a.a.a.c.f12442d);
    }

    public static String e(byte[] bArr) {
        return a(bArr, j.a.a.a.c.f12443e);
    }

    public static String f(byte[] bArr) {
        return a(bArr, "UTF-8");
    }

    private static IllegalStateException a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            throw a(str, e2);
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, j.a.a.a.c.a);
    }
}
