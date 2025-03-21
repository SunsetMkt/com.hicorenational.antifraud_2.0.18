package com.xiaomi.push;

import android.content.Context;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.xiaomi.push.service.C4394q;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.xiaomi.push.cp */
/* loaded from: classes2.dex */
public class C4141cp {

    /* renamed from: a */
    private final String f14763a = "disconnection_event";

    /* renamed from: b */
    private final String f14764b = "count";

    /* renamed from: c */
    private final String f14765c = Constants.KEY_HOST;

    /* renamed from: d */
    private final String f14766d = "network_state";

    /* renamed from: e */
    private final String f14767e = "reason";

    /* renamed from: f */
    private final String f14768f = "ping_interval";

    /* renamed from: g */
    private final String f14769g = C3351bh.f11568T;

    /* renamed from: h */
    private final String f14770h = "wifi_digest";

    /* renamed from: i */
    private final String f14771i = "duration";

    /* renamed from: j */
    private final String f14772j = "disconnect_time";

    /* renamed from: k */
    private final String f14773k = "connect_time";

    /* renamed from: l */
    private final String f14774l = "xmsf_vc";

    /* renamed from: m */
    private final String f14775m = "android_vc";

    /* renamed from: n */
    private final String f14776n = "uuid";

    /* renamed from: a */
    public void m14155a(Context context, List<C4140co> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        C4139cn.m14125a("upload size = " + list.size());
        String m16206a = C4394q.m16206a(context);
        for (C4140co c4140co : list) {
            HashMap hashMap = new HashMap();
            hashMap.put("count", Integer.valueOf(c4140co.m14129a()));
            hashMap.put(Constants.KEY_HOST, c4140co.m14131a());
            hashMap.put("network_state", Integer.valueOf(c4140co.m14135b()));
            hashMap.put("reason", Integer.valueOf(c4140co.m14141c()));
            hashMap.put("ping_interval", Long.valueOf(c4140co.m14130a()));
            hashMap.put(C3351bh.f11568T, Integer.valueOf(c4140co.m14145d()));
            hashMap.put("wifi_digest", c4140co.m14137b());
            hashMap.put("connected_network_type", Integer.valueOf(c4140co.m14149e()));
            hashMap.put("duration", Long.valueOf(c4140co.m14136b()));
            hashMap.put("disconnect_time", Long.valueOf(c4140co.m14142c()));
            hashMap.put("connect_time", Long.valueOf(c4140co.m14146d()));
            hashMap.put("xmsf_vc", Integer.valueOf(c4140co.m14151f()));
            hashMap.put("android_vc", Integer.valueOf(c4140co.m14153g()));
            hashMap.put("uuid", m16206a);
            C4187eh.m14597a().mo14596a("disconnection_event", hashMap);
        }
    }
}
