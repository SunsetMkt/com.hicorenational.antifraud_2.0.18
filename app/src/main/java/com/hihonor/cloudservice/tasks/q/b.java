package com.hihonor.cloudservice.tasks.q;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ExecuteCanceledResult.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<TResult> implements d.c.a.d.d<TResult> {
    private d.c.a.d.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f4069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4070c = new Object();

    /* JADX INFO: compiled from: ExecuteCanceledResult.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (b.this.f4070c) {
                if (b.this.a != null) {
                    b.this.a.onCanceled();
                }
            }
        }
    }

    b(Executor executor, d.c.a.d.e eVar) {
        this.a = eVar;
        this.f4069b = executor;
    }

    @Override // d.c.a.d.d
    public void cancel() {
        synchronized (this.f4070c) {
            this.a = null;
        }
    }

    @Override // d.c.a.d.d
    public void a(d.c.a.d.j<TResult> jVar) {
        if (jVar.c()) {
            this.f4069b.execute(new a());
        }
    }
}
