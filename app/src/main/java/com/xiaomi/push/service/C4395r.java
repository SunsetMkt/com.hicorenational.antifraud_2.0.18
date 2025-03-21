package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4100bb;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.r */
/* loaded from: classes2.dex */
public class C4395r {

    /* renamed from: a */
    private static C4395r f16762a;

    /* renamed from: a */
    private Context f16763a;

    /* renamed from: a */
    private List<String> f16764a = new ArrayList();

    /* renamed from: b */
    private final List<String> f16765b = new ArrayList();

    /* renamed from: c */
    private final List<String> f16766c = new ArrayList();

    private C4395r(Context context) {
        this.f16763a = context.getApplicationContext();
        if (this.f16763a == null) {
            this.f16763a = context;
        }
        SharedPreferences sharedPreferences = this.f16763a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f16764a.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f16765b.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f16766c.add(str3);
            }
        }
    }

    /* renamed from: a */
    public static C4395r m16214a(Context context) {
        if (f16762a == null) {
            f16762a = new C4395r(context);
        }
        return f16762a;
    }

    /* renamed from: b */
    public boolean m16218b(String str) {
        boolean contains;
        synchronized (this.f16765b) {
            contains = this.f16765b.contains(str);
        }
        return contains;
    }

    /* renamed from: c */
    public boolean m16220c(String str) {
        boolean contains;
        synchronized (this.f16766c) {
            contains = this.f16766c.contains(str);
        }
        return contains;
    }

    /* renamed from: d */
    public void m16221d(String str) {
        synchronized (this.f16764a) {
            if (this.f16764a.contains(str)) {
                this.f16764a.remove(str);
                this.f16763a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C4100bb.m13881a(this.f16764a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: e */
    public void m16222e(String str) {
        synchronized (this.f16765b) {
            if (this.f16765b.contains(str)) {
                this.f16765b.remove(str);
                this.f16763a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", C4100bb.m13881a(this.f16765b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: f */
    public void m16223f(String str) {
        synchronized (this.f16766c) {
            if (this.f16766c.contains(str)) {
                this.f16766c.remove(str);
                this.f16763a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", C4100bb.m13881a(this.f16766c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: a */
    public boolean m16216a(String str) {
        boolean contains;
        synchronized (this.f16764a) {
            contains = this.f16764a.contains(str);
        }
        return contains;
    }

    /* renamed from: b */
    public void m16217b(String str) {
        synchronized (this.f16765b) {
            if (!this.f16765b.contains(str)) {
                this.f16765b.add(str);
                this.f16763a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", C4100bb.m13881a(this.f16765b, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: c */
    public void m16219c(String str) {
        synchronized (this.f16766c) {
            if (!this.f16766c.contains(str)) {
                this.f16766c.add(str);
                this.f16763a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", C4100bb.m13881a(this.f16766c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: a */
    public void m16215a(String str) {
        synchronized (this.f16764a) {
            if (!this.f16764a.contains(str)) {
                this.f16764a.add(str);
                this.f16763a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C4100bb.m13881a(this.f16764a, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
