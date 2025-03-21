package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: PushClientSdkAppSp.java */
/* renamed from: com.vivo.push.util.z */
/* loaded from: classes2.dex */
public final class C4015z extends C3992c {

    /* renamed from: b */
    private Context f14282b;

    public C4015z(Context context) {
        if (context != null) {
            this.f14282b = context;
            m13317a(this.f14282b);
        }
    }

    /* renamed from: a */
    private synchronized void m13317a(Context context) {
        m13239a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    /* renamed from: b */
    public final String m13318b() {
        String obj;
        Context context = this.f14282b;
        String packageName = context.getPackageName();
        Object m13209a = C3990ag.m13209a(context, packageName, "com.vivo.push.app_id");
        if (m13209a != null) {
            obj = m13209a.toString();
        } else {
            Object m13209a2 = C3990ag.m13209a(context, packageName, "app_id");
            obj = m13209a2 != null ? m13209a2.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? m13246b("APP_APPID", "") : obj;
    }

    /* renamed from: c */
    public final String m13319c() {
        String obj;
        Context context = this.f14282b;
        String packageName = context.getPackageName();
        Object m13209a = C3990ag.m13209a(context, packageName, "com.vivo.push.api_key");
        if (m13209a != null) {
            obj = m13209a.toString();
        } else {
            Object m13209a2 = C3990ag.m13209a(context, packageName, "api_key");
            obj = m13209a2 != null ? m13209a2.toString() : "";
        }
        return TextUtils.isEmpty(obj) ? m13246b("APP_APIKEY", "") : obj;
    }
}
