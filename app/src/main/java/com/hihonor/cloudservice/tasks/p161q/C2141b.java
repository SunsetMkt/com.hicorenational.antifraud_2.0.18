package com.hihonor.cloudservice.tasks.p161q;

import java.util.concurrent.Executor;
import p031c.p075c.p076a.p090d.AbstractC1213j;
import p031c.p075c.p076a.p090d.InterfaceC1207d;
import p031c.p075c.p076a.p090d.InterfaceC1208e;

/* compiled from: ExecuteCanceledResult.java */
/* renamed from: com.hihonor.cloudservice.tasks.q.b */
/* loaded from: classes.dex */
public final class C2141b<TResult> implements InterfaceC1207d<TResult> {

    /* renamed from: a */
    private InterfaceC1208e f6436a;

    /* renamed from: b */
    private Executor f6437b;

    /* renamed from: c */
    private final Object f6438c = new Object();

    /* compiled from: ExecuteCanceledResult.java */
    /* renamed from: com.hihonor.cloudservice.tasks.q.b$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (C2141b.this.f6438c) {
                if (C2141b.this.f6436a != null) {
                    C2141b.this.f6436a.onCanceled();
                }
            }
        }
    }

    C2141b(Executor executor, InterfaceC1208e interfaceC1208e) {
        this.f6436a = interfaceC1208e;
        this.f6437b = executor;
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1207d
    public void cancel() {
        synchronized (this.f6438c) {
            this.f6436a = null;
        }
    }

    @Override // p031c.p075c.p076a.p090d.InterfaceC1207d
    /* renamed from: a */
    public void mo2318a(AbstractC1213j<TResult> abstractC1213j) {
        if (abstractC1213j.mo2341c()) {
            this.f6437b.execute(new a());
        }
    }
}
