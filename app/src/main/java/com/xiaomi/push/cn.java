package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class cn {
    private static int a = -1;

    /* JADX INFO: renamed from: a */
    private static cr f270a;

    /* JADX INFO: renamed from: a */
    private static String f271a;

    public static void a(Context context, fa faVar) {
        if (m240a(context)) {
            if (f270a == null) {
                f270a = new cr(context);
            }
            faVar.a(f270a);
            a("startStats");
        }
    }

    public static void b(Context context, fa faVar) {
        cr crVar = f270a;
        if (crVar != null) {
            faVar.b(crVar);
            f270a = null;
            a("stopStats");
        }
    }

    private static synchronized void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            if (f271a == null || !f271a.startsWith("W-")) {
                f271a = null;
            }
        } else {
            f271a = str;
        }
        a("updateNetId new networkId = " + str + ", finally netId = " + f271a);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m240a(Context context) {
        return ck.a(context);
    }

    public static void a(Context context, String str, int i2) {
        if (!m240a(context)) {
            a("onDisconnection shouldSampling = false");
            return;
        }
        cq.a(context, str, au.b(context), System.currentTimeMillis(), i2, com.xiaomi.push.service.m.a(context).m724b(), a(context), a(), a);
        a("onDisconnection");
    }

    /* JADX INFO: renamed from: a */
    public static void m239a(Context context) {
        if (!m240a(context)) {
            a("onReconnection shouldSampling = false");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        a = a(context);
        cq.a(context, jCurrentTimeMillis);
        a("onReconnection connectedNetworkType = " + a);
    }

    public static void a(Context context, String str) {
        if (!m240a(context)) {
            a("onWifiChanged shouldSampling = false");
            return;
        }
        a("onWifiChanged wifiDigest = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b("W-" + str);
    }

    private static int a(Context context) {
        String str;
        try {
            av avVarM142a = au.m142a();
            if (avVarM142a != null) {
                if (avVarM142a.a() == 0) {
                    String strM154b = avVarM142a.m154b();
                    if (TextUtils.isEmpty(strM154b) || "UNKNOWN".equalsIgnoreCase(strM154b)) {
                        str = null;
                    } else {
                        str = "M-" + strM154b;
                    }
                    b(str);
                    return 0;
                }
                if (avVarM142a.a() != 1 && avVarM142a.a() != 6) {
                    b(null);
                    return -1;
                }
                b("WIFI-ID-UNKNOWN");
                return 1;
            }
            b(null);
            return -1;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("DisconnectStatsHelper getNetType occurred error: " + e2.getMessage());
            b(null);
            return -1;
        }
    }

    private static synchronized String a() {
        return f271a;
    }

    static void a(String str) {
        ck.a("Push-DiscntStats", str);
    }
}
