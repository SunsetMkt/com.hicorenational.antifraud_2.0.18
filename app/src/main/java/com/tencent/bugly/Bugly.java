package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.proguard.C3142ae;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.InterfaceC3141ad;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class Bugly {

    /* renamed from: a */
    private static boolean f9808a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            C3113a m9532b = C3113a.m9532b();
            if (m9532b == null) {
                return null;
            }
            if (TextUtils.isEmpty(m9532b.f10211s)) {
                C3142ae m9817a = C3142ae.m9817a();
                if (m9817a == null) {
                    return m9532b.f10211s;
                }
                Map<String, byte[]> m9833a = m9817a.m9833a(556, (InterfaceC3141ad) null, true);
                if (m9833a != null && (bArr = m9833a.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return m9532b.f10211s;
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
            if (f9808a) {
                return;
            }
            f9808a = true;
            applicationContext = C3154aq.m9946a(context);
            if (applicationContext == null) {
                return;
            }
            C3072b.m9312a(CrashModule.getInstance());
            C3072b.m9312a(Beta.getInstance());
            C3072b.f9832a = enable;
            C3072b.m9310a(applicationContext, str, z, buglyStrategy);
        }
    }
}
