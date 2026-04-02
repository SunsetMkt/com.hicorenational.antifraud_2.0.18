package anet.channel;

import android.text.TextUtils;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class AwcnConfig {
    public static final String HTTP3_ENABLE = "HTTP3_ENABLE";
    public static final String NEXT_LAUNCH_FORBID = "NEXT_LAUNCH_FORBID";
    private static volatile boolean a = false;

    /* JADX INFO: renamed from: b */
    private static volatile boolean f1312b = true;

    /* JADX INFO: renamed from: c */
    private static volatile boolean f1313c = true;

    /* JADX INFO: renamed from: d */
    private static volatile boolean f1314d = true;

    /* JADX INFO: renamed from: e */
    private static volatile boolean f1315e = false;

    /* JADX INFO: renamed from: f */
    private static volatile boolean f1316f = true;

    /* JADX INFO: renamed from: g */
    private static volatile long f1317g = 43200000;

    /* JADX INFO: renamed from: h */
    private static volatile boolean f1318h = true;

    /* JADX INFO: renamed from: i */
    private static volatile boolean f1319i = true;

    /* JADX INFO: renamed from: j */
    private static boolean f1320j = true;

    /* JADX INFO: renamed from: k */
    private static boolean f1321k = false;

    /* JADX INFO: renamed from: l */
    private static volatile boolean f1322l = false;

    /* JADX INFO: renamed from: m */
    private static volatile boolean f1323m = true;

    /* JADX INFO: renamed from: n */
    private static volatile boolean f1324n = false;
    private static volatile int o = 10000;
    private static volatile boolean p = false;
    private static volatile boolean q = true;
    private static volatile int r = -1;
    private static volatile boolean s = true;
    private static volatile boolean t = true;
    private static volatile boolean u = false;
    private static volatile boolean v = true;
    private static volatile CopyOnWriteArrayList<String> w = null;
    private static volatile boolean x = true;
    private static volatile boolean y = true;

    public static int getAccsReconnectionDelayPeriod() {
        return o;
    }

    public static long getIpv6BlackListTtl() {
        return f1317g;
    }

    public static int getXquicCongControl() {
        return r;
    }

    public static boolean isAccsSessionCreateForbiddenInBg() {
        return a;
    }

    public static boolean isAllowHttpDnsNotify(String str) {
        if (w == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return w.contains(str);
    }

    public static boolean isAppLifeCycleListenerEnable() {
        return f1320j;
    }

    public static boolean isAsyncLoadStrategyEnable() {
        return f1321k;
    }

    public static boolean isCarrierInfoEnable() {
        return y;
    }

    public static boolean isCookieHeaderRedundantFix() {
        return t;
    }

    public static boolean isHorseRaceEnable() {
        return f1313c;
    }

    public static boolean isHttp3Enable() {
        return p;
    }

    public static boolean isHttp3OrangeEnable() {
        return q;
    }

    public static boolean isHttpsSniEnable() {
        return f1312b;
    }

    public static boolean isIdleSessionCloseEnable() {
        return f1316f;
    }

    public static boolean isIpStackDetectByUdpConnect() {
        return s;
    }

    public static boolean isIpv6BlackListEnable() {
        return f1319i;
    }

    public static boolean isIpv6Enable() {
        return f1318h;
    }

    public static boolean isNetworkDetectEnable() {
        return f1324n;
    }

    public static boolean isPing6Enable() {
        return f1323m;
    }

    public static boolean isQuicEnable() {
        return f1315e;
    }

    public static boolean isSendConnectInfoByBroadcast() {
        return u;
    }

    public static boolean isSendConnectInfoByService() {
        return v;
    }

    public static boolean isTbNextLaunch() {
        return f1322l;
    }

    public static boolean isTnetHeaderCacheEnable() {
        return f1314d;
    }

    public static boolean isWifiInfoEnable() {
        return x;
    }

    public static void registerPresetSessions(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess() && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString(Constants.KEY_HOST);
                    if (!anet.channel.strategy.utils.c.c(string)) {
                        return;
                    }
                    StrategyTemplate.getInstance().registerConnProtocol(string, ConnProtocol.valueOf(jSONObject.getString("protocol"), jSONObject.getString("rtt"), jSONObject.getString("publicKey")));
                    if (jSONObject.getBoolean("isKeepAlive")) {
                        SessionCenter.getInstance().registerSessionInfo(SessionInfo.create(string, true, false, null, null, null));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void setAccsReconnectionDelayPeriod(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 10000) {
            i2 = 10000;
        }
        o = i2;
    }

    public static void setAccsSessionCreateForbiddenInBg(boolean z) {
        a = z;
    }

    public static void setAppLifeCycleListenerEnable(boolean z) {
        f1320j = z;
    }

    public static void setAsyncLoadStrategyEnable(boolean z) {
        f1321k = z;
    }

    public static void setCarrierInfoEnable(boolean z) {
        y = z;
    }

    public static void setCookieHeaderRedundantFix(boolean z) {
        t = z;
    }

    public static void setHorseRaceEnable(boolean z) {
        f1313c = z;
    }

    public static void setHttp3Enable(boolean z) {
        p = z;
        ALog.e("awcn.AwcnConfig", "[setHttp3Enable]", null, "enable", Boolean.valueOf(z));
    }

    public static void setHttp3OrangeEnable(boolean z) {
        q = z;
    }

    public static void setHttpDnsNotifyWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            w = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.e("awcn.AwcnConfig", "[setHttpDnsNotifyWhiteList] error", null, e2, new Object[0]);
        }
    }

    public static void setHttpsSniEnable(boolean z) {
        f1312b = z;
    }

    public static void setIdleSessionCloseEnable(boolean z) {
        f1316f = z;
    }

    public static void setIpStackDetectByUdpConnect(boolean z) {
        s = z;
    }

    public static void setIpv6BlackListEnable(boolean z) {
        f1319i = z;
    }

    public static void setIpv6BlackListTtl(long j2) {
        f1317g = j2;
    }

    public static void setIpv6Enable(boolean z) {
        f1318h = z;
    }

    public static void setNetworkDetectEnable(boolean z) {
        f1324n = z;
    }

    public static void setPing6Enable(boolean z) {
        f1323m = z;
    }

    public static void setQuicEnable(boolean z) {
        f1315e = z;
    }

    public static void setSendConnectInfoByBroadcast(boolean z) {
        u = z;
    }

    public static void setSendConnectInfoByService(boolean z) {
        v = z;
    }

    public static void setTbNextLaunch(boolean z) {
        f1322l = z;
    }

    public static void setTnetHeaderCacheEnable(boolean z) {
        f1314d = z;
    }

    public static void setWifiInfoEnable(boolean z) {
        x = z;
    }

    public static void setXquicCongControl(int i2) {
        if (i2 < 0) {
            return;
        }
        r = i2;
    }
}
