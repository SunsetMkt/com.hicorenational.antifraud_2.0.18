package com.umeng.commonsdk.debug;

import com.umeng.commonsdk.UMConfigure;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class UMRTLog {
    private static final String RTLOG_ENABLE = "1";
    private static final String RTLOG_PROP = "debug.umeng.rtlog";
    public static final String RTLOG_TAG = "MobclickRT";

    private UMRTLog() {
    }

    /* renamed from: d */
    public static void m11554d(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    /* renamed from: e */
    public static void m11555e(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    /* renamed from: i */
    public static void m11556i(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    /* renamed from: sd */
    public static void m11557sd(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: se */
    public static void m11558se(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: si */
    public static void m11559si(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: sv */
    public static void m11560sv(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: sw */
    public static void m11561sw(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    /* renamed from: v */
    public static void m11562v(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    /* renamed from: w */
    public static void m11563w(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    private static String warpperMsg(String str, boolean z) {
        if (!z) {
            return str;
        }
        StringBuffer stringBuffer = null;
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length >= 3) {
                String fileName = stackTrace[2].getFileName();
                String methodName = stackTrace[2].getMethodName();
                int lineNumber = stackTrace[2].getLineNumber();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("<");
                stringBuffer2.append(fileName);
                stringBuffer2.append(Constants.COLON_SEPARATOR);
                stringBuffer2.append(methodName);
                stringBuffer2.append(Constants.COLON_SEPARATOR);
                stringBuffer2.append(lineNumber);
                stringBuffer2.append("> ");
                stringBuffer2.append(str);
                stringBuffer = stringBuffer2;
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
