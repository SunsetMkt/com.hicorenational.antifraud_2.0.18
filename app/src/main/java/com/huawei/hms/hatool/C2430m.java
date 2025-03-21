package com.huawei.hms.hatool;

import android.content.Context;
import com.heytap.mcssdk.constant.C2085b;

/* renamed from: com.huawei.hms.hatool.m */
/* loaded from: classes.dex */
public final class C2430m {

    /* renamed from: b */
    private static C2430m f7574b;

    /* renamed from: c */
    private static final Object f7575c = new Object();

    /* renamed from: a */
    private Context f7576a;

    private C2430m() {
    }

    /* renamed from: a */
    public static C2430m m7226a() {
        if (f7574b == null) {
            m7227b();
        }
        return f7574b;
    }

    /* renamed from: b */
    private static synchronized void m7227b() {
        synchronized (C2430m.class) {
            if (f7574b == null) {
                f7574b = new C2430m();
            }
        }
    }

    /* renamed from: a */
    public void m7228a(Context context) {
        synchronized (f7575c) {
            if (this.f7576a != null) {
                C2452v.m7390f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f7576a = context;
            C2446s.m7326c().m7331b().m7116a(this.f7576a);
            C2446s.m7326c().m7331b().m7135j(context.getPackageName());
            C2421j.m7169a().m7172a(context);
        }
    }

    /* renamed from: a */
    public void m7229a(String str) {
        C2452v.m7385c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f7576a;
        if (context == null) {
            C2452v.m7389e("hmsSdk", "sdk is not init");
        } else {
            C2446s.m7326c().m7331b().m7133i(C2408e1.m7096a(C2085b.f6180u, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
