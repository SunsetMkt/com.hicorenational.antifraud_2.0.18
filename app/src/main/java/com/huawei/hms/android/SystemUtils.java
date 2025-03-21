package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.taobao.accs.AccsClientConfig;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class SystemUtils {
    public static final String PRODUCT_BRAND = "ro.product.brand";
    public static final String PRODUCT_HONOR = "HONOR";
    public static final String PRODUCT_HUAWEI = "HUAWEI";
    public static final String UNKNOWN = "unknown";

    /* renamed from: a */
    private static String m6606a() {
        return getSystemProperties("ro.product.locale", "");
    }

    /* renamed from: b */
    private static String m6607b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getAndoridVersion() {
        return getSystemProperties("ro.build.version.release", "unknown");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static String getManufacturer() {
        return getSystemProperties("ro.product.manufacturer", "unknown");
    }

    public static long getMegabyte(double d2) {
        double d3 = Build.VERSION.SDK_INT > 25 ? 1000.0d : 1024.0d;
        return (long) (d2 * d3 * d3);
    }

    public static String getNetType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? "" : activeNetworkInfo.getTypeName();
    }

    public static String getPhoneModel() {
        return getSystemProperties("ro.product.model", "unknown");
    }

    public static String getSystemProperties(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.m7715e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    @Deprecated
    public static boolean isChinaROM() {
        String m6607b = m6607b();
        if (!TextUtils.isEmpty(m6607b)) {
            return AbstractC1191a.f2509J.equalsIgnoreCase(m6607b);
        }
        String m6606a = m6606a();
        if (!TextUtils.isEmpty(m6606a)) {
            return m6606a.toLowerCase(Locale.US).contains(AbstractC1191a.f2509J);
        }
        String localCountry = getLocalCountry();
        if (TextUtils.isEmpty(localCountry)) {
            return false;
        }
        return AbstractC1191a.f2509J.equalsIgnoreCase(localCountry);
    }

    public static boolean isEMUI() {
        StringBuilder sb = new StringBuilder();
        sb.append("is Emui :");
        int i2 = HwBuildEx.VERSION.EMUI_SDK_INT;
        sb.append(i2);
        HMSLog.m7717i("SystemUtils", sb.toString());
        return i2 > 0;
    }

    public static boolean isHuawei() {
        String systemProperties = getSystemProperties(PRODUCT_BRAND, "unknown");
        return PRODUCT_HUAWEI.equalsIgnoreCase(systemProperties) || PRODUCT_HONOR.equalsIgnoreCase(systemProperties);
    }

    public static boolean isSystemApp(Context context, String str) {
        if (context == null) {
            HMSLog.m7718w("SystemUtils", "isSystemApp context is null");
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (AndroidException e2) {
            HMSLog.m7715e("SystemUtils", "isSystemApp Exception: " + e2);
        } catch (RuntimeException e3) {
            HMSLog.m7715e("SystemUtils", "isSystemApp RuntimeException:" + e3);
        }
        return packageInfo != null && (packageInfo.applicationInfo.flags & 1) > 0;
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", AccsClientConfig.DEFAULT_CONFIGTAG).equalsIgnoreCase("tv");
    }
}
