package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import bean.SurveyH5Bean;
import com.taobao.accs.common.Constants;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.t */
/* loaded from: classes2.dex */
public class C3052t {

    /* renamed from: a */
    private static volatile Long f9763a;

    /* renamed from: b */
    private static volatile Integer f9764b;

    /* renamed from: a */
    static long m9273a(Context context) {
        if (f9763a == null) {
            try {
                f9763a = Long.valueOf(context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getLong(Constants.SP_KEY_LAST_LAUNCH_TIME, 0L));
            } catch (Throwable th) {
                ALog.m9181e("OrangeAdapter", "getLastActiveTime", th, new Object[0]);
            }
            ALog.m9180d("OrangeAdapter", "getLastActiveTime", "result", f9763a);
        }
        return f9763a.longValue();
    }

    /* renamed from: a */
    public static boolean m9276a() {
        return true;
    }

    /* renamed from: b */
    public static boolean m9277b() {
        return true;
    }

    /* renamed from: c */
    public static boolean m9278c() {
        return true;
    }

    /* renamed from: d */
    public static long m9279d() {
        if (f9764b == null) {
            f9764b = 10000;
            ALog.m9180d("OrangeAdapter", "getConnectTimeout", "result", f9764b);
        }
        return f9764b.intValue();
    }

    /* renamed from: e */
    public static boolean m9280e() {
        return true;
    }

    /* renamed from: a */
    static void m9274a(Context context, long j2) {
        try {
            f9763a = Long.valueOf(j2);
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putLong(Constants.SP_KEY_LAST_LAUNCH_TIME, j2);
            edit.apply();
        } catch (Throwable th) {
            ALog.m9181e("OrangeAdapter", "saveLastActiveTime fail:", th, "lastLaunchTime", Long.valueOf(j2));
        }
    }

    /* renamed from: a */
    public static void m9275a(Context context, String str, int i2) {
        try {
        } catch (Exception e2) {
            ALog.m9181e("OrangeAdapter", "saveConfigToSP fail:", e2, "key", str, SurveyH5Bean.VALUE, Integer.valueOf(i2));
        }
        if (context == null) {
            ALog.m9182e("OrangeAdapter", "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        edit.putInt(str, i2);
        edit.apply();
        ALog.m9183i("OrangeAdapter", "saveConfigToSP", "key", str, SurveyH5Bean.VALUE, Integer.valueOf(i2));
    }
}
