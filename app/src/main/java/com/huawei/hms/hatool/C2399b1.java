package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.b1 */
/* loaded from: classes.dex */
public class C2399b1 implements InterfaceC2438o1 {

    /* renamed from: a */
    private String f7478a;

    /* renamed from: b */
    private String f7479b;

    /* renamed from: c */
    private String f7480c;

    /* renamed from: d */
    private String f7481d;

    /* renamed from: e */
    private String f7482e;

    /* renamed from: f */
    private String f7483f;

    @Override // com.huawei.hms.hatool.InterfaceC2438o1
    /* renamed from: a */
    public JSONObject mo7044a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f7478a);
        jSONObject.put("eventtime", this.f7481d);
        jSONObject.put("event", this.f7479b);
        jSONObject.put("event_session_name", this.f7482e);
        jSONObject.put("first_session_event", this.f7483f);
        if (TextUtils.isEmpty(this.f7480c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f7480c));
        return jSONObject;
    }

    /* renamed from: a */
    public void m7045a(String str) {
        this.f7480c = str;
    }

    /* renamed from: a */
    public void m7046a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f7479b = jSONObject.optString("event");
        this.f7480c = C2433n.m7245a(jSONObject.optString("properties"), C2437o0.m7270d().m7274a());
        this.f7478a = jSONObject.optString("type");
        this.f7481d = jSONObject.optString("eventtime");
        this.f7482e = jSONObject.optString("event_session_name");
        this.f7483f = jSONObject.optString("first_session_event");
    }

    /* renamed from: b */
    public String m7047b() {
        return this.f7481d;
    }

    /* renamed from: b */
    public void m7048b(String str) {
        this.f7479b = str;
    }

    /* renamed from: c */
    public String m7049c() {
        return this.f7478a;
    }

    /* renamed from: c */
    public void m7050c(String str) {
        this.f7481d = str;
    }

    /* renamed from: d */
    public JSONObject m7051d() {
        JSONObject mo7044a = mo7044a();
        mo7044a.put("properties", C2433n.m7247b(this.f7480c, C2437o0.m7270d().m7274a()));
        return mo7044a;
    }

    /* renamed from: d */
    public void m7052d(String str) {
        this.f7478a = str;
    }

    /* renamed from: e */
    public void m7053e(String str) {
        this.f7483f = str;
    }

    /* renamed from: f */
    public void m7054f(String str) {
        this.f7482e = str;
    }
}
