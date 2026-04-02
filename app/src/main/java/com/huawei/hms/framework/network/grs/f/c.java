package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    public c(Context context, boolean z) {
        this.f4623d = z;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.f4622c = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x006e A[Catch: JSONException -> 0x0088, LOOP:1: B:56:0x0068->B:58:0x006e, LOOP_END, TryCatch #0 {JSONException -> 0x0088, blocks: (B:39:0x0007, B:40:0x0012, B:42:0x0018, B:44:0x0043, B:50:0x0059, B:52:0x0060, B:56:0x0068, B:58:0x006e, B:59:0x007a, B:60:0x0081, B:46:0x0049, B:48:0x004f, B:49:0x0054), top: B:66:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        HashSet hashSet;
        int i2;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                bVar.b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString(CommonNetImpl.NAME));
                bVar.a(jSONObject2.getString("description"));
                JSONArray jSONArray2 = null;
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else {
                    if (!jSONObject2.has("countries")) {
                        Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                        hashSet = new HashSet(16);
                        if (jSONArray2 != null && jSONArray2.length() != 0) {
                            for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                                hashSet.add((String) jSONArray2.get(i2));
                            }
                            bVar.a(hashSet);
                            arrayList.add(bVar);
                        }
                        return new ArrayList();
                    }
                    jSONArray = jSONObject2.getJSONArray("countries");
                }
                jSONArray2 = jSONArray;
                hashSet = new HashSet(16);
                if (jSONArray2 != null) {
                    while (i2 < jSONArray2.length()) {
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e2) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return new ArrayList();
        }
    }

    public List<com.huawei.hms.framework.network.grs.local.model.b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int b(String str) {
        this.a = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString(CommonNetImpl.NAME);
            long j2 = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.a.b(string);
            this.a.a(j2);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e2) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public int c(String str) {
        this.f4621b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = null;
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONObject2 = jSONObject.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
            }
            if (jSONObject2 == null) {
                return -1;
            }
            if (jSONObject2.length() != 0) {
                this.f4621b.addAll(a(jSONObject2));
            }
            return 0;
        } catch (JSONException e2) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x010c A[Catch: JSONException -> 0x0120, TryCatch #0 {JSONException -> 0x0120, blocks: (B:70:0x000c, B:71:0x001d, B:73:0x0023, B:75:0x0039, B:77:0x0042, B:78:0x0056, B:80:0x005c, B:82:0x006d, B:89:0x0086, B:90:0x009c, B:92:0x00a2, B:94:0x00b6, B:96:0x00bc, B:98:0x00cd, B:83:0x0072, B:85:0x0078, B:87:0x007f, B:99:0x00e1, B:101:0x00ec, B:105:0x00fb, B:107:0x0105, B:109:0x010c, B:110:0x0113, B:102:0x00f1, B:104:0x00f7, B:106:0x0100), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a2 A[Catch: JSONException -> 0x0120, TryCatch #0 {JSONException -> 0x0120, blocks: (B:70:0x000c, B:71:0x001d, B:73:0x0023, B:75:0x0039, B:77:0x0042, B:78:0x0056, B:80:0x005c, B:82:0x006d, B:89:0x0086, B:90:0x009c, B:92:0x00a2, B:94:0x00b6, B:96:0x00bc, B:98:0x00cd, B:83:0x0072, B:85:0x0078, B:87:0x007f, B:99:0x00e1, B:101:0x00ec, B:105:0x00fb, B:107:0x0105, B:109:0x010c, B:110:0x0113, B:102:0x00f1, B:104:0x00f7, B:106:0x0100), top: B:117:0x000c }] */
    @Override // com.huawei.hms.framework.network.grs.f.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        Iterator<String> itKeys;
        String str3 = "countryGroup";
        String str4 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject("services");
            Iterator<String> itKeys2 = jSONObject2.keys();
            while (itKeys2.hasNext()) {
                String next = itKeys2.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.b(next);
                if (!this.f4624e.contains(next)) {
                    this.f4624e.add(next);
                    if (this.f4623d) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                        cVar.c(jSONObject3.getString("routeBy"));
                        JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject4 = (JSONObject) jSONArray.get(i2);
                            com.huawei.hms.framework.network.grs.local.model.d dVar = new com.huawei.hms.framework.network.grs.local.model.d();
                            if (jSONObject4.has(str4)) {
                                string = jSONObject4.getString(str4);
                            } else if (jSONObject4.has(str3)) {
                                string = jSONObject4.getString(str3);
                            } else {
                                Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                                str2 = "no-country";
                                dVar.a(str2);
                                JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                                String str5 = str3;
                                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                                itKeys = jSONObject5.keys();
                                while (itKeys.hasNext()) {
                                    Iterator<String> it = itKeys;
                                    String next2 = itKeys.next();
                                    String string2 = jSONObject5.getString(next2);
                                    if (TextUtils.isEmpty(next2) || TextUtils.isEmpty(string2)) {
                                        itKeys = it;
                                    } else {
                                        concurrentHashMap.put(next2, jSONObject5.getString(next2));
                                        itKeys = it;
                                        str4 = str4;
                                    }
                                }
                                dVar.a(concurrentHashMap);
                                cVar.a(dVar.b(), dVar);
                                i2++;
                                str3 = str5;
                                str4 = str4;
                            }
                            str2 = string;
                            dVar.a(str2);
                            JSONObject jSONObject52 = jSONObject4.getJSONObject("addresses");
                            String str52 = str3;
                            ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap(16);
                            itKeys = jSONObject52.keys();
                            while (itKeys.hasNext()) {
                            }
                            dVar.a(concurrentHashMap2);
                            cVar.a(dVar.b(), dVar);
                            i2++;
                            str3 = str52;
                            str4 = str4;
                        }
                        String str6 = str3;
                        String str7 = str4;
                        List<com.huawei.hms.framework.network.grs.local.model.b> listA = null;
                        if (jSONObject3.has("countryOrAreaGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                        } else if (jSONObject3.has("countryGroups")) {
                            jSONObject = jSONObject3.getJSONObject("countryGroups");
                        } else {
                            Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                            cVar.a(listA);
                            if (this.a == null) {
                                this.a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.a.a(next, cVar);
                            str3 = str6;
                            str4 = str7;
                        }
                        listA = a((JSONArray) null, jSONObject);
                        cVar.a(listA);
                        if (this.a == null) {
                        }
                        this.a.a(next, cVar);
                        str3 = str6;
                        str4 = str7;
                    }
                }
            }
            return 0;
        } catch (JSONException e2) {
            Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check! %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return -1;
        }
    }
}
