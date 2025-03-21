package com.huawei.hms.framework.common;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class SystemPropUtils {
    private static final String TAG = "SystemPropUtils";

    public static String getProperty(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            Logger.m6803w(TAG, "reflect class for method has exception.");
            return str4;
        }
        try {
            Class<?> cls = Class.forName(str3);
            return (String) cls.getMethod(str, String.class, String.class).invoke(cls, str2, str4);
        } catch (Exception e2) {
            Logger.m6797e(TAG, "getProperty catch exception: ", e2);
            return str4;
        }
    }
}
