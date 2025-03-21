package com.huawei.hmf.tasks.p170a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* renamed from: com.huawei.hmf.tasks.a.e */
/* loaded from: classes.dex */
final class C2275e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a */
    private final Object f6959a = new Object();

    /* renamed from: b */
    private final int f6960b;

    /* renamed from: c */
    private final C2279i<Void> f6961c;

    /* renamed from: d */
    private int f6962d;

    /* renamed from: e */
    private Exception f6963e;

    /* renamed from: f */
    private boolean f6964f;

    C2275e(int i2, C2279i<Void> c2279i) {
        this.f6960b = i2;
        this.f6961c = c2279i;
    }

    /* renamed from: a */
    private void m6477a() {
        if (this.f6962d >= this.f6960b) {
            Exception exc = this.f6963e;
            if (exc != null) {
                this.f6961c.m6487a(new ExecutionException("a task failed", exc));
            } else if (this.f6964f) {
                this.f6961c.m6489a();
            } else {
                this.f6961c.m6488a((C2279i<Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f6959a) {
            this.f6962d++;
            this.f6964f = true;
            m6477a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f6959a) {
            this.f6962d++;
            this.f6963e = exc;
            m6477a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.f6959a) {
            this.f6962d++;
            m6477a();
        }
    }
}
