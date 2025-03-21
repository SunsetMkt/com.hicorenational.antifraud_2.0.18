package com.huawei.hmf.tasks.p170a;

import android.app.Activity;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.huawei.hmf.tasks.a.i */
/* loaded from: classes.dex */
public final class C2279i<TResult> extends Task<TResult> {

    /* renamed from: b */
    private boolean f6978b;

    /* renamed from: c */
    private volatile boolean f6979c;

    /* renamed from: d */
    private TResult f6980d;

    /* renamed from: e */
    private Exception f6981e;

    /* renamed from: a */
    private final Object f6977a = new Object();

    /* renamed from: f */
    private List<ExecuteResult<TResult>> f6982f = new ArrayList();

    /* renamed from: a */
    private Task<TResult> m6485a(ExecuteResult<TResult> executeResult) {
        boolean isComplete;
        synchronized (this.f6977a) {
            isComplete = isComplete();
            if (!isComplete) {
                this.f6982f.add(executeResult);
            }
        }
        if (isComplete) {
            executeResult.onComplete(this);
        }
        return this;
    }

    /* renamed from: b */
    private void m6486b() {
        synchronized (this.f6977a) {
            Iterator<ExecuteResult<TResult>> it = this.f6982f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onComplete(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f6982f = null;
        }
    }

    /* renamed from: a */
    public final void m6487a(Exception exc) {
        synchronized (this.f6977a) {
            if (this.f6978b) {
                return;
            }
            this.f6978b = true;
            this.f6981e = exc;
            this.f6977a.notifyAll();
            m6486b();
        }
    }

    /* renamed from: a */
    public final void m6488a(TResult tresult) {
        synchronized (this.f6977a) {
            if (this.f6978b) {
                return;
            }
            this.f6978b = true;
            this.f6980d = tresult;
            this.f6977a.notifyAll();
            m6486b();
        }
    }

    /* renamed from: a */
    public final boolean m6489a() {
        synchronized (this.f6977a) {
            if (this.f6978b) {
                return false;
            }
            this.f6978b = true;
            this.f6979c = true;
            this.f6977a.notifyAll();
            m6486b();
            return true;
        }
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        C2272b c2272b = new C2272b(TaskExecutors.uiThread(), onCanceledListener);
        FragmentC2277g.m6482a(activity, c2272b);
        return m6485a((ExecuteResult) c2272b);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(TaskExecutors.uiThread(), onCanceledListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return m6485a((ExecuteResult) new C2272b(executor, onCanceledListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        C2274d c2274d = new C2274d(TaskExecutors.uiThread(), onCompleteListener);
        FragmentC2277g.m6482a(activity, c2274d);
        return m6485a((ExecuteResult) c2274d);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.uiThread(), onCompleteListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        return m6485a((ExecuteResult) new C2274d(executor, onCompleteListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        C2276f c2276f = new C2276f(TaskExecutors.uiThread(), onFailureListener);
        FragmentC2277g.m6482a(activity, c2276f);
        return m6485a((ExecuteResult) c2276f);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.uiThread(), onFailureListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return m6485a((ExecuteResult) new C2276f(executor, onFailureListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<TResult> onSuccessListener) {
        C2278h c2278h = new C2278h(TaskExecutors.uiThread(), onSuccessListener);
        FragmentC2277g.m6482a(activity, c2278h);
        return m6485a((ExecuteResult) c2278h);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.uiThread(), onSuccessListener);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        return m6485a((ExecuteResult) new C2278h(executor, onSuccessListener));
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.uiThread(), continuation);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, final Continuation<TResult, TContinuationResult> continuation) {
        final C2279i c2279i = new C2279i();
        addOnCompleteListener(executor, new OnCompleteListener<TResult>() { // from class: com.huawei.hmf.tasks.a.i.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public final void onComplete(Task<TResult> task) {
                if (task.isCanceled()) {
                    c2279i.m6489a();
                    return;
                }
                try {
                    c2279i.m6488a((C2279i) continuation.then(task));
                } catch (Exception e2) {
                    c2279i.m6487a(e2);
                }
            }
        });
        return c2279i;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.uiThread(), continuation);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, final Continuation<TResult, Task<TContinuationResult>> continuation) {
        final C2279i c2279i = new C2279i();
        addOnCompleteListener(executor, new OnCompleteListener<TResult>() { // from class: com.huawei.hmf.tasks.a.i.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.huawei.hmf.tasks.OnCompleteListener
            public final void onComplete(Task<TResult> task) {
                try {
                    Task task2 = (Task) continuation.then(task);
                    if (task2 == 0) {
                        c2279i.m6487a((Exception) new NullPointerException("Continuation returned null"));
                    } else {
                        task2.addOnCompleteListener(new OnCompleteListener<TContinuationResult>() { // from class: com.huawei.hmf.tasks.a.i.4.1
                            @Override // com.huawei.hmf.tasks.OnCompleteListener
                            public final void onComplete(Task<TContinuationResult> task3) {
                                if (task3.isSuccessful()) {
                                    c2279i.m6488a((C2279i) task3.getResult());
                                } else if (task3.isCanceled()) {
                                    c2279i.m6489a();
                                } else {
                                    c2279i.m6487a(task3.getException());
                                }
                            }
                        });
                    }
                } catch (Exception e2) {
                    c2279i.m6487a(e2);
                }
            }
        });
        return c2279i;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.f6977a) {
            exc = this.f6981e;
        }
        return exc;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.f6977a) {
            if (this.f6981e != null) {
                throw new RuntimeException(this.f6981e);
            }
            tresult = this.f6980d;
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <E extends Throwable> TResult getResultThrowException(Class<E> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f6977a) {
            if (cls != null) {
                if (cls.isInstance(this.f6981e)) {
                    throw cls.cast(this.f6981e);
                }
            }
            if (this.f6981e != null) {
                throw new RuntimeException(this.f6981e);
            }
            tresult = this.f6980d;
        }
        return tresult;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isCanceled() {
        return this.f6979c;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.f6977a) {
            z = this.f6978b;
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.f6977a) {
            z = this.f6978b && !isCanceled() && this.f6981e == null;
        }
        return z;
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.uiThread(), successContinuation);
    }

    @Override // com.huawei.hmf.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, final SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        final C2279i c2279i = new C2279i();
        addOnSuccessListener(executor, new OnSuccessListener<TResult>() { // from class: com.huawei.hmf.tasks.a.i.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public final void onSuccess(TResult tresult) {
                try {
                    Task then = successContinuation.then(tresult);
                    if (then == 0) {
                        c2279i.m6487a((Exception) new NullPointerException("SuccessContinuation returned null"));
                    } else {
                        then.addOnCompleteListener(new OnCompleteListener<TContinuationResult>() { // from class: com.huawei.hmf.tasks.a.i.1.1
                            @Override // com.huawei.hmf.tasks.OnCompleteListener
                            public final void onComplete(Task<TContinuationResult> task) {
                                if (task.isSuccessful()) {
                                    c2279i.m6488a((C2279i) task.getResult());
                                } else if (task.isCanceled()) {
                                    c2279i.m6489a();
                                } else {
                                    c2279i.m6487a(task.getException());
                                }
                            }
                        });
                    }
                } catch (Exception e2) {
                    c2279i.m6487a(e2);
                }
            }
        });
        addOnFailureListener(new OnFailureListener() { // from class: com.huawei.hmf.tasks.a.i.2
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                c2279i.m6487a(exc);
            }
        });
        addOnCanceledListener(new OnCanceledListener() { // from class: com.huawei.hmf.tasks.a.i.3
            @Override // com.huawei.hmf.tasks.OnCanceledListener
            public final void onCanceled() {
                c2279i.m6489a();
            }
        });
        return c2279i;
    }
}
