package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.adapter.p171ui.UpdateAdapter;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AgHmsUpdateState;

/* loaded from: classes.dex */
public class AvailableUtil {

    /* renamed from: a */
    private static final Object f7044a = new Object();

    /* renamed from: b */
    private static boolean f7045b = false;

    /* renamed from: c */
    private static boolean f7046c = false;

    /* renamed from: com.huawei.hms.adapter.AvailableUtil$a */
    class RunnableC2287a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f7047a;

        RunnableC2287a(Context context) {
            this.f7047a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.m7717i("AvailableUtil", "enter asyncCheckHmsV3UpdateInfo");
            if (AvailableUtil.isInstallerLibExist(this.f7047a)) {
                UpdateAdapter.invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "checkHmsUpdateInfo", new Object[]{this.f7047a});
                HMSLog.m7717i("AvailableUtil", "quit asyncCheckHmsV3UpdateInfo");
            } else {
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                HMSLog.m7715e("AvailableUtil", "asyncCheckHmsV3UpdateInfo installer is not exist");
            }
        }
    }

    public static void asyncCheckHmsUpdateInfo(Context context) {
        if (HmsCheckedState.UNCHECKED != AgHmsUpdateState.getInstance().getCheckedState()) {
            HMSLog.m7717i("AvailableUtil", "asyncCheckHmsUpdateInfo, not need to check");
        } else {
            new Thread(new RunnableC2287a(context), "Thread-asyncCheckHmsV3UpdateInfo").start();
        }
    }

    public static boolean isInstallerLibExist(Context context) {
        Bundle bundle;
        Object obj;
        if (f7045b) {
            HMSLog.m7717i("AvailableUtil", "installerInit exist: " + f7046c);
            return f7046c;
        }
        synchronized (f7044a) {
            if (!f7045b) {
                boolean z = false;
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.m7715e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.update.manager.UpdateManager");
                        z = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.m7715e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");
                    }
                    f7046c = z;
                    f7045b = true;
                } else {
                    try {
                        try {
                            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("availableHMSCoreInstaller")) != null && String.valueOf(obj).equalsIgnoreCase("yes")) {
                                HMSLog.m7717i("AvailableUtil", "available exist: true");
                                z = true;
                            }
                        } catch (AndroidException unused2) {
                            HMSLog.m7715e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");
                        }
                    } catch (RuntimeException e2) {
                        HMSLog.m7716e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", e2);
                    }
                    f7046c = z;
                    f7045b = true;
                }
            }
        }
        HMSLog.m7717i("AvailableUtil", "available exist: " + f7046c);
        return f7046c;
    }
}
