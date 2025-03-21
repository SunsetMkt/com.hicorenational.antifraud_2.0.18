package com.umeng.message.proguard;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* renamed from: com.umeng.message.proguard.ap */
/* loaded from: classes2.dex */
public class C3567ap {

    /* renamed from: b */
    private static volatile C3567ap f13224b;

    /* renamed from: a */
    public final SharedPreferences f13225a = C3604x.m12460a().getSharedPreferences("umeng_push", 0);

    private C3567ap() {
    }

    /* renamed from: a */
    public static C3567ap m12275a() {
        if (f13224b == null) {
            synchronized (C3567ap.class) {
                if (f13224b == null) {
                    f13224b = new C3567ap();
                }
            }
        }
        return f13224b;
    }

    /* renamed from: a */
    public final void m12277a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f13225a.edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    public final void m12276a(String str) {
        if (this.f13225a.contains(str)) {
            this.f13225a.edit().remove(str).apply();
        }
    }
}
