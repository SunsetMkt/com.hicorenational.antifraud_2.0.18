package com.umeng.message.proguard;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import com.umeng.p221ut.device.UTDevice;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.umeng.message.proguard.d */
/* loaded from: classes2.dex */
public final class C3584d {

    /* renamed from: a */
    public static String f13268a;

    /* renamed from: b */
    public static String f13269b;

    /* renamed from: c */
    public static String f13270c;

    /* renamed from: d */
    private static String f13271d;

    /* renamed from: e */
    private static Boolean f13272e;

    /* renamed from: f */
    private static Boolean f13273f;

    /* renamed from: g */
    private static String f13274g;

    /* renamed from: h */
    private static Boolean f13275h;

    /* renamed from: a */
    public static String m12345a(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    /* renamed from: b */
    public static String m12349b(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    /* renamed from: c */
    public static String m12350c() {
        return "02:00:00:00:00:00";
    }

    /* renamed from: c */
    public static String m12351c(Context context) {
        String str;
        try {
            str = DeviceConfig.getImeiNew(context);
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
                return (messageAppkey == null || messageAppkey.length() < 16) ? str : C3575ax.m12316a(str, messageAppkey.substring(0, 16), C3570as.m12294a("bm1ldWcuZjkvT20rTDgyMw=="));
            } catch (Exception e2) {
                e = e2;
                UPLog.m12143e("DeviceConfig", e);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
    }

    /* renamed from: d */
    public static String m12353d(Context context) {
        String str;
        try {
            str = m12375s(context);
            try {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
                return (messageAppkey == null || messageAppkey.length() < 16) ? str : C3575ax.m12316a(str, messageAppkey.substring(0, 16), C3570as.m12294a("bm1ldWcuZjkvT20rTDgyMw=="));
            } catch (Exception e2) {
                e = e2;
                UPLog.m12143e("DeviceConfig", e);
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
    }

    /* renamed from: e */
    public static String m12355e(Context context) {
        return DeviceConfig.getAndroidId(context);
    }

    /* renamed from: f */
    public static String m12357f(Context context) {
        return UMUtils.MD5(m12375s(context));
    }

    /* renamed from: g */
    public static String[] m12359g(Context context) {
        return UMUtils.getNetworkAccessMode(context);
    }

    /* renamed from: h */
    public static boolean m12361h(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return true;
        } catch (Throwable th) {
            UPLog.m12143e("DeviceConfig", th);
            return true;
        }
    }

    /* renamed from: i */
    public static int m12362i(Context context) {
        try {
            return Calendar.getInstance(m12376t(context)).getTimeZone().getRawOffset() / 3600000;
        } catch (Exception e2) {
            UPLog.m12143e("DeviceConfig", e2);
            return 8;
        }
    }

    /* renamed from: j */
    public static String[] m12365j(Context context) {
        String[] strArr = new String[2];
        try {
            Locale m12376t = m12376t(context);
            strArr[0] = m12376t.getCountry();
            strArr[1] = m12376t.getLanguage();
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Exception e2) {
            UPLog.m12143e("DeviceConfig", e2);
            return strArr;
        }
    }

    /* renamed from: k */
    public static String m12367k(Context context) {
        String uMId = UMUtils.getUMId(context);
        return uMId == null ? "" : uMId;
    }

    /* renamed from: l */
    public static String m12368l(Context context) {
        int i2;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i3 = 0;
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                i2 = m12343a(displayMetrics, "noncompatWidthPixels");
                i3 = m12343a(displayMetrics, "noncompatHeightPixels");
            } else {
                i2 = -1;
            }
            if (i2 == -1 || i3 == -1) {
                i2 = displayMetrics.widthPixels;
                i3 = displayMetrics.heightPixels;
            }
            return i2 + "*" + i3;
        } catch (Exception e2) {
            UPLog.m12143e("DeviceConfig", e2);
            return "Unknown";
        }
    }

    /* renamed from: m */
    public static String m12369m(Context context) {
        try {
            return UMUtils.getOperator(context);
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    /* renamed from: n */
    public static String m12370n(Context context) {
        String channelByXML = UMUtils.getChannelByXML(context);
        return !TextUtils.isEmpty(channelByXML) ? channelByXML : "Unknown";
    }

    /* renamed from: o */
    public static String m12371o(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Throwable th) {
            UPLog.m12144e("DeviceConfig", "utdid failed! " + th.getMessage());
            return "";
        }
    }

    /* renamed from: p */
    public static String m12372p(Context context) {
        int m12373q = m12373q(context);
        return m12373q == 0 ? Boolean.toString(false) : m12373q == 1 ? Boolean.toString(true) : "unknown";
    }

    /* renamed from: q */
    public static int m12373q(Context context) {
        if (C3586f.m12389b()) {
            UPLog.m12142d("DeviceConfig", "silent mode disabled");
            return -1;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            try {
                return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled() ? 1 : 0;
            } catch (Throwable th) {
                UPLog.m12143e("DeviceConfig", th);
                return -1;
            }
        }
        if (i2 < 19) {
            return 1;
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i3 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i3), packageName)).intValue() == 0 ? 1 : 0;
        } catch (Exception e2) {
            UPLog.m12143e("DeviceConfig", e2);
            return -1;
        }
    }

