package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.C3111b;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.crashreport.common.strategy.C3116a;
import com.tencent.bugly.proguard.C3140ac;
import com.tencent.bugly.proguard.C3142ae;
import com.tencent.bugly.proguard.C3148ak;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3153ap;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.InterfaceC3141ad;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.b */
/* loaded from: classes2.dex */
public class C3072b {

    /* renamed from: a */
    public static boolean f9832a = true;

    /* renamed from: b */
    public static List<AbstractC3071a> f9833b = new ArrayList();

    /* renamed from: c */
    public static boolean f9834c;

    /* renamed from: d */
    private static C3142ae f9835d;

    /* renamed from: e */
    private static boolean f9836e;

    /* renamed from: a */
    private static boolean m9313a(C3113a c3113a) {
        List<String> list = c3113a.f10214v;
        c3113a.getClass();
        return list != null && list.contains("bugly");
    }

    /* renamed from: a */
    public static synchronized void m9308a(Context context) {
        synchronized (C3072b.class) {
            m9309a(context, (BuglyStrategy) null);
        }
    }

    /* renamed from: a */
    public static synchronized void m9309a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (C3072b.class) {
            if (f9836e) {
                C3151an.m9922d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                return;
            }
            C3113a m9531a = C3113a.m9531a(context);
            if (m9313a(m9531a)) {
                f9832a = false;
                return;
            }
            String m9571f = m9531a.m9571f();
            if (m9571f == null) {
                return;
            }
            m9310a(context, m9571f, m9531a.f10135B, buglyStrategy);
        }
    }

    /* renamed from: a */
    public static synchronized void m9310a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (C3072b.class) {
            if (f9836e) {
                C3151an.m9922d("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                return;
            }
            if (str == null) {
                return;
            }
            f9836e = true;
            if (z) {
                f9834c = true;
                C3151an.f10572c = true;
                C3151an.m9922d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                C3151an.m9923e("--------------------------------------------------------------------------------------------", new Object[0]);
                C3151an.m9922d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                C3151an.m9922d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                C3151an.m9922d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                C3151an.m9922d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                C3151an.m9923e("--------------------------------------------------------------------------------------------", new Object[0]);
                C3151an.m9918b("[init] Open debug mode of Bugly.", new Object[0]);
            }
            C3151an.m9915a(" crash report start initializing...", new Object[0]);
            C3151an.m9918b("[init] Bugly start initializing...", new Object[0]);
            C3151an.m9915a("[init] Bugly complete version: v%s", "3.1.7(1.4.5)");
            Context m9946a = C3154aq.m9946a(context);
            C3113a m9531a = C3113a.m9531a(m9946a);
            m9531a.m9587t();
            C3153ap.m9930a(m9946a);
            f9835d = C3142ae.m9818a(m9946a, f9833b);
            C3148ak.m9864a(m9946a);
            C3116a m9636a = C3116a.m9636a(m9946a, f9833b);
            C3140ac m9798a = C3140ac.m9798a(m9946a);
            if (m9313a(m9531a)) {
                f9832a = false;
                return;
            }
            m9531a.m9556a(str);
            C3151an.m9915a("[param] Set APP ID:%s", str);
            m9311a(buglyStrategy, m9531a);
            for (int i2 = 0; i2 < f9833b.size(); i2++) {
                try {
                    if (m9798a.m9809a(f9833b.get(i2).f9831id)) {
                        f9833b.get(i2).init(m9946a, z, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!C3151an.m9916a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            C3111b.m9493a(m9946a, buglyStrategy);
            m9636a.m9640a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
            C3151an.m9918b("[init] Bugly initialization finished.", new Object[0]);
        }
    }

    /* renamed from: a */
    private static void m9311a(BuglyStrategy buglyStrategy, C3113a c3113a) {
        byte[] bArr;
        if (buglyStrategy == null) {
            return;
        }
        String appVersion = buglyStrategy.getAppVersion();
        if (!TextUtils.isEmpty(appVersion)) {
            if (appVersion.length() > 100) {
                String substring = appVersion.substring(0, 100);
                C3151an.m9922d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                appVersion = substring;
            }
            c3113a.f10208p = appVersion;
            C3151an.m9915a("[param] Set App version: %s", buglyStrategy.getAppVersion());
        }
        try {
            if (buglyStrategy.isReplaceOldChannel()) {
                String appChannel = buglyStrategy.getAppChannel();
                if (!TextUtils.isEmpty(appChannel)) {
                    if (appChannel.length() > 100) {
                        String substring2 = appChannel.substring(0, 100);
                        C3151an.m9922d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                        appChannel = substring2;
                    }
                    f9835d.m9836a(556, "app_channel", appChannel.getBytes(), (InterfaceC3141ad) null, false);
                    c3113a.f10211s = appChannel;
                }
            } else {
                Map<String, byte[]> m9833a = f9835d.m9833a(556, (InterfaceC3141ad) null, true);
                if (m9833a != null && (bArr = m9833a.get("app_channel")) != null) {
                    c3113a.f10211s = new String(bArr);
                }
            }
            C3151an.m9915a("[param] Set App channel: %s", c3113a.f10211s);
        } catch (Exception e2) {
            if (f9834c) {
                e2.printStackTrace();
            }
        }
        String appPackageName = buglyStrategy.getAppPackageName();
        if (!TextUtils.isEmpty(appPackageName)) {
            if (appPackageName.length() > 100) {
                String substring3 = appPackageName.substring(0, 100);
                C3151an.m9922d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                appPackageName = substring3;
            }
            c3113a.f10196d = appPackageName;
            C3151an.m9915a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
        }
        String deviceID = buglyStrategy.getDeviceID();
        if (deviceID != null) {
            if (deviceID.length() > 100) {
                String substring4 = deviceID.substring(0, 100);
                C3151an.m9922d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                deviceID = substring4;
            }
            c3113a.m9565c(deviceID);
            C3151an.m9915a("[param] Set device ID: %s", deviceID);
        }
        c3113a.f10200h = buglyStrategy.isUploadProcess();
        C3153ap.f10574a = buglyStrategy.isBuglyLogUpload();
    }

    /* renamed from: a */
    public static synchronized void m9312a(AbstractC3071a abstractC3071a) {
        synchronized (C3072b.class) {
            if (!f9833b.contains(abstractC3071a)) {
                f9833b.add(abstractC3071a);
            }
        }
    }
}
