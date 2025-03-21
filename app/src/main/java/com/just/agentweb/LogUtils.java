package com.just.agentweb;

import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
class LogUtils {
    private static final String PREFIX = "agentweb-";

    LogUtils() {
    }

    /* renamed from: e */
    static void m8081e(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }

    /* renamed from: e */
    static void m8082e(String str, String str2, Throwable th) {
    }

    /* renamed from: i */
    static void m8083i(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }

    static boolean isDebug() {
        return AgentWebConfig.DEBUG;
    }

    static void safeCheckCrash(String str, String str2, Throwable th) {
        if (!isDebug()) {
            PREFIX.concat(str);
            return;
        }
        throw new RuntimeException(PREFIX.concat(str) + AbstractC1191a.f2568g + str2, th);
    }

    /* renamed from: v */
    static void m8084v(String str, String str2) {
        if (isDebug()) {
            PREFIX.concat(str);
        }
    }
}
