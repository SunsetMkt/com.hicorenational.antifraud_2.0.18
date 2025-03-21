package com.heytap.mcssdk.p160k;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.heytap.mcssdk.C2080a;

/* renamed from: com.heytap.mcssdk.k.c */
/* loaded from: classes.dex */
public class C2103c {
    /* renamed from: a */
    public static int m5859a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            C2107g.m5884b("getVersionCode--Exception:" + e2.getMessage());
            return 0;
        }
    }

    /* renamed from: a */
    public static int m5860a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e2) {
            C2107g.m5884b("getVersionCode--Exception:" + e2.getMessage());
            return 0;
        }
    }

    /* renamed from: a */
    public static int m5861a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                C2107g.m5896e("parseInt--NumberFormatException" + e2.getMessage());
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static String m5862a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 : iArr) {
            sb.append((char) i2);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m5863a(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e2) {
            C2107g.m5896e("isSupportPush NameNotFoundException:" + e2.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    /* renamed from: b */
    public static String m5864b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            C2107g.m5884b("getVersionName--Exception:" + e2.getMessage());
            return "0";
        }
    }

    /* renamed from: b */
    public static String m5865b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e2) {
            C2107g.m5884b("getVersionName--Exception:" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m5866c(Context context) {
        return C2080a.m5698w().m5729d(context);
    }

    /* renamed from: c */
    public static boolean m5867c(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            C2107g.m5896e("isExistPackage NameNotFoundException:" + e2.getMessage());
            return false;
        }
    }
}
