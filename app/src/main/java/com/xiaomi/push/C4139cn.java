package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.C4390m;

/* renamed from: com.xiaomi.push.cn */
/* loaded from: classes2.dex */
public class C4139cn {

    /* renamed from: a */
    private static int f14747a = -1;

    /* renamed from: a */
    private static C4143cr f14748a;

    /* renamed from: a */
    private static String f14749a;

    /* renamed from: a */
    public static void m14122a(Context context, AbstractC4207fa abstractC4207fa) {
        if (m14126a(context)) {
            if (f14748a == null) {
                f14748a = new C4143cr(context);
            }
            abstractC4207fa.m14765a(f14748a);
            m14125a("startStats");
        }
    }

    /* renamed from: b */
    public static void m14127b(Context context, AbstractC4207fa abstractC4207fa) {
        C4143cr c4143cr = f14748a;
        if (c4143cr != null) {
            abstractC4207fa.m14774b(c4143cr);
            f14748a = null;
            m14125a("stopStats");
        }
    }

    /* renamed from: b */
    private static synchronized void m14128b(String str) {
        synchronized (C4139cn.class) {
            if ("WIFI-ID-UNKNOWN".equals(str)) {
                if (f14749a == null || !f14749a.startsWith("W-")) {
                    f14749a = null;
                }
            } else {
                f14749a = str;
            }
            m14125a("updateNetId new networkId = " + str + ", finally netId = " + f14749a);
        }
    }

    /* renamed from: a */
    private static boolean m14126a(Context context) {
        return C4136ck.m14115a(context);
    }

    /* renamed from: a */
    public static void m14124a(Context context, String str, int i2) {
        if (!m14126a(context)) {
            m14125a("onDisconnection shouldSampling = false");
            return;
        }
        C4142cq.m14166a(context, str, C4092au.m13801b(context), System.currentTimeMillis(), i2, C4390m.m16121a(context).m16145b(), m14119a(context), m14120a(), f14747a);
        m14125a("onDisconnection");
    }

    /* renamed from: a */
    public static void m14121a(Context context) {
        if (!m14126a(context)) {
            m14125a("onReconnection shouldSampling = false");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f14747a = m14119a(context);
        C4142cq.m14164a(context, currentTimeMillis);
        m14125a("onReconnection connectedNetworkType = " + f14747a);
    }

    /* renamed from: a */
    public static void m14123a(Context context, String str) {
        if (!m14126a(context)) {
            m14125a("onWifiChanged shouldSampling = false");
            return;
        }
        m14125a("onWifiChanged wifiDigest = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m14128b("W-" + str);
    }

    /* renamed from: a */
    private static int m14119a(Context context) {
        String str;
        try {
            C4093av m13784a = C4092au.m13784a();
            if (m13784a != null) {
                if (m13784a.m13811a() == 0) {
                    String m13817b = m13784a.m13817b();
                    if (TextUtils.isEmpty(m13817b) || "UNKNOWN".equalsIgnoreCase(m13817b)) {
                        str = null;
                    } else {
                        str = "M-" + m13817b;
                    }
                    m14128b(str);
                    return 0;
                }
                if (m13784a.m13811a() != 1 && m13784a.m13811a() != 6) {
                    m14128b(null);
                    return -1;
                }
                m14128b("WIFI-ID-UNKNOWN");
                return 1;
            }
            m14128b(null);
            return -1;
        } catch (Exception e2) {
            AbstractC4022b.m13361d("DisconnectStatsHelper getNetType occurred error: " + e2.getMessage());
            m14128b(null);
            return -1;
        }
    }

    /* renamed from: a */
    private static synchronized String m14120a() {
        String str;
        synchronized (C4139cn.class) {
            str = f14749a;
        }
        return str;
    }

    /* renamed from: a */
    static void m14125a(String str) {
        C4136ck.m14114a("Push-DiscntStats", str);
    }
}
