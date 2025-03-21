package com.hihonor.cloudservice.tasks.p161q;

import java.util.concurrent.Executor;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p031c.p075c.p076a.p090d.InterfaceC1207d;
import p031c.p075c.p076a.p090d.InterfaceC1210g;

/* compiled from: ExecuteFailureResult.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.d */
/* loaded from: classes.dex */
public final class C2143d<TResult> implements InterfaceC1207d<TResult> {

    /* renamed from: a */
    private InterfaceC1210g f6445a;

    /* renamed from: b */
    private Executor f6446b;

    /* renamed from: c */
    private final Object f6447c = new Object();

    /* compiled from: ExecuteFailureResult.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.d$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AbstractC1213j f6448a;

        a(AbstractC1213j abstractC1213j) {
            this.f6448a = abstractC1213j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (C2143d.this.f6447c) {
                if (C2143d.this.f6445a != null) {
                    C2143d.this.f6445a.onFailure(this.f6448a.mo2336a());
                }
            }
        }
    }

    C2143d(Executor executor, InterfaceC1210g interfaceC1210g) {
        this.f6446b = executor;
        this.f6445a = interfaceC1210g;
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1207d
    public void cancel() {
        synchronized (this.f6447c) {
            this.f6445a = null;
        }
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1207d
    /* renamed from: a */
    public void mo2318a(AbstractC1213j<TResult> abstractC1213j) {
        if (abstractC1213j.mo2343e() || abstractC1213j.mo2341c()) {
            return;
        }
        this.f6446b.execute(new a(abstractC1213j));
    }
}
