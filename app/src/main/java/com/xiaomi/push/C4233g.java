package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.vivo.push.PushClientConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.Map;

/* renamed from: com.xiaomi.push.g */
/* loaded from: classes2.dex */
public class C4233g {

    /* renamed from: a */
    private static a f15437a;

    /* renamed from: com.xiaomi.push.g$a */
    public interface a {
        /* renamed from: a */
        Map<String, String> m14941a(Context context, String str);

        /* renamed from: a */
        boolean m14942a(Context context, String str);

        /* renamed from: b */
        boolean m14943b(Context context, String str);
    }

    /* renamed from: com.xiaomi.push.g$b */
    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);


        /* renamed from: a */
        private final int f15442a;

        b(int i2) {
            this.f15442a = i2;
        }

        /* renamed from: a */
        public int m14944a() {
            return this.f15442a;
        }
    }

    /* renamed from: a */
    public static String m14931a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: b */
    public static boolean m14938b(Context context, String str) {
        a aVar = f15437a;
        return aVar != null && aVar.m14943b(context, str);
    }

    /* renamed from: c */
    public static boolean m14939c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: d */
    public static boolean m14940d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static String m14937b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static int m14925a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    /* renamed from: a */
    public static int m14924a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(PushClientConstants.COM_ANDROID_SYSTEMUI, 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return 0;
            }
            return applicationInfo.metaData.getInt("SupportForPushVersionCode");
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* renamed from: b */
    public static int m14936b(Context context, String str) {
        ApplicationInfo m14926a = m14926a(context, str);
        if (m14926a == null) {
            return 0;
        }
        int i2 = m14926a.icon;
        return i2 == 0 ? m14926a.logo : i2;
    }

    @TargetApi(19)
    /* renamed from: a */
    public static b m14929a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        b m14928a;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (str.equals(context.getPackageName())) {
                    applicationInfo = context.getApplicationInfo();
                } else {
                    applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
                }
                m14928a = m14928a(context, applicationInfo);
            } catch (Throwable th) {
                AbstractC4022b.m13347a("get app op error " + th);
            }
            if (m14928a != b.UNKNOWN) {
                return m14928a;
            }
            Integer num = (Integer) C4094aw.m13819a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return b.UNKNOWN;
            }
            Integer num2 = (Integer) C4094aw.m13822a(context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
            int i2 = (Integer) C4094aw.m13819a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i3 = (Integer) C4094aw.m13819a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            AbstractC4022b.m13356b(String.format("get app mode %s|%s|%s", num2, i2, i3));
            if (i2 == null) {
                i2 = 0;
            }
            if (i3 == null) {
                i3 = 1;
            }
            if (num2 != null) {
                return z ? !num2.equals(i3) ? b.ALLOWED : b.NOT_ALLOWED : num2.equals(i2) ? b.ALLOWED : b.NOT_ALLOWED;
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }

    /* renamed from: a */
    private static b m14928a(Context context, ApplicationInfo applicationInfo) {
        Object systemService;
        int i2 = Build.VERSION.SDK_INT;
        if (applicationInfo != null && i2 >= 24) {
            Boolean bool = null;
            try {
                if (applicationInfo.packageName.equals(context.getPackageName())) {
                    bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
                } else {
                    if (i2 >= 29) {
                        systemService = C4094aw.m13822a(context.getSystemService("notification"), "getService", new Object[0]);
                    } else {
                        systemService = context.getSystemService("security");
                    }
                    if (systemService != null) {
                        bool = (Boolean) C4094aw.m13831b(systemService, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                    }
                }
                if (bool != null) {
                    return bool.booleanValue() ? b.ALLOWED : b.NOT_ALLOWED;
                }
            } catch (Exception e2) {
                AbstractC4022b.m13347a("are notifications enabled error " + e2);
            }
            return b.UNKNOWN;
        }
        return b.UNKNOWN;
    }

    /* renamed from: a */
    public static void m14933a(Context context, ApplicationInfo applicationInfo, boolean z) {
        Object systemService;
        int i2 = Build.VERSION.SDK_INT;
        if (b.ALLOWED != m14928a(context, applicationInfo)) {
            try {
                if (i2 >= 29) {
                    systemService = C4094aw.m13822a(context.getSystemService("notification"), "getService", new Object[0]);
                } else {
                    systemService = context.getSystemService("security");
                }
                if (systemService != null) {
                    C4094aw.m13831b(systemService, "setNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid), Boolean.valueOf(z));
                }
            } catch (Exception e2) {
                AbstractC4022b.m13347a("set notifications enabled error " + e2);
            }
        }
    }

    /* renamed from: a */
    public static boolean m14935a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!C4300j.m15680a()) {
            return context.getPackageName().equals(str);
        }
        a aVar = f15437a;
        return aVar != null && aVar.m14942a(context, str);
    }

    /* renamed from: a */
    public static boolean m14934a(Context context) {
        String m14930a = m14930a();
        if (TextUtils.isEmpty(m14930a) || context == null) {
            return false;
        }
        return m14930a.equals(context.getPackageName());
    }

    /* renamed from: a */
    public static String m14930a() {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            str = (String) C4094aw.m13824a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        }
        return !TextUtils.isEmpty(str) ? str : "";
    }

    /* renamed from: a */
    private static ApplicationInfo m14926a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            AbstractC4022b.m13347a("not found app info " + str);
            return null;
        }
    }

    /* renamed from: a */
    public static Drawable m14927a(Context context, String str) {
        ApplicationInfo m14926a = m14926a(context, str);
        Drawable drawable = null;
        if (m14926a != null) {
            try {
                drawable = m14926a.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = m14926a.loadLogo(context.getPackageManager());
                }
            } catch (Exception e2) {
                AbstractC4022b.m13347a("get app icon drawable failed, " + e2);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    /* renamed from: a */
    public static Map<String, String> m14932a(Context context, String str) {
        a aVar = f15437a;
        if (aVar == null) {
            return null;
        }
        return aVar.m14941a(context, str);
    }
}