    /* renamed from: r */
    public static boolean m12374r(Context context) {
        if (C3586f.m12389b()) {
            UPLog.m12142d("DeviceConfig", "silent mode disabled");
            return false;
        }
        try {
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
            } else if (Build.VERSION.SDK_INT >= 21) {
                intent.putExtra("app_package", context.getPackageName());
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            }
            intent.setFlags(CommonNetImpl.FLAG_AUTH);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            UPLog.m12143e("DeviceConfig", th);
            try {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", context.getPackageName(), null));
                intent2.setFlags(CommonNetImpl.FLAG_AUTH);
                context.startActivity(intent2);
                return true;
            } catch (Throwable th2) {
                UPLog.m12143e("DeviceConfig", th2);
                return false;
            }
        }
    }

    /* renamed from: s */
    private static String m12375s(Context context) {
        if (!TextUtils.isEmpty(f13271d)) {
            return f13271d;
        }
        String imeiNew = DeviceConfig.getImeiNew(context);
        f13271d = imeiNew;
        if (!TextUtils.isEmpty(imeiNew)) {
            return f13271d;
        }
        String androidId = DeviceConfig.getAndroidId(context);
        f13271d = androidId;
        if (!TextUtils.isEmpty(androidId)) {
            return f13271d;
        }
        String serial = DeviceConfig.getSerial();
        f13271d = serial;
        if (TextUtils.isEmpty(serial)) {
            f13271d = "";
        }
        return f13271d;
    }

    /* renamed from: t */
    private static Locale m12376t(Context context) {
        Locale locale;
        try {
            Configuration configuration = new Configuration();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Exception e2) {
            UPLog.m12143e("DeviceConfig", e2);
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    /* renamed from: a */
    public static String m12344a() {
        return UMUtils.getCPU();
    }

    /* renamed from: b */
    public static String m12348b() {
        return DeviceConfig.getSerial();
    }

    /* renamed from: e */
    public static String m12354e() {
        if (TextUtils.isEmpty(f13270c)) {
            f13270c = Build.BOARD;
        }
        return f13270c;
    }

    /* renamed from: f */
    public static String m12356f() {
        if (TextUtils.isEmpty(f13269b)) {
            String str = Build.BRAND;
            f13269b = str;
            if (TextUtils.isEmpty(str)) {
                f13269b = Build.MANUFACTURER;
            }
        }
        return f13269b;
    }

    /* renamed from: g */
    public static boolean m12358g() {
        String m12356f;
        Boolean bool = f13272e;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            m12356f = m12356f();
        } catch (Throwable unused) {
        }
        if ("huawei".equalsIgnoreCase(m12356f)) {
            f13272e = Boolean.TRUE;
            return true;
        }
        if ("honor".equalsIgnoreCase(m12356f)) {
            f13272e = Boolean.TRUE;
            return true;
        }
        f13272e = Boolean.FALSE;
        return false;
    }

    /* renamed from: k */
    private static String m12366k() {
        String str = f13274g;
        if (str != null) {
            return str;
        }
        if (!"vivo".equalsIgnoreCase(m12356f())) {
            f13274g = "";
            return "";
        }
        String m12347a = m12347a("ro.vivo.os.build.display.id");
        f13274g = m12347a;
        if (!TextUtils.isEmpty(m12347a)) {
            return f13274g;
        }
        String m12347a2 = m12347a("ro.iqoo.os.build.display.id");
        f13274g = m12347a2;
        if (!TextUtils.isEmpty(m12347a2)) {
            return f13274g;
        }
        f13274g = "";
        return "";
    }

    /* renamed from: a */
    public static String m12346a(Context context, String str) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
            if (string != null) {
                return string.trim();
            }
        } catch (Exception e2) {
            UPLog.m12143e("DeviceConfig", e2);
        }
        UPLog.m12147w("DeviceConfig", String.format("Could not read meta-data %s from AndroidManifest.xml.", str));
        return null;
    }

    /* renamed from: h */
    public static boolean m12360h() {
        Boolean bool = f13273f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if ("vivo".equalsIgnoreCase(m12356f())) {
            f13273f = Boolean.TRUE;
            return true;
        }
        String m12366k = m12366k();
        if (TextUtils.isEmpty(m12366k)) {
            f13273f = Boolean.FALSE;
            return false;
        }
        if (m12366k.startsWith("OriginOS") || m12366k.startsWith("Funtouch")) {
            f13273f = Boolean.TRUE;
            return true;
        }
        f13273f = Boolean.FALSE;
        return false;
    }

    /* renamed from: i */
    public static boolean m12363i() {
        Boolean bool = f13275h;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Boolean valueOf = Boolean.valueOf("harmony".equalsIgnoreCase((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            f13275h = valueOf;
            return valueOf.booleanValue();
        } catch (Throwable unused) {
            f13275h = Boolean.FALSE;
            return false;
        }
    }

    /* renamed from: j */
    public static String m12364j() {
        return m12347a("hw_sc.build.platform.version");
    }

    /* renamed from: d */
    public static String m12352d() {
        if (TextUtils.isEmpty(f13268a)) {
            f13268a = Build.MODEL;
        }
        return f13268a;
    }

    /* renamed from: a */
    private static int m12343a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e2) {
            UPLog.m12143e("DeviceConfig", e2);
            return -1;
        }
    }

    /* renamed from: a */
    private static String m12347a(String str) {
        try {
            return (String) C3579ba.m12330a("android.os.SystemProperties", "get", new Class[]{String.class}, null, new Object[]{str});
        } catch (Throwable unused) {
            return "";
        }
    }
}
