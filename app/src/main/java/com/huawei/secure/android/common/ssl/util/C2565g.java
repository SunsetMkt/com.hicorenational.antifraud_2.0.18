package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: com.huawei.secure.android.common.ssl.util.g */
/* loaded from: classes.dex */
public class C2565g {

    /* renamed from: a */
    private static final String f8248a = "aegis";

    /* renamed from: b */
    private static SharedPreferences f8249b;

    /* renamed from: a */
    public static long m7993a(String str, long j2, Context context) {
        return m7997b(context).getLong(str, j2);
    }

    /* renamed from: b */
    public static synchronized SharedPreferences m7997b(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (C2565g.class) {
            if (f8249b == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    f8249b = context.createDeviceProtectedStorageContext().getSharedPreferences(f8248a, 0);
                } else {
                    f8249b = context.getApplicationContext().getSharedPreferences(f8248a, 0);
                }
            }
            sharedPreferences = f8249b;
        }
        return sharedPreferences;
    }

    /* renamed from: a */
    public static int m7992a(String str, int i2, Context context) {
        return m7997b(context).getInt(str, i2);
    }

    /* renamed from: a */
    public static String m7994a(String str, String str2, Context context) {
        return m7997b(context).getString(str, str2);
    }

    /* renamed from: a */
    public static void m7996a(String str, Context context) {
        m7997b(context).edit().remove(str).apply();
    }

    /* renamed from: a */
    public static void m7995a(Context context) {
        m7997b(context).edit().clear().apply();
    }

    /* renamed from: b */
    public static void m7999b(String str, long j2, Context context) {
        m7997b(context).edit().putLong(str, j2).apply();
    }

    /* renamed from: b */
    public static void m7998b(String str, int i2, Context context) {
        m7997b(context).edit().putInt(str, i2).apply();
    }

    /* renamed from: b */
    public static void m8000b(String str, String str2, Context context) {
        m7997b(context).edit().putString(str, str2).apply();
    }
}
