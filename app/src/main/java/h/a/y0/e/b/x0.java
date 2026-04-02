package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableFlatMapCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x0<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.i> f11040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f11041d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f11042e;

    /* JADX INFO: compiled from: FlowableFlatMapCompletable.java */
    static final class a<T> extends h.a.y0.i.c<T> implements h.a.q<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        final boolean delayErrors;
        final h.a.x0.o<? super T, ? extends h.a.i> mapper;
        final int maxConcurrency;
        j.d.d s;
        final h.a.y0.j.c errors = new h.a.y0.j.c();
        final h.a.u0.b set = new h.a.u0.b();

        /* JADX INFO: renamed from: h.a.y0.e.b.x0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableFlatMapCompletable.java */
        final class C0197a extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c {
            private static final long serialVersionUID = 8606673141535671828L;

            C0197a() {
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

        a(j.d.c<? super T> cVar, h.a.x0.o<? super T, ? extends h.a.i> oVar, boolean z, int i2) {
            this.actual = cVar;
            this.mapper = oVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            lazySet(1);
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            this.set.dispose();
        }

        @Override // h.a.y0.c.o
        public void clear() {
        }

        void innerComplete(a<T>.C0197a c0197a) {
            this.set.c(c0197a);
            onComplete();
        }

        void innerError(a<T>.C0197a c0197a, Throwable th) {
            this.set.c(c0197a);
            onError(th);
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return true;
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
                cancel();
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
                C0197a c0197a = new C0197a();
                if (this.cancelled || !this.set.b(c0197a)) {
                    return;
                }
                iVar.a(c0197a);
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

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() throws Exception {
            return null;
        }

        @Override // j.d.d
        public void request(long j2) {
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            return i2 & 2;
        }
    }

    public x0(h.a.l<T> lVar, h.a.x0.o<? super T, ? extends h.a.i> oVar, boolean z, int i2) {
        super(lVar);
        this.f11040c = oVar;
        this.f11042e = z;
        this.f11041d = i2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10561b.a((h.a.q) new a(cVar, this.f11040c, this.f11042e, this.f11041d));
    }
}
