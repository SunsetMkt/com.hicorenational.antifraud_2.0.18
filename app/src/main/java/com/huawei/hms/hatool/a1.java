package com.huawei.hms.hatool;

import java.util.Map;

/* loaded from: classes.dex */
public abstract class a1 {
    public static void a(String str, String str2, long j2) {
        s0 h2 = h(str, str2);
        if (h2 != null) {
            h2.a(j2);
        }
    }

    public static boolean a(String str, String str2) {
        s0 h2 = h(str, str2);
        if (h2 != null) {
            return h2.a();
        }
        return true;
    }

    public static int b(String str, String str2) {
        s0 h2 = h(str, str2);
        if (h2 != null) {
            return h2.d();
        }
        return 7;
    }

    public static boolean c(String str, String str2) {
        s0 h2 = h(str, str2);
        if (h2 != null) {
            return h2.g();
        }
        return true;
    }

    public static String d(String str, String str2) {
        s0 h2 = h(str, str2);
        return h2 != null ? h2.f() : "";
    }

    public static boolean e(String str, String str2) {
        s0 h2 = h(str, str2);
        if (h2 != null) {
            return h2.i();
        }
        return false;
    }

    public static String f(String str, String str2) {
        s0 h2 = h(str, str2);
        return h2 != null ? h2.h() : "";
    }

    public static String g(String str, String str2) {
        s0 h2 = h(str, str2);
        return h2 != null ? h2.n() : "";
    }

    private static s0 h(String str, String str2) {
        l1 a2 = s.c().a(str);
        if (a2 == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return a2.a(str2);
        }
        s0 a3 = a2.a("oper");
        return a3 == null ? a2.a("maint") : a3;
    }

    public static Map<String, String> i(String str, String str2) {
        s0 h2 = h(str, str2);
        if (h2 != null) {
            return h2.k();
        }
        return null;
    }

    public static long j(String str, String str2) {
        s0 h2 = h(str, str2);
        if (h2 != null) {
            return h2.l();
        }
        return 0L;
    }

    public static int k(String str, String str2) {
        s0 h2 = h(str, str2);
        if (h2 != null) {
            return h2.b();
        }
        return 10;
    }

    public static String l(String str, String str2) {
        s0 h2 = h(str, str2);
        return h2 != null ? h2.o() : "";
    }

    public static String m(String str, String str2) {
        s0 h2 = h(str, str2);
        return h2 != null ? h2.q() : "";
    }

    public static String n(String str, String str2) {
        s0 h2 = h(str, str2);
        return h2 != null ? h2.m() : "";
    }

    public static String o(String str, String str2) {
        s0 h2 = h(str, str2);
        return h2 != null ? h2.p() : "";
    }
}
