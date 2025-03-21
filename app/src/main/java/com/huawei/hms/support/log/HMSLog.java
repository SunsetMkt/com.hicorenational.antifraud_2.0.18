package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AndroidException;
import com.huawei.hms.base.log.C2315a;
import com.huawei.hms.base.log.C2316b;

/* loaded from: classes.dex */
public class HMSLog {

    /* renamed from: a */
    private static final C2316b f7893a = new C2316b();

    /* renamed from: a */
    private static String m7711a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (AndroidException | RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    /* renamed from: d */
    public static void m7712d(String str, String str2) {
        f7893a.m6667a(3, str, str2);
    }

    /* renamed from: e */
    public static void m7715e(String str, String str2) {
        f7893a.m6667a(6, str, str2);
    }

    /* renamed from: i */
    public static void m7717i(String str, String str2) {
        f7893a.m6667a(4, str, str2);
    }

    public static void init(Context context, int i2, String str) {
        C2316b c2316b = f7893a;
        c2316b.m6668a(context, i2, str);
        c2316b.m6670a(str, "============================================================================\n====== " + m7711a(context) + "\n============================================================================");
    }

    public static boolean isErrorEnable() {
        return f7893a.m6671a(6);
    }

    public static boolean isInfoEnable() {
        return f7893a.m6671a(4);
    }

    public static boolean isWarnEnable() {
        return f7893a.m6671a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z) throws IllegalArgumentException {
        if (hMSExtLogger == null) {
            throw new IllegalArgumentException("extLogger is not able to be null");
        }
        C2315a c2315a = new C2315a(hMSExtLogger);
        if (z) {
            f7893a.m6669a(c2315a);
        } else {
            f7893a.m6666a().mo6662a(c2315a);
        }
    }

    /* renamed from: w */
    public static void m7718w(String str, String str2) {
        f7893a.m6667a(5, str, str2);
    }

    /* renamed from: e */
    public static void m7716e(String str, String str2, Throwable th) {
        f7893a.m6672b(6, str, str2, th);
    }

    /* renamed from: e */
    public static void m7713e(String str, long j2, String str2) {
        f7893a.m6667a(6, str, "[" + j2 + "] " + str2);
    }

    /* renamed from: e */
    public static void m7714e(String str, long j2, String str2, Throwable th) {
        f7893a.m6672b(6, str, "[" + j2 + "] " + str2, th);
    }
}
