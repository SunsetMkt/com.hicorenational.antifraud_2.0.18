package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundInnerHeader {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4412c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f4411b = JsonUtil.getStringValue(jSONObject, "action");
            this.f4412c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e2) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e2.getMessage());
        }
    }

    public String getAction() {
        return this.f4411b;
    }

    public int getApkVersion() {
        return this.a;
    }

    public String getResponseCallbackKey() {
        return this.f4412c;
    }

    public void setAction(String str) {
        this.f4411b = str;
    }

    public void setApkVersion(int i2) {
        this.a = i2;
    }

    public void setResponseCallbackKey(String str) {
        this.f4412c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.a);
            jSONObject.put("action", this.f4411b);
            jSONObject.put("responseCallbackKey", this.f4412c);
        } catch (JSONException e2) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.a + ", action:" + this.f4411b + ", responseCallbackKey:" + this.f4412c;
    }
}
