package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i<Void> f4367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Exception f4369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4370f;

    e(int i2, i<Void> iVar) {
        this.f4366b = i2;
        this.f4367c = iVar;
    }

    private void a() {
        if (this.f4368d >= this.f4366b) {
            Exception exc = this.f4369e;
            if (exc != null) {
                this.f4367c.a(new ExecutionException("a task failed", exc));
            } else if (this.f4370f) {
                this.f4367c.a();
            } else {
                this.f4367c.a((Void) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.a) {
            this.f4368d++;
            this.f4370f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.a) {
            this.f4368d++;
            this.f4369e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.a) {
            this.f4368d++;
            a();
        }
    }
}
