package com.xiaomi.push;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class cv {
    private final String a = "power_consumption_stats";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8836b = "off_up_ct";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8837c = "off_dn_ct";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8838d = "off_ping_ct";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8839e = "off_pong_ct";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f8840f = "off_dur";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f8841g = "on_up_ct";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f8842h = "on_dn_ct";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f8843i = "on_ping_ct";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f8844j = "on_pong_ct";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f8845k = "on_dur";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f8846l = com.umeng.analytics.pro.d.p;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f8847m = com.umeng.analytics.pro.d.q;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f8848n = "xmsf_vc";
    private final String o = "android_vc";
    private final String p = "uuid";

    public void a(Context context, cu cuVar) {
        if (cuVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("off_up_ct", Integer.valueOf(cuVar.a()));
        map.put("off_dn_ct", Integer.valueOf(cuVar.b()));
        map.put("off_ping_ct", Integer.valueOf(cuVar.c()));
        map.put("off_pong_ct", Integer.valueOf(cuVar.d()));
        map.put("off_dur", Long.valueOf(cuVar.m252a()));
        map.put("on_up_ct", Integer.valueOf(cuVar.e()));
        map.put("on_dn_ct", Integer.valueOf(cuVar.f()));
        map.put("on_ping_ct", Integer.valueOf(cuVar.g()));
        map.put("on_pong_ct", Integer.valueOf(cuVar.h()));
        map.put("on_dur", Long.valueOf(cuVar.m253b()));
        map.put(com.umeng.analytics.pro.d.p, Long.valueOf(cuVar.m254c()));
        map.put(com.umeng.analytics.pro.d.q, Long.valueOf(cuVar.m255d()));
        map.put("xmsf_vc", Integer.valueOf(cuVar.i()));
        map.put("android_vc", Integer.valueOf(cuVar.j()));
        map.put("uuid", com.xiaomi.push.service.q.m740a(context));
        eh.a().a("power_consumption_stats", map);
    }
}
