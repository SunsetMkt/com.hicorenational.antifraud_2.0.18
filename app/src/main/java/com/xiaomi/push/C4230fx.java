package com.xiaomi.push;

import java.util.Random;

/* renamed from: com.xiaomi.push.fx */
/* loaded from: classes2.dex */
public class C4230fx {

    /* renamed from: a */
    private static final char[] f15415a = "&quot;".toCharArray();

    /* renamed from: b */
    private static final char[] f15416b = "&apos;".toCharArray();

    /* renamed from: c */
    private static final char[] f15417c = "&amp;".toCharArray();

    /* renamed from: d */
    private static final char[] f15418d = "&lt;".toCharArray();

    /* renamed from: e */
    private static final char[] f15419e = "&gt;".toCharArray();

    /* renamed from: a */
    private static Random f15414a = new Random();

    /* renamed from: f */
    private static char[] f15420f = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: a */
    public static String m14901a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder((int) (length * 1.3d));
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
                    sb.append(f15418d);
                } else if (c2 == '>') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f15419e);
                } else if (c2 == '&') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    int i4 = i2 + 5;
                    if (length <= i4 || charArray[i2 + 1] != '#' || !Character.isDigit(charArray[i2 + 2]) || !Character.isDigit(charArray[i2 + 3]) || !Character.isDigit(charArray[i2 + 4]) || charArray[i4] != ';') {
                        i3 = i2 + 1;
                        sb.append(f15417c);
                    }
                } else if (c2 == '\"') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f15415a);
                } else if (c2 == '\'') {
                    if (i2 > i3) {
                        sb.append(charArray, i3, i2 - i3);
                    }
                    i3 = i2 + 1;
                    sb.append(f15416b);
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

    /* renamed from: b */
    public static final String m14904b(String str) {
        return m14902a(m14902a(m14902a(m14902a(m14902a(str, "&lt;", "<"), "&gt;", ">"), "&quot;", "\""), "&apos;", "'"), "&amp;", "&");
    }

    /* renamed from: a */
    public static final String m14902a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(str2, 0);
        if (indexOf < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] charArray2 = str3.toCharArray();
        int length = str2.length();
        StringBuilder sb = new StringBuilder(charArray.length);
        sb.append(charArray, 0, indexOf);
        sb.append(charArray2);
        int i2 = indexOf + length;
        while (true) {
            int indexOf2 = str.indexOf(str2, i2);
            if (indexOf2 > 0) {
                sb.append(charArray, i2, indexOf2 - i2);
                sb.append(charArray2);
                i2 = indexOf2 + length;
            } else {
                sb.append(charArray, i2, charArray.length - i2);
                return sb.toString();
            }
        }
    }

    /* renamed from: a */
    public static String m14903a(byte[] bArr) {
        return String.valueOf(C4096ay.m13843a(bArr));
    }

    /* renamed from: a */
    public static String m14900a(int i2) {
        if (i2 < 1) {
            return null;
        }
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < cArr.length; i3++) {
            cArr[i3] = f15420f[f15414a.nextInt(71)];
        }
        return new String(cArr);
    }
}
