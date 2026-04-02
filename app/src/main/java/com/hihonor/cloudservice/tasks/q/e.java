package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecuteSuccessResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<TResult> implements d.c.a.d.d<TResult> {
    private d.c.a.d.h<TResult> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f4077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4078c = new Object();

    /* JADX INFO: compiled from: ExecuteSuccessResult.java */
    class a implements Runnable {
        final /* synthetic */ d.c.a.d.j a;

        a(d.c.a.d.j jVar) {
            this.a = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (e.this.f4078c) {
                if (e.this.a != null) {
                    e.this.a.onSuccess(this.a.b());
                }
            }
        }
    }

    e(Executor executor, d.c.a.d.h<TResult> hVar) {
        this.f4077b = executor;
        this.a = hVar;
    }

    @Override // d.c.a.d.d
    public void cancel() {
        synchronized (this.f4078c) {
            this.a = null;
        }
    }

    @Override // d.c.a.d.d
    public void a(d.c.a.d.j<TResult> jVar) {
        if (!jVar.e() || jVar.c()) {
            return;
        }
        this.f4077b.execute(new a(jVar));
    }
}
