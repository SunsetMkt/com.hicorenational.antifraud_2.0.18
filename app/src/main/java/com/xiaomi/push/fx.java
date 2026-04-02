package com.xiaomi.push;

import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class fx {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final char[] f541a = "&quot;".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f9037b = "&apos;".toCharArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f9038c = "&amp;".toCharArray();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f9039d = "&lt;".toCharArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f9040e = "&gt;".toCharArray();
    private static Random a = new Random();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static char[] f9041f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (((double) length) * 1.3d));
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c2 = charArray[i2];
            if (c2 <= '>') {
                if (c2 == '<') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f9039d);
                } else if (c2 == '>') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f9040e);
                } else if (c2 == '&') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    int i4 = i2 + 5;
                    if (length <= i4 || charArray[i2 + 1] != '#' || !Character.isDigit(charArray[i2 + 2]) || !Character.isDigit(charArray[i2 + 3]) || !Character.isDigit(charArray[i2 + 4]) || charArray[i4] != ';') {
                        i3 = i2 + 1;
                        sb.append(f9038c);
                    }
                } else if (c2 == '\"') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f541a);
                } else if (c2 == '\'') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f9037b);
                }
            }
            i2++;
        }
        if (i3 == 0) {
            return str;
        }
        if (i2 > i3) {
            sb.append(charArray, i3, i2 - i3);
        }
        return sb.toString();
    }

    public static final String b(String str) {
        return a(a(a(a(a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }

    public static final String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(str2, 0);
        if (iIndexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, iIndexOf);
        sb.append(charArray2);
        int i2 = iIndexOf + length;
        while (true) {
            int iIndexOf2 = str.indexOf(str2, i2);
            if (iIndexOf2 > 0) {
                sb.append(charArray, i2, iIndexOf2 - i2);
                sb.append(charArray2);
                i2 = iIndexOf2 + length;
            } else {
                sb.append(charArray, i2, charArray.length - i2);
                return sb.toString();
            }
        }
    }

    public static String a(byte[] bArr) {
        return String.valueOf(ay.a(bArr));
    }

    public static String a(int i2) {
        if (i2 < 1) {
            return null;
        }
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < cArr.length; i3++) {
            cArr[i3] = f9041f[a.nextInt(71)];
        }
        return new String(cArr);
    }
}
