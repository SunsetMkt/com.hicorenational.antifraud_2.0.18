package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class f<TResult> implements ExecuteResult<TResult> {
    private OnFailureListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f4371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4372c = new Object();

    f(Executor executor, OnFailureListener onFailureListener) {
        this.a = onFailureListener;
        this.f4371b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f4372c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.f4371b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (f.this.f4372c) {
                    if (f.this.a != null) {
                        f.this.a.onFailure(task.getException());
                    }
                }
            }
        });
    }
}
