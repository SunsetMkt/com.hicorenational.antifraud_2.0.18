package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: SLModeUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7840b = "lastReqTime";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f7841c = 48;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f7842d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f7843e = 720;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7844f = "iss";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f7845g = "sinr";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f7846h = "clean";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f7847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f7848j;
    private static final String a = at.b().b(at.z);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Object f7849k = new Object();

    static {
        f7847i = false;
        f7848j = 720;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f7844f, "");
            if (TextUtils.isEmpty(strImprintProperty) || !"1".equals(strImprintProperty)) {
                return;
            }
            synchronized (f7849k) {
                f7847i = true;
            }
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f7845g, "");
            if (TextUtils.isEmpty(strImprintProperty)) {
                f7848j = 48;
                return;
            }
            try {
                f7848j = a(Integer.parseInt(strImprintProperty2));
            } catch (Throwable unused) {
                f7848j = 48;
            }
        }
    }

    private static int a(int i2) {
        if (i2 > 720) {
            return 720;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    public static boolean a() {
        boolean z;
        synchronized (f7849k) {
            z = f7847i;
        }
        return z;
    }

    public static long b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f7840b, 0L);
        }
        return 0L;
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f7846h, true).commit();
        }
    }

    public static void d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f7846h, false).commit();
        }
    }

    public static boolean e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f7846h, false);
        }
        return false;
    }

    public static int a(Context context) {
        int i2;
        synchronized (f7849k) {
            i2 = f7848j;
        }
        return i2;
    }

    public static boolean a(long j2, long j3, int i2) {
        Date date = new Date(j3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        calendar.add(10, i2);
        return date.after(calendar.getTime());
    }

    public static void a(Context context, long j2) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f7840b, j2).commit();
        }
    }
}
