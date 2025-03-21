package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static String f13228a = null;

    /* renamed from: a, reason: collision with other field name */
    private static boolean f902a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f13229b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f13230c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f13231d;

    /* renamed from: e, reason: collision with root package name */
    private static String f13232e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f13233f = String.valueOf((char) 2);

    /* renamed from: a, reason: collision with other field name */
    private static final String[] f903a = {d.d.D, "a-", "u-", "v-", "o-", "g-", "d-"};

    /* renamed from: a, reason: collision with other field name */
    private static final Set<String> f901a = new HashSet();

    static {
        f901a.add("com.xiaomi.xmsf");
        f901a.add("com.xiaomi.finddevice");
        f901a.add("com.miui.securitycenter");
        f902a = true;
    }

    private static double a(double d2) {
        int i2 = 1;
        while (true) {
            double d3 = i2;
            if (d3 >= d2) {
                return d3;
            }
            i2 <<= 1;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m615a(int i2) {
        if (i2 > 0) {
            String[] strArr = f903a;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return f903a[0];
    }

    @Deprecated
    public static String a(Context context) {
        return null;
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase(c.c.a.b.a.a.f3101h) || trim.equalsIgnoreCase("unknown");
    }

    public static String c() {
        return b() + "KB";
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    public static String d() {
        return (a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return null;
    }

    @Deprecated
    public static String f(Context context) {
        return "";
    }

    public static synchronized String g(Context context) {
        synchronized (i.class) {
            if (f13232e != null) {
                return f13232e;
            }
            f13232e = bb.b(b(context) + a(context));
            return f13232e;
        }
    }

    public static synchronized String h(Context context) {
        String b2;
        synchronized (i.class) {
            b2 = bb.b(b(context) + ((String) null));
        }
        return b2;
    }

    public static String i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    @Deprecated
    private static String j(Context context) {
        return "";
    }

    private static String k(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String l2 = l(context);
        a(context, l2);
        return l2;
    }

    private static String l(Context context) {
        return ay.a(Build.BRAND + c.c.a.b.a.a.s1 + k.a() + c.c.a.b.a.a.s1 + Build.VERSION.SDK_INT + c.c.a.b.a.a.s1 + Build.VERSION.RELEASE + c.c.a.b.a.a.s1 + Build.VERSION.INCREMENTAL + c.c.a.b.a.a.s1 + a() + c.c.a.b.a.a.s1 + context.getPackageName() + c.c.a.b.a.a.s1 + System.currentTimeMillis() + c.c.a.b.a.a.s1 + bb.a(16));
    }

    /* renamed from: c, reason: collision with other method in class */
    private static boolean m621c(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            if (packageInfo != null && packageInfo.applicationInfo != null && packageInfo.applicationInfo.metaData != null && packageInfo.applicationInfo.metaData.containsKey("supportGetAndroidID")) {
                boolean z = packageInfo.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);
                com.xiaomi.channel.commonutils.logger.b.m55b("DeviceInfo", "Get supportGetAndroidID from app metaData: " + z);
                return z;
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e2.getMessage());
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (serviceInfo != null && serviceInfo.metaData != null && serviceInfo.metaData.containsKey("supportGetAndroidID")) {
                com.xiaomi.channel.commonutils.logger.b.m55b("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");
                return false;
            }
        } catch (Exception e3) {
            com.xiaomi.channel.commonutils.logger.b.c("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e3.getMessage());
        }
        com.xiaomi.channel.commonutils.logger.b.m55b("DeviceInfo", "Not configure the metaData key of supportGetAndroidID，return true by default.");
        return true;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = f903a;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    public static String b(Context context) {
        if (f13229b == null && f902a) {
            f902a = m621c(context);
            if (!f902a) {
                return null;
            }
            try {
                f13229b = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m50a("failure to get androidId: " + th);
            }
            return f13229b;
        }
        return f13229b;
    }

    public static synchronized String a(Context context, boolean z) {
        String str;
        synchronized (i.class) {
            if (f13231d == null) {
                String b2 = b(context);
                int i2 = 1;
                switch (1) {
                    case 1:
                        String str2 = "";
                        if (!j.m632d()) {
                            str2 = z ? c(context) : j(context);
                        }
                        String a2 = a(context);
                        if (!(Build.VERSION.SDK_INT < 26)) {
                            if (b(str2)) {
                                if (!b(a2)) {
                                }
                            }
                        }
                        b2 = str2 + b2 + a2;
                        break;
                    case 2:
                        String b3 = an.a(context).b();
                        if (!TextUtils.isEmpty(b3)) {
                            b2 = b3 + b2;
                            i2 = 2;
                            break;
                        }
                    case 3:
                    case 4:
                        String mo136a = an.a(context).mo136a();
                        if (!TextUtils.isEmpty(mo136a) && !mo136a.startsWith("00000000-0000-0000-0000-000000000000")) {
                            i2 = 4;
                            b2 = mo136a;
                            break;
                        }
                        break;
                    case 5:
                        if (!TextUtils.isEmpty(b2)) {
                            i2 = 5;
                            break;
                        }
                    case 6:
                        b2 = k(context);
                        i2 = 6;
                        break;
                    default:
                        b2 = "";
                        break;
                }
                com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i2);
                if (i2 == 3) {
                    f13231d = b2;
                } else {
                    f13231d = m615a(i2) + bb.b(b2);
                }
            }
            str = f13231d;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        if (r1 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int b() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)
            boolean r0 = r0.exists()
            r2 = 0
            if (r0 == 0) goto L57
            r0 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L53
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L53
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L53
            r4 = 8192(0x2000, float:1.148E-41)
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L53
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r3 != 0) goto L41
            java.lang.String r3 = "\\s+"
            java.lang.String[] r0 = r0.split(r3)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r0 == 0) goto L41
            int r3 = r0.length     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r4 = 2
            if (r3 < r4) goto L41
            r3 = 1
            r4 = r0[r3]     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            boolean r4 = android.text.TextUtils.isDigitsOnly(r4)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            if (r4 == 0) goto L41
            r0 = r0[r3]     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L45 java.lang.Exception -> L47
            r2 = r0
        L41:
            r1.close()     // Catch: java.io.IOException -> L57
            goto L57
        L45:
            r0 = move-exception
            goto L4d
        L47:
            goto L54
        L49:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L4d:
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.io.IOException -> L52
        L52:
            throw r0
        L53:
            r1 = r0
        L54:
            if (r1 == 0) goto L57
            goto L41
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.i.b():int");
    }

    /* renamed from: b, reason: collision with other method in class */
    public static String m619b() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    @TargetApi(17)
    public static int a() {
        Object a2 = aw.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (a2 == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(a2)).intValue();
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m620b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m614a() {
        return a(b()) + "GB";
    }

    private static float a(int i2) {
        float f2 = ((((((i2 + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m617a(Context context) {
        Intent a2 = m.a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        if (a2 == null) {
            return false;
        }
        int intExtra = a2.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m616a() {
        return a() <= 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m618a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) aw.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        return packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) != 8388608;
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            com.xiaomi.channel.commonutils.logger.b.m50a("default_id exist,do not change it.");
        }
    }
}
