package cn.cloudwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes.dex */
public class PreferencesUtils {
    public static boolean getBoolean(Context context, String str, boolean z) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    public static float getFloat(Context context, String str, float f2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getFloat(str, f2);
    }

    public static int getInt(Context context, String str, int i2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, i2);
    }

    public static long getLong(Context context, String str) {
        return getLong(context, str, -1L);
    }

    public static String getString(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, null);
    }

    public static boolean putBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str, z);
        return edit.commit();
    }

    public static boolean putFloat(Context context, String str, float f2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putFloat(str, f2);
        return edit.commit();
    }

    public static boolean putInt(Context context, String str, int i2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str, i2);
        return edit.commit();
    }

    public static boolean putLong(Context context, String str, long j2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(str, j2);
        return edit.commit();
    }

    public static boolean putString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    public static boolean removeSharedPreferenceByKey(Context context, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.remove(str);
        return edit.commit();
    }

    public static long getLong(Context context, String str, long j2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(str, j2);
    }

    public static String getString(Context context, String str, String str2) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }
}
