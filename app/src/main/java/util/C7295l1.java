package util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.taobao.accs.utl.UtilityImpl;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import p388ui.Hicore;

/* compiled from: IpGetUtil.java */
/* renamed from: util.l1 */
/* loaded from: classes2.dex */
public class C7295l1 {
    /* renamed from: a */
    public static String m26407a() {
        Hicore app = Hicore.getApp();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) app.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "当前无网络连接";
        }
        if (activeNetworkInfo.getType() != 0) {
            return activeNetworkInfo.getType() == 1 ? m26408a(((WifiManager) app.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo().getIpAddress()) : "";
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m26408a(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }
}
