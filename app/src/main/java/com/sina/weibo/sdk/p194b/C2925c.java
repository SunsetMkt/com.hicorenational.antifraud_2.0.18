package com.sina.weibo.sdk.p194b;

/* renamed from: com.sina.weibo.sdk.b.c */
/* loaded from: classes.dex */
public final class C2925c {

    /* renamed from: ai */
    private static boolean f9303ai = false;

    /* renamed from: a */
    public static void m8837a(String str, String str2) {
        if (f9303ai) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String str3 = (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2;
        }
    }

    /* renamed from: b */
    public static void m8838b(String str, String str2) {
        if (f9303ai) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String str3 = (stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName()) + ": " + str2;
        }
    }

    public static void setLoggerEnable(boolean z) {
        f9303ai = z;
    }
}
