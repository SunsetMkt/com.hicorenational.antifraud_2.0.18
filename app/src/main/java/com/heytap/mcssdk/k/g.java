package com.heytap.mcssdk.k;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static final String a = "mcssdk---";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3950b = "MCS";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f3951c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f3952d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f3953e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f3954f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f3955g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f3956h = "-->";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f3957i = true;

    public static String a() {
        return f3950b;
    }

    public static void a(Exception exc) {
        if (!f3955g || exc == null) {
            return;
        }
        exc.getMessage();
    }

    public static void a(String str) {
        if (f3951c && f3957i) {
            String str2 = f3950b + f3956h + str;
        }
    }

    public static void a(String str, String str2) {
        if (f3951c && f3957i) {
            String str3 = f3950b + f3956h + str2;
        }
    }

    public static void a(String str, Throwable th) {
        if (f3955g) {
            th.toString();
        }
    }

    public static void a(boolean z) {
        f3951c = z;
    }

    public static void b(String str) {
        if (f3953e && f3957i) {
            String str2 = f3950b + f3956h + str;
        }
    }

    public static void b(String str, String str2) {
        if (f3953e && f3957i) {
            String str3 = f3950b + f3956h + str2;
        }
    }

    public static void b(boolean z) {
        f3953e = z;
    }

    public static boolean b() {
        return f3951c;
    }

    public static void c(String str) {
        if (f3952d && f3957i) {
            String str2 = f3950b + f3956h + str;
        }
    }

    public static void c(String str, String str2) {
        if (f3952d && f3957i) {
            String str3 = f3950b + f3956h + str2;
        }
    }

    public static void c(boolean z) {
        f3952d = z;
    }

    public static boolean c() {
        return f3953e;
    }

    public static void d(String str) {
        if (f3954f && f3957i) {
            String str2 = f3950b + f3956h + str;
        }
    }

    public static void d(String str, String str2) {
        if (f3954f && f3957i) {
            String str3 = f3950b + f3956h + str2;
        }
    }

    public static void d(boolean z) {
        f3954f = z;
    }

    public static boolean d() {
        return f3952d;
    }

    public static void e(String str) {
        if (f3955g && f3957i) {
            String str2 = f3950b + f3956h + str;
        }
    }

    public static void e(String str, String str2) {
        if (f3955g && f3957i) {
            String str3 = f3950b + f3956h + str2;
        }
    }

    public static void e(boolean z) {
        f3955g = z;
    }

    public static boolean e() {
        return f3954f;
    }

    public static void f(String str) {
        f3950b = str;
    }

    public static void f(boolean z) {
        f3957i = z;
        boolean z2 = f3957i;
        f3951c = z2;
        f3953e = z2;
        f3952d = z2;
        f3954f = z2;
        f3955g = z2;
    }

    public static boolean f() {
        return f3955g;
    }

    public static void g(String str) {
        f3956h = str;
    }

    public static boolean g() {
        return f3957i;
    }

    public static String h() {
        return f3956h;
    }
}
