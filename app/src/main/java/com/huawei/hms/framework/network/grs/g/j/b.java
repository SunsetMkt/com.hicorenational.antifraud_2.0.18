package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private final Future<com.huawei.hms.framework.network.grs.g.d> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f4677b = SystemClock.elapsedRealtime();

    public b(Future<com.huawei.hms.framework.network.grs.g.d> future) {
        this.a = future;
    }

    public Future<com.huawei.hms.framework.network.grs.g.d> a() {
        return this.a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.f4677b <= 300000;
    }
}
