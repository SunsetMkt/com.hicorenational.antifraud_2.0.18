package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import bean.SurveyH5Bean;
import com.taobao.accs.common.Constants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class t {
    private static volatile Long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Integer f5945b;

    static long a(Context context) {
        if (a == null) {
            try {
                a = Long.valueOf(context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getLong(Constants.SP_KEY_LAST_LAUNCH_TIME, 0L));
            } catch (Throwable th) {
                ALog.e("OrangeAdapter", "getLastActiveTime", th, new Object[0]);
            }
            ALog.d("OrangeAdapter", "getLastActiveTime", "result", a);
        }
        return a.longValue();
    }

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return true;
    }

    public static boolean c() {
        return true;
    }

    public static long d() {
        if (f5945b == null) {
            f5945b = 10000;
            ALog.d("OrangeAdapter", "getConnectTimeout", "result", f5945b);
        }
        return f5945b.intValue();
    }

    public static boolean e() {
        return true;
    }

    static void a(Context context, long j2) {
        try {
            a = Long.valueOf(j2);
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            editorEdit.putLong(Constants.SP_KEY_LAST_LAUNCH_TIME, j2);
            editorEdit.apply();
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "saveLastActiveTime fail:", th, "lastLaunchTime", Long.valueOf(j2));
        }
    }

    public static void a(Context context, String str, int i2) {
        try {
        } catch (Exception e2) {
            ALog.e("OrangeAdapter", "saveConfigToSP fail:", e2, "key", str, SurveyH5Bean.VALUE, Integer.valueOf(i2));
        }
        if (context == null) {
            ALog.e("OrangeAdapter", "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        editorEdit.putInt(str, i2);
        editorEdit.apply();
        ALog.i("OrangeAdapter", "saveConfigToSP", "key", str, SurveyH5Bean.VALUE, Integer.valueOf(i2));
    }
}
