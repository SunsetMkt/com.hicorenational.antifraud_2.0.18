package p251g.p252a.p268y0.p281g;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p270b.C4600a;

/* compiled from: InstantPeriodicTask.java */
/* renamed from: g.a.y0.g.f */
/* loaded from: classes2.dex */
final class CallableC5117f implements Callable<Void>, InterfaceC4552c {

    /* renamed from: f */
    static final FutureTask<Void> f19872f = new FutureTask<>(C4600a.f17514b, null);

    /* renamed from: a */
    final Runnable f19873a;

    /* renamed from: d */
    final ExecutorService f19876d;

    /* renamed from: e */
    Thread f19877e;

    /* renamed from: c */
    final AtomicReference<Future<?>> f19875c = new AtomicReference<>();

    /* renamed from: b */
    final AtomicReference<Future<?>> f19874b = new AtomicReference<>();

    CallableC5117f(Runnable runnable, ExecutorService executorService) {
        this.f19873a = runnable;
        this.f19876d = executorService;
    }

    /* renamed from: a */
    void m18559a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f19875c.get();
            if (future2 == f19872f) {
                future.cancel(this.f19877e != Thread.currentThread());
            }
        } while (!this.f19875c.compareAndSet(future2, future));
    }

    /* renamed from: b */
    void m18560b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f19874b.get();
            if (future2 == f19872f) {
                future.cancel(this.f19877e != Thread.currentThread());
            }
        } while (!this.f19874b.compareAndSet(future2, future));
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        Future<?> andSet = this.f19875c.getAndSet(f19872f);
        if (andSet != null && andSet != f19872f) {
            andSet.cancel(this.f19877e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f19874b.getAndSet(f19872f);
        if (andSet2 == null || andSet2 == f19872f) {
            return;
        }
        andSet2.cancel(this.f19877e != Thread.currentThread());
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f19875c.get() == f19872f;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        try {
            this.f19877e = Thread.currentThread();
            try {
                this.f19873a.run();
                m18560b(this.f19876d.submit(this));
            } catch (Throwable th) {
                C4476a.m17152b(th);
            }
            return null;
        } finally {
            this.f19877e = null;
        }
    }
}
