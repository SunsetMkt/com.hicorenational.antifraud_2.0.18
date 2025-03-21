package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.p170a.C2279i;
import com.huawei.hmf.tasks.p170a.C2280j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public class Tasks {
    private static C2280j IMPL = new C2280j();

    public static Task<List<Task<?>>> allOf(Collection<? extends Task<?>> collection) {
        return C2280j.m6491a(collection);
    }

    public static Task<List<Task<?>>> allOf(Task<?>... taskArr) {
        return C2280j.m6491a((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        C2280j.m6493a("await must not be called on the UI thread");
        if (task.isComplete()) {
            return (TResult) C2280j.m6492a((Task) task);
        }
        C2280j.a aVar = new C2280j.a();
        task.addOnSuccessListener(aVar).addOnFailureListener(aVar);
        aVar.f7003a.await();
        return (TResult) C2280j.m6492a((Task) task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C2280j.m6493a("await must not be called on the UI thread");
        if (!task.isComplete()) {
            C2280j.a aVar = new C2280j.a();
            task.addOnSuccessListener(aVar).addOnFailureListener(aVar);
            if (!aVar.f7003a.await(j2, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return (TResult) C2280j.m6492a((Task) task);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return IMPL.m6496a(TaskExecutors.immediate(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return IMPL.m6496a(TaskExecutors.background(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Executor executor, Callable<TResult> callable) {
        return IMPL.m6496a(executor, callable);
    }

    public static <TResult> Task<TResult> fromCanceled() {
        C2279i c2279i = new C2279i();
        c2279i.m6489a();
        return c2279i;
    }

    public static <TResult> Task<TResult> fromException(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<TResult> fromResult(TResult tresult) {
        return C2280j.m6490a(tresult);
    }

    public static Task<Void> join(Collection<? extends Task<?>> collection) {
        return C2280j.m6495c(collection);
    }

    public static Task<Void> join(Task<?>... taskArr) {
        return C2280j.m6495c(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> successOf(Collection<? extends Task<TResult>> collection) {
        return C2280j.m6494b(collection);
    }

    public static <TResult> Task<List<TResult>> successOf(Task<?>... taskArr) {
        return C2280j.m6494b(Arrays.asList(taskArr));
    }
}
