package com.hihonor.cloudservice.tasks.p161q;

import java.util.concurrent.Executor;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p031c.p075c.p076a.p090d.InterfaceC1207d;
import p031c.p075c.p076a.p090d.InterfaceC1211h;

/* compiled from: ExecuteSuccessResult.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.e */
/* loaded from: classes.dex */
public final class C2144e<TResult> implements InterfaceC1207d<TResult> {

    /* renamed from: a */
    private InterfaceC1211h<TResult> f6450a;

    /* renamed from: b */
    private Executor f6451b;

    /* renamed from: c */
    private final Object f6452c = new Object();

    /* compiled from: ExecuteSuccessResult.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.e$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AbstractC1213j f6453a;

        a(AbstractC1213j abstractC1213j) {
            this.f6453a = abstractC1213j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (C2144e.this.f6452c) {
                if (C2144e.this.f6450a != null) {
                    C2144e.this.f6450a.onSuccess(this.f6453a.mo2340b());
                }
            }
        }
    }

    C2144e(Executor executor, InterfaceC1211h<TResult> interfaceC1211h) {
        this.f6451b = executor;
        this.f6450a = interfaceC1211h;
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1207d
    public void cancel() {
        synchronized (this.f6452c) {
            this.f6450a = null;
        }
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1207d
    /* renamed from: a */
    public void mo2318a(AbstractC1213j<TResult> abstractC1213j) {
        if (!abstractC1213j.mo2343e() || abstractC1213j.mo2341c()) {
            return;
        }
        this.f6451b.execute(new a(abstractC1213j));
    }
}
