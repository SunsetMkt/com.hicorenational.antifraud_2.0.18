package com.umeng.socialize.p215a;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: UPLog.java */
/* renamed from: com.umeng.socialize.a.m */
/* loaded from: classes2.dex */
public class C3627m {

    /* renamed from: a */
    private static boolean f13511a = false;

    /* renamed from: a */
    public static void m12563a(boolean z) {
        f13511a = z;
    }

    /* renamed from: b */
    public static void m12566b(String str, Object... objArr) {
        if (m12564a()) {
            m12561a(4, str, m12560a(objArr));
        }
    }

    /* renamed from: c */
    public static void m12567c(String str, Object... objArr) {
        if (m12564a()) {
            m12561a(5, str, m12560a(objArr));
        }
    }

    /* renamed from: d */
    public static void m12568d(String str, Object... objArr) {
        if (m12564a()) {
            m12561a(6, str, m12560a(objArr));
        }
    }

    /* renamed from: a */
    public static boolean m12564a() {
        return f13511a;
    }

    /* renamed from: a */
    public static void m12562a(String str, Object... objArr) {
        if (m12564a()) {
            m12561a(3, str, m12560a(objArr));
        }
    }

    /* renamed from: b */
    private static void m12565b(int i2, String str, String str2) {
        if (i2 == 3) {
            m12558a(str);
            return;
        }
        if (i2 == 4) {
            m12558a(str);
        } else if (i2 == 5) {
            m12558a(str);
        } else {
            if (i2 != 6) {
                return;
            }
            m12558a(str);
        }
    }

    /* renamed from: a */
    private static void m12561a(int i2, String str, String str2) {
        if (str2 == null) {
            return;
        }
        while (str2.length() > 3072) {
            m12565b(i2, str, str2.substring(0, 3072));
            str2 = str2.substring(3072);
        }
        if (str2.length() > 0) {
            m12565b(i2, str, str2);
        }
    }

    /* renamed from: a */
    public static String m12559a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    /* renamed from: a */
    private static String m12558a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "AZX";
        }
        return "AZX." + str;
    }

    /* renamed from: a */
    private static String m12560a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }
}
