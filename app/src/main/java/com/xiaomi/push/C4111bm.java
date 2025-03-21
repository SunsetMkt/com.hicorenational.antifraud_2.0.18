package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.xiaomi.push.bm */
/* loaded from: classes2.dex */
public class C4111bm {

    /* renamed from: a */
    private static volatile C4111bm f14635a;

    /* renamed from: a */
    private Context f14636a;

    private C4111bm(Context context) {
        this.f14636a = context;
    }

    /* renamed from: a */
    public static C4111bm m13926a(Context context) {
        if (f14635a == null) {
            synchronized (C4111bm.class) {
                if (f14635a == null) {
                    f14635a = new C4111bm(context);
                }
            }
        }
        return f14635a;
    }

    /* renamed from: a */
    public synchronized void m13930a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f14636a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    /* renamed from: a */
    public synchronized void m13929a(String str, String str2, long j2) {
        SharedPreferences.Editor edit = this.f14636a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j2);
        edit.commit();
    }

    /* renamed from: a */
    public synchronized String m13928a(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f14636a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    /* renamed from: a */
    public synchronized long m13927a(String str, String str2, long j2) {
        try {
        } catch (Throwable unused) {
            return j2;
        }
        return this.f14636a.getSharedPreferences(str, 4).getLong(str2, j2);
    }
}
