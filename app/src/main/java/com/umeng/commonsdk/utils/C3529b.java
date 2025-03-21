package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* compiled from: PkgInfoUtil.java */
/* renamed from: com.umeng.commonsdk.utils.b */
/* loaded from: classes2.dex */
public class C3529b {

    /* renamed from: a */
    private static HashMap<String, PackageInfo> f12939a = new HashMap<>();

    /* renamed from: b */
    private static Object f12940b = new Object();

    /* compiled from: PkgInfoUtil.java */
    /* renamed from: com.umeng.commonsdk.utils.b$a */
    private static class a {

        /* renamed from: a */
        private static final C3529b f12941a = new C3529b();

        private a() {
        }
    }

    /* renamed from: a */
    public static C3529b m12093a() {
        return a.f12941a;
    }

    private C3529b() {
    }

    /* renamed from: a */
    public PackageInfo m12094a(Context context, String str, int i2) {
        PackageInfo packageInfo;
        synchronized (f12940b) {
            packageInfo = null;
            if (f12939a.containsKey(str)) {
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = f12939a.get(str);
            } else {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, i2);
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    f12939a.put(str, packageInfo2);
                    packageInfo = packageInfo2;
                } catch (PackageManager.NameNotFoundException unused) {
                    f12939a.put(str, null);
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                }
            }
        }
        return packageInfo;
    }
}
