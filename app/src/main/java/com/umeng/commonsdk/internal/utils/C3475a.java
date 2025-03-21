package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.C3529b;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: ApplicationLayerUtil.java */
/* renamed from: com.umeng.commonsdk.internal.utils.a */
/* loaded from: classes2.dex */
public class C3475a {

    /* compiled from: ApplicationLayerUtil.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.a$a */
    public static class a {

        /* renamed from: a */
        public String f12637a;

        /* renamed from: b */
        public String f12638b;
    }

    /* renamed from: a */
    public static long m11628a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo m12094a = C3529b.m12093a().m12094a(context, str, 64);
            if (m12094a != null) {
                return m12094a.firstInstallTime;
            }
            return 0L;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.m11774e("getAppFirstInstallTime" + th.getMessage());
            return 0L;
        }
    }

    /* renamed from: b */
    public static long m11630b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo m12094a = C3529b.m12093a().m12094a(context, str, 64);
            if (m12094a != null) {
                return m12094a.lastUpdateTime;
            }
            return 0L;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.m11774e("getAppLastUpdateTime:" + th.getMessage());
            return 0L;
        }
    }

    /* renamed from: b */
    public static void m11632b(Context context) {
    }

    /* renamed from: c */
    public static String m11635c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            ULog.m11774e("getAppInstaller:" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: d */
    public static int m11637d(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo m12094a = C3529b.m12093a().m12094a(context, str, 64);
            if (m12094a == null || (applicationInfo = m12094a.applicationInfo) == null) {
                return 0;
            }
            return applicationInfo.uid;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.m11774e("getAppUid:" + th.getMessage());
            return 0;
        }
    }

    /* renamed from: e */
    public static DisplayMetrics m11639e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    /* renamed from: f */
    public static List<InputMethodInfo> m11641f(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return null;
        }
        return inputMethodManager.getInputMethodList();
    }

    /* renamed from: g */
    public static List<a> m11642g(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(".")) {
                        a aVar = new a();
                        aVar.f12637a = str;
                        aVar.f12638b = m11640e(context, str);
                        arrayList.add(aVar);
                    }
                }
            }
        } catch (Exception e2) {
            ULog.m11774e("getAppList:" + e2.getMessage());
        }
        return arrayList;
    }

    /* renamed from: h */
    public static ActivityManager.MemoryInfo m11643h(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    /* renamed from: i */
    public static String m11644i(Context context) {
        if (context == null) {
        }
        return null;
    }

    /* renamed from: j */
    public static String m11645j(Context context) {
        return null;
    }

    /* renamed from: e */
    private static String m11640e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (String) applicationInfo.loadLabel(context.getPackageManager());
            }
            return null;
        } catch (Exception e2) {
            ULog.m11774e("getLabel:" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static int m11633c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    /* renamed from: a */
    public static boolean m11629a() {
        return C3482h.m11659a();
    }

    /* renamed from: b */
    public static String m11631b() {
        return new SimpleDateFormat().format(new Date());
    }

    /* renamed from: a */
    public static float m11627a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e2) {
            ULog.m11774e("getFontSize:" + e2.getMessage());
            return 0.0f;
        }
    }

    /* renamed from: d */
    public static int m11636d(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    /* renamed from: c */
    public static long m11634c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    /* renamed from: d */
    public static String m11638d() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : HelperUtils.getUmengMD5(obj);
        } catch (Exception e2) {
            ULog.m11774e("getHostName:" + e2.getMessage());
            return null;
        }
    }
}
