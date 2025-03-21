package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public abstract class SafePrintException {
    /* renamed from: a */
    private static boolean m8041a(String str) {
        for (String str2 : new String[]{"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", "java.security.acl.NotOwnerException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.net.BindException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.sql.SQLException"}) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public static String getStackTrace(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(AbstractC1191a.f2568g);
        }
        sb.append("Exception: ");
        sb.append(th.getClass().getName());
        sb.append('\n');
        if (!m8041a(th.getClass().getCanonicalName())) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                sb.append("Stack trace is NULL!");
                sb.append('\n');
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public static void print(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        getStackTrace(str2, th);
    }
}
