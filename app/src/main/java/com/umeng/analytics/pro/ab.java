package com.umeng.analytics.pro;

import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: AplAction.java */
/* JADX INFO: loaded from: classes2.dex */
public class ab extends z {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6982b;

    public ab(String str, ArrayList<aa> arrayList) {
        super(str, arrayList);
        this.a = "";
        this.f6982b = "";
    }

    @Override // com.umeng.analytics.pro.z, com.umeng.analytics.pro.ag
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObjectA = super.a(str, jSONObject);
        if (jSONObjectA != null) {
            try {
                jSONObjectA.put(com.umeng.ccg.a.s, this.a);
                jSONObjectA.put("action", this.f6982b);
            } catch (Throwable unused) {
            }
        }
        return jSONObjectA;
    }

    public void c(String str) {
        this.a = str;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.f6982b;
    }

    public void d(String str) {
        this.f6982b = str;
    }
}
