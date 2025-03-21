package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: CommFun.java */
/* renamed from: com.huawei.hms.push.e */
/* loaded from: classes.dex */
public class C2485e {
    /* renamed from: a */
    public static String m7553a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.m7717i("PushSelfShowLog", "get the app name of package:" + str + " failed.");
            return null;
        }
    }

    /* renamed from: b */
    public static Intent m7555b(Context context, String str) {
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception unused) {
            HMSLog.m7718w("PushSelfShowLog", str + " not have launch activity");
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m7558c(Context context, String str) {
        if (context != null && str != null && !"".equals(str)) {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192) == null) {
                    return false;
                }
                HMSLog.m7712d("PushSelfShowLog", str + " is installed");
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m7559d() {
        return Build.VERSION.SDK_INT >= 11;
    }

    /* renamed from: b */
    private static boolean m7556b() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: c */
    public static boolean m7557c() {
        return Build.VERSION.SDK_INT >= 33;
    }

    /* renamed from: a */
    public static Boolean m7552a(Context context, String str, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                int size = queryIntentActivities.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (queryIntentActivities.get(i2).activityInfo != null && str.equals(queryIntentActivities.get(i2).activityInfo.applicationInfo.packageName)) {
                        return Boolean.TRUE;
                    }
                }
            }
        } catch (Exception e2) {
            HMSLog.m7716e("PushSelfShowLog", e2.toString(), e2);
        }
        return Boolean.FALSE;
    }

    /* renamed from: a */
    public static int m7551a() {
        return m7556b() ? AbstractC1191a.f2487B1 : AbstractC1191a.f2490C1;
    }

    /* renamed from: a */
    public static boolean m7554a(Context context) {
        return "com.huawei.hwid".equals(context.getPackageName());
    }
}
