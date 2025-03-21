package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import com.huawei.hms.framework.network.grs.p173e.C2361a;
import com.huawei.hms.framework.network.grs.p173e.C2362b;
import com.huawei.hms.framework.network.grs.p173e.C2363c;
import com.huawei.hms.framework.network.grs.p174f.C2365b;
import com.huawei.hms.framework.network.grs.p175g.C2372d;
import com.huawei.hms.framework.network.grs.p175g.C2375g;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2380c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.a */
/* loaded from: classes.dex */
public class C2357a {

    /* renamed from: e */
    private static final String f7318e = "a";

    /* renamed from: a */
    private final GrsBaseInfo f7319a;

    /* renamed from: b */
    private C2361a f7320b;

    /* renamed from: c */
    private C2375g f7321c;

    /* renamed from: d */
    private C2363c f7322d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a */
    private static class a implements InterfaceC2358b {

        /* renamed from: a */
        String f7323a;

        /* renamed from: b */
        Map<String, String> f7324b;

        /* renamed from: c */
        IQueryUrlsCallBack f7325c;

        /* renamed from: d */
        Context f7326d;

        /* renamed from: e */
        GrsBaseInfo f7327e;

        /* renamed from: f */
        C2361a f7328f;

        a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, C2361a c2361a) {
            this.f7323a = str;
            this.f7324b = map;
            this.f7325c = iQueryUrlsCallBack;
            this.f7326d = context;
            this.f7327e = grsBaseInfo;
            this.f7328f = c2361a;
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC2358b
        /* renamed from: a */
        public void mo6817a() {
            Map<String, String> map = this.f7324b;
            if (map != null && !map.isEmpty()) {
                Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f7323a, StringUtils.anonymizeMessage(new JSONObject(this.f7324b).toString()));
                this.f7325c.onCallBackSuccess(this.f7324b);
                return;
            }
            if (this.f7324b != null) {
                Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f7323a);
                this.f7325c.onCallBackFail(-3);
                return;
            }
            Logger.m6799i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
            Map<String, String> m6885a = C2365b.m6881a(this.f7326d.getPackageName()).m6885a(this.f7326d, this.f7328f, this.f7327e, this.f7323a, true);
            if (m6885a == null || m6885a.isEmpty()) {
                Logger.m6798e(C2357a.f7318e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f7323a);
            }
            if (m6885a == null) {
                m6885a = new ConcurrentHashMap<>();
            }
            Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f7323a, StringUtils.anonymizeMessage(new JSONObject(m6885a).toString()));
            this.f7325c.onCallBackSuccess(m6885a);
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC2358b
        /* renamed from: a */
        public void mo6818a(C2372d c2372d) {
            IQueryUrlsCallBack iQueryUrlsCallBack;
            String m6937j = c2372d.m6937j();
            Map<String, String> m6810a = C2357a.m6810a(m6937j, this.f7323a);
            if (m6810a.isEmpty()) {
                Map<String, String> map = this.f7324b;
                if (map == null || map.isEmpty()) {
                    if (this.f7324b != null) {
                        Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", this.f7323a);
                        this.f7325c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(m6937j)) {
                        Logger.m6798e(C2357a.f7318e, "The serviceName[%s] is not configured on the GRS server.", this.f7323a);
                    }
                    Logger.m6799i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls: Get URL from Local JSON File");
                    Map<String, String> m6885a = C2365b.m6881a(this.f7326d.getPackageName()).m6885a(this.f7326d, this.f7328f, this.f7327e, this.f7323a, true);
                    if (m6885a == null || m6885a.isEmpty()) {
                        Logger.m6798e(C2357a.f7318e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", this.f7323a);
                    }
                    if (m6885a == null) {
                        m6885a = new ConcurrentHashMap<>();
                    }
                    Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls: Return [%s] Urls: %s", this.f7323a, StringUtils.anonymizeMessage(new JSONObject(m6885a).toString()));
                    this.f7325c.onCallBackSuccess(m6885a);
                    return;
                }
                Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls: Return [%s][%s] Url: %s", this.f7323a, StringUtils.anonymizeMessage(new JSONObject(this.f7324b).toString()));
                iQueryUrlsCallBack = this.f7325c;
                m6810a = this.f7324b;
            } else {
                Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", this.f7323a, StringUtils.anonymizeMessage(new JSONObject(m6810a).toString()));
                iQueryUrlsCallBack = this.f7325c;
            }
            iQueryUrlsCallBack.onCallBackSuccess(m6810a);
        }
    }

    /* renamed from: com.huawei.hms.framework.network.grs.a$b */
    private static class b implements InterfaceC2358b {

        /* renamed from: a */
        String f7329a;

        /* renamed from: b */
        String f7330b;

        /* renamed from: c */
        IQueryUrlCallBack f7331c;

        /* renamed from: d */
        String f7332d;

        /* renamed from: e */
        Context f7333e;

        /* renamed from: f */
        GrsBaseInfo f7334f;

        /* renamed from: g */
        C2361a f7335g;

        b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, C2361a c2361a) {
            this.f7329a = str;
            this.f7330b = str2;
            this.f7331c = iQueryUrlCallBack;
            this.f7332d = str3;
            this.f7333e = context;
            this.f7334f = grsBaseInfo;
            this.f7335g = c2361a;
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC2358b
        /* renamed from: a */
        public void mo6817a() {
            if (!TextUtils.isEmpty(this.f7332d)) {
                Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f7329a, this.f7330b, StringUtils.anonymizeMessage(this.f7332d));
                this.f7331c.onCallBackSuccess(this.f7332d);
                return;
            }
            if (!TextUtils.isEmpty(this.f7332d)) {
                Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f7329a, this.f7330b);
                this.f7331c.onCallBackFail(-3);
                return;
            }
            Logger.m6799i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
            String m6884a = C2365b.m6881a(this.f7333e.getPackageName()).m6884a(this.f7333e, this.f7335g, this.f7334f, this.f7329a, this.f7330b, true);
            if (m6884a == null || m6884a.isEmpty()) {
                Logger.m6798e(C2357a.f7318e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f7329a, this.f7330b);
            }
            Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f7329a, this.f7330b, StringUtils.anonymizeMessage(m6884a));
            this.f7331c.onCallBackSuccess(m6884a);
        }

        @Override // com.huawei.hms.framework.network.grs.InterfaceC2358b
        /* renamed from: a */
        public void mo6818a(C2372d c2372d) {
            IQueryUrlCallBack iQueryUrlCallBack;
            String str;
            String m6937j = c2372d.m6937j();
            Map<String, String> m6810a = C2357a.m6810a(m6937j, this.f7329a);
            if (m6810a.containsKey(this.f7330b)) {
                String str2 = C2357a.f7318e;
                String str3 = this.f7330b;
                Logger.m6800i(str2, "GrsClientManager.ayncGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", this.f7329a, str3, StringUtils.anonymizeMessage(m6810a.get(str3)));
                iQueryUrlCallBack = this.f7331c;
                str = m6810a.get(this.f7330b);
            } else {
                if (TextUtils.isEmpty(this.f7332d)) {
                    if (!TextUtils.isEmpty(this.f7332d)) {
                        Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", this.f7329a, this.f7330b);
                        this.f7331c.onCallBackFail(-5);
                        return;
                    }
                    if (!TextUtils.isEmpty(m6937j)) {
                        Logger.m6798e(C2357a.f7318e, "The serviceName[%s][%s] is not configured on the GRS server.", this.f7329a, this.f7330b);
                    }
                    Logger.m6799i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrl: Get URL from Local JSON File");
                    String m6884a = C2365b.m6881a(this.f7333e.getPackageName()).m6884a(this.f7333e, this.f7335g, this.f7334f, this.f7329a, this.f7330b, true);
                    if (m6884a == null || m6884a.isEmpty()) {
                        Logger.m6798e(C2357a.f7318e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", this.f7329a, this.f7330b);
                    }
                    Logger.m6800i(C2357a.f7318e, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f7329a, this.f7330b, StringUtils.anonymizeMessage(m6884a));
                    this.f7331c.onCallBackSuccess(m6884a);
                    return;
                }
                String str4 = C2357a.f7318e;
                String str5 = this.f7330b;
                Logger.m6800i(str4, "GrsClientManager.ayncGetGrsUrl: Return [%s][%s] Url: %s", this.f7329a, str5, StringUtils.anonymizeMessage(m6810a.get(str5)));
                iQueryUrlCallBack = this.f7331c;
                str = this.f7332d;
            }
            iQueryUrlCallBack.onCallBackSuccess(str);
        }
    }

    public C2357a(GrsBaseInfo grsBaseInfo, C2361a c2361a, C2375g c2375g, C2363c c2363c) {
        this.f7319a = grsBaseInfo;
        this.f7320b = c2361a;
        this.f7321c = c2375g;
        this.f7322d = c2363c;
    }

    /* renamed from: a */
    public static CountryCodeBean m6806a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    /* renamed from: a */
    public static Map<String, Map<String, String>> m6808a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.m6801v(f7318e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, m6811a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.m6805w(f7318e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    /* renamed from: a */
    private Map<String, String> m6809a(String str, C2362b c2362b, Context context) {
        Map<String, String> m6848a = this.f7320b.m6848a(this.f7319a, str, c2362b, context);
        if (m6848a != null && !m6848a.isEmpty()) {
            Logger.m6799i(f7318e, "GrsClientManager.getUrlsLocal: Get URL from GRS Server Cache");
            return m6848a;
        }
        Map<String, String> m6885a = C2365b.m6881a(context.getPackageName()).m6885a(context, this.f7320b, this.f7319a, str, false);
        Logger.m6799i(f7318e, "GrsClientManager.getUrlsLocal: Get URL from Local JSON File");
        return m6885a != null ? m6885a : new HashMap();
    }

    /* renamed from: a */
    public static Map<String, String> m6810a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.m6803w(f7318e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.m6805w(f7318e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e2) {
            Logger.m6805w(f7318e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return hashMap;
        }
    }

    /* renamed from: a */
    public static Map<String, String> m6811a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.m6805w(f7318e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    /* renamed from: a */
    public String m6812a(Context context, String str, int i2) {
        C2372d m6950a = this.f7321c.m6950a(new C2380c(this.f7319a, context), str, this.f7322d, i2);
        return m6950a == null ? "" : m6950a.m6940m() ? this.f7320b.m6847a().m6857a(this.f7319a.getGrsParasKey(true, true, context), "") : m6950a.m6937j();
    }

    /* renamed from: a */
    public String m6813a(String str, String str2, Context context, int i2) {
        C2362b c2362b = new C2362b();
        String str3 = m6809a(str, c2362b, context).get(str2);
        if (c2362b.m6855a() && !TextUtils.isEmpty(str3)) {
            Logger.m6800i(f7318e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            return str3;
        }
        String m6812a = m6812a(context, str, i2);
        String str4 = m6810a(m6812a, str).get(str2);
        if (!TextUtils.isEmpty(str4)) {
            Logger.m6800i(f7318e, "GrsClientManager.synGetGrsUrl: Get URL from Current Called GRS Server, Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str4));
            return str4;
        }
        if (TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(m6812a)) {
                Logger.m6798e(f7318e, "The serviceName[%s][%s] is not configured on the GRS server.", str, str2);
            }
            Logger.m6799i(f7318e, "GrsClientManager.synGetGrsUrl: Get URL from Local JSON File.");
            str3 = C2365b.m6881a(context.getPackageName()).m6884a(context, this.f7320b, this.f7319a, str, str2, true);
            if (str3 == null || str3.isEmpty()) {
                Logger.m6798e(f7318e, "The serviceName[%s][%s] is not configured in the JSON configuration files to reveal all the details", str, str2);
            }
        }
        Logger.m6800i(f7318e, "GrsClientManager.synGetGrsUrl: Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
        return str3;
    }

    /* renamed from: a */
    public Map<String, String> m6814a(String str, Context context, int i2) {
        C2362b c2362b = new C2362b();
        Map<String, String> m6809a = m6809a(str, c2362b, context);
        if (c2362b.m6855a() && !m6809a.isEmpty()) {
            Logger.m6800i(f7318e, "Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(m6809a).toString()));
            return m6809a;
        }
        String m6812a = m6812a(context, str, i2);
        Map<String, String> m6810a = m6810a(m6812a, str);
        if (!m6810a.isEmpty()) {
            Logger.m6800i(f7318e, "GrsClientManager.synGetGrsUrls: Get URL from Current Called GRS Server Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(m6810a).toString()));
            return m6810a;
        }
        if (m6809a.isEmpty()) {
            if (!TextUtils.isEmpty(m6812a)) {
                Logger.m6798e(f7318e, "The serviceName[%s] is not configured on the GRS server.", str);
            }
            Logger.m6799i(f7318e, "GrsClientManager.synGetGrsUrls: Get URL from Local JSON File.");
            m6809a = C2365b.m6881a(context.getPackageName()).m6885a(context, this.f7320b, this.f7319a, str, true);
            if (m6809a == null || m6809a.isEmpty()) {
                Logger.m6798e(f7318e, "The serviceName[%s] is not configured in the JSON configuration files to reveal all the details", str);
            }
        }
        String str2 = f7318e;
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = StringUtils.anonymizeMessage(m6809a != null ? new JSONObject(m6809a).toString() : "");
        Logger.m6800i(str2, "GrsClientManager.synGetGrsUrls: Return [%s] Urls: %s", objArr);
        return m6809a;
    }

    /* renamed from: a */
    public void m6815a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, int i2) {
        C2362b c2362b = new C2362b();
        Map<String, String> m6809a = m6809a(str, c2362b, context);
        if (!c2362b.m6855a()) {
            this.f7321c.m6952a(new C2380c(this.f7319a, context), new a(str, m6809a, iQueryUrlsCallBack, context, this.f7319a, this.f7320b), str, this.f7322d, i2);
            return;
        }
        if (m6809a.isEmpty()) {
            Logger.m6800i(f7318e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls is Empty", str);
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            Logger.m6800i(f7318e, "GrsClientManager.ayncGetGrsUrls：Return [%s] Urls: %s", str, StringUtils.anonymizeMessage(new JSONObject(m6809a).toString()));
            Logger.m6800i(f7318e, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(m6809a).toString()));
            iQueryUrlsCallBack.onCallBackSuccess(m6809a);
        }
    }

    /* renamed from: a */
    public void m6816a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context, int i2) {
        C2362b c2362b = new C2362b();
        String str3 = m6809a(str, c2362b, context).get(str2);
        if (!c2362b.m6855a()) {
            this.f7321c.m6952a(new C2380c(this.f7319a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.f7319a, this.f7320b), str, this.f7322d, i2);
        } else if (TextUtils.isEmpty(str3)) {
            Logger.m6800i(f7318e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url is Empty", str, str2);
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            Logger.m6800i(f7318e, "GrsClientManager.ayncGetGrsUrl：Return [%s][%s] Url: %s", str, str2, StringUtils.anonymizeMessage(str3));
            iQueryUrlCallBack.onCallBackSuccess(str3);
        }
    }
}
