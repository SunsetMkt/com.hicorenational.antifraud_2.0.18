package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes.dex */
public class l1 {
    private s0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s0 f4776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private s0 f4777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private s0 f4778d;

    public l1(String str) {
    }

    public s0 a() {
        return this.f4777c;
    }

    public s0 a(String str) {
        if (str.equals("oper")) {
            return c();
        }
        if (str.equals("maint")) {
            return b();
        }
        if (str.equals("diffprivacy")) {
            return a();
        }
        if (str.equals("preins")) {
            return d();
        }
        v.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(s0 s0Var) {
        this.a = s0Var;
    }

    public s0 b() {
        return this.a;
    }

    public void b(s0 s0Var) {
        this.f4776b = s0Var;
    }

    public s0 c() {
        return this.f4776b;
    }

    public s0 d() {
        return this.f4778d;
    }
}
