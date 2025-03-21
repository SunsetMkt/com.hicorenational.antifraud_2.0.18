package com.umeng.socialize.handler;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class UMHonorPreferences {
    private static final String KEY_AUTH = "auth";

    /* renamed from: sp */
    private final SharedPreferences f13630sp;

    public UMHonorPreferences(Context context) {
        this.f13630sp = context.getSharedPreferences("um_honor", 0);
    }

    public void delete() {
        this.f13630sp.edit().clear().apply();
    }

    public boolean isAuthed() {
        return this.f13630sp.getBoolean("auth", false);
    }

    public void setAuthed() {
        this.f13630sp.edit().putBoolean("auth", true).apply();
    }
}
