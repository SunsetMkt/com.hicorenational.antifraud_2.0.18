package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* compiled from: LogTime.java */
/* renamed from: com.bumptech.glide.util.f */
/* loaded from: classes.dex */
public final class C1872f {

    /* renamed from: a */
    private static final double f5485a;

    static {
        f5485a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    private C1872f() {
    }

    @TargetApi(17)
    /* renamed from: a */
    public static long m4970a() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }

    /* renamed from: a */
    public static double m4969a(long j2) {
        return (m4970a() - j2) * f5485a;
    }
}
