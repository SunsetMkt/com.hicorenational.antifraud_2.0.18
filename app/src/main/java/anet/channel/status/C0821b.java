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
import anet.channel.util.C0857c;
import com.taobao.accs.utl.UtilityImpl;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import util.permissionutil.C7308a;

/* compiled from: Taobao */
/* renamed from: anet.channel.status.b */
/* loaded from: classes.dex */
class C0821b {

    /* renamed from: t */
    private static Method f1030t;

    /* renamed from: m */
    private static String[] f1023m = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};

    /* renamed from: a */
    static volatile Context f1011a = null;

    /* renamed from: b */
    static volatile boolean f1012b = false;

    /* renamed from: c */
    static volatile NetworkStatusHelper.NetworkStatus f1013c = NetworkStatusHelper.NetworkStatus.NONE;

    /* renamed from: d */
    static volatile String f1014d = "unknown";

    /* renamed from: e */
    static volatile String f1015e = "";

    /* renamed from: f */
    static volatile String f1016f = "";

    /* renamed from: g */
    static volatile String f1017g = "";

    /* renamed from: h */
    static volatile String f1018h = "unknown";

    /* renamed from: i */
    static volatile String f1019i = "";

    /* renamed from: j */
    static volatile Pair<String, Integer> f1020j = null;

    /* renamed from: k */
    static volatile boolean f1021k = false;

    /* renamed from: l */
    static volatile List<InetAddress> f1022l = Collections.EMPTY_LIST;

    /* renamed from: n */
    private static volatile boolean f1024n = false;

    /* renamed from: o */
    private static volatile boolean f1025o = false;

    /* renamed from: p */
    private static ConnectivityManager f1026p = null;

    /* renamed from: q */
    private static TelephonyManager f1027q = null;

    /* renamed from: r */
    private static WifiManager f1028r = null;

    /* renamed from: s */
    private static SubscriptionManager f1029s = null;

    /* renamed from: u */
    private static BroadcastReceiver f1031u = new BroadcastReceiver() { // from class: anet.channel.status.NetworkStatusMonitor$2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ALog.isPrintLog(1)) {
                ALog.m713d("awcn.NetworkStatusMonitor", "receiver:" + intent.getAction(), null, new Object[0]);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0823d(this));
        }
    };

    C0821b() {
    }

    /* renamed from: a */
    static void m614a() {
        if (f1024n || f1011a == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            f1011a.registerReceiver(f1031u, intentFilter);
        } catch (Exception unused) {
            ALog.m715e("awcn.NetworkStatusMonitor", "registerReceiver failed", null, new Object[0]);
        }
        m619d();
        f1024n = true;
    }

    /* renamed from: b */
    static void m616b() {
        if (f1011a != null) {
            f1011a.unregisterReceiver(f1031u);
        }
    }

    /* renamed from: c */
    static void m618c() {
        if (Build.VERSION.SDK_INT < 24 || f1025o) {
            return;
        }
        NetworkInfo m620e = m620e();
        f1012b = m620e != null && m620e.isConnected();
        f1026p.registerDefaultNetworkCallback(new C0822c());
        f1025o = true;
    }

    /* renamed from: d */
    static void m619d() {
        NetworkInfo networkInfo;
        boolean z;
        WifiInfo m624i;
        ALog.m713d("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", null, new Object[0]);
        NetworkStatusHelper.NetworkStatus networkStatus = f1013c;
        String str = f1015e;
        String str2 = f1016f;
        try {
            try {
                networkInfo = m620e();
                z = false;
            } catch (Exception e2) {
                ALog.m714e("awcn.NetworkStatusMonitor", "getNetworkInfo exception", null, e2, new Object[0]);
                m615a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                networkInfo = null;
                z = true;
            }
            if (!z) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    ALog.m716i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "info.isConnected", Boolean.valueOf(networkInfo.isConnected()), "info.isAvailable", Boolean.valueOf(networkInfo.isAvailable()), "info.getType", Integer.valueOf(networkInfo.getType()));
                    if (networkInfo.getType() == 0) {
                        String subtypeName = networkInfo.getSubtypeName();
                        String replace = TextUtils.isEmpty(subtypeName) ? "" : subtypeName.replace(AbstractC1191a.f2568g, "");
                        m615a(m612a(networkInfo.getSubtype(), replace), replace);
                        f1015e = m613a(networkInfo.getExtraInfo());
                        m623h();
                    } else if (networkInfo.getType() == 1) {
                        m615a(NetworkStatusHelper.NetworkStatus.WIFI, UtilityImpl.NET_TYPE_WIFI);
                        if (AwcnConfig.isWifiInfoEnable() && (m624i = m624i()) != null && m617b(C7308a.f25528g)) {
                            f1017g = m624i.getBSSID();
                            f1016f = m624i.getSSID();
                        }
                        f1018h = UtilityImpl.NET_TYPE_WIFI;
                        f1019i = UtilityImpl.NET_TYPE_WIFI;
                        f1020j = m625j();
                    } else {
                        m615a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                    }
                    f1021k = networkInfo.isRoaming();
                    C0857c.m729e();
                }
                m615a(NetworkStatusHelper.NetworkStatus.NO, "no network");
                ALog.m716i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "no network");
            }
            if (f1013c == networkStatus && f1015e.equalsIgnoreCase(str) && f1016f.equalsIgnoreCase(str2)) {
                return;
            }
            if (ALog.isPrintLog(2)) {
                NetworkStatusHelper.printNetworkDetail();
            }
            NetworkStatusHelper.notifyStatusChanged(f1013c);
        } catch (Exception e3) {
            ALog.m714e("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, e3, new Object[0]);
        }
    }

    /* renamed from: e */
    static NetworkInfo m620e() {
        if (f1026p == null) {
            f1026p = (ConnectivityManager) f1011a.getSystemService("connectivity");
        }
        return f1026p.getActiveNetworkInfo();
    }

    /* renamed from: f */
    static String m621f() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            for (String str : f1023m) {
                String str2 = (String) method.invoke(null, str);
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* renamed from: g */
    static int m622g() {
        if (f1026p == null || Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        return f1026p.getRestrictBackgroundStatus();
    }

    /* renamed from: h */
    private static void m623h() {
        try {
            if (AwcnConfig.isCarrierInfoEnable() && m617b(C7308a.f25531j)) {
                if (f1027q == null) {
                    f1027q = (TelephonyManager) f1011a.getSystemService("phone");
                }
                f1019i = f1027q.getSimOperator();
                if (Build.VERSION.SDK_INT >= 22) {
                    if (f1029s == null) {
                        f1029s = SubscriptionManager.from(f1011a);
                        f1030t = f1029s.getClass().getDeclaredMethod("getDefaultDataSubscriptionInfo", new Class[0]);
                    }
                    if (f1030t != null) {
                        f1018h = ((SubscriptionInfo) f1030t.invoke(f1029s, new Object[0])).getCarrierName().toString();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: i */
    private static WifiInfo m624i() {
        try {
            if (f1028r == null) {
                f1028r = (WifiManager) f1011a.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            }
            return f1028r.getConnectionInfo();
        } catch (Throwable th) {
            ALog.m714e("awcn.NetworkStatusMonitor", "getWifiInfo", null, th, new Object[0]);
            return null;
        }
    }

    /* renamed from: j */
    private static Pair<String, Integer> m625j() {
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

    /* renamed from: b */
    private static boolean m617b(String str) {
        return Build.VERSION.SDK_INT >= 23 && f1011a.checkSelfPermission(str) == 0;
    }

    /* renamed from: a */
    private static void m615a(NetworkStatusHelper.NetworkStatus networkStatus, String str) {
        f1013c = networkStatus;
        f1014d = str;
        f1015e = "";
        f1016f = "";
        f1017g = "";
        f1020j = null;
        f1018h = "";
        f1019i = "";
    }

    /* renamed from: a */
    private static NetworkStatusHelper.NetworkStatus m612a(int i2, String str) {
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

    /* renamed from: a */
    private static String m613a(String str) {
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
