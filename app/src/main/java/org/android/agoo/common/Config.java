package org.android.agoo.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Config {
    public static final String AGOO_CLEAR_TIME = "agoo_clear_time";
    public static final String AGOO_UNREPORT_TIMES = "agoo_UnReport_times";
    public static final String KEY_DEVICE_TOKEN = "deviceId";
    public static final String PREFERENCES = "Agoo_AppStore";
    public static final String PROPERTY_APP_KEY = "agoo_app_key";
    public static final String PROPERTY_APP_VERSION = "app_version";
    public static final String PROPERTY_DEVICE_TOKEN = "app_device_token";
    public static final String PROPERTY_PUSH_USER_TOKEN = "app_push_user_token";
    public static final String PROPERTY_SECRET_KEY = "agoo_secret";
    public static final String PROPERTY_TT_ID = "app_tt_id";
    public static final String TAG = "Config";

    /* renamed from: a */
    public static String f21466a;

    /* renamed from: b */
    private static String f21467b;

    /* renamed from: c */
    private static String f21468c;

    /* renamed from: d */
    private static String f21469d;

    /* renamed from: a */
    public static String m24934a(Context context) {
        String str = f21467b;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            str = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_APP_KEY, f21467b);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "getAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.m9182e(TAG, "getAgooAppKey null!!", new Object[0]);
        }
        ALog.m9180d(TAG, "getAgooAppKey", "appkey", str);
        return str;
    }

    /* renamed from: b */
    public static String m24938b(Context context) {
        String str = f21468c;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            str = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_SECRET_KEY, f21468c);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "getAgooMessageSecret", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.m9182e(TAG, "getAgooMessageSecret null!!", new Object[0]);
        }
        ALog.m9180d(TAG, "getAgooMessageSecret", "secret", str);
        return str;
    }

    /* renamed from: c */
    public static String m24941c(Context context) {
        return TextUtils.isEmpty(f21466a) ? ACCSManager.getDefaultConfig(context) : f21466a;
    }

    /* renamed from: d */
    public static boolean m24943d(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: e */
    public static void m24944e(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putInt(AGOO_UNREPORT_TIMES, 0);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: f */
    public static int m24945f(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: g */
    public static String m24946g(Context context) {
        String str = f21469d;
        try {
            str = context.getSharedPreferences(PREFERENCES, 4).getString("deviceId", f21469d);
        } catch (Throwable th) {
            ALog.m9181e(TAG, "getDeviceToken", th, new Object[0]);
        }
        ALog.m9183i(TAG, "getDeviceToken", "token", str);
        return str;
    }

    /* renamed from: h */
    public static String m24947h(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_PUSH_USER_TOKEN, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void setAgooAppKey(Context context, String str) {
        try {
        } catch (Throwable th) {
            ALog.m9181e(TAG, "setAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.m9182e(TAG, "setAgooAppKey appkey null", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(f21467b)) {
            if (TextUtils.equals(str, f21467b)) {
                return;
            }
            ALog.m9182e(TAG, "setAgooAppKey error!", "new", str, "old", f21467b);
        } else {
            f21467b = str;
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putString(PROPERTY_APP_KEY, str);
            edit.apply();
            ALog.m9180d(TAG, "setAgooAppKey", "appkey", str);
        }
    }

    /* renamed from: c */
    public static void m24942c(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            if (!TextUtils.isEmpty(str)) {
                edit.putString(PROPERTY_PUSH_USER_TOKEN, str);
            }
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m24937a(Context context, String str) {
        try {
        } catch (Throwable th) {
            ALog.m9181e(TAG, "setAgooMessageSecret", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.m9182e(TAG, "setAgooMessageSecret secret null", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(f21468c)) {
            if (TextUtils.equals(str, f21468c)) {
                return;
            }
            ALog.m9182e(TAG, "setAgooMessageSecret error!", "new", str, "old", f21468c);
        } else {
            f21468c = str;
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putString(PROPERTY_SECRET_KEY, f21468c);
            edit.apply();
            ALog.m9180d(TAG, "setAgooMessageSecret", "secret", str);
        }
    }

    /* renamed from: b */
    public static void m24939b(Context context, String str) {
        ALog.m9183i(TAG, "setDeviceToken", "token", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f21469d = str;
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putString("deviceId", str);
            edit.apply();
        } catch (Throwable th) {
            ALog.m9181e(TAG, "setDeviceToken", th, new Object[0]);
        }
    }

    /* renamed from: b */
    public static boolean m24940b(Context context, long j2) {
        try {
            long j3 = context.getSharedPreferences(PREFERENCES, 4).getLong(AGOO_CLEAR_TIME, 0L);
            StringBuilder sb = new StringBuilder();
            sb.append("now=");
            sb.append(j2);
            sb.append(",now - lastTime=");
            long j4 = j2 - j3;
            sb.append(j4);
            sb.append(",istrue=");
            sb.append(j4 > 86400000);
            ALog.m9180d("isClearTime", sb.toString(), new Object[0]);
            return j2 != 0 && j4 > 86400000;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m24935a(Context context, int i2) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES, 4);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(AGOO_UNREPORT_TIMES, sharedPreferences.getInt(AGOO_UNREPORT_TIMES, 0) + i2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static void m24936a(Context context, long j2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(PREFERENCES, 4).edit();
            edit.putLong(AGOO_CLEAR_TIME, j2);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
