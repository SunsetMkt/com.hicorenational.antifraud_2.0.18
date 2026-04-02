package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.j;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_START_TIME = "startTime";
    static double[] a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f6940b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f6941c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f6942d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f6943e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = at.b().b(at.A);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Object f6944f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f6945g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f6946h = "";

    static void a(String str) {
        f6941c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            if (cls != null) {
                return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f6944f) {
            str = f6946h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f6942d)) {
            f6942d = com.umeng.common.b.a(context).c();
        }
        return f6942d;
    }

    public static int getVerticalType(Context context) {
        if (f6943e == 0) {
            f6943e = com.umeng.common.b.a(context).d();
        }
        return f6943e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f6944f) {
            z = f6945g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f6944f) {
            f6945g = false;
            f6946h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f6944f) {
            f6945g = true;
            if (map != null && map.containsKey(DEBUG_KEY)) {
                f6946h = map.get(DEBUG_KEY);
            }
        }
    }

    static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.A, 0, "\\|");
        } else {
            f6942d = str;
            com.umeng.common.b.a(context).a(f6942d);
        }
    }

    static void a(Context context, int i2) {
        f6943e = i2;
        com.umeng.common.b.a(context).a(f6943e);
    }
}
