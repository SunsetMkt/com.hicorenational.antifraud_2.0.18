package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableConcatMapCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w<T> extends h.a.c {
    final h.a.g0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.i> f11684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f11685c;

    /* JADX INFO: compiled from: ObservableConcatMapCompletable.java */
    static final class a<T> extends AtomicInteger implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 6893587405571511048L;
        volatile boolean active;
        final h.a.f actual;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final C0218a inner;
        final h.a.x0.o<? super T, ? extends h.a.i> mapper;
        h.a.y0.c.o<T> queue;
        h.a.u0.c s;
        int sourceMode;

        /* JADX INFO: renamed from: h.a.y0.e.d.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableConcatMapCompletable.java */
        static final class C0218a extends AtomicReference<h.a.u0.c> implements h.a.f {
            private static final long serialVersionUID = -5987419458390772447L;
            final h.a.f actual;
            final a<?> parent;

            C0218a(h.a.f fVar, a<?> aVar) {
                this.actual = fVar;
                this.parent = aVar;
            }

            void dispose() {
                h.a.y0.a.d.dispose(this);
            }

            @Override // h.a.f
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // h.a.f
            public void onError(Throwable th) {
                this.parent.dispose();
                this.actual.onError(th);
            }

            @Override // h.a.f
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.set(this, cVar);
            }
        }

        a(h.a.f fVar, h.a.x0.o<? super T, ? extends h.a.i> oVar, int i2) {
            this.actual = fVar;
            this.mapper = oVar;
            this.bufferSize = i2;
            this.inner = new C0218a(fVar, this);
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
                                h.a.i iVar = (h.a.i) h.a.y0.b.b.a(this.mapper.apply(tPoll), "The mapper returned a null CompletableSource");
                                this.active = true;
                                iVar.a(this.inner);
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
            if (this.sourceMode == 0) {
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

    public w(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.i> oVar, int i2) {
        this.a = g0Var;
        this.f11684b = oVar;
        this.f11685c = Math.max(8, i2);
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        this.a.subscribe(new a(fVar, this.f11684b, this.f11685c));
    }
}
