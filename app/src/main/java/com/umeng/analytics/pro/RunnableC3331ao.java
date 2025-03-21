package com.umeng.analytics.pro;

import com.umeng.ccg.C3440c;
import com.umeng.ccg.C3441d;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* compiled from: HttpPostThread.java */
/* renamed from: com.umeng.analytics.pro.ao */
/* loaded from: classes2.dex */
public class RunnableC3331ao implements Runnable {

    /* renamed from: a */
    public static final String f11466a = "https://ucc.umeng.com/v2/inn/fetch";

    /* renamed from: b */
    private String f11467b;

    /* renamed from: c */
    private String f11468c;

    /* renamed from: d */
    private String f11469d;

    public RunnableC3331ao(String str, JSONObject jSONObject, String str2) {
        this.f11467b = str;
        this.f11468c = jSONObject.toString();
        this.f11469d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] m10851a = C3329am.m10851a(this.f11467b, this.f11468c);
            if (m10851a != null) {
                JSONObject jSONObject2 = new JSONObject(new String(m10851a));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f11469d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        C3440c.m11465a(UMGlobalContext.getAppContext(), 102, C3441d.m11471a(), jSONObject);
    }
}
