package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecuteCompleteResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class c<TResult> implements d.c.a.d.d<TResult> {
    private d.c.a.d.f<TResult> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Executor f4071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4072c = new Object();

    /* JADX INFO: compiled from: ExecuteCompleteResult.java */
    class a implements Runnable {
        final /* synthetic */ d.c.a.d.j a;

        a(d.c.a.d.j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (c.this.f4072c) {
                if (c.this.a != null) {
                    c.this.a.a(this.a);
                }
            }
        }
    }

    c(Executor executor, d.c.a.d.f<TResult> fVar) {
        this.f4071b = executor;
        this.a = fVar;
    }

    @Override // d.c.a.d.d
    public void cancel() {
        synchronized (this.f4072c) {
            this.a = null;
        }
    }

    @Override // d.c.a.d.d
    public void a(d.c.a.d.j<TResult> jVar) {
        this.f4071b.execute(new a(jVar));
    }
}
