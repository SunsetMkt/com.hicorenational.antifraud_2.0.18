package com.huawei.hms.hatool;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f0 extends k0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f4724g = "";

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f4763d);
        jSONObject.put("appid", this.a);
        jSONObject.put("hmac", this.f4724g);
        jSONObject.put("chifer", this.f4765f);
        jSONObject.put("timestamp", this.f4761b);
        jSONObject.put("servicetag", this.f4762c);
        jSONObject.put("requestid", this.f4764e);
        return jSONObject;
    }

    public void g(String str) {
        this.f4724g = str;
    }
}
