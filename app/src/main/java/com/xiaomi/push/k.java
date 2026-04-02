package com.xiaomi.push;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    private static long a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f909a;

    public static synchronized String a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - a) > 86400000) {
            a = jCurrentTimeMillis;
            f909a = Build.MODEL;
        }
        return f909a == null ? "" : f909a;
    }
}
