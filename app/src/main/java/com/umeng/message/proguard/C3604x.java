package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.message.common.UPLog;

/* renamed from: com.umeng.message.proguard.x */
/* loaded from: classes2.dex */
public final class C3604x {

    /* renamed from: a */
    private static Application f13388a;

    /* renamed from: a */
    public static void m12461a(Context context) {
        if (f13388a != null || context == null) {
            return;
        }
        f13388a = (Application) context.getApplicationContext();
    }

    /* renamed from: a */
    public static Application m12460a() {
        Application application = f13388a;
        if (application != null) {
            return application;
        }
        try {
            Context appContext = UMGlobalContext.getAppContext();
            if (appContext != null) {
                Application application2 = (Application) appContext.getApplicationContext();
                f13388a = application2;
                if (application2 != null) {
                    return f13388a;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Application application3 = (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]), new Object[0]);
            f13388a = application3;
            if (application3 != null) {
                return f13388a;
            }
        } catch (Exception unused2) {
        }
        UPLog.m12144e("Core", "context null! make sure PushAgent.setup(...) be called in Application.onCreate().");
        throw new IllegalStateException("context null! make sure PushAgent.setup(...) be called in Application.onCreate().");
    }
}
