package com.umeng.message.proguard;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes2.dex */
final class l {
    final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f8050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f8051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f8052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f8053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f8054f;

    public l(Object obj, Object obj2) {
        String strValueOf;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.a = packageInfo.packageName;
        this.f8051c = packageInfo.versionName;
        this.f8052d = packageInfo.firstInstallTime;
        this.f8053e = packageInfo.lastUpdateTime;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        int i2 = 0;
        if (applicationInfo == null) {
            i2 = -1;
        } else {
            int i3 = applicationInfo.flags;
            if ((i3 & 1) == 0 && (i3 & 128) == 0) {
                i2 = 1;
            }
        }
        this.f8054f = i2;
        try {
            strValueOf = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            strValueOf = "";
        }
        this.f8050b = strValueOf;
    }
}
