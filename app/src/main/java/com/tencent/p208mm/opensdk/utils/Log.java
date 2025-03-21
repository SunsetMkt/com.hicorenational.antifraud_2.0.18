package com.tencent.p208mm.opensdk.utils;

/* loaded from: classes2.dex */
public class Log {
    private static ILog logImpl;

    /* renamed from: d */
    public static void m10363d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.m10358d(str, str2);
    }

    /* renamed from: e */
    public static void m10364e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.m10359e(str, str2);
    }

    /* renamed from: i */
    public static void m10365i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.m10360i(str, str2);
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    /* renamed from: v */
    public static void m10366v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.m10361v(str, str2);
    }

    /* renamed from: w */
    public static void m10367w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            return;
        }
        iLog.m10362w(str, str2);
    }
}
