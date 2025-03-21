package anet.channel.strategy.dispatch;

import android.os.Build;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.utils.C0848c;
import anet.channel.util.ALog;
import anet.channel.util.C0857c;
import com.taobao.accs.antibrush.C2964b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: anet.channel.strategy.dispatch.d */
/* loaded from: classes.dex */
class C0833d {
    public static final String TAG = "amdc.DispatchParamBuilder";

    C0833d() {
    }

    /* renamed from: a */
    public static Map m684a(Map<String, Object> map) {
        IAmdcSign sign = AmdcRuntimeInfo.getSign();
        if (sign == null || TextUtils.isEmpty(sign.getAppkey())) {
            ALog.m715e(TAG, "amdc sign is null or appkey is empty", null, new Object[0]);
            return null;
        }
        NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        if (!NetworkStatusHelper.isConnected()) {
            ALog.m715e(TAG, "no network, don't send amdc request", null, new Object[0]);
            return null;
        }
        map.put("appkey", sign.getAppkey());
        map.put("v", DispatchConstants.VER_CODE);
        map.put("platform", DispatchConstants.ANDROID);
        map.put(DispatchConstants.PLATFORM_VERSION, Build.VERSION.RELEASE);
        if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getUserId())) {
            map.put("sid", GlobalAppRuntimeInfo.getUserId());
        }
        map.put("netType", status.toString());
        map.put("carrier", NetworkStatusHelper.getCarrier());
        map.put(DispatchConstants.MNC, NetworkStatusHelper.getSimOp());
        if (AmdcRuntimeInfo.latitude != 0.0d) {
            map.put("lat", String.valueOf(AmdcRuntimeInfo.latitude));
        }
        if (AmdcRuntimeInfo.longitude != 0.0d) {
            map.put("lng", String.valueOf(AmdcRuntimeInfo.longitude));
        }
        map.putAll(AmdcRuntimeInfo.getParams());
        map.put("channel", AmdcRuntimeInfo.appChannel);
        map.put("appName", AmdcRuntimeInfo.appName);
        map.put("appVersion", AmdcRuntimeInfo.appVersion);
        map.put(DispatchConstants.STACK_TYPE, Integer.toString(m682a()));
        map.put(DispatchConstants.DOMAIN, m685b(map));
        map.put(DispatchConstants.SIGNTYPE, sign.useSecurityGuard() ? C2964b.KEY_SEC : "noSec");
        map.put("t", String.valueOf(System.currentTimeMillis()));
        String m683a = m683a(sign, map);
        if (TextUtils.isEmpty(m683a)) {
            return null;
        }
        map.put("sign", m683a);
        return map;
    }

    /* renamed from: b */
    private static String m685b(Map map) {
        Set set = (Set) map.remove(DispatchConstants.HOSTS);
        StringBuilder sb = new StringBuilder();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static int m682a() {
        int m727c = C0857c.m727c();
        if (m727c == 1) {
            return 4;
        }
        if (m727c != 2) {
            return m727c != 3 ? 4 : 1;
        }
        return 2;
    }

    /* renamed from: a */
    static String m683a(IAmdcSign iAmdcSign, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(C0848c.m710d(map.get("appkey")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get(DispatchConstants.DOMAIN)));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("appName")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("appVersion")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get(DispatchConstants.BSSID)));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("channel")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("deviceId")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("lat")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("lng")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get(DispatchConstants.MACHINE)));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("netType")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get(DispatchConstants.OTHER)));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("platform")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get(DispatchConstants.PLATFORM_VERSION)));
        sb.append("&");
        sb.append(C0848c.m710d(map.get(DispatchConstants.PRE_IP)));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("sid")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("t")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get("v")));
        sb.append("&");
        sb.append(C0848c.m710d(map.get(DispatchConstants.SIGNTYPE)));
        try {
            return iAmdcSign.sign(sb.toString());
        } catch (Exception e2) {
            ALog.m714e(TAG, "get sign failed", null, e2, new Object[0]);
            return null;
        }
    }
}
