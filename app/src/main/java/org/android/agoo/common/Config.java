package org.android.agoo.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
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
    public static String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f12863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f12864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f12865d;

    public static String a(Context context) {
        String string = f12863b;
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            string = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_APP_KEY, f12863b);
        } catch (Throwable th) {
            ALog.e(TAG, "getAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(string)) {
            ALog.e(TAG, "getAgooAppKey null!!", new Object[0]);
        }
        ALog.d(TAG, "getAgooAppKey", "appkey", string);
        return string;
    }

    public static String b(Context context) {
        String string = f12864c;
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            string = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_SECRET_KEY, f12864c);
        } catch (Throwable th) {
            ALog.e(TAG, "getAgooMessageSecret", th, new Object[0]);
        }
        if (TextUtils.isEmpty(string)) {
            ALog.e(TAG, "getAgooMessageSecret null!!", new Object[0]);
        }
        ALog.d(TAG, "getAgooMessageSecret", "secret", string);
        return string;
    }

    public static String c(Context context) {
        return TextUtils.isEmpty(a) ? ACCSManager.getDefaultConfig(context) : a;
    }

    public static boolean d(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void e(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putInt(AGOO_UNREPORT_TIMES, 0);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static int f(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String g(Context context) {
        String string = f12865d;
        try {
            string = context.getSharedPreferences(PREFERENCES, 4).getString("deviceId", f12865d);
        } catch (Throwable th) {
            ALog.e(TAG, "getDeviceToken", th, new Object[0]);
        }
        ALog.i(TAG, "getDeviceToken", "token", string);
        return string;
    }

    public static String h(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_PUSH_USER_TOKEN, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void setAgooAppKey(Context context, String str) {
        try {
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "setAgooAppKey appkey null", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(f12863b)) {
            if (TextUtils.equals(str, f12863b)) {
                return;
            }
            ALog.e(TAG, "setAgooAppKey error!", "new", str, "old", f12863b);
        } else {
            f12863b = str;
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putString(PROPERTY_APP_KEY, str);
            editorEdit.apply();
            ALog.d(TAG, "setAgooAppKey", "appkey", str);
        }
    }

    public static void c(Context context, String str) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            if (!TextUtils.isEmpty(str)) {
                editorEdit.putString(PROPERTY_PUSH_USER_TOKEN, str);
            }
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str) {
        try {
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooMessageSecret", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "setAgooMessageSecret secret null", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(f12864c)) {
            if (TextUtils.equals(str, f12864c)) {
                return;
            }
            ALog.e(TAG, "setAgooMessageSecret error!", "new", str, "old", f12864c);
        } else {
            f12864c = str;
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putString(PROPERTY_SECRET_KEY, f12864c);
            editorEdit.apply();
            ALog.d(TAG, "setAgooMessageSecret", "secret", str);
        }
    }

    public static void b(Context context, String str) {
        ALog.i(TAG, "setDeviceToken", "token", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f12865d = str;
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putString("deviceId", str);
            editorEdit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "setDeviceToken", th, new Object[0]);
        }
    }

    public static boolean b(Context context, long j2) {
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
            ALog.d("isClearTime", sb.toString(), new Object[0]);
            return j2 != 0 && j4 > 86400000;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(Context context, int i2) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES, 4);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(AGOO_UNREPORT_TIMES, sharedPreferences.getInt(AGOO_UNREPORT_TIMES, 0) + i2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, long j2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putLong(AGOO_CLEAR_TIME, j2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }
}
