package com.xiaomi.push;

import android.content.Context;
import com.umeng.analytics.pro.C3397d;
import com.xiaomi.push.service.C4394q;
import java.util.HashMap;

/* renamed from: com.xiaomi.push.cv */
/* loaded from: classes2.dex */
public class C4147cv {

    /* renamed from: a */
    private final String f14807a = "power_consumption_stats";

    /* renamed from: b */
    private final String f14808b = "off_up_ct";

    /* renamed from: c */
    private final String f14809c = "off_dn_ct";

    /* renamed from: d */
    private final String f14810d = "off_ping_ct";

    /* renamed from: e */
    private final String f14811e = "off_pong_ct";

    /* renamed from: f */
    private final String f14812f = "off_dur";

    /* renamed from: g */
    private final String f14813g = "on_up_ct";

    /* renamed from: h */
    private final String f14814h = "on_dn_ct";

    /* renamed from: i */
    private final String f14815i = "on_ping_ct";

    /* renamed from: j */
    private final String f14816j = "on_pong_ct";

    /* renamed from: k */
    private final String f14817k = "on_dur";

    /* renamed from: l */
    private final String f14818l = C3397d.f11950p;

    /* renamed from: m */
    private final String f14819m = C3397d.f11951q;

    /* renamed from: n */
    private final String f14820n = "xmsf_vc";

    /* renamed from: o */
    private final String f14821o = "android_vc";

    /* renamed from: p */
    private final String f14822p = "uuid";

    /* renamed from: a */
    public void m14221a(Context context, C4146cu c4146cu) {
        if (c4146cu == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("off_up_ct", Integer.valueOf(c4146cu.m14193a()));
        hashMap.put("off_dn_ct", Integer.valueOf(c4146cu.m14197b()));
        hashMap.put("off_ping_ct", Integer.valueOf(c4146cu.m14201c()));
        hashMap.put("off_pong_ct", Integer.valueOf(c4146cu.m14205d()));
        hashMap.put("off_dur", Long.valueOf(c4146cu.m14194a()));
        hashMap.put("on_up_ct", Integer.valueOf(c4146cu.m14209e()));
        hashMap.put("on_dn_ct", Integer.valueOf(c4146cu.m14211f()));
        hashMap.put("on_ping_ct", Integer.valueOf(c4146cu.m14213g()));
        hashMap.put("on_pong_ct", Integer.valueOf(c4146cu.m14215h()));
        hashMap.put("on_dur", Long.valueOf(c4146cu.m14198b()));
        hashMap.put(C3397d.f11950p, Long.valueOf(c4146cu.m14202c()));
        hashMap.put(C3397d.f11951q, Long.valueOf(c4146cu.m14206d()));
        hashMap.put("xmsf_vc", Integer.valueOf(c4146cu.m14217i()));
        hashMap.put("android_vc", Integer.valueOf(c4146cu.m14219j()));
        hashMap.put("uuid", C4394q.m16206a(context));
        C4187eh.m14597a().mo14596a("power_consumption_stats", hashMap);
    }
}
