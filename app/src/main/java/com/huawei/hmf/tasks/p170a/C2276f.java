package com.huawei.hmf.tasks.p170a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.f */
/* loaded from: classes.dex */
public final class C2276f<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    private OnFailureListener f6965a;

    /* renamed from: b */
    private Executor f6966b;

    /* renamed from: c */
    private final Object f6967c = new Object();

    C2276f(Executor executor, OnFailureListener onFailureListener) {
        this.f6965a = onFailureListener;
        this.f6966b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f6967c) {
            this.f6965a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.f6966b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (C2276f.this.f6967c) {
                    if (C2276f.this.f6965a != null) {
                        C2276f.this.f6965a.onFailure(task.getException());
                    }
                }
            }
        });
    }
}
