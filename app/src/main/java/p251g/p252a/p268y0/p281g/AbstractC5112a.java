package p251g.p252a.p268y0.p281g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p270b.C4600a;

/* compiled from: AbstractDirectTask.java */
/* renamed from: g.a.y0.g.a */
/* loaded from: classes2.dex */
abstract class AbstractC5112a extends AtomicReference<Future<?>> implements InterfaceC4552c {
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;
    protected static final FutureTask<Void> FINISHED = new FutureTask<>(C4600a.f17514b, null);
    protected static final FutureTask<Void> DISPOSED = new FutureTask<>(C4600a.f17514b, null);

    AbstractC5112a(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == FINISHED || future == (futureTask = DISPOSED) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.runner != Thread.currentThread());
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == FINISHED || future == DISPOSED;
    }

    public final void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == FINISHED) {
                return;
            }
            if (future2 == DISPOSED) {
                future.cancel(this.runner != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
