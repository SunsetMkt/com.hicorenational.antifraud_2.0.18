package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class h<TResult> implements ExecuteResult<TResult> {
    private OnSuccessListener<TResult> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f4375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4376c = new Object();

    h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.a = onSuccessListener;
        this.f4375b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f4376c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.f4375b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (h.this.f4376c) {
                    if (h.this.a != null) {
                        h.this.a.onSuccess(task.getResult());
                    }
                }
            }
        });
    }
}
