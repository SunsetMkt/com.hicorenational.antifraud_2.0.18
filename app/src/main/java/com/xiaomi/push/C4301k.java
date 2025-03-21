package com.xiaomi.push;

import android.os.Build;

/* renamed from: com.xiaomi.push.k */
/* loaded from: classes2.dex */
public class C4301k {

    /* renamed from: a */
    private static long f16370a;

    /* renamed from: a */
    private static String f16371a;

    /* renamed from: a */
    public static synchronized String m15694a() {
        String str;
        synchronized (C4301k.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - f16370a) > 86400000) {
                f16370a = currentTimeMillis;
                f16371a = Build.MODEL;
            }
            str = f16371a == null ? "" : f16371a;
        }
        return str;
    }
}
