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

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a = true;

    /* JADX INFO: renamed from: b */
    public static List<a> f5994b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public static boolean f5995c;

    /* JADX INFO: renamed from: d */
    private static ae f5996d;

    /* JADX INFO: renamed from: e */
    private static boolean f5997e;

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.v;
        aVar.getClass();
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        a(context, (BuglyStrategy) null);
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (f5997e) {
            an.d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            return;
        }
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(context);
        if (a(aVarA)) {
            a = false;
            return;
        }
        String strF = aVarA.f();
        if (strF == null) {
            return;
        }
        a(context, strF, aVarA.B, buglyStrategy);
    }

    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        if (f5997e) {
            an.d("[init] initial Multi-times, ignore this.", new Object[0]);
            return;
        }
        if (context == null) {
            return;
        }
        if (str == null) {
            return;
        }
        f5997e = true;
        if (z) {
            f5995c = true;
            an.f6411c = true;
            an.d("Bugly debug\u6a21\u5f0f\u5f00\u542f\uff0c\u8bf7\u5728\u53d1\u5e03\u65f6\u628aisDebug\u5173\u95ed\u3002 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
            an.e("--------------------------------------------------------------------------------------------", new Object[0]);
            an.d("Bugly debug\u6a21\u5f0f\u5c06\u6709\u4ee5\u4e0b\u884c\u4e3a\u7279\u6027 -- The following list shows the behaviour of debug model: ", new Object[0]);
            an.d("[1] \u8f93\u51fa\u8be6\u7ec6\u7684Bugly SDK\u7684Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
            an.d("[2] \u6bcf\u4e00\u6761Crash\u90fd\u4f1a\u88ab\u7acb\u5373\u4e0a\u62a5 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
            an.d("[3] \u81ea\u5b9a\u4e49\u65e5\u5fd7\u5c06\u4f1a\u5728Logcat\u4e2d\u8f93\u51fa -- Custom log will be output to logcat.", new Object[0]);
            an.e("--------------------------------------------------------------------------------------------", new Object[0]);
            an.b("[init] Open debug mode of Bugly.", new Object[0]);
        }
        an.a(" crash report start initializing...", new Object[0]);
        an.b("[init] Bugly start initializing...", new Object[0]);
        an.a("[init] Bugly complete version: v%s", "3.1.7(1.4.5)");
        Context contextA = aq.a(context);
        com.tencent.bugly.crashreport.common.info.a aVarA = com.tencent.bugly.crashreport.common.info.a.a(contextA);
        aVarA.t();
        ap.a(contextA);
        f5996d = ae.a(contextA, f5994b);
        ak.a(contextA);
        com.tencent.bugly.crashreport.common.strategy.a aVarA2 = com.tencent.bugly.crashreport.common.strategy.a.a(contextA, f5994b);
        ac acVarA = ac.a(contextA);
        if (a(aVarA)) {
            a = false;
            return;
        }
        aVarA.a(str);
        an.a("[param] Set APP ID:%s", str);
        a(buglyStrategy, aVarA);
        for (int i2 = 0; i2 < f5994b.size(); i2++) {
            try {
                if (acVarA.a(f5994b.get(i2).id)) {
                    f5994b.get(i2).init(contextA, z, buglyStrategy);
                }
            } catch (Throwable th) {
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        com.tencent.bugly.crashreport.biz.b.a(contextA, buglyStrategy);
        aVarA2.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
        an.b("[init] Bugly initialization finished.", new Object[0]);
    }

    private static void a(BuglyStrategy buglyStrategy, com.tencent.bugly.crashreport.common.info.a aVar) {
        byte[] bArr;
        if (buglyStrategy == null) {
            return;
        }
        String appVersion = buglyStrategy.getAppVersion();
        if (!TextUtils.isEmpty(appVersion)) {
            if (appVersion.length() > 100) {
                String strSubstring = appVersion.substring(0, 100);
                an.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, strSubstring);
                appVersion = strSubstring;
            }
            aVar.p = appVersion;
            an.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
        }
        try {
            if (buglyStrategy.isReplaceOldChannel()) {
                String appChannel = buglyStrategy.getAppChannel();
                if (!TextUtils.isEmpty(appChannel)) {
                    if (appChannel.length() > 100) {
                        String strSubstring2 = appChannel.substring(0, 100);
                        an.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, strSubstring2);
                        appChannel = strSubstring2;
                    }
                    f5996d.a(556, "app_channel", appChannel.getBytes(), (ad) null, false);
                    aVar.s = appChannel;
                }
            } else {
                Map<String, byte[]> mapA = f5996d.a(556, (ad) null, true);
                if (mapA != null && (bArr = mapA.get("app_channel")) != null) {
                    aVar.s = new String(bArr);
                }
            }
            an.a("[param] Set App channel: %s", aVar.s);
        } catch (Exception e2) {
            if (f5995c) {
                e2.printStackTrace();
            }
        }
        String appPackageName = buglyStrategy.getAppPackageName();
        if (!TextUtils.isEmpty(appPackageName)) {
            if (appPackageName.length() > 100) {
                String strSubstring3 = appPackageName.substring(0, 100);
                an.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, strSubstring3);
                appPackageName = strSubstring3;
            }
            aVar.f6175d = appPackageName;
            an.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
        }
        String deviceID = buglyStrategy.getDeviceID();
        if (deviceID != null) {
            if (deviceID.length() > 100) {
                String strSubstring4 = deviceID.substring(0, 100);
                an.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, strSubstring4);
                deviceID = strSubstring4;
            }
            aVar.c(deviceID);
            an.a("[param] Set device ID: %s", deviceID);
        }
        aVar.f6179h = buglyStrategy.isUploadProcess();
        ap.a = buglyStrategy.isBuglyLogUpload();
    }

    public static synchronized void a(a aVar) {
        if (!f5994b.contains(aVar)) {
            f5994b.add(aVar);
        }
    }
}
