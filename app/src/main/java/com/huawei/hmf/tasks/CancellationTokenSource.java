package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CancellationTokenSource {
    private c impl = new c();

    public void cancel() {
        c cVar = this.impl;
        if (cVar.f4362c) {
            return;
        }
        synchronized (cVar.f4361b) {
            cVar.f4362c = true;
            Iterator<Runnable> it = cVar.a.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
