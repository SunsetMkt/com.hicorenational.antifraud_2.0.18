package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class b<TResult> implements ExecuteResult<TResult> {
    private OnCanceledListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f4359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4360c = new Object();

    b(Executor executor, OnCanceledListener onCanceledListener) {
        this.a = onCanceledListener;
        this.f4359b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f4360c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.f4359b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this.f4360c) {
                        if (b.this.a != null) {
                            b.this.a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
