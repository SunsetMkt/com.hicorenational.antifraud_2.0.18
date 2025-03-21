package com.vivo.push;

import android.os.SystemClock;

/* compiled from: RequestFrequencyControl.java */
/* renamed from: com.vivo.push.y */
/* loaded from: classes2.dex */
public final class C4019y {

    /* renamed from: a */
    private volatile long f14291a = -1;

    /* renamed from: a */
    public final synchronized boolean m13329a() {
        boolean z;
        long j2 = this.f14291a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        z = j2 != -1 && elapsedRealtime > j2 && elapsedRealtime < j2 + 2000;
        this.f14291a = SystemClock.elapsedRealtime();
        return z;
    }
}
