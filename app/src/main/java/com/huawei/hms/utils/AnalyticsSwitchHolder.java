package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.stats.C2507a;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;

/* loaded from: classes.dex */
public class AnalyticsSwitchHolder {
    public static final int ANALYTICS_DISABLED = 2;
    public static final int ANALYTICS_ENABLED = 1;

    /* renamed from: a */
    private static volatile int f7922a;

    /* renamed from: b */
    private static final Object f7923b = new Object();

    /* renamed from: c */
    private static volatile Long f7924c = 0L;

    /* renamed from: d */
    private static volatile boolean f7925d = false;

    /* renamed from: e */
    private static volatile boolean f7926e = false;

    /* renamed from: com.huawei.hms.utils.AnalyticsSwitchHolder$a */
    class RunnableC2537a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7927a;

        RunnableC2537a(Context context) {
            this.f7927a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnalyticsSwitchHolder.m7734f(this.f7927a);
            HMSLog.m7717i("AnalyticsSwitchHolder", "getStateForHmsAnalyticsProvider");
        }
    }

    /* renamed from: com.huawei.hms.utils.AnalyticsSwitchHolder$b */
    class RunnableC2538b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7928a;

        RunnableC2538b(Context context) {
            this.f7928a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m7717i("AnalyticsSwitchHolder", "enter setAnalyticsStateAndTimestamp");
            AnalyticsSwitchHolder.m7734f(this.f7928a);
            HMSLog.m7717i("AnalyticsSwitchHolder", "quit setAnalyticsStateAndTimestamp");
        }
    }

    /* renamed from: b */
    private static boolean m7730b(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.m7715e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bireport.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.m7715e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
            } catch (RuntimeException e2) {
                HMSLog.m7716e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", e2);
            }
        }
        HMSLog.m7717i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    }

    /* renamed from: c */
    private static void m7731c(Context context) {
        f7924c = Long.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        new Thread(new RunnableC2537a(context), "Thread-getStateForHmsAnalyticsProvider").start();
    }

    /* renamed from: d */
    private static boolean m7732d(Context context) {
        return RegionUtils.isChinaROM(context);
    }

    /* renamed from: e */
    private static void m7733e(Context context) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (timestamp.getTime() - f7924c.longValue() < 86400000 || f7924c.longValue() <= 0) {
            return;
        }
        f7924c = Long.valueOf(timestamp.getTime());
        new Thread(new RunnableC2538b(context), "Thread-refreshOobeAnalyticsState").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static void m7734f(Context context) {
        if (context == null) {
            HMSLog.m7715e("AnalyticsSwitchHolder", "In setAnalyticsState、, context is null.");
            return;
        }
        if (HiAnalyticsUtils.getInstance().getOobeAnalyticsState(context) != 1) {
            synchronized (f7923b) {
                f7922a = 2;
            }
            C2507a.m7656c().m7657a();
            return;
        }
        synchronized (f7923b) {
            f7922a = 1;
        }
        if (HiAnalyticsUtils.getInstance().getInitFlag() || f7925d) {
            return;
        }
        HMSBIInitializer.getInstance(context).initHaSDK();
        f7925d = true;
    }

    public static int getAndRefreshAnalyticsState(Context context) {
        int i2;
        synchronized (f7923b) {
            isAnalyticsDisabled(context);
            i2 = f7922a;
        }
        return i2;
    }

    public static boolean getBiSetting(Context context) {
        Bundle bundle;
        if (context == null) {
            HMSLog.m7715e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                    return bundle.getBoolean("com.huawei.hms.client.bi.setting");
                }
            } catch (AndroidException unused) {
                HMSLog.m7715e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
            } catch (RuntimeException e2) {
                HMSLog.m7716e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", e2);
            }
        }
        HMSLog.m7717i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    }

    public static boolean isAnalyticsDisabled(Context context) {
        synchronized (f7923b) {
            if (f7922a == 0) {
                if (context == null) {
                    return true;
                }
                if (m7730b(context)) {
                    HMSLog.m7717i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
                    f7922a = 1;
                } else if (getBiSetting(context)) {
                    HMSLog.m7717i("AnalyticsSwitchHolder", "Builder->biSetting :true");
                    f7922a = 2;
                } else if (m7732d(context)) {
                    f7922a = 1;
                } else {
                    HMSLog.m7717i("AnalyticsSwitchHolder", "not ChinaROM");
                    f7922a = 3;
                    f7926e = true;
                    m7731c(context);
                }
            } else if (f7926e) {
                m7733e(context);
            }
            return f7922a != 1;
        }
    }
}
