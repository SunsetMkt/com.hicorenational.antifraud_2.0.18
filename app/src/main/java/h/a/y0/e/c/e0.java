package h.a.y0.e.c;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeFlatMapSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0<T, R> extends h.a.k0<R> {
    final h.a.y<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> f11126b;

    /* JADX INFO: compiled from: MaybeFlatMapSingle.java */
    static final class a<T, R> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = 4827726964688405508L;
        final h.a.n0<? super R> actual;
        final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> mapper;

        a(h.a.n0<? super R> n0Var, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
            this.actual = n0Var;
            this.mapper = oVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            this.actual.onError(new NoSuchElementException());
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            try {
                h.a.q0 q0Var = (h.a.q0) h.a.y0.b.b.a(this.mapper.apply(t), "The mapper returned a null SingleSource");
                if (isDisposed()) {
                    return;
                }
                q0Var.a(new b(this, this.actual));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: MaybeFlatMapSingle.java */
    static final class b<R> implements h.a.n0<R> {
        final AtomicReference<h.a.u0.c> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.n0<? super R> f11127b;

        b(AtomicReference<h.a.u0.c> atomicReference, h.a.n0<? super R> n0Var) {
            this.a = atomicReference;
            this.f11127b = n0Var;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.f11127b.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.replace(this.a, cVar);
        }

        @Override // h.a.n0
        public void onSuccess(R r) {
            this.f11127b.onSuccess(r);
        }
    }

    public e0(h.a.y<T> yVar, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
        this.a = yVar;
        this.f11126b = oVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        this.a.a(new a(n0Var, this.f11126b));
    }
}
