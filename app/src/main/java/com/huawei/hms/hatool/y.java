package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    private static y f7114b;

    /* renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f7115a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.f7115a.containsKey(str)) {
            this.f7115a.put(str, new p0());
        }
        return this.f7115a.get(str);
    }

    public static y a() {
        if (f7114b == null) {
            b();
        }
        return f7114b;
    }

    private static synchronized void b() {
        synchronized (y.class) {
            if (f7114b == null) {
                f7114b = new y();
            }
        }
    }

    public p0 a(String str, long j2) {
        p0 a2 = a(str);
        a2.a(j2);
        return a2;
    }
}
