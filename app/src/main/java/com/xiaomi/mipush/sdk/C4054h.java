package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4094aw;

/* renamed from: com.xiaomi.mipush.sdk.h */
/* loaded from: classes2.dex */
public class C4054h {

    /* renamed from: a */
    private static int f14413a = -1;

    /* renamed from: a */
    public static EnumC4063q m13558a(Context context) {
        return m13560a(context) ? EnumC4063q.HUAWEI : m13562c(context) ? EnumC4063q.OPPO : m13563d(context) ? EnumC4063q.VIVO : EnumC4063q.OTHER;
    }

    /* renamed from: b */
    public static boolean m13561b(Context context) {
        Object m13822a = C4094aw.m13822a(C4094aw.m13824a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object m13823a = C4094aw.m13823a("com.google.android.gms.common.ConnectionResult", HttpConstant.SUCCESS);
        if (m13823a == null || !(m13823a instanceof Integer)) {
            AbstractC4022b.m13359c("google service is not avaliable");
            f14413a = 0;
            return false;
        }
        int intValue = ((Integer) Integer.class.cast(m13823a)).intValue();
        if (m13822a != null) {
            if (m13822a instanceof Integer) {
                f14413a = ((Integer) Integer.class.cast(m13822a)).intValue() == intValue ? 1 : 0;
            } else {
                f14413a = 0;
                AbstractC4022b.m13359c("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("is google service can be used");
        sb.append(f14413a > 0);
        AbstractC4022b.m13359c(sb.toString());
        return f14413a > 0;
    }

    /* renamed from: c */
    public static boolean m13562c(Context context) {
        boolean z = false;
        Object m13824a = C4094aw.m13824a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (m13824a != null && (m13824a instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(m13824a)).booleanValue();
        }
        AbstractC4022b.m13359c("color os push  is avaliable ? :" + z);
        return z;
    }

    /* renamed from: d */
    public static boolean m13563d(Context context) {
        boolean z = false;
        Object m13824a = C4094aw.m13824a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (m13824a != null && (m13824a instanceof Boolean)) {
            z = ((Boolean) Boolean.class.cast(m13824a)).booleanValue();
        }
        AbstractC4022b.m13359c("fun touch os push  is avaliable ? :" + z);
        return z;
    }

    /* renamed from: a */
    public static boolean m13560a(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null) {
                if (m13559a()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m13559a() {
        try {
            String str = (String) C4094aw.m13824a("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            if (!TextUtils.isEmpty(str)) {
                if (Integer.parseInt(str) >= 9) {
                    return true;
                }
            }
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
        }
        return false;
    }
}
