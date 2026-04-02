package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7872b;
    private String a = "_$unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7873c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f7874d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7875e = a.f7871j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f7876f = null;

    public b(Context context) {
        this.f7872b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.f7873c;
    }

    public Map<String, Object> c() {
        return this.f7876f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("pn", this.f7872b);
            jSONObject.put("ds", this.f7874d);
            jSONObject.put("ts", this.f7873c);
            if (this.f7876f != null && this.f7876f.size() > 0) {
                for (String str : this.f7876f.keySet()) {
                    jSONObject.put(str, this.f7876f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f7875e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.a + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("pn:" + this.f7872b + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("ts:" + this.f7873c + Constants.ACCEPT_TIME_SEPARATOR_SP);
        Map<String, Object> map = this.f7876f;
        if (map != null && map.size() > 0) {
            for (String str : this.f7876f.keySet()) {
                Object obj = this.f7876f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        sb.append("ds:" + this.f7874d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(long j2) {
        this.f7873c = j2;
    }

    public void a(Map<String, Object> map) {
        this.f7876f = map;
    }
}
