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
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p245d.C4443d;

/* renamed from: com.xiaomi.push.i */
/* loaded from: classes2.dex */
public class C4287i {

    /* renamed from: a */
    private static String f16339a = null;

    /* renamed from: a */
    private static boolean f16341a = false;

    /* renamed from: b */
    private static String f16343b = null;

    /* renamed from: c */
    private static String f16344c = "";

    /* renamed from: d */
    private static String f16345d;

    /* renamed from: e */
    private static String f16346e;

    /* renamed from: f */
    private static final String f16347f = String.valueOf((char) 2);

    /* renamed from: a */
    private static final String[] f16342a = {C4443d.f16920D, "a-", "u-", "v-", "o-", "g-", "d-"};

    /* renamed from: a */
    private static final Set<String> f16340a = new HashSet();

    static {
        f16340a.add("com.xiaomi.xmsf");
        f16340a.add("com.xiaomi.finddevice");
        f16340a.add("com.miui.securitycenter");
        f16341a = true;
    }

    /* renamed from: a */
    private static double m15628a(double d2) {
        int i2 = 1;
        while (true) {
            double d3 = i2;
            if (d3 >= d2) {
                return d3;
            }
            i2 <<= 1;
        }
    }

    /* renamed from: a */
    private static String m15633a(int i2) {
        if (i2 > 0) {
            String[] strArr = f16342a;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return f16342a[0];
    }

    @Deprecated
    /* renamed from: a */
    public static String m15634a(Context context) {
        return null;
    }

    /* renamed from: b */
    private static boolean m15645b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase(AbstractC1191a.f2571h) || trim.equalsIgnoreCase("unknown");
    }

    /* renamed from: c */
    public static String m15646c() {
        return m15641b() + "KB";
    }

    @Deprecated
    /* renamed from: c */
    public static String m15647c(Context context) {
        return null;
    }

