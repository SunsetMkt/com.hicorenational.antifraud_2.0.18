package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c extends CancellationToken {
    public final List<Runnable> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4361b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4362c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f4362c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.f4361b) {
            if (this.f4362c) {
                runnable.run();
            } else {
                this.a.add(runnable);
            }
        }
        return this;
    }
}
