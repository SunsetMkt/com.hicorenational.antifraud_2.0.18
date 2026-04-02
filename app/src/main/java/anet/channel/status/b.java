package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.AwcnConfig;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class b {
    private static Method t;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String[] f1554m = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
    static volatile Context a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile boolean f1543b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile NetworkStatusHelper.NetworkStatus f1544c = NetworkStatusHelper.NetworkStatus.NONE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile String f1545d = "unknown";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile String f1546e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile String f1547f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile String f1548g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static volatile String f1549h = "unknown";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static volatile String f1550i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static volatile Pair<String, Integer> f1551j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static volatile boolean f1552k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static volatile List<InetAddress> f1553l = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile boolean f1555n = false;
    private static volatile boolean o = false;
    private static ConnectivityManager p = null;
    private static TelephonyManager q = null;
    private static WifiManager r = null;
    private static SubscriptionManager s = null;
    private static BroadcastReceiver u = new BroadcastReceiver() { // from class: anet.channel.status.NetworkStatusMonitor$2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.NetworkStatusMonitor", "receiver:" + intent.getAction(), null, new Object[0]);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this));
        }
    };

    b() {
    }

    static void a() {
        if (f1555n || a == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            a.registerReceiver(u, intentFilter);
        } catch (Exception unused) {
            ALog.e("awcn.NetworkStatusMonitor", "registerReceiver failed", null, new Object[0]);
        }
        d();
        f1555n = true;
    }

    static void b() {
        if (a != null) {
            a.unregisterReceiver(u);
        }
    }

    static void c() {
        if (Build.VERSION.SDK_INT < 24 || o) {
            return;
        }
        NetworkInfo networkInfoE = e();
        f1543b = networkInfoE != null && networkInfoE.isConnected();
        p.registerDefaultNetworkCallback(new c());
        o = true;
    }

    static void d() {
        NetworkInfo networkInfoE;
        boolean z;
        WifiInfo wifiInfoI;
        ALog.d("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", null, new Object[0]);
        NetworkStatusHelper.NetworkStatus networkStatus = f1544c;
        String str = f1546e;
        String str2 = f1547f;
        try {
            try {
                networkInfoE = e();
                z = false;
            } catch (Exception e2) {
                ALog.e("awcn.NetworkStatusMonitor", "getNetworkInfo exception", null, e2, new Object[0]);
                a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                networkInfoE = null;
                z = true;
            }
            if (!z) {
                if (networkInfoE == null || !networkInfoE.isConnected()) {
                    a(NetworkStatusHelper.NetworkStatus.NO, "no network");
                    ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "no network");
                } else {
                    ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "info.isConnected", Boolean.valueOf(networkInfoE.isConnected()), "info.isAvailable", Boolean.valueOf(networkInfoE.isAvailable()), "info.getType", Integer.valueOf(networkInfoE.getType()));
                    if (networkInfoE.getType() == 0) {
                        String subtypeName = networkInfoE.getSubtypeName();
                        String strReplace = TextUtils.isEmpty(subtypeName) ? "" : subtypeName.replace(d.c.a.b.a.a.f10074g, "");
                        a(a(networkInfoE.getSubtype(), strReplace), strReplace);
                        f1546e = a(networkInfoE.getExtraInfo());
                        h();
                    } else if (networkInfoE.getType() == 1) {
                        a(NetworkStatusHelper.NetworkStatus.WIFI, UtilityImpl.NET_TYPE_WIFI);
                        if (AwcnConfig.isWifiInfoEnable() && (wifiInfoI = i()) != null && b(util.permissionutil.a.f15030g)) {
                            f1548g = wifiInfoI.getBSSID();
                            f1547f = wifiInfoI.getSSID();
                        }
                        f1549h = UtilityImpl.NET_TYPE_WIFI;
                        f1550i = UtilityImpl.NET_TYPE_WIFI;
                        f1551j = j();
                    } else {
                        a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                    }
                    f1552k = networkInfoE.isRoaming();
                    anet.channel.util.c.e();
                }
            }
            if (f1544c == networkStatus && f1546e.equalsIgnoreCase(str) && f1547f.equalsIgnoreCase(str2)) {
                return;
            }
            if (ALog.isPrintLog(2)) {
                NetworkStatusHelper.printNetworkDetail();
            }
            NetworkStatusHelper.notifyStatusChanged(f1544c);
        } catch (Exception e3) {
            ALog.e("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, e3, new Object[0]);
        }
    }

    static NetworkInfo e() {
        if (p == null) {
            p = (ConnectivityManager) a.getSystemService("connectivity");
        }
        return p.getActiveNetworkInfo();
    }

    static String f() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            for (String str : f1554m) {
                String str2 = (String) method.invoke(null, str);
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    static int g() {
        if (p == null || Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        return p.getRestrictBackgroundStatus();
    }

    private static void h() {
        try {
            if (AwcnConfig.isCarrierInfoEnable() && b(util.permissionutil.a.f15033j)) {
                if (q == null) {
                    q = (TelephonyManager) a.getSystemService("phone");
                }
                f1550i = q.getSimOperator();
                if (Build.VERSION.SDK_INT >= 22) {
                    if (s == null) {
                        s = SubscriptionManager.from(a);
                        t = s.getClass().getDeclaredMethod("getDefaultDataSubscriptionInfo", new Class[0]);
                    }
                    if (t != null) {
                        f1549h = ((SubscriptionInfo) t.invoke(s, new Object[0])).getCarrierName().toString();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private static WifiInfo i() {
        try {
            if (r == null) {
                r = (WifiManager) a.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            }
            return r.getConnectionInfo();
        } catch (Throwable th) {
            ALog.e("awcn.NetworkStatusMonitor", "getWifiInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static Pair<String, Integer> j() {
        try {
            String property = System.getProperty("http.proxyHost");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return Pair.create(property, Integer.valueOf(Integer.parseInt(System.getProperty("http.proxyPort"))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static boolean b(String str) {
        return Build.VERSION.SDK_INT >= 23 && a.checkSelfPermission(str) == 0;
    }

    private static void a(NetworkStatusHelper.NetworkStatus networkStatus, String str) {
        f1544c = networkStatus;
        f1545d = str;
        f1546e = "";
        f1547f = "";
        f1548g = "";
        f1551j = null;
        f1549h = "";
        f1550i = "";
    }

    private static NetworkStatusHelper.NetworkStatus a(int i2, String str) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkStatusHelper.NetworkStatus.G2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkStatusHelper.NetworkStatus.G3;
            case 13:
            case 18:
            case 19:
                return NetworkStatusHelper.NetworkStatus.G4;
            case 20:
                return NetworkStatusHelper.NetworkStatus.G5;
            default:
                if (!str.equalsIgnoreCase("TD-SCDMA") && !str.equalsIgnoreCase("WCDMA") && !str.equalsIgnoreCase("CDMA2000")) {
                    return NetworkStatusHelper.NetworkStatus.NONE;
                }
                return NetworkStatusHelper.NetworkStatus.G3;
        }
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.contains("cmwap")) {
                return "cmwap";
            }
            if (lowerCase.contains("uniwap")) {
                return "uniwap";
            }
            if (lowerCase.contains("3gwap")) {
                return "3gwap";
            }
            if (lowerCase.contains("ctwap")) {
                return "ctwap";
            }
            if (lowerCase.contains("cmnet")) {
                return "cmnet";
            }
            if (lowerCase.contains("uninet")) {
                return "uninet";
            }
            if (lowerCase.contains("3gnet")) {
                return "3gnet";
            }
            if (lowerCase.contains("ctnet")) {
                return "ctnet";
            }
        }
        return "unknown";
    }
}
