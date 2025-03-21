package com.umeng.p221ut.p222a.p225c;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* renamed from: com.umeng.ut.a.c.e */
/* loaded from: classes2.dex */
public class C3810e {

    /* renamed from: b */
    private static boolean f13873b = false;

    /* renamed from: c */
    private static boolean f13874c = false;

    /* renamed from: a */
    public static boolean m12785a() {
        return f13873b;
    }

    /* renamed from: b */
    public static void m12787b(String str, Object... objArr) {
        if (f13874c) {
            m12789d();
            m12782a(str, objArr);
        }
    }

    /* renamed from: c */
    public static void m12788c() {
        if (f13873b) {
            m12789d();
            m12782a((String) null, new Object[0]);
        }
    }

    /* renamed from: d */
    private static String m12789d() {
        String str;
        String str2;
        StackTraceElement m12780a = m12780a();
        if (m12780a != null) {
            String className = m12780a.getClassName();
            str2 = !TextUtils.isEmpty(className) ? className.substring(className.lastIndexOf(46) + 1) : "";
            str = m12780a.getMethodName();
        } else {
            str = "";
            str2 = str;
        }
        return "Utdid." + str2 + "." + str + "." + String.valueOf(Process.myPid()) + "." + (Thread.currentThread().getId() + "");
    }

    /* renamed from: a */
    public static void m12784a(String str, Object... objArr) {
        if (f13873b) {
            m12789d();
            m12782a(str, objArr);
        }
    }

    /* renamed from: b */
    public static void m12786b(String str, Throwable th, Object... objArr) {
        if (f13874c) {
            m12789d();
            m12782a(str, objArr);
        }
    }

    /* renamed from: a */
    public static void m12783a(String str, Throwable th, Object... objArr) {
        if (f13873b) {
            m12789d();
            m12782a(str, objArr);
        }
    }

    /* renamed from: a */
    private static String m12781a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    /* renamed from: a */
    private static String m12782a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        int i2 = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append(m12781a(objArr[i2], objArr[i3]));
                if (i3 < length - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static StackTraceElement m12780a() {
        try {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(C3810e.class.getName())) {
                    return stackTraceElement;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
