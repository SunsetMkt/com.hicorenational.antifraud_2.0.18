package com.huawei.hms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public class AGCUtils {
    /* JADX WARN: Removed duplicated region for block: B:6:0x0069 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x006a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m6759a(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "Get "
            java.lang.String r1 = ""
            java.lang.String r2 = "AGCUtils"
            r3 = 0
            com.huawei.agconnect.AGConnectOptionsBuilder r4 = new com.huawei.agconnect.AGConnectOptionsBuilder     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L44
            r4.<init>()     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L44
            android.content.res.Resources r5 = r7.getResources()     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L44
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L44
            java.lang.String r6 = "agconnect-services.json"
            java.io.InputStream r3 = r5.open(r6)     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L44
            r4.setInputStream(r3)     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L44
            com.huawei.agconnect.AGConnectOptions r7 = r4.build(r7)     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L44
            java.lang.String r7 = r7.getString(r8)     // Catch: java.lang.Throwable -> L26 java.lang.NullPointerException -> L28 java.io.IOException -> L44
            goto L60
        L26:
            r7 = move-exception
            goto L84
        L28:
            r7 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r4.<init>()     // Catch: java.lang.Throwable -> L26
            r4.append(r0)     // Catch: java.lang.Throwable -> L26
            r4.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = " with AGConnectServicesConfig failed: "
            r4.append(r0)     // Catch: java.lang.Throwable -> L26
            r4.append(r7)     // Catch: java.lang.Throwable -> L26
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L26
            com.huawei.hms.support.log.HMSLog.m7715e(r2, r7)     // Catch: java.lang.Throwable -> L26
            goto L5f
        L44:
            r7 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r4.<init>()     // Catch: java.lang.Throwable -> L26
            r4.append(r0)     // Catch: java.lang.Throwable -> L26
            r4.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r0 = " failed: "
            r4.append(r0)     // Catch: java.lang.Throwable -> L26
            r4.append(r7)     // Catch: java.lang.Throwable -> L26
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L26
            com.huawei.hms.support.log.HMSLog.m7715e(r2, r7)     // Catch: java.lang.Throwable -> L26
        L5f:
            r7 = r1
        L60:
            com.huawei.hms.utils.IOUtils.closeQuietly(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L6a
            return r7
        L6a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "The "
            r7.append(r0)
            r7.append(r8)
            java.lang.String r8 = " is null."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.huawei.hms.support.log.HMSLog.m7715e(r2, r7)
            return r1
        L84:
            com.huawei.hms.utils.IOUtils.closeQuietly(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.AGCUtils.m6759a(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private static String m6760b(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m7715e("AGCUtils", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("com.huawei.hms.client.cpid")) == null) {
                HMSLog.m7717i("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
                return "";
            }
            String valueOf = String.valueOf(obj);
            return valueOf.startsWith("cpid=") ? valueOf.substring(5) : valueOf;
        } catch (AndroidException unused) {
            HMSLog.m7715e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.");
            return "";
        } catch (RuntimeException e2) {
            HMSLog.m7716e("AGCUtils", "In getMetaDataCpId, Failed to read meta data for the CpId.", e2);
            return "";
        }
    }

    /* renamed from: c */
    private static boolean m6761c(Context context) {
        return context.getPackageName().equals(HMSPackageManager.getInstance(context).getHMSPackageNameForMultiService());
    }

    public static String getAppId(Context context) {
        if (context == null) {
            HMSLog.m7718w("AGCUtils", "getAppId context is null");
            return "";
        }
        String str = null;
        if (m6761c(context)) {
            str = m6759a(context, "client/app_id");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        try {
            AGConnectInstance aGConnectInstance = AGConnectInstance.getInstance();
            if (aGConnectInstance.getContext() != context) {
                aGConnectInstance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = aGConnectInstance.getOptions().getString("client/app_id");
        } catch (NullPointerException unused) {
            HMSLog.m7715e("AGCUtils", "Get appId with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String m6758a = m6758a(context);
        return !TextUtils.isEmpty(m6758a) ? m6758a : m6759a(context, "client/app_id");
    }

    public static String getCpId(Context context) {
        if (context == null) {
            HMSLog.m7718w("AGCUtils", "getCpId context is null");
            return "";
        }
        if (m6761c(context)) {
            return m6759a(context, "client/cp_id");
        }
        String str = null;
        try {
            AGConnectInstance aGConnectInstance = AGConnectInstance.getInstance();
            if (aGConnectInstance.getContext() != context) {
                aGConnectInstance = AGConnectInstance.buildInstance(new AGConnectOptionsBuilder().build(context));
            }
            str = aGConnectInstance.getOptions().getString("client/cp_id");
        } catch (NullPointerException unused) {
            HMSLog.m7715e("AGCUtils", "Get cpid with AGConnectServicesConfig failed");
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String m6760b = m6760b(context);
        return !TextUtils.isEmpty(m6760b) ? m6760b : m6759a(context, "client/cp_id");
    }

    /* renamed from: a */
    private static String m6758a(Context context) {
        Bundle bundle;
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.m7715e("AGCUtils", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(Constants.HUAWEI_HMS_CLIENT_APPID)) != null) {
                String valueOf = String.valueOf(obj);
                return valueOf.startsWith("appid=") ? valueOf.substring(6) : valueOf;
            }
            HMSLog.m7715e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (AndroidException unused) {
            HMSLog.m7715e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.");
            return "";
        } catch (RuntimeException e2) {
            HMSLog.m7716e("AGCUtils", "In getMetaDataAppId, Failed to read meta data for the AppID.", e2);
            return "";
        }
    }
}
