package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Event.java */
/* renamed from: com.umeng.commonsdk.vchannel.b */
/* loaded from: classes2.dex */
public class C3533b {

    /* renamed from: b */
    private String f13036b;

    /* renamed from: a */
    private String f13035a = "_$unknown";

    /* renamed from: c */
    private long f13037c = 0;

    /* renamed from: d */
    private long f13038d = 0;

    /* renamed from: e */
    private String f13039e = C3532a.f13034j;

    /* renamed from: f */
    private Map<String, Object> f13040f = null;

    public C3533b(Context context) {
        this.f13036b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    /* renamed from: a */
    public String m12105a() {
        return this.f13035a;
    }

    /* renamed from: b */
    public long m12109b() {
        return this.f13037c;
    }

    /* renamed from: c */
    public Map<String, Object> m12110c() {
        return this.f13040f;
    }

    /* renamed from: d */
    public JSONObject m12111d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f13035a);
            jSONObject.put("pn", this.f13036b);
            jSONObject.put("ds", this.f13038d);
            jSONObject.put("ts", this.f13037c);
            if (this.f13040f != null && this.f13040f.size() > 0) {
                for (String str : this.f13040f.keySet()) {
                    jSONObject.put(str, this.f13040f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f13039e, jSONArray);
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
        sb.append("id:" + this.f13035a + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("pn:" + this.f13036b + Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("ts:" + this.f13037c + Constants.ACCEPT_TIME_SEPARATOR_SP);
        Map<String, Object> map = this.f13040f;
        if (map != null && map.size() > 0) {
            for (String str : this.f13040f.keySet()) {
                Object obj = this.f13040f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        sb.append("ds:" + this.f13038d + "]");
        return sb.toString();
    }

    /* renamed from: a */
    public void m12107a(String str) {
        this.f13035a = str;
    }

    /* renamed from: a */
    public void m12106a(long j2) {
        this.f13037c = j2;
    }

    /* renamed from: a */
    public void m12108a(Map<String, Object> map) {
        this.f13040f = map;
    }
}
