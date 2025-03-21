package com.huawei.secure.android.common.util;

/* loaded from: classes.dex */
public class SafeStringBuffer {

    /* renamed from: a */
    private static final String f8278a = "SafeStringBuffer";

    /* renamed from: b */
    private static final String f8279b = "";

    public static String substring(StringBuffer stringBuffer, int i2) {
        if (stringBuffer != null && stringBuffer.length() >= i2 && i2 >= 0) {
            try {
                return stringBuffer.substring(i2);
            } catch (Exception e2) {
                String str = "substring exception: " + e2.getMessage();
            }
        }
        return "";
    }

    public static String substring(StringBuffer stringBuffer, int i2, int i3) {
        if (stringBuffer != null && i2 >= 0 && i3 <= stringBuffer.length() && i3 >= i2) {
            try {
                return stringBuffer.substring(i2, i3);
            } catch (Exception e2) {
                String str = "substring: " + e2.getMessage();
            }
        }
        return "";
    }
}
