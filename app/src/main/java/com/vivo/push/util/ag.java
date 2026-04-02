package com.vivo.push.util;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import bean.SurveyH5Bean;
import com.huawei.hms.push.AttributionReporter;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Utility.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ag {
    private static String[] a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* JADX INFO: renamed from: b */
    private static String[] f8655b = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};

    /* JADX INFO: renamed from: c */
    private static String[] f8656c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* JADX INFO: renamed from: d */
    private static String[] f8657d = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* JADX INFO: renamed from: e */
    private static String[] f8658e = new String[0];

    /* JADX INFO: renamed from: f */
    private static Map<String, Bundle> f8659f = new ConcurrentHashMap();

    public static long a(Context context) {
        String strA = aa.a(context);
        if (!TextUtils.isEmpty(strA)) {
            return a(context, strA);
        }
        u.a("Utility", "systemPushPkgName is null");
        return -1L;
    }

    public static String b(Context context, String str) {
        Object objA = a(context, str, "verification_status");
        return objA != null ? objA.toString() : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x00c3 A[Catch: Exception -> 0x00cd, TRY_ENTER, TryCatch #1 {Exception -> 0x00cd, blocks: (B:141:0x00a6, B:143:0x00ab, B:145:0x00af, B:155:0x00c3, B:157:0x00c8), top: B:175:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00c8 A[Catch: Exception -> 0x00cd, TRY_LEAVE, TryCatch #1 {Exception -> 0x00cd, blocks: (B:141:0x00a6, B:143:0x00ab, B:145:0x00af, B:155:0x00c3, B:157:0x00c8), top: B:175:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00d6 A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:163:0x00d1, B:165:0x00d6, B:167:0x00da), top: B:173:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static PublicKey c(Context context) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Throwable th;
        Cursor cursorQuery;
        Exception e2;
        Cursor cursorQuery2;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.x.a);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            u.a("Utility", "client is null");
                            cursorQuery2 = contentProviderClientAcquireUnstableContentProviderClient.query(com.vivo.push.x.a, null, null, null, null);
                        } catch (Exception e3) {
                            e2 = e3;
                            cursorQuery = null;
                            e2.printStackTrace();
                            if (cursorQuery != null) {
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursorQuery = null;
                            if (cursorQuery != null) {
                            }
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                            throw th;
                        }
                    } else {
                        cursorQuery2 = null;
                    }
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient = null;
                    cursorQuery2 = null;
                }
                if (cursorQuery2 == null) {
                    try {
                        cursorQuery = context.getContentResolver().query(com.vivo.push.x.a, null, null, null, null);
                    } catch (Exception e4) {
                        e2 = e4;
                        cursorQuery = cursorQuery2;
                        e2.printStackTrace();
                        if (cursorQuery != null) {
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        cursorQuery = cursorQuery2;
                        if (cursorQuery != null) {
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        }
                        throw th;
                    }
                } else {
                    cursorQuery = cursorQuery2;
                }
            } catch (Exception e5) {
                e2 = e5;
                cursorQuery = null;
                contentProviderClientAcquireUnstableContentProviderClient = null;
            } catch (Throwable th4) {
                contentProviderClientAcquireUnstableContentProviderClient = null;
                th = th4;
                cursorQuery = null;
            }
        } catch (Exception unused) {
        }
        if (cursorQuery == null) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception unused2) {
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            return null;
        }
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    if ("pushkey".equals(cursorQuery.getString(cursorQuery.getColumnIndex(CommonNetImpl.NAME)))) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex(SurveyH5Bean.VALUE));
                        u.d("Utility", "result key : ".concat(String.valueOf(string)));
                        PublicKey publicKeyA = ab.a(string);
                        if (cursorQuery != null) {
                            try {
                                cursorQuery.close();
                            } catch (Exception unused3) {
                            }
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                        return publicKeyA;
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    e2.printStackTrace();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    }
                    return null;
                }
                contentProviderClientAcquireUnstableContentProviderClient.close();
                return null;
            } catch (Throwable th5) {
                th = th5;
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Exception unused4) {
                        throw th;
                    }
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.close();
        }
        return null;
    }

    private static void d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new VivoPushException("serviceInfos is null");
            }
            for (String str2 : f8656c) {
                a(str2, serviceInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void e(Context context, String str) throws VivoPushException {
        if (f8658e.length <= 0) {
            return;
        }
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            if (activityInfoArr == null) {
                throw new VivoPushException("activityInfos is null");
            }
            for (String str2 : f8658e) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    private static void f(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new VivoPushException("receivers is null");
            }
            for (String str2 : f8657d) {
                a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int g(Context context, String str) {
        String string;
        int iIntValue;
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            u.a("Utility", "getClientSdkVersion() error, context is null or pkgName is empty");
            return 0;
        }
        Object objA = a(context, str, "sdk_version_vivo");
        if (objA instanceof String) {
            string = (String) objA;
        } else {
            if (objA instanceof Integer) {
                iIntValue = ((Integer) objA).intValue();
                str2 = "";
                if (iIntValue <= 0) {
                    return iIntValue;
                }
                try {
                    return Integer.parseInt(str2);
                } catch (Exception e2) {
                    u.a("Utility", "getClientSdkVersion: ".concat(String.valueOf(e2)));
                    return 0;
                }
            }
            if (objA == null) {
                return 0;
            }
            string = objA.toString();
        }
        str2 = string;
        iIntValue = 0;
        if (iIntValue <= 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x00fd, code lost:
    
        r12 = r12 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(Context context) throws VivoPushException {
        String string;
        int i2;
        u.d("Utility", "check PushService AndroidManifest declearation !");
        String strA = aa.a(context);
        boolean zD = aa.d(context, context.getPackageName());
        boolean zE = aa.e(context, context.getPackageName());
        boolean zC = aa.c(context, context.getPackageName());
        if (zE) {
            a = new String[]{"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};
            f8655b = new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};
            f8656c = new String[]{"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};
            f8657d = new String[]{"com.vivo.push.sdk.RegistrationReceiver"};
        } else {
            if (!zC && !zD) {
                throw new VivoPushException("AndroidManifest.xml\u4e2dreceiver\u914d\u7f6e\u9879\u9519\u8bef\uff0c\u8be6\u89c1\u63a5\u5165\u6587\u6863");
            }
            if (zC) {
                f8656c = new String[]{"com.vivo.push.sdk.service.CommandClientService"};
            } else {
                f8656c = new String[]{"com.vivo.push.sdk.service.CommandService"};
            }
            f8657d = new String[0];
            a = new String[0];
            if (zD) {
                f8655b = new String[]{"android.permission.INTERNET", "android.permission.WRITE_SETTINGS"};
            } else {
                f8655b = new String[]{"android.permission.INTERNET"};
            }
        }
        if (zD) {
            long jA = a(context, context.getPackageName());
            long j2 = context.getPackageName().equals(strA) ? 1341L : 341L;
            if (jA == -1) {
                throw new VivoPushException("AndroidManifest.xml\u4e2d\u672a\u914d\u7f6esdk_version");
            }
            if (jA != j2) {
                throw new VivoPushException("AndroidManifest.xml\u4e2dsdk_version\u914d\u7f6e\u9879\u9519\u8bef\uff0c\u8bf7\u914d\u7f6e\u5f53\u524dsdk_version\u7248\u672c\u4e3a:".concat(String.valueOf(j2)));
            }
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String[] strArr = packageManager.getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    String[] strArr2 = f8655b;
                    int length = strArr2.length;
                    int i3 = 0;
                    while (i3 < length) {
                        String str = strArr2[i3];
                        int length2 = strArr.length;
                        while (i2 < length2) {
                            i2 = str.equals(strArr[i2]) ? 0 : i2 + 1;
                        }
                        throw new VivoPushException("permission : " + str + "  check fail : " + Arrays.toString(strArr));
                    }
                    f(context, strA);
                    d(context, strA);
                    e(context, strA);
                    try {
                        if (a(context, context.getPackageName(), "local_iv") != null) {
                            String packageName = context.getPackageName();
                            Object objA = a(context, packageName, "com.vivo.push.api_key");
                            String string2 = "";
                            if (objA != null) {
                                string = objA.toString();
                            } else {
                                Object objA2 = a(context, packageName, "api_key");
                                string = objA2 != null ? objA2.toString() : "";
                            }
                            if (!TextUtils.isEmpty(string)) {
                                String packageName2 = context.getPackageName();
                                Object objA3 = a(context, packageName2, "com.vivo.push.app_id");
                                if (objA3 != null) {
                                    string2 = objA3.toString();
                                } else {
                                    Object objA4 = a(context, packageName2, "app_id");
                                    if (objA4 != null) {
                                        string2 = objA4.toString();
                                    }
                                }
                                if (TextUtils.isEmpty(string2)) {
                                    throw new VivoPushException("com.vivo.push.app_id is null");
                                }
                                if ((zD || zE) && a(context, context.getPackageName()) == -1) {
                                    throw new VivoPushException("sdkversion is null");
                                }
                                if (zE) {
                                    a(context, "com.vivo.pushservice.action.METHOD", "com.vivo.push.sdk.RegistrationReceiver", true);
                                    a(context, "com.vivo.pushservice.action.PUSH_SERVICE", "com.vivo.push.sdk.service.PushService", false);
                                    return;
                                }
                                return;
                            }
                            throw new VivoPushException("com.vivo.push.api_key is null");
                        }
                        throw new VivoPushException("AndroidManifest.xml\u4e2d\u672a\u914d\u7f6e".concat("local_iv"));
                    } catch (Exception e2) {
                        throw new VivoPushException("getMetaValue error " + e2.getMessage());
                    }
                }
                throw new VivoPushException("Permissions is null!");
            }
            throw new VivoPushException("localPackageManager is null");
        } catch (Exception e3) {
            throw new VivoPushException(e3.getMessage());
        }
    }

    public static long a(Context context, String str) {
        Object objA = a(context, str, "com.vivo.push.sdk_version");
        if (objA == null) {
            objA = a(context, str, "sdk_version");
        }
        if (objA != null) {
            try {
                return Long.parseLong(objA.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                u.a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        u.a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(Context context) throws Throwable {
        Throwable th;
        Cursor cursor;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        ?? Query = 0;
        Query = 0;
        try {
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    contentProviderClientAcquireUnstableContentProviderClient = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                    }
                    if (0 == 0) {
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        u.a("Utility", "close", e3);
                        throw th;
                    }
                }
                if (0 == 0 && Build.VERSION.SDK_INT >= 24) {
                    Query.close();
                    throw th;
                }
                throw th;
            }
        } catch (Exception e4) {
            u.a("Utility", "close", e4);
        }
        if (context == null) {
            u.a("Utility", "context is null");
            return false;
        }
        String packageName = context.getPackageName();
        int i2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.x.f8697b);
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    u.a("Utility", "client is null");
                    Query = contentProviderClientAcquireUnstableContentProviderClient.query(com.vivo.push.x.f8697b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"341", packageName, String.valueOf(i2)}, null);
                } catch (Exception e5) {
                    e = e5;
                    u.a("Utility", "isSupport", e);
                    if (0 != 0) {
                        Query.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                }
            }
        } else {
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
        if (Query == 0) {
            Query = context.getContentResolver().query(com.vivo.push.x.f8697b, null, "pushVersion = ? and appPkgName = ? and appCode = ? ", new String[]{"341", packageName, String.valueOf(i2)}, null);
        }
        if (Query == 0) {
            u.a("Utility", "cursor is null");
            if (Query != 0) {
                try {
                    Query.close();
                } catch (Exception e6) {
                    u.a("Utility", "close", e6);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            return false;
        }
        if (Query.moveToFirst() && (Query.getInt(Query.getColumnIndex(AttributionReporter.SYSTEM_PERMISSION)) & 1) != 0) {
            if (Query != 0) {
                try {
                    Query.close();
                } catch (Exception e7) {
                    u.a("Utility", "close", e7);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            return true;
        }
        if (Query != 0) {
            Query.close();
        }
        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.close();
        }
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public static Object a(Context context, String str, String str2) {
        Bundle bundle;
        Object obj = null;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object obj2 = (f8659f == null || f8659f.size() <= 0 || (bundle = f8659f.get(str)) == null) ? null : bundle.get(str2);
            if (obj2 != null) {
                return obj2;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                Bundle bundle2 = applicationInfo != null ? applicationInfo.metaData : null;
                Object obj3 = bundle2 != null ? bundle2.get(str2) : obj2;
                try {
                    if (f8659f.size() > 300) {
                        return obj3;
                    }
                    f8659f.put(str, bundle2);
                    return obj3;
                } catch (Exception e2) {
                    obj = obj3;
                    e = e2;
                    u.a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return obj;
                }
            } catch (Exception e3) {
                e = e3;
                obj = obj2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static Object a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    private static void a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    public static int c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int iA = (int) a(context, str);
            return iA <= 0 ? g(context, str) : iA;
        }
        u.a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    }

    private static void a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    private static void a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z) {
                List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
                    Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
                    while (it.hasNext()) {
                        if (str2.equals(it.next().activityInfo.name)) {
                            return;
                        }
                    }
                    throw new VivoPushException(str2 + " is missing");
                }
                throw new VivoPushException("checkModule " + intent + " has no receivers");
            }
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo : listQueryIntentServices) {
                    if (str2.equals(resolveInfo.serviceInfo.name)) {
                        if (resolveInfo.serviceInfo.exported) {
                            return;
                        }
                        throw new VivoPushException(resolveInfo.serviceInfo.name + " exported is false");
                    }
                }
                throw new VivoPushException(str2 + " is missing");
            }
            throw new VivoPushException("checkModule " + intent + " has no services");
        } catch (Exception e2) {
            u.a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    public static String b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    public static void a(Context context, Intent intent) {
        String strA = aa.a(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(strA)) {
            u.a("Utility", "illegality abe adapter : push pkg is null");
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            u.a("Utility", "illegality abe adapter : src pkg is null");
            return;
        }
        if (strA.equals(context.getPackageName())) {
            u.a("Utility", "illegality abe adapter : abe is not pushservice");
            return;
        }
        if (!strA.equals(stringExtra)) {
            u.d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + strA);
            intent.setPackage(strA);
            intent.setClassName(strA, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
            return;
        }
        u.a("Utility", "illegality abe adapter : pushPkg = " + strA + " ; srcPkg = " + stringExtra);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str, String str2, long j2) throws Throwable {
        Throwable th;
        Cursor cursor;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        ?? Query = 0;
        Query = 0;
        try {
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    contentProviderClientAcquireUnstableContentProviderClient = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    if (cursor != null) {
                    }
                    if (0 == 0) {
                        throw th;
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        u.a("Utility", "close", e3);
                        throw th;
                    }
                }
                if (0 == 0 && Build.VERSION.SDK_INT >= 24) {
                    Query.close();
                    throw th;
                }
                throw th;
            }
        } catch (Exception e4) {
            u.a("Utility", "close", e4);
        }
        if (context == null) {
            u.a("Utility", "context is null");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.x.f8698c);
            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                try {
                    u.a("Utility", "client is null");
                    Query = contentProviderClientAcquireUnstableContentProviderClient.query(com.vivo.push.x.f8698c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j2)}, null);
                } catch (Exception e5) {
                    e = e5;
                    u.a("Utility", "isOverdue", e);
                    if (0 != 0) {
                        Query.close();
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                }
            }
        } else {
            contentProviderClientAcquireUnstableContentProviderClient = null;
        }
        if (Query == 0) {
            Query = context.getContentResolver().query(com.vivo.push.x.f8698c, null, "appPkgName = ? and regId = ? sdkVersion = ? ", new String[]{str, str2, String.valueOf(j2)}, null);
        }
        if (Query == 0) {
            u.a("Utility", "cursor is null");
            if (Query != 0) {
                try {
                    Query.close();
                } catch (Exception e6) {
                    u.a("Utility", "close", e6);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            return false;
        }
        if (Query.moveToFirst()) {
            boolean z = Boolean.parseBoolean(Query.getString(Query.getColumnIndex("clientState")));
            if (Query != 0) {
                try {
                    Query.close();
                } catch (Exception e7) {
                    u.a("Utility", "close", e7);
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            return z;
        }
        if (Query != 0) {
            Query.close();
        }
        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.close();
        }
        return false;
    }

    public static boolean a(Context context, String str, boolean z) {
        Cursor cursorA;
        Cursor cursor = null;
        try {
        } catch (Exception e2) {
            u.a("Utility", "close", e2);
        }
        try {
            try {
                Uri uri = com.vivo.push.x.f8700e;
                String[] strArr = new String[2];
                strArr[0] = str;
                strArr[1] = z ? "1" : "0";
                cursorA = a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
            } catch (Exception e3) {
                u.a("Utility", "syncAgreePrivacyStatement", e3);
                if (0 != 0) {
                    cursor.close();
                }
            }
            if (cursorA == null) {
                u.a("Utility", "cursor is null");
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (Exception e4) {
                        u.a("Utility", "close", e4);
                    }
                }
                return false;
            }
            if (!cursorA.moveToFirst()) {
                if (cursorA != null) {
                    cursorA.close();
                }
                return false;
            }
            boolean z2 = Boolean.parseBoolean(cursorA.getString(cursorA.getColumnIndex("agreePrivacyStatement")));
            if (cursorA != null) {
                try {
                    cursorA.close();
                } catch (Exception e5) {
                    u.a("Utility", "close", e5);
                }
            }
            return z2;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e6) {
                    u.a("Utility", "close", e6);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Cursor a(Uri uri, String str, String[] strArr, Context context) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Cursor cursorQuery;
        ContentProviderClient contentProviderClient = null;
        try {
            try {
                if (context == null) {
                    u.a("Utility", "context is null");
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            u.a("Utility", "client is null");
                            cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, null, str, strArr, null);
                        } catch (Exception e2) {
                            e = e2;
                            u.a("Utility", "queryContentResolver", e);
                            if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                try {
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        contentProviderClientAcquireUnstableContentProviderClient.close();
                                    }
                                } catch (Exception e3) {
                                    u.a("Utility", "close", e3);
                                }
                            }
                            return null;
                        }
                    } else {
                        cursorQuery = null;
                    }
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient = null;
                    cursorQuery = null;
                }
                if (cursorQuery == null) {
                    cursorQuery = context.getContentResolver().query(uri, null, str, strArr, null);
                }
                if (cursorQuery != null) {
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                contentProviderClientAcquireUnstableContentProviderClient.close();
                            }
                        } catch (Exception e4) {
                            u.a("Utility", "close", e4);
                        }
                    }
                    return cursorQuery;
                }
                u.a("Utility", "cursor is null");
                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    try {
                        if (Build.VERSION.SDK_INT >= 24) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                    } catch (Exception e5) {
                        u.a("Utility", "close", e5);
                    }
                }
                return null;
            } catch (Exception e6) {
                e = e6;
                contentProviderClientAcquireUnstableContentProviderClient = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        contentProviderClient.close();
                    }
                } catch (Exception e7) {
                    u.a("Utility", "close", e7);
                }
            }
            throw th;
        }
    }
}
