package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;

/* JADX INFO: loaded from: classes.dex */
public class TaskCompletionSource<TResult> {
    private final i<TResult> task = new i<>();

    /* JADX INFO: renamed from: com.huawei.hmf.tasks.TaskCompletionSource$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TaskCompletionSource.this.task.a();
        }
    }

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.register(new Runnable() { // from class: com.huawei.hmf.tasks.TaskCompletionSource.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TaskCompletionSource.this.task.a();
            }
        });
    }

    public Task<TResult> getTask() {
        return this.task;
    }

    public void setException(Exception exc) {
        this.task.a(exc);
    }

    public void setResult(TResult tresult) {
        this.task.a(tresult);
    }
}
