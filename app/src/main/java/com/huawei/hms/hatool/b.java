package com.huawei.hms.hatool;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {
    s0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    s0 f4696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Context f4697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f4698d;

    public b(Context context) {
        if (context != null) {
            this.f4697c = context.getApplicationContext();
        }
        this.a = new s0();
        this.f4696b = new s0();
    }

    public b a(int i2, String str) {
        s0 s0Var;
        v.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i2);
        if (!p1.b(str)) {
            str = "";
        }
        if (i2 == 0) {
            s0Var = this.a;
        } else {
            if (i2 != 1) {
                v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            }
            s0Var = this.f4696b;
        }
        s0Var.b(str);
        return this;
    }

    public b a(String str) {
        v.c("hmsSdk", "Builder.setAppID is execute");
        this.f4698d = str;
        return this;
    }

    @Deprecated
    public b a(boolean z) {
        v.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.a.j().a(z);
        this.f4696b.j().a(z);
        return this;
    }

    public void a() {
        if (this.f4697c == null) {
            v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        v.c("hmsSdk", "Builder.create() is execute.");
        z0 z0Var = new z0("_hms_config_tag");
        z0Var.b(new s0(this.a));
        z0Var.a(new s0(this.f4696b));
        m.a().a(this.f4697c);
        g0.a().a(this.f4697c);
        q.c().a(z0Var);
        m.a().a(this.f4698d);
    }

    @Deprecated
    public b b(boolean z) {
        v.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.a.j().b(z);
        this.f4696b.j().b(z);
        return this;
    }

    @Deprecated
    public b c(boolean z) {
        v.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.a.j().c(z);
        this.f4696b.j().c(z);
        return this;
    }
}
