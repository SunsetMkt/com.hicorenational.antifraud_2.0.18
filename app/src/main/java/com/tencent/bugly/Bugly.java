package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.aq;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class Bugly {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f8738a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
            if (b2 == null) {
                return null;
            }
            if (TextUtils.isEmpty(b2.s)) {
                ae a2 = ae.a();
                if (a2 == null) {
                    return b2.s;
                }
                Map<String, byte[]> a3 = a2.a(556, (ad) null, true);
                if (a3 != null && (bArr = a3.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return b2.s;
        }
    }

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static void putUserData(Context context, String str, String str2) {
        CrashReport.putUserData(context, str, str2);
    }

    public static void setAppChannel(Context context, String str) {
        CrashReport.setAppChannel(context, str);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        CrashReport.setIsDevelopmentDevice(context, z);
    }

    public static void setUserId(Context context, String str) {
        CrashReport.setUserId(context, str);
    }

    public static void setUserTag(Context context, int i2) {
        CrashReport.setUserSceneTag(context, i2);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (f8738a) {
                return;
            }
            f8738a = true;
            applicationContext = aq.a(context);
            if (applicationContext == null) {
                return;
            }
            b.a(CrashModule.getInstance());
            b.a(Beta.getInstance());
            b.f8757a = enable;
            b.a(applicationContext, str, z, buglyStrategy);
        }
    }
}
