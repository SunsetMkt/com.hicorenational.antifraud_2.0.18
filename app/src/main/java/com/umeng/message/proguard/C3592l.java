package com.umeng.message.proguard;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* renamed from: com.umeng.message.proguard.l */
/* loaded from: classes2.dex */
final class C3592l {

    /* renamed from: a */
    final String f13300a;

    /* renamed from: b */
    final String f13301b;

    /* renamed from: c */
    final String f13302c;

    /* renamed from: d */
    final long f13303d;

    /* renamed from: e */
    final long f13304e;

    /* renamed from: f */
    final int f13305f;

    public C3592l(Object obj, Object obj2) {
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f13300a = packageInfo.packageName;
        this.f13302c = packageInfo.versionName;
        this.f13303d = packageInfo.firstInstallTime;
        this.f13304e = packageInfo.lastUpdateTime;
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
        this.f13305f = i2;
        try {
            str = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f13301b = str;
    }
}
