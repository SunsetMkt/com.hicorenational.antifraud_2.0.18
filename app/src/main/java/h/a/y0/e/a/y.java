package h.a.y0.e.a;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: CompletableMerge.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y extends h.a.c {
    final j.d.b<? extends h.a.i> a;

    /* JADX INFO: renamed from: b */
    final int f10559b;

    /* JADX INFO: renamed from: c */
    final boolean f10560c;

    /* JADX INFO: compiled from: CompletableMerge.java */
    static final class a extends AtomicInteger implements h.a.q<h.a.i>, h.a.u0.c {
        private static final long serialVersionUID = -2108443387387077490L;
        final h.a.f actual;
        final boolean delayErrors;
        final int maxConcurrency;
        j.d.d s;
        final h.a.u0.b set = new h.a.u0.b();
        final h.a.y0.j.c error = new h.a.y0.j.c();

        /* JADX INFO: renamed from: h.a.y0.e.a.y$a$a */
        /* JADX INFO: compiled from: CompletableMerge.java */
        final class C0187a extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c {
            private static final long serialVersionUID = 251330541679988317L;

            C0187a() {
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

        a(h.a.f fVar, int i2, boolean z) {
            this.actual = fVar;
            this.maxConcurrency = i2;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.s.cancel();
            this.set.dispose();
        }

        void innerComplete(C0187a c0187a) {
            this.set.c(c0187a);
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
            } else {
                Throwable th = this.error.get();
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
            }
        }

        void innerError(C0187a c0187a, Throwable th) {
            this.set.c(c0187a);
            if (!this.delayErrors) {
                this.s.cancel();
                this.set.dispose();
                if (!this.error.addThrowable(th)) {
                    h.a.c1.a.b(th);
                    return;
                } else {
                    if (getAndSet(0) > 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
            }
            if (!this.error.addThrowable(th)) {
                h.a.c1.a.b(th);
            } else if (decrementAndGet() == 0) {
                this.actual.onError(this.error.terminate());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // j.d.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                if (this.error.get() != null) {
                    this.actual.onError(this.error.terminate());
                } else {
                    this.actual.onComplete();
                }
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.delayErrors) {
                if (!this.error.addThrowable(th)) {
                    h.a.c1.a.b(th);
                    return;
                } else {
                    if (decrementAndGet() == 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
            }
            this.set.dispose();
            if (!this.error.addThrowable(th)) {
                h.a.c1.a.b(th);
            } else if (getAndSet(0) > 0) {
                this.actual.onError(this.error.terminate());
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

        @Override // j.d.c
        public void onNext(h.a.i iVar) {
            getAndIncrement();
            C0187a c0187a = new C0187a();
            this.set.b(c0187a);
            iVar.a(c0187a);
        }
    }

    public y(j.d.b<? extends h.a.i> bVar, int i2, boolean z) {
        this.a = bVar;
        this.f10559b = i2;
        this.f10560c = z;
    }

    @Override // h.a.c
    public void b(h.a.f fVar) {
        this.a.subscribe(new a(fVar, this.f10559b, this.f10560c));
    }
}
