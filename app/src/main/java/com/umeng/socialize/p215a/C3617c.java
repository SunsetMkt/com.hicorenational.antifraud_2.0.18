package com.umeng.socialize.p215a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.Closeable;

/* compiled from: Misc.java */
/* renamed from: com.umeng.socialize.a.c */
/* loaded from: classes2.dex */
public class C3617c {

    /* renamed from: a */
    public static String f13479a;

    /* renamed from: b */
    public static String f13480b;

    /* renamed from: c */
    public static String f13481c;

    /* renamed from: a */
    public static String m12502a() {
        if (TextUtils.isEmpty(f13479a)) {
            f13479a = Build.BRAND;
            if (TextUtils.isEmpty(f13479a)) {
                f13479a = Build.MANUFACTURER;
            }
        }
        return f13479a;
    }

    /* renamed from: b */
    public static String m12505b() {
        if (TextUtils.isEmpty(f13480b)) {
            f13480b = Build.MODEL;
        }
        return f13480b;
    }

    /* renamed from: c */
    public static String m12507c() {
        if (TextUtils.isEmpty(f13481c)) {
            f13481c = Build.BOARD;
        }
        return f13481c;
    }

    /* renamed from: b */
    public static boolean m12506b(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }

    /* renamed from: a */
    public static void m12503a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static Object m12501a(Object obj, String str, int i2) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i2);
        } catch (Throwable th) {
            if (!C3615a.f13470c) {
                return null;
            }
            UMRTLog.m11555e("MISC", "pkg:" + str + " failed:" + th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m12504a(Context context) {
        return UMUtils.isMainProgress(context);
    }
}
