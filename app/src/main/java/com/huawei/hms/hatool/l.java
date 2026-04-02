package com.huawei.hms.hatool;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4766b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4767c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f4768d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4769e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f4770f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4771g;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.a);
        jSONObject.put("oaid", this.f4771g);
        jSONObject.put("uuid", this.f4770f);
        jSONObject.put("upid", this.f4769e);
        jSONObject.put("imei", this.f4766b);
        jSONObject.put("sn", this.f4767c);
        jSONObject.put("udid", this.f4768d);
        return jSONObject;
    }

    public void b(String str) {
        this.f4766b = str;
    }

    public void c(String str) {
        this.f4771g = str;
    }

    public void d(String str) {
        this.f4767c = str;
    }

    public void e(String str) {
        this.f4768d = str;
    }

    public void f(String str) {
        this.f4769e = str;
    }

    public void g(String str) {
        this.f4770f = str;
    }
}
