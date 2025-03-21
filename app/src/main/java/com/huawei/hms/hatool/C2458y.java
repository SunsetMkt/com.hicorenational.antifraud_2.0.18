package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.y */
/* loaded from: classes.dex */
public final class C2458y {

    /* renamed from: b */
    private static C2458y f7644b;

    /* renamed from: a */
    private volatile Map<String, C2440p0> f7645a = new HashMap();

    private C2458y() {
    }

    /* renamed from: a */
    private C2440p0 m7414a(String str) {
        if (!this.f7645a.containsKey(str)) {
            this.f7645a.put(str, new C2440p0());
        }
        return this.f7645a.get(str);
    }

    /* renamed from: a */
    public static C2458y m7415a() {
        if (f7644b == null) {
            m7416b();
        }
        return f7644b;
    }

    /* renamed from: b */
    private static synchronized void m7416b() {
        synchronized (C2458y.class) {
            if (f7644b == null) {
                f7644b = new C2458y();
            }
        }
    }

    /* renamed from: a */
    public C2440p0 m7417a(String str, long j2) {
        C2440p0 m7414a = m7414a(str);
        m7414a.m7281a(j2);
        return m7414a;
    }
}
