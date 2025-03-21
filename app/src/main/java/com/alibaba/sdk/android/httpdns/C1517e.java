package com.alibaba.sdk.android.httpdns;

import android.text.Html;
import com.alibaba.sdk.android.httpdns.net64.C1528a;
import com.alibaba.sdk.android.httpdns.p112b.C1505b;
import com.alibaba.sdk.android.httpdns.p112b.C1506c;
import com.alibaba.sdk.android.httpdns.p112b.C1508e;
import com.alibaba.sdk.android.httpdns.p112b.C1510g;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.alibaba.sdk.android.httpdns.e */
/* loaded from: classes.dex */
class C1517e {

    /* renamed from: a */
    private String f3914a;

    /* renamed from: b */
    private long f3915b;

    /* renamed from: b */
    private String f3916b;

    /* renamed from: c */
    private long f3917c;
    private String hostName;
    private String[] ips;

    C1517e(C1508e c1508e) {
        this.hostName = c1508e.host;
        this.f3917c = C1506c.m3443a(c1508e.f3862n);
        this.f3915b = -1000L;
        ArrayList<C1510g> arrayList = c1508e.f3857a;
        if (arrayList != null && arrayList.size() > 0) {
            int size = c1508e.f3857a.size();
            this.ips = new String[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.ips[i2] = c1508e.f3857a.get(i2).f3865o;
            }
        }
        if (C1528a.m3551a().m3554a()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList<C1510g> arrayList3 = c1508e.f3859b;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (int i3 = 0; i3 < c1508e.f3859b.size(); i3++) {
                    arrayList2.add(c1508e.f3859b.get(i3).f3865o);
                }
            }
            C1528a.m3551a().m3553a(this.hostName, arrayList2);
        }
        this.f3914a = c1508e.f3856a;
        this.f3916b = c1508e.f3858b;
    }

    C1517e(String str) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject(str);
        this.hostName = jSONObject.getString(Constants.KEY_HOST);
        try {
            if (jSONObject.has("ips")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("ips");
                int length = jSONArray2.length();
                this.ips = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    this.ips[i2] = jSONArray2.getString(i2);
                }
            }
            if (C1528a.m3551a().m3554a() && jSONObject.has("ipsv6") && (jSONArray = jSONObject.getJSONArray("ipsv6")) != null) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(jSONArray.getString(i3));
                }
                C1528a.m3551a().m3553a(this.hostName, arrayList);
            }
            if (jSONObject.has("extra")) {
                this.f3914a = jSONObject.getString("extra");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f3915b = jSONObject.getLong(RemoteMessageConst.TTL);
        this.f3917c = System.currentTimeMillis() / 1000;
    }

    C1517e(String str, String[] strArr, long j2, long j3, String str2, String str3) {
        this.hostName = str;
        this.ips = strArr;
        this.f3915b = j2;
        this.f3917c = j3;
        this.f3914a = str2;
        this.f3916b = str3;
    }

    /* renamed from: a */
    long m3509a() {
        return this.f3915b;
    }

    /* renamed from: a */
    C1508e m3510a() {
        List<String> m3552a;
        C1508e c1508e = new C1508e();
        c1508e.host = this.hostName;
        c1508e.f3862n = String.valueOf(this.f3917c);
        c1508e.f3861m = C1505b.m3442i();
        String[] strArr = this.ips;
        if (strArr != null && strArr.length > 0) {
            c1508e.f3857a = new ArrayList<>();
            for (String str : this.ips) {
                C1510g c1510g = new C1510g();
                c1510g.f3865o = str;
                c1510g.f3866p = String.valueOf(this.f3915b);
                c1508e.f3857a.add(c1510g);
            }
        }
        if (C1528a.m3551a().m3554a() && (m3552a = C1528a.m3551a().m3552a(this.hostName)) != null && m3552a.size() > 0) {
            c1508e.f3859b = new ArrayList<>();
            for (String str2 : m3552a) {
                C1510g c1510g2 = new C1510g();
                c1510g2.f3865o = str2;
                c1510g2.f3866p = String.valueOf(this.f3915b);
                c1508e.f3859b.add(c1510g2);
            }
        }
        c1508e.f3856a = this.f3914a;
        c1508e.f3858b = this.f3916b;
        return c1508e;
    }

    /* renamed from: a */
    String m3511a() {
        return this.f3914a;
    }

    /* renamed from: a */
    Map<String, String> m3512a() {
        HashMap hashMap = new HashMap();
        String str = this.f3914a;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(Html.fromHtml(Html.fromHtml(str).toString()).toString());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.get(next) == null ? null : jSONObject.get(next).toString());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hashMap;
    }

    /* renamed from: b */
    long m3513b() {
        return this.f3917c;
    }

    /* renamed from: b */
    boolean m3514b() {
        return m3513b() + m3509a() < System.currentTimeMillis() / 1000 || m3515c();
    }

    /* renamed from: c */
    boolean m3515c() {
        return m3509a() == -1000;
    }

    String getCacheKey() {
        return this.f3916b;
    }

    String[] getIps() {
        return this.ips;
    }

    void setCacheKey(String str) {
        this.f3916b = str;
    }

    public String toString() {
        String str = "host: " + this.hostName + " ip cnt: " + this.ips.length + " ttl: " + this.f3915b;
        for (int i2 = 0; i2 < this.ips.length; i2++) {
            str = str + "\n ip: " + this.ips[i2];
        }
        return str;
    }
}
