package com.umeng.commonsdk.statistics;

import com.umeng.commonsdk.statistics.common.ULog;

/* loaded from: classes2.dex */
public class AnalyticsConstants {
    public static final String CFG_FIELD_KEY = "cfgfd";
    public static boolean CHECK_DEVICE = true;
    public static final String LOG_TAG = "MobclickAgent";

    /* renamed from: OS */
    public static final String f12711OS = "Android";
    public static final String SDK_TYPE = "Android";
    public static boolean SUB_PROCESS_EVENT = false;
    public static final String ZERO_RESPONSE_FLAG = "iscfg";
    private static int commonDeviceType = 1;
    public static String[] APPLOG_URL_LIST = {UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    public static final boolean UM_DEBUG = ULog.DEBUG;

    public static synchronized int getDeviceType() {
        int i2;
        synchronized (AnalyticsConstants.class) {
            i2 = commonDeviceType;
        }
        return i2;
    }

    public static void setDeviceType(int i2) {
        commonDeviceType = i2;
    }
}
