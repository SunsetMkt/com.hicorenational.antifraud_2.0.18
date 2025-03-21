package com.huawei.secure.android.common.util;

/* loaded from: classes.dex */
public class SafeString {

    /* renamed from: a */
    private static final String f8276a = "SafeString";

    /* renamed from: b */
    private static final String f8277b = "";

    public static String replace(String str, CharSequence charSequence, CharSequence charSequence2) {
        if (str != null && charSequence != null && charSequence2 != null) {
            try {
                return str.replace(charSequence, charSequence2);
            } catch (Exception e2) {
                String str2 = "replace: " + e2.getMessage();
            }
        }
        return str;
    }

    public static String substring(String str, int i2) {
        if (str != null && str.length() >= i2 && i2 >= 0) {
            try {
                return str.substring(i2);
            } catch (Exception e2) {
                String str2 = "substring exception: " + e2.getMessage();
            }
        }
        return "";
    }

    public static String substring(String str, int i2, int i3) {
        if (str != null && i2 >= 0 && i3 <= str.length() && i3 >= i2) {
            try {
                return str.substring(i2, i3);
            } catch (Exception e2) {
                String str2 = "substring: " + e2.getMessage();
            }
        }
        return "";
    }
}
