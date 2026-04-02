package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SingleDelayWithCompletable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g<T> extends h.a.k0<T> {
    final h.a.q0<T> a;

    /* JADX INFO: renamed from: b */
    final h.a.i f11841b;

    /* JADX INFO: compiled from: SingleDelayWithCompletable.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.f, h.a.u0.c {
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

        @Override // h.a.f
        public void onComplete() {
            this.source.a(new h.a.y0.d.a0(this, this.actual));
        }

        @Override // h.a.f
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.f
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }
    }

    public g(h.a.q0<T> q0Var, h.a.i iVar) {
        this.a = q0Var;
        this.f11841b = iVar;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super T> n0Var) {
        this.f11841b.a(new a(n0Var, this.a));
    }
}
