package com.huawei.hms.framework.network.grs.p174f;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.C2389a;
import com.huawei.hms.framework.network.grs.local.model.C2390b;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.f.c */
/* loaded from: classes.dex */
public class C2366c extends AbstractC2364a {
    public C2366c(Context context, boolean z) {
        this.f7365d = z;
        if (m6866a("grs_sdk_global_route_config.json", context) == 0) {
            this.f7364c = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[Catch: JSONException -> 0x0088, LOOP:1: B:15:0x0068->B:17:0x006e, LOOP_END, TryCatch #0 {JSONException -> 0x0088, blocks: (B:3:0x0007, B:4:0x0012, B:6:0x0018, B:8:0x0043, B:10:0x0059, B:12:0x0060, B:15:0x0068, B:17:0x006e, B:19:0x007a, B:22:0x0081, B:27:0x0049, B:29:0x004f, B:30:0x0054), top: B:2:0x0007 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.huawei.hms.framework.network.grs.local.model.C2390b> m6887a(org.json.JSONObject r13) {
        /*
            r12 = this;
            java.lang.String r0 = "countries"
            java.lang.String r1 = "countriesOrAreas"
            java.lang.String r2 = "LocalManagerV1"
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: org.json.JSONException -> L88
            r5 = 16
            r4.<init>(r5)     // Catch: org.json.JSONException -> L88
            java.util.Iterator r6 = r13.keys()     // Catch: org.json.JSONException -> L88
        L12:
            boolean r7 = r6.hasNext()     // Catch: org.json.JSONException -> L88
            if (r7 == 0) goto L87
            java.lang.Object r7 = r6.next()     // Catch: org.json.JSONException -> L88
            java.lang.String r7 = (java.lang.String) r7     // Catch: org.json.JSONException -> L88
            com.huawei.hms.framework.network.grs.local.model.b r8 = new com.huawei.hms.framework.network.grs.local.model.b     // Catch: org.json.JSONException -> L88
            r8.<init>()     // Catch: org.json.JSONException -> L88
            r8.m6999b(r7)     // Catch: org.json.JSONException -> L88
            org.json.JSONObject r7 = r13.getJSONObject(r7)     // Catch: org.json.JSONException -> L88
            java.lang.String r9 = "name"
            java.lang.String r9 = r7.getString(r9)     // Catch: org.json.JSONException -> L88
            r8.m7000c(r9)     // Catch: org.json.JSONException -> L88
            java.lang.String r9 = "description"
            java.lang.String r9 = r7.getString(r9)     // Catch: org.json.JSONException -> L88
            r8.m6996a(r9)     // Catch: org.json.JSONException -> L88
            r9 = 0
            boolean r10 = r7.has(r1)     // Catch: org.json.JSONException -> L88
            if (r10 == 0) goto L49
            org.json.JSONArray r7 = r7.getJSONArray(r1)     // Catch: org.json.JSONException -> L88
        L47:
            r9 = r7
            goto L59
        L49:
            boolean r10 = r7.has(r0)     // Catch: org.json.JSONException -> L88
            if (r10 == 0) goto L54
            org.json.JSONArray r7 = r7.getJSONArray(r0)     // Catch: org.json.JSONException -> L88
            goto L47
        L54:
            java.lang.String r7 = "current country or area group has not config countries or areas."
            com.huawei.hms.framework.common.Logger.m6803w(r2, r7)     // Catch: org.json.JSONException -> L88
        L59:
            java.util.HashSet r7 = new java.util.HashSet     // Catch: org.json.JSONException -> L88
            r7.<init>(r5)     // Catch: org.json.JSONException -> L88
            if (r9 == 0) goto L81
            int r10 = r9.length()     // Catch: org.json.JSONException -> L88
            if (r10 != 0) goto L67
            goto L81
        L67:
            r10 = 0
        L68:
            int r11 = r9.length()     // Catch: org.json.JSONException -> L88
            if (r10 >= r11) goto L7a
            java.lang.Object r11 = r9.get(r10)     // Catch: org.json.JSONException -> L88
            java.lang.String r11 = (java.lang.String) r11     // Catch: org.json.JSONException -> L88
            r7.add(r11)     // Catch: org.json.JSONException -> L88
            int r10 = r10 + 1
            goto L68
        L7a:
            r8.m6997a(r7)     // Catch: org.json.JSONException -> L88
            r4.add(r8)     // Catch: org.json.JSONException -> L88
            goto L12
        L81:
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch: org.json.JSONException -> L88
            r13.<init>()     // Catch: org.json.JSONException -> L88
            return r13
        L87:
            return r4
        L88:
            r13 = move-exception
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r13 = r13.getMessage()
            java.lang.String r13 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r13)
            r0[r3] = r13
            java.lang.String r13 = "parse countryGroups failed maybe json style is wrong. %s"
            com.huawei.hms.framework.common.Logger.m6805w(r2, r13, r0)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p174f.C2366c.m6887a(org.json.JSONObject):java.util.List");
    }

    /* renamed from: a */
    public List<C2390b> m6888a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : m6887a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.p174f.AbstractC2364a
    /* renamed from: b */
    public int mo6873b(String str) {
        this.f7362a = new C2389a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString(CommonNetImpl.NAME);
            long j2 = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f7362a.m6994b(string);
            this.f7362a.m6992a(j2);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e2) {
            Logger.m6805w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.p174f.AbstractC2364a
    /* renamed from: c */
    public int mo6876c(String str) {
        this.f7363b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryGroups");
            } else {
                Logger.m6796e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONObject2 == null) {
                return -1;
            }
            if (jSONObject2.length() != 0) {
                this.f7363b.addAll(m6887a(jSONObject2));
            }
            return 0;
        } catch (JSONException e2) {
            Logger.m6805w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2 A[Catch: JSONException -> 0x0120, TryCatch #0 {JSONException -> 0x0120, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:9:0x0039, B:12:0x0042, B:13:0x0056, B:15:0x005c, B:17:0x006d, B:19:0x0086, B:20:0x009c, B:22:0x00a2, B:24:0x00b6, B:31:0x00bc, B:35:0x00cd, B:36:0x0072, B:38:0x0078, B:39:0x007f, B:42:0x00e1, B:44:0x00ec, B:45:0x00fb, B:46:0x0105, B:48:0x010c, B:49:0x0113, B:53:0x00f1, B:55:0x00f7, B:56:0x0100), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c A[Catch: JSONException -> 0x0120, TryCatch #0 {JSONException -> 0x0120, blocks: (B:3:0x000c, B:4:0x001d, B:6:0x0023, B:9:0x0039, B:12:0x0042, B:13:0x0056, B:15:0x005c, B:17:0x006d, B:19:0x0086, B:20:0x009c, B:22:0x00a2, B:24:0x00b6, B:31:0x00bc, B:35:0x00cd, B:36:0x0072, B:38:0x0078, B:39:0x007f, B:42:0x00e1, B:44:0x00ec, B:45:0x00fb, B:46:0x0105, B:48:0x010c, B:49:0x0113, B:53:0x00f1, B:55:0x00f7, B:56:0x0100), top: B:2:0x000c }] */
    @Override // com.huawei.hms.framework.network.grs.p174f.AbstractC2364a
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int mo6880f(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.p174f.C2366c.mo6880f(java.lang.String):int");
    }
}
