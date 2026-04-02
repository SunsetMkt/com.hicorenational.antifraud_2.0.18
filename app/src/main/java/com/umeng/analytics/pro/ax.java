package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import org.android.agoo.xiaomi.MiPushRegistar;

/* JADX INFO: compiled from: DeviceIdSupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public class ax {
    private static final String a = "ro.build.version.emui";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7037b = "hw_sc.build.platform.version";

    public static au a(Context context) {
        String str = Build.BRAND;
        bg.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("\u534e\u4e3a")) {
            return new ay();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("\u5c0f\u7c73") || str.equalsIgnoreCase(MiPushRegistar.BLACKSHARK)) {
            return new bf();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new be();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new bc();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new az();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new bb();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new bd();
        }
        if (a()) {
            return new ay();
        }
        if (str.equalsIgnoreCase("meizu") || str.equalsIgnoreCase("mblu") || c()) {
            return new ba();
        }
        if (b()) {
            return new aw();
        }
        return null;
    }

    private static boolean b() {
        return !TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean a() {
        return (TextUtils.isEmpty(a(a)) && TextUtils.isEmpty(a(f7037b))) ? false : true;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
