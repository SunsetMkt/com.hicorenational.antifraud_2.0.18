package anet.channel.util;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.NetTypeStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.android.netutil.UdpConnectType;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.c */
/* loaded from: classes.dex */
public class C0857c {
    public static final int IPV4_ONLY = 1;
    public static final int IPV6_ONLY = 2;
    public static final int IP_DUAL_STACK = 3;
    public static final int IP_STACK_UNKNOWN = 0;

    /* renamed from: b */
    static volatile String f1174b;

    /* renamed from: c */
    static C0860f f1175c;

    /* renamed from: a */
    static final byte[][] f1173a = {new byte[]{-64, 0, 0, -86}, new byte[]{-64, 0, 0, -85}};

    /* renamed from: d */
    static ConcurrentHashMap<String, C0860f> f1176d = new ConcurrentHashMap<>();

    /* renamed from: e */
    static ConcurrentHashMap<String, Integer> f1177e = new ConcurrentHashMap<>();

    static {
        f1174b = null;
        f1175c = null;
        try {
            f1175c = new C0860f((Inet6Address) InetAddress.getAllByName("64:ff9b::")[0], 96);
            f1174b = m725b(NetworkStatusHelper.getStatus());
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static boolean m723a() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m725b(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String wifiBSSID = NetworkStatusHelper.getWifiBSSID();
            if (TextUtils.isEmpty(wifiBSSID)) {
                wifiBSSID = "";
            }
            return "WIFI$" + wifiBSSID;
        }
        if (!networkStatus.isMobile()) {
            return "UnknownNetwork";
        }
        return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
    }

    /* renamed from: c */
    public static int m727c() {
        Integer num = f1177e.get(f1174b);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* renamed from: d */
    public static C0860f m728d() {
        C0860f c0860f = f1176d.get(f1174b);
        return c0860f == null ? f1175c : c0860f;
    }

    /* renamed from: e */
    public static void m729e() {
        if (!AwcnConfig.isIpv6Enable()) {
            ALog.m715e("awcn.Inet64Util", "[startIpStackDetect]ipv6Enable=false", null, new Object[0]);
            return;
        }
        f1174b = m725b(NetworkStatusHelper.getStatus());
        if (f1177e.putIfAbsent(f1174b, 0) != null) {
            return;
        }
        int m734j = m734j();
        f1177e.put(f1174b, Integer.valueOf(m734j));
        NetTypeStat netTypeStat = new NetTypeStat();
        netTypeStat.ipStackType = m734j;
        String str = f1174b;
        if (m734j == 2 || m734j == 3) {
            ThreadPoolExecutorFactory.submitScheduledTask(new RunnableC0858d(str, netTypeStat), 1500L, TimeUnit.MILLISECONDS);
        } else if (GlobalAppRuntimeInfo.isTargetProcess()) {
            AppMonitor.getInstance().commitStat(netTypeStat);
        }
    }

    /* renamed from: h */
    private static int m732h() throws SocketException {
        String str;
        int i2;
        TreeMap treeMap = new TreeMap();
        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (true) {
            str = null;
            i2 = 0;
            if (!it.hasNext()) {
                break;
            }
            NetworkInterface networkInterface = (NetworkInterface) it.next();
            if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                String displayName = networkInterface.getDisplayName();
                ALog.m716i("awcn.Inet64Util", "find NetworkInterface:" + displayName, null, new Object[0]);
                Iterator<InterfaceAddress> it2 = networkInterface.getInterfaceAddresses().iterator();
                int i3 = 0;
                while (it2.hasNext()) {
                    InetAddress address = it2.next().getAddress();
                    if (address instanceof Inet6Address) {
                        Inet6Address inet6Address = (Inet6Address) address;
                        if (!m724a(inet6Address)) {
                            ALog.m715e("awcn.Inet64Util", "Found IPv6 address:" + inet6Address.toString(), null, new Object[0]);
                            i3 |= 2;
                        }
                    } else if (address instanceof Inet4Address) {
                        Inet4Address inet4Address = (Inet4Address) address;
                        if (!m724a((InetAddress) inet4Address) && !inet4Address.getHostAddress().startsWith("192.168.43.")) {
                            ALog.m715e("awcn.Inet64Util", "Found IPv4 address:" + inet4Address.toString(), null, new Object[0]);
                            i3 |= 1;
                        }
                    }
                }
                if (i3 != 0) {
                    treeMap.put(displayName.toLowerCase(), Integer.valueOf(i3));
                }
            }
        }
        if (treeMap.isEmpty()) {
            return 0;
        }
        if (treeMap.size() == 1) {
            return ((Integer) treeMap.firstEntry().getValue()).intValue();
        }
        if (NetworkStatusHelper.getStatus().isWifi()) {
            str = "wlan";
        } else if (NetworkStatusHelper.getStatus().isMobile()) {
            str = "rmnet";
        }
        if (str != null) {
            Iterator it3 = treeMap.entrySet().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it3.next();
                if (((String) entry.getKey()).startsWith(str)) {
                    i2 = ((Integer) entry.getValue()).intValue();
                    break;
                }
            }
        }
        return (i2 == 2 && treeMap.containsKey("v4-wlan0")) ? i2 | ((Integer) treeMap.remove("v4-wlan0")).intValue() : i2;
    }

