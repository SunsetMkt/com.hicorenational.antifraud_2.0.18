package com.xiaomi.push;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cb {
    private int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8792c;

    public cb() {
        this(0, 0L, 0L, null);
    }

    public int a() {
        return this.a;
    }

    public cb(int i2, long j2, long j3, Exception exc) {
        this.a = i2;
        this.f246a = j2;
        this.f8792c = j3;
        this.f8791b = System.currentTimeMillis();
        if (exc != null) {
            this.f247a = exc.getClass().getSimpleName();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public JSONObject m215a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f246a);
        jSONObject.put("size", this.f8792c);
        jSONObject.put("ts", this.f8791b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f247a);
        return jSONObject;
    }

    public cb a(JSONObject jSONObject) {
        this.f246a = jSONObject.getLong("cost");
        this.f8792c = jSONObject.getLong("size");
        this.f8791b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f247a = jSONObject.optString("expt");
        return this;
    }
}
