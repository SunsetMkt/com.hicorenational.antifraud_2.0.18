package com.xiaomi.push;

import org.json.JSONObject;

/* renamed from: com.xiaomi.push.cb */
/* loaded from: classes2.dex */
public class C4127cb {

    /* renamed from: a */
    private int f14696a;

    /* renamed from: a */
    private long f14697a;

    /* renamed from: a */
    private String f14698a;

    /* renamed from: b */
    private long f14699b;

    /* renamed from: c */
    private long f14700c;

    public C4127cb() {
        this(0, 0L, 0L, null);
    }

    /* renamed from: a */
    public int m14028a() {
        return this.f14696a;
    }

    public C4127cb(int i2, long j2, long j3, Exception exc) {
        this.f14696a = i2;
        this.f14697a = j2;
        this.f14700c = j3;
        this.f14699b = System.currentTimeMillis();
        if (exc != null) {
            this.f14698a = exc.getClass().getSimpleName();
        }
    }

    /* renamed from: a */
    public JSONObject m14030a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f14697a);
        jSONObject.put("size", this.f14700c);
        jSONObject.put("ts", this.f14699b);
        jSONObject.put("wt", this.f14696a);
        jSONObject.put("expt", this.f14698a);
        return jSONObject;
    }

    /* renamed from: a */
    public C4127cb m14029a(JSONObject jSONObject) {
        this.f14697a = jSONObject.getLong("cost");
        this.f14700c = jSONObject.getLong("size");
        this.f14699b = jSONObject.getLong("ts");
        this.f14696a = jSONObject.getInt("wt");
        this.f14698a = jSONObject.optString("expt");
        return this;
    }
}
