package com.huawei.hmf.tasks.p170a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.b */
/* loaded from: classes.dex */
public final class C2272b<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    private OnCanceledListener f6947a;

    /* renamed from: b */
    private Executor f6948b;

    /* renamed from: c */
    private final Object f6949c = new Object();

    C2272b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f6947a = onCanceledListener;
        this.f6948b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f6949c) {
            this.f6947a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.f6948b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (C2272b.this.f6949c) {
                        if (C2272b.this.f6947a != null) {
                            C2272b.this.f6947a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