    /* renamed from: i */
    private static int m733i() {
        SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        int i2 = UdpConnectType.testUdpConnectIpv4() ? 1 : 0;
        return UdpConnectType.testUdpConnectIpv6() ? i2 | 2 : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object[]] */
    /* renamed from: j */
    public static int m734j() {
        ?? r3;
        int i2;
        try {
            r3 = AwcnConfig.isIpStackDetectByUdpConnect();
        } catch (Throwable th) {
            th = th;
            r3 = 0;
        }
        try {
            if (r3 != 0) {
                String str = "udp_connect";
                i2 = m733i();
                r3 = str;
            } else {
                String str2 = "interfaces";
                i2 = m732h();
                r3 = str2;
            }
        } catch (Throwable th2) {
            th = th2;
            ALog.m714e("awcn.Inet64Util", "[detectIpStack]error.", null, th, new Object[0]);
            i2 = 0;
            ALog.m715e("awcn.Inet64Util", "startIpStackDetect", null, new Object[]{"ip stack", Integer.valueOf(i2), "detectType", r3});
            return i2;
        }
        ALog.m715e("awcn.Inet64Util", "startIpStackDetect", null, new Object[]{"ip stack", Integer.valueOf(i2), "detectType", r3});
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static C0860f m735k() throws UnknownHostException {
        InetAddress inetAddress;
        boolean z;
        try {
            inetAddress = InetAddress.getByName("ipv4only.arpa");
        } catch (Exception unused) {
            inetAddress = null;
        }
        if (inetAddress instanceof Inet6Address) {
            ALog.m716i("awcn.Inet64Util", "Resolved AAAA: " + inetAddress.toString(), null, new Object[0]);
            byte[] address = inetAddress.getAddress();
            if (address.length != 16) {
                return null;
            }
            int i2 = 12;
            while (true) {
                z = true;
                if (i2 < 0) {
                    z = false;
                    break;
                }
                byte b2 = address[i2];
                byte[][] bArr = f1173a;
                if ((b2 & bArr[0][0]) != 0 && address[i2 + 1] == 0 && address[i2 + 2] == 0) {
                    int i3 = i2 + 3;
                    if (address[i3] == bArr[0][3] || address[i3] == bArr[1][3]) {
                        break;
                    }
                }
                i2--;
            }
            if (z) {
                address[i2 + 3] = 0;
                address[i2 + 2] = 0;
                address[i2 + 1] = 0;
                address[i2] = 0;
                return new C0860f(Inet6Address.getByAddress("ipv4only.arpa", address, 0), i2 * 8);
            }
        } else if (inetAddress instanceof Inet4Address) {
            ALog.m716i("awcn.Inet64Util", "Resolved A: " + inetAddress.toString(), null, new Object[0]);
        }
        return null;
    }

    /* renamed from: a */
    public static String m722a(Inet4Address inet4Address) throws Exception {
        if (inet4Address == null) {
            throw new InvalidParameterException("address in null");
        }
        C0860f m728d = m728d();
        if (m728d == null) {
            throw new Exception("cannot get nat64 prefix");
        }
        byte[] address = inet4Address.getAddress();
        byte[] address2 = m728d.f1182b.getAddress();
        int i2 = m728d.f1181a / 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i3 + i2;
            if (i5 > 15 || i4 >= 4) {
                break;
            }
            if (i5 != 8) {
                address2[i5] = (byte) (address[i4] | address2[i5]);
                i4++;
            }
            i3++;
        }
        return InetAddress.getByAddress(address2).getHostAddress();
    }

    /* renamed from: b */
    public static boolean m726b() {
        Integer num = f1177e.get(f1174b);
        return num != null && num.intValue() == 1;
    }

    /* renamed from: a */
    public static String m721a(String str) throws Exception {
        return m722a((Inet4Address) Inet4Address.getByName(str));
    }

    /* renamed from: a */
    private static boolean m724a(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }
}
