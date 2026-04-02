package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b1 implements o1 {
    private String a;

    /* JADX INFO: renamed from: b */
    private String f4705b;

    /* JADX INFO: renamed from: c */
    private String f4706c;

    /* JADX INFO: renamed from: d */
    private String f4707d;

    /* JADX INFO: renamed from: e */
    private String f4708e;

    /* JADX INFO: renamed from: f */
    private String f4709f;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.a);
        jSONObject.put("eventtime", this.f4707d);
        jSONObject.put("event", this.f4705b);
        jSONObject.put("event_session_name", this.f4708e);
        jSONObject.put("first_session_event", this.f4709f);
        if (TextUtils.isEmpty(this.f4706c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f4706c));
        return jSONObject;
    }

    public void a(String str) {
        this.f4706c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f4705b = jSONObject.optString("event");
        this.f4706c = n.a(jSONObject.optString("properties"), o0.d().a());
        this.a = jSONObject.optString("type");
        this.f4707d = jSONObject.optString("eventtime");
        this.f4708e = jSONObject.optString("event_session_name");
        this.f4709f = jSONObject.optString("first_session_event");
    }

    public String b() {
        return this.f4707d;
    }

    public void b(String str) {
        this.f4705b = str;
    }

    public String c() {
        return this.a;
    }

    public void c(String str) {
        this.f4707d = str;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObjectA = a();
        jSONObjectA.put("properties", n.b(this.f4706c, o0.d().a()));
        return jSONObjectA;
    }

    public void d(String str) {
        this.a = str;
    }

    public void e(String str) {
        this.f4709f = str;
    }

    public void f(String str) {
        this.f4708e = str;
    }
}
