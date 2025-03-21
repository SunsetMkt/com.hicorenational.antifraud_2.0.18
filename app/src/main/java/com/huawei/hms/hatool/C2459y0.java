package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.y0 */
/* loaded from: classes.dex */
public class C2459y0 extends AbstractC2449t0 {

    /* renamed from: f */
    String f7646f;

    /* renamed from: g */
    String f7647g;

    /* renamed from: h */
    private String f7648h;

    @Override // com.huawei.hms.hatool.InterfaceC2438o1
    /* renamed from: a */
    public JSONObject mo7044a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f7648h);
        jSONObject.put("_emui_ver", this.f7629a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f7646f);
        jSONObject.put("_mnc", this.f7647g);
        jSONObject.put("_package_name", this.f7630b);
        jSONObject.put("_app_ver", this.f7631c);
        jSONObject.put("_lib_ver", "2.2.0.314");
        jSONObject.put("_channel", this.f7632d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f7633e);
        return jSONObject;
    }

    /* renamed from: f */
    public void m7418f(String str) {
        this.f7646f = str;
    }

    /* renamed from: g */
    public void m7419g(String str) {
        this.f7647g = str;
    }

    /* renamed from: h */
    public void m7420h(String str) {
        this.f7648h = str;
    }
}
