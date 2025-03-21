package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes.dex */
public class HianalyticsExist {

    /* renamed from: a */
    private static final Object f7814a = new Object();

    /* renamed from: b */
    private static boolean f7815b = false;

    /* renamed from: c */
    private static boolean f7816c = false;

    public static boolean isHianalyticsExist() {
        boolean z;
        synchronized (f7814a) {
            if (!f7815b) {
                boolean z2 = false;
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                    z = true;
                } catch (ClassNotFoundException unused) {
                    HMSLog.m7717i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                    z = false;
                }
                try {
                    Class.forName("com.huawei.hms.hatool.HmsHiAnalyticsUtils");
                    z2 = true;
                } catch (ClassNotFoundException unused2) {
                    HMSLog.m7717i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HmsHiAnalyticsUtils.");
                }
                if (z && !z2) {
                    f7816c = true;
                }
                f7815b = true;
                HMSLog.m7717i("HianalyticsExist", "hianalytics exist: " + f7816c);
            }
        }
        return f7816c;
    }
}
