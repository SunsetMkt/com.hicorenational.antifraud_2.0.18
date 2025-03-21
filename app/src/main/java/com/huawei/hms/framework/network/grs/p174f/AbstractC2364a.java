package com.huawei.hms.framework.network.grs.p174f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.C2389a;
import com.huawei.hms.framework.network.grs.local.model.C2390b;
import com.huawei.hms.framework.network.grs.local.model.C2391c;
import com.huawei.hms.framework.network.grs.local.model.C2392d;
import com.huawei.hms.framework.network.grs.p173e.C2361a;
import com.huawei.hms.framework.network.grs.p178h.C2384c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.a */
/* loaded from: classes.dex */
public abstract class AbstractC2364a {

    /* renamed from: a */
    protected C2389a f7362a;

    /* renamed from: b */
    protected List<C2390b> f7363b;

    /* renamed from: c */
    protected boolean f7364c = false;

    /* renamed from: d */
    protected boolean f7365d = false;

    /* renamed from: e */
    protected Set<String> f7366e = new HashSet(16);

    /* renamed from: a */
    private Map<String, String> m6862a(List<C2390b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (C2390b c2390b : list) {
            if (c2390b.m6995a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), c2390b.m6998b());
            }
            if (c2390b.m6995a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), c2390b.m6998b());
            }
            if (c2390b.m6995a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), c2390b.m6998b());
            }
            if (c2390b.m6995a().contains(str)) {
                Logger.m6801v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, c2390b.m6998b());
            }
        }
        return concurrentHashMap;
    }

    /* renamed from: b */
    private int m6863b(String str, Context context) {
        if (m6864g(C2384c.m6980a(str, context)) != 0) {
            return -1;
        }
        Logger.m6800i("AbstractLocalManager", "load APP_CONFIG_FILE success{%s}.", str);
        return 0;
    }

    /* renamed from: g */
    private int m6864g(String str) {
        int mo6876c;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.f7365d && (mo6876c = mo6876c(str)) != 0) {
            return mo6876c;
        }
        int mo6873b = mo6873b(str);
        return mo6873b != 0 ? mo6873b : mo6880f(str);
    }

    /* renamed from: h */
    private int m6865h(String str) {
        List<C2390b> list;
        int m6878d;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return (!this.f7365d || !((list = this.f7363b) == null || list.isEmpty()) || (m6878d = m6878d(str)) == 0) ? m6879e(str) : m6878d;
    }

    /* renamed from: a */
    int m6866a(String str, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(GrsApp.getInstance().getBrand("/"));
        sb.append(str);
        return m6863b(sb.toString(), context) != 0 ? -1 : 0;
    }

    /* renamed from: a */
    public C2389a m6867a() {
        return this.f7362a;
    }

    /* renamed from: a */
    public String m6868a(Context context, C2361a c2361a, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        Map<String, String> m6871a = m6871a(context, c2361a, grsBaseInfo, str, z);
        if (m6871a != null) {
            return m6871a.get(str2);
        }
        Logger.m6805w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    /* renamed from: a */
    public String m6869a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("no_route_country".equals(str)) {
            return "no-country";
        }
        List<C2390b> list = this.f7363b;
        if (list != null && !list.isEmpty()) {
            for (C2390b c2390b : this.f7363b) {
                if (c2390b.m6995a().contains(str)) {
                    return c2390b.m6998b();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0075 A[Catch: JSONException -> 0x0091, LOOP:1: B:19:0x006f->B:21:0x0075, LOOP_END, TryCatch #0 {JSONException -> 0x0091, blocks: (B:7:0x0011, B:8:0x0019, B:10:0x001f, B:12:0x004a, B:14:0x0060, B:16:0x0067, B:19:0x006f, B:21:0x0075, B:23:0x0081, B:26:0x008a, B:31:0x0050, B:33:0x0056, B:34:0x005b), top: B:6:0x0011 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.huawei.hms.framework.network.grs.local.model.C2390b> m6870a(org.json.JSONArray r13) {
        /*
            r12 = this;
            java.lang.String r0 = "countries"
            java.lang.String r1 = "countriesOrAreas"
            java.lang.String r2 = "AbstractLocalManager"
            if (r13 == 0) goto Laa
            int r3 = r13.length()
            if (r3 != 0) goto L10
            goto Laa
        L10:
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: org.json.JSONException -> L91
            r5 = 16
            r4.<init>(r5)     // Catch: org.json.JSONException -> L91
            r6 = 0
        L19:
            int r7 = r13.length()     // Catch: org.json.JSONException -> L91
            if (r6 >= r7) goto L90
            org.json.JSONObject r7 = r13.getJSONObject(r6)     // Catch: org.json.JSONException -> L91
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch: org.json.JSONException -> L91
            r8.<init>()     // Catch: org.json.JSONException -> L91
            java.lang.String r9 = "id"
            java.lang.String r9 = r7.getString(r9)     // Catch: org.json.JSONException -> L91
            r8.m6999b(r9)     // Catch: org.json.JSONException -> L91
            java.lang.String r9 = "name"
            java.lang.String r9 = r7.getString(r9)     // Catch: org.json.JSONException -> L91
            r8.m7000c(r9)     // Catch: org.json.JSONException -> L91
            java.lang.String r9 = "description"
            java.lang.String r9 = r7.getString(r9)     // Catch: org.json.JSONException -> L91
            r8.m6996a(r9)     // Catch: org.json.JSONException -> L91
            r9 = 0
            boolean r10 = r7.has(r1)     // Catch: org.json.JSONException -> L91
            if (r10 == 0) goto L50
            org.json.JSONArray r7 = r7.getJSONArray(r1)     // Catch: org.json.JSONException -> L91
        L4e:
            r9 = r7
            goto L60
        L50:
            boolean r10 = r7.has(r0)     // Catch: org.json.JSONException -> L91
            if (r10 == 0) goto L5b
            org.json.JSONArray r7 = r7.getJSONArray(r0)     // Catch: org.json.JSONException -> L91
            goto L4e
        L5b:
            java.lang.String r7 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.m6803w(r2, r7)     // Catch: org.json.JSONException -> L91
        L60:
            java.util.HashSet r7 = new java.util.HashSet     // Catch: org.json.JSONException -> L91
            r7.<init>(r5)     // Catch: org.json.JSONException -> L91
            if (r9 == 0) goto L8a
            int r10 = r9.length()     // Catch: org.json.JSONException -> L91
            if (r10 != 0) goto L6e
            goto L8a
        L6e:
            r10 = 0
        L6f:
            int r11 = r9.length()     // Catch: org.json.JSONException -> L91
            if (r10 >= r11) goto L81
            java.lang.Object r11 = r9.get(r10)     // Catch: org.json.JSONException -> L91
            java.lang.String r11 = (java.lang.String) r11     // Catch: org.json.JSONException -> L91
            r7.add(r11)     // Catch: org.json.JSONException -> L91
            int r10 = r10 + 1
            goto L6f
        L81:
            r8.m6997a(r7)     // Catch: org.json.JSONException -> L91
            r4.add(r8)     // Catch: org.json.JSONException -> L91
            int r6 = r6 + 1
            goto L19
        L8a:
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch: org.json.JSONException -> L91
            r13.<init>()     // Catch: org.json.JSONException -> L91
            return r13
        L90:
            return r4
        L91:
            r13 = move-exception
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r13 = r13.getMessage()
            java.lang.String r13 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r13)
            r0[r3] = r13
            java.lang.String r13 = "parse countrygroup failed maybe json style is wrong. %s"
            com.huawei.hms.framework.common.Logger.m6805w(r2, r13, r0)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        Laa:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p174f.AbstractC2364a.m6870a(org.json.JSONArray):java.util.List");
    }

    /* renamed from: a */
    public Map<String, String> m6871a(Context context, C2361a c2361a, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        C2389a c2389a = this.f7362a;
        if (c2389a == null) {
            Logger.m6803w("AbstractLocalManager", "application data is null.");
            return null;
        }
        C2391c m6990a = c2389a.m6990a(str);
        if (m6990a == null) {
            Logger.m6805w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String m6890b = C2368e.m6890b(context, c2361a, m6990a.m7005b(), grsBaseInfo, z);
        if (m6890b == null) {
            Logger.m6805w("AbstractLocalManager", "country not found by routeby in local config{%s}", m6990a.m7005b());
            return null;
        }
        List<C2390b> m7002a = m6990a.m7002a();
        C2392d m7001a = m6990a.m7001a((m7002a == null || m7002a.size() == 0) ? m6869a(m6890b) : m6862a(m7002a, grsBaseInfo, m6890b).get(m6890b));
        if (m7001a == null) {
            return null;
        }
        return m7001a.m7008a();
    }

    /* renamed from: a */
    public void m6872a(Context context, List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : list) {
            Logger.m6794d("AbstractLocalManager", "getBatchLoadSdkSuccessFlag file:" + str);
            if (TextUtils.isEmpty(str) || !Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str)) {
                Logger.m6800i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, skipped.", str);
            } else {
                if (m6865h(C2384c.m6980a(GrsApp.getInstance().getBrand("/") + str, context)) == 0) {
                    Logger.m6800i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, sucess.", str);
                } else {
                    Logger.m6800i("AbstractLocalManager", "load SDK_CONFIG_FILE: %s, failure.", str);
                }
            }
        }
    }

    /* renamed from: b */
    public abstract int mo6873b(String str);

    /* renamed from: b */
    public Set<String> m6874b() {
        return this.f7366e;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void m6875b(org.json.JSONArray r15) {
        /*
            r14 = this;
            if (r15 == 0) goto Lf6
            int r0 = r15.length()
            if (r0 != 0) goto La
            goto Lf6
        La:
            r0 = 0
            r1 = 0
        Lc:
            int r2 = r15.length()
            if (r1 >= r2) goto Lf6
            org.json.JSONObject r2 = r15.getJSONObject(r1)
            com.huawei.hms.framework.network.grs.local.model.c r3 = new com.huawei.hms.framework.network.grs.local.model.c
            r3.<init>()
            java.lang.String r4 = "name"
            java.lang.String r4 = r2.getString(r4)
            r3.m7006b(r4)
            java.util.Set<java.lang.String> r5 = r14.f7366e
            boolean r5 = r5.contains(r4)
            if (r5 != 0) goto Lf2
            java.util.Set<java.lang.String> r5 = r14.f7366e
            r5.add(r4)
            boolean r5 = r14.f7365d
            if (r5 == 0) goto Lf2
            java.lang.String r5 = "routeBy"
            java.lang.String r5 = r2.getString(r5)
            r3.m7007c(r5)
            java.lang.String r5 = "servings"
            org.json.JSONArray r5 = r2.getJSONArray(r5)
            r6 = 0
        L45:
            int r7 = r5.length()
            java.lang.String r8 = "AbstractLocalManager"
            if (r6 >= r7) goto Lbf
            java.lang.Object r7 = r5.get(r6)
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            com.huawei.hms.framework.network.grs.local.model.d r9 = new com.huawei.hms.framework.network.grs.local.model.d
            r9.<init>()
            java.lang.String r10 = "countryOrAreaGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L65
        L60:
            java.lang.String r8 = r7.getString(r10)
            goto L7a
        L65:
            java.lang.String r10 = "countryGroup"
            boolean r11 = r7.has(r10)
            if (r11 == 0) goto L6e
            goto L60
        L6e:
            r10 = 1
            java.lang.Object[] r10 = new java.lang.Object[r10]
            r10[r0] = r4
            java.lang.String r11 = "maybe this service{%s} routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.m6802v(r8, r11, r10)
            java.lang.String r8 = "no-country"
        L7a:
            r9.m7009a(r8)
            java.lang.String r8 = "addresses"
            org.json.JSONObject r7 = r7.getJSONObject(r8)
            java.util.concurrent.ConcurrentHashMap r8 = new java.util.concurrent.ConcurrentHashMap
            r10 = 16
            r8.<init>(r10)
            java.util.Iterator r10 = r7.keys()
        L8e:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto Lb2
            java.lang.Object r11 = r10.next()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r12 = r7.getString(r11)
            boolean r13 = android.text.TextUtils.isEmpty(r11)
            if (r13 != 0) goto L8e
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 != 0) goto L8e
            java.lang.String r12 = r7.getString(r11)
            r8.put(r11, r12)
            goto L8e
        Lb2:
            r9.m7010a(r8)
            java.lang.String r7 = r9.m7011b()
            r3.m7003a(r7, r9)
            int r6 = r6 + 1
            goto L45
        Lbf:
            r5 = 0
            java.lang.String r6 = "countryOrAreaGroups"
            boolean r7 = r2.has(r6)
            if (r7 == 0) goto Ld1
        Lc8:
            org.json.JSONArray r2 = r2.getJSONArray(r6)
            java.util.List r5 = r14.m6870a(r2)
            goto Ldf
        Ld1:
            java.lang.String r6 = "countryGroups"
            boolean r7 = r2.has(r6)
            if (r7 == 0) goto Lda
            goto Lc8
        Lda:
            java.lang.String r2 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.m6799i(r8, r2)
        Ldf:
            r3.m7004a(r5)
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.f7362a
            if (r2 != 0) goto Led
            com.huawei.hms.framework.network.grs.local.model.a r2 = new com.huawei.hms.framework.network.grs.local.model.a
            r2.<init>()
            r14.f7362a = r2
        Led:
            com.huawei.hms.framework.network.grs.local.model.a r2 = r14.f7362a
            r2.m6993a(r4, r3)
        Lf2:
            int r1 = r1 + 1
            goto Lc
        Lf6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p174f.AbstractC2364a.m6875b(org.json.JSONArray):void");
    }

    /* renamed from: c */
    public abstract int mo6876c(String str);

    /* renamed from: c */
    public boolean m6877c() {
        return this.f7364c;
    }

    /* renamed from: d */
    public int m6878d(String str) {
        this.f7363b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.m6796e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONArray == null) {
                return -1;
            }
            this.f7363b.addAll(m6870a(jSONArray));
            return 0;
        } catch (JSONException e2) {
            Logger.m6805w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    /* renamed from: e */
    public int m6879e(String str) {
        try {
            m6875b(new JSONObject(str).getJSONArray("services"));
            return 0;
        } catch (JSONException e2) {
            Logger.m6805w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    /* renamed from: f */
    public abstract int mo6880f(String str);
}
