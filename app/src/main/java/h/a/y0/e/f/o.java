package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleDoOnDispose.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.a f11864b;

    /* JADX INFO: compiled from: SingleDoOnDispose.java */
    static final class a<T> extends AtomicReference<h.a.x0.a> implements h.a.n0<T>, h.a.u0.c {
        private static final long serialVersionUID = -8583764624474935784L;
        final h.a.n0<? super T> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11865d;

        a(h.a.n0<? super T> n0Var, h.a.x0.a aVar) {
            this.actual = n0Var;
            lazySet(aVar);
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.x0.a andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
                this.f11865d.dispose();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11865d.isDisposed();
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11865d, cVar)) {
                this.f11865d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public o(h.a.q0<T> q0Var, h.a.x0.a aVar) {
        this.a = q0Var;
        this.f11864b = aVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.a.a(new a(n0Var, this.f11864b));
    }
}
