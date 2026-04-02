package com.xiaomi.push;

import android.content.Context;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class cp {
    private final String a = "disconnection_event";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8812b = "count";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8813c = Constants.KEY_HOST;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8814d = "network_state";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8815e = "reason";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f8816f = "ping_interval";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f8817g = com.umeng.analytics.pro.bh.T;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f8818h = "wifi_digest";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f8819i = "duration";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f8820j = "disconnect_time";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f8821k = "connect_time";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f8822l = "xmsf_vc";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f8823m = "android_vc";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f8824n = "uuid";

    public void a(Context context, List<co> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        cn.a("upload size = " + list.size());
        String strM740a = com.xiaomi.push.service.q.m740a(context);
        for (co coVar : list) {
            HashMap map = new HashMap();
            map.put("count", Integer.valueOf(coVar.a()));
            map.put(Constants.KEY_HOST, coVar.m242a());
            map.put("network_state", Integer.valueOf(coVar.b()));
            map.put("reason", Integer.valueOf(coVar.c()));
            map.put("ping_interval", Long.valueOf(coVar.m241a()));
            map.put(com.umeng.analytics.pro.bh.T, Integer.valueOf(coVar.d()));
            map.put("wifi_digest", coVar.m244b());
            map.put("connected_network_type", Integer.valueOf(coVar.e()));
            map.put("duration", Long.valueOf(coVar.m243b()));
            map.put("disconnect_time", Long.valueOf(coVar.m245c()));
            map.put("connect_time", Long.valueOf(coVar.m246d()));
            map.put("xmsf_vc", Integer.valueOf(coVar.f()));
            map.put("android_vc", Integer.valueOf(coVar.g()));
            map.put("uuid", strM740a);
            eh.a().a("disconnection_event", map);
        }
    }
}
