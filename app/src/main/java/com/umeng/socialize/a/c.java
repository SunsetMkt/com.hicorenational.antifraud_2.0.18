package com.umeng.socialize.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;

/* JADX INFO: compiled from: Misc.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f8170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f8171c;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = Build.BRAND;
            if (TextUtils.isEmpty(a)) {
                a = Build.MANUFACTURER;
            }
        }
        return a;
    }

    public static String b() {
        if (TextUtils.isEmpty(f8170b)) {
            f8170b = Build.MODEL;
        }
        return f8170b;
    }

    public static String c() {
        if (TextUtils.isEmpty(f8171c)) {
            f8171c = Build.BOARD;
        }
        return f8171c;
    }

    public static boolean b(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static Object a(Object obj, String str, int i2) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i2);
        } catch (Throwable th) {
            if (!a.f8165c) {
                return null;
            }
            UMRTLog.e("MISC", "pkg:" + str + " failed:" + th.getMessage());
            return null;
        }
    }

    public static boolean a(Context context) {
        return UMUtils.isMainProgress(context);
    }
}
