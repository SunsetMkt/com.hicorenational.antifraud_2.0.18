package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3336at;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: StoreHelper.java */
/* renamed from: com.umeng.commonsdk.statistics.common.d */
/* loaded from: classes2.dex */
public final class C3499d {

    /* renamed from: a */
    private static C3499d f12752a;

    /* renamed from: b */
    private static Context f12753b;

    /* renamed from: c */
    private static String f12754c;

    /* renamed from: d */
    private static final String f12755d = C3336at.m10865b().m10868b(C3336at.f11499m);

    public C3499d(Context context) {
    }

    /* renamed from: a */
    public static synchronized C3499d m11813a(Context context) {
        C3499d c3499d;
        synchronized (C3499d.class) {
            f12753b = context.getApplicationContext();
            f12754c = context.getPackageName();
            if (f12752a == null) {
                f12752a = new C3499d(context);
            }
            c3499d = f12752a;
        }
        return c3499d;
    }

    /* renamed from: f */
    private SharedPreferences m11814f() {
        return f12753b.getSharedPreferences(f12755d + f12754c, 0);
    }

    /* renamed from: b */
    public String m11819b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12753b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    /* renamed from: c */
    public boolean m11820c() {
        return UMFrUtils.envelopeFileNumber(f12753b) > 0;
    }

    /* renamed from: d */
    public String[] m11821d() {
        try {
            SharedPreferences m11814f = m11814f();
            String string = m11814f.getString("au_p", null);
            String string2 = m11814f.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: e */
    public void m11822e() {
        m11814f().edit().remove("au_p").remove("au_u").commit();
    }

    /* renamed from: a */
    public void m11816a(int i2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12753b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i2).commit();
        }
    }

    /* renamed from: a */
    public int m11815a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12753b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    /* renamed from: a */
    public void m11817a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f12753b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    /* renamed from: a */
    public void m11818a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = m11814f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }
}
