package com.huawei.hms.framework.network.grs.p175g.p177j;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p174f.C2365b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.j.c */
/* loaded from: classes.dex */
public class C2380c {

    /* renamed from: a */
    private final GrsBaseInfo f7433a;

    /* renamed from: b */
    private final Context f7434b;

    /* renamed from: c */
    private final Set<String> f7435c = new HashSet();

    public C2380c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f7433a = grsBaseInfo;
        this.f7434b = context;
    }

    /* renamed from: e */
    private String m6959e() {
        Set<String> m6886b = C2365b.m6881a(this.f7434b.getPackageName()).m6886b();
        if (m6886b.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = m6886b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.m6800i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: f */
    private String m6960f() {
        Logger.m6801v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f7435c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.m6802v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public Context m6961a() {
        return this.f7434b;
    }

    /* renamed from: a */
    public void m6962a(String str) {
        this.f7435c.add(str);
    }

    /* renamed from: b */
    public GrsBaseInfo m6963b() {
        return this.f7433a;
    }

    /* renamed from: c */
    public String m6964c() {
        return this.f7435c.size() == 0 ? m6959e() : m6960f();
    }

    /* renamed from: d */
    public Set<String> m6965d() {
        return this.f7435c;
    }
}
