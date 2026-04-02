package com.huawei.hms.hatool;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b */
    private static m f4779b;

    /* JADX INFO: renamed from: c */
    private static final Object f4780c = new Object();
    private Context a;

    private m() {
    }

    public static m a() {
        if (f4779b == null) {
            b();
        }
        return f4779b;
    }

    private static synchronized void b() {
        if (f4779b == null) {
            f4779b = new m();
        }
    }

    public void a(Context context) {
        synchronized (f4780c) {
            if (this.a != null) {
                v.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.a = context;
            s.c().b().a(this.a);
            s.c().b().j(context.getPackageName());
            j.a().a(context);
        }
    }

    public void a(String str) {
        v.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
        } else {
            s.c().b().i(e1.a(com.heytap.mcssdk.constant.b.u, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
