package h.a.y0.d;

import h.a.i0;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FutureObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T> extends CountDownLatch implements i0<T>, Future<T>, h.a.u0.c {
    T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f10477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<h.a.u0.c> f10478c;

    public r() {
        super(1);
        this.f10478c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        h.a.u0.c cVar;
        h.a.y0.a.d dVar;
        do {
            cVar = this.f10478c.get();
            if (cVar == this || cVar == (dVar = h.a.y0.a.d.DISPOSED)) {
                return false;
            }
        } while (!this.f10478c.compareAndSet(cVar, dVar));
        if (cVar != null) {
            cVar.dispose();
        }
        countDown();
        return true;
    }

    @Override // h.a.u0.c
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            h.a.y0.j.e.a();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f10477b;
        if (th == null) {
            return this.a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return h.a.y0.a.d.isDisposed(this.f10478c.get());
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // h.a.i0
    public void onComplete() {
        h.a.u0.c cVar;
        if (this.a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            cVar = this.f10478c.get();
            if (cVar == this || cVar == h.a.y0.a.d.DISPOSED) {
                return;
            }
        } while (!this.f10478c.compareAndSet(cVar, this));
        countDown();
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        h.a.u0.c cVar;
        if (this.f10477b != null) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10477b = th;
        do {
            cVar = this.f10478c.get();
            if (cVar == this || cVar == h.a.y0.a.d.DISPOSED) {
                h.a.c1.a.b(th);
                return;
            }
        } while (!this.f10478c.compareAndSet(cVar, this));
        countDown();
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (this.a == null) {
            this.a = t;
        } else {
            this.f10478c.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        h.a.y0.a.d.setOnce(this.f10478c, cVar);
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (getCount() != 0) {
            h.a.y0.j.e.a();
            if (!await(j2, timeUnit)) {
                throw new TimeoutException();
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f10477b;
            if (th == null) {
                return this.a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
