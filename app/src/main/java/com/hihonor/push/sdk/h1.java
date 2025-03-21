package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
public class h1 {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6290a;

    public h1(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("context is null!");
        }
        if (Build.VERSION.SDK_INT < 24) {
            this.f6290a = context.getSharedPreferences(str, 0);
            return;
        }
        Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
        if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str) & (!sharedPreferences.getBoolean(str, false))) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, true);
            edit.apply();
        }
        this.f6290a = createDeviceProtectedStorageContext.getSharedPreferences(str, 0);
    }

    public boolean a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f6290a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    public boolean a(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f6290a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }
}
