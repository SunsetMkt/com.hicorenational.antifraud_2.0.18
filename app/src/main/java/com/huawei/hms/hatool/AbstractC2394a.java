package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* renamed from: com.huawei.hms.hatool.a */
/* loaded from: classes.dex */
public abstract class AbstractC2394a {

    /* renamed from: a */
    private static C2461z0 f7456a;

    /* renamed from: a */
    private static synchronized C2461z0 m7012a() {
        C2461z0 c2461z0;
        synchronized (AbstractC2394a.class) {
            if (f7456a == null) {
                f7456a = C2442q.m7291c().m7294b();
            }
            c2461z0 = f7456a;
        }
        return c2461z0;
    }

    /* renamed from: a */
    public static void m7013a(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (m7012a() == null || !C2444q1.m7318b().m7319a()) {
            return;
        }
        if (i2 == 1 || i2 == 0) {
            f7456a.m7435a(i2, str, linkedHashMap);
            return;
        }
        C2452v.m7387d("hmsSdk", "Data type no longer collects range.type: " + i2);
    }

    @Deprecated
    /* renamed from: a */
    public static void m7014a(Context context, String str, String str2) {
        if (m7012a() != null) {
            f7456a.m7436a(context, str, str2);
        }
    }

    /* renamed from: b */
    public static void m7015b(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (m7012a() == null || !C2444q1.m7318b().m7319a()) {
            return;
        }
        if (i2 == 1 || i2 == 0) {
            f7456a.m7438b(i2, str, linkedHashMap);
            return;
        }
        C2452v.m7387d("hmsSdk", "Data type no longer collects range.type: " + i2);
    }

    /* renamed from: b */
    public static boolean m7016b() {
        return C2442q.m7291c().m7293a();
    }

    /* renamed from: c */
    public static void m7017c() {
        if (m7012a() == null || !C2444q1.m7318b().m7319a()) {
            return;
        }
        f7456a.m7434a(-1);
    }
}
