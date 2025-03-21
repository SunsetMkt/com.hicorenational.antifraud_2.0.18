package com.huawei.hms.hatool;

import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.f0 */
/* loaded from: classes.dex */
public class C2410f0 extends AbstractC2425k0 {

    /* renamed from: g */
    private String f7502g = "";

    @Override // com.huawei.hms.hatool.InterfaceC2438o1
    /* renamed from: a */
    public JSONObject mo7044a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "3");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f7556d);
        jSONObject.put("appid", this.f7553a);
        jSONObject.put("hmac", this.f7502g);
        jSONObject.put("chifer", this.f7558f);
        jSONObject.put("timestamp", this.f7554b);
        jSONObject.put("servicetag", this.f7555c);
        jSONObject.put("requestid", this.f7557e);
        return jSONObject;
    }

    /* renamed from: g */
    public void m7104g(String str) {
        this.f7502g = str;
    }
}
