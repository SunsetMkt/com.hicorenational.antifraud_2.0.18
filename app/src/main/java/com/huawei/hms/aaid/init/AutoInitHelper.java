package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.C2471i;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public class AutoInitHelper {
    public static void doAutoInit(Context context) {
        try {
            if (isAutoInitEnabled(context)) {
                HMSLog.m7717i("AutoInit", "Push init start");
                new Thread(new RunnableC2281a(context)).start();
            }
        } catch (Exception e2) {
            HMSLog.m7716e("AutoInit", "Push init failed", e2);
        }
    }

    public static boolean isAutoInitEnabled(Context context) {
        C2471i m7469a = C2471i.m7469a(context);
        if (m7469a.containsKey("push_kit_auto_init_enabled")) {
            return m7469a.getBoolean("push_kit_auto_init_enabled");
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void setAutoInitEnabled(Context context, boolean z) {
        C2471i m7469a = C2471i.m7469a(context);
        boolean z2 = m7469a.getBoolean("push_kit_auto_init_enabled");
        m7469a.saveBoolean("push_kit_auto_init_enabled", z);
        if (!z || z2) {
            return;
        }
        doAutoInit(context);
    }
}
