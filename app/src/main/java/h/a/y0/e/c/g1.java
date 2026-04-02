package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeTakeUntilPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g1<T, U> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<U> f11137b;

    /* JADX INFO: compiled from: MaybeTakeUntilPublisher.java */
    static final class a<T, U> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = -2187421758664251153L;
        final h.a.v<? super T> actual;
        final C0206a<U> other = new C0206a<>(this);

        /* JADX INFO: renamed from: h.a.y0.e.c.g1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaybeTakeUntilPublisher.java */
        static final class C0206a<U> extends AtomicReference<j.d.d> implements h.a.q<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final a<?, U> parent;

            C0206a(a<?, U> aVar) {
                this.parent = aVar;
            }

            @Override // j.d.c
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // j.d.c
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // j.d.c
            public void onNext(Object obj) {
                this.parent.otherComplete();
            }

            @Override // h.a.q
            public void onSubscribe(j.d.d dVar) {
                if (h.a.y0.i.j.setOnce(this, dVar)) {
                    dVar.request(i.q2.t.m0.f12222b);
                }
            }
        }

        a(h.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            h.a.y0.i.j.cancel(this.other);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            h.a.y0.i.j.cancel(this.other);
            if (getAndSet(h.a.y0.a.d.DISPOSED) != h.a.y0.a.d.DISPOSED) {
                this.actual.onComplete();
            }
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            h.a.y0.i.j.cancel(this.other);
            if (getAndSet(h.a.y0.a.d.DISPOSED) != h.a.y0.a.d.DISPOSED) {
                this.actual.onError(th);
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            h.a.y0.i.j.cancel(this.other);
            if (getAndSet(h.a.y0.a.d.DISPOSED) != h.a.y0.a.d.DISPOSED) {
                this.actual.onSuccess(t);
            }
        }

        void otherComplete() {
            if (h.a.y0.a.d.dispose(this)) {
                this.actual.onComplete();
            }
        }

        void otherError(Throwable th) {
            if (h.a.y0.a.d.dispose(this)) {
                this.actual.onError(th);
            } else {
                h.a.c1.a.b(th);
            }
        }
    }

    public g1(h.a.y<T> yVar, j.d.b<U> bVar) {
        super(yVar);
        this.f11137b = bVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        this.f11137b.subscribe(aVar.other);
        this.a.a(aVar);
    }
}
