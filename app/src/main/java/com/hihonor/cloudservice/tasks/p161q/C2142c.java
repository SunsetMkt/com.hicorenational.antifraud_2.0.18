package com.hihonor.cloudservice.tasks.p161q;

import java.util.concurrent.Executor;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p031c.p075c.p076a.p090d.InterfaceC1207d;
import p031c.p075c.p076a.p090d.InterfaceC1209f;

/* compiled from: ExecuteCompleteResult.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.c */
/* loaded from: classes.dex */
public final class C2142c<TResult> implements InterfaceC1207d<TResult> {

    /* renamed from: a */
    private InterfaceC1209f<TResult> f6440a;

    /* renamed from: b */
    Executor f6441b;

    /* renamed from: c */
    private final Object f6442c = new Object();

    /* compiled from: ExecuteCompleteResult.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.c$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AbstractC1213j f6443a;

        a(AbstractC1213j abstractC1213j) {
            this.f6443a = abstractC1213j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (C2142c.this.f6442c) {
                if (C2142c.this.f6440a != null) {
                    C2142c.this.f6440a.mo2319a(this.f6443a);
                }
            }
        }
    }

    C2142c(Executor executor, InterfaceC1209f<TResult> interfaceC1209f) {
        this.f6441b = executor;
        this.f6440a = interfaceC1209f;
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1207d
    public void cancel() {
        synchronized (this.f6442c) {
            this.f6440a = null;
        }
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1207d
    /* renamed from: a */
    public void mo2318a(AbstractC1213j<TResult> abstractC1213j) {
        this.f6441b.execute(new a(abstractC1213j));
    }
}
