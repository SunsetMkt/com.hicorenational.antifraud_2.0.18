package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h1 implements o1 {
    private List<b1> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k0 f4741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t0 f4742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o1 f4743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4744e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f4745f;

    public h1(String str) {
        this.f4745f = str;
    }

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        String str;
        List<b1> list = this.a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f4741b == null || this.f4742c == null || this.f4743d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f4741b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObjectA = this.f4743d.a();
            jSONObjectA.put("properties", this.f4742c.a());
            try {
                jSONObjectA.put("events_global_properties", new JSONObject(this.f4744e));
            } catch (JSONException unused) {
                jSONObjectA.put("events_global_properties", this.f4744e);
            }
            jSONObject2.put("events_common", jSONObjectA);
            JSONArray jSONArray = new JSONArray();
            Iterator<b1> it = this.a.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectA2 = it.next().a();
                if (jSONObjectA2 != null) {
                    jSONArray.put(jSONObjectA2);
                } else {
                    v.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put(com.umeng.analytics.pro.d.ar, jSONArray);
            try {
                String strA = n.a(k1.a(jSONObject2.toString().getBytes("UTF-8")), this.f4745f);
                if (TextUtils.isEmpty(strA)) {
                    v.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", strA);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        v.e("hmsSdk", str);
        return null;
    }

    public void a(k0 k0Var) {
        this.f4741b = k0Var;
    }

    public void a(l lVar) {
        this.f4743d = lVar;
    }

    public void a(t0 t0Var) {
        this.f4742c = t0Var;
    }

    public void a(String str) {
        if (str != null) {
            this.f4744e = str;
        }
    }

    public void a(List<b1> list) {
        this.a = list;
    }
}
