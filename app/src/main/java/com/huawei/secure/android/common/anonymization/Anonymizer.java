package com.huawei.secure.android.common.anonymization;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public class Anonymizer {

    /* renamed from: a */
    private static final String f7998a = "Anonymizer";

    public static String maskAccountId(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 1 ? "*" : str.length() < 8 ? maskCommonString(str, 0, 1) : maskCommonString(str, 0, 4);
    }

    public static String maskBankAccount(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 2 ? C2545a.m7815a(str, '*') : (str.length() < 11 || str.length() >= 20) ? maskCommonString(str, 6, 4) : maskCommonString(str, 4, 4);
    }

    public static String maskBirthday(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return C2545a.m7815a(str, '*');
        }
        String[] m7819a = C2545a.m7819a(str, 4);
        return C2545a.m7817a("", C2545a.m7818a(m7819a, 0), C2545a.m7816a(C2545a.m7818a(m7819a, 1), "0123456789", "*"));
    }

    public static String maskCommonString(String str, int i2, int i3) {
        int length;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (str.length() <= i2 + i3) {
            length = str.length() - 1;
            i2 = 1;
        } else {
            length = str.length() - i3;
        }
        String[] m7820a = C2545a.m7820a(str, i2, length);
        return C2545a.m7817a("", C2545a.m7818a(m7820a, 0), C2545a.m7815a(C2545a.m7818a(m7820a, 1), '*'), C2545a.m7818a(m7820a, 2));
    }

    public static String maskEmail(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            String[] m7819a = C2545a.m7819a(str, 1);
            return C2545a.m7817a("", C2545a.m7818a(m7819a, 0), C2545a.m7815a(C2545a.m7818a(m7819a, 1), '*'));
        }
        String[] m7821a = C2545a.m7821a(str, indexOf, indexOf + 1, str.lastIndexOf(46));
        return C2545a.m7817a("", C2545a.m7815a(C2545a.m7818a(m7821a, 0), '*'), C2545a.m7818a(m7821a, 1), C2545a.m7815a(C2545a.m7818a(m7821a, 2), '*'), C2545a.m7818a(m7821a, 3));
    }

    public static String maskId(String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 12, 0);
    }

    public static String maskImeiImsi(String str) {
        return (str == null || str.length() <= 0) ? "" : maskCommonString(str, str.length() - 4, 0);
    }

    public static String maskIpV4(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return C2545a.m7815a(str, '*');
        }
        String[] m7819a = C2545a.m7819a(str, lastIndexOf + 1);
        return C2545a.m7817a("", C2545a.m7818a(m7819a, 0), C2545a.m7815a(C2545a.m7818a(m7819a, 1), '*'));
    }

    public static String maskIpV6(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String[] m7825b = C2545a.m7825b(str, ':');
        if (m7825b.length <= 1) {
            return C2545a.m7815a(str, '*');
        }
        if (m7825b.length != 8) {
            String[] m7819a = C2545a.m7819a(str, str.indexOf(58) + 1);
            return C2545a.m7817a("", C2545a.m7818a(m7819a, 0), C2545a.m7816a(C2545a.m7818a(m7819a, 1), "0123456789ABCDEFabcdef", "*"));
        }
        m7825b[2] = maskLower8Bit(m7825b[2]);
        for (int i2 = 3; i2 < m7825b.length; i2++) {
            m7825b[i2] = C2545a.m7815a(m7825b[i2], '*');
        }
        return C2545a.m7817a(Constants.COLON_SEPARATOR, m7825b);
    }

    public static String maskLower8Bit(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.length() <= 2) {
            return C2545a.m7815a(str, '*');
        }
        String[] m7819a = C2545a.m7819a(str, str.length() - 2);
        return C2545a.m7817a("", C2545a.m7818a(m7819a, 0), C2545a.m7815a(C2545a.m7818a(m7819a, 1), '*'));
    }

    public static String maskMac(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int m7814a = C2545a.m7814a(str, '-', 2);
        if (m7814a < 0) {
            return C2545a.m7816a(str, "0123456789ABCDEFabcdef", "*");
        }
        String[] m7819a = C2545a.m7819a(str, m7814a);
        return C2545a.m7817a("", C2545a.m7818a(m7819a, 0), C2545a.m7816a(C2545a.m7818a(m7819a, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static String maskName(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 1 ? "*" : maskCommonString(str, 1, 0);
    }

    public static String maskPhone(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 2 ? C2545a.m7815a(str, '*') : (str.length() < 8 || str.length() >= 11) ? maskCommonString(str, 3, 4) : maskCommonString(str, 2, 2);
    }
}
