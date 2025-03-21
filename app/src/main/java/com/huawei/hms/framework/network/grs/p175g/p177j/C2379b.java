package com.huawei.hms.framework.network.grs.p175g.p177j;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.p175g.C2372d;
import java.util.concurrent.Future;

/* renamed from: com.huawei.hms.framework.network.grs.g.j.b */
/* loaded from: classes.dex */
public class C2379b {

    /* renamed from: a */
    private final Future<C2372d> f7431a;

    /* renamed from: b */
    private final long f7432b = SystemClock.elapsedRealtime();

    public C2379b(Future<C2372d> future) {
        this.f7431a = future;
    }

    /* renamed from: a */
    public Future<C2372d> m6957a() {
        return this.f7431a;
    }

    /* renamed from: b */
    public boolean m6958b() {
        return SystemClock.elapsedRealtime() - this.f7432b <= 300000;
    }
}
