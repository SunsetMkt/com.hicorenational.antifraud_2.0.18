package com.umeng.analytics.pro;

import com.xiaomi.mipush.sdk.Constants;

/* compiled from: Logger.java */
/* renamed from: com.umeng.analytics.pro.bg */
/* loaded from: classes2.dex */
public class C3350bg {

    /* renamed from: a */
    private static final String f11547a = "OpenId";

    /* renamed from: b */
    private static boolean f11548b = false;

    /* renamed from: a */
    public static void m10899a(boolean z) {
        String str = "setDebug:" + z;
        f11548b = z;
    }

    /* renamed from: b */
    public static void m10900b(String str, Object... objArr) {
        if (f11548b) {
            m10903e(str, objArr);
        }
    }

    /* renamed from: c */
    public static void m10901c(String str, Object... objArr) {
        if (f11548b) {
            m10903e(str, objArr);
        }
    }

    /* renamed from: d */
    public static void m10902d(String str, Object... objArr) {
        if (f11548b) {
            m10903e(str, objArr);
        }
    }

    /* renamed from: e */
    private static String m10903e(String str, Object... objArr) {
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
                sb.append(m10897a(objArr[i2], objArr[i3]));
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
    public static void m10898a(String str, Object... objArr) {
        if (f11548b) {
            m10903e(str, objArr);
        }
    }

    /* renamed from: a */
    private static String m10897a(Object obj, Object obj2) {
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
}
