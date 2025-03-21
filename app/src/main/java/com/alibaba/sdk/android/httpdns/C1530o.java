package com.alibaba.sdk.android.httpdns;

import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.sdk.android.httpdns.o */
/* loaded from: classes.dex */
public class C1530o {

    /* renamed from: d */
    private String[] f3965d;
    private boolean enabled;

    C1530o(String str) {
        this.enabled = true;
        try {
            JSONObject jSONObject = new JSONObject(str);
            C1522i.m3525d("StartIp Schedule center response:" + jSONObject.toString());
            if (jSONObject.has("service_status")) {
                this.enabled = jSONObject.getString("service_status").equals("disable") ? false : true;
            }
            if (jSONObject.has("service_ip")) {
                JSONArray jSONArray = jSONObject.getJSONArray("service_ip");
                this.f3965d = new String[jSONArray.length()];
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f3965d[i2] = (String) jSONArray.get(i2);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public String[] m3557b() {
        return this.f3965d;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
