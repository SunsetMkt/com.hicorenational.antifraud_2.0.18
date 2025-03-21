package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import org.android.agoo.xiaomi.MiPushRegistar;

/* compiled from: DeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.ax */
/* loaded from: classes2.dex */
public class C3340ax {

    /* renamed from: a */
    private static final String f11525a = "ro.build.version.emui";

    /* renamed from: b */
    private static final String f11526b = "hw_sc.build.platform.version";

    /* renamed from: a */
    public static InterfaceC3337au m10881a(Context context) {
        String str = Build.BRAND;
        C3350bg.m10898a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new C3341ay();
        }
        if (str.equalsIgnoreCase("xiaomi") || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase(MiPushRegistar.BLACKSHARK)) {
            return new C3349bf();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new C3348be();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new C3346bc();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new C3342az();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new C3345bb();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new C3347bd();
        }
        if (m10883a()) {
            return new C3341ay();
        }
        if (str.equalsIgnoreCase("meizu") || str.equalsIgnoreCase("mblu") || m10885c()) {
            return new C3344ba();
        }
        if (m10884b()) {
            return new C3339aw();
        }
        return null;
    }

    /* renamed from: b */
    private static boolean m10884b() {
        return !TextUtils.isEmpty(m10882a("ro.coolos.version"));
    }

    /* renamed from: c */
    private static boolean m10885c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m10883a() {
        return (TextUtils.isEmpty(m10882a(f11525a)) && TextUtils.isEmpty(m10882a(f11526b))) ? false : true;
    }

    /* renamed from: a */
    private static String m10882a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
