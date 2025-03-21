package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.c */
/* loaded from: classes.dex */
public class C2189c {
    /* renamed from: a */
    public static void m6376a(String str) {
        String str2;
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "";
                break;
            } else {
                if (!stackTrace[i2].getClass().equals(C2189c.class)) {
                    String className = stackTrace[i2].getClassName();
                    str2 = className.substring(className.lastIndexOf(46) + 1);
                    break;
                }
                i2++;
            }
        }
        m6377a("HonorPush_" + str2, str, null);
    }

    /* renamed from: a */
    public static void m6377a(String str, String str2, Throwable th) {
        if (str2.length() > 4000) {
            int i2 = 0;
            while (i2 < str2.length()) {
                int i3 = i2 + 4000;
                if (str2.length() > i3) {
                    str2.substring(i2, i3);
                } else {
                    str2.substring(i2);
                }
                i2 = i3;
            }
        }
    }
}
