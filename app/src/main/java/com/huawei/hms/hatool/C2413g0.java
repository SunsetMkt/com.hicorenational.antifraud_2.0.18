package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.g0 */
/* loaded from: classes.dex */
public final class C2413g0 {

    /* renamed from: c */
    private static C2413g0 f7503c;

    /* renamed from: a */
    private Context f7504a;

    /* renamed from: b */
    private final Object f7505b = new Object();

    private C2413g0() {
    }

    /* renamed from: a */
    public static C2413g0 m7107a() {
        if (f7503c == null) {
            m7109b();
        }
        return f7503c;
    }

    /* renamed from: a */
    private JSONObject m7108a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                C2452v.m7382b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    /* renamed from: b */
    private static synchronized void m7109b() {
        synchronized (C2413g0.class) {
            if (f7503c == null) {
                f7503c = new C2413g0();
            }
        }
    }

    /* renamed from: a */
    public void m7110a(Context context) {
        synchronized (this.f7505b) {
            if (this.f7504a != null) {
                return;
            }
            this.f7504a = context;
            C2406e.m7077a().m7080a(context);
        }
    }

    /* renamed from: a */
    public void m7111a(String str, int i2) {
        C2406e.m7077a().m7081a(str, i2);
    }

    /* renamed from: a */
    public void m7112a(String str, int i2, String str2, LinkedHashMap<String, String> linkedHashMap) {
        C2406e.m7077a().m7082a(str, i2, str2, m7108a(linkedHashMap));
    }

    /* renamed from: a */
    public void m7113a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            C2406e.m7077a().m7082a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            C2452v.m7390f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    /* renamed from: b */
    public void m7114b(String str, int i2, String str2, LinkedHashMap<String, String> linkedHashMap) {
        C2406e.m7077a().m7083a(str, i2, str2, m7108a(linkedHashMap), System.currentTimeMillis());
    }
}
