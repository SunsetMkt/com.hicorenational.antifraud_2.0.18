package h.a.y0.e.d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableConcatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v<T, U> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> f11660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f11661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.y0.j.j f11662d;

    /* JADX INFO: compiled from: ObservableConcatMap.java */
    static final class a<T, R> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final h.a.i0<? super R> actual;
        final int bufferSize;
        volatile boolean cancelled;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11663d;
        volatile boolean done;
        final h.a.y0.j.c error = new h.a.y0.j.c();
        final h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> mapper;
        final C0216a<R> observer;
        h.a.y0.c.o<T> queue;
        int sourceMode;
        final boolean tillTheEnd;

        /* JADX INFO: renamed from: h.a.y0.e.d.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableConcatMap.java */
        static final class C0216a<R> extends AtomicReference<h.a.u0.c> implements h.a.i0<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final h.a.i0<? super R> actual;
            final a<?, R> parent;

            C0216a(h.a.i0<? super R> i0Var, a<?, R> aVar) {
                this.actual = i0Var;
                this.parent = aVar;
            }

            void dispose() {
                h.a.y0.a.d.dispose(this);
            }

            @Override // h.a.i0
            public void onComplete() {
                a<?, R> aVar = this.parent;
                aVar.active = false;
                aVar.drain();
            }

            @Override // h.a.i0
            public void onError(Throwable th) {
                a<?, R> aVar = this.parent;
                if (!aVar.error.addThrowable(th)) {
                    h.a.c1.a.b(th);
                    return;
                }
                if (!aVar.tillTheEnd) {
                    aVar.f11663d.dispose();
                }
                aVar.active = false;
                aVar.drain();
            }

            @Override // h.a.i0
            public void onNext(R r) {
                this.actual.onNext(r);
            }

            @Override // h.a.i0
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.replace(this, cVar);
            }
        }

        a(h.a.i0<? super R> i0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends R>> oVar, int i2, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.tillTheEnd = z;
            this.observer = new C0216a<>(i0Var, this);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.cancelled = true;
            this.f11663d.dispose();
            this.observer.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.i0<? super R> i0Var = this.actual;
            h.a.y0.c.o<T> oVar = this.queue;
            h.a.y0.j.c cVar = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        oVar.clear();
                        return;
                    }
                    if (!this.tillTheEnd && cVar.get() != null) {
                        oVar.clear();
                        this.cancelled = true;
                        i0Var.onError(cVar.terminate());
                        return;
                    }
                    boolean z = this.done;
                    try {
                        T tPoll = oVar.poll();
                        boolean z2 = tPoll == null;
                        if (z && z2) {
                            this.cancelled = true;
                            Throwable thTerminate = cVar.terminate();
                            if (thTerminate != null) {
                                i0Var.onError(thTerminate);
                                return;
                            } else {
                                i0Var.onComplete();
                                return;
                            }
                        }
                        if (!z2) {
                            try {
                                h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                                if (g0Var instanceof Callable) {
                                    try {
                                        defpackage.a aVar = (Object) ((Callable) g0Var).call();
                                        if (aVar != null && !this.cancelled) {
                                            i0Var.onNext(aVar);
                                        }
                                    } catch (Throwable th) {
                                        h.a.v0.b.b(th);
                                        cVar.addThrowable(th);
                                    }
                                } else {
                                    this.active = true;
                                    g0Var.subscribe(this.observer);
                                }
                            } catch (Throwable th2) {
                                h.a.v0.b.b(th2);
                                this.cancelled = true;
                                this.f11663d.dispose();
                                oVar.clear();
                                cVar.addThrowable(th2);
                                i0Var.onError(cVar.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        h.a.v0.b.b(th3);
                        this.cancelled = true;
                        this.f11663d.dispose();
                        cVar.addThrowable(th3);
                        i0Var.onError(cVar.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                h.a.c1.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11663d, cVar)) {
                this.f11663d = cVar;
                if (cVar instanceof h.a.y0.c.j) {
                    h.a.y0.c.j jVar = (h.a.y0.c.j) cVar;
                    int iRequestFusion = jVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = jVar;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.c(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableConcatMap.java */
    static final class b<T, U> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final h.a.i0<? super U> actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        int fusionMode;
        final a<U> inner;
        final h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> mapper;
        h.a.y0.c.o<T> queue;
        h.a.u0.c s;

        /* JADX INFO: compiled from: ObservableConcatMap.java */
        static final class a<U> extends AtomicReference<h.a.u0.c> implements h.a.i0<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final h.a.i0<? super U> actual;
            final b<?, ?> parent;

            a(h.a.i0<? super U> i0Var, b<?, ?> bVar) {
                this.actual = i0Var;
                this.parent = bVar;
            }

            void dispose() {
                h.a.y0.a.d.dispose(this);
            }

            @Override // h.a.i0
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // h.a.i0
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // h.a.i0
            public void onNext(U u) {
                this.actual.onNext(u);
            }

            @Override // h.a.i0
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.set(this, cVar);
            }
        }

        b(h.a.i0<? super U> i0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> oVar, int i2) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.inner = new a<>(i0Var, this);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.s.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T tPoll = this.queue.poll();
                        boolean z2 = tPoll == null;
                        if (z && z2) {
                            this.disposed = true;
                            this.actual.onComplete();
                            return;
                        } else if (!z2) {
                            try {
                                h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null ObservableSource");
                                this.active = true;
                                g0Var.subscribe(this.inner);
                            } catch (Throwable th) {
                                h.a.v0.b.b(th);
                                dispose();
                                this.queue.clear();
                                this.actual.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        h.a.v0.b.b(th2);
                        dispose();
                        this.queue.clear();
                        this.actual.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.done = true;
            dispose();
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                if (cVar instanceof h.a.y0.c.j) {
                    h.a.y0.c.j jVar = (h.a.y0.c.j) cVar;
                    int iRequestFusion = jVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = jVar;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = jVar;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.c(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }
    }

    public v(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.g0<? extends U>> oVar, int i2, h.a.y0.j.j jVar) {
        super(g0Var);
        this.f11660b = oVar;
        this.f11662d = jVar;
        this.f11661c = Math.max(8, i2);
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super U> i0Var) {
        if (s2.a(this.a, i0Var, this.f11660b)) {
            return;
        }
        h.a.y0.j.j jVar = this.f11662d;
        if (jVar == h.a.y0.j.j.IMMEDIATE) {
            this.a.subscribe(new b(new h.a.a1.m(i0Var), this.f11660b, this.f11661c));
        } else {
            this.a.subscribe(new a(i0Var, this.f11660b, this.f11661c, jVar == h.a.y0.j.j.END));
        }
    }
}
