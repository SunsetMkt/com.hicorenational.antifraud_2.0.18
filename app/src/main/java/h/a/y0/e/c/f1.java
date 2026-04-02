package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeTakeUntilMaybe.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f1<T, U> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.y<U> f11133b;

    /* JADX INFO: compiled from: MaybeTakeUntilMaybe.java */
    static final class a<T, U> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = -2187421758664251153L;
        final h.a.v<? super T> actual;
        final C0204a<U> other = new C0204a<>(this);

        /* JADX INFO: renamed from: h.a.y0.e.c.f1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaybeTakeUntilMaybe.java */
        static final class C0204a<U> extends AtomicReference<h.a.u0.c> implements h.a.v<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final a<?, U> parent;

            C0204a(a<?, U> aVar) {
                this.parent = aVar;
            }

            @Override // h.a.v
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // h.a.v
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // h.a.v
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this, cVar);
            }

            @Override // h.a.v, h.a.n0
            public void onSuccess(Object obj) {
                this.parent.otherComplete();
            }
        }

        a(h.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            h.a.y0.a.d.dispose(this.other);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            h.a.y0.a.d.dispose(this.other);
            if (getAndSet(h.a.y0.a.d.DISPOSED) != h.a.y0.a.d.DISPOSED) {
                this.actual.onComplete();
            }
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            h.a.y0.a.d.dispose(this.other);
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
            h.a.y0.a.d.dispose(this.other);
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

    public f1(h.a.y<T> yVar, h.a.y<U> yVar2) {
        super(yVar);
        this.f11133b = yVar2;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        this.f11133b.a(aVar.other);
        this.a.a(aVar);
    }
}
