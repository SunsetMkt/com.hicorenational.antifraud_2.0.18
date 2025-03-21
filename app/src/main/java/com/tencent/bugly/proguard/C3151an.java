package com.tencent.bugly.proguard;

import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.an */
/* loaded from: classes2.dex */
public class C3151an {

    /* renamed from: a */
    public static String f10570a = "CrashReportInfo";

    /* renamed from: b */
    public static String f10571b = "CrashReport";

    /* renamed from: c */
    public static boolean f10572c = false;

    /* renamed from: a */
    private static boolean m9912a(int i2, String str, Object... objArr) {
        if (!f10572c) {
            return false;
        }
        m9924f(str, objArr);
        return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5;
    }

    /* renamed from: b */
    public static boolean m9918b(String str, Object... objArr) {
        return m9912a(5, str, objArr);
    }

    /* renamed from: c */
    public static boolean m9921c(String str, Object... objArr) {
        return m9912a(1, str, objArr);
    }

    /* renamed from: d */
    public static boolean m9922d(String str, Object... objArr) {
        return m9912a(2, str, objArr);
    }

    /* renamed from: e */
    public static boolean m9923e(String str, Object... objArr) {
        return m9912a(3, str, objArr);
    }

    /* renamed from: f */
    private static String m9924f(String str, Object... objArr) {
        return str == null ? AbstractC1191a.f2571h : (objArr == null || objArr.length == 0) ? str : String.format(Locale.US, str, objArr);
    }

    /* renamed from: b */
    public static boolean m9917b(Class cls, String str, Object... objArr) {
        return m9912a(1, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: c */
    public static boolean m9920c(Class cls, String str, Object... objArr) {
        return m9912a(3, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: a */
    private static boolean m9913a(int i2, Throwable th) {
        if (f10572c) {
            return m9912a(i2, C3154aq.m9957a(th), new Object[0]);
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m9919b(Throwable th) {
        return m9913a(3, th);
    }

    /* renamed from: a */
    public static boolean m9915a(String str, Object... objArr) {
        return m9912a(0, str, objArr);
    }

    /* renamed from: a */
    public static boolean m9914a(Class cls, String str, Object... objArr) {
        return m9912a(0, String.format(Locale.US, "[%s] %s", cls.getSimpleName(), str), objArr);
    }

    /* renamed from: a */
    public static boolean m9916a(Throwable th) {
        return m9913a(2, th);
    }
}
