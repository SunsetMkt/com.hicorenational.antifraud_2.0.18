package com.xiaomi.push;

import android.os.Build;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static long f13251a;

    /* renamed from: a, reason: collision with other field name */
    private static String f909a;

    public static synchronized String a() {
        String str;
        synchronized (k.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - f13251a) > 86400000) {
                f13251a = currentTimeMillis;
                f909a = Build.MODEL;
            }
            str = f909a == null ? "" : f909a;
        }
        return str;
    }
}
