package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String a = "aegis";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f5221b;

    public static long a(String str, long j2, Context context) {
        return b(context).getLong(str, j2);
    }

    public static synchronized SharedPreferences b(Context context) {
        if (f5221b == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                f5221b = context.createDeviceProtectedStorageContext().getSharedPreferences(a, 0);
            } else {
                f5221b = context.getApplicationContext().getSharedPreferences(a, 0);
            }
        }
        return f5221b;
    }

    public static int a(String str, int i2, Context context) {
        return b(context).getInt(str, i2);
    }

    public static String a(String str, String str2, Context context) {
        return b(context).getString(str, str2);
    }

    public static void a(String str, Context context) {
        b(context).edit().remove(str).apply();
    }

    public static void a(Context context) {
        b(context).edit().clear().apply();
    }

    public static void b(String str, long j2, Context context) {
        b(context).edit().putLong(str, j2).apply();
    }

    public static void b(String str, int i2, Context context) {
        b(context).edit().putInt(str, i2).apply();
    }

    public static void b(String str, String str2, Context context) {
        b(context).edit().putString(str, str2).apply();
    }
}
