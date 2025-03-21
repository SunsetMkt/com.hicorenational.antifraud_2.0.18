package com.huawei.secure.android.common.util;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class SafeStringBuilder {

    /* renamed from: a */
    private static final String f8280a = "SafeStringBuilder";

    /* renamed from: b */
    private static final String f8281b = "";

    public static String substring(StringBuilder sb, int i2) {
        if (!TextUtils.isEmpty(sb) && sb.length() >= i2 && i2 >= 0) {
            try {
                return sb.substring(i2);
            } catch (Exception e2) {
                String str = "substring exception: " + e2.getMessage();
            }
        }
        return "";
    }

    public static String substring(StringBuilder sb, int i2, int i3) {
        if (!TextUtils.isEmpty(sb) && i2 >= 0 && i3 <= sb.length() && i3 >= i2) {
            try {
                return sb.substring(i2, i3);
            } catch (Exception e2) {
                String str = "substring: " + e2.getMessage();
            }
        }
        return "";
    }
}
