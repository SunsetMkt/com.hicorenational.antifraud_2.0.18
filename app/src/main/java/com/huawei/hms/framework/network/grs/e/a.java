package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.d;
import com.huawei.hms.framework.network.grs.g.g;
import com.huawei.hms.framework.network.grs.h.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e */
    private static final String f4614e = "a";

    /* JADX INFO: renamed from: f */
    private static final Map<String, Map<String, Map<String, String>>> f4615f = new ConcurrentHashMap(16);
    private final Map<String, Long> a = new ConcurrentHashMap(16);

    /* JADX INFO: renamed from: b */
    private final c f4616b;

    /* JADX INFO: renamed from: c */
    private final c f4617c;

    /* JADX INFO: renamed from: d */
    private final g f4618d;

    public a(c cVar, c cVar2, g gVar) {
        this.f4617c = cVar2;
        this.f4616b = cVar;
        this.f4618d = gVar;
        this.f4618d.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l2 = this.a.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (e.a(l2)) {
            bVar.a(2);
            return;
        }
        if (e.a(l2, 300000L)) {
            this.f4618d.a(new com.huawei.hms.framework.network.grs.g.j.c(grsBaseInfo, context), null, str, this.f4617c, -1);
        }
        bVar.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.a.get(str), 300000L)) {
            this.f4618d.a(new com.huawei.hms.framework.network.grs.g.j.c(grsBaseInfo, context), null, null, this.f4617c, -1);
        }
    }

    public c a() {
        return this.f4616b;
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        Map<String, Map<String, String>> map = f4615f.get(grsBaseInfo.getGrsParasKey(true, true, context));
        if (map != null && !map.isEmpty()) {
            a(grsBaseInfo, bVar, context, str);
            return map.get(str);
        }
        Logger.i(f4614e, "Cache size is: " + f4615f.size());
        return new HashMap();
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        this.f4616b.b(grsParasKey + "time", "0");
        this.a.remove(grsParasKey + "time");
        f4615f.remove(grsParasKey);
        Logger.i(f4614e, "Cache size is: " + f4615f.size());
        this.f4618d.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, d dVar, Context context, com.huawei.hms.framework.network.grs.g.j.c cVar) {
        if (dVar.f() == 2) {
            Logger.w(f4614e, "update cache from server failed");
            return;
        }
        if (cVar.d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
            if (dVar.m()) {
                f4615f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(this.f4616b.a(grsParasKey, "")));
            } else {
                this.f4616b.b(grsParasKey, dVar.j());
                f4615f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(dVar.j()));
            }
            if (!TextUtils.isEmpty(dVar.e())) {
                this.f4616b.b(grsParasKey + HttpHeaders.ETAG, dVar.e());
            }
            this.f4616b.b(grsParasKey + "time", dVar.a());
            this.a.put(grsParasKey, Long.valueOf(Long.parseLong(dVar.a())));
        } else {
            this.f4616b.b("geoipCountryCode", dVar.j());
            this.f4616b.b("geoipCountryCodetime", dVar.a());
        }
        Logger.i(f4614e, "Cache size is: " + f4615f.size());
    }

    public g b() {
        return this.f4618d;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(true, true, context);
        String strA = this.f4616b.a(grsParasKey, "");
        String strA2 = this.f4616b.a(grsParasKey + "time", "0");
        long j2 = 0;
        if (!TextUtils.isEmpty(strA2) && strA2.matches("\\d+")) {
            try {
                j2 = Long.parseLong(strA2);
            } catch (NumberFormatException e2) {
                Logger.w(f4614e, "convert urlParamKey from String to Long catch NumberFormatException.", e2);
            }
        }
        f4615f.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(strA));
        Logger.i(f4614e, "Cache size is: " + f4615f.size());
        this.a.put(grsParasKey, Long.valueOf(j2));
        a(grsBaseInfo, grsParasKey, context);
    }

    public c c() {
        return this.f4617c;
    }
}
