package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleFlatMap.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v<T, R> extends h.a.k0<R> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> f11895b;

    /* JADX INFO: compiled from: SingleFlatMap.java */
    static final class a<T, R> extends AtomicReference<h.a.u0.c> implements h.a.n0<T>, h.a.u0.c {
        private static final long serialVersionUID = 3258103020495908596L;
        final h.a.n0<? super R> actual;
        final h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> mapper;

        /* JADX INFO: renamed from: h.a.y0.e.f.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SingleFlatMap.java */
        static final class C0229a<R> implements h.a.n0<R> {
            final AtomicReference<h.a.u0.c> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final h.a.n0<? super R> f11896b;

            C0229a(AtomicReference<h.a.u0.c> atomicReference, h.a.n0<? super R> n0Var) {
                this.a = atomicReference;
                this.f11896b = n0Var;
            }

            @Override // h.a.n0
            public void onError(Throwable th) {
                this.f11896b.onError(th);
            }

            @Override // h.a.n0
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.replace(this.a, cVar);
            }

            @Override // h.a.n0
            public void onSuccess(R r) {
                this.f11896b.onSuccess(r);
            }
        }

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

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            try {
                h.a.q0 q0Var = (h.a.q0) h.a.y0.b.b.a(this.mapper.apply(t), "The single returned by the mapper is null");
                if (isDisposed()) {
                    return;
                }
                q0Var.a(new C0229a(this, this.actual));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }
    }

    public v(h.a.q0<? extends T> q0Var, h.a.x0.o<? super T, ? extends h.a.q0<? extends R>> oVar) {
        this.f11895b = oVar;
        this.a = q0Var;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super R> n0Var) {
        this.a.a(new a(n0Var, this.f11895b));
    }
}
