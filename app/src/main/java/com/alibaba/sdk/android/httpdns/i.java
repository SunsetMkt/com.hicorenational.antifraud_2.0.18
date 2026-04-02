package com.alibaba.sdk.android.httpdns;

import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private static ILogger a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f2578c = -1;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private static boolean f21c = false;

    public static void a(Throwable th) {
        if (!f21c || th == null) {
            return;
        }
        th.printStackTrace();
    }

    private static String c() {
        try {
            if (f2578c == -1) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (stackTrace[i2].getMethodName().equals("getTraceInfo")) {
                        f2578c = i3 + 1;
                        break;
                    }
                    i3++;
                    i2++;
                }
            }
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[f2578c + 1];
            return stackTraceElement.getFileName() + Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + " - [" + stackTraceElement.getMethodName() + "]";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void d(String str) {
        if (f21c && str != null) {
            String str2 = Thread.currentThread().getId() + " - " + c() + " - " + str;
        }
        ILogger iLogger = a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    public static void e(String str) {
        if (f21c && str != null) {
            String str2 = Thread.currentThread().getId() + " - " + c() + " - " + str;
        }
        ILogger iLogger = a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    public static void f(String str) {
        if (f21c && str != null) {
            String str2 = Thread.currentThread().getId() + " - " + c() + " - " + str;
        }
        ILogger iLogger = a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    static synchronized void setLogEnabled(boolean z) {
        f21c = z;
    }

    static void setLogger(ILogger iLogger) {
        a = iLogger;
    }
}
