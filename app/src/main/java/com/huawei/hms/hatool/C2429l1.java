package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.l1 */
/* loaded from: classes.dex */
public class C2429l1 {

    /* renamed from: a */
    private C2447s0 f7570a;

    /* renamed from: b */
    private C2447s0 f7571b;

    /* renamed from: c */
    private C2447s0 f7572c;

    /* renamed from: d */
    private C2447s0 f7573d;

    public C2429l1(String str) {
    }

    /* renamed from: a */
    public C2447s0 m7219a() {
        return this.f7572c;
    }

    /* renamed from: a */
    public C2447s0 m7220a(String str) {
        if (str.equals("oper")) {
            return m7224c();
        }
        if (str.equals("maint")) {
            return m7222b();
        }
        if (str.equals("diffprivacy")) {
            return m7219a();
        }
        if (str.equals("preins")) {
            return m7225d();
        }
        C2452v.m7390f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    /* renamed from: a */
    public void m7221a(C2447s0 c2447s0) {
        this.f7570a = c2447s0;
    }

    /* renamed from: b */
    public C2447s0 m7222b() {
        return this.f7570a;
    }

    /* renamed from: b */
    public void m7223b(C2447s0 c2447s0) {
        this.f7571b = c2447s0;
    }

    /* renamed from: c */
    public C2447s0 m7224c() {
        return this.f7571b;
    }

    /* renamed from: d */
    public C2447s0 m7225d() {
        return this.f7573d;
    }
}
