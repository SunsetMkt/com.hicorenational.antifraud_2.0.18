package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.alibaba.sdk.android.httpdns.b */
/* loaded from: classes.dex */
public class C1503b {

    /* renamed from: a */
    private static SharedPreferences f3846a = null;

    /* renamed from: a */
    private static boolean f3847a = true;

    /* renamed from: b */
    private static boolean f3848b = true;

    /* renamed from: a */
    static void m3426a(Context context) {
        if (context != null) {
            f3846a = context.getSharedPreferences("httpdns_config_enable", 0);
            SharedPreferences sharedPreferences = f3846a;
            if (sharedPreferences != null) {
                f3847a = sharedPreferences.getBoolean("key_enable", true);
            }
        }
    }

    /* renamed from: a */
    public static void m3427a(boolean z) {
        f3847a = z;
        SharedPreferences sharedPreferences = f3846a;
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("key_enable", z);
            edit.apply();
        }
    }

    /* renamed from: a */
    public static boolean m3428a() {
        return f3847a && f3848b;
    }

    /* renamed from: b */
    public static void m3429b(boolean z) {
        f3848b = z;
    }
}
