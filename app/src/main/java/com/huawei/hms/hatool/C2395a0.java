package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.a0 */
/* loaded from: classes.dex */
public class C2395a0 implements InterfaceRunnableC2412g {

    /* renamed from: a */
    private Context f7457a = AbstractC2443q0.m7311i();

    /* renamed from: b */
    private String f7458b;

    /* renamed from: c */
    private JSONObject f7459c;

    /* renamed from: d */
    private String f7460d;

    /* renamed from: e */
    private String f7461e;

    /* renamed from: f */
    private String f7462f;

    /* renamed from: g */
    private String f7463g;

    /* renamed from: h */
    private Boolean f7464h;

    public C2395a0(String str, JSONObject jSONObject, String str2, String str3, long j2) {
        this.f7458b = str;
        this.f7459c = jSONObject;
        this.f7460d = str2;
        this.f7461e = str3;
        this.f7462f = String.valueOf(j2);
        if (AbstractC2460z.m7429i(str2, "oper")) {
            C2440p0 m7417a = C2458y.m7415a().m7417a(str2, j2);
            this.f7463g = m7417a.m7280a();
            this.f7464h = Boolean.valueOf(m7417a.m7282b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        C2452v.m7385c("hmsSdk", "Begin to run EventRecordTask...");
        int m7309h = AbstractC2443q0.m7309h();
        int m7029k = AbstractC2396a1.m7029k(this.f7460d, this.f7461e);
        if (C2401c0.m7059a(this.f7457a, "stat_v2_1", m7309h * 1048576)) {
            C2452v.m7385c("hmsSdk", "stat sp file reach max limited size, discard new event");
            C2406e.m7077a().m7084a("", "alltype");
            return;
        }
        C2399b1 c2399b1 = new C2399b1();
        c2399b1.m7048b(this.f7458b);
        c2399b1.m7045a(this.f7459c.toString());
        c2399b1.m7052d(this.f7461e);
        c2399b1.m7050c(this.f7462f);
        c2399b1.m7054f(this.f7463g);
        Boolean bool = this.f7464h;
        c2399b1.m7053e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject m7051d = c2399b1.m7051d();
            String m7253a = AbstractC2435n1.m7253a(this.f7460d, this.f7461e);
            String m7069a = C2403d.m7069a(this.f7457a, "stat_v2_1", m7253a, "");
            try {
                jSONArray = !TextUtils.isEmpty(m7069a) ? new JSONArray(m7069a) : new JSONArray();
            } catch (JSONException unused) {
                C2452v.m7387d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(m7051d);
            C2403d.m7074b(this.f7457a, "stat_v2_1", m7253a, jSONArray.toString());
            if (jSONArray.toString().length() > m7029k * 1024) {
                C2406e.m7077a().m7084a(this.f7460d, this.f7461e);
            }
        } catch (JSONException unused2) {
            C2452v.m7389e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
