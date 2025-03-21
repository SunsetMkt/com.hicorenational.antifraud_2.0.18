package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.huawei.hms.hatool.c1 */
/* loaded from: classes.dex */
public class C2402c1 {
    /* renamed from: a */
    public static Map<String, List<C2399b1>> m7061a(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> m7070a = C2403d.m7070a(context, str);
        m7067b(m7070a);
        return m7063a(m7070a);
    }

    /* renamed from: a */
    public static Map<String, List<C2399b1>> m7062a(Context context, String str, String str2) {
        Map<String, List<C2399b1>> m7061a;
        Map<String, List<C2399b1>> m7061a2;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            C2452v.m7385c("hmsSdk", "read all event records");
            m7061a = m7061a(context, "stat_v2_1");
            m7061a2 = m7061a(context, "cached_v2_1");
        } else {
            String m7253a = AbstractC2435n1.m7253a(str, str2);
            m7061a = m7066b(context, "stat_v2_1", m7253a);
            m7061a2 = m7066b(context, "cached_v2_1", m7253a);
        }
        return m7064a(m7061a, m7061a2);
    }

    /* renamed from: a */
    private static Map<String, List<C2399b1>> m7063a(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                m7065a(key, (String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    private static Map<String, List<C2399b1>> m7064a(Map<String, List<C2399b1>> map, Map<String, List<C2399b1>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map2);
        return hashMap;
    }

    /* renamed from: a */
    private static void m7065a(String str, String str2, Map<String, List<C2399b1>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                C2399b1 c2399b1 = new C2399b1();
                try {
                    c2399b1.m7046a(jSONArray.getJSONObject(i2));
                    arrayList.add(c2399b1);
                } catch (JSONException unused) {
                    C2452v.m7389e("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
            }
            map.put(str, arrayList);
        } catch (JSONException unused2) {
            C2452v.m7389e("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    /* renamed from: b */
    public static Map<String, List<C2399b1>> m7066b(Context context, String str, String str2) {
        String m7069a = C2403d.m7069a(context, str, str2, "");
        HashMap hashMap = new HashMap();
        m7065a(str2, m7069a, hashMap);
        return hashMap;
    }

    /* renamed from: b */
    private static void m7067b(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> m7255a = AbstractC2435n1.m7255a(AbstractC2443q0.m7297b());
        while (it.hasNext()) {
            if (!m7255a.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }
}
