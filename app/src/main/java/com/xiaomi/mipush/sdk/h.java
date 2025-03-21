package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.xiaomi.push.aw;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static int f12377a = -1;

    public static q a(Context context) {
        return m103a(context) ? q.HUAWEI : c(context) ? q.OPPO : d(context) ? q.VIVO : q.OTHER;
    }

    public static boolean b(Context context) {
        Object a2 = aw.a(aw.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object a3 = aw.a("com.google.android.gms.common.ConnectionResult", HttpConstant.SUCCESS);
        if (a3 == null || !(a3 instanceof Integer)) {
            com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            f12377a = 0;
            return false;
        }
        int intValue = ((Integer) Integer.class.cast(a3)).intValue();
        if (a2 != null) {
            if (a2 instanceof Integer) {
                f12377a = ((Integer) Integer.class.cast(a2)).intValue() == intValue ? 1 : 0;
            } else {
                f12377a = 0;
                com.xiaomi.channel.commonutils.logger.b.c("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is google service can be used");
        sb.append(f12377a > 0);
        com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
        return f12377a > 0;
    }

    public static boolean c(Context context) {
        boolean z = false;
        Object a2 = aw.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("color os push  is avaliable ? :" + z);
        return z;
    }

    public static boolean d(Context context) {
        boolean z = false;
        Object a2 = aw.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (a2 != null && (a2 instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(a2)).booleanValue();
        }
        com.xiaomi.channel.commonutils.logger.b.c("fun touch os push  is avaliable ? :" + z);
        return z;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m103a(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null) {
                if (a()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean a() {
        try {
            String str = (String) aw.a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
        return false;
    }
}
