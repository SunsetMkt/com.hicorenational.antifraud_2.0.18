package com.huawei.hms.framework.network.grs.p175g;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.h */
/* loaded from: classes.dex */
public class C2376h {
    /* renamed from: a */
    public static String m6954a(String str, String str2) {
        return !str.equals(str2) ? m6955b(str, str2) : str;
    }

    /* renamed from: b */
    private static String m6955b(String str, String str2) {
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str)) {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("services");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(jSONArray.getString(i2));
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            JSONArray jSONArray2 = new JSONObject(str2).getJSONArray("services");
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                hashSet.add(jSONArray2.getString(i3));
            }
        }
        if (hashSet.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            jSONArray3.put((String) it.next());
        }
        jSONObject.put("services", jSONArray3);
        return jSONObject.toString();
    }
}
