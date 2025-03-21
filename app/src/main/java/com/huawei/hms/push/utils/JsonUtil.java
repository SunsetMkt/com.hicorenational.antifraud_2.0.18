package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonUtil {
    private JsonUtil() {
    }

    /* renamed from: a */
    private static void m7647a(JSONObject jSONObject, String str, Object obj, Bundle bundle) {
        if (obj == null) {
            HMSLog.m7718w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            }
            bundle.putString(str, getString(jSONObject, str, str2));
            return;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, getInt(jSONObject, str, ((Integer) obj).intValue()));
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            if (iArr.length == 0) {
                iArr = null;
            }
            bundle.putIntArray(str, getIntArray(jSONObject, str, iArr));
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            if (jArr.length == 0) {
                jArr = null;
            }
            bundle.putLongArray(str, getLongArray(jSONObject, str, jArr));
            return;
        }
        if (!(obj instanceof String[])) {
            HMSLog.m7718w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
            return;
        }
        String[] strArr = (String[]) obj;
        if (strArr.length == 0) {
            strArr = null;
        }
        bundle.putStringArray(str, getStringArray(jSONObject, str, strArr));
    }

    public static int getInt(JSONObject jSONObject, String str, int i2) {
        if (jSONObject == null) {
            return i2;
        }
        try {
            return jSONObject.has(str) ? jSONObject.getInt(str) : i2;
        } catch (JSONException unused) {
            HMSLog.m7718w("JsonUtil", "JSONException: get " + str + " error.");
            return i2;
        }
    }

    public static int[] getIntArray(JSONObject jSONObject, String str, int[] iArr) {
        int[] iArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    iArr2 = new int[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        iArr2[i2] = ((Integer) jSONArray.get(i2)).intValue();
                    }
                }
            } catch (JSONException unused) {
                HMSLog.m7718w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return iArr2 == null ? iArr : iArr2;
    }

    public static JSONArray getIntJsonArray(int[] iArr) {
        JSONArray jSONArray = new JSONArray();
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                jSONArray.put(i2);
            }
        }
        return jSONArray;
    }

    public static long[] getLongArray(JSONObject jSONObject, String str, long[] jArr) {
        long[] jArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    jArr2 = new long[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        jArr2[i2] = jSONArray.getLong(i2);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.m7718w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return jArr2 == null ? jArr : jArr2;
    }

    public static JSONArray getLongJsonArray(long[] jArr) {
        JSONArray jSONArray = new JSONArray();
        if (jArr != null && jArr.length != 0) {
            for (long j2 : jArr) {
                jSONArray.put(j2);
            }
        }
        return jSONArray;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return str2;
        }
        try {
            return (!jSONObject.has(str) || jSONObject.get(str) == null) ? str2 : String.valueOf(jSONObject.get(str));
        } catch (JSONException unused) {
            HMSLog.m7718w("JsonUtil", "JSONException: get " + str + " error.");
            return str2;
        }
    }

    public static String[] getStringArray(JSONObject jSONObject, String str, String[] strArr) {
        String[] strArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    strArr2 = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr2[i2] = (String) jSONArray.get(i2);
                    }
                }
            } catch (JSONException unused) {
                HMSLog.m7718w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return strArr2;
    }

    public static JSONArray getStringJsonArray(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                jSONArray.put(str);
            }
        }
        return jSONArray;
    }

    public static void transferJsonObjectToBundle(JSONObject jSONObject, Bundle bundle, HashMap<String, Object> hashMap) {
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            m7647a(jSONObject, entry.getKey(), entry.getValue(), bundle);
        }
    }
}
