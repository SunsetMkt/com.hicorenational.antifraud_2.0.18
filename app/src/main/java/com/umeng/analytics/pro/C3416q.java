package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMRTLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DataSpliter.java */
/* renamed from: com.umeng.analytics.pro.q */
/* loaded from: classes2.dex */
public class C3416q {
    /* renamed from: a */
    public static JSONObject m11364a(Context context, long j2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (!jSONObject.has("content")) {
                return jSONObject2;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("content");
            if (jSONObject3.has("analytics")) {
                JSONObject jSONObject4 = jSONObject3.getJSONObject("analytics");
                if (jSONObject4.has("ekv")) {
                    jSONObject4.remove("ekv");
                }
                if (jSONObject4.has(C3397d.f11894T)) {
                    jSONObject4.remove(C3397d.f11894T);
                }
                if (jSONObject4.has("error")) {
                    jSONObject4.remove("error");
                }
                jSONObject3.put("analytics", jSONObject4);
            }
            jSONObject2.put("content", jSONObject3);
            if (jSONObject.has("header")) {
                jSONObject2.put("header", jSONObject.getJSONObject("header"));
            }
            if (m11363a(jSONObject2) <= j2) {
                return jSONObject2;
            }
            jSONObject2 = null;
            C3408i.m11232a(context).m11264i();
            C3408i.m11232a(context).m11263h();
            C3408i.m11232a(context).m11255b(true, false);
            C3408i.m11232a(context).m11246a();
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> u-app packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    /* renamed from: a */
    public static long m11363a(JSONObject jSONObject) {
        return jSONObject.toString().getBytes().length;
    }

    /* renamed from: a */
    public static long m11362a(JSONArray jSONArray) {
        return jSONArray.toString().getBytes().length;
    }
}
