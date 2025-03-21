package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.HMacUtil;
import com.taobao.accs.client.C2978a;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class UtilityImpl {
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";

    /* renamed from: a */
    private static final byte[] f9701a = new byte[0];

    /* renamed from: a */
    public static String m9196a(Context context) {
        String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getString(Constants.KEY_PROXY_HOST, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String m9220f = m9220f();
        if (TextUtils.isEmpty(m9220f)) {
            return null;
        }
        return m9220f;
    }

    /* renamed from: b */
    public static int m9207b() {
        return -1;
    }

    /* renamed from: b */
    public static int m9208b(Context context) {
        int i2 = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getInt(Constants.KEY_PROXY_PORT, -1);
        if (i2 > 0) {
            return i2;
        }
        if (m9196a(context) == null) {
            return -1;
        }
        try {
            return m9222g();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: c */
    public static boolean m9213c(Context context) {
        String str;
        int i2;
        synchronized (f9701a) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            PackageInfo packageInfo = GlobalClientInfo.getInstance(context).getPackageInfo();
            int i3 = sharedPreferences.getInt(Constants.KEY_APP_VERSION_CODE, -1);
            String string = sharedPreferences.getString(Constants.KEY_APP_VERSION_NAME, "");
            if (packageInfo != null) {
                i2 = packageInfo.versionCode;
                str = packageInfo.versionName;
            } else {
                str = null;
                i2 = 0;
            }
            if (i3 == i2 && string.equals(str)) {
                return false;
            }
            m9234p(context);
            ALog.m9183i("UtilityImpl", "appVersionChanged", "oldV", Integer.valueOf(i3), "nowV", Integer.valueOf(i2), "oldN", string, "nowN", str);
            return true;
        }
    }

    /* renamed from: c */
    public static byte[] m9214c() {
        return null;
    }

    /* renamed from: d */
    public static String m9215d() {
        return AbstractC1191a.f2571h;
    }

    /* renamed from: d */
    public static boolean m9217d(Context context) {
        boolean z;
        if (context == null) {
            return false;
        }
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            context = null;
        }
        synchronized (f9701a) {
            try {
                z = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(Constants.KEY_FOUCE_DISABLE, false);
                return z;
            } catch (Throwable th2) {
                th = th2;
                context = null;
                try {
                    throw th;
                } catch (Exception e3) {
                    e = e3;
                    ALog.m9181e("UtilityImpl", "getFocusDisableStatus", e, new Object[0]);
                    z = context;
                    return z;
                }
            }
        }
    }

    public static void disableService(Context context) {
        ComponentName componentName = new ComponentName(context, C3042j.channelService);
        PackageManager packageManager = context.getPackageManager();
        try {
            ALog.m9180d("UtilityImpl", "disableService, cn=" + componentName.toString(), new Object[0]);
            if (packageManager.getServiceInfo(componentName, 128).enabled) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                killService(context);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: e */
    public static boolean m9219e(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            ALog.m9182e("UtilityImpl", C3042j.m9244a(e2), new Object[0]);
        }
        return context.getPackageManager().getServiceInfo(new ComponentName(context, C3042j.channelService), 128).enabled;
    }

    public static void enableService(Context context) {
        ComponentName componentName = new ComponentName(context, C3042j.channelService);
        ALog.m9180d("UtilityImpl", "enableService", "comptName", componentName);
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } catch (Exception e2) {
            ALog.m9185w("UtilityImpl", "enableService", e2, new Object[0]);
        }
    }

    /* renamed from: f */
    public static boolean m9221f(Context context) {
        context.getPackageName();
        ComponentName componentName = new ComponentName(context, C2978a.m8977b());
        PackageManager packageManager = context.getPackageManager();
        if (!componentName.getPackageName().equals("!")) {
            return packageManager.getServiceInfo(componentName, 128).enabled;
        }
        ALog.m9182e("UtilityImpl", "getAgooServiceEnabled,exception,comptName.getPackageName()=" + componentName.getPackageName(), new Object[0]);
        return false;
    }

    public static void focusDisableService(Context context) {
        try {
            synchronized (f9701a) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putBoolean(Constants.KEY_FOUCE_DISABLE, true);
                edit.apply();
                disableService(context);
            }
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "focusDisableService", th, new Object[0]);
        }
    }

    public static void focusEnableService(Context context) {
        try {
            synchronized (f9701a) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putBoolean(Constants.KEY_FOUCE_DISABLE, false);
                edit.apply();
                enableService(context);
            }
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "focusEnableService", th, new Object[0]);
        }
    }

    /* renamed from: g */
    public static String m9223g(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return "unknown";
        }
        if (networkInfo.getType() == 1) {
            return NET_TYPE_WIFI;
        }
        String subtypeName = networkInfo.getSubtypeName();
        return !TextUtils.isEmpty(subtypeName) ? subtypeName.replaceAll(AbstractC1191a.f2568g, "") : "";
    }

    /* renamed from: h */
    public static String m9225h(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "getNetworkTypeExt", th, new Object[0]);
            return null;
        }
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        if (activeNetworkInfo.getType() == 1) {
            return NET_TYPE_WIFI;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NET_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NET_TYPE_3G;
            case 13:
                return NET_TYPE_4G;
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (TextUtils.isEmpty(subtypeName)) {
                    return "unknown";
                }
                if (!subtypeName.equalsIgnoreCase("td-scdma") && !subtypeName.equalsIgnoreCase("td_scdma")) {
                    if (!subtypeName.equalsIgnoreCase("tds_hsdpa")) {
                        return "unknown";
                    }
                }
                return NET_TYPE_3G;
        }
        ALog.m9181e("UtilityImpl", "getNetworkTypeExt", th, new Object[0]);
        return null;
    }

    /* renamed from: i */
    public static boolean m9227i(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = GlobalClientInfo.getInstance(context).getConnectivityManager().getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            } catch (Throwable th) {
                ALog.m9181e("UtilityImpl", "isNetworkConnected", th, new Object[0]);
            }
        }
        return false;
    }

    public static boolean isMainProcess(Context context) {
        return C3042j.m9245a(context);
    }

    /* renamed from: j */
    public static String m9228j(Context context) {
        return C3042j.m9247b(context);
    }

    /* renamed from: k */
    public static long m9229k(Context context) {
        long j2;
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0);
            long j3 = sharedPreferences.getLong(Constants.SP_KEY_SERVICE_START, 0L);
            j2 = j3 > 0 ? sharedPreferences.getLong(Constants.SP_KEY_SERVICE_END, 0L) - j3 : 0L;
        } catch (Throwable th) {
            th = th;
            j2 = 0;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(Constants.SP_KEY_SERVICE_START, 0L);
            edit.putLong(Constants.SP_KEY_SERVICE_END, 0L);
            edit.apply();
        } catch (Throwable th2) {
            th = th2;
            ALog.m9181e("UtilityImpl", "getServiceAliveTime:", th, new Object[0]);
            return j2;
        }
        return j2;
    }

    public static void killService(Context context) {
        try {
            int myUid = Process.myUid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.uid == myUid) {
                    if (!TextUtils.isEmpty(C2978a.f9403d) && C2978a.f9403d.equals(runningAppProcessInfo.processName)) {
                        ALog.m9182e("UtilityImpl", "killService", "processName", runningAppProcessInfo.processName);
                        Process.killProcess(runningAppProcessInfo.pid);
                        return;
                    } else if (runningAppProcessInfo.processName.endsWith(":channel")) {
                        ALog.m9182e("UtilityImpl", "killService", "processName", runningAppProcessInfo.processName);
                        Process.killProcess(runningAppProcessInfo.pid);
                        return;
                    }
                }
            }
            ALog.m9182e("UtilityImpl", "kill nothing", new Object[0]);
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "killService", th, new Object[0]);
        }
    }

    /* renamed from: l */
    public static String m9230l(Context context) {
        try {
            return GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: m */
    public static String m9231m(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 4).getString(Constants.SP_KEY_COOKIE_SEC, null);
        } catch (Exception e2) {
            ALog.m9181e("UtilityImpl", "reStoreCookie fail", e2, new Object[0]);
            return null;
        }
    }

    /* renamed from: n */
    public static void m9232n(Context context) {
        try {
            GlobalClientInfo.f9388c = null;
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 0).edit();
            edit.clear();
            edit.apply();
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "clearCookie fail", th, new Object[0]);
        }
    }

    /* renamed from: o */
    public static String m9233o(Context context) {
        return C3042j.m9248c(context);
    }

    /* renamed from: p */
    private static void m9234p(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(Constants.KEY_APP_VERSION_CODE, GlobalClientInfo.getInstance(context).getPackageInfo().versionCode);
            edit.putString(Constants.KEY_APP_VERSION_NAME, GlobalClientInfo.getInstance(context).getPackageInfo().versionName);
            edit.apply();
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "saveAppVersion", th, new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static boolean m9211b(String str, Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        try {
            synchronized (f9701a) {
                try {
                    z = !context.getSharedPreferences(str, 0).getString(Constants.SP_KEY_NOTIFICATION_STATE, "").equals(C3042j.m9248c(context));
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        ALog.m9181e("UtilityImpl", "notificationStateChanged", th, new Object[0]);
                        z = str;
                        return z;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: d */
    public static String m9216d(String str, Context context) {
        String string;
        try {
            synchronized (f9701a) {
                string = context.getSharedPreferences(str, 0).getString("utdid", C3042j.m9247b(context));
            }
            return string;
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "getUtdid", th, new Object[0]);
            return "";
        }
    }

    /* renamed from: i */
    public static String m9226i() {
        Class<?>[] clsArr = {String.class};
        Object[] objArr = {"ro.build.version.emui"};
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            ALog.m9180d("UtilityImpl", "getEmuiVersion", "result", str);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception e2) {
            ALog.m9181e("UtilityImpl", "getEmuiVersion", e2, new Object[0]);
            return "";
        }
    }

    /* renamed from: a */
    public static String m9195a(long j2) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(j2));
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "formatDay", th, new Object[0]);
            return "";
        }
    }

    /* renamed from: f */
    public static String m9220f() {
        if (Build.VERSION.SDK_INT < 11) {
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    /* renamed from: g */
    public static int m9222g() {
        if (Build.VERSION.SDK_INT < 11) {
            return Proxy.getDefaultPort();
        }
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* renamed from: e */
    public static long m9218e() {
        return C3042j.m9242a();
    }

    /* renamed from: a */
    public static boolean m9203a() {
        try {
            return !GlobalAppRuntimeInfo.isAppBackground();
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "isForeground error ", th, new Object[0]);
            return false;
        }
    }

    /* renamed from: a */
    public static String m9197a(String str, String str2, String str3) {
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            ALog.m9182e("UtilityImpl", "getAppsign appkey null", new Object[0]);
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                str4 = HMacUtil.hmacSha1Hex(str2.getBytes(), (str + str3).getBytes());
            } else {
                ALog.m9182e("UtilityImpl", "getAppsign secret null", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "getAppsign", th, new Object[0]);
        }
        return str4;
    }

    /* renamed from: h */
    public static String m9224h() {
        String str = m9220f() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + m9222g();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.m9180d("UtilityImpl", "getProxy:" + str, new Object[0]);
        }
        return str;
    }

    /* renamed from: b */
    public static void m9210b(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            GlobalClientInfo.f9388c = str;
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 0).edit();
            edit.putString(Constants.SP_KEY_COOKIE_SEC, str);
            edit.apply();
        } catch (Exception e2) {
            ALog.m9181e("UtilityImpl", "storeCookie fail", e2, new Object[0]);
        }
    }

    /* renamed from: c */
    public static void m9212c(String str, Context context) {
        try {
            synchronized (f9701a) {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putString("utdid", C3042j.m9247b(context));
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "saveUtdid", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public static boolean m9205a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            ALog.m9182e("UtilityImpl", "package not exist", "pkg", str);
            return false;
        }
    }

    /* renamed from: b */
    public static String m9209b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static boolean m9206a(String str, Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        try {
            synchronized (f9701a) {
                try {
                    z = !context.getSharedPreferences(str, 0).getString("utdid", "").equals(C3042j.m9247b(context));
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        ALog.m9181e("UtilityImpl", "utdidChanged", th, new Object[0]);
                        z = str;
                        return z;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* renamed from: a */
    public static void m9201a(Context context, String str, long j2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0).edit();
            edit.putLong(str, j2);
            edit.apply();
            ALog.m9180d("UtilityImpl", "setServiceTime:" + j2, new Object[0]);
        } catch (Throwable th) {
            ALog.m9181e("UtilityImpl", "setServiceTime:", th, new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m9202a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 4).edit();
            edit.putString(Constants.SP_KEY_NOTIFICATION_STATE, str2);
            edit.apply();
        } catch (Exception e2) {
            ALog.m9181e("UtilityImpl", "saveNotificationState fail", e2, new Object[0]);
        }
    }

    /* renamed from: a */
    public static int m9193a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public static String m9198a(Throwable th) {
        return C3042j.m9244a(th);
    }

    /* renamed from: a */
    public static String m9194a(int i2) {
        try {
            return String.valueOf(i2);
        } catch (Exception e2) {
            ALog.m9181e("UtilityImpl", "int2String", e2, new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public static final Map<String, String> m9200a(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String m9199a = m9199a(entry.getValue());
                    if (!TextUtils.isEmpty(m9199a)) {
                        if (!key.startsWith(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                            key = key.toLowerCase(Locale.US);
                        }
                        hashMap.put(key, m9199a);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    /* renamed from: a */
    public static final String m9199a(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            stringBuffer.append(list.get(i2));
            if (i2 < size - 1) {
                stringBuffer.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static boolean m9204a(long j2, long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j2));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j3));
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }
}
