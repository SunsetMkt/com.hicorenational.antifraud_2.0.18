package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.hms.hatool.s */
/* loaded from: classes.dex */
public final class C2446s {

    /* renamed from: b */
    static Map<String, C2429l1> f7608b = new HashMap();

    /* renamed from: c */
    private static C2446s f7609c;

    /* renamed from: a */
    private C2414g1 f7610a = new C2414g1();

    private C2446s() {
    }

    /* renamed from: c */
    public static C2446s m7326c() {
        if (f7609c == null) {
            m7327d();
        }
        return f7609c;
    }

    /* renamed from: d */
    private static synchronized void m7327d() {
        synchronized (C2446s.class) {
            if (f7609c == null) {
                f7609c = new C2446s();
            }
        }
    }

    /* renamed from: a */
    public C2429l1 m7328a(String str) {
        return f7608b.get(str);
    }

    /* renamed from: a */
    public Set<String> m7329a() {
        return f7608b.keySet();
    }

    /* renamed from: a */
    public void m7330a(String str, C2429l1 c2429l1) {
        f7608b.put(str, c2429l1);
    }

    /* renamed from: b */
    public C2414g1 m7331b() {
        return this.f7610a;
    }
}
