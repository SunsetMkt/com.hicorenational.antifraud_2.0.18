package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3336at;
import com.umeng.analytics.pro.C3409j;
import com.umeng.common.C3443b;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: classes2.dex */
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

    /* renamed from: a */
    static double[] f11347a = null;

    /* renamed from: b */
    private static String f11348b = null;

    /* renamed from: c */
    private static String f11349c = null;

    /* renamed from: d */
    private static String f11350d = null;

    /* renamed from: e */
    private static int f11351e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = C3336at.m10865b().m10868b(C3336at.f11482A);

    /* renamed from: f */
    private static Object f11352f = new Object();

    /* renamed from: g */
    private static boolean f11353g = false;

    /* renamed from: h */
    private static String f11354h = "";

    /* renamed from: a */
    static void m10734a(String str) {
        f11349c = str;
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
        return f11347a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f11352f) {
            str = f11354h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f11350d)) {
            f11350d = C3443b.m11503a(context).m11513c();
        }
        return f11350d;
    }

    public static int getVerticalType(Context context) {
        if (f11351e == 0) {
            f11351e = C3443b.m11503a(context).m11514d();
        }
        return f11351e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f11352f) {
            z = f11353g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f11352f) {
            f11353g = false;
            f11354h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f11352f) {
            f11353g = true;
            if (map != null && map.containsKey(DEBUG_KEY)) {
                f11354h = map.get(DEBUG_KEY);
            }
        }
    }

    /* renamed from: a */
    static void m10733a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.m11549aq(C3409j.f12068A, 0, "\\|");
        } else {
            f11350d = str;
            C3443b.m11503a(context).m11509a(f11350d);
        }
    }

    /* renamed from: a */
    static void m10732a(Context context, int i2) {
        f11351e = i2;
        C3443b.m11503a(context).m11508a(f11351e);
    }
}
