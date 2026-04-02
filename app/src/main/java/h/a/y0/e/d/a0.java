package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableCreate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0<T> extends h.a.b0<T> {
    final h.a.e0<T> a;

    /* JADX INFO: compiled from: ObservableCreate.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.d0<T>, h.a.u0.c {
        private static final long serialVersionUID = -3434801548987643227L;
        final h.a.i0<? super T> observer;

        a(h.a.i0<? super T> i0Var) {
            this.observer = i0Var;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.d0, h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.k
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // h.a.k
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            h.a.c1.a.b(th);
        }

        @Override // h.a.k
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t);
            }
        }

        @Override // h.a.d0
        public h.a.d0<T> serialize() {
            return new b(this);
        }

        @Override // h.a.d0
        public void setCancellable(h.a.x0.f fVar) {
            setDisposable(new h.a.y0.a.b(fVar));
        }

        @Override // h.a.d0
        public void setDisposable(h.a.u0.c cVar) {
            h.a.y0.a.d.set(this, cVar);
        }

        @Override // h.a.d0
        public boolean tryOnError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: ObservableCreate.java */
    static final class b<T> extends AtomicInteger implements h.a.d0<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final h.a.d0<T> emitter;
        final h.a.y0.j.c error = new h.a.y0.j.c();
        final h.a.y0.f.c<T> queue = new h.a.y0.f.c<>(16);

        b(h.a.d0<T> d0Var) {
            this.emitter = d0Var;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            h.a.d0<T> d0Var = this.emitter;
            h.a.y0.f.c<T> cVar = this.queue;
            h.a.y0.j.c cVar2 = this.error;
            int iAddAndGet = 1;
            while (!d0Var.isDisposed()) {
                if (cVar2.get() != null) {
                    cVar.clear();
                    d0Var.onError(cVar2.terminate());
                    return;
                }
                boolean z = this.done;
                T tPoll = cVar.poll();
                boolean z2 = tPoll == null;
                if (z && z2) {
                    d0Var.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    d0Var.onNext(tPoll);
                }
            }
            cVar.clear();
        }

        @Override // h.a.d0, h.a.u0.c
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // h.a.k
        public void onComplete() {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // h.a.k
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            h.a.c1.a.b(th);
        }

        @Override // h.a.k
        public void onNext(T t) {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                h.a.y0.f.c<T> cVar = this.queue;
                synchronized (cVar) {
                    cVar.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // h.a.d0
        public h.a.d0<T> serialize() {
            return this;
        }

        @Override // h.a.d0
        public void setCancellable(h.a.x0.f fVar) {
            this.emitter.setCancellable(fVar);
        }

        @Override // h.a.d0
        public void setDisposable(h.a.u0.c cVar) {
            this.emitter.setDisposable(cVar);
        }

        @Override // h.a.d0
        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isDisposed() && !this.done) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public a0(h.a.e0<T> e0Var) {
        this.a = e0Var;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var);
        i0Var.onSubscribe(aVar);
        try {
            this.a.a(aVar);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            aVar.onError(th);
        }
    }
}
