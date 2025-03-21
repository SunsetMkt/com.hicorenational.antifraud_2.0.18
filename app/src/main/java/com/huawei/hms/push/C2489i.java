package com.huawei.hms.push;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.huawei.hms.aaid.utils.PushPreferences;
import java.lang.reflect.InvocationTargetException;

/* compiled from: NotificationUtil.java */
/* renamed from: com.huawei.hms.push.i */
/* loaded from: classes.dex */
public class C2489i {
    /* renamed from: a */
    public static boolean m7565a(Context context) {
        if (new PushPreferences(context, "push_notify_flag").getBoolean("notify_msg_enable")) {
            return false;
        }
        if (C2485e.m7557c()) {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return m7566b(context);
        }
        if (i2 >= 19) {
            return m7566b(context);
        }
        return true;
    }

    @SuppressLint({"NewApi", "InlinedApi"})
    /* renamed from: b */
    private static boolean m7566b(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }
}
