package util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: AntiHijackingUtil.java */
/* renamed from: util.w0 */
/* loaded from: classes2.dex */
public class C7330w0 {

    /* renamed from: b */
    public static final String f25717b = "AntiHijackingUtil";

    /* renamed from: c */
    private static List<String> f25718c = new ArrayList();

    /* renamed from: d */
    static List<ApplicationInfo> f25719d;

    /* renamed from: e */
    private static PackageManager f25720e;

    /* renamed from: a */
    private List<ApplicationInfo> f25721a;

    /* renamed from: a */
    public static void m26683a(List<String> list) {
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static boolean m26684a(Context context) {
        int i2;
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            f25720e = context.getPackageManager();
            if (f25719d == null || f25719d.size() == 0) {
                List<ApplicationInfo> installedApplications = f25720e.getInstalledApplications(8192);
                Collections.sort(installedApplications, new ApplicationInfo.DisplayNameComparator(f25720e));
                f25719d = installedApplications;
            }
            for (ApplicationInfo applicationInfo : f25719d) {
                if ((1 & applicationInfo.flags) != 0) {
                    f25718c.add(applicationInfo.packageName);
                }
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            try {
                i2 = Integer.valueOf(Build.VERSION.SDK).intValue();
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            String m26685b = i2 >= 21 ? m26685b(context) : activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
            if (m26685b != null) {
                z = m26685b.equals(context.getPackageName());
                Iterator<String> it = f25718c.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(m26685b)) {
                        z = true;
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return z;
    }

    /* renamed from: b */
    public static String m26685b(Context context) {
        Field field;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        Integer num;
        try {
            field = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
        } catch (Exception e2) {
            e2.printStackTrace();
            field = null;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        int i2 = 0;
        while (true) {
            if (i2 >= runningAppProcesses.size()) {
                runningAppProcessInfo = null;
                break;
            }
            runningAppProcessInfo = runningAppProcesses.get(i2);
            if (runningAppProcessInfo.importance == 100) {
                try {
                    num = Integer.valueOf(field.getInt(runningAppProcessInfo));
                } catch (Exception e3) {
                    e3.printStackTrace();
                    num = null;
                }
                if (num != null && num.intValue() == 2) {
                    break;
                }
            }
            i2++;
        }
        if (runningAppProcessInfo != null) {
            return runningAppProcessInfo.processName;
        }
        return null;
    }
}
