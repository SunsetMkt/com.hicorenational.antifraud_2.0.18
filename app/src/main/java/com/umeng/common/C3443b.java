package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.C3336at;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: SPHelper.java */
/* renamed from: com.umeng.common.b */
/* loaded from: classes2.dex */
public final class C3443b {

    /* renamed from: a */
    private static C3443b f12397a;

    /* renamed from: b */
    private static Context f12398b;

    /* renamed from: c */
    private static String f12399c;

    /* renamed from: d */
    private static final String f12400d = C3336at.m10865b().m10868b(C3336at.f11499m);

    /* compiled from: SPHelper.java */
    /* renamed from: com.umeng.common.b$a */
    private static final class a {

        /* renamed from: a */
        private static final C3443b f12401a = new C3443b();

        private a() {
        }
    }

    /* renamed from: a */
    public static synchronized C3443b m11503a(Context context) {
        C3443b c3443b;
        synchronized (C3443b.class) {
            if (f12398b == null && context != null) {
                f12398b = context.getApplicationContext();
            }
            if (f12398b != null) {
                f12399c = context.getPackageName();
            }
            c3443b = a.f12401a;
        }
        return c3443b;
    }

    /* renamed from: e */
    private SharedPreferences m11507e() {
        Context context = f12398b;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(f12400d + f12399c, 0);
    }

    /* renamed from: b */
    public void m11512b() {
        SharedPreferences m11507e = m11507e();
        if (m11507e != null) {
            m11507e.edit().remove("au_p").remove("au_u").commit();
        }
    }

    /* renamed from: c */
    public String m11513c() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12398b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    /* renamed from: d */
    public int m11514d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12398b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    /* renamed from: a */
    public void m11510a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = m11507e().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    /* renamed from: a */
    public String[] m11511a() {
        SharedPreferences m11507e = m11507e();
        if (m11507e == null) {
            return null;
        }
        String string = m11507e.getString("au_p", null);
        String string2 = m11507e.getString("au_u", null);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return null;
        }
        return new String[]{string, string2};
    }

    /* renamed from: a */
    public void m11509a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12398b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    /* renamed from: a */
    public void m11508a(int i2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12398b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i2).commit();
        }
    }

    /* renamed from: a */
    public static String m11504a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null) ? "" : sharedPreferences.getString(str2, "");
    }

    /* renamed from: a */
    public static void m11506a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(str, 0)) == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    /* renamed from: a */
    public static void m11505a(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences(str, 0).edit();
        edit.remove(AnalyticsConfig.DEBUG_KEY);
        edit.remove(AnalyticsConfig.RTD_PERIOD);
        edit.remove(AnalyticsConfig.RTD_START_TIME);
        edit.clear();
        edit.commit();
    }
}
