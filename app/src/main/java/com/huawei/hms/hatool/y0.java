package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class y0 extends t0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f4825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String f4826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4827h;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f4827h);
        jSONObject.put("_emui_ver", this.a);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.f4825f);
        jSONObject.put("_mnc", this.f4826g);
        jSONObject.put("_package_name", this.f4814b);
        jSONObject.put("_app_ver", this.f4815c);
        jSONObject.put("_lib_ver", "2.2.0.314");
        jSONObject.put("_channel", this.f4816d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f4817e);
        return jSONObject;
    }

    public void f(String str) {
        this.f4825f = str;
    }

    public void g(String str) {
        this.f4826g = str;
    }

    public void h(String str) {
        this.f4827h = str;
    }
}
