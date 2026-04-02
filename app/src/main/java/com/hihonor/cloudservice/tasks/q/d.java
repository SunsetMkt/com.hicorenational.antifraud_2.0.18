package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecuteFailureResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class d<TResult> implements d.c.a.d.d<TResult> {
    private d.c.a.d.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f4074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4075c = new Object();

    /* JADX INFO: compiled from: ExecuteFailureResult.java */
    class a implements Runnable {
        final /* synthetic */ d.c.a.d.j a;

        a(d.c.a.d.j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (d.this.f4075c) {
                if (d.this.a != null) {
                    d.this.a.onFailure(this.a.a());
                }
            }
        }
    }

    d(Executor executor, d.c.a.d.g gVar) {
        this.f4074b = executor;
        this.a = gVar;
    }

    @Override // d.c.a.d.d
    public void cancel() {
        synchronized (this.f4075c) {
            this.a = null;
        }
    }

    @Override // d.c.a.d.d
    public void a(d.c.a.d.j<TResult> jVar) {
        if (jVar.e() || jVar.c()) {
            return;
        }
        this.f4074b.execute(new a(jVar));
    }
}
