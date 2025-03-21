package com.huawei.hms.framework.network.grs.p175g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.C2357a;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p173e.C2361a;
import com.huawei.hms.framework.network.grs.p173e.C2363c;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2380c;
import com.huawei.hms.framework.network.grs.p178h.C2386e;
import org.json.JSONException;

/* renamed from: com.huawei.hms.framework.network.grs.g.b */
/* loaded from: classes.dex */
public class C2370b {

    /* renamed from: a */
    private final Context f7380a;

    /* renamed from: b */
    private final GrsBaseInfo f7381b;

    /* renamed from: c */
    private final C2361a f7382c;

    public C2370b(Context context, C2361a c2361a, GrsBaseInfo grsBaseInfo) {
        this.f7380a = context;
        this.f7381b = grsBaseInfo;
        this.f7382c = c2361a;
    }

    /* renamed from: a */
    public String m6898a(boolean z) {
        String str = C2357a.m6810a(this.f7382c.m6847a().m6857a("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        Logger.m6799i("GeoipCountry", "geoIpCountry is: " + str);
        String m6857a = this.f7382c.m6847a().m6857a("geoipCountryCodetime", "0");
        long j2 = 0;
        if (!TextUtils.isEmpty(m6857a) && m6857a.matches("\\d+")) {
            try {
                j2 = Long.parseLong(m6857a);
            } catch (NumberFormatException e2) {
                Logger.m6804w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e2);
            }
        }
        if (TextUtils.isEmpty(str) || C2386e.m6984a(Long.valueOf(j2))) {
            C2380c c2380c = new C2380c(this.f7381b, this.f7380a);
            c2380c.m6962a("geoip.countrycode");
            C2363c m6853c = this.f7382c.m6853c();
            if (m6853c != null) {
                String str2 = null;
                try {
                    str2 = C2376h.m6954a(m6853c.m6857a("services", ""), c2380c.m6964c());
                } catch (JSONException e3) {
                    Logger.m6805w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e3.getMessage()));
                }
                if (!TextUtils.isEmpty(str2)) {
                    m6853c.m6861b("services", str2);
                }
            }
            if (z) {
                C2372d m6950a = this.f7382c.m6851b().m6950a(c2380c, "geoip.countrycode", m6853c, -1);
                if (m6950a != null) {
                    str = C2357a.m6810a(m6950a.m6937j(), "geoip.countrycode").get("ROOT");
                }
                Logger.m6799i("GeoipCountry", "sync request to query geoip.countrycode is:" + str);
            } else {
                Logger.m6799i("GeoipCountry", "async request to query geoip.countrycode");
                this.f7382c.m6851b().m6952a(c2380c, null, "geoip.countrycode", m6853c, -1);
            }
        }
        return str;
    }
}
