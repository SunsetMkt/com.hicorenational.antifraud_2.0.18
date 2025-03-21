package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.v */
/* loaded from: classes.dex */
public class C2452v {

    /* renamed from: a */
    private static C2431m0 f7638a = new C2431m0();

    /* renamed from: a */
    public static void m7378a(int i2) {
        f7638a.m7231a(i2);
    }

    /* renamed from: a */
    public static void m7379a(String str, String str2) {
        if (!m7381a() || str == null || str2 == null) {
            return;
        }
        f7638a.m7233b(3, str, str2);
    }

    /* renamed from: a */
    public static void m7380a(String str, String str2, Object... objArr) {
        if (!m7386c() || str == null || str2 == null) {
            return;
        }
        f7638a.m7233b(4, str, String.format(str2, objArr));
    }

    /* renamed from: a */
    private static boolean m7381a() {
        return f7638a.m7234b(3);
    }

    /* renamed from: b */
    public static void m7382b(String str, String str2) {
        if (!m7384b() || str == null || str2 == null) {
            return;
        }
        f7638a.m7233b(6, str, str2);
    }

    /* renamed from: b */
    public static void m7383b(String str, String str2, Object... objArr) {
        m7387d(str, String.format(str2, objArr));
    }

    /* renamed from: b */
    private static boolean m7384b() {
        return f7638a.m7234b(6);
    }

    /* renamed from: c */
    public static void m7385c(String str, String str2) {
        if (!m7386c() || str == null || str2 == null) {
            return;
        }
        f7638a.m7233b(4, str, str2);
    }

    /* renamed from: c */
    private static boolean m7386c() {
        return f7638a.m7234b(4);
    }

    /* renamed from: d */
    public static void m7387d(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f7638a.m7233b(4, str, str2);
    }

    /* renamed from: d */
    private static boolean m7388d() {
        return f7638a.m7234b(5);
    }

    /* renamed from: e */
    public static void m7389e(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f7638a.m7233b(5, str, str2);
    }

    /* renamed from: f */
    public static void m7390f(String str, String str2) {
        if (!m7388d() || str == null || str2 == null) {
            return;
        }
        f7638a.m7233b(5, str, str2);
    }
}
