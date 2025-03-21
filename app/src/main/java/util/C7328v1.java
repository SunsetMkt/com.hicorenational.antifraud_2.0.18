package util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.usage.StorageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hicorenational.antifraud.C2114a;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import p388ui.Hicore;
import util.permissionutil.C7308a;

/* compiled from: SystemUtils.java */
/* renamed from: util.v1 */
/* loaded from: classes2.dex */
public class C7328v1 {

    /* renamed from: a */
    private static long f25714a;

    /* compiled from: SystemUtils.java */
    /* renamed from: util.v1$a */
    public interface a {
        /* renamed from: a */
        void m26682a();
    }

    /* renamed from: a */
    public static final String m26643a() {
        return Build.VERSION.SDK_INT < 29 ? ContextCompat.checkSelfPermission(Hicore.getApp(), C7308a.f25531j) == 0 ? ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId() : "" : Settings.System.getString(Hicore.getApp().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }

    /* renamed from: b */
    public static String m26650b() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            str = Build.MANUFACTURER;
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.PRODUCT;
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.MODEL;
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.BOARD;
        }
        return TextUtils.isEmpty(str) ? Build.DEVICE : str;
    }

    /* renamed from: c */
    public static String m26655c() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: d */
    public static String m26658d() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: e */
    public static final String m26660e() {
        String deviceId = Build.VERSION.SDK_INT < 29 ? ContextCompat.checkSelfPermission(Hicore.getApp(), C7308a.f25531j) == 0 ? ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId() : "" : Settings.System.getString(Hicore.getApp().getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        return TextUtils.isEmpty(deviceId) ? m26676m() : deviceId;
    }

    /* renamed from: f */
    public static final String m26662f() {
        return (Build.VERSION.SDK_INT >= 29 || ContextCompat.checkSelfPermission(Hicore.getApp(), C7308a.f25531j) != 0) ? "" : ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getDeviceId();
    }

    /* renamed from: g */
    private static String m26664g() {
        try {
            return new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: h */
    private static String m26666h() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            String str = "all:" + list.size();
            for (NetworkInterface networkInterface : list) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    String str2 = "macBytes:" + hardwareAddress.length + Constants.ACCEPT_TIME_SEPARATOR_SP + networkInterface.getName();
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: i */
    public static String m26668i() {
        return "Android " + m26655c();
    }

    /* renamed from: j */
    public static String m26670j() {
        try {
            return ContextCompat.checkSelfPermission(Hicore.getApp(), C7308a.f25531j) == 0 ? ((TelephonyManager) Hicore.getApp().getSystemService("phone")).getLine1Number() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: k */
    public static String m26672k() {
        return Build.MODEL;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m26674l() {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: util.C7328v1.m26674l():java.lang.String");
    }

    /* renamed from: m */
    public static String m26676m() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        try {
            return new UUID(str.hashCode(), Build.class.getField("SERIAL").get(null).toString().hashCode()).toString();
        } catch (Exception unused) {
            return new UUID(str.hashCode(), "serial".hashCode()).toString();
        }
    }

    /* renamed from: n */
    public static int m26677n() {
        return C2114a.f6308e;
    }

    /* renamed from: o */
    public static String m26678o() {
        return C2114a.f6309f;
    }

    /* renamed from: p */
    public static boolean m26679p() {
        return Build.VERSION.SDK_INT >= 26;
    }

    /* renamed from: q */
    public static boolean m26680q() {
        return Build.VERSION.SDK_INT >= 29;
    }

    /* renamed from: r */
    public static boolean m26681r() {
        PowerManager powerManager = (PowerManager) Hicore.getApp().getSystemService("power");
        if (powerManager == null || Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return powerManager.isIgnoringBatteryOptimizations(Hicore.getApp().getPackageName());
    }

    /* renamed from: c */
    public static String m26656c(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    /* renamed from: i */
    public static void m26669i(Context context) {
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + Hicore.getApp().getPackageName()));
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: k */
    public static void m26673k(Context context) {
        Intent intent = new Intent();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            context.startActivity(intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName()));
            return;
        }
        if (i2 <= 22) {
            m26671j(context);
            return;
        }
        try {
            intent.addFlags(CommonNetImpl.FLAG_AUTH);
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            m26671j(context);
        }
    }

    /* renamed from: d */
    public static String m26659d(Context context) {
        long j2;
        long j3;
        Iterator it;
        long longValue;
        long j4;
        long j5;
        Context context2 = context;
        StorageManager storageManager = (StorageManager) context2.getSystemService("storage");
        int i2 = Build.VERSION.SDK_INT;
        float f2 = 1024.0f;
        if (i2 < 23) {
            try {
                StorageVolume[] storageVolumeArr = (StorageVolume[]) StorageManager.class.getDeclaredMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
                if (storageVolumeArr != null) {
                    Method method = null;
                    long j6 = 0;
                    j3 = 0;
                    for (StorageVolume storageVolume : storageVolumeArr) {
                        if (method == null) {
                            method = storageVolume.getClass().getDeclaredMethod("getPathFile", new Class[0]);
                        }
                        File file = (File) method.invoke(storageVolume, new Object[0]);
                        j6 += file.getTotalSpace();
                        j3 += file.getUsableSpace();
                    }
                    j2 = j6;
                } else {
                    j2 = 0;
                    j3 = 0;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("totalSize = ");
                float f3 = j2;
                sb.append(m26645a(f3, 1024.0f));
                sb.append(" ,availableSize = ");
                sb.append(m26645a(j3, 1024.0f));
                C7301n1.m26454a("hsc", sb.toString());
                return m26645a(f3, 1024.0f);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        try {
            long j7 = 0;
            long j8 = 0;
            for (Iterator it2 = ((List) StorageManager.class.getDeclaredMethod("getVolumes", new Class[0]).invoke(storageManager, new Object[0])).iterator(); it2.hasNext(); it2 = it) {
                Object next = it2.next();
                int i3 = next.getClass().getField("type").getInt(next);
                if (i3 == 1) {
                    if (i2 >= 26) {
                        it = it2;
                        longValue = m26642a(context2, (String) next.getClass().getDeclaredMethod("getFsUuid", new Class[0]).invoke(next, new Object[0]));
                        f2 = 1000.0f;
                    } else {
                        it = it2;
                        longValue = i2 >= 25 ? ((Long) StorageManager.class.getMethod("getPrimaryStorageSize", new Class[0]).invoke(storageManager, new Object[0])).longValue() : 0L;
                    }
                    if (((Boolean) next.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(next, new Object[0])).booleanValue()) {
                        File file2 = (File) next.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(next, new Object[0]);
                        if (longValue == 0) {
                            longValue = file2.getTotalSpace();
                        }
                        long totalSpace = longValue - file2.getTotalSpace();
                        j8 += longValue - file2.getFreeSpace();
                        j4 = j7 + longValue;
                        j5 = totalSpace;
                    } else {
                        j4 = j7;
                        j5 = 0;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("设备内存大小：");
                    float f4 = longValue;
                    sb2.append(m26645a(f4, f2));
                    sb2.append("系统大小：");
                    sb2.append(m26645a(j5, f2));
                    C7301n1.m26454a("hsc", sb2.toString());
                    C7301n1.m26454a("hsc", "totalSize = " + m26645a(f4, f2) + " ,used(with system) = " + m26645a(j8, f2) + " ,free = " + m26645a(r5 - j8, f2));
                    j7 = j4;
                } else {
                    it = it2;
                    if (i3 == 0 && ((Boolean) next.getClass().getDeclaredMethod("isMountedReadable", new Class[0]).invoke(next, new Object[0])).booleanValue()) {
                        File file3 = (File) next.getClass().getDeclaredMethod("getPath", new Class[0]).invoke(next, new Object[0]);
                        j8 += file3.getTotalSpace() - file3.getFreeSpace();
                        j7 += file3.getTotalSpace();
                        context2 = context;
                    }
                }
                context2 = context;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("总内存 total = ");
            float f5 = j7;
            sb3.append(m26645a(f5, f2));
            sb3.append("已用 used(with system) = ");
            sb3.append(m26645a(j8, 1000.0f));
            sb3.append("可用 available = ");
            sb3.append(m26645a(j7 - j8, f2));
            C7301n1.m26454a("hsc", sb3.toString());
            return m26645a(f5, f2);
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
    
        if (r2 == 1) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        if (r2 == 2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        r7.startActivity(new android.content.Intent("android.settings.SETTINGS"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
    
        if (util.C7292k1.m26399c(r7) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        util.C7292k1.m26401e(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        return;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m26665g(android.content.Context r7) {
        /*
            java.lang.String r0 = "android.settings.SETTINGS"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            java.lang.String r1 = r1.toLowerCase()     // Catch: java.lang.Exception -> L73
            r2 = -1
            int r3 = r1.hashCode()     // Catch: java.lang.Exception -> L73
            r4 = -1206476313(0xffffffffb816a1e7, float:-3.591357E-5)
            r5 = 2
            r6 = 1
            if (r3 == r4) goto L33
            r4 = -759499589(0xffffffffd2baf4bb, float:-4.014849E11)
            if (r3 == r4) goto L29
            r4 = 3620012(0x373cac, float:5.072717E-39)
            if (r3 == r4) goto L1f
            goto L3c
        L1f:
            java.lang.String r3 = "vivo"
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L73
            if (r1 == 0) goto L3c
            r2 = 2
            goto L3c
        L29:
            java.lang.String r3 = "xiaomi"
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L73
            if (r1 == 0) goto L3c
            r2 = 1
            goto L3c
        L33:
            java.lang.String r3 = "huawei"
            boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L73
            if (r1 == 0) goto L3c
            r2 = 0
        L3c:
            if (r2 == 0) goto L55
            if (r2 == r6) goto L55
            if (r2 == r5) goto L4b
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L73
            r1.<init>(r0)     // Catch: java.lang.Exception -> L73
            r7.startActivity(r1)     // Catch: java.lang.Exception -> L73
            goto L7b
        L4b:
            boolean r1 = util.C7292k1.m26399c(r7)     // Catch: java.lang.Exception -> L73
            if (r1 != 0) goto L7b
            util.C7292k1.m26401e(r7)     // Catch: java.lang.Exception -> L73
            goto L7b
        L55:
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L73
            java.lang.String r2 = "android.intent.action.MAIN"
            r1.<init>(r2)     // Catch: java.lang.Exception -> L73
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r1.addFlags(r2)     // Catch: java.lang.Exception -> L73
            java.lang.String r2 = "android.intent.category.LAUNCHER"
            r1.addCategory(r2)     // Catch: java.lang.Exception -> L73
            java.lang.String r2 = "com.android.settings/.Settings$HighPowerApplicationsActivity"
            android.content.ComponentName r2 = android.content.ComponentName.unflattenFromString(r2)     // Catch: java.lang.Exception -> L73
            r1.setComponent(r2)     // Catch: java.lang.Exception -> L73
            r7.startActivity(r1)     // Catch: java.lang.Exception -> L73
            goto L7b
        L73:
            android.content.Intent r1 = new android.content.Intent
            r1.<init>(r0)
            r7.startActivity(r1)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: util.C7328v1.m26665g(android.content.Context):void");
    }

    /* renamed from: j */
    public static void m26671j(Context context) {
        try {
            context.startActivity(new Intent("android.settings.SETTINGS"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: f */
    public static boolean m26663f(Context context) {
        context.getResources().getIdentifier("config_showNavigationBar", "bool", DispatchConstants.ANDROID);
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "沉浸式");
            if ("1".equals(str)) {
                return false;
            }
            return "0".equals(str);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static String m26646a(long j2) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j2));
    }

    /* renamed from: c */
    public static void m26657c(Context context, String str) {
        context.startActivity(Hicore.getApp().getPackageManager().getLaunchIntentForPackage(str));
    }

    /* renamed from: a */
    public static synchronized String m26647a(Context context) {
        String string;
        synchronized (C7328v1.class) {
            try {
                string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return string;
    }

    /* renamed from: e */
    public static boolean m26661e(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        return (runningTasks.isEmpty() || runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName())) ? false : true;
    }

    /* renamed from: b */
    public static String m26651b(Activity activity) {
        String m26666h;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            String m26652b = m26652b((Context) activity);
            if (m26652b != null) {
                String str = "android 5.0以前的方式获取mac" + m26652b;
                if (!m26652b.replaceAll(Constants.COLON_SEPARATOR, "").equalsIgnoreCase("020000000000")) {
                    return m26652b;
                }
            }
        } else if (i2 >= 23 && i2 < 24) {
            String m26664g = m26664g();
            if (m26664g != null) {
                String str2 = "android 6~7 的方式获取的mac" + m26664g;
                if (!m26664g.replaceAll(Constants.COLON_SEPARATOR, "").equalsIgnoreCase("020000000000")) {
                    return m26664g;
                }
            }
        } else if (Build.VERSION.SDK_INT >= 24 && (m26666h = m26666h()) != null) {
            String str3 = "android 7以后 的方式获取的mac" + m26666h;
            if (!m26666h.replaceAll(Constants.COLON_SEPARATOR, "").equalsIgnoreCase("020000000000")) {
                return m26666h;
            }
        }
        return "";
    }

    /* renamed from: h */
    public static void m26667h(Context context) {
        try {
            switch (Build.MANUFACTURER.toLowerCase()) {
                case "samsung":
                    try {
                        m26649a(context, "com.samsung.android.sm_cn", "com.samsung.android.sm.app.dashboard.SmartManagerDashBoardActivity");
                        return;
                    } catch (Exception unused) {
                        m26657c(context, "com.samsung.android.sm");
                        return;
                    }
                case "huawei":
                    try {
                        m26649a(context, "com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity");
                        return;
                    } catch (Exception unused2) {
                        m26649a(context, "com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity");
                        return;
                    }
                case "xiaomi":
                    m26649a(context, "com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity");
                    return;
                case "vivo":
                    try {
                        m26649a(context, "com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity");
                        return;
                    } catch (Exception unused3) {
                        m26657c(context, "com.iqoo.secure");
                        return;
                    }
                case "oppo":
                    try {
                        try {
                            try {
                                m26649a(context, "com.coloros.oppoguardelf", "com.coloros.powermanager.fuelgaue.PowerUsageModelActivity");
                                return;
                            } catch (Exception unused4) {
                                m26657c(context, "com.coloros.phonemanager");
                                return;
                            }
                        } catch (Exception unused5) {
                            m26657c(context, "com.coloros.safecenter");
                            return;
                        }
                    } catch (Exception unused6) {
                        m26657c(context, "com.oppo.safe");
                        return;
                    }
                case "yulong":
                case "360":
                    m26649a(context, "com.yulong.android.coolsafe", "com.yulong.android.coolsafe.ui.activity.autorun.AutoRunListActivity");
                    return;
                case "meizu":
                    try {
                        m26649a(context, "com.meizu.safe", "com.meizu.safe.permission.SmartBGActivity");
                        return;
                    } catch (Exception unused7) {
                        m26657c(context, "com.meizu.safe");
                        return;
                    }
                case "oneplus":
                    m26649a(context, "com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity");
                    return;
                case "smartisan":
                    m26657c(context, "com.smartisanos.security");
                    return;
                case "letv":
                    try {
                        m26649a(context, "com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity");
                        return;
                    } catch (Exception unused8) {
                        Intent intent = new Intent();
                        intent.addFlags(CommonNetImpl.FLAG_AUTH);
                        intent.setAction("com.letv.android.permissionautoboot");
                        context.startActivity(intent);
                        return;
                    }
                default:
                    Intent intent2 = new Intent();
                    if (Build.VERSION.SDK_INT >= 9) {
                        intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent2.setData(Uri.fromParts("package", context.getPackageName(), null));
                    } else if (Build.VERSION.SDK_INT <= 8) {
                        intent2.setAction("android.intent.action.VIEW");
                        intent2.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                        intent2.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
                    }
                    context.startActivity(intent2);
                    return;
            }
        } catch (Exception unused9) {
            context.startActivity(new Intent("android.settings.SETTINGS"));
        }
        context.startActivity(new Intent("android.settings.SETTINGS"));
    }

    @RequiresApi(api = 26)
    /* renamed from: a */
    public static long m26642a(Context context, String str) {
        UUID fromString;
        try {
            if (str == null) {
                fromString = StorageManager.UUID_DEFAULT;
            } else {
                fromString = UUID.fromString(str);
            }
            return ((StorageStatsManager) context.getSystemService(StorageStatsManager.class)).getTotalBytes(fromString);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    /* renamed from: a */
    public static String m26644a(float f2) {
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        int i2 = 0;
        while (f2 > 1024.0f && i2 < 4) {
            f2 /= 1024.0f;
            i2++;
        }
        return String.format(Locale.getDefault(), " %.2f %s", Float.valueOf(f2), strArr[i2]);
    }

    /* renamed from: a */
    public static String m26645a(float f2, float f3) {
        String[] strArr = {"B", "KB", "MB", "GB", "TB"};
        int i2 = 0;
        while (f2 > f3 && i2 < 4) {
            f2 /= f3;
            i2++;
        }
        return String.format(Locale.getDefault(), " %.2f %s", Float.valueOf(f2), strArr[i2]);
    }

    /* renamed from: b */
    private static String m26652b(Context context) {
        WifiManager wifiManager;
        WifiInfo wifiInfo;
        if (context == null || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)) == null) {
            return null;
        }
        try {
            wifiInfo = wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            return null;
        }
        String macAddress = wifiInfo.getMacAddress();
        return !TextUtils.isEmpty(macAddress) ? macAddress.toUpperCase(Locale.ENGLISH) : macAddress;
    }

    /* renamed from: a */
    public static void m26648a(Activity activity) {
        Configuration configuration = activity.getResources().getConfiguration();
        if (configuration.fontScale > 1.0f) {
            configuration.fontScale = 0.9f;
            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
            activity.getBaseContext().getResources().updateConfiguration(configuration, displayMetrics);
        }
    }

    /* renamed from: b */
    public static boolean m26653b(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - f25714a;
        if (0 < j3 && j3 < j2) {
            return true;
        }
        f25714a = currentTimeMillis;
        return false;
    }

    /* renamed from: a */
    public static void m26649a(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.addFlags(CommonNetImpl.FLAG_AUTH);
        context.startActivity(intent);
    }

    /* renamed from: b */
    public static boolean m26654b(Context context, String str) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            for (int i2 = 0; i2 < runningServices.size(); i2++) {
                if (str.equals(runningServices.get(i2).service.getClassName())) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: l */
    public static void m26675l(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String m26656c = m26656c(context);
                if (context.getPackageName().equals(m26656c)) {
                    return;
                }
                WebView.setDataDirectorySuffix(m26656c);
            }
        } catch (Exception unused) {
        }
    }
}
