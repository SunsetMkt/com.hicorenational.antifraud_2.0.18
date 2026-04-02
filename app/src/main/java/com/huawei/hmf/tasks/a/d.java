package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class d<TResult> implements ExecuteResult<TResult> {
    Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OnCompleteListener<TResult> f4363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4364c = new Object();

    d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f4363b = onCompleteListener;
        this.a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f4364c) {
            this.f4363b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.a.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this.f4364c) {
                    if (d.this.f4363b != null) {
                        d.this.f4363b.onComplete(task);
                    }
                }
            }
        });
    }
}
