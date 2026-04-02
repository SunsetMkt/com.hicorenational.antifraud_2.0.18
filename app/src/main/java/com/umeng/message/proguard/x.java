package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.message.common.UPLog;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    private static Application a;

    public static void a(Context context) {
        if (a != null || context == null) {
            return;
        }
        a = (Application) context.getApplicationContext();
    }

    public static Application a() {
        Application application = a;
        if (application != null) {
            return application;
        }
        try {
            Context appContext = UMGlobalContext.getAppContext();
            if (appContext != null) {
                Application application2 = (Application) appContext.getApplicationContext();
                a = application2;
                if (application2 != null) {
                    return a;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Application application3 = (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]), new Object[0]);
            a = application3;
            if (application3 != null) {
                return a;
            }
        } catch (Exception unused2) {
        }
        UPLog.e("Core", "context null! make sure PushAgent.setup(...) be called in Application.onCreate().");
        throw new IllegalStateException("context null! make sure PushAgent.setup(...) be called in Application.onCreate().");
    }
}
