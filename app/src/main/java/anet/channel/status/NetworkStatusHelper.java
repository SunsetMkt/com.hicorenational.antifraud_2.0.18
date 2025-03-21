package anet.channel.status;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.C0861g;
import anet.channel.util.StringUtils;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NetworkStatusHelper {
    private static final String TAG = "awcn.NetworkStatusHelper";
    static CopyOnWriteArraySet<INetworkStatusChangeListener> listeners = new CopyOnWriteArraySet<>();

    /* compiled from: Taobao */
    public interface INetworkStatusChangeListener {
        void onNetworkStatusChanged(NetworkStatus networkStatus);
    }

    /* compiled from: Taobao */
    public enum NetworkStatus {
        NONE,
        NO,
        G2,
        G3,
        G4,
        WIFI,
        G5;

        public String getType() {
            return this == G2 ? "2G" : this == G3 ? "3G" : this == G4 ? "4G" : this == G5 ? "5G" : toString();
        }

        public boolean isMobile() {
            return this == G2 || this == G3 || this == G4 || this == G5;
        }

        public boolean isWifi() {
            return this == WIFI;
        }
    }

    public static void addStatusChangeListener(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        listeners.add(iNetworkStatusChangeListener);
    }

    public static String getApn() {
        return C0821b.f1015e;
    }

    public static String getCarrier() {
        return C0821b.f1018h;
    }

    public static String getDnsServerAddress() {
        return !C0821b.f1022l.isEmpty() ? C0821b.f1022l.get(0).getHostAddress() : C0821b.m621f();
    }

    public static String getNetworkSubType() {
        return C0821b.f1014d;
    }

    public static String getProxyType() {
        NetworkStatus networkStatus = C0821b.f1013c;
        return (networkStatus != NetworkStatus.WIFI || getWifiProxy() == null) ? (networkStatus.isMobile() && C0821b.f1015e.contains("wap")) ? "wap" : (!networkStatus.isMobile() || C0861g.m736a() == null) ? "" : "auth" : "proxy";
    }

    public static int getRestrictBackgroundStatus() {
        return C0821b.m622g();
    }

    public static String getSimOp() {
        return C0821b.f1019i;
    }

    public static NetworkStatus getStatus() {
        return C0821b.f1013c;
    }

    public static String getUniqueId(NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String md5ToHex = StringUtils.md5ToHex(getWifiBSSID());
            if (TextUtils.isEmpty(md5ToHex)) {
                md5ToHex = "";
            }
            return "WIFI$" + md5ToHex;
        }
        if (!networkStatus.isMobile()) {
            return "";
        }
        return networkStatus.getType() + "$" + getApn();
    }

    public static String getWifiBSSID() {
        return C0821b.f1017g;
    }

    public static Pair<String, Integer> getWifiProxy() {
        if (C0821b.f1013c != NetworkStatus.WIFI) {
            return null;
        }
        return C0821b.f1020j;
    }

    public static String getWifiSSID() {
        return C0821b.f1016f;
    }

    public static boolean isConnected() {
        if (Build.VERSION.SDK_INT >= 24) {
            if (C0821b.f1012b) {
                return true;
            }
        } else if (C0821b.f1013c != NetworkStatus.NO) {
            return true;
        }
        try {
            NetworkInfo m620e = C0821b.m620e();
            if (m620e != null) {
                if (m620e.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isProxy() {
        NetworkStatus networkStatus = C0821b.f1013c;
        String str = C0821b.f1015e;
        if (networkStatus == NetworkStatus.WIFI && getWifiProxy() != null) {
            return true;
        }
        if (networkStatus.isMobile()) {
            return str.contains("wap") || C0861g.m736a() != null;
        }
        return false;
    }

    public static boolean isRoaming() {
        return C0821b.f1021k;
    }

    static void notifyStatusChanged(NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0820a(networkStatus));
    }

    public static void printNetworkDetail() {
        try {
            NetworkStatus status = getStatus();
            StringBuilder sb = new StringBuilder(128);
            sb.append("\nNetwork detail*******************************\n");
            sb.append("Status: ");
            sb.append(status.getType());
            sb.append('\n');
            sb.append("Subtype: ");
            sb.append(getNetworkSubType());
            sb.append('\n');
            if (status != NetworkStatus.NO) {
                if (status.isMobile()) {
                    sb.append("Apn: ");
                    sb.append(getApn());
                    sb.append('\n');
                    sb.append("Carrier: ");
                    sb.append(getCarrier());
                    sb.append('\n');
                } else {
                    sb.append("BSSID: ");
                    sb.append(getWifiBSSID());
                    sb.append('\n');
                    sb.append("SSID: ");
                    sb.append(getWifiSSID());
                    sb.append('\n');
                }
            }
            if (isProxy()) {
                sb.append("Proxy: ");
                sb.append(getProxyType());
                sb.append('\n');
                Pair<String, Integer> wifiProxy = getWifiProxy();
                if (wifiProxy != null) {
                    sb.append("ProxyHost: ");
                    sb.append((String) wifiProxy.first);
                    sb.append('\n');
                    sb.append("ProxyPort: ");
                    sb.append(wifiProxy.second);
                    sb.append('\n');
                }
            }
            sb.append("*********************************************");
            ALog.m716i(TAG, sb.toString(), null, new Object[0]);
        } catch (Exception unused) {
        }
    }

    public static void removeStatusChangeListener(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        listeners.remove(iNetworkStatusChangeListener);
    }

    public static synchronized void startListener(Context context) {
        synchronized (NetworkStatusHelper.class) {
            if (context == null) {
                throw new NullPointerException("context is null");
            }
            C0821b.f1011a = context;
            C0821b.m614a();
            C0821b.m618c();
        }
    }

    public void stopListener(Context context) {
        C0821b.m616b();
    }
}
