package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class PackageManagerCompat {
    private static final String TAG = "PackageUtils";
    private static final String VERSION = "6.0.11.300";
    private static String sAppVersion = "";

    public static String getAppPackageName(Context context) {
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 16384).packageName;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.m6803w(TAG, "Failed to get Package managers Package Info");
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        if (!TextUtils.isEmpty(sAppVersion)) {
            return sAppVersion;
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return sAppVersion;
        }
        try {
            sAppVersion = String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.m6803w(TAG, "Failed to get Package managers Package Info");
        }
        return sAppVersion;
    }

    private static Bundle getBundleFromApp(Context context) {
        PackageManager packageManager;
        Bundle bundle = Bundle.EMPTY;
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return bundle;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            return (applicationInfo == null || applicationInfo.metaData == null) ? bundle : applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException | RuntimeException e2) {
            Logger.m6804w(TAG, "NameNotFoundException:", e2);
            return bundle;
        }
    }

    private static Bundle getBundleFromKit(Context context) {
        if (ContextHolder.getKitContext() != null) {
            context = ContextHolder.getKitContext();
        }
        if (context == null) {
            Logger.m6801v(TAG, "the kitContext is null");
            return Bundle.EMPTY;
        }
        if (context.getApplicationInfo() == null) {
            Logger.m6801v(TAG, "the kit applicationInfo is null");
            return Bundle.EMPTY;
        }
        Logger.m6799i(TAG, "kitContext: " + context.getPackageName());
        Bundle bundle = context.getApplicationInfo().metaData;
        return bundle == null ? Bundle.EMPTY : bundle;
    }

    private static Bundle getBundleFromKitOrAPP(Context context) {
        Bundle bundleFromKit = getBundleFromKit(context);
        return (bundleFromKit == null || bundleFromKit.isEmpty()) ? getBundleFromApp(context) : bundleFromKit;
    }

    public static String getMetaDataFromApp(Context context, String str, String str2) {
        Bundle bundleFromApp = getBundleFromApp(context);
        return bundleFromApp != null ? bundleFromApp.getString(str, str2) : str2;
    }

    public static String getMetaDataFromKit(Context context, String str, String str2) {
        try {
            Bundle bundleFromKit = getBundleFromKit(context);
            return bundleFromKit == null ? str2 : bundleFromKit.getString(str, str2);
        } catch (RuntimeException unused) {
            Logger.m6801v(TAG, "the kit metaData is runtimeException");
            return str2;
        }
    }

    public static String getMetaDataFromKitOrApp(Context context, String str, String str2) {
        return getBundleFromKitOrAPP(context).getString(str, str2);
    }

    public static Map<String, String> getMetaDataMapFromKitOrApp(Context context, String str) {
        HashMap hashMap = new HashMap();
        Bundle bundleFromKitOrAPP = getBundleFromKitOrAPP(context);
        for (String str2 : bundleFromKitOrAPP.keySet()) {
            if (str2.startsWith(str)) {
                String string = bundleFromKitOrAPP.getString(str2);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str2.substring(str.length()), string);
                }
            }
        }
        return hashMap;
    }
}
