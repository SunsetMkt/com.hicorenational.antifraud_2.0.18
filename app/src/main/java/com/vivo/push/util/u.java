package com.vivo.push.util;

import android.content.Context;

/* JADX INFO: compiled from: LogUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u {
    public static final t a = new s();

    /* JADX INFO: renamed from: b */
    private static boolean f8693b;

    /* JADX INFO: renamed from: c */
    private static boolean f8694c;

    static {
        c();
    }

    public static boolean a() {
        return f8693b;
    }

    public static boolean b() {
        return f8693b && f8694c;
    }

    private static void c() {
        f8693b = ag.b("persist.sys.log.ctrl", "no").equals("yes");
    }

    public static int d(String str, String str2) {
        return a.d(str, str2);
    }

    public static int e(String str, String str2) {
        return a.e(str, str2);
    }

    public static void a(boolean z) {
        c();
        f8694c = z;
    }

    public static int c(String str, String str2) {
        return a.c(str, str2);
    }

    public static int b(String str, String str2) {
        return a.b(str, str2);
    }

    public static void c(Context context, String str) {
        a.c(context, str);
    }

    public static int a(String str, String str2) {
        return a.a(str, str2);
    }

    public static int b(String str, String str2, Throwable th) {
        return a.b(str, str2, th);
    }

    public static int a(String str, Throwable th) {
        return a.a(str, th);
    }

    public static void b(Context context, String str) {
        a.b(context, str);
    }

    public static int a(String str, String str2, Throwable th) {
        return a.a(str, str2, th);
    }

    public static void b(String str) {
        if (f8693b) {
            a.c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    public static String a(Throwable th) {
        return a.a(th);
    }

    public static void a(Context context, String str) {
        a.a(context, str);
    }

    public static void a(String str) {
        if (f8693b) {
            a.c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    public static void a(int i2, String str) {
        a("RunTimeException", "code: " + i2 + ", exceptionMsg: " + str);
    }
}
