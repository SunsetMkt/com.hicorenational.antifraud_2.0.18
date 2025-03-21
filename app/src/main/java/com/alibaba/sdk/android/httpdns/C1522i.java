package com.alibaba.sdk.android.httpdns;

import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.alibaba.sdk.android.httpdns.i */
/* loaded from: classes.dex */
public class C1522i {

    /* renamed from: a */
    private static ILogger f3930a = null;

    /* renamed from: c */
    private static int f3931c = -1;

    /* renamed from: c */
    private static boolean f3932c = false;

    /* renamed from: a */
    public static void m3523a(Throwable th) {
        if (!f3932c || th == null) {
            return;
        }
        th.printStackTrace();
    }

    /* renamed from: c */
    private static String m3524c() {
        try {
            if (f3931c == -1) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (stackTrace[i2].getMethodName().equals("getTraceInfo")) {
                        f3931c = i3 + 1;
                        break;
                    }
                    i3++;
                    i2++;
                }
            }
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[f3931c + 1];
            return stackTraceElement.getFileName() + Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + " - [" + stackTraceElement.getMethodName() + "]";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: d */
    public static void m3525d(String str) {
        if (f3932c && str != null) {
            String str2 = Thread.currentThread().getId() + " - " + m3524c() + " - " + str;
        }
        ILogger iLogger = f3930a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    /* renamed from: e */
    public static void m3526e(String str) {
        if (f3932c && str != null) {
            String str2 = Thread.currentThread().getId() + " - " + m3524c() + " - " + str;
        }
        ILogger iLogger = f3930a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    /* renamed from: f */
    public static void m3527f(String str) {
        if (f3932c && str != null) {
            String str2 = Thread.currentThread().getId() + " - " + m3524c() + " - " + str;
        }
        ILogger iLogger = f3930a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    static synchronized void setLogEnabled(boolean z) {
        synchronized (C1522i.class) {
            f3932c = z;
        }
    }

    static void setLogger(ILogger iLogger) {
        f3930a = iLogger;
    }
}
