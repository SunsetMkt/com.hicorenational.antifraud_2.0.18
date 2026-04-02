package com.umeng.analytics.pro;

import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONObject;

/* JADX INFO: compiled from: HttpPostThread.java */
/* JADX INFO: loaded from: classes2.dex */
public class ao implements Runnable {
    public static final String a = "https://ucc.umeng.com/v2/inn/fetch";

    /* JADX INFO: renamed from: b */
    private String f7004b;

    /* JADX INFO: renamed from: c */
    private String f7005c;

    /* JADX INFO: renamed from: d */
    private String f7006d;

    public ao(String str, JSONObject jSONObject, String str2) {
        this.f7004b = str;
        this.f7005c = jSONObject.toString();
        this.f7006d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = null;
        try {
            byte[] bArrA = am.a(this.f7004b, this.f7005c);
            if (bArrA != null) {
                JSONObject jSONObject2 = new JSONObject(new String(bArrA));
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.f7006d);
                    jSONObject3.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (Throwable unused2) {
        }
        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 102, com.umeng.ccg.d.a(), jSONObject);
    }
}
