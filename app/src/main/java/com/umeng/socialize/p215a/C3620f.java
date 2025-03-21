package com.umeng.socialize.p215a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: UMAppInfo.java */
/* renamed from: com.umeng.socialize.a.f */
/* loaded from: classes2.dex */
class C3620f {

    /* renamed from: a */
    final String f13489a;

    /* renamed from: b */
    final String f13490b;

    /* renamed from: c */
    final String f13491c;

    /* renamed from: d */
    final long f13492d;

    /* renamed from: e */
    final long f13493e;

    /* renamed from: f */
    final int f13494f;

    public C3620f(Object obj, Object obj2) {
        String str;
        PackageManager packageManager = (PackageManager) obj;
        PackageInfo packageInfo = (PackageInfo) obj2;
        this.f13489a = packageInfo.packageName;
        this.f13491c = packageInfo.versionName;
        this.f13492d = packageInfo.firstInstallTime;
        this.f13493e = packageInfo.lastUpdateTime;
        this.f13494f = m12537a(packageInfo);
        try {
            str = String.valueOf(packageManager.getApplicationLabel(packageInfo.applicationInfo));
        } catch (Throwable unused) {
            str = "";
        }
        this.f13490b = str;
    }

    /* renamed from: a */
    private int m12537a(PackageInfo packageInfo) {
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return -1;
        }
        int i2 = applicationInfo.flags;
        return ((i2 & 1) == 0 && (i2 & 128) == 0) ? 1 : 0;
    }
}
