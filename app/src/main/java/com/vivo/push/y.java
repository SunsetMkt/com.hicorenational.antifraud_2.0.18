package com.vivo.push;

import android.os.SystemClock;

/* JADX INFO: compiled from: RequestFrequencyControl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    private volatile long a = -1;

    public final synchronized boolean a() {
        boolean z;
        long j2 = this.a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        z = j2 != -1 && jElapsedRealtime > j2 && jElapsedRealtime < j2 + 2000;
        this.a = SystemClock.elapsedRealtime();
        return z;
    }
}
