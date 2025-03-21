package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.p170a.C2273c;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CancellationTokenSource {
    private C2273c impl = new C2273c();

    public void cancel() {
        C2273c c2273c = this.impl;
        if (c2273c.f6953c) {
            return;
        }
        synchronized (c2273c.f6952b) {
            c2273c.f6953c = true;
            Iterator<Runnable> it = c2273c.f6951a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
