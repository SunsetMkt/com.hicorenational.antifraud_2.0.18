package com.umeng.socialize.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: UMAppInfo.java */
/* JADX INFO: loaded from: classes2.dex */
class f {
    final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f8176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f8177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f8178d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f8179e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f8180f;

    public f(Object obj, Object obj2) {
        String strValueOf;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.a = packageInfo.packageName;
        this.f8177c = packageInfo.versionName;
        this.f8178d = packageInfo.firstInstallTime;
        this.f8179e = packageInfo.lastUpdateTime;
        this.f8180f = a(packageInfo);
        try {
            strValueOf = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            strValueOf = "";
        }
        this.f8176b = strValueOf;
    }

    private int a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i2 = applicationInfo.flags;
        return ((i2 & 1) == 0 && (i2 & 128) == 0) ? 1 : 0;
    }
}
