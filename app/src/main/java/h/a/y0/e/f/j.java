package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleDelayWithSingle.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j<T, U> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.q0<U> f11847b;

    /* JADX INFO: compiled from: SingleDelayWithSingle.java */
    static final class a<T, U> extends AtomicReference<h.a.u0.c> implements h.a.n0<U>, h.a.u0.c {
        private static final long serialVersionUID = -8565274649390031272L;
        final h.a.n0<? super T> actual;
        final h.a.q0<T> source;

        a(h.a.n0<? super T> n0Var, h.a.q0<T> q0Var) {
            this.actual = n0Var;
            this.source = q0Var;
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
            if (h.a.y0.a.d.set(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.n0
        public void onSuccess(U u) {
            this.source.a(new h.a.y0.d.a0(this, this.actual));
        }
    }

    public j(h.a.q0<T> q0Var, h.a.q0<U> q0Var2) {
        this.a = q0Var;
        this.f11847b = q0Var2;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.f11847b.a(new a(n0Var, this.a));
    }
}
