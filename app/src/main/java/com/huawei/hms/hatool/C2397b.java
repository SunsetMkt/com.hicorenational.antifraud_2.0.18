package com.huawei.hms.hatool;

import android.content.Context;

/* renamed from: com.huawei.hms.hatool.b */
/* loaded from: classes.dex */
public class C2397b {

    /* renamed from: a */
    C2447s0 f7465a;

    /* renamed from: b */
    C2447s0 f7466b;

    /* renamed from: c */
    Context f7467c;

    /* renamed from: d */
    String f7468d;

    public C2397b(Context context) {
        if (context != null) {
            this.f7467c = context.getApplicationContext();
        }
        this.f7465a = new C2447s0();
        this.f7466b = new C2447s0();
    }

    /* renamed from: a */
    public C2397b m7034a(int i2, String str) {
        C2447s0 c2447s0;
        C2452v.m7385c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i2);
        if (!C2441p1.m7290b(str)) {
            str = "";
        }
        if (i2 == 0) {
            c2447s0 = this.f7465a;
        } else {
            if (i2 != 1) {
                C2452v.m7390f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            }
            c2447s0 = this.f7466b;
        }
        c2447s0.m7340b(str);
        return this;
    }

    /* renamed from: a */
    public C2397b m7035a(String str) {
        C2452v.m7385c("hmsSdk", "Builder.setAppID is execute");
        this.f7468d = str;
        return this;
    }

    @Deprecated
    /* renamed from: a */
    public C2397b m7036a(boolean z) {
        C2452v.m7385c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f7465a.m7357j().m7179a(z);
        this.f7466b.m7357j().m7179a(z);
        return this;
    }

    /* renamed from: a */
    public void m7037a() {
        if (this.f7467c == null) {
            C2452v.m7382b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        C2452v.m7385c("hmsSdk", "Builder.create() is execute.");
        C2461z0 c2461z0 = new C2461z0("_hms_config_tag");
        c2461z0.m7439b(new C2447s0(this.f7465a));
        c2461z0.m7437a(new C2447s0(this.f7466b));
        C2430m.m7226a().m7228a(this.f7467c);
        C2413g0.m7107a().m7110a(this.f7467c);
        C2442q.m7291c().m7292a(c2461z0);
        C2430m.m7226a().m7229a(this.f7468d);
    }

    @Deprecated
    /* renamed from: b */
    public C2397b m7038b(boolean z) {
        C2452v.m7385c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f7465a.m7357j().m7181b(z);
        this.f7466b.m7357j().m7181b(z);
        return this;
    }

    @Deprecated
    /* renamed from: c */
    public C2397b m7039c(boolean z) {
        C2452v.m7385c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f7465a.m7357j().m7183c(z);
        this.f7466b.m7357j().m7183c(z);
        return this;
    }
}
