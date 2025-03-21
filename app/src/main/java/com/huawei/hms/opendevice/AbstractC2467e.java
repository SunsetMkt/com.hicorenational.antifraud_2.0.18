package com.huawei.hms.opendevice;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* compiled from: CommFun.java */
/* renamed from: com.huawei.hms.opendevice.e */
/* loaded from: classes.dex */
public abstract class AbstractC2467e {

    /* renamed from: a */
    private static String f7658a;

    /* renamed from: a */
    private static String m7453a() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            bufferedReader.close();
                            inputStreamReader.close();
                            fileInputStream.close();
                            return "";
                        }
                        String trim = readLine.trim();
                        bufferedReader.close();
                        inputStreamReader.close();
                        fileInputStream.close();
                        return trim;
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            HMSLog.m7715e("CommFun", "get current app processes IOException!");
            return "";
        } catch (Exception e2) {
            HMSLog.m7715e("CommFun", "get current app processes exception!" + e2.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    public static boolean m7456b() {
        int i2 = HwBuildEx.VERSION.EMUI_SDK_INT;
        HMSLog.m7712d("CommFun", "Emui Api Level:" + i2);
        return i2 > 0;
    }

    /* renamed from: c */
    public static String m7457c(Context context) {
        String parent;
        if (Build.VERSION.SDK_INT >= 24) {
            parent = context.createDeviceProtectedStorageContext().getDataDir() + "";
        } else {
            parent = context.getFilesDir().getParent();
        }
        if (TextUtils.isEmpty(parent)) {
            HMSLog.m7715e("CommFun", "get storage root path of the current user failed.");
        }
        return parent;
    }

    /* renamed from: d */
    public static long m7458d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.huawei.android.pushagent", 16384).versionCode;
        } catch (Exception unused) {
            HMSLog.m7715e("CommFun", "get nc versionCode error");
            return -1L;
        }
    }

    /* renamed from: e */
    public static boolean m7459e(Context context) {
        return m7456b() && HwBuildEx.VERSION.EMUI_SDK_INT < 21 && m7458d(context) < 110001400;
    }

    /* renamed from: b */
    private static String m7455b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName != null) {
                    HMSLog.m7717i("CommFun", "info.pid -> " + runningAppProcessInfo.pid + ", info.processName -> " + runningAppProcessInfo.processName);
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
        HMSLog.m7718w("CommFun", "get running app processes null!");
        return "";
    }

    /* renamed from: a */
    public static String m7454a(Context context) {
        if (!TextUtils.isEmpty(f7658a)) {
            return f7658a;
        }
        String m7455b = m7455b(context);
        f7658a = m7455b;
        if (!TextUtils.isEmpty(m7455b)) {
            return f7658a;
        }
        String m7453a = m7453a();
        f7658a = m7453a;
        return m7453a;
    }
}
