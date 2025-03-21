package com.alibaba.sdk.android.utils.crashdefend;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: CrashDefendUtils.java */
/* renamed from: com.alibaba.sdk.android.utils.crashdefend.e */
/* loaded from: classes.dex */
class C1571e {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:
    
        if (r0 != null) goto L48;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void m3620a(android.content.Context r8, com.alibaba.sdk.android.utils.crashdefend.C1567a r9, java.util.List<com.alibaba.sdk.android.utils.crashdefend.C1569c> r10) {
        /*
            if (r8 != 0) goto L3
            return
        L3:
            monitor-enter(r10)
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r1.<init>()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            if (r9 == 0) goto L13
            java.lang.String r2 = "startSerialNumber"
            long r3 = r9.f4037a     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
        L13:
            if (r10 == 0) goto L73
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r9.<init>()     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.util.Iterator r2 = r10.iterator()     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
        L1e:
            boolean r3 = r2.hasNext()     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            if (r3 == 0) goto L6e
            java.lang.Object r3 = r2.next()     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            com.alibaba.sdk.android.utils.crashdefend.c r3 = (com.alibaba.sdk.android.utils.crashdefend.C1569c) r3     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            if (r3 == 0) goto L1e
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.<init>()     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r5 = "sdkId"
            java.lang.String r6 = r3.f4051a     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r5 = "sdkVersion"
            java.lang.String r6 = r3.f4054b     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r5 = "crashLimit"
            int r6 = r3.f4048a     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r5 = "crashCount"
            int r6 = r3.crashCount     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r5 = "waitTime"
            int r6 = r3.f4052b     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r5 = "registerSerialNumber"
            long r6 = r3.f4053b     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r5 = "startSerialNumber"
            long r6 = r3.f4049a     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r5 = "restoreCount"
            int r3 = r3.f4055c     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r4.put(r5, r3)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r9.put(r4)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            goto L1e
        L6e:
            java.lang.String r2 = "sdkList"
            r1.put(r2, r9)     // Catch: org.json.JSONException -> L73 java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
        L73:
            java.lang.String r9 = r1.toString()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            boolean r1 = m3621a(r8)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r2 = 0
            if (r1 == 0) goto L86
            java.lang.String r1 = "com_alibaba_aliyun_crash_defend_sdk_info"
            java.io.FileOutputStream r8 = r8.openFileOutput(r1, r2)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
        L84:
            r0 = r8
            goto La0
        L86:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r1.<init>()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r3 = "com_alibaba_aliyun_crash_defend_sdk_info_"
            r1.append(r3)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r3 = m3619a(r8)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r1.append(r3)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            java.io.FileOutputStream r8 = r8.openFileOutput(r1, r2)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            goto L84
        La0:
            byte[] r8 = r9.getBytes()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            r0.write(r8)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb6 java.io.IOException -> Lb9
            if (r0 == 0) goto Lbc
        La9:
            r0.close()     // Catch: java.lang.Throwable -> Lb4 java.io.IOException -> Lbc
            goto Lbc
        Lad:
            r8 = move-exception
            if (r0 == 0) goto Lb3
            r0.close()     // Catch: java.io.IOException -> Lb3 java.lang.Throwable -> Lb4
        Lb3:
            throw r8     // Catch: java.lang.Throwable -> Lb4
        Lb4:
            r8 = move-exception
            goto Lbe
        Lb6:
            if (r0 == 0) goto Lbc
            goto La9
        Lb9:
            if (r0 == 0) goto Lbc
            goto La9
        Lbc:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb4
            return
        Lbe:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> Lb4
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.C1571e.m3620a(android.content.Context, com.alibaba.sdk.android.utils.crashdefend.a, java.util.List):void");
    }

    /* renamed from: b */
    private static String m3623b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    /* renamed from: c */
    private static String m3624c(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e2) {
            String str = "getProcessNameByActivityThread error: " + e2;
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (r1 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0049, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006b, code lost:
    
        if (r1 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0053, code lost:
    
        if (r1 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0050, code lost:
    
        if (r1 != null) goto L60;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean m3622a(android.content.Context r9, com.alibaba.sdk.android.utils.crashdefend.C1567a r10, java.util.List<com.alibaba.sdk.android.utils.crashdefend.C1569c> r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.C1571e.m3622a(android.content.Context, com.alibaba.sdk.android.utils.crashdefend.a, java.util.List):boolean");
    }

    /* renamed from: a */
    private static boolean m3621a(Context context) {
        return context.getPackageName().equalsIgnoreCase(m3619a(context));
    }

    /* renamed from: a */
    private static String m3619a(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        String m3624c = m3624c(context);
        if (!TextUtils.isEmpty(m3624c)) {
            return m3624c;
        }
        String m3618a = m3618a();
        return !TextUtils.isEmpty(m3618a) ? m3618a : m3623b(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [int] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m3618a() {
        /*
            int r0 = android.os.Process.myPid()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.append(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r0 = "/cmdline"
            r3.append(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 == 0) goto L3b
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L61
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L61
            goto L3c
        L39:
            r2 = move-exception
            goto L4b
        L3b:
            r0 = r1
        L3c:
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.io.IOException -> L42
            goto L60
        L42:
            r0 = move-exception
            r0.printStackTrace()
            goto L60
        L47:
            r0 = move-exception
            goto L65
        L49:
            r2 = move-exception
            r0 = r1
        L4b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r4 = "getProcessNameByPid error: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L61
            r3.append(r2)     // Catch: java.lang.Throwable -> L61
            r3.toString()     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L60
            r0.close()     // Catch: java.io.IOException -> L42
        L60:
            return r1
        L61:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L65:
            if (r1 == 0) goto L6f
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r1 = move-exception
            r1.printStackTrace()
        L6f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.crashdefend.C1571e.m3618a():java.lang.String");
    }
}
