package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.p170a.C2279i;

/* loaded from: classes.dex */
public class TaskCompletionSource<TResult> {
    private final C2279i<TResult> task = new C2279i<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.register(new Runnable() { // from class: com.huawei.hmf.tasks.TaskCompletionSource.1
            @Override // java.lang.Runnable
            public void run() {
                TaskCompletionSource.this.task.m6489a();
            }
        });
    }

    public Task<TResult> getTask() {
        return this.task;
    }

    public void setException(Exception exc) {
        this.task.m6487a(exc);
    }

    public void setResult(TResult tresult) {
        this.task.m6488a((C2279i<TResult>) tresult);
    }
}
