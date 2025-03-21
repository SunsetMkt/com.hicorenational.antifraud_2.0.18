package com.huawei.hmf.tasks.p170a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.huawei.hmf.tasks.a.c */
/* loaded from: classes.dex */
public final class C2273c extends CancellationToken {

    /* renamed from: a */
    public final List<Runnable> f6951a = new ArrayList();

    /* renamed from: b */
    public final Object f6952b = new Object();

    /* renamed from: c */
    public boolean f6953c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f6953c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.f6952b) {
            if (this.f6953c) {
                runnable.run();
            } else {
                this.f6951a.add(runnable);
            }
        }
        return this;
    }
}
