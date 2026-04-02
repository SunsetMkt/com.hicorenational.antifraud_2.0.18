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

/* JADX INFO: compiled from: AntiHijackingUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class z0 {

    /* JADX INFO: renamed from: b */
    public static final String f15114b = "AntiHijackingUtil";

    /* JADX INFO: renamed from: c */
    private static List<String> f15115c = new ArrayList();

    /* JADX INFO: renamed from: d */
    static List<ApplicationInfo> f15116d;

    /* JADX INFO: renamed from: e */
    private static PackageManager f15117e;
    private List<ApplicationInfo> a;

    public static void a(List<String> list) {
    }

    @SuppressLint({"NewApi"})
    public static boolean a(Context context) {
        int iIntValue;
        boolean zEquals = false;
        if (context == null) {
            return false;
        }
        try {
            f15117e = context.getPackageManager();
            if (f15116d == null || f15116d.size() == 0) {
                List<ApplicationInfo> installedApplications = f15117e.getInstalledApplications(8192);
                Collections.sort(installedApplications, new ApplicationInfo.DisplayNameComparator(f15117e));
                f15116d = installedApplications;
            }
            for (ApplicationInfo applicationInfo : f15116d) {
                if ((1 & applicationInfo.flags) != 0) {
                    f15115c.add(applicationInfo.packageName);
                }
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            try {
                iIntValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            } catch (NumberFormatException unused) {
                iIntValue = 0;
            }
            String strB = iIntValue >= 21 ? b(context) : activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
            if (strB != null) {
                zEquals = strB.equals(context.getPackageName());
                Iterator<String> it = f15115c.iterator();
                while (it.hasNext()) {
                    if (it.next().equals(strB)) {
                        zEquals = true;
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return zEquals;
    }

    public static String b(Context context) {
        Field declaredField;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        Integer numValueOf;
        try {
            declaredField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
        } catch (Exception e2) {
            e2.printStackTrace();
            declaredField = null;
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
                    numValueOf = Integer.valueOf(declaredField.getInt(runningAppProcessInfo));
                } catch (Exception e3) {
                    e3.printStackTrace();
                    numValueOf = null;
                }
                if (numValueOf != null && numValueOf.intValue() == 2) {
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
