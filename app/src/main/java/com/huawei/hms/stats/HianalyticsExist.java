package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes.dex */
public class HianalyticsExist {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4911b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4912c = false;

    public static boolean isHianalyticsExist() {
        boolean z;
        synchronized (a) {
            if (!f4911b) {
                boolean z2 = false;
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                    z = true;
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                    z = false;
                }
                try {
                    Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                    z2 = true;
                } catch (ClassNotFoundException unused2) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                }
                if (z && !z2) {
                    f4912c = true;
                }
                f4911b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f4912c);
            }
        }
        return f4912c;
    }
}
