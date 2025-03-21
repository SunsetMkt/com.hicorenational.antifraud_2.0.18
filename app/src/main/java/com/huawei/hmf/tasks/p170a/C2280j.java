package com.huawei.hmf.tasks.p170a;

import android.os.Looper;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.j */
/* loaded from: classes.dex */
public final class C2280j {

    /* renamed from: com.huawei.hmf.tasks.a.j$a */
    public static class a<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

        /* renamed from: a */
        public final CountDownLatch f7003a = new CountDownLatch(1);

        @Override // com.huawei.hmf.tasks.OnCanceledListener
        public final void onCanceled() {
            this.f7003a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.f7003a.countDown();
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public final void onSuccess(TResult tresult) {
            this.f7003a.countDown();
        }
    }

    /* renamed from: a */
    public static <TResult> Task<TResult> m6490a(TResult tresult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    /* renamed from: a */
    public static Task<List<Task<?>>> m6491a(final Collection<? extends Task<?>> collection) {
        return m6495c(collection).continueWith(new Continuation<Void, List<Task<?>>>() { // from class: com.huawei.hmf.tasks.a.j.2
            @Override // com.huawei.hmf.tasks.Continuation
            public final /* synthetic */ List<Task<?>> then(Task<Void> task) throws Exception {
                ArrayList arrayList = new ArrayList(collection.size());
                arrayList.addAll(collection);
                return arrayList;
            }
        });
    }

    /* renamed from: a */
    public static <TResult> TResult m6492a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    /* renamed from: a */
    public static void m6493a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: b */
    public static <TResult> Task<List<TResult>> m6494b(final Collection<? extends Task<?>> collection) {
        return (Task<List<TResult>>) m6495c(collection).continueWith(new Continuation<Void, List<TResult>>() { // from class: com.huawei.hmf.tasks.a.j.3
            @Override // com.huawei.hmf.tasks.Continuation
            public final /* synthetic */ Object then(Task<Void> task) throws Exception {
                ArrayList arrayList = new ArrayList();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Task) it.next()).getResult());
                }
                return arrayList;
            }
        });
    }

    /* renamed from: c */
    public static Task<Void> m6495c(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return m6490a((Object) null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        C2279i c2279i = new C2279i();
        C2275e c2275e = new C2275e(collection.size(), c2279i);
        for (Task<?> task : collection) {
            task.addOnSuccessListener(TaskExecutors.immediate(), c2275e);
            task.addOnFailureListener(TaskExecutors.immediate(), c2275e);
            task.addOnCanceledListener(TaskExecutors.immediate(), c2275e);
        }
        return c2279i;
    }

    /* renamed from: a */
    public final <TResult> Task<TResult> m6496a(Executor executor, final Callable<TResult> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        taskCompletionSource.setResult(callable.call());
                    } catch (Exception e2) {
                        taskCompletionSource.setException(e2);
                    }
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
        return taskCompletionSource.getTask();
    }
}
