package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ForegroundInnerHeader {

    /* renamed from: a */
    private int f7036a;

    /* renamed from: b */
    private String f7037b;

    /* renamed from: c */
    private String f7038c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f7036a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f7037b = JsonUtil.getStringValue(jSONObject, "action");
            this.f7038c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e2) {
            HMSLog.m7715e("ForegroundInnerHeader", "fromJson failed: " + e2.getMessage());
        }
    }

    public String getAction() {
        return this.f7037b;
    }

    public int getApkVersion() {
        return this.f7036a;
    }

    public String getResponseCallbackKey() {
        return this.f7038c;
    }

    public void setAction(String str) {
        this.f7037b = str;
    }

    public void setApkVersion(int i2) {
        this.f7036a = i2;
    }

    public void setResponseCallbackKey(String str) {
        this.f7038c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f7036a);
            jSONObject.put("action", this.f7037b);
            jSONObject.put("responseCallbackKey", this.f7038c);
        } catch (JSONException e2) {
            HMSLog.m7715e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f7036a + ", action:" + this.f7037b + ", responseCallbackKey:" + this.f7038c;
    }
}
