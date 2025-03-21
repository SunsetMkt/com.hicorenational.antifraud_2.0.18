package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.huawei.hms.hatool.o */
/* loaded from: classes.dex */
public abstract class AbstractC2436o {

    /* renamed from: com.huawei.hms.hatool.o$a */
    private static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static Object m7256a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls == null) {
            throw new a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new a("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new a("paramsType or params should be same");
            }
            if (clsArr.length != objArr.length) {
                throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
        }
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused) {
                str2 = "invokeStaticFun(): method invoke Exception!";
                C2452v.m7390f("hmsSdk", str2);
                return null;
            } catch (IllegalArgumentException unused2) {
                str2 = "invokeStaticFun(): Illegal Argument!";
                C2452v.m7390f("hmsSdk", str2);
                return null;
            } catch (InvocationTargetException unused3) {
                str2 = "invokeStaticFun(): Invocation Target Exception!";
                C2452v.m7390f("hmsSdk", str2);
                return null;
            }
        } catch (NoSuchMethodException unused4) {
            C2452v.m7390f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        }
    }

    /* renamed from: a */
    private static Object m7257a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return m7256a(Class.forName(str), str2, clsArr, objArr);
        } catch (a unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            C2452v.m7390f("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            C2452v.m7390f("hmsSdk", str3);
            return null;
        }
    }

    /* renamed from: a */
    public static String m7258a() {
        return m7260a("ro.build.version.emui", "");
    }

    @SuppressLint({"HardwareIds"})
    /* renamed from: a */
    public static String m7259a(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }

    /* renamed from: a */
    public static String m7260a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String m7261a = m7261a("android.os.SystemProperties", str, str2);
        return TextUtils.isEmpty(m7261a) ? m7261a("com.huawei.android.os.SystemPropertiesEx", str, str2) : m7261a;
    }

    /* renamed from: a */
    private static String m7261a(String str, String str2, String str3) {
        Object m7257a = m7257a(str, "get", new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return m7257a != null ? (String) m7257a : str3;
    }

    /* renamed from: b */
    public static String m7262b() {
        String m7261a = m7261a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        C2452v.m7385c("hmsSdk", "SystemPropertiesEx: get rom_ver: " + m7261a);
        if (!TextUtils.isEmpty(m7261a)) {
            return m7261a;
        }
        String str = Build.DISPLAY;
        C2452v.m7385c("hmsSdk", "SystemProperties: get rom_ver: " + str);
        return str;
    }

    /* renamed from: b */
    public static String m7263b(Context context) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String obj2 = obj.toString();
            return obj2.length() > 256 ? "Unknown" : obj2;
        } catch (PackageManager.NameNotFoundException unused) {
            C2452v.m7390f("hmsSdk", "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }

    /* renamed from: c */
    public static String m7264c(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    /* renamed from: d */
    public static String m7265d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(m7264c(context), 16384).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            C2452v.m7390f("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }
}
