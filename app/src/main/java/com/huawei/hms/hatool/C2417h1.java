package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.umeng.analytics.pro.C3397d;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.h1 */
/* loaded from: classes.dex */
public class C2417h1 implements InterfaceC2438o1 {

    /* renamed from: a */
    private List<C2399b1> f7525a;

    /* renamed from: b */
    private AbstractC2425k0 f7526b;

    /* renamed from: c */
    private AbstractC2449t0 f7527c;

    /* renamed from: d */
    private InterfaceC2438o1 f7528d;

    /* renamed from: e */
    private String f7529e = "";

    /* renamed from: f */
    private String f7530f;

    public C2417h1(String str) {
        this.f7530f = str;
    }

    @Override // com.huawei.hms.hatool.InterfaceC2438o1
    /* renamed from: a */
    public JSONObject mo7044a() {
        String str;
        List<C2399b1> list = this.f7525a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f7526b == null || this.f7527c == null || this.f7528d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.f7526b.mo7044a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject mo7044a = this.f7528d.mo7044a();
            mo7044a.put("properties", this.f7527c.mo7044a());
            try {
                mo7044a.put("events_global_properties", new JSONObject(this.f7529e));
            } catch (JSONException unused) {
                mo7044a.put("events_global_properties", this.f7529e);
            }
            jSONObject2.put("events_common", mo7044a);
            JSONArray jSONArray = new JSONArray();
            Iterator<C2399b1> it = this.f7525a.iterator();
            while (it.hasNext()) {
                JSONObject mo7044a2 = it.next().mo7044a();
                if (mo7044a2 != null) {
                    jSONArray.put(mo7044a2);
                } else {
                    C2452v.m7389e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put(C3397d.f11927ar, jSONArray);
            try {
                String m7246a = C2433n.m7246a(C2426k1.m7206a(jSONObject2.toString().getBytes("UTF-8")), this.f7530f);
                if (TextUtils.isEmpty(m7246a)) {
                    C2452v.m7389e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", m7246a);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        C2452v.m7389e("hmsSdk", str);
        return null;
    }

    /* renamed from: a */
    public void m7157a(AbstractC2425k0 abstractC2425k0) {
        this.f7526b = abstractC2425k0;
    }

    /* renamed from: a */
    public void m7158a(C2427l c2427l) {
        this.f7528d = c2427l;
    }

    /* renamed from: a */
    public void m7159a(AbstractC2449t0 abstractC2449t0) {
        this.f7527c = abstractC2449t0;
    }

    /* renamed from: a */
    public void m7160a(String str) {
        if (str != null) {
            this.f7529e = str;
        }
    }

    /* renamed from: a */
    public void m7161a(List<C2399b1> list) {
        this.f7525a = list;
    }
}
