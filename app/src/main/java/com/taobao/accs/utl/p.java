package com.taobao.accs.utl;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        JSONObject a = new JSONObject();

        public a a(String str, String str2) {
            if (str2 != null && str != null) {
                try {
                    this.a.put(str, str2);
                } catch (JSONException unused) {
                }
            }
            return this;
        }

        public a a(String str, Integer num) {
            if (num == null) {
                return this;
            }
            try {
                this.a.put(str, num);
            } catch (JSONException unused) {
            }
            return this;
        }

        public a a(String str, Long l2) {
            if (l2 == null) {
                return this;
            }
            try {
                this.a.put(str, l2);
            } catch (JSONException unused) {
            }
            return this;
        }

        public JSONObject a() {
            return this.a;
        }
    }

    public static String a(JSONObject jSONObject, String str, String str2) throws JSONException {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.getString(str) : str2;
    }
}
