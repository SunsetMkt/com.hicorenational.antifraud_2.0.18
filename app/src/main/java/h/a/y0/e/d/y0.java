package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableFlatMapSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y0<T, R> extends h.a.y0.e.d.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> f11711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11712c;

    /* JADX INFO: compiled from: ObservableFlatMapSingle.java */
    static final class a<T, R> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 8600231336733376951L;
        final h.a.i0<? super R> actual;
        volatile boolean cancelled;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11713d;
        final boolean delayErrors;
        final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> mapper;
        final h.a.u0.b set = new h.a.u0.b();
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<h.a.y0.f.c<R>> queue = new AtomicReference<>();

        /* JADX INFO: renamed from: h.a.y0.e.d.y0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableFlatMapSingle.java */
        final class C0222a extends AtomicReference<h.a.u0.c> implements h.a.n0<R>, h.a.u0.c {
            private static final long serialVersionUID = -502562646270949838L;

            C0222a() {
            }

            @Override // h.a.u0.c
            public void dispose() {
                h.a.y0.a.d.dispose(this);
            }

            @Override // h.a.u0.c
            public boolean isDisposed() {
                return h.a.y0.a.d.isDisposed(get());
            }

            @Override // h.a.n0
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // h.a.n0
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // h.a.n0
            public void onSuccess(R r) {
                a.this.innerSuccess(this, r);
            }
        }

        a(h.a.i0<? super R> i0Var, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.delayErrors = z;
        }

        void clear() {
            h.a.y0.f.c<R> cVar = this.queue.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.cancelled = true;
            this.f11713d.dispose();
            this.set.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            h.a.i0<? super R> i0Var = this.actual;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<h.a.y0.f.c<R>> atomicReference = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable thTerminate = this.errors.terminate();
                    clear();
                    i0Var.onError(thTerminate);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                h.a.y0.f.c<R> cVar = atomicReference.get();
                defpackage.a aVarPoll = cVar != null ? cVar.poll() : null;
                boolean z2 = aVarPoll == null;
                if (z && z2) {
                    Throwable thTerminate2 = this.errors.terminate();
                    if (thTerminate2 != null) {
                        i0Var.onError(thTerminate2);
                        return;
                    } else {
                        i0Var.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    i0Var.onNext(aVarPoll);
                }
            }
            clear();
        }

        h.a.y0.f.c<R> getOrCreateQueue() {
            h.a.y0.f.c<R> cVar;
            do {
                h.a.y0.f.c<R> cVar2 = this.queue.get();
                if (cVar2 != null) {
                    return cVar2;
                }
                cVar = new h.a.y0.f.c<>(h.a.b0.L());
            } while (!this.queue.compareAndSet(null, cVar));
            return cVar;
        }

        void innerError(a<T, R>.C0222a c0222a, Throwable th) {
            this.set.c(c0222a);
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.f11713d.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void innerSuccess(a<T, R>.C0222a c0222a, R r) {
            this.set.c(c0222a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    this.actual.onNext(r);
                    boolean z = this.active.decrementAndGet() == 0;
                    h.a.y0.f.c<R> cVar = this.queue.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        Throwable thTerminate = this.errors.terminate();
                        if (thTerminate != null) {
                            this.actual.onError(thTerminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    h.a.y0.f.c<R> orCreateQueue = getOrCreateQueue();
                    synchronized (orCreateQueue) {
                        orCreateQueue.offer(r);
                    }
                    this.active.decrementAndGet();
                    if (getAndIncrement() != 0) {
                        return;
                    }
                }
            }
            drainLoop();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }

        @Override // h.a.i0
        public void onNext(T t) {
            try {
                h.a.q0 q0Var = (h.a.q0) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null SingleSource");
                this.active.getAndIncrement();
                C0222a c0222a = new C0222a();
                if (this.cancelled || !this.set.b(c0222a)) {
                    return;
                }
                q0Var.a(c0222a);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11713d.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11713d, cVar)) {
                this.f11713d = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public y0(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar, boolean z) {
        super(g0Var);
        this.f11711b = oVar;
        this.f11712c = z;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super R> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11711b, this.f11712c));
    }
}
