package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ResponseWrap {

    /* renamed from: a */
    private String f7295a;

    /* renamed from: b */
    private ResponseHeader f7296b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f7296b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f7296b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f7296b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f7296b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f7296b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f7296b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f7296b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f7296b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f7296b.setPkgName(JsonUtil.getStringValue(jSONObject, Constants.PARAM_PKG_NAME));
            this.f7296b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.f7296b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.f7296b.setResolution(JsonUtil.getStringValue(jSONObject, "resolution"));
            this.f7295a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e2) {
            HMSLog.m7715e("ResponseWrap", "fromJson failed: " + e2.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f7295a)) {
            this.f7295a = new JSONObject().toString();
        }
        return this.f7295a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f7296b;
    }

    public void setBody(String str) {
        this.f7295a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f7296b = responseHeader;
    }

    public String toJson() {
        if (this.f7296b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f7296b.getStatusCode());
            jSONObject.put("error_code", this.f7296b.getErrorCode());
            jSONObject.put("error_reason", this.f7296b.getErrorReason());
            jSONObject.put("srv_name", this.f7296b.getSrvName());
            jSONObject.put("api_name", this.f7296b.getApiName());
            jSONObject.put("app_id", this.f7296b.getAppID());
            jSONObject.put(Constants.PARAM_PKG_NAME, this.f7296b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.f7296b.getTransactionId());
            jSONObject.put("resolution", this.f7296b.getResolution());
            String sessionId = this.f7296b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.f7295a)) {
                jSONObject.put("body", this.f7295a);
            }
        } catch (JSONException e2) {
            HMSLog.m7715e("ResponseWrap", "toJson failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f7295a + "', responseHeader=" + this.f7296b + '}';
    }
}
