package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a0 implements g {
    private Context a = q0.i();

    /* JADX INFO: renamed from: b */
    private String f4689b;

    /* JADX INFO: renamed from: c */
    private JSONObject f4690c;

    /* JADX INFO: renamed from: d */
    private String f4691d;

    /* JADX INFO: renamed from: e */
    private String f4692e;

    /* JADX INFO: renamed from: f */
    private String f4693f;

    /* JADX INFO: renamed from: g */
    private String f4694g;

    /* JADX INFO: renamed from: h */
    private Boolean f4695h;

    public a0(String str, JSONObject jSONObject, String str2, String str3, long j2) {
        this.f4689b = str;
        this.f4690c = jSONObject;
        this.f4691d = str2;
        this.f4692e = str3;
        this.f4693f = String.valueOf(j2);
        if (z.i(str2, "oper")) {
            p0 p0VarA = y.a().a(str2, j2);
            this.f4694g = p0VarA.a();
            this.f4695h = Boolean.valueOf(p0VarA.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        v.c("hmsSdk", "Begin to run EventRecordTask...");
        int iH = q0.h();
        int iK = a1.k(this.f4691d, this.f4692e);
        if (c0.a(this.a, "stat_v2_1", iH * 1048576)) {
            v.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            e.a().a("", "alltype");
            return;
        }
        b1 b1Var = new b1();
        b1Var.b(this.f4689b);
        b1Var.a(this.f4690c.toString());
        b1Var.d(this.f4692e);
        b1Var.c(this.f4693f);
        b1Var.f(this.f4694g);
        Boolean bool = this.f4695h;
        b1Var.e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject jSONObjectD = b1Var.d();
            String strA = n1.a(this.f4691d, this.f4692e);
            String strA2 = d.a(this.a, "stat_v2_1", strA, "");
            try {
                jSONArray = !TextUtils.isEmpty(strA2) ? new JSONArray(strA2) : new JSONArray();
            } catch (JSONException unused) {
                v.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(jSONObjectD);
            d.b(this.a, "stat_v2_1", strA, jSONArray.toString());
            if (jSONArray.toString().length() > iK * 1024) {
                e.a().a(this.f4691d, this.f4692e);
            }
        } catch (JSONException unused2) {
            v.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
