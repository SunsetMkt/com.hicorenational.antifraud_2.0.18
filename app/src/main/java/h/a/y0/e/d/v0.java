package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableFlatMapCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v0<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.i> f11664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11665c;

    /* JADX INFO: compiled from: ObservableFlatMapCompletable.java */
    static final class a<T> extends h.a.y0.d.b<T> implements h.a.i0<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final h.a.i0<? super T> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11666d;
        final boolean delayErrors;
        volatile boolean disposed;
        final h.a.x0.o<? super T, ? extends h.a.i> mapper;
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        final h.a.u0.b set = new h.a.u0.b();

        /* JADX INFO: renamed from: h.a.y0.e.d.v0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableFlatMapCompletable.java */
        final class C0217a extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0217a() {
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

        a(h.a.i0<? super T> i0Var, h.a.x0.o<? super T, ? extends h.a.i> oVar, boolean z) {
            this.actual = i0Var;
            this.mapper = oVar;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // h.a.y0.c.o
        public void clear() {
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.disposed = true;
            this.f11666d.dispose();
            this.set.dispose();
        }

        void innerComplete(a<T>.C0217a c0217a) {
            this.set.c(c0217a);
            onComplete();
        }

        void innerError(a<T>.C0217a c0217a, Throwable th) {
            this.set.c(c0217a);
            onError(th);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11666d.isDisposed();
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return true;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thTerminate = this.errors.terminate();
                if (thTerminate != null) {
                    this.actual.onError(thTerminate);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                h.a.c1.a.b(th);
                return;
            }
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.actual.onError(this.errors.terminate());
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            try {
                h.a.i iVar = (h.a.i) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0217a c0217a = new C0217a();
                if (this.disposed || !this.set.b(c0217a)) {
                    return;
                }
                iVar.a(c0217a);
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11666d.dispose();
                onError(th);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11666d, cVar)) {
                this.f11666d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            return null;
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public v0(h.a.g0<T> g0Var, h.a.x0.o<? super T, ? extends h.a.i> oVar, boolean z) {
        super(g0Var);
        this.f11664b = oVar;
        this.f11665c = z;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        this.a.subscribe(new a(i0Var, this.f11664b, this.f11665c));
    }
}
