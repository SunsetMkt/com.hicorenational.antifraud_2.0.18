package com.umeng.p221ut.p226b.p229b;

import com.umeng.p221ut.p222a.C3796a;
import com.umeng.p221ut.p222a.p225c.C3810e;
import org.json.JSONObject;

/* renamed from: com.umeng.ut.b.b.b */
/* loaded from: classes2.dex */
class C3817b {

    /* renamed from: d */
    int f13891d = -1;

    C3817b() {
    }

    /* renamed from: a */
    static C3817b m12805a(String str) {
        JSONObject jSONObject;
        C3817b c3817b = new C3817b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("code")) {
                c3817b.f13891d = jSONObject2.getInt("code");
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null && jSONObject.has("id") && jSONObject.has("d_ts")) {
                C3819d.m12808a(C3796a.m12755a().m12757a()).m12820a(jSONObject.getString("id"), jSONObject.getLong("d_ts"));
            }
            C3810e.m12784a("BizResponse", "content", str);
        } catch (Throwable th) {
            C3810e.m12784a("", th.toString());
        }
        return c3817b;
    }

    /* renamed from: a */
    static boolean m12806a(int i2) {
        return i2 >= 0 && i2 != 10012;
    }
}
