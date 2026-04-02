package com.umeng.ut.b.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f8433d = -1;

    b() {
    }

    static b a(String str) {
        JSONObject jSONObject;
        b bVar = new b();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("code")) {
                bVar.f8433d = jSONObject2.getInt("code");
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null && jSONObject.has("id") && jSONObject.has("d_ts")) {
                d.a(com.umeng.ut.a.a.a().m39a()).a(jSONObject.getString("id"), jSONObject.getLong("d_ts"));
            }
            com.umeng.ut.a.c.e.m42a("BizResponse", "content", str);
        } catch (Throwable th) {
            com.umeng.ut.a.c.e.m42a("", th.toString());
        }
        return bVar;
    }

    static boolean a(int i2) {
        return i2 >= 0 && i2 != 10012;
    }
}
