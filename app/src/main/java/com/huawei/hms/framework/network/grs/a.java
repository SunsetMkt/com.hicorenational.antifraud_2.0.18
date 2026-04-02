package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e */
    private static final String f4586e = "a";
    private final GrsBaseInfo a;

    /* JADX INFO: renamed from: b */
    private com.huawei.hms.framework.network.grs.e.a f4587b;

    /* JADX INFO: renamed from: c */
    private g f4588c;

    /* JADX INFO: renamed from: d */
    private com.huawei.hms.framework.network.grs.e.c f4589d;

    /* JADX INFO: renamed from: com.huawei.hms.framework.network.grs.a$a */
    private static class C0093a implements com.huawei.hms.framework.network.grs.b {
        String a;

        /* JADX INFO: renamed from: b */
        Map<String, String> f4590b;

        /* JADX INFO: renamed from: c */
        IQueryUrlsCallBack f4591c;

        /* JADX INFO: renamed from: d */
        Context f4592d;

        /* JADX INFO: renamed from: e */
        GrsBaseInfo f4593e;

        /* JADX INFO: renamed from: f */
        com.huawei.hms.framework.network.grs.e.a f4594f;

        C0093a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.a = str;
            this.f4590b = map;
            this.f4591c = iQueryUrlsCallBack;
            this.f4592d = context;
            this.f4593e = grsBaseInfo;
            this.f4594f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.f4590b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.a, StringUtils.anonymizeMessage(new JSONObject(this.f4590b).toString()));
                this.f4591c.onCallBackSuccess(this.f4590b);
                return;
            }
            if (this.f4590b != null) {
                Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls\uff1aReturn [%s] Urls is Empty", this.a);
                this.f4591c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> mapA = com.huawei.hms.framework.network.grs.f.b.a(this.f4592d.getPackageName()).a(this.f4592d, this.f4594f, this.f4593e, this.a, true);
            if (mapA == null || mapA.isEmpty()) {
                Logger.e(a.f4586e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.a);
            }
            if (mapA == null) {
                mapA = new ConcurrentHashMap<>();
            }
            Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.a, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            this.f4591c.onCallBackSuccess(mapA);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String strJ = dVar.j();
            Map<String, String> mapA = a.a(strJ, this.a);
            if (mapA.isEmpty()) {
                Map<String, String> map = this.f4590b;
                if (map == null || map.isEmpty()) {
                    if (this.f4590b != null) {
                        Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls\uff1aReturn [%s] Urls is Empty", this.a);
                        this.f4591c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(strJ)) {
                        Logger.e(a.f4586e, "The serviceName[%s] is not configured on the GRS server.", this.a);
                    }
                    Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                    Map<String, String> mapA2 = com.huawei.hms.framework.network.grs.f.b.a(this.f4592d.getPackageName()).a(this.f4592d, this.f4594f, this.f4593e, this.a, true);
                    if (mapA2 == null || mapA2.isEmpty()) {
                        Logger.e(a.f4586e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.a);
                    }
                    if (mapA2 == null) {
                        mapA2 = new ConcurrentHashMap<>();
                    }
                    Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.a, StringUtils.anonymizeMessage(new JSONObject(mapA2).toString()));
                    this.f4591c.onCallBackSuccess(mapA2);
                    return;
                }
                Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.a, StringUtils.anonymizeMessage(new JSONObject(this.f4590b).toString()));
                iQueryUrlsCallBack = this.f4591c;
                mapA = this.f4590b;
            } else {
                Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.a, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
                iQueryUrlsCallBack = this.f4591c;
            }
            iQueryUrlsCallBack.onCallBackSuccess(mapA);
        }
    }

    private static class b implements com.huawei.hms.framework.network.grs.b {
        String a;

        /* JADX INFO: renamed from: b */
        String f4595b;

        /* JADX INFO: renamed from: c */
        IQueryUrlCallBack f4596c;

        /* JADX INFO: renamed from: d */
        String f4597d;

        /* JADX INFO: renamed from: e */
        Context f4598e;

        /* JADX INFO: renamed from: f */
        GrsBaseInfo f4599f;

        /* JADX INFO: renamed from: g */
        com.huawei.hms.framework.network.grs.e.a f4600g;

        b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.a = str;
            this.f4595b = str2;
            this.f4596c = iQueryUrlCallBack;
            this.f4597d = str3;
            this.f4598e = context;
            this.f4599f = grsBaseInfo;
            this.f4600g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.f4597d)) {
                Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.a, this.f4595b, StringUtils.anonymizeMessage(this.f4597d));
                this.f4596c.onCallBackSuccess(this.f4597d);
                return;
            }
            if (!TextUtils.isEmpty(this.f4597d)) {
                Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrl\uff1aReturn [%s][%s] Url is Empty", this.a, this.f4595b);
                this.f4596c.onCallBackFail(-3);
                return;
            }
            Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String strA = com.huawei.hms.framework.network.grs.f.b.a(this.f4598e.getPackageName()).a(this.f4598e, this.f4600g, this.f4599f, this.a, this.f4595b, true);
            if (strA == null || strA.isEmpty()) {
                Logger.e(a.f4586e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.a, this.f4595b);
            }
            Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.a, this.f4595b, StringUtils.anonymizeMessage(strA));
            this.f4596c.onCallBackSuccess(strA);
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String strJ = dVar.j();
            Map<String, String> mapA = a.a(strJ, this.a);
            if (mapA.containsKey(this.f4595b)) {
                String str2 = a.f4586e;
                String str3 = this.f4595b;
                Logger.i(str2, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", this.a, str3, StringUtils.anonymizeMessage(mapA.get(str3)));
                iQueryUrlCallBack = this.f4596c;
                str = mapA.get(this.f4595b);
            } else {
                if (TextUtils.isEmpty(this.f4597d)) {
                    if (!TextUtils.isEmpty(this.f4597d)) {
                        Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrl\uff1aReturn [%s][%s] Url is Empty", this.a, this.f4595b);
                        this.f4596c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(strJ)) {
                        Logger.e(a.f4586e, "The serviceName[%s][%s] is not configured on the GRS server.", this.a, this.f4595b);
                    }
                    Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                    String strA = com.huawei.hms.framework.network.grs.f.b.a(this.f4598e.getPackageName()).a(this.f4598e, this.f4600g, this.f4599f, this.a, this.f4595b, true);
                    if (strA == null || strA.isEmpty()) {
                        Logger.e(a.f4586e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.a, this.f4595b);
                    }
                    Logger.i(a.f4586e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.a, this.f4595b, StringUtils.anonymizeMessage(strA));
                    this.f4596c.onCallBackSuccess(strA);
                    return;
                }
                String str4 = a.f4586e;
                String str5 = this.f4595b;
                Logger.i(str4, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.a, str5, StringUtils.anonymizeMessage(mapA.get(str5)));
                iQueryUrlCallBack = this.f4596c;
                str = this.f4597d;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, g gVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.a = grsBaseInfo;
        this.f4587b = aVar;
        this.f4588c = gVar;
        this.f4589d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    public static Map<String, Map<String, String>> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f4586e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(f4586e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> mapA = this.f4587b.a(this.a, str, bVar, context);
        if (mapA != null && !mapA.isEmpty()) {
            Logger.i(f4586e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return mapA;
        }
        Map<String, String> mapA2 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f4587b, this.a, str, false);
        Logger.i(f4586e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return mapA2 != null ? mapA2 : new HashMap();
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f4586e, "isSpExpire jsonValue from server is null.");
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f4586e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return map;
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject2.get(next).toString());
            }
            return map;
        } catch (JSONException e2) {
            Logger.w(f4586e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return map;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                    concurrentHashMap.put(next, string);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(f4586e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    public String a(Context context, String str, int i2) {
        com.huawei.hms.framework.network.grs.g.d dVarA = this.f4588c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.a, context), str, this.f4589d, i2);
        return dVarA == null ? "" : dVarA.m() ? this.f4587b.a().a(this.a.getGrsParasKey(true, true, context), "") : dVarA.j();
    }

    public String a(String str, String str2, Context context, int i2) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String strA = a(str, bVar, context).get(str2);
        if (bVar.a() && !TextUtils.isEmpty(strA)) {
            Logger.i(f4586e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(strA));
            return strA;
        }
        String strA2 = a(context, str, i2);
        String str3 = a(strA2, str).get(str2);
        if (!TextUtils.isEmpty(str3)) {
            Logger.i(f4586e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            return str3;
        }
        if (TextUtils.isEmpty(strA)) {
            if (!TextUtils.isEmpty(strA2)) {
                Logger.e(f4586e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            Logger.i(f4586e, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            strA = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f4587b, this.a, str, str2, true);
            if (strA == null || strA.isEmpty()) {
                Logger.e(f4586e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str, str2);
            }
        }
        Logger.i(f4586e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(strA));
        return strA;
    }

    public Map<String, String> a(String str, Context context, int i2) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> mapA = a(str, bVar, context);
        if (bVar.a() && !mapA.isEmpty()) {
            Logger.i(f4586e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            return mapA;
        }
        String strA = a(context, str, i2);
        Map<String, String> mapA2 = a(strA, str);
        if (!mapA2.isEmpty()) {
            Logger.i(f4586e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA2).toString()));
            return mapA2;
        }
        if (mapA.isEmpty()) {
            if (!TextUtils.isEmpty(strA)) {
                Logger.e(f4586e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            Logger.i(f4586e, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            mapA = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName()).a(context, this.f4587b, this.a, str, true);
            if (mapA == null || mapA.isEmpty()) {
                Logger.e(f4586e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
            }
        }
        String str2 = f4586e;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = StringUtils.anonymizeMessage(mapA != null ? new JSONObject(mapA).toString() : "");
        Logger.i(str2, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
        return mapA;
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i2) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> mapA = a(str, bVar, context);
        if (!bVar.a()) {
            this.f4588c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.a, context), new C0093a(str, mapA, iQueryUrlsCallBack, context, this.a, this.f4587b), str, this.f4589d, i2);
            return;
        }
        if (mapA.isEmpty()) {
            Logger.i(f4586e, "GrsClientManager.ayncGetGrsUrls\uff1aReturn [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            Logger.i(f4586e, "GrsClientManager.ayncGetGrsUrls\uff1aReturn [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            Logger.i(f4586e, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(mapA).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(mapA);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i2) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (!bVar.a()) {
            this.f4588c.a(new com.huawei.hms.framework.network.grs.g.j.c(this.a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.a, this.f4587b), str, this.f4589d, i2);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.i(f4586e, "GrsClientManager.ayncGetGrsUrl\uff1aReturn [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.i(f4586e, "GrsClientManager.ayncGetGrsUrl\uff1aReturn [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
