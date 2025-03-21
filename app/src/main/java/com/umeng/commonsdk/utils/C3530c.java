package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3336at;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Calendar;
import java.util.Date;

/* compiled from: SLModeUtil.java */
/* renamed from: com.umeng.commonsdk.utils.c */
/* loaded from: classes2.dex */
public class C3530c {

    /* renamed from: b */
    private static final String f12943b = "lastReqTime";

    /* renamed from: c */
    private static final int f12944c = 48;

    /* renamed from: d */
    private static final int f12945d = 1;

    /* renamed from: e */
    private static final int f12946e = 720;

    /* renamed from: f */
    private static final String f12947f = "iss";

    /* renamed from: g */
    private static final String f12948g = "sinr";

    /* renamed from: h */
    private static final String f12949h = "clean";

    /* renamed from: i */
    private static boolean f12950i;

    /* renamed from: j */
    private static int f12951j;

    /* renamed from: a */
    private static final String f12942a = C3336at.m10865b().m10868b(C3336at.f11512z);

    /* renamed from: k */
    private static Object f12952k = new Object();

    static {
        f12950i = false;
        f12951j = 720;
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(appContext, f12947f, "");
            if (TextUtils.isEmpty(imprintProperty) || !"1".equals(imprintProperty)) {
                return;
            }
            synchronized (f12952k) {
                f12950i = true;
            }
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(appContext, f12948g, "");
            if (TextUtils.isEmpty(imprintProperty)) {
                f12951j = 48;
                return;
            }
            try {
                f12951j = m12096a(Integer.parseInt(imprintProperty2));
            } catch (Throwable unused) {
                f12951j = 48;
            }
        }
    }

    /* renamed from: a */
    private static int m12096a(int i2) {
        if (i2 > 720) {
            return 720;
        }
        if (i2 < 1) {
            return 1;
        }
        return i2;
    }

    /* renamed from: a */
    public static boolean m12099a() {
        boolean z;
        synchronized (f12952k) {
            z = f12950i;
        }
        return z;
    }

    /* renamed from: b */
    public static long m12101b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f12942a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getLong(f12943b, 0L);
        }
        return 0L;
    }

    /* renamed from: c */
    public static void m12102c(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f12942a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f12949h, true).commit();
        }
    }

    /* renamed from: d */
    public static void m12103d(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f12942a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(f12949h, false).commit();
        }
    }

    /* renamed from: e */
    public static boolean m12104e(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f12942a, 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(f12949h, false);
        }
        return false;
    }

    /* renamed from: a */
    public static int m12097a(Context context) {
        int i2;
        synchronized (f12952k) {
            i2 = f12951j;
        }
        return i2;
    }

    /* renamed from: a */
    public static boolean m12100a(long j2, long j3, int i2) {
        Date date = new Date(j3);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        calendar.add(10, i2);
        return date.after(calendar.getTime());
    }

    /* renamed from: a */
    public static void m12098a(Context context, long j2) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f12942a, 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(f12943b, j2).commit();
        }
    }
}
