package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* renamed from: com.hihonor.push.sdk.h1 */
/* loaded from: classes.dex */
public class C2207h1 {

    /* renamed from: a */
    public final SharedPreferences f6789a;

    public C2207h1(Context context, String str) {
        if (context == null) {
            throw new NullPointerException("context is null!");
        }
        if (Build.VERSION.SDK_INT < 24) {
            this.f6789a = context.getSharedPreferences(str, 0);
            return;
        }
        Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
        if (createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str) & (!sharedPreferences.getBoolean(str, false))) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, true);
            edit.apply();
        }
        this.f6789a = createDeviceProtectedStorageContext.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public boolean m6389a(String str, String str2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f6789a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.putString(str, str2).commit();
    }

    /* renamed from: a */
    public boolean m6388a(String str) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = this.f6789a;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return false;
        }
        return edit.remove(str).commit();
    }
}
