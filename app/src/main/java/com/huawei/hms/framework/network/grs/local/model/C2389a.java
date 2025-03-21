package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.local.model.a */
/* loaded from: classes.dex */
public class C2389a {

    /* renamed from: a */
    private String f7447a;

    /* renamed from: b */
    private final Map<String, C2391c> f7448b = new ConcurrentHashMap(16);

    /* renamed from: a */
    public C2391c m6990a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f7448b.get(str);
        }
        Logger.m6803w("ApplicationBean", "In getServing(String serviceName), the serviceName is Empty or null");
        return null;
    }

    /* renamed from: a */
    public String m6991a() {
        return this.f7447a;
    }

    /* renamed from: a */
    public void m6992a(long j2) {
    }

    /* renamed from: a */
    public void m6993a(String str, C2391c c2391c) {
        if (TextUtils.isEmpty(str) || c2391c == null) {
            return;
        }
        this.f7448b.put(str, c2391c);
    }

    /* renamed from: b */
    public void m6994b(String str) {
        this.f7447a = str;
    }
}
