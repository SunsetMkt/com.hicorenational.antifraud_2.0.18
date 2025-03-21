package com.huawei.hms.hatool;

import java.util.Map;

/* renamed from: com.huawei.hms.hatool.a1 */
/* loaded from: classes.dex */
public abstract class AbstractC2396a1 {
    /* renamed from: a */
    public static void m7018a(String str, String str2, long j2) {
        C2447s0 m7026h = m7026h(str, str2);
        if (m7026h != null) {
            m7026h.m7333a(j2);
        }
    }

    /* renamed from: a */
    public static boolean m7019a(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        if (m7026h != null) {
            return m7026h.m7337a();
        }
        return true;
    }

    /* renamed from: b */
    public static int m7020b(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        if (m7026h != null) {
            return m7026h.m7345d();
        }
        return 7;
    }

    /* renamed from: c */
    public static boolean m7021c(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        if (m7026h != null) {
            return m7026h.m7354g();
        }
        return true;
    }

    /* renamed from: d */
    public static String m7022d(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        return m7026h != null ? m7026h.m7351f() : "";
    }

    /* renamed from: e */
    public static boolean m7023e(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        if (m7026h != null) {
            return m7026h.m7356i();
        }
        return false;
    }

    /* renamed from: f */
    public static String m7024f(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        return m7026h != null ? m7026h.m7355h() : "";
    }

    /* renamed from: g */
    public static String m7025g(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        return m7026h != null ? m7026h.m7361n() : "";
    }

    /* renamed from: h */
    private static C2447s0 m7026h(String str, String str2) {
        C2429l1 m7328a = C2446s.m7326c().m7328a(str);
        if (m7328a == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return m7328a.m7220a(str2);
        }
        C2447s0 m7220a = m7328a.m7220a("oper");
        return m7220a == null ? m7328a.m7220a("maint") : m7220a;
    }

    /* renamed from: i */
    public static Map<String, String> m7027i(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        if (m7026h != null) {
            return m7026h.m7358k();
        }
        return null;
    }

    /* renamed from: j */
    public static long m7028j(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        if (m7026h != null) {
            return m7026h.m7359l();
        }
        return 0L;
    }

    /* renamed from: k */
    public static int m7029k(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        if (m7026h != null) {
            return m7026h.m7338b();
        }
        return 10;
    }

    /* renamed from: l */
    public static String m7030l(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        return m7026h != null ? m7026h.m7362o() : "";
    }

    /* renamed from: m */
    public static String m7031m(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        return m7026h != null ? m7026h.m7364q() : "";
    }

    /* renamed from: n */
    public static String m7032n(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        return m7026h != null ? m7026h.m7360m() : "";
    }

    /* renamed from: o */
    public static String m7033o(String str, String str2) {
        C2447s0 m7026h = m7026h(str, str2);
        return m7026h != null ? m7026h.m7363p() : "";
    }
}
