package h.a.y0.g;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: InstantPeriodicTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements Callable<Void>, h.a.u0.c {

    /* JADX INFO: renamed from: f */
    static final FutureTask<Void> f11943f = new FutureTask<>(h.a.y0.b.a.f10446b, null);
    final Runnable a;

    /* JADX INFO: renamed from: d */
    final ExecutorService f11946d;

    /* JADX INFO: renamed from: e */
    Thread f11947e;

    /* JADX INFO: renamed from: c */
    final AtomicReference<Future<?>> f11945c = new AtomicReference<>();

    /* JADX INFO: renamed from: b */
    final AtomicReference<Future<?>> f11944b = new AtomicReference<>();

    f(Runnable runnable, ExecutorService executorService) {
        this.a = runnable;
        this.f11946d = executorService;
    }

    void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f11945c.get();
            if (future2 == f11943f) {
                future.cancel(this.f11947e != Thread.currentThread());
            }
        } while (!this.f11945c.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f11944b.get();
            if (future2 == f11943f) {
                future.cancel(this.f11947e != Thread.currentThread());
            }
        } while (!this.f11944b.compareAndSet(future2, future));
    }

    @Override // h.a.u0.c
    public void dispose() {
        Future<?> andSet = this.f11945c.getAndSet(f11943f);
        if (andSet != null && andSet != f11943f) {
            andSet.cancel(this.f11947e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f11944b.getAndSet(f11943f);
        if (andSet2 == null || andSet2 == f11943f) {
            return;
        }
        andSet2.cancel(this.f11947e != Thread.currentThread());
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f11945c.get() == f11943f;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.f11947e = Thread.currentThread();
            try {
                this.a.run();
                b(this.f11946d.submit(this));
            } catch (Throwable th) {
                h.a.c1.a.b(th);
            }
            return null;
        } finally {
            this.f11947e = null;
        }
    }
}
