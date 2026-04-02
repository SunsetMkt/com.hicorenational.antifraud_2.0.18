package h.a.y0.e.f;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleTakeUntil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n0<T, U> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j.d.b<U> f11863b;

    /* JADX INFO: compiled from: SingleTakeUntil.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, h.a.u0.c {
        private static final long serialVersionUID = -622603812305745221L;
        final h.a.n0<? super T> actual;
        final b other = new b(this);

        a(h.a.n0<? super T> n0Var) {
            this.actual = n0Var;
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
            this.other.dispose();
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || getAndSet(dVar) == h.a.y0.a.d.DISPOSED) {
                h.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.other.dispose();
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || getAndSet(dVar) == h.a.y0.a.d.DISPOSED) {
                return;
            }
            this.actual.onSuccess(t);
        }

        void otherError(Throwable th) {
            h.a.u0.c andSet;
            h.a.u0.c cVar = get();
            h.a.y0.a.d dVar = h.a.y0.a.d.DISPOSED;
            if (cVar == dVar || (andSet = getAndSet(dVar)) == h.a.y0.a.d.DISPOSED) {
                h.a.c1.a.b(th);
                return;
            }
            if (andSet != null) {
                andSet.dispose();
            }
            this.actual.onError(th);
        }
    }

    /* JADX INFO: compiled from: SingleTakeUntil.java */
    static final class b extends AtomicReference<j.d.d> implements h.a.q<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        final a<?> parent;

        b(a<?> aVar) {
            this.parent = aVar;
        }

        public void dispose() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // j.d.c
        public void onComplete() {
            j.d.d dVar = get();
            h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
            if (dVar != jVar) {
                lazySet(jVar);
                this.parent.otherError(new CancellationException());
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.parent.otherError(th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            if (h.a.y0.i.j.cancel(this)) {
                this.parent.otherError(new CancellationException());
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public n0(h.a.q0<T> q0Var, j.d.b<U> bVar) {
        this.a = q0Var;
        this.f11863b = bVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        a aVar = new a(n0Var);
        n0Var.onSubscribe(aVar);
        this.f11863b.subscribe(aVar.other);
        this.a.a(aVar);
    }
}
