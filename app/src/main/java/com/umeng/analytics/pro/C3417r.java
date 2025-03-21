package com.umeng.analytics.pro;

import android.content.Context;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefconProcesser.java */
/* renamed from: com.umeng.analytics.pro.r */
/* loaded from: classes2.dex */
public class C3417r {

    /* renamed from: a */
    private static final int f12236a = 0;

    /* renamed from: b */
    private static final int f12237b = 1;

    /* renamed from: c */
    private static final int f12238c = 2;

    /* renamed from: d */
    private static final int f12239d = 3;

    /* renamed from: e */
    private final long f12240e;

    /* compiled from: DefconProcesser.java */
    /* renamed from: com.umeng.analytics.pro.r$a */
    private static class a {

        /* renamed from: a */
        public static final C3417r f12241a = new C3417r();

        private a() {
        }
    }

    /* renamed from: a */
    public static C3417r m11365a() {
        return a.f12241a;
    }

    /* renamed from: c */
    private JSONArray m11368c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", C3424y.m11419a().m11434d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(C3397d.f11950p, currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    /* renamed from: b */
    public void m11371b(JSONObject jSONObject, Context context) {
        int m11369a = m11369a(context);
        if (m11369a == 1) {
            if (jSONObject.has(C3397d.f11886L)) {
                jSONObject.remove(C3397d.f11886L);
            }
            if (jSONObject.has(C3397d.f11948n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(C3397d.f11948n);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2.has(C3397d.f11930au)) {
                            jSONObject2.remove(C3397d.f11930au);
                        }
                        if (jSONObject2.has(C3397d.f11931av)) {
                            jSONObject2.remove(C3397d.f11931av);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            C3408i.m11232a(context).m11249a(false, true);
            return;
        }
        if (m11369a == 2) {
            if (jSONObject.has(C3397d.f11886L)) {
                jSONObject.remove(C3397d.f11886L);
            }
            if (jSONObject.has(C3397d.f11948n)) {
                jSONObject.remove(C3397d.f11948n);
            }
            try {
                jSONObject.put(C3397d.f11948n, m11368c());
            } catch (Exception unused2) {
            }
            C3408i.m11232a(context).m11249a(false, true);
            return;
        }
        if (m11369a == 3) {
            if (jSONObject.has(C3397d.f11886L)) {
                jSONObject.remove(C3397d.f11886L);
            }
            jSONObject.remove(C3397d.f11948n);
            C3408i.m11232a(context).m11249a(false, true);
        }
    }

    private C3417r() {
        this.f12240e = C2084a.f6122d;
    }

    /* renamed from: a */
    public int m11369a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    /* renamed from: a */
    private void m11366a(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(C3397d.f11948n)) {
            jSONObject.remove(C3397d.f11948n);
        }
        if (jSONObject.has(C3397d.f11886L)) {
            jSONObject.remove(C3397d.f11886L);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(C3397d.f11894T)) {
            jSONObject.remove(C3397d.f11894T);
        }
        if (jSONObject.has(C3397d.f11886L)) {
            jSONObject.remove(C3397d.f11886L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    /* renamed from: a */
    public void m11370a(JSONObject jSONObject, Context context) {
        int m11369a = m11369a(context);
        if (m11369a == 1) {
            m11366a(jSONObject, true);
            C3408i.m11232a(context).m11255b(false, true);
        } else {
            if (m11369a == 2) {
                jSONObject.remove(C3397d.f11948n);
                try {
                    jSONObject.put(C3397d.f11948n, m11367b());
                } catch (Exception unused) {
                }
                m11366a(jSONObject, true);
                C3408i.m11232a(context).m11255b(false, true);
                return;
            }
            if (m11369a == 3) {
                m11366a(jSONObject, false);
                C3408i.m11232a(context).m11255b(false, true);
            }
        }
    }

    /* renamed from: b */
    private JSONArray m11367b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", C3424y.m11419a().m11426a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(C3397d.f11950p, currentTimeMillis);
            jSONObject.put(C3397d.f11951q, currentTimeMillis + C2084a.f6122d);
            jSONObject.put("duration", C2084a.f6122d);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}
