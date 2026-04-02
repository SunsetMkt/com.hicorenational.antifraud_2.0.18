package com.heytap.mcssdk.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f3958d = "shared_msg_sdk";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f3959e = "hasDefaultChannelCreated";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f3960f = "decryptTag";
    private Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f3961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f3962c;

    private static class b {
        static h a = new h();

        private b() {
        }
    }

    private h() {
        this.f3962c = new Object();
        Context contextK = com.heytap.mcssdk.a.w().k();
        if (contextK != null) {
            this.a = a(contextK);
        }
        Context context = this.a;
        if (context != null) {
            this.f3961b = context.getSharedPreferences(f3958d, 0);
        }
    }

    private Context a(Context context) {
        boolean zA = d.a();
        g.b("fbeVersion is " + zA);
        return (!zA || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    public static h c() {
        return b.a;
    }

    private SharedPreferences d() {
        SharedPreferences sharedPreferences = this.f3961b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f3962c) {
            if (this.f3961b != null || this.a == null) {
                return this.f3961b;
            }
            this.f3961b = this.a.getSharedPreferences(f3958d, 0);
            return this.f3961b;
        }
    }

    public void a(String str) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            sharedPreferencesD.edit().putString(f3960f, str).commit();
        }
    }

    public void a(boolean z) {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            sharedPreferencesD.edit().putBoolean(f3959e, z).commit();
        }
    }

    public boolean a() {
        SharedPreferences sharedPreferencesD = d();
        if (sharedPreferencesD != null) {
            return sharedPreferencesD.getBoolean(f3959e, false);
        }
        return false;
    }

    public String b() {
        SharedPreferences sharedPreferencesD = d();
        return sharedPreferencesD != null ? sharedPreferencesD.getString(f3960f, "DES") : "DES";
    }
}
