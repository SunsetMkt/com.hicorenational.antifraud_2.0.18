package com.vivo.push.util;

import android.content.Context;

/* compiled from: LogUtil.java */
/* renamed from: com.vivo.push.util.u */
/* loaded from: classes2.dex */
public final class C4010u {

    /* renamed from: a */
    public static final InterfaceC4009t f14278a = new C4008s();

    /* renamed from: b */
    private static boolean f14279b;

    /* renamed from: c */
    private static boolean f14280c;

    static {
        m13307c();
    }

    /* renamed from: a */
    public static boolean m13300a() {
        return f14279b;
    }

    /* renamed from: b */
    public static boolean m13305b() {
        return f14279b && f14280c;
    }

    /* renamed from: c */
    private static void m13307c() {
        f14279b = C3990ag.m13218b("persist.sys.log.ctrl", "no").equals("yes");
    }

    /* renamed from: d */
    public static int m13309d(String str, String str2) {
        return f14278a.mo13290d(str, str2);
    }

    /* renamed from: e */
    public static int m13310e(String str, String str2) {
        return f14278a.mo13291e(str, str2);
    }

    /* renamed from: a */
    public static void m13299a(boolean z) {
        m13307c();
        f14280c = z;
    }

    /* renamed from: c */
    public static int m13306c(String str, String str2) {
        return f14278a.mo13288c(str, str2);
    }

    /* renamed from: b */
    public static int m13301b(String str, String str2) {
        return f14278a.mo13285b(str, str2);
    }

    /* renamed from: c */
    public static void m13308c(Context context, String str) {
        f14278a.mo13289c(context, str);
    }

    /* renamed from: a */
    public static int m13292a(String str, String str2) {
        return f14278a.mo13280a(str, str2);
    }

    /* renamed from: b */
    public static int m13302b(String str, String str2, Throwable th) {
        return f14278a.mo13286b(str, str2, th);
    }

    /* renamed from: a */
    public static int m13294a(String str, Throwable th) {
        return f14278a.mo13282a(str, th);
    }

    /* renamed from: b */
    public static void m13303b(Context context, String str) {
        f14278a.mo13287b(context, str);
    }

    /* renamed from: a */
    public static int m13293a(String str, String str2, Throwable th) {
        return f14278a.mo13281a(str, str2, th);
    }

    /* renamed from: b */
    public static void m13304b(String str) {
        if (f14279b) {
            f14278a.mo13288c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    /* renamed from: a */
    public static String m13295a(Throwable th) {
        return f14278a.mo13283a(th);
    }

    /* renamed from: a */
    public static void m13297a(Context context, String str) {
        f14278a.mo13284a(context, str);
    }

    /* renamed from: a */
    public static void m13298a(String str) {
        if (f14279b) {
            f14278a.mo13288c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    /* renamed from: a */
    public static void m13296a(int i2, String str) {
        m13292a("RunTimeException", "code: " + i2 + ", exceptionMsg: " + str);
    }
}
