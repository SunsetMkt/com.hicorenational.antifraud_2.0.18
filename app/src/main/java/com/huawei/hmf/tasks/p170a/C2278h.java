package com.huawei.hmf.tasks.p170a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.h */
/* loaded from: classes.dex */
public final class C2278h<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    private OnSuccessListener<TResult> f6972a;

    /* renamed from: b */
    private Executor f6973b;

    /* renamed from: c */
    private final Object f6974c = new Object();

    C2278h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f6972a = onSuccessListener;
        this.f6973b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f6974c) {
            this.f6972a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.f6973b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (C2278h.this.f6974c) {
                    if (C2278h.this.f6972a != null) {
                        C2278h.this.f6972a.onSuccess(task.getResult());
                    }
                }
            }
        });
    }
}
