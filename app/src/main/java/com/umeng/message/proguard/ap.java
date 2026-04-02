package com.umeng.message.proguard;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ap {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ap f7998b;
    public final SharedPreferences a = x.a().getSharedPreferences("umeng_push", 0);

    private ap() {
    }

    public static ap a() {
        if (f7998b == null) {
            synchronized (ap.class) {
                if (f7998b == null) {
                    f7998b = new ap();
                }
            }
        }
        return f7998b;
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.edit().putString(str, str2).apply();
    }

    public final void a(String str) {
        if (this.a.contains(str)) {
            this.a.edit().remove(str).apply();
        }
    }
}
