package com.huawei.hms.hatool;

import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.l */
/* loaded from: classes.dex */
public class C2427l extends AbstractC2448t {

    /* renamed from: b */
    private String f7559b = "";

    /* renamed from: c */
    private String f7560c = "";

    /* renamed from: d */
    private String f7561d = "";

    /* renamed from: e */
    private String f7562e = "";

    /* renamed from: f */
    protected String f7563f = "";

    /* renamed from: g */
    private String f7564g;

    @Override // com.huawei.hms.hatool.InterfaceC2438o1
    /* renamed from: a */
    public JSONObject mo7044a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f7628a);
        jSONObject.put("oaid", this.f7564g);
        jSONObject.put("uuid", this.f7563f);
        jSONObject.put("upid", this.f7562e);
        jSONObject.put("imei", this.f7559b);
        jSONObject.put("sn", this.f7560c);
        jSONObject.put("udid", this.f7561d);
        return jSONObject;
    }

    /* renamed from: b */
    public void m7207b(String str) {
        this.f7559b = str;
    }

    /* renamed from: c */
    public void m7208c(String str) {
        this.f7564g = str;
    }

    /* renamed from: d */
    public void m7209d(String str) {
        this.f7560c = str;
    }

    /* renamed from: e */
    public void m7210e(String str) {
        this.f7561d = str;
    }

    /* renamed from: f */
    public void m7211f(String str) {
        this.f7562e = str;
    }

    /* renamed from: g */
    public void m7212g(String str) {
        this.f7563f = str;
    }
}
