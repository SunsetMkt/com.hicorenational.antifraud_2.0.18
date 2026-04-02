package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ResponseWrap {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ResponseHeader f4572b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f4572b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f4572b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f4572b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f4572b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f4572b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f4572b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f4572b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f4572b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f4572b.setPkgName(JsonUtil.getStringValue(jSONObject, Constants.PARAM_PKG_NAME));
            this.f4572b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.f4572b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.f4572b.setResolution(JsonUtil.getStringValue(jSONObject, "resolution"));
            this.a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e2) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e2.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = new JSONObject().toString();
        }
        return this.a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f4572b;
    }

    public void setBody(String str) {
        this.a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f4572b = responseHeader;
    }

    public String toJson() {
        if (this.f4572b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f4572b.getStatusCode());
            jSONObject.put("error_code", this.f4572b.getErrorCode());
            jSONObject.put("error_reason", this.f4572b.getErrorReason());
            jSONObject.put("srv_name", this.f4572b.getSrvName());
            jSONObject.put("api_name", this.f4572b.getApiName());
            jSONObject.put("app_id", this.f4572b.getAppID());
            jSONObject.put(Constants.PARAM_PKG_NAME, this.f4572b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.f4572b.getTransactionId());
            jSONObject.put("resolution", this.f4572b.getResolution());
            String sessionId = this.f4572b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put("body", this.a);
            }
        } catch (JSONException e2) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e2.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.a + "', responseHeader=" + this.f4572b + '}';
    }
}
