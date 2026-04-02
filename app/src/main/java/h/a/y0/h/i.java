package h.a.y0.h;

import i.q2.t.m0;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FutureSubscriber.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i<T> extends CountDownLatch implements h.a.q<T>, Future<T>, j.d.d {
    T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f12016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<j.d.d> f12017c;

    public i() {
        super(1);
        this.f12017c = new AtomicReference<>();
    }

    @Override // j.d.d
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        j.d.d dVar;
        h.a.y0.i.j jVar;
        do {
            dVar = this.f12017c.get();
            if (dVar == this || dVar == (jVar = h.a.y0.i.j.CANCELLED)) {
                return false;
            }
        } while (!this.f12017c.compareAndSet(dVar, jVar));
        if (dVar != null) {
            dVar.cancel();
        }
        countDown();
        return true;
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
        Throwable th = this.f12016b;
        if (th == null) {
            return this.a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return h.a.y0.i.j.isCancelled(this.f12017c.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // j.d.c
    public void onComplete() {
        j.d.d dVar;
        if (this.a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            dVar = this.f12017c.get();
            if (dVar == this || dVar == h.a.y0.i.j.CANCELLED) {
                return;
            }
        } while (!this.f12017c.compareAndSet(dVar, this));
        countDown();
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        j.d.d dVar;
        do {
            dVar = this.f12017c.get();
            if (dVar == this || dVar == h.a.y0.i.j.CANCELLED) {
                h.a.c1.a.b(th);
                return;
            }
            this.f12016b = th;
        } while (!this.f12017c.compareAndSet(dVar, this));
        countDown();
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (this.a == null) {
            this.a = t;
        } else {
            this.f12017c.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (h.a.y0.i.j.setOnce(this.f12017c, dVar)) {
            dVar.request(m0.f12222b);
        }
    }

    @Override // j.d.d
    public void request(long j2) {
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
            Throwable th = this.f12016b;
            if (th == null) {
                return this.a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
