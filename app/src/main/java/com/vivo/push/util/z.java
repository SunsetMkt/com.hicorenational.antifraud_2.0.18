package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: PushClientSdkAppSp.java */
/* loaded from: classes2.dex */
public final class z extends c {

    /* renamed from: b, reason: collision with root package name */
    private Context f12303b;

    public z(Context context) {
        if (context != null) {
            this.f12303b = context;
            a(this.f12303b);
        }
    }

    private synchronized void a(Context context) {
        a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    public final String b() {
        String obj;
        Context context = this.f12303b;
        String packageName = context.getPackageName();
        Object a2 = ag.a(context, packageName, "com.vivo.push.app_id");
        if (a2 != null) {
            obj = a2.toString();
        } else {
            Object a3 = ag.a(context, packageName, "app_id");
            obj = a3 != null ? a3.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? b("APP_APPID", "") : obj;
    }

    public final String c() {
        String obj;
        Context context = this.f12303b;
        String packageName = context.getPackageName();
        Object a2 = ag.a(context, packageName, "com.vivo.push.api_key");
        if (a2 != null) {
            obj = a2.toString();
        } else {
            Object a3 = ag.a(context, packageName, "api_key");
            obj = a3 != null ? a3.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? b("APP_APIKEY", "") : obj;
    }
}
