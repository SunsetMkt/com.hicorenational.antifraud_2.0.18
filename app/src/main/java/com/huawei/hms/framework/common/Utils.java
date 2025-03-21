package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;

/* loaded from: classes.dex */
public class Utils {
    private static final String TAG = "Utils";

    public static long getCurrentTime(boolean z) {
        return z ? SystemClock.elapsedRealtime() : System.currentTimeMillis();
    }

    public static boolean is64Bit(Context context) {
        if (context == null) {
            Logger.m6796e(TAG, "Null context, please check it.");
            return false;
        }
        Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 < 21) {
            return false;
        }
        try {
            return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).nativeLibraryDir.contains("64");
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.m6796e(TAG, "Get application info failed: name not found, try to get baseContext.");
            if (!(context instanceof ContextWrapper)) {
                return false;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == null) {
                Logger.m6803w(TAG, "Get baseContext failed: null. Return default: is64-bit.");
                return true;
            }
            try {
                return baseContext.getPackageManager().getApplicationInfo(baseContext.getPackageName(), 128).nativeLibraryDir.contains("64");
            } catch (PackageManager.NameNotFoundException unused2) {
                Logger.m6796e(TAG, "Get baseContext application info failed: name not found");
                return true;
            }
        }
    }
}
