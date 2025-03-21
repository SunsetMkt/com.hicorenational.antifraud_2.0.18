package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8757a = true;

    /* renamed from: b, reason: collision with root package name */
    public static List<a> f8758b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8759c;

    /* renamed from: d, reason: collision with root package name */
    private static ae f8760d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f8761e;

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.v;
        aVar.getClass();
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a(context, (BuglyStrategy) null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (f8761e) {
                an.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                return;
            }
            com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
            if (a(a2)) {
                f8757a = false;
                return;
            }
            String f2 = a2.f();
            if (f2 == null) {
                return;
            }
            a(context, f2, a2.B, buglyStrategy);
        }
    }

    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (f8761e) {
                an.d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                return;
            }
            if (str == null) {
                return;
            }
            f8761e = true;
            if (z) {
                f8759c = true;
                an.f9254c = true;
                an.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                an.e("--------------------------------------------------------------------------------------------", new Object[0]);
                an.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                an.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                an.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                an.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                an.e("--------------------------------------------------------------------------------------------", new Object[0]);
                an.b("[init] Open debug mode of Bugly.", new Object[0]);
            }
            an.a(" crash report start initializing...", new Object[0]);
            an.b("[init] Bugly start initializing...", new Object[0]);
            an.a("[init] Bugly complete version: v%s", "3.1.7(1.4.5)");
            Context a2 = aq.a(context);
            com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(a2);
            a3.t();
            ap.a(a2);
            f8760d = ae.a(a2, f8758b);
            ak.a(a2);
            com.tencent.bugly.crashreport.common.strategy.a a4 = com.tencent.bugly.crashreport.common.strategy.a.a(a2, f8758b);
            ac a5 = ac.a(a2);
            if (a(a3)) {
                f8757a = false;
                return;
            }
            a3.a(str);
            an.a("[param] Set APP ID:%s", str);
            a(buglyStrategy, a3);
            for (int i2 = 0; i2 < f8758b.size(); i2++) {
                try {
                    if (a5.a(f8758b.get(i2).id)) {
                        f8758b.get(i2).init(a2, z, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            com.tencent.bugly.crashreport.biz.b.a(a2, buglyStrategy);
            a4.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
            an.b("[init] Bugly initialization finished.", new Object[0]);
        }
    }

    private static void a(BuglyStrategy buglyStrategy, com.tencent.bugly.crashreport.common.info.a aVar) {
        byte[] bArr;
        if (buglyStrategy == null) {
            return;
        }
        String appVersion = buglyStrategy.getAppVersion();
        if (!TextUtils.isEmpty(appVersion)) {
            if (appVersion.length() > 100) {
                String substring = appVersion.substring(0, 100);
                an.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                appVersion = substring;
            }
            aVar.p = appVersion;
            an.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
        }
        try {
            if (buglyStrategy.isReplaceOldChannel()) {
                String appChannel = buglyStrategy.getAppChannel();
                if (!TextUtils.isEmpty(appChannel)) {
                    if (appChannel.length() > 100) {
                        String substring2 = appChannel.substring(0, 100);
                        an.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                        appChannel = substring2;
                    }
                    f8760d.a(556, "app_channel", appChannel.getBytes(), (ad) null, false);
                    aVar.s = appChannel;
                }
            } else {
                Map<String, byte[]> a2 = f8760d.a(556, (ad) null, true);
                if (a2 != null && (bArr = a2.get("app_channel")) != null) {
                    aVar.s = new String(bArr);
                }
            }
            an.a("[param] Set App channel: %s", aVar.s);
        } catch (Exception e2) {
            if (f8759c) {
                e2.printStackTrace();
            }
        }
        String appPackageName = buglyStrategy.getAppPackageName();
        if (!TextUtils.isEmpty(appPackageName)) {
            if (appPackageName.length() > 100) {
                String substring3 = appPackageName.substring(0, 100);
                an.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                appPackageName = substring3;
            }
            aVar.f8977d = appPackageName;
            an.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
        }
        String deviceID = buglyStrategy.getDeviceID();
        if (deviceID != null) {
            if (deviceID.length() > 100) {
                String substring4 = deviceID.substring(0, 100);
                an.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                deviceID = substring4;
            }
            aVar.c(deviceID);
            an.a("[param] Set device ID: %s", deviceID);
        }
        aVar.f8981h = buglyStrategy.isUploadProcess();
        ap.f9256a = buglyStrategy.isBuglyLogUpload();
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!f8758b.contains(aVar)) {
                f8758b.add(aVar);
            }
        }
    }
}
