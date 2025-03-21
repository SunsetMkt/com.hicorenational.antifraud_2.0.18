package com.huawei.agconnect.config.impl;

import com.huawei.agconnect.config.ConfigReader;
import com.umeng.socialize.common.SocializeConstants;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.agconnect.config.impl.i */
/* loaded from: classes.dex */
public class C2256i implements ConfigReader {

    /* renamed from: a */
    private final JSONObject f6909a;

    C2256i(InputStream inputStream, String str) {
        this.f6909a = m6432a(inputStream);
        m6433a(str);
    }

    /* renamed from: a */
    private JSONObject m6432a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException | JSONException unused) {
            }
        }
        return new JSONObject();
    }

    /* renamed from: a */
    private void m6433a(String str) {
        try {
            JSONObject m6435b = m6435b(str);
            if (m6435b == null) {
                return;
            }
            String string = getString("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal("0.0");
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
            } catch (NumberFormatException unused) {
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.f6909a.getJSONObject("client").put("app_id", m6435b.getString("app_id"));
                return;
            }
            if (bigDecimal.compareTo(new BigDecimal(SocializeConstants.PROTOCOL_VERSON)) >= 0) {
                Iterator<String> keys = m6435b.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!"package_name".equals(next)) {
                        m6434a(next, m6435b.get(next), this.f6909a);
                    }
                }
            }
        } catch (JSONException unused2) {
        }
    }

    /* renamed from: a */
    private void m6434a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            m6434a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    /* renamed from: b */
    private JSONObject m6435b(String str) throws JSONException {
        JSONArray jSONArray = this.f6909a.getJSONArray("appInfos");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] split = str.split("/");
        try {
            JSONObject jSONObject = this.f6909a;
            for (int i2 = 1; i2 < split.length; i2++) {
                if (i2 == split.length - 1) {
                    str = jSONObject.get(split[i2]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(split[i2]);
            }
        } catch (JSONException unused) {
            String str3 = "JSONException when reading 'path': " + str;
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f6909a.toString().hashCode() + '}';
    }
}
