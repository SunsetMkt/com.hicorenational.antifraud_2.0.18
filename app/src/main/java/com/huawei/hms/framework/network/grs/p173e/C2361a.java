package com.huawei.hms.framework.network.grs.p173e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.C2357a;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p175g.C2372d;
import com.huawei.hms.framework.network.grs.p175g.C2375g;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2380c;
import com.huawei.hms.framework.network.grs.p178h.C2386e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.e.a */
/* loaded from: classes.dex */
public class C2361a {

    /* renamed from: e */
    private static final String f7352e = "a";

    /* renamed from: f */
    private static final Map<String, Map<String, Map<String, String>>> f7353f = new ConcurrentHashMap(16);

    /* renamed from: a */
    private final Map<String, Long> f7354a = new ConcurrentHashMap(16);

    /* renamed from: b */
    private final C2363c f7355b;

    /* renamed from: c */
    private final C2363c f7356c;

    /* renamed from: d */
    private final C2375g f7357d;

    public C2361a(C2363c c2363c, C2363c c2363c2, C2375g c2375g) {
        this.f7356c = c2363c2;
        this.f7355b = c2363c;
        this.f7357d = c2375g;
        this.f7357d.m6951a(this);
    }

    /* renamed from: a */
    private void m6845a(GrsBaseInfo grsBaseInfo, C2362b c2362b, Context context, String str) {
        Long l2 = this.f7354a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (C2386e.m6984a(l2)) {
            c2362b.m6854a(2);
            return;
        }
        if (C2386e.m6985a(l2, 300000L)) {
            this.f7357d.m6952a(new C2380c(grsBaseInfo, context), null, str, this.f7356c, -1);
        }
        c2362b.m6854a(1);
    }

    /* renamed from: a */
    private void m6846a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (C2386e.m6985a(this.f7354a.get(str), 300000L)) {
            this.f7357d.m6952a(new C2380c(grsBaseInfo, context), null, null, this.f7356c, -1);
        }
    }

    /* renamed from: a */
    public C2363c m6847a() {
        return this.f7355b;
    }

    /* renamed from: a */
    public Map<String, String> m6848a(GrsBaseInfo grsBaseInfo, String str, C2362b c2362b, Context context) {
        Map<String, Map<String, String>> map = f7353f.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (map != null && !map.isEmpty()) {
            m6845a(grsBaseInfo, c2362b, context, str);
            return map.get(str);
        }
        Logger.m6799i(f7352e, "Cache size is: " + f7353f.size());
        return new HashMap();
    }

    /* renamed from: a */
    public void m6849a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f7355b.m6861b(grsParasKey + "time", "0");
        this.f7354a.remove(grsParasKey + "time");
        f7353f.remove(grsParasKey);
        Logger.m6799i(f7352e, "Cache size is: " + f7353f.size());
        this.f7357d.m6953a(grsParasKey);
    }

    /* renamed from: a */
    public void m6850a(GrsBaseInfo grsBaseInfo, C2372d c2372d, Context context, C2380c c2380c) {
        if (c2372d.m6933f() == 2) {
            Logger.m6803w(f7352e, "update cache from server failed");
            return;
        }
        if (c2380c.m6965d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (c2372d.m6940m()) {
                f7353f.put(grsParasKey, C2357a.m6808a(this.f7355b.m6857a(grsParasKey, "")));
            } else {
                this.f7355b.m6861b(grsParasKey, c2372d.m6937j());
                f7353f.put(grsParasKey, C2357a.m6808a(c2372d.m6937j()));
            }
            if (!TextUtils.isEmpty(c2372d.m6932e())) {
                this.f7355b.m6861b(grsParasKey + HttpHeaders.ETAG, c2372d.m6932e());
            }
            this.f7355b.m6861b(grsParasKey + "time", c2372d.m6923a());
            this.f7354a.put(grsParasKey, Long.valueOf(Long.parseLong(c2372d.m6923a())));
        } else {
            this.f7355b.m6861b("geoipCountryCode", c2372d.m6937j());
            this.f7355b.m6861b("geoipCountryCodetime", c2372d.m6923a());
        }
        Logger.m6799i(f7352e, "Cache size is: " + f7353f.size());
    }

    /* renamed from: b */
    public C2375g m6851b() {
        return this.f7357d;
    }

    /* renamed from: b */
    public void m6852b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String m6857a = this.f7355b.m6857a(grsParasKey, "");
        String m6857a2 = this.f7355b.m6857a(grsParasKey + "time", "0");
        long j2 = 0;
        if (!TextUtils.isEmpty(m6857a2) && m6857a2.matches("\\d+")) {
            try {
                j2 = Long.parseLong(m6857a2);
            } catch (NumberFormatException e2) {
                Logger.m6804w(f7352e, "convert urlParamKey from String to Long catch NumberFormatException.", e2);
            }
        }
        f7353f.put(grsParasKey, C2357a.m6808a(m6857a));
        Logger.m6799i(f7352e, "Cache size is: " + f7353f.size());
        this.f7354a.put(grsParasKey, Long.valueOf(j2));
        m6846a(grsBaseInfo, grsParasKey, context);
    }

    /* renamed from: c */
    public C2363c m6853c() {
        return this.f7356c;
    }
}
