package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.util.Locale;
import p286h.p323z2.C5736h0;

/* loaded from: classes.dex */
public class EncodeUtil {

    /* renamed from: a */
    private static final String f8258a = "EncodeUtil";

    /* renamed from: b */
    private static final char[] f8259b = {',', '.', '-', '_'};

    /* renamed from: c */
    private static final String[] f8260c = new String[256];

    static {
        for (char c2 = 0; c2 < 255; c2 = (char) (c2 + 1)) {
            if ((c2 < '0' || c2 > '9') && ((c2 < 'A' || c2 > 'Z') && (c2 < 'a' || c2 > 'z'))) {
                f8260c[c2] = m8009b(c2).intern();
            } else {
                f8260c[c2] = null;
            }
        }
    }

    /* renamed from: a */
    private static String m8007a(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(m8006a(cArr, Character.valueOf(str.charAt(i2))));
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m8009b(char c2) {
        return Integer.toHexString(c2);
    }

    public static String decodeForJavaScript(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            C2569a c2569a = new C2569a(str);
            while (c2569a.m8062a()) {
                Character m8004a = m8004a(c2569a);
                if (m8004a != null) {
                    sb.append(m8004a);
                } else {
                    sb.append(c2569a.m8066d());
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            String str2 = "decode js: " + e2.getMessage();
            return "";
        }
    }

    public static String encodeForJavaScript(String str) {
        return encodeForJavaScript(str, f8259b);
    }

    public static String encodeForJavaScript(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return m8007a(cArr, str);
        } catch (Exception e2) {
            String str2 = "encode js: " + e2.getMessage();
            return "";
        }
    }

    /* renamed from: a */
    private static String m8006a(char[] cArr, Character ch) {
        if (m8008a(ch.charValue(), cArr)) {
            return "" + ch;
        }
        if (m8005a(ch.charValue()) == null) {
            return "" + ch;
        }
        String hexString = Integer.toHexString(ch.charValue());
        if (ch.charValue() < 256) {
            return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
        return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
    }

    /* renamed from: a */
    private static boolean m8008a(char c2, char[] cArr) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static String m8005a(char c2) {
        if (c2 < 255) {
            return f8260c[c2];
        }
        return m8009b(c2);
    }

    /* renamed from: a */
    private static Character m8004a(C2569a c2569a) {
        c2569a.m8065c();
        Character m8066d = c2569a.m8066d();
        if (m8066d == null) {
            c2569a.m8071i();
            return null;
        }
        if (m8066d.charValue() != '\\') {
            c2569a.m8071i();
            return null;
        }
        Character m8066d2 = c2569a.m8066d();
        if (m8066d2 == null) {
            c2569a.m8071i();
            return null;
        }
        if (m8066d2.charValue() == 'b') {
            return '\b';
        }
        if (m8066d2.charValue() == 't') {
            return '\t';
        }
        if (m8066d2.charValue() == 'n') {
            return '\n';
        }
        if (m8066d2.charValue() == 'v') {
            return (char) 11;
        }
        if (m8066d2.charValue() == 'f') {
            return '\f';
        }
        if (m8066d2.charValue() == 'r') {
            return '\r';
        }
        if (m8066d2.charValue() == '\"') {
            return Character.valueOf(C5736h0.f20712a);
        }
        if (m8066d2.charValue() == '\'') {
            return '\'';
        }
        if (m8066d2.charValue() == '\\') {
            return '\\';
        }
        int i2 = 0;
        if (Character.toLowerCase(m8066d2.charValue()) == 'x') {
            StringBuilder sb = new StringBuilder();
            while (i2 < 2) {
                Character m8067e = c2569a.m8067e();
                if (m8067e != null) {
                    sb.append(m8067e);
                    i2++;
                } else {
                    c2569a.m8071i();
                    return null;
                }
            }
            try {
                int parseInt = Integer.parseInt(sb.toString(), 16);
                if (Character.isValidCodePoint(parseInt)) {
                    return Character.valueOf((char) parseInt);
                }
            } catch (NumberFormatException unused) {
                c2569a.m8071i();
                return null;
            }
        } else if (Character.toLowerCase(m8066d2.charValue()) == 'u') {
            StringBuilder sb2 = new StringBuilder();
            while (i2 < 4) {
                Character m8067e2 = c2569a.m8067e();
                if (m8067e2 != null) {
                    sb2.append(m8067e2);
                    i2++;
                } else {
                    c2569a.m8071i();
                    return null;
                }
            }
            try {
                int parseInt2 = Integer.parseInt(sb2.toString(), 16);
                if (Character.isValidCodePoint(parseInt2)) {
                    return Character.valueOf((char) parseInt2);
                }
            } catch (NumberFormatException unused2) {
                c2569a.m8071i();
                return null;
            }
        } else if (C2569a.m8060c(m8066d2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m8066d2);
            Character m8066d3 = c2569a.m8066d();
            if (!C2569a.m8060c(m8066d3)) {
                c2569a.m8061a(m8066d3);
            } else {
                sb3.append(m8066d3);
                Character m8066d4 = c2569a.m8066d();
                if (!C2569a.m8060c(m8066d4)) {
                    c2569a.m8061a(m8066d4);
                } else {
                    sb3.append(m8066d4);
                }
            }
            try {
                int parseInt3 = Integer.parseInt(sb3.toString(), 8);
                if (Character.isValidCodePoint(parseInt3)) {
                    return Character.valueOf((char) parseInt3);
                }
            } catch (NumberFormatException unused3) {
                c2569a.m8071i();
                return null;
            }
        }
        return m8066d2;
    }
}
