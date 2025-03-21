package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import h.z2.h0;
import java.util.Locale;

/* loaded from: classes.dex */
public class EncodeUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7676a = "EncodeUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f7677b = {',', '.', '-', '_'};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f7678c = new String[256];

    static {
        for (char c2 = 0; c2 < 255; c2 = (char) (c2 + 1)) {
            if ((c2 < '0' || c2 > '9') && ((c2 < 'A' || c2 > 'Z') && (c2 < 'a' || c2 > 'z'))) {
                f7678c[c2] = b(c2).intern();
            } else {
                f7678c[c2] = null;
            }
        }
    }

    private static String a(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(a(cArr, Character.valueOf(str.charAt(i2))));
        }
        return sb.toString();
    }

    private static String b(char c2) {
        return Integer.toHexString(c2);
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            a aVar = new a(str);
            while (aVar.a()) {
                Character a2 = a(aVar);
                if (a2 != null) {
                    sb.append(a2);
                } else {
                    sb.append(aVar.d());
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            String str2 = "decode js: " + e2.getMessage();
            return "";
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, f7677b);
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return a(cArr, str);
        } catch (Exception e2) {
            String str2 = "encode js: " + e2.getMessage();
            return "";
        }
    }

    private static String a(char[] cArr, Character ch) {
        if (a(ch.charValue(), cArr)) {
            return "" + ch;
        }
        if (a(ch.charValue()) == null) {
            return "" + ch;
        }
        String hexString = Integer.toHexString(ch.charValue());
        if (ch.charValue() < 256) {
            return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
        return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
    }

    private static boolean a(char c2, char[] cArr) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    private static String a(char c2) {
        if (c2 < 255) {
            return f7678c[c2];
        }
        return b(c2);
    }

    private static Character a(a aVar) {
        aVar.c();
        Character d2 = aVar.d();
        if (d2 == null) {
            aVar.i();
            return null;
        }
        if (d2.charValue() != '\\') {
            aVar.i();
            return null;
        }
        Character d3 = aVar.d();
        if (d3 == null) {
            aVar.i();
            return null;
        }
        if (d3.charValue() == 'b') {
            return '\b';
        }
        if (d3.charValue() == 't') {
            return '\t';
        }
        if (d3.charValue() == 'n') {
            return '\n';
        }
        if (d3.charValue() == 'v') {
            return (char) 11;
        }
        if (d3.charValue() == 'f') {
            return '\f';
        }
        if (d3.charValue() == 'r') {
            return '\r';
        }
        if (d3.charValue() == '\"') {
            return Character.valueOf(h0.f16704a);
        }
        if (d3.charValue() == '\'') {
            return '\'';
        }
        if (d3.charValue() == '\\') {
            return '\\';
        }
        int i2 = 0;
        if (Character.toLowerCase(d3.charValue()) == 'x') {
            StringBuilder sb = new StringBuilder();
            while (i2 < 2) {
                Character e2 = aVar.e();
                if (e2 != null) {
                    sb.append(e2);
                    i2++;
                } else {
                    aVar.i();
                    return null;
                }
            }
            try {
                int parseInt = Integer.parseInt(sb.toString(), 16);
                if (Character.isValidCodePoint(parseInt)) {
                    return Character.valueOf((char) parseInt);
                }
            } catch (NumberFormatException unused) {
                aVar.i();
                return null;
            }
        } else if (Character.toLowerCase(d3.charValue()) == 'u') {
            StringBuilder sb2 = new StringBuilder();
            while (i2 < 4) {
                Character e3 = aVar.e();
                if (e3 != null) {
                    sb2.append(e3);
                    i2++;
                } else {
                    aVar.i();
                    return null;
                }
            }
            try {
                int parseInt2 = Integer.parseInt(sb2.toString(), 16);
                if (Character.isValidCodePoint(parseInt2)) {
                    return Character.valueOf((char) parseInt2);
                }
            } catch (NumberFormatException unused2) {
                aVar.i();
                return null;
            }
        } else if (a.c(d3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(d3);
            Character d4 = aVar.d();
            if (!a.c(d4)) {
                aVar.a(d4);
            } else {
                sb3.append(d4);
                Character d5 = aVar.d();
                if (!a.c(d5)) {
                    aVar.a(d5);
                } else {
                    sb3.append(d5);
                }
            }
            try {
                int parseInt3 = Integer.parseInt(sb3.toString(), 8);
                if (Character.isValidCodePoint(parseInt3)) {
                    return Character.valueOf((char) parseInt3);
                }
            } catch (NumberFormatException unused3) {
                aVar.i();
                return null;
            }
        }
        return d3;
    }
}
