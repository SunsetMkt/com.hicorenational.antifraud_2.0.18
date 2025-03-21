package com.huawei.secure.android.common.anonymization;

/* renamed from: com.huawei.secure.android.common.anonymization.a */
/* loaded from: classes.dex */
public class C2545a {
    /* renamed from: a */
    public static String[] m7824a(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        }
        if (strArr2.length <= 0) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    /* renamed from: b */
    public static String[] m7826b(String str, String[] strArr) {
        return m7824a(new String[]{str}, strArr);
    }

    /* renamed from: b */
    public static String[] m7825b(String str, char c2) {
        if (str == null) {
            return new String[0];
        }
        if (str.length() <= 0) {
            return new String[]{str};
        }
        int i2 = 1;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == c2) {
                i2++;
            }
        }
        if (i2 <= 1) {
            return new String[]{str};
        }
        String[] strArr = new String[i2];
        StringBuilder sb = new StringBuilder(str.length());
        int i4 = 0;
        for (int i5 = 0; i5 < str.length() && i4 < i2; i5++) {
            char charAt = str.charAt(i5);
            if (charAt == c2) {
                strArr[i4] = sb.toString();
                sb.setLength(0);
                i4++;
            } else {
                sb.append(charAt);
            }
        }
        strArr[i4] = sb.toString();
        return strArr;
    }

    /* renamed from: a */
    public static String[] m7823a(String[] strArr, String str) {
        return m7824a(strArr, new String[]{str});
    }

    /* renamed from: a */
    public static String[] m7820a(String str, int i2, int i3) {
        String[] m7819a = m7819a(str, i2);
        return m7826b(m7818a(m7819a, 0), m7819a(m7818a(m7819a, 1), i3 - i2));
    }

    /* renamed from: a */
    public static String[] m7821a(String str, int i2, int i3, int i4) {
        String[] m7819a = m7819a(str, i2);
        return m7826b(m7818a(m7819a, 0), m7820a(m7818a(m7819a, 1), i3 - i2, i4 - i2));
    }

    /* renamed from: a */
    public static String[] m7822a(String str, int... iArr) {
        if (str == null) {
            return new String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new String[]{str};
        }
        if (iArr.length <= 1) {
            return m7819a(str, iArr[0]);
        }
        int i2 = iArr[0];
        int[] iArr2 = new int[iArr.length - 1];
        int i3 = 0;
        while (i3 < iArr2.length) {
            int i4 = i3 + 1;
            iArr2[i3] = iArr[i4] - i2;
            i3 = i4;
        }
        String[] m7819a = m7819a(str, i2);
        return m7826b(m7818a(m7819a, 0), m7822a(m7818a(m7819a, 1), iArr2));
    }

    /* renamed from: a */
    public static String[] m7819a(String str, int i2) {
        if (str == null) {
            return new String[]{"", ""};
        }
        return (i2 < 0 || i2 > str.length()) ? new String[]{str, ""} : new String[]{str.substring(0, i2), str.substring(i2)};
    }

    /* renamed from: a */
    public static String m7817a(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i2 = 1; i2 < strArr.length; i2++) {
            if (strArr[i2] != null) {
                sb.append(str);
                sb.append(strArr[i2]);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m7816a(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            int lastIndexOf = str2.lastIndexOf(c2);
            if (lastIndexOf < 0) {
                cArr[i2] = c2;
            } else {
                cArr[i2] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m7818a(String[] strArr, int i2) {
        return (strArr == null || strArr.length <= 0 || i2 < 0 || i2 >= strArr.length) ? "" : strArr[i2];
    }

    /* renamed from: a */
    public static String m7815a(String str, char c2) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        char[] cArr = new char[str.length()];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = c2;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static int m7814a(String str, char c2, int i2) {
        int length = str.length() - 1;
        while (length >= 0 && (str.charAt(length) != c2 || i2 - 1 > 0)) {
            length--;
        }
        return length;
    }
}
