package com.umeng.analytics.pro;

import com.umeng.ccg.C3438a;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: AplAction.java */
/* renamed from: com.umeng.analytics.pro.ab */
/* loaded from: classes2.dex */
public class C3318ab extends C3425z {

    /* renamed from: a */
    private String f11421a;

    /* renamed from: b */
    private String f11422b;

    public C3318ab(String str, ArrayList<InterfaceC3317aa> arrayList) {
        super(str, arrayList);
        this.f11421a = "";
        this.f11422b = "";
    }

    @Override // com.umeng.analytics.pro.C3425z, com.umeng.analytics.pro.InterfaceC3323ag
    /* renamed from: a */
    public JSONObject mo10812a(String str, JSONObject jSONObject) {
        JSONObject mo10812a = super.mo10812a(str, jSONObject);
        if (mo10812a != null) {
            try {
                mo10812a.put(C3438a.f12346s, this.f11421a);
                mo10812a.put("action", this.f11422b);
            } catch (Throwable unused) {
            }
        }
        return mo10812a;
    }

    /* renamed from: c */
    public void m10813c(String str) {
        this.f11421a = str;
    }

    /* renamed from: d */
    public String m10814d() {
        return this.f11421a;
    }

    /* renamed from: e */
    public String m10816e() {
        return this.f11422b;
    }

    /* renamed from: d */
    public void m10815d(String str) {
        this.f11422b = str;
    }
}
