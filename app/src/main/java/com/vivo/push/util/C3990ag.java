package com.vivo.push.util;

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
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.C4018x;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Utility.java */
/* renamed from: com.vivo.push.util.ag */
/* loaded from: classes2.dex */
public final class C3990ag {

    /* renamed from: a */
    private static String[] f14229a = {"com.vivo.push.sdk.RegistrationReceiver", "com.vivo.push.sdk.service.PushService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: b */
    private static String[] f14230b = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_SETTINGS", "android.permission.VIBRATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.WAKE_LOCK", "com.bbk.account.permission.READ_ACCOUNTINFO", "android.permission.AUTHENTICATE_ACCOUNTS", "android.permission.MOUNT_UNMOUNT_FILESYSTEMS", "android.permission.GET_TASKS"};

    /* renamed from: c */
    private static String[] f14231c = {"com.vivo.push.sdk.service.CommandService", "com.vivo.push.sdk.service.CommonJobService"};

    /* renamed from: d */
    private static String[] f14232d = {"com.vivo.push.sdk.RegistrationReceiver"};

    /* renamed from: e */
    private static String[] f14233e = new String[0];

    /* renamed from: f */
    private static Map<String, Bundle> f14234f = new ConcurrentHashMap();

    /* renamed from: a */
    public static long m13206a(Context context) {
        String m13180a = C3984aa.m13180a(context);
        if (!TextUtils.isEmpty(m13180a)) {
            return m13207a(context, m13180a);
        }
        C4010u.m13292a("Utility", "systemPushPkgName is null");
        return -1L;
    }

    /* renamed from: b */
    public static String m13217b(Context context, String str) {
        Object m13209a = m13209a(context, str, "verification_status");
        return m13209a != null ? m13209a.toString() : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ad, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00af, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 24) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c3 A[Catch: Exception -> 0x00cd, TRY_ENTER, TryCatch #1 {Exception -> 0x00cd, blocks: (B:44:0x00a6, B:46:0x00ab, B:48:0x00af, B:54:0x00c3, B:56:0x00c8), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c8 A[Catch: Exception -> 0x00cd, TRY_LEAVE, TryCatch #1 {Exception -> 0x00cd, blocks: (B:44:0x00a6, B:46:0x00ab, B:48:0x00af, B:54:0x00c3, B:56:0x00c8), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d6 A[Catch: Exception -> 0x00dd, TryCatch #0 {Exception -> 0x00dd, blocks: (B:69:0x00d1, B:62:0x00d6, B:64:0x00da), top: B:68:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.security.PublicKey m13221c(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.C3990ag.m13221c(android.content.Context):java.security.PublicKey");
    }

    /* renamed from: d */
    private static void m13222d(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                throw new VivoPushException("serviceInfos is null");
            }
            for (String str2 : f14231c) {
                m13214a(str2, serviceInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    /* renamed from: e */
    private static void m13224e(Context context, String str) throws VivoPushException {
        if (f14233e.length <= 0) {
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
            for (String str2 : f14233e) {
                m13214a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException("error " + e2.getMessage());
        }
    }

    /* renamed from: f */
    private static void m13225f(Context context, String str) throws VivoPushException {
        try {
            if (context.getPackageManager() == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers;
            if (activityInfoArr == null) {
                throw new VivoPushException("receivers is null");
            }
            for (String str2 : f14232d) {
                m13214a(str2, activityInfoArr, str);
            }
        } catch (Exception e2) {
            throw new VivoPushException(e2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m13226g(android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "Utility"
            r1 = 0
            if (r3 == 0) goto L46
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto Lc
            goto L46
        Lc:
            java.lang.String r2 = "sdk_version_vivo"
            java.lang.Object r3 = m13209a(r3, r4, r2)
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L1b
            java.lang.String r3 = (java.lang.String) r3
        L18:
            r4 = r3
            r3 = 0
            goto L2f
        L1b:
            boolean r4 = r3 instanceof java.lang.Integer
            if (r4 == 0) goto L28
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r4 = ""
            goto L2f
        L28:
            if (r3 == 0) goto L45
            java.lang.String r3 = r3.toString()
            goto L18
        L2f:
            if (r3 <= 0) goto L32
            return r3
        L32:
            int r1 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Exception -> L37
            goto L45
        L37:
            r3 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "getClientSdkVersion: "
            java.lang.String r3 = r4.concat(r3)
            com.vivo.push.util.C4010u.m13292a(r0, r3)
        L45:
            return r1
        L46:
            java.lang.String r3 = "getClientSdkVersion() error, context is null or pkgName is empty"
            com.vivo.push.util.C4010u.m13292a(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.C3990ag.m13226g(android.content.Context, java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00fd, code lost:
    
        r12 = r12 + 1;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m13219b(android.content.Context r20) throws com.vivo.push.util.VivoPushException {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.C3990ag.m13219b(android.content.Context):void");
    }

    /* renamed from: a */
    public static long m13207a(Context context, String str) {
        Object m13209a = m13209a(context, str, "com.vivo.push.sdk_version");
        if (m13209a == null) {
            m13209a = m13209a(context, str, "sdk_version");
        }
        if (m13209a != null) {
            try {
                return Long.parseLong(m13209a.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                C4010u.m13293a("Utility", "getSdkVersionCode error ", e2);
                return -1L;
            }
        }
        C4010u.m13292a("Utility", "getSdkVersionCode sdk version is null");
        return -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ff A[Catch: Exception -> 0x00fb, TryCatch #2 {Exception -> 0x00fb, blocks: (B:83:0x00f7, B:71:0x00ff, B:73:0x0103), top: B:82:0x00f7 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m13223d(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.C3990ag.m13223d(android.content.Context):boolean");
    }

    /* renamed from: a */
    public static Object m13209a(Context context, String str, String str2) {
        Bundle bundle;
        if (context == null || str2 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Object obj = (f14234f == null || f14234f.size() <= 0 || (bundle = f14234f.get(str)) == null) ? null : bundle.get(str2);
            if (obj != null) {
                return obj;
            }
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                r0 = applicationInfo != null ? applicationInfo.metaData : null;
                Object obj2 = r0 != null ? r0.get(str2) : obj;
                try {
                    if (f14234f.size() > 300) {
                        return obj2;
                    }
                    f14234f.put(str, r0);
                    return obj2;
                } catch (Exception e2) {
                    r0 = obj2;
                    e = e2;
                    C4010u.m13292a("Utility", "getMetaValue::".concat(String.valueOf(e)));
                    return r0;
                }
            } catch (Exception e3) {
                e = e3;
                r0 = obj;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* renamed from: a */
    public static Object m13210a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    /* renamed from: a */
    private static void m13214a(String str, ComponentInfo[] componentInfoArr, String str2) throws VivoPushException {
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (str.equals(componentInfo.name)) {
                if (componentInfo.enabled) {
                    m13213a(componentInfo, str2);
                    return;
                }
                throw new VivoPushException(componentInfo.name + " module Push-SDK need is illegitmacy !");
            }
        }
        throw new VivoPushException(str + " module Push-SDK need is not exist");
    }

    /* renamed from: c */
    public static int m13220c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int m13207a = (int) m13207a(context, str);
            return m13207a <= 0 ? m13226g(context, str) : m13207a;
        }
        C4010u.m13292a("Utility", "getClientSdkVersionCode() error, context is null or pkgName is empty");
        return 0;
    }

    /* renamed from: a */
    private static void m13213a(ComponentInfo componentInfo, String str) throws VivoPushException {
        if (componentInfo.applicationInfo.packageName.equals(str)) {
            return;
        }
        for (String str2 : f14229a) {
            if (str2.equals(componentInfo.name) && !componentInfo.processName.contains(":pushservice")) {
                throw new VivoPushException("module : " + componentInfo.name + " process :" + componentInfo.processName + "  check process fail");
            }
        }
    }

    /* renamed from: a */
    private static void m13212a(Context context, String str, String str2, boolean z) throws VivoPushException {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                throw new VivoPushException("localPackageManager is null");
            }
            if (z) {
                List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 576);
                if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (it.hasNext()) {
                        if (str2.equals(it.next().activityInfo.name)) {
                            return;
                        }
                    }
                    throw new VivoPushException(str2 + " is missing");
                }
                throw new VivoPushException("checkModule " + intent + " has no receivers");
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
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
            C4010u.m13292a("Utility", "error  " + e2.getMessage());
            throw new VivoPushException("checkModule error" + e2.getMessage());
        }
    }

    /* renamed from: b */
    public static String m13218b(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* renamed from: a */
    public static void m13211a(Context context, Intent intent) {
        String m13180a = C3984aa.m13180a(context);
        String stringExtra = intent.getStringExtra("client_pkgname");
        if (TextUtils.isEmpty(m13180a)) {
            C4010u.m13292a("Utility", "illegality abe adapter : push pkg is null");
            return;
        }
        if (TextUtils.isEmpty(stringExtra)) {
            C4010u.m13292a("Utility", "illegality abe adapter : src pkg is null");
            return;
        }
        if (m13180a.equals(context.getPackageName())) {
            C4010u.m13292a("Utility", "illegality abe adapter : abe is not pushservice");
            return;
        }
        if (!m13180a.equals(stringExtra)) {
            C4010u.m13309d("Utility", "proxy to core : intent pkg : " + intent.getPackage() + " ; src pkg : " + stringExtra + " ; push pkg : " + m13180a);
            intent.setPackage(m13180a);
            intent.setClassName(m13180a, "com.vivo.push.sdk.service.PushService");
            context.startService(intent);
            return;
        }
        C4010u.m13292a("Utility", "illegality abe adapter : pushPkg = " + m13180a + " ; srcPkg = " + stringExtra);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00eb A[Catch: Exception -> 0x00e7, TryCatch #5 {Exception -> 0x00e7, blocks: (B:80:0x00e3, B:68:0x00eb, B:70:0x00ef), top: B:79:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.ContentProviderClient, android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m13215a(android.content.Context r17, java.lang.String r18, java.lang.String r19, long r20) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.C3990ag.m13215a(android.content.Context, java.lang.String, java.lang.String, long):boolean");
    }

    /* renamed from: a */
    public static boolean m13216a(Context context, String str, boolean z) {
        Cursor m13208a;
        Cursor cursor = null;
        try {
        } catch (Exception e2) {
            C4010u.m13293a("Utility", "close", e2);
        }
        try {
            try {
                Uri uri = C4018x.f14289e;
                String[] strArr = new String[2];
                strArr[0] = str;
                strArr[1] = z ? "1" : "0";
                m13208a = m13208a(uri, "appPkgName = ? and agreePrivacyStatement = ? ", strArr, context);
            } catch (Exception e3) {
                C4010u.m13293a("Utility", "syncAgreePrivacyStatement", e3);
                if (0 != 0) {
                    cursor.close();
                }
            }
            if (m13208a == null) {
                C4010u.m13292a("Utility", "cursor is null");
                if (m13208a != null) {
                    try {
                        m13208a.close();
                    } catch (Exception e4) {
                        C4010u.m13293a("Utility", "close", e4);
                    }
                }
                return false;
            }
            if (!m13208a.moveToFirst()) {
                if (m13208a != null) {
                    m13208a.close();
                }
                return false;
            }
            boolean parseBoolean = Boolean.parseBoolean(m13208a.getString(m13208a.getColumnIndex("agreePrivacyStatement")));
            if (m13208a != null) {
                try {
                    m13208a.close();
                } catch (Exception e5) {
                    C4010u.m13293a("Utility", "close", e5);
                }
            }
            return parseBoolean;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e6) {
                    C4010u.m13293a("Utility", "close", e6);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.database.Cursor m13208a(android.net.Uri r12, java.lang.String r13, java.lang.String[] r14, android.content.Context r15) {
        /*
            java.lang.String r0 = "close"
            r1 = 24
            r2 = 0
            java.lang.String r3 = "Utility"
            if (r15 != 0) goto Lf
            java.lang.String r12 = "context is null"
            com.vivo.push.util.C4010u.m13292a(r3, r12)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            return r2
        Lf:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r4 < r1) goto L2f
            android.content.ContentResolver r4 = r15.getContentResolver()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            android.content.ContentProviderClient r4 = r4.acquireUnstableContentProviderClient(r12)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6b
            if (r4 == 0) goto L2d
            java.lang.String r5 = "client is null"
            com.vivo.push.util.C4010u.m13292a(r3, r5)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            r7 = 0
            r10 = 0
            r5 = r4
            r6 = r12
            r8 = r13
            r9 = r14
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            goto L31
        L2d:
            r5 = r2
            goto L31
        L2f:
            r4 = r2
            r5 = r4
        L31:
            if (r5 != 0) goto L43
            android.content.ContentResolver r6 = r15.getContentResolver()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            r8 = 0
            r11 = 0
            r7 = r12
            r9 = r13
            r10 = r14
            android.database.Cursor r5 = r6.query(r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            goto L43
        L41:
            r12 = move-exception
            goto L6d
        L43:
            if (r5 != 0) goto L59
            java.lang.String r12 = "cursor is null"
            com.vivo.push.util.C4010u.m13292a(r3, r12)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L81
            if (r4 == 0) goto L58
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L54
            if (r12 < r1) goto L58
            r4.close()     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r12 = move-exception
            com.vivo.push.util.C4010u.m13293a(r3, r0, r12)
        L58:
            return r2
        L59:
            if (r4 == 0) goto L67
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L63
            if (r12 < r1) goto L67
            r4.close()     // Catch: java.lang.Exception -> L63
            goto L67
        L63:
            r12 = move-exception
            com.vivo.push.util.C4010u.m13293a(r3, r0, r12)
        L67:
            return r5
        L68:
            r12 = move-exception
            r4 = r2
            goto L82
        L6b:
            r12 = move-exception
            r4 = r2
        L6d:
            java.lang.String r13 = "queryContentResolver"
            com.vivo.push.util.C4010u.m13293a(r3, r13, r12)     // Catch: java.lang.Throwable -> L81
            if (r4 == 0) goto L80
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L7c
            if (r12 < r1) goto L80
            r4.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r12 = move-exception
            com.vivo.push.util.C4010u.m13293a(r3, r0, r12)
        L80:
            return r2
        L81:
            r12 = move-exception
        L82:
            if (r4 == 0) goto L90
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L8c
            if (r13 < r1) goto L90
            r4.close()     // Catch: java.lang.Exception -> L8c
            goto L90
        L8c:
            r13 = move-exception
            com.vivo.push.util.C4010u.m13293a(r3, r0, r13)
        L90:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.C3990ag.m13208a(android.net.Uri, java.lang.String, java.lang.String[], android.content.Context):android.database.Cursor");
    }
}
