package g.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableFlatMapSingle.java */
/* loaded from: classes2.dex */
public final class y0<T, R> extends g.a.y0.e.d.a<T, R> {

    /* renamed from: b, reason: collision with root package name */
    final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> f15583b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f15584c;

    /* compiled from: ObservableFlatMapSingle.java */
    static final class a<T, R> extends AtomicInteger implements g.a.i0<T>, g.a.u0.c {
        private static final long serialVersionUID = 8600231336733376951L;
        final g.a.i0<? super R> actual;
        volatile boolean cancelled;

        /* renamed from: d, reason: collision with root package name */
        g.a.u0.c f15585d;
        final boolean delayErrors;
        final g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> mapper;
        final g.a.u0.b set = new g.a.u0.b();
        final g.a.y0.j.c errors = new g.a.y0.j.c();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<g.a.y0.f.c<R>> queue = new AtomicReference<>();

        /* compiled from: ObservableFlatMapSingle.java */
        /* renamed from: g.a.y0.e.d.y0$a$a, reason: collision with other inner class name */
        final class C0221a extends AtomicReference<g.a.u0.c> implements g.a.n0<R>, g.a.u0.c {
            private static final long serialVersionUID = -502562646270949838L;

            C0221a() {
            }

            @Override // g.a.u0.c
            public void dispose() {
                g.a.y0.a.d.dispose(this);
            }

            @Override // g.a.u0.c
            public boolean isDisposed() {
                return g.a.y0.a.d.isDisposed(get());
            }

            @Override // g.a.n0
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // g.a.n0
            public void onSubscribe(g.a.u0.c cVar) {
                g.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // g.a.n0
            public void onSuccess(R r) {
                a.this.innerSuccess(this, r);
            }
        }

        a(g.a.i0<? super R> i0Var, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.delayErrors = z;
        }

        void clear() {
            g.a.y0.f.c<R> cVar = this.queue.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        @Override // g.a.u0.c
        public void dispose() {
            this.cancelled = true;
            this.f15585d.dispose();
            this.set.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            g.a.i0<? super R> i0Var = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<g.a.y0.f.c<R>> atomicReference = this.queue;
            int i2 = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable terminate = this.errors.terminate();
                    clear();
                    i0Var.onError(terminate);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                g.a.y0.f.c<R> cVar = atomicReference.get();
                a.a.a poll = cVar != null ? cVar.poll() : null;
                boolean z2 = poll == null;
                if (z && z2) {
                    Throwable terminate2 = this.errors.terminate();
                    if (terminate2 != null) {
                        i0Var.onError(terminate2);
                        return;
                    } else {
                        i0Var.onComplete();
                        return;
                    }
                }
                if (z2) {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    i0Var.onNext(poll);
                }
            }
            clear();
        }

        g.a.y0.f.c<R> getOrCreateQueue() {
            g.a.y0.f.c<R> cVar;
            do {
                g.a.y0.f.c<R> cVar2 = this.queue.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new g.a.y0.f.c<>(g.a.b0.L());
            } while (!this.queue.compareAndSet(null, cVar));
            return cVar;
        }

        void innerError(a<T, R>.C0221a c0221a, Throwable th) {
            this.set.c(c0221a);
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.f15585d.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
        }

        void innerSuccess(a<T, R>.C0221a c0221a, R r) {
            this.set.c(c0221a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.actual.onNext(r);
                    boolean z = this.active.decrementAndGet() == 0;
                    g.a.y0.f.c<R> cVar = this.queue.get();
                    if (!z || (cVar != null && !cVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                    } else {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.actual.onError(terminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                }
            }
            g.a.y0.f.c<R> orCreateQueue = getOrCreateQueue();
            synchronized (orCreateQueue) {
                orCreateQueue.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // g.a.i0
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // g.a.i0
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.addThrowable(th)) {
                g.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }

        @Override // g.a.i0
        public void onNext(T t) {
            try {
                g.a.q0 q0Var = (g.a.q0) g.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                C0221a c0221a = new C0221a();
                if (this.cancelled || !this.set.b(c0221a)) {
                    return;
                }
                q0Var.a(c0221a);
            } catch (Throwable th) {
                g.a.v0.b.b(th);
                this.f15585d.dispose();
                onError(th);
            }
        }

        @Override // g.a.i0
        public void onSubscribe(g.a.u0.c cVar) {
            if (g.a.y0.a.d.validate(this.f15585d, cVar)) {
                this.f15585d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public y0(g.a.g0<T> g0Var, g.a.x0.o<? super T, ? extends g.a.q0<? extends R>> oVar, boolean z) {
        super(g0Var);
        this.f15583b = oVar;
        this.f15584c = z;
    }

    @Override // g.a.b0
    protected void d(g.a.i0<? super R> i0Var) {
        this.f14934a.subscribe(new a(i0Var, this.f15583b, this.f15584c));
    }
}
