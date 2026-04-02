package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* JADX INFO: compiled from: PkgInfoUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static HashMap<String, PackageInfo> a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f7839b = new Object();

    /* JADX INFO: compiled from: PkgInfoUtil.java */
    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.a;
    }

    private b() {
    }

    public PackageInfo a(Context context, String str, int i2) {
        PackageInfo packageInfo;
        synchronized (f7839b) {
            packageInfo = null;
            if (a.containsKey(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg\uff1a " + str + ", pkgInfo\u7f13\u5b58\u547d\u4e2d\uff0c\u76f4\u63a5\u8fd4\u56de");
                packageInfo = a.get(str);
            } else {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, i2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg\uff1a " + str + ", \u83b7\u53d6pkgInfo\u5e76\u7f13\u5b58");
                    a.put(str, packageInfo2);
                    packageInfo = packageInfo2;
                } catch (PackageManager.NameNotFoundException unused) {
                    a.put(str, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "\uff0c\u76ee\u6807\u5305\u672a\u5b89\u88c5\u3002");
                }
            }
        }
        return packageInfo;
    }
}
