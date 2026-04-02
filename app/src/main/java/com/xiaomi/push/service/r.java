package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    private static r a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f1069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<String> f1070a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f9416b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f9417c = new ArrayList();

    private r(Context context) {
        this.f1069a = context.getApplicationContext();
        if (this.f1069a == null) {
            this.f1069a = context;
        }
        SharedPreferences sharedPreferences = this.f1069a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f1070a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f9416b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f9417c.add(str3);
            }
        }
    }

    public static r a(Context context) {
        if (a == null) {
            a = new r(context);
        }
        return a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m744b(String str) {
        boolean zContains;
        synchronized (this.f9416b) {
            zContains = this.f9416b.contains(str);
        }
        return zContains;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m745c(String str) {
        boolean zContains;
        synchronized (this.f9417c) {
            zContains = this.f9417c.contains(str);
        }
        return zContains;
    }

    public void d(String str) {
        synchronized (this.f1070a) {
            if (this.f1070a.contains(str)) {
                this.f1070a.remove(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bb.a(this.f1070a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f9416b) {
            if (this.f9416b.contains(str)) {
                this.f9416b.remove(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bb.a(this.f9416b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f9417c) {
            if (this.f9417c.contains(str)) {
                this.f9417c.remove(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bb.a(this.f9417c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m743a(String str) {
        boolean zContains;
        synchronized (this.f1070a) {
            zContains = this.f1070a.contains(str);
        }
        return zContains;
    }

    public void b(String str) {
        synchronized (this.f9416b) {
            if (!this.f9416b.contains(str)) {
                this.f9416b.add(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.bb.a(this.f9416b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void c(String str) {
        synchronized (this.f9417c) {
            if (!this.f9417c.contains(str)) {
                this.f9417c.add(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.bb.a(this.f9417c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void a(String str) {
        synchronized (this.f1070a) {
            if (!this.f1070a.contains(str)) {
                this.f1070a.add(str);
                this.f1069a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.bb.a(this.f1070a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
