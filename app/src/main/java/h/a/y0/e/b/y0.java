package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableFlatMapCompletableCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y0<T> extends h.a.c implements h.a.y0.c.b<T> {
    final h.a.l<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.i> f11068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f11069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f11070d;

    /* JADX INFO: compiled from: FlowableFlatMapCompletableCompletable.java */
    static final class a<T> extends AtomicInteger implements h.a.q<T>, h.a.u0.c {
        private static final long serialVersionUID = 8443155186132538303L;
        final h.a.f actual;
        final boolean delayErrors;
        volatile boolean disposed;
        final h.a.x0.o<? super T, ? extends h.a.i> mapper;
        final int maxConcurrency;
        j.d.d s;
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        final h.a.u0.b set = new h.a.u0.b();

        /* JADX INFO: renamed from: h.a.y0.e.b.y0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableFlatMapCompletableCompletable.java */
        final class C0198a extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0198a() {
            }

            @Override // h.a.u0.c
            public void dispose() {
                h.a.y0.a.d.dispose(this);
            }

            @Override // h.a.u0.c
            public boolean isDisposed() {
                return h.a.y0.a.d.isDisposed(get());
            }

            @Override // h.a.f
            public void onComplete() {
                a.this.innerComplete(this);
            }

            @Override // h.a.f
            public void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            @Override // h.a.f
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this, cVar);
            }
        }

        a(h.a.f fVar, h.a.x0.o<? super T, ? extends h.a.i> oVar, boolean z, int i2) {
            this.actual = fVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            lazySet(1);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.disposed = true;
            this.s.cancel();
            this.set.dispose();
        }

        void innerComplete(a<T>.C0198a c0198a) {
            this.set.c(c0198a);
            onComplete();
        }

        void innerError(a<T>.C0198a c0198a, Throwable th) {
            this.set.c(c0198a);
            onError(th);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // j.d.c
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
            } else {
                Throwable thTerminate = this.errors.terminate();
                if (thTerminate != null) {
                    this.actual.onError(thTerminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            if (decrementAndGet() == 0) {
                this.actual.onError(this.errors.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            try {
                h.a.i iVar = (h.a.i) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0198a c0198a = new C0198a();
                if (this.disposed || !this.set.b(c0198a)) {
                    return;
                }
                iVar.a(c0198a);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    dVar.request(i.q2.t.m0.f12222b);
                } else {
                    dVar.request(i2);
                }
            }
        }
    }

    public y0(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends h.a.i> oVar, boolean z, int i2) {
        this.a = lVar;
        this.f11068b = oVar;
        this.f11070d = z;
        this.f11069c = i2;
    }

    @Override // h.a.c
    protected void b(h.a.f fVar) {
        this.a.a((h.a.q) new a(fVar, this.f11068b, this.f11070d, this.f11069c));
    }

    @Override // h.a.y0.c.b
    public h.a.l<T> b() {
        return h.a.c1.a.a(new x0(this.a, this.f11068b, this.f11070d, this.f11069c));
    }
}
