package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: b */
    static Map<String, l1> f4799b = new HashMap();

    /* JADX INFO: renamed from: c */
    private static s f4800c;
    private g1 a = new g1();

    private s() {
    }

    public static s c() {
        if (f4800c == null) {
            d();
        }
        return f4800c;
    }

    private static synchronized void d() {
        if (f4800c == null) {
            f4800c = new s();
        }
    }

    public l1 a(String str) {
        return f4799b.get(str);
    }

    public Set<String> a() {
        return f4799b.keySet();
    }

    public void a(String str, l1 l1Var) {
        f4799b.put(str, l1Var);
    }

    public g1 b() {
        return this.a;
    }
}
