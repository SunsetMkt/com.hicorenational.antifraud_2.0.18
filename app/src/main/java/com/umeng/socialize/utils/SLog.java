package com.umeng.socialize.utils;

import android.os.Bundle;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SLog {
    private static boolean DEBUG = true;

    /* renamed from: E */
    private static final int f13815E = 0;

    /* renamed from: I */
    private static final int f13816I = 2;
    private static final String PRIVATE = "priviteSocial";
    private static final String TAG = "Social";

    /* renamed from: AQ */
    public static void m12715AQ(String str, String str2) {
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.m11550aq(TAG, 0, str, str2);
    }

    public static void BUNDLE(Bundle bundle) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.bundle(TAG, 2, bundle);
        }
    }

    /* renamed from: E */
    public static void m12716E(String str) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(TAG, 0, split);
        }
    }

    /* renamed from: I */
    public static void m12717I(String str) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(TAG, 2, split);
        }
    }

    public static void JARRY(JSONArray jSONArray) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.jsonArry(TAG, jSONArray);
        }
    }

    public static void JSON(JSONObject jSONObject) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.jsonObject(TAG, jSONObject);
        }
    }

    /* renamed from: TE */
    public static void m12718TE(String str, String str2) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str2.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social_" + str, 0, split);
        }
    }

    /* renamed from: TI */
    public static void m12719TI(String str, String str2) {
        if (UMConfigure.umDebugLog != null) {
            String[] split = str2.split("\n");
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo("Social_" + str, 2, split);
        }
    }

    public static void debug(String str) {
        if (UMConfigure.umDebugLog == null || !DEBUG) {
            return;
        }
        UMLog.mutlInfo(PRIVATE, 2, "[private log]  " + str);
    }

    public static void error(Throwable th) {
        if (UMConfigure.umDebugLog != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            String[] strArr = new String[stackTrace.length + 2];
            strArr[0] = "错误信息如下:";
            strArr[1] = "错误类型:" + th.getMessage();
            int i2 = 2;
            for (StackTraceElement stackTraceElement : stackTrace) {
                strArr[i2] = "        at\t " + stackTraceElement.toString();
                i2++;
            }
            UMLog uMLog = UMConfigure.umDebugLog;
            UMLog.mutlInfo(TAG, 0, strArr);
        }
    }

    public static boolean isDebug() {
        if (UMConfigure.umDebugLog != null) {
            return UMConfigure.isDebugLog();
        }
        return false;
    }

    public static void mutlE(String... strArr) {
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.mutlInfo(TAG, 0, strArr);
    }

    public static void mutlI(String... strArr) {
        if (UMConfigure.umDebugLog != null) {
            UMLog.mutlInfo(TAG, 2, strArr);
        }
    }

    public static void runtimePrint(String str) {
        UMRTLog.m11555e(PRIVATE, str);
    }

    public static void selfLog(String str) {
    }

    public static void welcome() {
        UMConfigure.isDebugLog();
    }

    public static void error(String str, Throwable th) {
        if (UMConfigure.umDebugLog == null || th == null) {
            return;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String[] strArr = new String[stackTrace.length + 2];
        strArr[0] = str;
        strArr[1] = "错误类型:" + th.getMessage();
        int i2 = 2;
        for (StackTraceElement stackTraceElement : stackTrace) {
            strArr[i2] = "        at\t " + stackTraceElement.toString();
            i2++;
        }
        UMLog uMLog = UMConfigure.umDebugLog;
        UMLog.mutlInfo(TAG, 0, strArr);
    }
}
