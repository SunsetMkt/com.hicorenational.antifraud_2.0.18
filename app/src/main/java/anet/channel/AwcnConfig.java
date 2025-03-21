package anet.channel;

import android.text.TextUtils;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AwcnConfig {
    public static final String HTTP3_ENABLE = "HTTP3_ENABLE";
    public static final String NEXT_LAUNCH_FORBID = "NEXT_LAUNCH_FORBID";

    /* renamed from: a */
    private static volatile boolean f635a = false;

    /* renamed from: b */
    private static volatile boolean f636b = true;

    /* renamed from: c */
    private static volatile boolean f637c = true;

    /* renamed from: d */
    private static volatile boolean f638d = true;

    /* renamed from: e */
    private static volatile boolean f639e = false;

    /* renamed from: f */
    private static volatile boolean f640f = true;

    /* renamed from: g */
    private static volatile long f641g = 43200000;

    /* renamed from: h */
    private static volatile boolean f642h = true;

    /* renamed from: i */
    private static volatile boolean f643i = true;

    /* renamed from: j */
    private static boolean f644j = true;

    /* renamed from: k */
    private static boolean f645k = false;

    /* renamed from: l */
    private static volatile boolean f646l = false;

    /* renamed from: m */
    private static volatile boolean f647m = true;

    /* renamed from: n */
    private static volatile boolean f648n = false;

    /* renamed from: o */
    private static volatile int f649o = 10000;

    /* renamed from: p */
    private static volatile boolean f650p = false;

    /* renamed from: q */
    private static volatile boolean f651q = true;

    /* renamed from: r */
    private static volatile int f652r = -1;

    /* renamed from: s */
    private static volatile boolean f653s = true;

    /* renamed from: t */
    private static volatile boolean f654t = true;

    /* renamed from: u */
    private static volatile boolean f655u = false;

    /* renamed from: v */
    private static volatile boolean f656v = true;

    /* renamed from: w */
    private static volatile CopyOnWriteArrayList<String> f657w = null;

    /* renamed from: x */
    private static volatile boolean f658x = true;

    /* renamed from: y */
    private static volatile boolean f659y = true;

    public static int getAccsReconnectionDelayPeriod() {
        return f649o;
    }

    public static long getIpv6BlackListTtl() {
        return f641g;
    }

    public static int getXquicCongControl() {
        return f652r;
    }

    public static boolean isAccsSessionCreateForbiddenInBg() {
        return f635a;
    }

    public static boolean isAllowHttpDnsNotify(String str) {
        if (f657w == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return f657w.contains(str);
    }

    public static boolean isAppLifeCycleListenerEnable() {
        return f644j;
    }

    public static boolean isAsyncLoadStrategyEnable() {
        return f645k;
    }

    public static boolean isCarrierInfoEnable() {
        return f659y;
    }

    public static boolean isCookieHeaderRedundantFix() {
        return f654t;
    }

    public static boolean isHorseRaceEnable() {
        return f637c;
    }

    public static boolean isHttp3Enable() {
        return f650p;
    }

    public static boolean isHttp3OrangeEnable() {
        return f651q;
    }

    public static boolean isHttpsSniEnable() {
        return f636b;
    }

    public static boolean isIdleSessionCloseEnable() {
        return f640f;
    }

    public static boolean isIpStackDetectByUdpConnect() {
        return f653s;
    }

    public static boolean isIpv6BlackListEnable() {
        return f643i;
    }

    public static boolean isIpv6Enable() {
        return f642h;
    }

    public static boolean isNetworkDetectEnable() {
        return f648n;
    }

    public static boolean isPing6Enable() {
        return f647m;
    }

    public static boolean isQuicEnable() {
        return f639e;
    }

    public static boolean isSendConnectInfoByBroadcast() {
        return f655u;
    }

    public static boolean isSendConnectInfoByService() {
        return f656v;
    }

    public static boolean isTbNextLaunch() {
        return f646l;
    }

    public static boolean isTnetHeaderCacheEnable() {
        return f638d;
    }

    public static boolean isWifiInfoEnable() {
        return f658x;
    }

    public static void registerPresetSessions(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess() && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString(Constants.KEY_HOST);
                    if (!C0848c.m709c(string)) {
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
        f649o = i2;
    }

    public static void setAccsSessionCreateForbiddenInBg(boolean z) {
        f635a = z;
    }

    public static void setAppLifeCycleListenerEnable(boolean z) {
        f644j = z;
    }

    public static void setAsyncLoadStrategyEnable(boolean z) {
        f645k = z;
    }

    public static void setCarrierInfoEnable(boolean z) {
        f659y = z;
    }

    public static void setCookieHeaderRedundantFix(boolean z) {
        f654t = z;
    }

    public static void setHorseRaceEnable(boolean z) {
        f637c = z;
    }

    public static void setHttp3Enable(boolean z) {
        f650p = z;
        ALog.m715e("awcn.AwcnConfig", "[setHttp3Enable]", null, "enable", Boolean.valueOf(z));
    }

    public static void setHttp3OrangeEnable(boolean z) {
        f651q = z;
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
            f657w = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.m714e("awcn.AwcnConfig", "[setHttpDnsNotifyWhiteList] error", null, e2, new Object[0]);
        }
    }

    public static void setHttpsSniEnable(boolean z) {
        f636b = z;
    }

    public static void setIdleSessionCloseEnable(boolean z) {
        f640f = z;
    }

    public static void setIpStackDetectByUdpConnect(boolean z) {
        f653s = z;
    }

    public static void setIpv6BlackListEnable(boolean z) {
        f643i = z;
    }

    public static void setIpv6BlackListTtl(long j2) {
        f641g = j2;
    }

    public static void setIpv6Enable(boolean z) {
        f642h = z;
    }

    public static void setNetworkDetectEnable(boolean z) {
        f648n = z;
    }

    public static void setPing6Enable(boolean z) {
        f647m = z;
    }

    public static void setQuicEnable(boolean z) {
        f639e = z;
    }

    public static void setSendConnectInfoByBroadcast(boolean z) {
        f655u = z;
    }

    public static void setSendConnectInfoByService(boolean z) {
        f656v = z;
    }

    public static void setTbNextLaunch(boolean z) {
        f646l = z;
    }

    public static void setTnetHeaderCacheEnable(boolean z) {
        f638d = z;
    }

    public static void setWifiInfoEnable(boolean z) {
        f658x = z;
    }

    public static void setXquicCongControl(int i2) {
        if (i2 < 0) {
            return;
        }
        f652r = i2;
    }
}
