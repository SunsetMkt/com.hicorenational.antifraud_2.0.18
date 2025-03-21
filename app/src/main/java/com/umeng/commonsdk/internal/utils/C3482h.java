package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import com.umeng.commonsdk.internal.utils.C3479e;
import java.io.File;

/* compiled from: Root.java */
/* renamed from: com.umeng.commonsdk.internal.utils.h */
/* loaded from: classes2.dex */
public class C3482h {
    /* renamed from: a */
    public static boolean m11659a() {
        return m11660b() || m11661c() || m11662d() || m11663e();
    }

    /* renamed from: b */
    private static boolean m11660b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    /* renamed from: c */
    private static boolean m11661c() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            return new File("/system/app/Kinguser.apk").exists();
        } catch (Exception unused2) {
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m11662d() {
        return new C3479e().m11656a(C3479e.a.check_su_binary) != null;
    }

    /* renamed from: e */
    private static boolean m11663e() {
        for (String str : new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/", "/su/bin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}) {
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }
}
