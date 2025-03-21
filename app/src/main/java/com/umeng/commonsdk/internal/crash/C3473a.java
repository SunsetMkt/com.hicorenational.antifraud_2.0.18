package com.umeng.commonsdk.internal.crash;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: UMCrashUtils.java */
/* renamed from: com.umeng.commonsdk.internal.crash.a */
/* loaded from: classes2.dex */
public class C3473a {
    /* renamed from: a */
    public static String m11609a(Throwable th) {
        String str = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            str = stringWriter.toString();
            printWriter.close();
            stringWriter.close();
            return str;
        } catch (Exception unused) {
            return str;
        }
    }
}
