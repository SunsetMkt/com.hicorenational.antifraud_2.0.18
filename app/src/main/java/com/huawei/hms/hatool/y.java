package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static y f4824b;
    private volatile Map<String, p0> a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, new p0());
        }
        return this.a.get(str);
    }

    public static y a() {
        if (f4824b == null) {
            b();
        }
        return f4824b;
    }

    private static synchronized void b() {
        if (f4824b == null) {
            f4824b = new y();
        }
    }

    public p0 a(String str, long j2) {
        p0 p0VarA = a(str);
        p0VarA.a(j2);
        return p0VarA;
    }
}
