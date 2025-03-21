package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class HianalyticsBaseData {
    public static final String EVENT_ID = "url_request";
    public static final int FALSE = 0;
    public static final String SDK_NAME = "sdk_name";
    public static final String SDK_TYPE = "sdk_type";
    public static final String SDK_VERSION = "sdk_version";
    private static final String TAG = "HianalyticsBaseData";
    public static final int TRUE = 1;
    private LinkedHashMap<String, String> data = new LinkedHashMap<>();

    public HianalyticsBaseData() {
        this.data.put("sdk_type", "UxPP");
        this.data.put(SDK_NAME, "networkkit");
    }

    public LinkedHashMap<String, String> get() {
        return this.data;
    }

    public HianalyticsBaseData put(String str, String str2) {
        if (str == null || str2 == null) {
            Logger.m6801v(TAG, "key = " + str + " : value = " + str2);
        } else {
            this.data.put(str, str2);
        }
        return this;
    }

    public HianalyticsBaseData putIfNotDefault(String str, long j2, long j3) {
        return j2 == j3 ? this : put(str, j2);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : get().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            Logger.m6804w(TAG, "catch JSONException", e2);
        }
        return jSONObject.toString();
    }

    public HianalyticsBaseData put(String str, long j2) {
        if (str == null) {
            Logger.m6801v(TAG, "key = null : value = " + j2);
        } else {
            this.data.put(str, "" + j2);
        }
        return this;
    }

    public HianalyticsBaseData put(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            this.data.putAll(linkedHashMap);
        } else {
            Logger.m6801v(TAG, "data is null");
        }
        return this;
    }
}
