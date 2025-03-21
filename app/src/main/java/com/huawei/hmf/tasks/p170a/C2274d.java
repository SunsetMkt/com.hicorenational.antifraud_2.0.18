package com.huawei.hmf.tasks.p170a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.d */
/* loaded from: classes.dex */
public final class C2274d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a */
    Executor f6954a;

    /* renamed from: b */
    private OnCompleteListener<TResult> f6955b;

    /* renamed from: c */
    private final Object f6956c = new Object();

    C2274d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f6955b = onCompleteListener;
        this.f6954a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f6956c) {
            this.f6955b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.f6954a.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (C2274d.this.f6956c) {
                    if (C2274d.this.f6955b != null) {
                        C2274d.this.f6955b.onComplete(task);
                    }
                }
            }
        });
    }
}
