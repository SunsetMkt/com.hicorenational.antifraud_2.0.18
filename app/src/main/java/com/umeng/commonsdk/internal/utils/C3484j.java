package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3336at;

/* compiled from: UMInternalUtils.java */
/* renamed from: com.umeng.commonsdk.internal.utils.j */
/* loaded from: classes2.dex */
public class C3484j {

    /* renamed from: a */
    private static final String f12668a = C3336at.m10865b().m10868b(C3336at.f11504r);

    /* renamed from: b */
    private static final String f12669b = "um_common_strength";

    /* renamed from: c */
    private static final String f12670c = "um_common_battery";

    /* renamed from: a */
    public static String m11664a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f12668a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f12670c, null);
    }

    /* renamed from: a */
    public static void m11665a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f12668a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f12670c, str).commit();
    }
}
