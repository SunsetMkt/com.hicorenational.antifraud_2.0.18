package com.taobao.accs.utl;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.utl.p */
/* loaded from: classes2.dex */
public class C3048p {

    /* compiled from: Taobao */
    /* renamed from: com.taobao.accs.utl.p$a */
    public static class a {

        /* renamed from: a */
        JSONObject f9762a = new JSONObject();

        /* renamed from: a */
        public a m9262a(String str, String str2) {
            if (str2 != null && str != null) {
                try {
                    this.f9762a.put(str, str2);
                } catch (JSONException unused) {
                }
            }
            return this;
        }

        /* renamed from: a */
        public a m9260a(String str, Integer num) {
            if (num == null) {
                return this;
            }
            try {
                this.f9762a.put(str, num);
            } catch (JSONException unused) {
            }
            return this;
        }

        /* renamed from: a */
        public a m9261a(String str, Long l2) {
            if (l2 == null) {
                return this;
            }
            try {
                this.f9762a.put(str, l2);
            } catch (JSONException unused) {
            }
            return this;
        }

        /* renamed from: a */
        public JSONObject m9263a() {
            return this.f9762a;
        }
    }

    /* renamed from: a */
    public static String m9259a(JSONObject jSONObject, String str, String str2) throws JSONException {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.getString(str) : str2;
    }
}
