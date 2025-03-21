package com.heytap.mcssdk.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
public class h {

    /* renamed from: d, reason: collision with root package name */
    private static final String f5908d = "shared_msg_sdk";

    /* renamed from: e, reason: collision with root package name */
    private static final String f5909e = "hasDefaultChannelCreated";

    /* renamed from: f, reason: collision with root package name */
    private static final String f5910f = "decryptTag";

    /* renamed from: a, reason: collision with root package name */
    private Context f5911a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f5912b;

    /* renamed from: c, reason: collision with root package name */
    private Object f5913c;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static h f5914a = new h();

        private b() {
        }
    }

    private h() {
        this.f5913c = new Object();
        Context k2 = com.heytap.mcssdk.a.w().k();
        if (k2 != null) {
            this.f5911a = a(k2);
        }
        Context context = this.f5911a;
        if (context != null) {
            this.f5912b = context.getSharedPreferences(f5908d, 0);
        }
    }

    private Context a(Context context) {
        boolean a2 = d.a();
        g.b("fbeVersion is " + a2);
        return (!a2 || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    public static h c() {
        return b.f5914a;
    }

    private SharedPreferences d() {
        SharedPreferences sharedPreferences = this.f5912b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f5913c) {
            if (this.f5912b != null || this.f5911a == null) {
                return this.f5912b;
            }
            this.f5912b = this.f5911a.getSharedPreferences(f5908d, 0);
            return this.f5912b;
        }
    }

    public void a(String str) {
        SharedPreferences d2 = d();
        if (d2 != null) {
            d2.edit().putString(f5910f, str).commit();
        }
    }

    public void a(boolean z) {
        SharedPreferences d2 = d();
        if (d2 != null) {
            d2.edit().putBoolean(f5909e, z).commit();
        }
    }

    public boolean a() {
        SharedPreferences d2 = d();
        if (d2 != null) {
            return d2.getBoolean(f5909e, false);
        }
        return false;
    }

    public String b() {
        SharedPreferences d2 = d();
        return d2 != null ? d2.getString(f5910f, "DES") : "DES";
    }
}