    /* renamed from: d */
    public static String m15649d() {
        return (m15631a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    @Deprecated
    /* renamed from: d */
    public static String m15650d(Context context) {
        return null;
    }

    @Deprecated
    /* renamed from: e */
    public static String m15651e(Context context) {
        return null;
    }

    @Deprecated
    /* renamed from: f */
    public static String m15652f(Context context) {
        return "";
    }

    /* renamed from: g */
    public static synchronized String m15653g(Context context) {
        synchronized (C4287i.class) {
            if (f16346e != null) {
                return f16346e;
            }
            f16346e = C4100bb.m13888b(m15643b(context) + m15634a(context));
            return f16346e;
        }
    }

    /* renamed from: h */
    public static synchronized String m15654h(Context context) {
        String m13888b;
        synchronized (C4287i.class) {
            m13888b = C4100bb.m13888b(m15643b(context) + ((String) null));
        }
        return m13888b;
    }

    /* renamed from: i */
    public static String m15655i(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    @Deprecated
    /* renamed from: j */
    private static String m15656j(Context context) {
        return "";
    }

    /* renamed from: k */
    private static String m15657k(Context context) {
        String string = context.getSharedPreferences("device_info", 0).getString("default_id", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String m15658l = m15658l(context);
        m15636a(context, m15658l);
        return m15658l;
    }

    /* renamed from: l */
    private static String m15658l(Context context) {
        return C4096ay.m13839a(Build.BRAND + AbstractC1191a.f2606s1 + C4301k.m15694a() + AbstractC1191a.f2606s1 + Build.VERSION.SDK_INT + AbstractC1191a.f2606s1 + Build.VERSION.RELEASE + AbstractC1191a.f2606s1 + Build.VERSION.INCREMENTAL + AbstractC1191a.f2606s1 + m15630a() + AbstractC1191a.f2606s1 + context.getPackageName() + AbstractC1191a.f2606s1 + System.currentTimeMillis() + AbstractC1191a.f2606s1 + C4100bb.m13878a(16));
    }

    /* renamed from: c */
    private static boolean m15648c(Context context) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
            if (packageInfo != null && packageInfo.applicationInfo != null && packageInfo.applicationInfo.metaData != null && packageInfo.applicationInfo.metaData.containsKey("supportGetAndroidID")) {
                boolean z = packageInfo.applicationInfo.metaData.getBoolean("supportGetAndroidID", true);
                AbstractC4022b.m13357b("DeviceInfo", "Get supportGetAndroidID from app metaData: " + z);
                return z;
            }
        } catch (Exception e2) {
            AbstractC4022b.m13360c("DeviceInfo", "Check supportGetAndroidID from app metaData error: " + e2.getMessage());
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName(context.getPackageName(), "com.xiaomi.push.service.XMPushService");
            intent.setComponent(componentName);
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(componentName, 128);
            if (serviceInfo != null && serviceInfo.metaData != null && serviceInfo.metaData.containsKey("supportGetAndroidID")) {
                AbstractC4022b.m13357b("DeviceInfo", "The metaData of XMPushService contains key supportGetAndroidID,so return false.");
                return false;
            }
        } catch (Exception e3) {
            AbstractC4022b.m13360c("DeviceInfo", "Check supportGetAndroidID from XMPushService metaData error: " + e3.getMessage());
        }
        AbstractC4022b.m13357b("DeviceInfo", "Not configure the metaData key of supportGetAndroidID，return true by default.");
        return true;
    }

    /* renamed from: a */
    public static boolean m15640a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            String[] strArr = f16342a;
            if (i2 >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    /* renamed from: b */
    public static String m15643b(Context context) {
        if (f16343b == null && f16341a) {
            f16341a = m15648c(context);
            if (!f16341a) {
                return null;
            }
            try {
                f16343b = Settings.Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            } catch (Throwable th) {
                AbstractC4022b.m13347a("failure to get androidId: " + th);
            }
            return f16343b;
        }
        return f16343b;
    }

    /* renamed from: a */
    public static synchronized String m15635a(Context context, boolean z) {
        String str;
        synchronized (C4287i.class) {
            if (f16345d == null) {
                String m15643b = m15643b(context);
                int i2 = 1;
                switch (1) {
                    case 1:
                        String str2 = "";
                        if (!C4300j.m15691d()) {
                            str2 = z ? m15647c(context) : m15656j(context);
                        }
                        String m15634a = m15634a(context);
                        if (!(Build.VERSION.SDK_INT < 26)) {
                            if (m15645b(str2)) {
                                if (!m15645b(m15634a)) {
                                }
                            }
                        }
                        m15643b = str2 + m15643b + m15634a;
                        break;
                    case 2:
                        String m13759b = C4085an.m13755a(context).m13759b();
                        if (!TextUtils.isEmpty(m13759b)) {
                            m15643b = m13759b + m15643b;
                            i2 = 2;
                            break;
                        }
                    case 3:
                    case 4:
                        String mo13736a = C4085an.m13755a(context).mo13736a();
                        if (!TextUtils.isEmpty(mo13736a) && !mo13736a.startsWith("00000000-0000-0000-0000-000000000000")) {
                            i2 = 4;
                            m15643b = mo13736a;
                            break;
                        }
                        break;
                    case 5:
                        if (!TextUtils.isEmpty(m15643b)) {
                            i2 = 5;
                            break;
                        }
                    case 6:
                        m15643b = m15657k(context);
                        i2 = 6;
                        break;
                    default:
                        m15643b = "";
                        break;
                }
                AbstractC4022b.m13356b("devid rule select:" + i2);
                if (i2 == 3) {
                    f16345d = m15643b;
                } else {
                    f16345d = m15633a(i2) + C4100bb.m13888b(m15643b);
                }
            }
            str = f16345d;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        if (r1 == null) goto L29;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m15641b() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C4287i.m15641b():int");
    }

    /* renamed from: b */
    public static String m15642b() {
        return m15628a(((m15631a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    @TargetApi(17)
    /* renamed from: a */
    public static int m15630a() {
        Object m13824a = C4094aw.m13824a("android.os.UserHandle", "myUserId", new Object[0]);
        if (m13824a == null) {
            return -1;
        }
        return ((Integer) Integer.class.cast(m13824a)).intValue();
    }

    /* renamed from: b */
    public static boolean m15644b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    /* renamed from: a */
    public static String m15632a() {
        return m15629a(m15641b()) + "GB";
    }

    /* renamed from: a */
    private static float m15629a(int i2) {
        float f2 = ((((((i2 + 102400) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    /* renamed from: a */
    private static long m15631a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: a */
    public static boolean m15638a(Context context) {
        Intent m15701a = C4303m.m15701a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        if (m15701a == null) {
            return false;
        }
        int intExtra = m15701a.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: a */
    public static boolean m15637a() {
        return m15630a() <= 0;
    }

    /* renamed from: a */
    public static boolean m15639a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) C4094aw.m13822a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        return packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) != 8388608;
    }

    /* renamed from: a */
    private static void m15636a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            AbstractC4022b.m13347a("default_id exist,do not change it.");
        }
    }
}
